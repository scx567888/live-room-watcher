#----------- 注意 因为 Powershell 无法正确识别无 BOM 头的 UTF-8 脚本 所以脚本修改后保存时请携带 BOM 头 -------------

#-------------------------------------------- 环境变量参数 -----------------------------------------------
param($JAVA_HOME, $MAVEN_HOME)

#---------------------------------------------- 全局变量 ------------------------------------------------
# 当前脚本的版本号
$SCRIPT_VERSION = '5'
#项目名称
$PROJECT_NAME = '-'
#项目版本
$PROJECT_VERSION = '-'
#构建成品输出位置 默认为当前目录下的 built 文件夹
$OUTPUT_URL = Join-Path (Get-Location) 'built'

#设置标题
function SetTitle($title)
{
    $host.ui.RawUI.WindowTitle = "$title [v$SCRIPT_VERSION] "
}

function SetOutputUrl()
{
    while ($true)
    {
        $tempOutputUrl = Read-Host '请输入打包文件的输出目录 留空为当前目录下的 built'
        if ($tempOutputUrl -ne '')
        {
            $script:OUTPUT_URL = $tempOutputUrl
        }
        $urlCanUse = Test-Path $OUTPUT_URL
        if (-not$urlCanUse)
        {
            Write-Host "$OUTPUT_URL 不存在,已自动创建!!!" -ForegroundColor Yellow
            $null = mkdir "$OUTPUT_URL"
            break
        }
        else
        {
            $isNotEmptyFolder = Test-Path (Join-Path $OUTPUT_URL '*')
            if ($isNotEmptyFolder)
            {
                $choiceNumber = Read-Host "输出目录文件夹不为空 , 添加时间戳(1) | 强制覆盖(0) | 重新输入(AnyKey) "
                if ($choiceNumber -eq '1')
                {
                    $nowTime = Get-Date -Format 'yyyy-MM-dd HH-mm-ss'
                    $script:OUTPUT_URL = "$OUTPUT_URL $nowTime"
                    $null = mkdir "$OUTPUT_URL"
                    break
                }
                elseif ($choiceNumber -eq '0')
                {
                    $Files = Get-ChildItem $OUTPUT_URL -Force
                    foreach ($File in $Files)
                    {
                        $FilePath = $File.FullName
                        Remove-Item -Path $FilePath -Recurse -Force
                    }
                    break
                }
            }
            else
            {
                break
            }
        }
    }
    Write-Host "打包后的文件将存储在 $OUTPUT_URL" -ForegroundColor Green
}

#显示 选项
function DisplayInfo()
{
    SetTitle "$PROJECT_NAME 构建脚本"
    Write-Host "此 Build 脚本,用于 $PROJECT_NAME 项目 (脚本版本: $SCRIPT_VERSION)" -ForegroundColor Cyan
    Write-Host '建议事先请在脚本中配置一下 基本变量 !!!' -ForegroundColor Cyan
    Write-Host '如果卡住请按一下回车 !!!' -ForegroundColor Cyan
    Write-Host '  1. 运行项目' -ForegroundColor Green
    Write-Host '  2. 构建项目 (不包括依赖项)' -ForegroundColor Magenta
    Write-Host '  3. 构建项目 (包括依赖项)' -ForegroundColor Yellow
    Write-Host '  4. 仅复制依赖项' -ForegroundColor Blue
    Write-Host '  0. 退出' -ForegroundColor Red
}

#设置
function SetPageCode()
{
    $null = chcp.com(65001)
}

#设置 临时环境变量
function SetTempEnvironmentVariables()
{
    $PathVariables = ""
    if ($False -eq [String]::IsNullOrEmpty($JAVA_HOME))
    {
        $PathVariables = $PathVariables + $JAVA_HOME + '\bin;'
        $env:JAVA_HOME = $JAVA_HOME
    }
    if ($False -eq [String]::IsNullOrEmpty($MAVEN_HOME))
    {
        $PathVariables = $PathVariables + $MAVEN_HOME + ';'
    }
    $env:Path = $env:Path + $PathVariables
    $env:JAVA_TOOL_OPTIONS = '-Dfile.encoding=UTF-8 -Duser.language=zh'
}

function ToZip($from, $to)
{
    Compress-Archive -Path $from  -DestinationPath $to -Force
}

#运行项目
function RunProject()
{
    SetTitle "运行 $PROJECT_NAME 项目中..."
    Clear-Host
    mvn compile exec:java
}

function ShowSuccess()
{
    SetTitle "打包成功!!!"
    Write-Host '清理残余文件' -ForegroundColor Red
    mvn clean
    Write-Host '打包成功'  -ForegroundColor Green
    Write-Host "后台项目是$OUTPUT_URL\$PROJECT_NAME-$PROJECT_VERSION.jar" -ForegroundColor Green
    Write-Host "启动脚本是$OUTPUT_URL\startup.bat" -ForegroundColor Green
    pause
    explorer $OUTPUT_URL
}

#构建项目并复制 lib
function BuildProjectWithLib()
{
    SetTitle "构建 $PROJECT_NAME 项目 (包括依赖项) 中..."
    BuildProject
    mvn dependency:copy-dependencies
    Move-Item  ".\target\lib" "$OUTPUT_URL\lib"
    ShowSuccess
}

#复制 lib
function CopyLib()
{
    SetTitle " $PROJECT_NAME 项目 (仅复制依赖项) 中..."
    SetOutputUrl
    mvn dependency:copy-dependencies
    Move-Item  ".\target\lib" "$OUTPUT_URL\lib"
    SetTitle "复制依赖项成功!!!"
    Write-Host '清理残余文件' -ForegroundColor Red
    mvn clean
    Write-Host '复制依赖项成功'  -ForegroundColor Green
    Write-Host "依赖项所在目录$OUTPUT_URL\lib" -ForegroundColor Green
    pause
    explorer "$OUTPUT_URL\lib"
}

#构建项目但不复制 lib
function BuildProjectWithoutLib()
{
    SetTitle "构建 $PROJECT_NAME 项目 (不包括依赖项) 中..."
    BuildProject
    ShowSuccess
}

#创建 windows 上的启动脚本 ( .bat 文件)
function CreateWindowsStartupScript()
{
    # 脚本内容
    $ScriptContent =
    "@echo off
CHCP 65001
TITLE $PROJECT_NAME-$PROJECT_VERSION
SET JAVA_TOOL_OPTIONS=-Dfile.encoding=UTF-8 -Duser.language=zh
java -jar $PROJECT_NAME-$PROJECT_VERSION.jar"
    # 将内容写入文件
    $UTF8NoBomEncoding = New-Object System.Text.UTF8Encoding $False
    [System.IO.File]::WriteAllText("$OUTPUT_URL\startup.bat", $ScriptContent, $UTF8NoBomEncoding)
}

function BuildProject()
{
    SetOutputUrl
    Write-Host "开始打包 $PROJECT_NAME 版本为: $PROJECT_VERSION" -ForegroundColor Green
    mvn clean package --define "maven.test.skip=true"
    Move-Item ".\target\$PROJECT_NAME-$PROJECT_VERSION.jar" $OUTPUT_URL
    Copy-Item ".\src\main\resources\*" $OUTPUT_URL -recurse
    CreateWindowsStartupScript
}

#检查项目 并设置基本变量
function CheckProject()
{
    $xmlFile = New-Object -Typename XML
    $xmlFile.load('.\pom.xml')
    $script:PROJECT_NAME = $xmlFile.project.artifactId
    $script:PROJECT_VERSION = $xmlFile.project.version
}

#显示选项
function DisplayChoice()
{
    $choiceNumber = Read-Host '请选择要进行的操作数字 , 然后按回车'
    if ($choiceNumber -eq '1')
    {
        RunProject
    }
    elseif ($choiceNumber -eq '2')
    {
        BuildProjectWithoutLib
    }
    elseif ($choiceNumber -eq '3')
    {
        BuildProjectWithLib
    }
    elseif ($choiceNumber -eq '4')
    {
        CopyLib
    }
    elseif ($choiceNumber -eq '0')
    {
        exit
    }
    else
    {
        Write-Host  "输入的操作数字 $choiceNumber 有误 , 请重新输入 !!!" -ForegroundColor red
        DisplayChoice
    }
}

#主函数
function Main()
{
    SetPageCode
    CheckProject
    SetTempEnvironmentVariables
    DisplayInfo
    DisplayChoice
}

#执行主函数
Main

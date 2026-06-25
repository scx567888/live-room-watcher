package cool.scx.live_room_watcher.test;

import cool.scx.live_room_watcher.impl.douyin_hack.DouYinHackLiveRoomWatcher;
import dev.scx.ansi.Ansi;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static cool.scx.live_room_watcher.impl.douyin_hack.DouYinHackWebSocketOptionsProvider.ofPlaywright;

public class DouYinHackLiveRoomWatcherTest {

    public static final DateTimeFormatter DEFAULT_DATETIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        test1();
    }

    /// nowTimeStr.
    public static String nowTimeStr() {
        return DEFAULT_DATETIME_FORMATTER.format(LocalDateTime.now()) + " : ";
    }

    // @Test
    public static void test1() {
        var liveRoomWatcher = new DouYinHackLiveRoomWatcher(ofPlaywright(
            "https://live.douyin.com/510200350291?anchor_id=1093380747297773&category_name=all&is_vs=0&page_type=main_category_page&vs_ep_group_id=&vs_episode_id=&vs_episode_stage=&vs_season_id=",
            "enter_pc_once=1; UIFID_TEMP=8f584679f13361d7674396b25a46f1c75dd7736730eef2bca7f1b3cfea8b216d1aabc9d7981304aa82c61942cc3530b92ce56500b4125dcc04a060fa313b21867856bf046bc6eab5c429c059e571647f; UIFID=8f584679f13361d7674396b25a46f1c75dd7736730eef2bca7f1b3cfea8b216d9e24fdbbd62529710707aadde5449b4c511ebe4fe581d0afbce3ebece9751ecbbe6cbfe672f69ee0a83439b24ae058895239037efc942cd22046f6d2cee035abe185006923584c6a903e57ae08d63fae1efcf965686872b25b3becd77c5ee0df287ca3bc0ce662f16481f1af01efa96d7560e0acbbc181f690661e5130a9403c; bd_ticket_guard_client_web_domain=2; live_use_vvc=%22false%22; passport_csrf_token=a7529bdb7eac3af80e3ddd93314758b4; passport_csrf_token_default=a7529bdb7eac3af80e3ddd93314758b4; fpk1=U2FsdGVkX1+y04GvzU4shibthE8fMJqUn+ZY+88ayQYLpdp2kHEviCDRbSfE5arPEt+sxCwdAYETYGD5WHDK1A==; fpk2=d18e73137d21a5f9c90eef45302b8ff1; s_v_web_id=verify_mowmnbkr_wF8RZ1um_YM6T_4ZVk_9vCC_IFDRtmLT7N6U; SEARCH_UN_LOGIN_PV_CURR_DAY=%7B%22date%22%3A1778227342918%2C%22count%22%3A2%7D; passport_mfa_token=CjcORXLT3FxtfAoAAbwxinV3xmxXUOCqyPQm0DvEg6q9PhhuJWghmbu365fq87FrGD%2F2qUUpN%2FyoGkoKPAAAAAAAAAAAAABQZR5JWooDprMfv07pE0PW3VzDU2seNYdEkEw3wVc6%2B4iUXMiEEDcu7W28hZdFBf32LBDM85AOGPax0WwgAiIBA%2BLRjfI%3D; d_ticket=cfa56d84b7fca5601443a8ef5d3aebaca2bc1; passport_assist_user=CkHcSHwQzafNpO7unKgRkmttQXRSWykl0jGQFa95VXF1PqUsLROXscU7INPi3Hiso7zL26IC3tF6FXhcMNO1owPwIRpKCjwAAAAAAAAAAAAAUGXG5COtf9uF9JH6E8QJdl8X2CrTfpy3WnmGeZzqyuENTf-8dg656pynA12c3-zLoaEQ3fOQDhiJr9ZUIAEiAQPpsITP; n_mh=4UHO4-HTNEYISJEe5B4svY9Dxg-jkgVQJzexrjEBPcs; uid_tt=064759f1d0cc48945c9cb66f183aa7ed; uid_tt_ss=064759f1d0cc48945c9cb66f183aa7ed; sid_tt=e2ffc7392b3e5b23c927120605de91c3; sessionid=e2ffc7392b3e5b23c927120605de91c3; sessionid_ss=e2ffc7392b3e5b23c927120605de91c3; is_staff_user=false; has_biz_token=false; _bd_ticket_crypt_cookie=9c9a7c1bdf6adb79dc8f12ee753e67a6; __security_mc_1_s_sdk_sign_data_key_web_protect=297a4c41-49eb-8f05; __security_mc_1_s_sdk_cert_key=aeeb6a55-4fb9-9a2c; __security_mc_1_s_sdk_crypt_sdk=3544bd05-43ab-91a8; __security_server_data_status=1; login_time=1778227600898; SelfTabRedDotControl=%5B%5D; ttwid=1%7C-A3SCbdXqpSQD8A0yz5sV1gplV5lqpFqCVxjuNjrG6k%7C1781713659%7C6f4d0e6a863825fa4df363f7525efe1630a06f62417434b8b7f98c972a594f79; is_dash_user=1; publish_badge_show_info=%220%2C0%2C0%2C1782120723987%22; sid_guard=e2ffc7392b3e5b23c927120605de91c3%7C1782120726%7C5184000%7CFri%2C+21-Aug-2026+09%3A32%3A06+GMT; session_tlb_tag=sttt%7C16%7C4v_HOSs-WyPJJxIGBd6Rw__________xW-aIvQBrSrRDWhSzN57i5MLreGJ5jfQkabcx4UpJh80%3D; sid_ucp_v1=1.0.0-KGNkM2MyYmRiMzIzMWRjOTc1NDcwZGJjYjU0ODhjOTVmMmQxNWIwNjcKIQjtrbDtnIz_AhCWguTRBhjvMSAMMOC285gGOAdA9AdIBBoCbGYiIGUyZmZjNzM5MmIzZTViMjNjOTI3MTIwNjA1ZGU5MWMz; ssid_ucp_v1=1.0.0-KGNkM2MyYmRiMzIzMWRjOTc1NDcwZGJjYjU0ODhjOTVmMmQxNWIwNjcKIQjtrbDtnIz_AhCWguTRBhjvMSAMMOC285gGOAdA9AdIBBoCbGYiIGUyZmZjNzM5MmIzZTViMjNjOTI3MTIwNjA1ZGU5MWMz; playRecommendGuideTagCount=1; totalRecommendGuideTagCount=1; live_private_user=0; __live_version__=%221.1.5.3126%22; home_can_add_dy_2_desktop=%220%22; PhoneResumeUidCacheV1=%7B%221684871876187885%22%3A%7B%22time%22%3A1782194486108%2C%22noClick%22%3A1%7D%7D; download_guide=%223%2F20260623%2F0%22; volume_info=%7B%22isUserMute%22%3Atrue%2C%22isMute%22%3Atrue%2C%22volume%22%3A0.5%7D; FOLLOW_LIVE_POINT_INFO=%22MS4wLjABAAAAD6Q5XDACWW4renBmQ24Ore7FEmGrtMs2u2fEhiYR5AS3iGc4P-0td8WoBY7-_6hu%2F1782230400000%2F1782194467766%2F0%2F1782213368500%22; stream_recommend_feed_params=%22%7B%5C%22cookie_enabled%5C%22%3Atrue%2C%5C%22screen_width%5C%22%3A1228%2C%5C%22screen_height%5C%22%3A691%2C%5C%22browser_online%5C%22%3Atrue%2C%5C%22cpu_core_num%5C%22%3A12%2C%5C%22device_memory%5C%22%3A32%2C%5C%22downlink%5C%22%3A10%2C%5C%22effective_type%5C%22%3A%5C%224g%5C%22%2C%5C%22round_trip_time%5C%22%3A50%7D%22; LivePausePop=%22%257B%2522todayCount%2522%253A2%252C%2522closeNum%2522%253A0%252C%2522todayShowRoom%2522%253A%25227654870125157419811%252C7654871661052758825%2522%252C%2522lastTimer%2522%253A1782293256775%257D%22; webcast_local_quality=null; is_support_rtm_web_ts=1; csrf_session_id=8f6fd07c57132cc1c4fa930427e93b2b; has_avx2=null; device_web_cpu_core=12; device_web_memory_size=32; biz_trace_id=a912c342; live_debug_info=%7B%22roomId%22%3A%227655154784109988642%22%2C%22resolution%22%3A%7B%22width%22%3A960%2C%22height%22%3A540%7D%2C%22fps%22%3A75%2C%22audioDataRate%22%3A48000%2C%22droppedFrames%22%3A1%2C%22totalFrames%22%3A17%2C%22videoBuffer%22%3A%5B%5D%2C%22src%22%3A%22https%3A%2F%2Fpull-x3-f5.douyinliving.com%2Fthirdgame%2Fstream-696072546301510465_ld.flv%3Fexpire%3D1782971749%26sign%3D13b2edf76df4ecf300d551915a67fd43%26volcSecret%3D13b2edf76df4ecf300d551915a67fd43%26volcTime%3D1782971749%26arch_hrchy%3Ds2%26exp_hrchy%3Ds1%26s_anchor%3D1%26major_anchor_level%3Dvip%26unique_id%3Dstream-696072546301510465_833_flv_ld%26t_id%3D037-20260625135548EDBA40A57779DDF01E86-eNctcf%26biz_quality%3Dld%26biz_protocol%3Dflv%22%2C%22linkmicInfo%22%3A%7B%22uiLayout%22%3A0%2C%22playModes%22%3A%5B%5D%2C%22allDevices%22%3A%22%E8%BF%9E%E7%BA%BF%E8%AE%BE%E5%A4%87%EF%BC%9A%E7%94%B3%E8%AF%B7%E8%BF%9E%E7%BA%BF%E5%90%8E%E6%89%8D%E8%8E%B7%E5%8F%96%22%2C%22audioInputs%22%3A%5B%5D%2C%22videoInputs%22%3A%5B%5D%7D%2C%22href%22%3A%22https%3A%2F%2Flive.douyin.com%2F39644365772%3Fanchor_id%3D3017536920106472%26category_name%3Dall%26is_vs%3D0%26page_type%3Dmain_category_page%26vs_ep_group_id%3D%26vs_episode_id%3D%26vs_episode_stage%3D%26vs_season_id%3D%22%7D; bd_ticket_guard_client_data=eyJiZC10aWNrZXQtZ3VhcmQtdmVyc2lvbiI6MiwiYmQtdGlja2V0LWd1YXJkLWl0ZXJhdGlvbi12ZXJzaW9uIjoxLCJiZC10aWNrZXQtZ3VhcmQtcmVlLXB1YmxpYy1rZXkiOiJCUEFZVnVFcmp5RUU5aHJVemE3N01VdytBSDhiQVREZDFiNlZwVFlzVFJXQ3FGQlJ5bHN0QUVsNnNzaDUzR1FNRGttK2VNdnB5MERtRHowOVJmeFBaalE9IiwiYmQtdGlja2V0LWd1YXJkLXdlYi12ZXJzaW9uIjoyfQ%3D%3D; bd_ticket_guard_client_data_v2=eyJyZWVfcHVibGljX2tleSI6IkJQQVlWdUVyanlFRTloclV6YTc3TVV3K0FIOGJBVERkMWI2VnBUWXNUUldDcUZCUnlsc3RBRWw2c3NoNTNHUU1Ea20rZU12cHkwRG1EejA5UmZ4UFpqUT0iLCJ0c19zaWduIjoidHMuMi5kZWNjMDg4OGMxNjNiOTUwNDdiZmVhNDNiMGUxZTNhNTgzMzFiMGE2MGUwOTA0NGZhY2Y1M2RjZTkyMDliNzQzYzRmYmU4N2QyMzE5Y2YwNTMxODYyNGNlZGExNDkxMWNhNDA2ZGVkYmViZWRkYjJlMzBmY2U4ZDRmYTAyNTc1ZCIsInJlcV9jb250ZW50Ijoic2VjX3RzIiwicmVxX3NpZ24iOiJJV2tGbS9Ob3ZPT3Fab1pZaEFGc2prWS9GYmVtQ3drOUM5Y0N6RXNkM3NrPSIsInNlY190cyI6IiNVRmxFSzY5M2kyYk8wbUdQejRQb05tWjluUVdkVDlLK2Y1Vk1hNDNoZFdMQUZoWk4vdG5na1lSVVkxWGoifQ%3D%3D; live_can_add_dy_2_desktop=%221%22; IsDouyinActive=true; odin_tt=3f88cd3eb21567bc53297ba2d976732723986757bfd1d0627baa5829017813c8bef2449c5471f88623db05adcf9934ee8e77a9137d9f3733324ea9af73655f65"
        ));

        liveRoomWatcher.onChat(chat -> {
            Ansi.ansi().brightGreen(nowTimeStr() + "[消息] ").defaultColor(chat.user().nickname() + " : ").brightWhite(chat.content()).println();
        }).onUser(user -> {
            Ansi.ansi().brightMagenta(nowTimeStr() + "[来了] ").defaultColor(user.nickname()).println();
        }).onLike(like -> {
            Ansi.ansi().brightYellow(nowTimeStr() + "[点赞] ").defaultColor(like.user().nickname() + " x " + like.count()).println();
        }).onFollow(follow -> {
            Ansi.ansi().brightCyan(nowTimeStr() + "[关注] ").defaultColor(follow.user().nickname()).println();
        }).onGift(gift -> {
            Ansi.ansi().brightBlue(nowTimeStr() + "[礼物] ").defaultColor(gift.user().nickname() + " : ").brightWhite(gift.name() + " x " + gift.count()).println();
        });

        liveRoomWatcher.startWatch();

    }

}

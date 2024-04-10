// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: douyin_hack/webcast/data/TextFormat.proto

// Protobuf Java Version: 4.26.1
package cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data;

/**
 * <pre>
 * 根据抖音前台 js 编写
 * 更新时间 : 2023-01-05 17:14:42
 * </pre>
 *
 * Protobuf type {@code TextFormat}
 */
public final class TextFormat extends
    com.google.protobuf.GeneratedMessage implements
    // @@protoc_insertion_point(message_implements:TextFormat)
    TextFormatOrBuilder {
private static final long serialVersionUID = 0L;
  static {
    com.google.protobuf.RuntimeVersion.validateProtobufGencodeVersion(
      com.google.protobuf.RuntimeVersion.RuntimeDomain.PUBLIC,
      /* major= */ 4,
      /* minor= */ 26,
      /* patch= */ 1,
      /* suffix= */ "",
      TextFormat.class.getName());
  }
  // Use TextFormat.newBuilder() to construct.
  private TextFormat(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
    super(builder);
  }
  private TextFormat() {
    color_ = "";
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.TextFormatOuterClass.internal_static_TextFormat_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.TextFormatOuterClass.internal_static_TextFormat_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.TextFormat.class, cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.TextFormat.Builder.class);
  }

  public static final int COLOR_FIELD_NUMBER = 1;
  @SuppressWarnings("serial")
  private volatile java.lang.Object color_ = "";
  /**
   * <code>string color = 1;</code>
   * @return The color.
   */
  @java.lang.Override
  public java.lang.String getColor() {
    java.lang.Object ref = color_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      color_ = s;
      return s;
    }
  }
  /**
   * <code>string color = 1;</code>
   * @return The bytes for color.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getColorBytes() {
    java.lang.Object ref = color_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      color_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int BOLD_FIELD_NUMBER = 2;
  private boolean bold_ = false;
  /**
   * <code>bool bold = 2;</code>
   * @return The bold.
   */
  @java.lang.Override
  public boolean getBold() {
    return bold_;
  }

  public static final int ITALIC_FIELD_NUMBER = 3;
  private boolean italic_ = false;
  /**
   * <code>bool italic = 3;</code>
   * @return The italic.
   */
  @java.lang.Override
  public boolean getItalic() {
    return italic_;
  }

  public static final int WEIGHT_FIELD_NUMBER = 4;
  private int weight_ = 0;
  /**
   * <code>int32 weight = 4;</code>
   * @return The weight.
   */
  @java.lang.Override
  public int getWeight() {
    return weight_;
  }

  public static final int ITALICANGLE_FIELD_NUMBER = 5;
  private int italicAngle_ = 0;
  /**
   * <code>int32 italicAngle = 5;</code>
   * @return The italicAngle.
   */
  @java.lang.Override
  public int getItalicAngle() {
    return italicAngle_;
  }

  public static final int FONTSIZE_FIELD_NUMBER = 6;
  private int fontSize_ = 0;
  /**
   * <code>int32 fontSize = 6;</code>
   * @return The fontSize.
   */
  @java.lang.Override
  public int getFontSize() {
    return fontSize_;
  }

  public static final int USEHEIGHLIGHTCOLOR_FIELD_NUMBER = 7;
  private boolean useHeighLightColor_ = false;
  /**
   * <code>bool useHeighLightColor = 7;</code>
   * @return The useHeighLightColor.
   */
  @java.lang.Override
  public boolean getUseHeighLightColor() {
    return useHeighLightColor_;
  }

  public static final int USEREMOTECLOR_FIELD_NUMBER = 8;
  private boolean useRemoteClor_ = false;
  /**
   * <code>bool useRemoteClor = 8;</code>
   * @return The useRemoteClor.
   */
  @java.lang.Override
  public boolean getUseRemoteClor() {
    return useRemoteClor_;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!com.google.protobuf.GeneratedMessage.isStringEmpty(color_)) {
      com.google.protobuf.GeneratedMessage.writeString(output, 1, color_);
    }
    if (bold_ != false) {
      output.writeBool(2, bold_);
    }
    if (italic_ != false) {
      output.writeBool(3, italic_);
    }
    if (weight_ != 0) {
      output.writeInt32(4, weight_);
    }
    if (italicAngle_ != 0) {
      output.writeInt32(5, italicAngle_);
    }
    if (fontSize_ != 0) {
      output.writeInt32(6, fontSize_);
    }
    if (useHeighLightColor_ != false) {
      output.writeBool(7, useHeighLightColor_);
    }
    if (useRemoteClor_ != false) {
      output.writeBool(8, useRemoteClor_);
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!com.google.protobuf.GeneratedMessage.isStringEmpty(color_)) {
      size += com.google.protobuf.GeneratedMessage.computeStringSize(1, color_);
    }
    if (bold_ != false) {
      size += com.google.protobuf.CodedOutputStream
        .computeBoolSize(2, bold_);
    }
    if (italic_ != false) {
      size += com.google.protobuf.CodedOutputStream
        .computeBoolSize(3, italic_);
    }
    if (weight_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(4, weight_);
    }
    if (italicAngle_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(5, italicAngle_);
    }
    if (fontSize_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(6, fontSize_);
    }
    if (useHeighLightColor_ != false) {
      size += com.google.protobuf.CodedOutputStream
        .computeBoolSize(7, useHeighLightColor_);
    }
    if (useRemoteClor_ != false) {
      size += com.google.protobuf.CodedOutputStream
        .computeBoolSize(8, useRemoteClor_);
    }
    size += getUnknownFields().getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.TextFormat)) {
      return super.equals(obj);
    }
    cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.TextFormat other = (cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.TextFormat) obj;

    if (!getColor()
        .equals(other.getColor())) return false;
    if (getBold()
        != other.getBold()) return false;
    if (getItalic()
        != other.getItalic()) return false;
    if (getWeight()
        != other.getWeight()) return false;
    if (getItalicAngle()
        != other.getItalicAngle()) return false;
    if (getFontSize()
        != other.getFontSize()) return false;
    if (getUseHeighLightColor()
        != other.getUseHeighLightColor()) return false;
    if (getUseRemoteClor()
        != other.getUseRemoteClor()) return false;
    if (!getUnknownFields().equals(other.getUnknownFields())) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + COLOR_FIELD_NUMBER;
    hash = (53 * hash) + getColor().hashCode();
    hash = (37 * hash) + BOLD_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
        getBold());
    hash = (37 * hash) + ITALIC_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
        getItalic());
    hash = (37 * hash) + WEIGHT_FIELD_NUMBER;
    hash = (53 * hash) + getWeight();
    hash = (37 * hash) + ITALICANGLE_FIELD_NUMBER;
    hash = (53 * hash) + getItalicAngle();
    hash = (37 * hash) + FONTSIZE_FIELD_NUMBER;
    hash = (53 * hash) + getFontSize();
    hash = (37 * hash) + USEHEIGHLIGHTCOLOR_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
        getUseHeighLightColor());
    hash = (37 * hash) + USEREMOTECLOR_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
        getUseRemoteClor());
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.TextFormat parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.TextFormat parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.TextFormat parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.TextFormat parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.TextFormat parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.TextFormat parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.TextFormat parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input);
  }
  public static cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.TextFormat parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.TextFormat parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseDelimitedWithIOException(PARSER, input);
  }

  public static cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.TextFormat parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.TextFormat parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input);
  }
  public static cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.TextFormat parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.TextFormat prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessage.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * <pre>
   * 根据抖音前台 js 编写
   * 更新时间 : 2023-01-05 17:14:42
   * </pre>
   *
   * Protobuf type {@code TextFormat}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessage.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:TextFormat)
      cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.TextFormatOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.TextFormatOuterClass.internal_static_TextFormat_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.TextFormatOuterClass.internal_static_TextFormat_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.TextFormat.class, cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.TextFormat.Builder.class);
    }

    // Construct using cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.TextFormat.newBuilder()
    private Builder() {

    }

    private Builder(
        com.google.protobuf.GeneratedMessage.BuilderParent parent) {
      super(parent);

    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      bitField0_ = 0;
      color_ = "";
      bold_ = false;
      italic_ = false;
      weight_ = 0;
      italicAngle_ = 0;
      fontSize_ = 0;
      useHeighLightColor_ = false;
      useRemoteClor_ = false;
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.TextFormatOuterClass.internal_static_TextFormat_descriptor;
    }

    @java.lang.Override
    public cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.TextFormat getDefaultInstanceForType() {
      return cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.TextFormat.getDefaultInstance();
    }

    @java.lang.Override
    public cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.TextFormat build() {
      cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.TextFormat result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.TextFormat buildPartial() {
      cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.TextFormat result = new cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.TextFormat(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.TextFormat result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.color_ = color_;
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.bold_ = bold_;
      }
      if (((from_bitField0_ & 0x00000004) != 0)) {
        result.italic_ = italic_;
      }
      if (((from_bitField0_ & 0x00000008) != 0)) {
        result.weight_ = weight_;
      }
      if (((from_bitField0_ & 0x00000010) != 0)) {
        result.italicAngle_ = italicAngle_;
      }
      if (((from_bitField0_ & 0x00000020) != 0)) {
        result.fontSize_ = fontSize_;
      }
      if (((from_bitField0_ & 0x00000040) != 0)) {
        result.useHeighLightColor_ = useHeighLightColor_;
      }
      if (((from_bitField0_ & 0x00000080) != 0)) {
        result.useRemoteClor_ = useRemoteClor_;
      }
    }

    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.TextFormat) {
        return mergeFrom((cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.TextFormat)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.TextFormat other) {
      if (other == cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.TextFormat.getDefaultInstance()) return this;
      if (!other.getColor().isEmpty()) {
        color_ = other.color_;
        bitField0_ |= 0x00000001;
        onChanged();
      }
      if (other.getBold() != false) {
        setBold(other.getBold());
      }
      if (other.getItalic() != false) {
        setItalic(other.getItalic());
      }
      if (other.getWeight() != 0) {
        setWeight(other.getWeight());
      }
      if (other.getItalicAngle() != 0) {
        setItalicAngle(other.getItalicAngle());
      }
      if (other.getFontSize() != 0) {
        setFontSize(other.getFontSize());
      }
      if (other.getUseHeighLightColor() != false) {
        setUseHeighLightColor(other.getUseHeighLightColor());
      }
      if (other.getUseRemoteClor() != false) {
        setUseRemoteClor(other.getUseRemoteClor());
      }
      this.mergeUnknownFields(other.getUnknownFields());
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 10: {
              color_ = input.readStringRequireUtf8();
              bitField0_ |= 0x00000001;
              break;
            } // case 10
            case 16: {
              bold_ = input.readBool();
              bitField0_ |= 0x00000002;
              break;
            } // case 16
            case 24: {
              italic_ = input.readBool();
              bitField0_ |= 0x00000004;
              break;
            } // case 24
            case 32: {
              weight_ = input.readInt32();
              bitField0_ |= 0x00000008;
              break;
            } // case 32
            case 40: {
              italicAngle_ = input.readInt32();
              bitField0_ |= 0x00000010;
              break;
            } // case 40
            case 48: {
              fontSize_ = input.readInt32();
              bitField0_ |= 0x00000020;
              break;
            } // case 48
            case 56: {
              useHeighLightColor_ = input.readBool();
              bitField0_ |= 0x00000040;
              break;
            } // case 56
            case 64: {
              useRemoteClor_ = input.readBool();
              bitField0_ |= 0x00000080;
              break;
            } // case 64
            default: {
              if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                done = true; // was an endgroup tag
              }
              break;
            } // default:
          } // switch (tag)
        } // while (!done)
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.unwrapIOException();
      } finally {
        onChanged();
      } // finally
      return this;
    }
    private int bitField0_;

    private java.lang.Object color_ = "";
    /**
     * <code>string color = 1;</code>
     * @return The color.
     */
    public java.lang.String getColor() {
      java.lang.Object ref = color_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        color_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string color = 1;</code>
     * @return The bytes for color.
     */
    public com.google.protobuf.ByteString
        getColorBytes() {
      java.lang.Object ref = color_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        color_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string color = 1;</code>
     * @param value The color to set.
     * @return This builder for chaining.
     */
    public Builder setColor(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      color_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>string color = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearColor() {
      color_ = getDefaultInstance().getColor();
      bitField0_ = (bitField0_ & ~0x00000001);
      onChanged();
      return this;
    }
    /**
     * <code>string color = 1;</code>
     * @param value The bytes for color to set.
     * @return This builder for chaining.
     */
    public Builder setColorBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      color_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }

    private boolean bold_ ;
    /**
     * <code>bool bold = 2;</code>
     * @return The bold.
     */
    @java.lang.Override
    public boolean getBold() {
      return bold_;
    }
    /**
     * <code>bool bold = 2;</code>
     * @param value The bold to set.
     * @return This builder for chaining.
     */
    public Builder setBold(boolean value) {

      bold_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>bool bold = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearBold() {
      bitField0_ = (bitField0_ & ~0x00000002);
      bold_ = false;
      onChanged();
      return this;
    }

    private boolean italic_ ;
    /**
     * <code>bool italic = 3;</code>
     * @return The italic.
     */
    @java.lang.Override
    public boolean getItalic() {
      return italic_;
    }
    /**
     * <code>bool italic = 3;</code>
     * @param value The italic to set.
     * @return This builder for chaining.
     */
    public Builder setItalic(boolean value) {

      italic_ = value;
      bitField0_ |= 0x00000004;
      onChanged();
      return this;
    }
    /**
     * <code>bool italic = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearItalic() {
      bitField0_ = (bitField0_ & ~0x00000004);
      italic_ = false;
      onChanged();
      return this;
    }

    private int weight_ ;
    /**
     * <code>int32 weight = 4;</code>
     * @return The weight.
     */
    @java.lang.Override
    public int getWeight() {
      return weight_;
    }
    /**
     * <code>int32 weight = 4;</code>
     * @param value The weight to set.
     * @return This builder for chaining.
     */
    public Builder setWeight(int value) {

      weight_ = value;
      bitField0_ |= 0x00000008;
      onChanged();
      return this;
    }
    /**
     * <code>int32 weight = 4;</code>
     * @return This builder for chaining.
     */
    public Builder clearWeight() {
      bitField0_ = (bitField0_ & ~0x00000008);
      weight_ = 0;
      onChanged();
      return this;
    }

    private int italicAngle_ ;
    /**
     * <code>int32 italicAngle = 5;</code>
     * @return The italicAngle.
     */
    @java.lang.Override
    public int getItalicAngle() {
      return italicAngle_;
    }
    /**
     * <code>int32 italicAngle = 5;</code>
     * @param value The italicAngle to set.
     * @return This builder for chaining.
     */
    public Builder setItalicAngle(int value) {

      italicAngle_ = value;
      bitField0_ |= 0x00000010;
      onChanged();
      return this;
    }
    /**
     * <code>int32 italicAngle = 5;</code>
     * @return This builder for chaining.
     */
    public Builder clearItalicAngle() {
      bitField0_ = (bitField0_ & ~0x00000010);
      italicAngle_ = 0;
      onChanged();
      return this;
    }

    private int fontSize_ ;
    /**
     * <code>int32 fontSize = 6;</code>
     * @return The fontSize.
     */
    @java.lang.Override
    public int getFontSize() {
      return fontSize_;
    }
    /**
     * <code>int32 fontSize = 6;</code>
     * @param value The fontSize to set.
     * @return This builder for chaining.
     */
    public Builder setFontSize(int value) {

      fontSize_ = value;
      bitField0_ |= 0x00000020;
      onChanged();
      return this;
    }
    /**
     * <code>int32 fontSize = 6;</code>
     * @return This builder for chaining.
     */
    public Builder clearFontSize() {
      bitField0_ = (bitField0_ & ~0x00000020);
      fontSize_ = 0;
      onChanged();
      return this;
    }

    private boolean useHeighLightColor_ ;
    /**
     * <code>bool useHeighLightColor = 7;</code>
     * @return The useHeighLightColor.
     */
    @java.lang.Override
    public boolean getUseHeighLightColor() {
      return useHeighLightColor_;
    }
    /**
     * <code>bool useHeighLightColor = 7;</code>
     * @param value The useHeighLightColor to set.
     * @return This builder for chaining.
     */
    public Builder setUseHeighLightColor(boolean value) {

      useHeighLightColor_ = value;
      bitField0_ |= 0x00000040;
      onChanged();
      return this;
    }
    /**
     * <code>bool useHeighLightColor = 7;</code>
     * @return This builder for chaining.
     */
    public Builder clearUseHeighLightColor() {
      bitField0_ = (bitField0_ & ~0x00000040);
      useHeighLightColor_ = false;
      onChanged();
      return this;
    }

    private boolean useRemoteClor_ ;
    /**
     * <code>bool useRemoteClor = 8;</code>
     * @return The useRemoteClor.
     */
    @java.lang.Override
    public boolean getUseRemoteClor() {
      return useRemoteClor_;
    }
    /**
     * <code>bool useRemoteClor = 8;</code>
     * @param value The useRemoteClor to set.
     * @return This builder for chaining.
     */
    public Builder setUseRemoteClor(boolean value) {

      useRemoteClor_ = value;
      bitField0_ |= 0x00000080;
      onChanged();
      return this;
    }
    /**
     * <code>bool useRemoteClor = 8;</code>
     * @return This builder for chaining.
     */
    public Builder clearUseRemoteClor() {
      bitField0_ = (bitField0_ & ~0x00000080);
      useRemoteClor_ = false;
      onChanged();
      return this;
    }

    // @@protoc_insertion_point(builder_scope:TextFormat)
  }

  // @@protoc_insertion_point(class_scope:TextFormat)
  private static final cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.TextFormat DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.TextFormat();
  }

  public static cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.TextFormat getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<TextFormat>
      PARSER = new com.google.protobuf.AbstractParser<TextFormat>() {
    @java.lang.Override
    public TextFormat parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      Builder builder = newBuilder();
      try {
        builder.mergeFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(builder.buildPartial());
      } catch (com.google.protobuf.UninitializedMessageException e) {
        throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(e)
            .setUnfinishedMessage(builder.buildPartial());
      }
      return builder.buildPartial();
    }
  };

  public static com.google.protobuf.Parser<TextFormat> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<TextFormat> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.TextFormat getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}


// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: webcast/im/UpdateFanTicketMessage.proto

package cool.scx.live_room_watcher.douyin.proto_entity.webcast.im;

/**
 * <pre>
 *更新时间 : 2023-01-11
 * </pre>
 *
 * Protobuf type {@code UpdateFanTicketMessage}
 */
public final class UpdateFanTicketMessage extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:UpdateFanTicketMessage)
    UpdateFanTicketMessageOrBuilder {
private static final long serialVersionUID = 0L;
  // Use UpdateFanTicketMessage.newBuilder() to construct.
  private UpdateFanTicketMessage(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private UpdateFanTicketMessage() {
    roomFanTicketCountText_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new UpdateFanTicketMessage();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private UpdateFanTicketMessage(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.Common.Builder subBuilder = null;
            if (common_ != null) {
              subBuilder = common_.toBuilder();
            }
            common_ = input.readMessage(cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.Common.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(common_);
              common_ = subBuilder.buildPartial();
            }

            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            roomFanTicketCountText_ = s;
            break;
          }
          case 24: {

            roomFanTicketCount_ = input.readInt64();
            break;
          }
          case 32: {

            forceUpdate_ = input.readBool();
            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.UpdateFanTicketMessageOuterClass.internal_static_UpdateFanTicketMessage_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.UpdateFanTicketMessageOuterClass.internal_static_UpdateFanTicketMessage_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.UpdateFanTicketMessage.class, cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.UpdateFanTicketMessage.Builder.class);
  }

  public static final int COMMON_FIELD_NUMBER = 1;
  private cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.Common common_;
  /**
   * <code>.Common common = 1;</code>
   * @return Whether the common field is set.
   */
  @java.lang.Override
  public boolean hasCommon() {
    return common_ != null;
  }
  /**
   * <code>.Common common = 1;</code>
   * @return The common.
   */
  @java.lang.Override
  public cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.Common getCommon() {
    return common_ == null ? cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.Common.getDefaultInstance() : common_;
  }
  /**
   * <code>.Common common = 1;</code>
   */
  @java.lang.Override
  public cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.CommonOrBuilder getCommonOrBuilder() {
    return getCommon();
  }

  public static final int ROOMFANTICKETCOUNTTEXT_FIELD_NUMBER = 2;
  private volatile java.lang.Object roomFanTicketCountText_;
  /**
   * <code>string roomFanTicketCountText = 2;</code>
   * @return The roomFanTicketCountText.
   */
  @java.lang.Override
  public java.lang.String getRoomFanTicketCountText() {
    java.lang.Object ref = roomFanTicketCountText_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      roomFanTicketCountText_ = s;
      return s;
    }
  }
  /**
   * <code>string roomFanTicketCountText = 2;</code>
   * @return The bytes for roomFanTicketCountText.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getRoomFanTicketCountTextBytes() {
    java.lang.Object ref = roomFanTicketCountText_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      roomFanTicketCountText_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int ROOMFANTICKETCOUNT_FIELD_NUMBER = 3;
  private long roomFanTicketCount_;
  /**
   * <code>int64 roomFanTicketCount = 3;</code>
   * @return The roomFanTicketCount.
   */
  @java.lang.Override
  public long getRoomFanTicketCount() {
    return roomFanTicketCount_;
  }

  public static final int FORCEUPDATE_FIELD_NUMBER = 4;
  private boolean forceUpdate_;
  /**
   * <code>bool forceUpdate = 4;</code>
   * @return The forceUpdate.
   */
  @java.lang.Override
  public boolean getForceUpdate() {
    return forceUpdate_;
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
    if (common_ != null) {
      output.writeMessage(1, getCommon());
    }
    if (!getRoomFanTicketCountTextBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, roomFanTicketCountText_);
    }
    if (roomFanTicketCount_ != 0L) {
      output.writeInt64(3, roomFanTicketCount_);
    }
    if (forceUpdate_ != false) {
      output.writeBool(4, forceUpdate_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (common_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getCommon());
    }
    if (!getRoomFanTicketCountTextBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, roomFanTicketCountText_);
    }
    if (roomFanTicketCount_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(3, roomFanTicketCount_);
    }
    if (forceUpdate_ != false) {
      size += com.google.protobuf.CodedOutputStream
        .computeBoolSize(4, forceUpdate_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.UpdateFanTicketMessage)) {
      return super.equals(obj);
    }
    cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.UpdateFanTicketMessage other = (cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.UpdateFanTicketMessage) obj;

    if (hasCommon() != other.hasCommon()) return false;
    if (hasCommon()) {
      if (!getCommon()
          .equals(other.getCommon())) return false;
    }
    if (!getRoomFanTicketCountText()
        .equals(other.getRoomFanTicketCountText())) return false;
    if (getRoomFanTicketCount()
        != other.getRoomFanTicketCount()) return false;
    if (getForceUpdate()
        != other.getForceUpdate()) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (hasCommon()) {
      hash = (37 * hash) + COMMON_FIELD_NUMBER;
      hash = (53 * hash) + getCommon().hashCode();
    }
    hash = (37 * hash) + ROOMFANTICKETCOUNTTEXT_FIELD_NUMBER;
    hash = (53 * hash) + getRoomFanTicketCountText().hashCode();
    hash = (37 * hash) + ROOMFANTICKETCOUNT_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getRoomFanTicketCount());
    hash = (37 * hash) + FORCEUPDATE_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
        getForceUpdate());
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.UpdateFanTicketMessage parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.UpdateFanTicketMessage parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.UpdateFanTicketMessage parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.UpdateFanTicketMessage parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.UpdateFanTicketMessage parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.UpdateFanTicketMessage parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.UpdateFanTicketMessage parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.UpdateFanTicketMessage parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.UpdateFanTicketMessage parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.UpdateFanTicketMessage parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.UpdateFanTicketMessage parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.UpdateFanTicketMessage parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.UpdateFanTicketMessage prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * <pre>
   *更新时间 : 2023-01-11
   * </pre>
   *
   * Protobuf type {@code UpdateFanTicketMessage}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:UpdateFanTicketMessage)
      cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.UpdateFanTicketMessageOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.UpdateFanTicketMessageOuterClass.internal_static_UpdateFanTicketMessage_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.UpdateFanTicketMessageOuterClass.internal_static_UpdateFanTicketMessage_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.UpdateFanTicketMessage.class, cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.UpdateFanTicketMessage.Builder.class);
    }

    // Construct using cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.UpdateFanTicketMessage.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      if (commonBuilder_ == null) {
        common_ = null;
      } else {
        common_ = null;
        commonBuilder_ = null;
      }
      roomFanTicketCountText_ = "";

      roomFanTicketCount_ = 0L;

      forceUpdate_ = false;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.UpdateFanTicketMessageOuterClass.internal_static_UpdateFanTicketMessage_descriptor;
    }

    @java.lang.Override
    public cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.UpdateFanTicketMessage getDefaultInstanceForType() {
      return cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.UpdateFanTicketMessage.getDefaultInstance();
    }

    @java.lang.Override
    public cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.UpdateFanTicketMessage build() {
      cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.UpdateFanTicketMessage result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.UpdateFanTicketMessage buildPartial() {
      cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.UpdateFanTicketMessage result = new cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.UpdateFanTicketMessage(this);
      if (commonBuilder_ == null) {
        result.common_ = common_;
      } else {
        result.common_ = commonBuilder_.build();
      }
      result.roomFanTicketCountText_ = roomFanTicketCountText_;
      result.roomFanTicketCount_ = roomFanTicketCount_;
      result.forceUpdate_ = forceUpdate_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.UpdateFanTicketMessage) {
        return mergeFrom((cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.UpdateFanTicketMessage)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.UpdateFanTicketMessage other) {
      if (other == cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.UpdateFanTicketMessage.getDefaultInstance()) return this;
      if (other.hasCommon()) {
        mergeCommon(other.getCommon());
      }
      if (!other.getRoomFanTicketCountText().isEmpty()) {
        roomFanTicketCountText_ = other.roomFanTicketCountText_;
        onChanged();
      }
      if (other.getRoomFanTicketCount() != 0L) {
        setRoomFanTicketCount(other.getRoomFanTicketCount());
      }
      if (other.getForceUpdate() != false) {
        setForceUpdate(other.getForceUpdate());
      }
      this.mergeUnknownFields(other.unknownFields);
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
      cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.UpdateFanTicketMessage parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.UpdateFanTicketMessage) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.Common common_;
    private com.google.protobuf.SingleFieldBuilderV3<
        cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.Common, cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.Common.Builder, cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.CommonOrBuilder> commonBuilder_;
    /**
     * <code>.Common common = 1;</code>
     * @return Whether the common field is set.
     */
    public boolean hasCommon() {
      return commonBuilder_ != null || common_ != null;
    }
    /**
     * <code>.Common common = 1;</code>
     * @return The common.
     */
    public cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.Common getCommon() {
      if (commonBuilder_ == null) {
        return common_ == null ? cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.Common.getDefaultInstance() : common_;
      } else {
        return commonBuilder_.getMessage();
      }
    }
    /**
     * <code>.Common common = 1;</code>
     */
    public Builder setCommon(cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.Common value) {
      if (commonBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        common_ = value;
        onChanged();
      } else {
        commonBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.Common common = 1;</code>
     */
    public Builder setCommon(
        cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.Common.Builder builderForValue) {
      if (commonBuilder_ == null) {
        common_ = builderForValue.build();
        onChanged();
      } else {
        commonBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.Common common = 1;</code>
     */
    public Builder mergeCommon(cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.Common value) {
      if (commonBuilder_ == null) {
        if (common_ != null) {
          common_ =
            cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.Common.newBuilder(common_).mergeFrom(value).buildPartial();
        } else {
          common_ = value;
        }
        onChanged();
      } else {
        commonBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.Common common = 1;</code>
     */
    public Builder clearCommon() {
      if (commonBuilder_ == null) {
        common_ = null;
        onChanged();
      } else {
        common_ = null;
        commonBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.Common common = 1;</code>
     */
    public cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.Common.Builder getCommonBuilder() {
      
      onChanged();
      return getCommonFieldBuilder().getBuilder();
    }
    /**
     * <code>.Common common = 1;</code>
     */
    public cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.CommonOrBuilder getCommonOrBuilder() {
      if (commonBuilder_ != null) {
        return commonBuilder_.getMessageOrBuilder();
      } else {
        return common_ == null ?
            cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.Common.getDefaultInstance() : common_;
      }
    }
    /**
     * <code>.Common common = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.Common, cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.Common.Builder, cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.CommonOrBuilder> 
        getCommonFieldBuilder() {
      if (commonBuilder_ == null) {
        commonBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.Common, cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.Common.Builder, cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.CommonOrBuilder>(
                getCommon(),
                getParentForChildren(),
                isClean());
        common_ = null;
      }
      return commonBuilder_;
    }

    private java.lang.Object roomFanTicketCountText_ = "";
    /**
     * <code>string roomFanTicketCountText = 2;</code>
     * @return The roomFanTicketCountText.
     */
    public java.lang.String getRoomFanTicketCountText() {
      java.lang.Object ref = roomFanTicketCountText_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        roomFanTicketCountText_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string roomFanTicketCountText = 2;</code>
     * @return The bytes for roomFanTicketCountText.
     */
    public com.google.protobuf.ByteString
        getRoomFanTicketCountTextBytes() {
      java.lang.Object ref = roomFanTicketCountText_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        roomFanTicketCountText_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string roomFanTicketCountText = 2;</code>
     * @param value The roomFanTicketCountText to set.
     * @return This builder for chaining.
     */
    public Builder setRoomFanTicketCountText(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      roomFanTicketCountText_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string roomFanTicketCountText = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearRoomFanTicketCountText() {
      
      roomFanTicketCountText_ = getDefaultInstance().getRoomFanTicketCountText();
      onChanged();
      return this;
    }
    /**
     * <code>string roomFanTicketCountText = 2;</code>
     * @param value The bytes for roomFanTicketCountText to set.
     * @return This builder for chaining.
     */
    public Builder setRoomFanTicketCountTextBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      roomFanTicketCountText_ = value;
      onChanged();
      return this;
    }

    private long roomFanTicketCount_ ;
    /**
     * <code>int64 roomFanTicketCount = 3;</code>
     * @return The roomFanTicketCount.
     */
    @java.lang.Override
    public long getRoomFanTicketCount() {
      return roomFanTicketCount_;
    }
    /**
     * <code>int64 roomFanTicketCount = 3;</code>
     * @param value The roomFanTicketCount to set.
     * @return This builder for chaining.
     */
    public Builder setRoomFanTicketCount(long value) {
      
      roomFanTicketCount_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 roomFanTicketCount = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearRoomFanTicketCount() {
      
      roomFanTicketCount_ = 0L;
      onChanged();
      return this;
    }

    private boolean forceUpdate_ ;
    /**
     * <code>bool forceUpdate = 4;</code>
     * @return The forceUpdate.
     */
    @java.lang.Override
    public boolean getForceUpdate() {
      return forceUpdate_;
    }
    /**
     * <code>bool forceUpdate = 4;</code>
     * @param value The forceUpdate to set.
     * @return This builder for chaining.
     */
    public Builder setForceUpdate(boolean value) {
      
      forceUpdate_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>bool forceUpdate = 4;</code>
     * @return This builder for chaining.
     */
    public Builder clearForceUpdate() {
      
      forceUpdate_ = false;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:UpdateFanTicketMessage)
  }

  // @@protoc_insertion_point(class_scope:UpdateFanTicketMessage)
  private static final cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.UpdateFanTicketMessage DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.UpdateFanTicketMessage();
  }

  public static cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.UpdateFanTicketMessage getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<UpdateFanTicketMessage>
      PARSER = new com.google.protobuf.AbstractParser<UpdateFanTicketMessage>() {
    @java.lang.Override
    public UpdateFanTicketMessage parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new UpdateFanTicketMessage(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<UpdateFanTicketMessage> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<UpdateFanTicketMessage> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.UpdateFanTicketMessage getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}


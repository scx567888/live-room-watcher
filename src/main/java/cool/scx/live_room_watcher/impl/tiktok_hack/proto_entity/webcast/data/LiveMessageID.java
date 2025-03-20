// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: tiktok_hack/webcast/data/LiveMessageID.proto
// Protobuf Java Version: 4.29.0

package cool.scx.live_room_watcher.impl.tiktok_hack.proto_entity.webcast.data;

/**
 * <pre>
 * 更新时间 2024-04-29
 * </pre>
 *
 * Protobuf type {@code tiktok_hack.LiveMessageID}
 */
public final class LiveMessageID extends
    com.google.protobuf.GeneratedMessage implements
    // @@protoc_insertion_point(message_implements:tiktok_hack.LiveMessageID)
    LiveMessageIDOrBuilder {
private static final long serialVersionUID = 0L;
  static {
    com.google.protobuf.RuntimeVersion.validateProtobufGencodeVersion(
      com.google.protobuf.RuntimeVersion.RuntimeDomain.PUBLIC,
      /* major= */ 4,
      /* minor= */ 29,
      /* patch= */ 0,
      /* suffix= */ "",
      LiveMessageID.class.getName());
  }
  // Use LiveMessageID.newBuilder() to construct.
  private LiveMessageID(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
    super(builder);
  }
  private LiveMessageID() {
    primaryId_ = "";
    messageScene_ = "";
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return cool.scx.live_room_watcher.impl.tiktok_hack.proto_entity.webcast.data.LiveMessageIDOuterClass.internal_static_tiktok_hack_LiveMessageID_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return cool.scx.live_room_watcher.impl.tiktok_hack.proto_entity.webcast.data.LiveMessageIDOuterClass.internal_static_tiktok_hack_LiveMessageID_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            cool.scx.live_room_watcher.impl.tiktok_hack.proto_entity.webcast.data.LiveMessageID.class, cool.scx.live_room_watcher.impl.tiktok_hack.proto_entity.webcast.data.LiveMessageID.Builder.class);
  }

  public static final int PRIMARYID_FIELD_NUMBER = 1;
  @SuppressWarnings("serial")
  private volatile java.lang.Object primaryId_ = "";
  /**
   * <code>string primaryId = 1;</code>
   * @return The primaryId.
   */
  @java.lang.Override
  public java.lang.String getPrimaryId() {
    java.lang.Object ref = primaryId_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      primaryId_ = s;
      return s;
    }
  }
  /**
   * <code>string primaryId = 1;</code>
   * @return The bytes for primaryId.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getPrimaryIdBytes() {
    java.lang.Object ref = primaryId_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      primaryId_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int MESSAGESCENE_FIELD_NUMBER = 2;
  @SuppressWarnings("serial")
  private volatile java.lang.Object messageScene_ = "";
  /**
   * <code>string messageScene = 2;</code>
   * @return The messageScene.
   */
  @java.lang.Override
  public java.lang.String getMessageScene() {
    java.lang.Object ref = messageScene_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      messageScene_ = s;
      return s;
    }
  }
  /**
   * <code>string messageScene = 2;</code>
   * @return The bytes for messageScene.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getMessageSceneBytes() {
    java.lang.Object ref = messageScene_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      messageScene_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
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
    if (!com.google.protobuf.GeneratedMessage.isStringEmpty(primaryId_)) {
      com.google.protobuf.GeneratedMessage.writeString(output, 1, primaryId_);
    }
    if (!com.google.protobuf.GeneratedMessage.isStringEmpty(messageScene_)) {
      com.google.protobuf.GeneratedMessage.writeString(output, 2, messageScene_);
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!com.google.protobuf.GeneratedMessage.isStringEmpty(primaryId_)) {
      size += com.google.protobuf.GeneratedMessage.computeStringSize(1, primaryId_);
    }
    if (!com.google.protobuf.GeneratedMessage.isStringEmpty(messageScene_)) {
      size += com.google.protobuf.GeneratedMessage.computeStringSize(2, messageScene_);
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
    if (!(obj instanceof cool.scx.live_room_watcher.impl.tiktok_hack.proto_entity.webcast.data.LiveMessageID)) {
      return super.equals(obj);
    }
    cool.scx.live_room_watcher.impl.tiktok_hack.proto_entity.webcast.data.LiveMessageID other = (cool.scx.live_room_watcher.impl.tiktok_hack.proto_entity.webcast.data.LiveMessageID) obj;

    if (!getPrimaryId()
        .equals(other.getPrimaryId())) return false;
    if (!getMessageScene()
        .equals(other.getMessageScene())) return false;
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
    hash = (37 * hash) + PRIMARYID_FIELD_NUMBER;
    hash = (53 * hash) + getPrimaryId().hashCode();
    hash = (37 * hash) + MESSAGESCENE_FIELD_NUMBER;
    hash = (53 * hash) + getMessageScene().hashCode();
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static cool.scx.live_room_watcher.impl.tiktok_hack.proto_entity.webcast.data.LiveMessageID parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static cool.scx.live_room_watcher.impl.tiktok_hack.proto_entity.webcast.data.LiveMessageID parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static cool.scx.live_room_watcher.impl.tiktok_hack.proto_entity.webcast.data.LiveMessageID parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static cool.scx.live_room_watcher.impl.tiktok_hack.proto_entity.webcast.data.LiveMessageID parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static cool.scx.live_room_watcher.impl.tiktok_hack.proto_entity.webcast.data.LiveMessageID parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static cool.scx.live_room_watcher.impl.tiktok_hack.proto_entity.webcast.data.LiveMessageID parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static cool.scx.live_room_watcher.impl.tiktok_hack.proto_entity.webcast.data.LiveMessageID parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input);
  }
  public static cool.scx.live_room_watcher.impl.tiktok_hack.proto_entity.webcast.data.LiveMessageID parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static cool.scx.live_room_watcher.impl.tiktok_hack.proto_entity.webcast.data.LiveMessageID parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseDelimitedWithIOException(PARSER, input);
  }

  public static cool.scx.live_room_watcher.impl.tiktok_hack.proto_entity.webcast.data.LiveMessageID parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static cool.scx.live_room_watcher.impl.tiktok_hack.proto_entity.webcast.data.LiveMessageID parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input);
  }
  public static cool.scx.live_room_watcher.impl.tiktok_hack.proto_entity.webcast.data.LiveMessageID parseFrom(
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
  public static Builder newBuilder(cool.scx.live_room_watcher.impl.tiktok_hack.proto_entity.webcast.data.LiveMessageID prototype) {
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
   * 更新时间 2024-04-29
   * </pre>
   *
   * Protobuf type {@code tiktok_hack.LiveMessageID}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessage.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:tiktok_hack.LiveMessageID)
      cool.scx.live_room_watcher.impl.tiktok_hack.proto_entity.webcast.data.LiveMessageIDOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return cool.scx.live_room_watcher.impl.tiktok_hack.proto_entity.webcast.data.LiveMessageIDOuterClass.internal_static_tiktok_hack_LiveMessageID_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return cool.scx.live_room_watcher.impl.tiktok_hack.proto_entity.webcast.data.LiveMessageIDOuterClass.internal_static_tiktok_hack_LiveMessageID_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              cool.scx.live_room_watcher.impl.tiktok_hack.proto_entity.webcast.data.LiveMessageID.class, cool.scx.live_room_watcher.impl.tiktok_hack.proto_entity.webcast.data.LiveMessageID.Builder.class);
    }

    // Construct using cool.scx.live_room_watcher.impl.tiktok_hack.proto_entity.webcast.data.LiveMessageID.newBuilder()
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
      primaryId_ = "";
      messageScene_ = "";
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return cool.scx.live_room_watcher.impl.tiktok_hack.proto_entity.webcast.data.LiveMessageIDOuterClass.internal_static_tiktok_hack_LiveMessageID_descriptor;
    }

    @java.lang.Override
    public cool.scx.live_room_watcher.impl.tiktok_hack.proto_entity.webcast.data.LiveMessageID getDefaultInstanceForType() {
      return cool.scx.live_room_watcher.impl.tiktok_hack.proto_entity.webcast.data.LiveMessageID.getDefaultInstance();
    }

    @java.lang.Override
    public cool.scx.live_room_watcher.impl.tiktok_hack.proto_entity.webcast.data.LiveMessageID build() {
      cool.scx.live_room_watcher.impl.tiktok_hack.proto_entity.webcast.data.LiveMessageID result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public cool.scx.live_room_watcher.impl.tiktok_hack.proto_entity.webcast.data.LiveMessageID buildPartial() {
      cool.scx.live_room_watcher.impl.tiktok_hack.proto_entity.webcast.data.LiveMessageID result = new cool.scx.live_room_watcher.impl.tiktok_hack.proto_entity.webcast.data.LiveMessageID(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(cool.scx.live_room_watcher.impl.tiktok_hack.proto_entity.webcast.data.LiveMessageID result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.primaryId_ = primaryId_;
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.messageScene_ = messageScene_;
      }
    }

    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof cool.scx.live_room_watcher.impl.tiktok_hack.proto_entity.webcast.data.LiveMessageID) {
        return mergeFrom((cool.scx.live_room_watcher.impl.tiktok_hack.proto_entity.webcast.data.LiveMessageID)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(cool.scx.live_room_watcher.impl.tiktok_hack.proto_entity.webcast.data.LiveMessageID other) {
      if (other == cool.scx.live_room_watcher.impl.tiktok_hack.proto_entity.webcast.data.LiveMessageID.getDefaultInstance()) return this;
      if (!other.getPrimaryId().isEmpty()) {
        primaryId_ = other.primaryId_;
        bitField0_ |= 0x00000001;
        onChanged();
      }
      if (!other.getMessageScene().isEmpty()) {
        messageScene_ = other.messageScene_;
        bitField0_ |= 0x00000002;
        onChanged();
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
              primaryId_ = input.readStringRequireUtf8();
              bitField0_ |= 0x00000001;
              break;
            } // case 10
            case 18: {
              messageScene_ = input.readStringRequireUtf8();
              bitField0_ |= 0x00000002;
              break;
            } // case 18
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

    private java.lang.Object primaryId_ = "";
    /**
     * <code>string primaryId = 1;</code>
     * @return The primaryId.
     */
    public java.lang.String getPrimaryId() {
      java.lang.Object ref = primaryId_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        primaryId_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string primaryId = 1;</code>
     * @return The bytes for primaryId.
     */
    public com.google.protobuf.ByteString
        getPrimaryIdBytes() {
      java.lang.Object ref = primaryId_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        primaryId_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string primaryId = 1;</code>
     * @param value The primaryId to set.
     * @return This builder for chaining.
     */
    public Builder setPrimaryId(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      primaryId_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>string primaryId = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearPrimaryId() {
      primaryId_ = getDefaultInstance().getPrimaryId();
      bitField0_ = (bitField0_ & ~0x00000001);
      onChanged();
      return this;
    }
    /**
     * <code>string primaryId = 1;</code>
     * @param value The bytes for primaryId to set.
     * @return This builder for chaining.
     */
    public Builder setPrimaryIdBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      primaryId_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }

    private java.lang.Object messageScene_ = "";
    /**
     * <code>string messageScene = 2;</code>
     * @return The messageScene.
     */
    public java.lang.String getMessageScene() {
      java.lang.Object ref = messageScene_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        messageScene_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string messageScene = 2;</code>
     * @return The bytes for messageScene.
     */
    public com.google.protobuf.ByteString
        getMessageSceneBytes() {
      java.lang.Object ref = messageScene_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        messageScene_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string messageScene = 2;</code>
     * @param value The messageScene to set.
     * @return This builder for chaining.
     */
    public Builder setMessageScene(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      messageScene_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>string messageScene = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearMessageScene() {
      messageScene_ = getDefaultInstance().getMessageScene();
      bitField0_ = (bitField0_ & ~0x00000002);
      onChanged();
      return this;
    }
    /**
     * <code>string messageScene = 2;</code>
     * @param value The bytes for messageScene to set.
     * @return This builder for chaining.
     */
    public Builder setMessageSceneBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      messageScene_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }

    // @@protoc_insertion_point(builder_scope:tiktok_hack.LiveMessageID)
  }

  // @@protoc_insertion_point(class_scope:tiktok_hack.LiveMessageID)
  private static final cool.scx.live_room_watcher.impl.tiktok_hack.proto_entity.webcast.data.LiveMessageID DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new cool.scx.live_room_watcher.impl.tiktok_hack.proto_entity.webcast.data.LiveMessageID();
  }

  public static cool.scx.live_room_watcher.impl.tiktok_hack.proto_entity.webcast.data.LiveMessageID getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<LiveMessageID>
      PARSER = new com.google.protobuf.AbstractParser<LiveMessageID>() {
    @java.lang.Override
    public LiveMessageID parsePartialFrom(
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

  public static com.google.protobuf.Parser<LiveMessageID> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<LiveMessageID> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public cool.scx.live_room_watcher.impl.tiktok_hack.proto_entity.webcast.data.LiveMessageID getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}


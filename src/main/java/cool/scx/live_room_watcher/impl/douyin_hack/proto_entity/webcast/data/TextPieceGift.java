// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: douyin_hack/webcast/data/TextPieceGift.proto

// Protobuf Java Version: 4.26.1
package cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data;

/**
 * <pre>
 * 更新时间 : 2023-01-05 17:22:10
 * </pre>
 *
 * Protobuf type {@code TextPieceGift}
 */
public final class TextPieceGift extends
    com.google.protobuf.GeneratedMessage implements
    // @@protoc_insertion_point(message_implements:TextPieceGift)
    TextPieceGiftOrBuilder {
private static final long serialVersionUID = 0L;
  static {
    com.google.protobuf.RuntimeVersion.validateProtobufGencodeVersion(
      com.google.protobuf.RuntimeVersion.RuntimeDomain.PUBLIC,
      /* major= */ 4,
      /* minor= */ 26,
      /* patch= */ 1,
      /* suffix= */ "",
      TextPieceGift.class.getName());
  }
  // Use TextPieceGift.newBuilder() to construct.
  private TextPieceGift(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
    super(builder);
  }
  private TextPieceGift() {
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.TextPieceGiftOuterClass.internal_static_TextPieceGift_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.TextPieceGiftOuterClass.internal_static_TextPieceGift_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.TextPieceGift.class, cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.TextPieceGift.Builder.class);
  }

  private int bitField0_;
  public static final int GIFTID_FIELD_NUMBER = 1;
  private long giftId_ = 0L;
  /**
   * <code>int64 giftId = 1;</code>
   * @return The giftId.
   */
  @java.lang.Override
  public long getGiftId() {
    return giftId_;
  }

  public static final int NAMEREF_FIELD_NUMBER = 2;
  private cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.PatternRef nameRef_;
  /**
   * <code>.PatternRef nameRef = 2;</code>
   * @return Whether the nameRef field is set.
   */
  @java.lang.Override
  public boolean hasNameRef() {
    return ((bitField0_ & 0x00000001) != 0);
  }
  /**
   * <code>.PatternRef nameRef = 2;</code>
   * @return The nameRef.
   */
  @java.lang.Override
  public cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.PatternRef getNameRef() {
    return nameRef_ == null ? cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.PatternRef.getDefaultInstance() : nameRef_;
  }
  /**
   * <code>.PatternRef nameRef = 2;</code>
   */
  @java.lang.Override
  public cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.PatternRefOrBuilder getNameRefOrBuilder() {
    return nameRef_ == null ? cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.PatternRef.getDefaultInstance() : nameRef_;
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
    if (giftId_ != 0L) {
      output.writeInt64(1, giftId_);
    }
    if (((bitField0_ & 0x00000001) != 0)) {
      output.writeMessage(2, getNameRef());
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (giftId_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(1, giftId_);
    }
    if (((bitField0_ & 0x00000001) != 0)) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, getNameRef());
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
    if (!(obj instanceof cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.TextPieceGift)) {
      return super.equals(obj);
    }
    cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.TextPieceGift other = (cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.TextPieceGift) obj;

    if (getGiftId()
        != other.getGiftId()) return false;
    if (hasNameRef() != other.hasNameRef()) return false;
    if (hasNameRef()) {
      if (!getNameRef()
          .equals(other.getNameRef())) return false;
    }
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
    hash = (37 * hash) + GIFTID_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getGiftId());
    if (hasNameRef()) {
      hash = (37 * hash) + NAMEREF_FIELD_NUMBER;
      hash = (53 * hash) + getNameRef().hashCode();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.TextPieceGift parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.TextPieceGift parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.TextPieceGift parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.TextPieceGift parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.TextPieceGift parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.TextPieceGift parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.TextPieceGift parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input);
  }
  public static cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.TextPieceGift parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.TextPieceGift parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseDelimitedWithIOException(PARSER, input);
  }

  public static cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.TextPieceGift parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.TextPieceGift parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input);
  }
  public static cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.TextPieceGift parseFrom(
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
  public static Builder newBuilder(cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.TextPieceGift prototype) {
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
   * 更新时间 : 2023-01-05 17:22:10
   * </pre>
   *
   * Protobuf type {@code TextPieceGift}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessage.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:TextPieceGift)
      cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.TextPieceGiftOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.TextPieceGiftOuterClass.internal_static_TextPieceGift_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.TextPieceGiftOuterClass.internal_static_TextPieceGift_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.TextPieceGift.class, cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.TextPieceGift.Builder.class);
    }

    // Construct using cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.TextPieceGift.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessage.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessage
              .alwaysUseFieldBuilders) {
        getNameRefFieldBuilder();
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      bitField0_ = 0;
      giftId_ = 0L;
      nameRef_ = null;
      if (nameRefBuilder_ != null) {
        nameRefBuilder_.dispose();
        nameRefBuilder_ = null;
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.TextPieceGiftOuterClass.internal_static_TextPieceGift_descriptor;
    }

    @java.lang.Override
    public cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.TextPieceGift getDefaultInstanceForType() {
      return cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.TextPieceGift.getDefaultInstance();
    }

    @java.lang.Override
    public cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.TextPieceGift build() {
      cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.TextPieceGift result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.TextPieceGift buildPartial() {
      cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.TextPieceGift result = new cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.TextPieceGift(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.TextPieceGift result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.giftId_ = giftId_;
      }
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.nameRef_ = nameRefBuilder_ == null
            ? nameRef_
            : nameRefBuilder_.build();
        to_bitField0_ |= 0x00000001;
      }
      result.bitField0_ |= to_bitField0_;
    }

    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.TextPieceGift) {
        return mergeFrom((cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.TextPieceGift)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.TextPieceGift other) {
      if (other == cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.TextPieceGift.getDefaultInstance()) return this;
      if (other.getGiftId() != 0L) {
        setGiftId(other.getGiftId());
      }
      if (other.hasNameRef()) {
        mergeNameRef(other.getNameRef());
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
            case 8: {
              giftId_ = input.readInt64();
              bitField0_ |= 0x00000001;
              break;
            } // case 8
            case 18: {
              input.readMessage(
                  getNameRefFieldBuilder().getBuilder(),
                  extensionRegistry);
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

    private long giftId_ ;
    /**
     * <code>int64 giftId = 1;</code>
     * @return The giftId.
     */
    @java.lang.Override
    public long getGiftId() {
      return giftId_;
    }
    /**
     * <code>int64 giftId = 1;</code>
     * @param value The giftId to set.
     * @return This builder for chaining.
     */
    public Builder setGiftId(long value) {

      giftId_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>int64 giftId = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearGiftId() {
      bitField0_ = (bitField0_ & ~0x00000001);
      giftId_ = 0L;
      onChanged();
      return this;
    }

    private cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.PatternRef nameRef_;
    private com.google.protobuf.SingleFieldBuilder<
        cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.PatternRef, cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.PatternRef.Builder, cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.PatternRefOrBuilder> nameRefBuilder_;
    /**
     * <code>.PatternRef nameRef = 2;</code>
     * @return Whether the nameRef field is set.
     */
    public boolean hasNameRef() {
      return ((bitField0_ & 0x00000002) != 0);
    }
    /**
     * <code>.PatternRef nameRef = 2;</code>
     * @return The nameRef.
     */
    public cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.PatternRef getNameRef() {
      if (nameRefBuilder_ == null) {
        return nameRef_ == null ? cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.PatternRef.getDefaultInstance() : nameRef_;
      } else {
        return nameRefBuilder_.getMessage();
      }
    }
    /**
     * <code>.PatternRef nameRef = 2;</code>
     */
    public Builder setNameRef(cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.PatternRef value) {
      if (nameRefBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        nameRef_ = value;
      } else {
        nameRefBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>.PatternRef nameRef = 2;</code>
     */
    public Builder setNameRef(
        cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.PatternRef.Builder builderForValue) {
      if (nameRefBuilder_ == null) {
        nameRef_ = builderForValue.build();
      } else {
        nameRefBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>.PatternRef nameRef = 2;</code>
     */
    public Builder mergeNameRef(cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.PatternRef value) {
      if (nameRefBuilder_ == null) {
        if (((bitField0_ & 0x00000002) != 0) &&
          nameRef_ != null &&
          nameRef_ != cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.PatternRef.getDefaultInstance()) {
          getNameRefBuilder().mergeFrom(value);
        } else {
          nameRef_ = value;
        }
      } else {
        nameRefBuilder_.mergeFrom(value);
      }
      if (nameRef_ != null) {
        bitField0_ |= 0x00000002;
        onChanged();
      }
      return this;
    }
    /**
     * <code>.PatternRef nameRef = 2;</code>
     */
    public Builder clearNameRef() {
      bitField0_ = (bitField0_ & ~0x00000002);
      nameRef_ = null;
      if (nameRefBuilder_ != null) {
        nameRefBuilder_.dispose();
        nameRefBuilder_ = null;
      }
      onChanged();
      return this;
    }
    /**
     * <code>.PatternRef nameRef = 2;</code>
     */
    public cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.PatternRef.Builder getNameRefBuilder() {
      bitField0_ |= 0x00000002;
      onChanged();
      return getNameRefFieldBuilder().getBuilder();
    }
    /**
     * <code>.PatternRef nameRef = 2;</code>
     */
    public cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.PatternRefOrBuilder getNameRefOrBuilder() {
      if (nameRefBuilder_ != null) {
        return nameRefBuilder_.getMessageOrBuilder();
      } else {
        return nameRef_ == null ?
            cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.PatternRef.getDefaultInstance() : nameRef_;
      }
    }
    /**
     * <code>.PatternRef nameRef = 2;</code>
     */
    private com.google.protobuf.SingleFieldBuilder<
        cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.PatternRef, cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.PatternRef.Builder, cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.PatternRefOrBuilder> 
        getNameRefFieldBuilder() {
      if (nameRefBuilder_ == null) {
        nameRefBuilder_ = new com.google.protobuf.SingleFieldBuilder<
            cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.PatternRef, cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.PatternRef.Builder, cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.PatternRefOrBuilder>(
                getNameRef(),
                getParentForChildren(),
                isClean());
        nameRef_ = null;
      }
      return nameRefBuilder_;
    }

    // @@protoc_insertion_point(builder_scope:TextPieceGift)
  }

  // @@protoc_insertion_point(class_scope:TextPieceGift)
  private static final cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.TextPieceGift DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.TextPieceGift();
  }

  public static cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.TextPieceGift getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<TextPieceGift>
      PARSER = new com.google.protobuf.AbstractParser<TextPieceGift>() {
    @java.lang.Override
    public TextPieceGift parsePartialFrom(
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

  public static com.google.protobuf.Parser<TextPieceGift> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<TextPieceGift> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.TextPieceGift getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}


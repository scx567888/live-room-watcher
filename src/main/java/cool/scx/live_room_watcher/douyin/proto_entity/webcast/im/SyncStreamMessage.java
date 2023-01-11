// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: webcast/im/SyncStreamMessage.proto

package cool.scx.live_room_watcher.douyin.proto_entity.webcast.im;

/**
 * <pre>
 *更新时间 : 2023-01-10
 * </pre>
 *
 * Protobuf type {@code SyncStreamMessage}
 *
 * @author scx567888
 * @version $Id: $Id
 */
public final class SyncStreamMessage extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:SyncStreamMessage)
    SyncStreamMessageOrBuilder {
/** Constant <code>serialVersionUID=0L</code> */
private static final long serialVersionUID = 0L;
  // Use SyncStreamMessage.newBuilder() to construct.
  /**
   * <p>Constructor for SyncStreamMessage.</p>
   *
   * @param builder a {@link com.google.protobuf.GeneratedMessageV3.Builder} object
   */
  private SyncStreamMessage(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  /**
   * <p>Constructor for SyncStreamMessage.</p>
   */
  private SyncStreamMessage() {
    common_ = "";
    infoListList_ = java.util.Collections.emptyList();
  }

  /** {@inheritDoc} */
  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new SyncStreamMessage();
  }

  /** {@inheritDoc} */
  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  /**
   * <p>Constructor for SyncStreamMessage.</p>
   *
   * @param input a {@link com.google.protobuf.CodedInputStream} object
   * @param extensionRegistry a {@link com.google.protobuf.ExtensionRegistryLite} object
   * @throws com.google.protobuf.InvalidProtocolBufferException if any.
   */
  private SyncStreamMessage(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
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
            java.lang.String s = input.readStringRequireUtf8();

            common_ = s;
            break;
          }
          case 18: {
            if (!((mutable_bitField0_ & 0x00000001) != 0)) {
              infoListList_ = new java.util.ArrayList<cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.SyncStreamInfoMessage>();
              mutable_bitField0_ |= 0x00000001;
            }
            infoListList_.add(
                input.readMessage(cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.SyncStreamInfoMessage.parser(), extensionRegistry));
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
      if (((mutable_bitField0_ & 0x00000001) != 0)) {
        infoListList_ = java.util.Collections.unmodifiableList(infoListList_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  /**
   * <p>getDescriptor.</p>
   *
   * @return a {@link com.google.protobuf.Descriptors.Descriptor} object
   */
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.SyncStreamMessageOuterClass.internal_static_SyncStreamMessage_descriptor;
  }

  /** {@inheritDoc} */
  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.SyncStreamMessageOuterClass.internal_static_SyncStreamMessage_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.SyncStreamMessage.class, cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.SyncStreamMessage.Builder.class);
  }

  /** Constant <code>COMMON_FIELD_NUMBER=1</code> */
  public static final int COMMON_FIELD_NUMBER = 1;
  private volatile java.lang.Object common_;
  /**
   * {@inheritDoc}
   *
   * <code>string common = 1;</code>
   */
  @java.lang.Override
  public java.lang.String getCommon() {
    java.lang.Object ref = common_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      common_ = s;
      return s;
    }
  }
  /**
   * {@inheritDoc}
   *
   * <code>string common = 1;</code>
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getCommonBytes() {
    java.lang.Object ref = common_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      common_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  /** Constant <code>INFOLISTLIST_FIELD_NUMBER=2</code> */
  public static final int INFOLISTLIST_FIELD_NUMBER = 2;
  private java.util.List<cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.SyncStreamInfoMessage> infoListList_;
  /**
   * {@inheritDoc}
   *
   * <code>repeated .SyncStreamInfoMessage infoListList = 2;</code>
   */
  @java.lang.Override
  public java.util.List<cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.SyncStreamInfoMessage> getInfoListListList() {
    return infoListList_;
  }
  /**
   * {@inheritDoc}
   *
   * <code>repeated .SyncStreamInfoMessage infoListList = 2;</code>
   */
  @java.lang.Override
  public java.util.List<? extends cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.SyncStreamInfoMessageOrBuilder> 
      getInfoListListOrBuilderList() {
    return infoListList_;
  }
  /**
   * {@inheritDoc}
   *
   * <code>repeated .SyncStreamInfoMessage infoListList = 2;</code>
   */
  @java.lang.Override
  public int getInfoListListCount() {
    return infoListList_.size();
  }
  /**
   * {@inheritDoc}
   *
   * <code>repeated .SyncStreamInfoMessage infoListList = 2;</code>
   */
  @java.lang.Override
  public cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.SyncStreamInfoMessage getInfoListList(int index) {
    return infoListList_.get(index);
  }
  /**
   * {@inheritDoc}
   *
   * <code>repeated .SyncStreamInfoMessage infoListList = 2;</code>
   */
  @java.lang.Override
  public cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.SyncStreamInfoMessageOrBuilder getInfoListListOrBuilder(
      int index) {
    return infoListList_.get(index);
  }

  private byte memoizedIsInitialized = -1;
  /** {@inheritDoc} */
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  /** {@inheritDoc} */
  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!getCommonBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, common_);
    }
    for (int i = 0; i < infoListList_.size(); i++) {
      output.writeMessage(2, infoListList_.get(i));
    }
    unknownFields.writeTo(output);
  }

  /** {@inheritDoc} */
  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getCommonBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, common_);
    }
    for (int i = 0; i < infoListList_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, infoListList_.get(i));
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  /** {@inheritDoc} */
  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.SyncStreamMessage)) {
      return super.equals(obj);
    }
    cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.SyncStreamMessage other = (cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.SyncStreamMessage) obj;

    if (!getCommon()
        .equals(other.getCommon())) return false;
    if (!getInfoListListList()
        .equals(other.getInfoListListList())) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  /** {@inheritDoc} */
  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + COMMON_FIELD_NUMBER;
    hash = (53 * hash) + getCommon().hashCode();
    if (getInfoListListCount() > 0) {
      hash = (37 * hash) + INFOLISTLIST_FIELD_NUMBER;
      hash = (53 * hash) + getInfoListListList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  /**
   * <p>parseFrom.</p>
   *
   * @param data a {@link java.nio.ByteBuffer} object
   * @return a {@link cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.SyncStreamMessage} object
   * @throws com.google.protobuf.InvalidProtocolBufferException if any.
   */
  public static cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.SyncStreamMessage parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  /**
   * <p>parseFrom.</p>
   *
   * @param data a {@link java.nio.ByteBuffer} object
   * @param extensionRegistry a {@link com.google.protobuf.ExtensionRegistryLite} object
   * @return a {@link cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.SyncStreamMessage} object
   * @throws com.google.protobuf.InvalidProtocolBufferException if any.
   */
  public static cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.SyncStreamMessage parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  /**
   * <p>parseFrom.</p>
   *
   * @param data a {@link com.google.protobuf.ByteString} object
   * @return a {@link cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.SyncStreamMessage} object
   * @throws com.google.protobuf.InvalidProtocolBufferException if any.
   */
  public static cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.SyncStreamMessage parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  /**
   * <p>parseFrom.</p>
   *
   * @param data a {@link com.google.protobuf.ByteString} object
   * @param extensionRegistry a {@link com.google.protobuf.ExtensionRegistryLite} object
   * @return a {@link cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.SyncStreamMessage} object
   * @throws com.google.protobuf.InvalidProtocolBufferException if any.
   */
  public static cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.SyncStreamMessage parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  /**
   * <p>parseFrom.</p>
   *
   * @param data an array of {@link byte} objects
   * @return a {@link cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.SyncStreamMessage} object
   * @throws com.google.protobuf.InvalidProtocolBufferException if any.
   */
  public static cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.SyncStreamMessage parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  /**
   * <p>parseFrom.</p>
   *
   * @param data an array of {@link byte} objects
   * @param extensionRegistry a {@link com.google.protobuf.ExtensionRegistryLite} object
   * @return a {@link cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.SyncStreamMessage} object
   * @throws com.google.protobuf.InvalidProtocolBufferException if any.
   */
  public static cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.SyncStreamMessage parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  /**
   * <p>parseFrom.</p>
   *
   * @param input a {@link java.io.InputStream} object
   * @return a {@link cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.SyncStreamMessage} object
   * @throws java.io.IOException if any.
   */
  public static cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.SyncStreamMessage parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  /**
   * <p>parseFrom.</p>
   *
   * @param input a {@link java.io.InputStream} object
   * @param extensionRegistry a {@link com.google.protobuf.ExtensionRegistryLite} object
   * @return a {@link cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.SyncStreamMessage} object
   * @throws java.io.IOException if any.
   */
  public static cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.SyncStreamMessage parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  /**
   * <p>parseDelimitedFrom.</p>
   *
   * @param input a {@link java.io.InputStream} object
   * @return a {@link cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.SyncStreamMessage} object
   * @throws java.io.IOException if any.
   */
  public static cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.SyncStreamMessage parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  /**
   * <p>parseDelimitedFrom.</p>
   *
   * @param input a {@link java.io.InputStream} object
   * @param extensionRegistry a {@link com.google.protobuf.ExtensionRegistryLite} object
   * @return a {@link cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.SyncStreamMessage} object
   * @throws java.io.IOException if any.
   */
  public static cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.SyncStreamMessage parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  /**
   * <p>parseFrom.</p>
   *
   * @param input a {@link com.google.protobuf.CodedInputStream} object
   * @return a {@link cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.SyncStreamMessage} object
   * @throws java.io.IOException if any.
   */
  public static cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.SyncStreamMessage parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  /**
   * <p>parseFrom.</p>
   *
   * @param input a {@link com.google.protobuf.CodedInputStream} object
   * @param extensionRegistry a {@link com.google.protobuf.ExtensionRegistryLite} object
   * @return a {@link cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.SyncStreamMessage} object
   * @throws java.io.IOException if any.
   */
  public static cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.SyncStreamMessage parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  /** {@inheritDoc} */
  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  /**
   * <p>newBuilder.</p>
   *
   * @return a {@link cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.SyncStreamMessage.Builder} object
   */
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  /**
   * <p>newBuilder.</p>
   *
   * @param prototype a {@link cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.SyncStreamMessage} object
   * @return a {@link cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.SyncStreamMessage.Builder} object
   */
  public static Builder newBuilder(cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.SyncStreamMessage prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  /** {@inheritDoc} */
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  /** {@inheritDoc} */
  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * <pre>
   *更新时间 : 2023-01-10
   * </pre>
   *
   * Protobuf type {@code SyncStreamMessage}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:SyncStreamMessage)
      cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.SyncStreamMessageOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.SyncStreamMessageOuterClass.internal_static_SyncStreamMessage_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.SyncStreamMessageOuterClass.internal_static_SyncStreamMessage_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.SyncStreamMessage.class, cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.SyncStreamMessage.Builder.class);
    }

    // Construct using cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.SyncStreamMessage.newBuilder()
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
        getInfoListListFieldBuilder();
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      common_ = "";

      if (infoListListBuilder_ == null) {
        infoListList_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
      } else {
        infoListListBuilder_.clear();
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.SyncStreamMessageOuterClass.internal_static_SyncStreamMessage_descriptor;
    }

    @java.lang.Override
    public cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.SyncStreamMessage getDefaultInstanceForType() {
      return cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.SyncStreamMessage.getDefaultInstance();
    }

    @java.lang.Override
    public cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.SyncStreamMessage build() {
      cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.SyncStreamMessage result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.SyncStreamMessage buildPartial() {
      cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.SyncStreamMessage result = new cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.SyncStreamMessage(this);
      int from_bitField0_ = bitField0_;
      result.common_ = common_;
      if (infoListListBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)) {
          infoListList_ = java.util.Collections.unmodifiableList(infoListList_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.infoListList_ = infoListList_;
      } else {
        result.infoListList_ = infoListListBuilder_.build();
      }
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
      if (other instanceof cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.SyncStreamMessage) {
        return mergeFrom((cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.SyncStreamMessage)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.SyncStreamMessage other) {
      if (other == cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.SyncStreamMessage.getDefaultInstance()) return this;
      if (!other.getCommon().isEmpty()) {
        common_ = other.common_;
        onChanged();
      }
      if (infoListListBuilder_ == null) {
        if (!other.infoListList_.isEmpty()) {
          if (infoListList_.isEmpty()) {
            infoListList_ = other.infoListList_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureInfoListListIsMutable();
            infoListList_.addAll(other.infoListList_);
          }
          onChanged();
        }
      } else {
        if (!other.infoListList_.isEmpty()) {
          if (infoListListBuilder_.isEmpty()) {
            infoListListBuilder_.dispose();
            infoListListBuilder_ = null;
            infoListList_ = other.infoListList_;
            bitField0_ = (bitField0_ & ~0x00000001);
            infoListListBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getInfoListListFieldBuilder() : null;
          } else {
            infoListListBuilder_.addAllMessages(other.infoListList_);
          }
        }
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
      cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.SyncStreamMessage parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.SyncStreamMessage) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.lang.Object common_ = "";
    /**
     * <code>string common = 1;</code>
     * @return The common.
     */
    public java.lang.String getCommon() {
      java.lang.Object ref = common_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        common_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string common = 1;</code>
     * @return The bytes for common.
     */
    public com.google.protobuf.ByteString
        getCommonBytes() {
      java.lang.Object ref = common_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        common_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string common = 1;</code>
     * @param value The common to set.
     * @return This builder for chaining.
     */
    public Builder setCommon(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      common_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string common = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearCommon() {
      
      common_ = getDefaultInstance().getCommon();
      onChanged();
      return this;
    }
    /**
     * <code>string common = 1;</code>
     * @param value The bytes for common to set.
     * @return This builder for chaining.
     */
    public Builder setCommonBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      common_ = value;
      onChanged();
      return this;
    }

    private java.util.List<cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.SyncStreamInfoMessage> infoListList_ =
      java.util.Collections.emptyList();
    private void ensureInfoListListIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        infoListList_ = new java.util.ArrayList<cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.SyncStreamInfoMessage>(infoListList_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.SyncStreamInfoMessage, cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.SyncStreamInfoMessage.Builder, cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.SyncStreamInfoMessageOrBuilder> infoListListBuilder_;

    /**
     * <code>repeated .SyncStreamInfoMessage infoListList = 2;</code>
     */
    public java.util.List<cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.SyncStreamInfoMessage> getInfoListListList() {
      if (infoListListBuilder_ == null) {
        return java.util.Collections.unmodifiableList(infoListList_);
      } else {
        return infoListListBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .SyncStreamInfoMessage infoListList = 2;</code>
     */
    public int getInfoListListCount() {
      if (infoListListBuilder_ == null) {
        return infoListList_.size();
      } else {
        return infoListListBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .SyncStreamInfoMessage infoListList = 2;</code>
     */
    public cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.SyncStreamInfoMessage getInfoListList(int index) {
      if (infoListListBuilder_ == null) {
        return infoListList_.get(index);
      } else {
        return infoListListBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .SyncStreamInfoMessage infoListList = 2;</code>
     */
    public Builder setInfoListList(
        int index, cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.SyncStreamInfoMessage value) {
      if (infoListListBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureInfoListListIsMutable();
        infoListList_.set(index, value);
        onChanged();
      } else {
        infoListListBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .SyncStreamInfoMessage infoListList = 2;</code>
     */
    public Builder setInfoListList(
        int index, cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.SyncStreamInfoMessage.Builder builderForValue) {
      if (infoListListBuilder_ == null) {
        ensureInfoListListIsMutable();
        infoListList_.set(index, builderForValue.build());
        onChanged();
      } else {
        infoListListBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .SyncStreamInfoMessage infoListList = 2;</code>
     */
    public Builder addInfoListList(cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.SyncStreamInfoMessage value) {
      if (infoListListBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureInfoListListIsMutable();
        infoListList_.add(value);
        onChanged();
      } else {
        infoListListBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .SyncStreamInfoMessage infoListList = 2;</code>
     */
    public Builder addInfoListList(
        int index, cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.SyncStreamInfoMessage value) {
      if (infoListListBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureInfoListListIsMutable();
        infoListList_.add(index, value);
        onChanged();
      } else {
        infoListListBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .SyncStreamInfoMessage infoListList = 2;</code>
     */
    public Builder addInfoListList(
        cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.SyncStreamInfoMessage.Builder builderForValue) {
      if (infoListListBuilder_ == null) {
        ensureInfoListListIsMutable();
        infoListList_.add(builderForValue.build());
        onChanged();
      } else {
        infoListListBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .SyncStreamInfoMessage infoListList = 2;</code>
     */
    public Builder addInfoListList(
        int index, cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.SyncStreamInfoMessage.Builder builderForValue) {
      if (infoListListBuilder_ == null) {
        ensureInfoListListIsMutable();
        infoListList_.add(index, builderForValue.build());
        onChanged();
      } else {
        infoListListBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .SyncStreamInfoMessage infoListList = 2;</code>
     */
    public Builder addAllInfoListList(
        java.lang.Iterable<? extends cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.SyncStreamInfoMessage> values) {
      if (infoListListBuilder_ == null) {
        ensureInfoListListIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, infoListList_);
        onChanged();
      } else {
        infoListListBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .SyncStreamInfoMessage infoListList = 2;</code>
     */
    public Builder clearInfoListList() {
      if (infoListListBuilder_ == null) {
        infoListList_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        infoListListBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .SyncStreamInfoMessage infoListList = 2;</code>
     */
    public Builder removeInfoListList(int index) {
      if (infoListListBuilder_ == null) {
        ensureInfoListListIsMutable();
        infoListList_.remove(index);
        onChanged();
      } else {
        infoListListBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .SyncStreamInfoMessage infoListList = 2;</code>
     */
    public cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.SyncStreamInfoMessage.Builder getInfoListListBuilder(
        int index) {
      return getInfoListListFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .SyncStreamInfoMessage infoListList = 2;</code>
     */
    public cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.SyncStreamInfoMessageOrBuilder getInfoListListOrBuilder(
        int index) {
      if (infoListListBuilder_ == null) {
        return infoListList_.get(index);  } else {
        return infoListListBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .SyncStreamInfoMessage infoListList = 2;</code>
     */
    public java.util.List<? extends cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.SyncStreamInfoMessageOrBuilder> 
         getInfoListListOrBuilderList() {
      if (infoListListBuilder_ != null) {
        return infoListListBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(infoListList_);
      }
    }
    /**
     * <code>repeated .SyncStreamInfoMessage infoListList = 2;</code>
     */
    public cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.SyncStreamInfoMessage.Builder addInfoListListBuilder() {
      return getInfoListListFieldBuilder().addBuilder(
          cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.SyncStreamInfoMessage.getDefaultInstance());
    }
    /**
     * <code>repeated .SyncStreamInfoMessage infoListList = 2;</code>
     */
    public cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.SyncStreamInfoMessage.Builder addInfoListListBuilder(
        int index) {
      return getInfoListListFieldBuilder().addBuilder(
          index, cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.SyncStreamInfoMessage.getDefaultInstance());
    }
    /**
     * <code>repeated .SyncStreamInfoMessage infoListList = 2;</code>
     */
    public java.util.List<cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.SyncStreamInfoMessage.Builder> 
         getInfoListListBuilderList() {
      return getInfoListListFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.SyncStreamInfoMessage, cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.SyncStreamInfoMessage.Builder, cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.SyncStreamInfoMessageOrBuilder> 
        getInfoListListFieldBuilder() {
      if (infoListListBuilder_ == null) {
        infoListListBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.SyncStreamInfoMessage, cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.SyncStreamInfoMessage.Builder, cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.SyncStreamInfoMessageOrBuilder>(
                infoListList_,
                ((bitField0_ & 0x00000001) != 0),
                getParentForChildren(),
                isClean());
        infoListList_ = null;
      }
      return infoListListBuilder_;
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


    // @@protoc_insertion_point(builder_scope:SyncStreamMessage)
  }

  // @@protoc_insertion_point(class_scope:SyncStreamMessage)
  /** Constant <code>DEFAULT_INSTANCE</code> */
  private static final cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.SyncStreamMessage DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.SyncStreamMessage();
  }

  /**
   * <p>getDefaultInstance.</p>
   *
   * @return a {@link cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.SyncStreamMessage} object
   */
  public static cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.SyncStreamMessage getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  /** Constant <code>PARSER</code> */
  private static final com.google.protobuf.Parser<SyncStreamMessage>
      PARSER = new com.google.protobuf.AbstractParser<SyncStreamMessage>() {
    @java.lang.Override
    public SyncStreamMessage parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new SyncStreamMessage(input, extensionRegistry);
    }
  };

  /**
   * <p>parser.</p>
   *
   * @return a {@link com.google.protobuf.Parser} object
   */
  public static com.google.protobuf.Parser<SyncStreamMessage> parser() {
    return PARSER;
  }

  /** {@inheritDoc} */
  @java.lang.Override
  public com.google.protobuf.Parser<SyncStreamMessage> getParserForType() {
    return PARSER;
  }

  /** {@inheritDoc} */
  @java.lang.Override
  public cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.SyncStreamMessage getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}


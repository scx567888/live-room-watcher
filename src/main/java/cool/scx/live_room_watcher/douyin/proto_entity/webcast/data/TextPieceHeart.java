// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: webcast/data/TextPieceHeart.proto

package cool.scx.live_room_watcher.douyin.proto_entity.webcast.data;

/**
 * <pre>
 *更新时间 : 2023-01-05 17:25:27
 * </pre>
 *
 * Protobuf type {@code TextPieceHeart}
 */
public final class TextPieceHeart extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:TextPieceHeart)
    TextPieceHeartOrBuilder {
private static final long serialVersionUID = 0L;
  // Use TextPieceHeart.newBuilder() to construct.
  private TextPieceHeart(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private TextPieceHeart() {
    color_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new TextPieceHeart();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private TextPieceHeart(
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
            java.lang.String s = input.readStringRequireUtf8();

            color_ = s;
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
    return cool.scx.live_room_watcher.douyin.proto_entity.webcast.data.TextPieceHeartOuterClass.internal_static_TextPieceHeart_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return cool.scx.live_room_watcher.douyin.proto_entity.webcast.data.TextPieceHeartOuterClass.internal_static_TextPieceHeart_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            cool.scx.live_room_watcher.douyin.proto_entity.webcast.data.TextPieceHeart.class, cool.scx.live_room_watcher.douyin.proto_entity.webcast.data.TextPieceHeart.Builder.class);
  }

  public static final int COLOR_FIELD_NUMBER = 1;
  private volatile java.lang.Object color_;
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
    if (!getColorBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, color_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getColorBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, color_);
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
    if (!(obj instanceof cool.scx.live_room_watcher.douyin.proto_entity.webcast.data.TextPieceHeart)) {
      return super.equals(obj);
    }
    cool.scx.live_room_watcher.douyin.proto_entity.webcast.data.TextPieceHeart other = (cool.scx.live_room_watcher.douyin.proto_entity.webcast.data.TextPieceHeart) obj;

    if (!getColor()
        .equals(other.getColor())) return false;
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
    hash = (37 * hash) + COLOR_FIELD_NUMBER;
    hash = (53 * hash) + getColor().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static cool.scx.live_room_watcher.douyin.proto_entity.webcast.data.TextPieceHeart parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static cool.scx.live_room_watcher.douyin.proto_entity.webcast.data.TextPieceHeart parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static cool.scx.live_room_watcher.douyin.proto_entity.webcast.data.TextPieceHeart parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static cool.scx.live_room_watcher.douyin.proto_entity.webcast.data.TextPieceHeart parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static cool.scx.live_room_watcher.douyin.proto_entity.webcast.data.TextPieceHeart parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static cool.scx.live_room_watcher.douyin.proto_entity.webcast.data.TextPieceHeart parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static cool.scx.live_room_watcher.douyin.proto_entity.webcast.data.TextPieceHeart parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static cool.scx.live_room_watcher.douyin.proto_entity.webcast.data.TextPieceHeart parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static cool.scx.live_room_watcher.douyin.proto_entity.webcast.data.TextPieceHeart parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static cool.scx.live_room_watcher.douyin.proto_entity.webcast.data.TextPieceHeart parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static cool.scx.live_room_watcher.douyin.proto_entity.webcast.data.TextPieceHeart parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static cool.scx.live_room_watcher.douyin.proto_entity.webcast.data.TextPieceHeart parseFrom(
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
  public static Builder newBuilder(cool.scx.live_room_watcher.douyin.proto_entity.webcast.data.TextPieceHeart prototype) {
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
   *更新时间 : 2023-01-05 17:25:27
   * </pre>
   *
   * Protobuf type {@code TextPieceHeart}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:TextPieceHeart)
      cool.scx.live_room_watcher.douyin.proto_entity.webcast.data.TextPieceHeartOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return cool.scx.live_room_watcher.douyin.proto_entity.webcast.data.TextPieceHeartOuterClass.internal_static_TextPieceHeart_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return cool.scx.live_room_watcher.douyin.proto_entity.webcast.data.TextPieceHeartOuterClass.internal_static_TextPieceHeart_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              cool.scx.live_room_watcher.douyin.proto_entity.webcast.data.TextPieceHeart.class, cool.scx.live_room_watcher.douyin.proto_entity.webcast.data.TextPieceHeart.Builder.class);
    }

    // Construct using cool.scx.live_room_watcher.douyin.proto_entity.webcast.data.TextPieceHeart.newBuilder()
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
      color_ = "";

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return cool.scx.live_room_watcher.douyin.proto_entity.webcast.data.TextPieceHeartOuterClass.internal_static_TextPieceHeart_descriptor;
    }

    @java.lang.Override
    public cool.scx.live_room_watcher.douyin.proto_entity.webcast.data.TextPieceHeart getDefaultInstanceForType() {
      return cool.scx.live_room_watcher.douyin.proto_entity.webcast.data.TextPieceHeart.getDefaultInstance();
    }

    @java.lang.Override
    public cool.scx.live_room_watcher.douyin.proto_entity.webcast.data.TextPieceHeart build() {
      cool.scx.live_room_watcher.douyin.proto_entity.webcast.data.TextPieceHeart result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public cool.scx.live_room_watcher.douyin.proto_entity.webcast.data.TextPieceHeart buildPartial() {
      cool.scx.live_room_watcher.douyin.proto_entity.webcast.data.TextPieceHeart result = new cool.scx.live_room_watcher.douyin.proto_entity.webcast.data.TextPieceHeart(this);
      result.color_ = color_;
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
      if (other instanceof cool.scx.live_room_watcher.douyin.proto_entity.webcast.data.TextPieceHeart) {
        return mergeFrom((cool.scx.live_room_watcher.douyin.proto_entity.webcast.data.TextPieceHeart)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(cool.scx.live_room_watcher.douyin.proto_entity.webcast.data.TextPieceHeart other) {
      if (other == cool.scx.live_room_watcher.douyin.proto_entity.webcast.data.TextPieceHeart.getDefaultInstance()) return this;
      if (!other.getColor().isEmpty()) {
        color_ = other.color_;
        onChanged();
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
      cool.scx.live_room_watcher.douyin.proto_entity.webcast.data.TextPieceHeart parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (cool.scx.live_room_watcher.douyin.proto_entity.webcast.data.TextPieceHeart) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

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
      if (value == null) {
    throw new NullPointerException();
  }
  
      color_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string color = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearColor() {
      
      color_ = getDefaultInstance().getColor();
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
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      color_ = value;
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


    // @@protoc_insertion_point(builder_scope:TextPieceHeart)
  }

  // @@protoc_insertion_point(class_scope:TextPieceHeart)
  private static final cool.scx.live_room_watcher.douyin.proto_entity.webcast.data.TextPieceHeart DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new cool.scx.live_room_watcher.douyin.proto_entity.webcast.data.TextPieceHeart();
  }

  public static cool.scx.live_room_watcher.douyin.proto_entity.webcast.data.TextPieceHeart getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<TextPieceHeart>
      PARSER = new com.google.protobuf.AbstractParser<TextPieceHeart>() {
    @java.lang.Override
    public TextPieceHeart parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new TextPieceHeart(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<TextPieceHeart> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<TextPieceHeart> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public cool.scx.live_room_watcher.douyin.proto_entity.webcast.data.TextPieceHeart getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}


// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: douyin_hack/webcast/data/RoomUserAttr.proto
// Protobuf Java Version: 4.27.2

package cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data;

/**
 * Protobuf type {@code RoomUserAttr}
 */
public final class RoomUserAttr extends
    com.google.protobuf.GeneratedMessage implements
    // @@protoc_insertion_point(message_implements:RoomUserAttr)
    RoomUserAttrOrBuilder {
private static final long serialVersionUID = 0L;
  static {
    com.google.protobuf.RuntimeVersion.validateProtobufGencodeVersion(
      com.google.protobuf.RuntimeVersion.RuntimeDomain.PUBLIC,
      /* major= */ 4,
      /* minor= */ 27,
      /* patch= */ 2,
      /* suffix= */ "",
      RoomUserAttr.class.getName());
  }
  // Use RoomUserAttr.newBuilder() to construct.
  private RoomUserAttr(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
    super(builder);
  }
  private RoomUserAttr() {
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.RoomUserAttrOuterClass.internal_static_RoomUserAttr_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.RoomUserAttrOuterClass.internal_static_RoomUserAttr_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.RoomUserAttr.class, cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.RoomUserAttr.Builder.class);
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
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    size += getUnknownFields().getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.RoomUserAttr)) {
      return super.equals(obj);
    }
    cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.RoomUserAttr other = (cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.RoomUserAttr) obj;

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
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.RoomUserAttr parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.RoomUserAttr parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.RoomUserAttr parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.RoomUserAttr parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.RoomUserAttr parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.RoomUserAttr parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.RoomUserAttr parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input);
  }
  public static cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.RoomUserAttr parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.RoomUserAttr parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseDelimitedWithIOException(PARSER, input);
  }

  public static cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.RoomUserAttr parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.RoomUserAttr parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input);
  }
  public static cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.RoomUserAttr parseFrom(
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
  public static Builder newBuilder(cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.RoomUserAttr prototype) {
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
   * Protobuf type {@code RoomUserAttr}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessage.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:RoomUserAttr)
      cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.RoomUserAttrOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.RoomUserAttrOuterClass.internal_static_RoomUserAttr_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.RoomUserAttrOuterClass.internal_static_RoomUserAttr_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.RoomUserAttr.class, cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.RoomUserAttr.Builder.class);
    }

    // Construct using cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.RoomUserAttr.newBuilder()
    private Builder() {

    }

    private Builder(
        com.google.protobuf.GeneratedMessage.BuilderParent parent) {
      super(parent);

    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.RoomUserAttrOuterClass.internal_static_RoomUserAttr_descriptor;
    }

    @java.lang.Override
    public cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.RoomUserAttr getDefaultInstanceForType() {
      return cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.RoomUserAttr.getDefaultInstance();
    }

    @java.lang.Override
    public cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.RoomUserAttr build() {
      cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.RoomUserAttr result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.RoomUserAttr buildPartial() {
      cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.RoomUserAttr result = new cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.RoomUserAttr(this);
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.RoomUserAttr) {
        return mergeFrom((cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.RoomUserAttr)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.RoomUserAttr other) {
      if (other == cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.RoomUserAttr.getDefaultInstance()) return this;
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

    // @@protoc_insertion_point(builder_scope:RoomUserAttr)
  }

  // @@protoc_insertion_point(class_scope:RoomUserAttr)
  private static final cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.RoomUserAttr DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.RoomUserAttr();
  }

  public static cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.RoomUserAttr getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<RoomUserAttr>
      PARSER = new com.google.protobuf.AbstractParser<RoomUserAttr>() {
    @java.lang.Override
    public RoomUserAttr parsePartialFrom(
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

  public static com.google.protobuf.Parser<RoomUserAttr> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<RoomUserAttr> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.RoomUserAttr getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}


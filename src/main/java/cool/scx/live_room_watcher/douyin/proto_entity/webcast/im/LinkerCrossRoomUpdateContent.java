// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: webcast/im/LinkerCrossRoomUpdateContent.proto

package cool.scx.live_room_watcher.douyin.proto_entity.webcast.im;

/**
 * <pre>
 * 更新时间 : 2023-01-11
 * </pre>
 * <p>
 * Protobuf type {@code LinkerCrossRoomUpdateContent}
 *
 * @author scx567888
 * @version $Id: $Id
 */
public final class LinkerCrossRoomUpdateContent extends
        com.google.protobuf.GeneratedMessageV3 implements
        // @@protoc_insertion_point(message_implements:LinkerCrossRoomUpdateContent)
        LinkerCrossRoomUpdateContentOrBuilder {
    /**
     * Constant <code>serialVersionUID=0L</code>
     */
    private static final long serialVersionUID = 0L;
    // Use LinkerCrossRoomUpdateContent.newBuilder() to construct.
    /**
     * Constant <code>DEFAULT_INSTANCE</code>
     */
    private static final cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCrossRoomUpdateContent DEFAULT_INSTANCE;
    /**
     * Constant <code>PARSER</code>
     */
    private static final com.google.protobuf.Parser<LinkerCrossRoomUpdateContent>
            PARSER = new com.google.protobuf.AbstractParser<LinkerCrossRoomUpdateContent>() {
        @java.lang.Override
        public LinkerCrossRoomUpdateContent parsePartialFrom(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return new LinkerCrossRoomUpdateContent(input, extensionRegistry);
        }
    };

    static {
        DEFAULT_INSTANCE = new cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCrossRoomUpdateContent();
    }

    private byte memoizedIsInitialized = -1;

    /**
     * <p>Constructor for LinkerCrossRoomUpdateContent.</p>
     *
     * @param builder a {@link com.google.protobuf.GeneratedMessageV3.Builder} object
     */
    private LinkerCrossRoomUpdateContent(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
        super(builder);
    }

    /**
     * <p>Constructor for LinkerCrossRoomUpdateContent.</p>
     */
    private LinkerCrossRoomUpdateContent() {
    }

    /**
     * <p>Constructor for LinkerCrossRoomUpdateContent.</p>
     *
     * @param input             a {@link com.google.protobuf.CodedInputStream} object
     * @param extensionRegistry a {@link com.google.protobuf.ExtensionRegistryLite} object
     * @throws com.google.protobuf.InvalidProtocolBufferException if any.
     */
    private LinkerCrossRoomUpdateContent(
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

    /**
     * <p>getDescriptor.</p>
     *
     * @return a {@link com.google.protobuf.Descriptors.Descriptor} object
     */
    public static final com.google.protobuf.Descriptors.Descriptor
    getDescriptor() {
        return cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCrossRoomUpdateContentOuterClass.internal_static_LinkerCrossRoomUpdateContent_descriptor;
    }

    /**
     * <p>parseFrom.</p>
     *
     * @param data a {@link java.nio.ByteBuffer} object
     * @return a {@link cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCrossRoomUpdateContent} object
     * @throws com.google.protobuf.InvalidProtocolBufferException if any.
     */
    public static cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCrossRoomUpdateContent parseFrom(
            java.nio.ByteBuffer data)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    /**
     * <p>parseFrom.</p>
     *
     * @param data              a {@link java.nio.ByteBuffer} object
     * @param extensionRegistry a {@link com.google.protobuf.ExtensionRegistryLite} object
     * @return a {@link cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCrossRoomUpdateContent} object
     * @throws com.google.protobuf.InvalidProtocolBufferException if any.
     */
    public static cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCrossRoomUpdateContent parseFrom(
            java.nio.ByteBuffer data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    /**
     * <p>parseFrom.</p>
     *
     * @param data a {@link com.google.protobuf.ByteString} object
     * @return a {@link cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCrossRoomUpdateContent} object
     * @throws com.google.protobuf.InvalidProtocolBufferException if any.
     */
    public static cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCrossRoomUpdateContent parseFrom(
            com.google.protobuf.ByteString data)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    /**
     * <p>parseFrom.</p>
     *
     * @param data              a {@link com.google.protobuf.ByteString} object
     * @param extensionRegistry a {@link com.google.protobuf.ExtensionRegistryLite} object
     * @return a {@link cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCrossRoomUpdateContent} object
     * @throws com.google.protobuf.InvalidProtocolBufferException if any.
     */
    public static cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCrossRoomUpdateContent parseFrom(
            com.google.protobuf.ByteString data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    /**
     * <p>parseFrom.</p>
     *
     * @param data an array of {@link byte} objects
     * @return a {@link cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCrossRoomUpdateContent} object
     * @throws com.google.protobuf.InvalidProtocolBufferException if any.
     */
    public static cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCrossRoomUpdateContent parseFrom(byte[] data)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    /**
     * <p>parseFrom.</p>
     *
     * @param data              an array of {@link byte} objects
     * @param extensionRegistry a {@link com.google.protobuf.ExtensionRegistryLite} object
     * @return a {@link cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCrossRoomUpdateContent} object
     * @throws com.google.protobuf.InvalidProtocolBufferException if any.
     */
    public static cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCrossRoomUpdateContent parseFrom(
            byte[] data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    /**
     * <p>parseFrom.</p>
     *
     * @param input a {@link java.io.InputStream} object
     * @return a {@link cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCrossRoomUpdateContent} object
     * @throws java.io.IOException if any.
     */
    public static cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCrossRoomUpdateContent parseFrom(java.io.InputStream input)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseWithIOException(PARSER, input);
    }

    /**
     * <p>parseFrom.</p>
     *
     * @param input             a {@link java.io.InputStream} object
     * @param extensionRegistry a {@link com.google.protobuf.ExtensionRegistryLite} object
     * @return a {@link cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCrossRoomUpdateContent} object
     * @throws java.io.IOException if any.
     */
    public static cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCrossRoomUpdateContent parseFrom(
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
     * @return a {@link cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCrossRoomUpdateContent} object
     * @throws java.io.IOException if any.
     */
    public static cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCrossRoomUpdateContent parseDelimitedFrom(java.io.InputStream input)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseDelimitedWithIOException(PARSER, input);
    }

    /**
     * <p>parseDelimitedFrom.</p>
     *
     * @param input             a {@link java.io.InputStream} object
     * @param extensionRegistry a {@link com.google.protobuf.ExtensionRegistryLite} object
     * @return a {@link cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCrossRoomUpdateContent} object
     * @throws java.io.IOException if any.
     */
    public static cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCrossRoomUpdateContent parseDelimitedFrom(
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
     * @return a {@link cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCrossRoomUpdateContent} object
     * @throws java.io.IOException if any.
     */
    public static cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCrossRoomUpdateContent parseFrom(
            com.google.protobuf.CodedInputStream input)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseWithIOException(PARSER, input);
    }

    /**
     * <p>parseFrom.</p>
     *
     * @param input             a {@link com.google.protobuf.CodedInputStream} object
     * @param extensionRegistry a {@link com.google.protobuf.ExtensionRegistryLite} object
     * @return a {@link cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCrossRoomUpdateContent} object
     * @throws java.io.IOException if any.
     */
    public static cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCrossRoomUpdateContent parseFrom(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseWithIOException(PARSER, input, extensionRegistry);
    }

    /**
     * <p>newBuilder.</p>
     *
     * @return a {@link cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCrossRoomUpdateContent.Builder} object
     */
    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    /**
     * <p>newBuilder.</p>
     *
     * @param prototype a {@link cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCrossRoomUpdateContent} object
     * @return a {@link cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCrossRoomUpdateContent.Builder} object
     */
    public static Builder newBuilder(cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCrossRoomUpdateContent prototype) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }

    /**
     * <p>getDefaultInstance.</p>
     *
     * @return a {@link cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCrossRoomUpdateContent} object
     */
    public static cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCrossRoomUpdateContent getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /**
     * <p>parser.</p>
     *
     * @return a {@link com.google.protobuf.Parser} object
     */
    public static com.google.protobuf.Parser<LinkerCrossRoomUpdateContent> parser() {
        return PARSER;
    }

    /**
     * {@inheritDoc}
     */
    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(
            UnusedPrivateParameter unused) {
        return new LinkerCrossRoomUpdateContent();
    }

    /**
     * {@inheritDoc}
     */
    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
        return this.unknownFields;
    }

    /**
     * {@inheritDoc}
     */
    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
    internalGetFieldAccessorTable() {
        return cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCrossRoomUpdateContentOuterClass.internal_static_LinkerCrossRoomUpdateContent_fieldAccessorTable
                .ensureFieldAccessorsInitialized(
                        cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCrossRoomUpdateContent.class, cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCrossRoomUpdateContent.Builder.class);
    }

    /**
     * {@inheritDoc}
     */
    @java.lang.Override
    public final boolean isInitialized() {
        byte isInitialized = memoizedIsInitialized;
        if (isInitialized == 1) return true;
        if (isInitialized == 0) return false;

        memoizedIsInitialized = 1;
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @java.lang.Override
    public void writeTo(com.google.protobuf.CodedOutputStream output)
            throws java.io.IOException {
        unknownFields.writeTo(output);
    }

    /**
     * {@inheritDoc}
     */
    @java.lang.Override
    public int getSerializedSize() {
        int size = memoizedSize;
        if (size != -1) return size;

        size = 0;
        size += unknownFields.getSerializedSize();
        memoizedSize = size;
        return size;
    }

    /**
     * {@inheritDoc}
     */
    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCrossRoomUpdateContent)) {
            return super.equals(obj);
        }
        cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCrossRoomUpdateContent other = (cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCrossRoomUpdateContent) obj;

        if (!unknownFields.equals(other.unknownFields)) return false;
        return true;
    }

    // @@protoc_insertion_point(class_scope:LinkerCrossRoomUpdateContent)

    /**
     * {@inheritDoc}
     */
    @java.lang.Override
    public int hashCode() {
        if (memoizedHashCode != 0) {
            return memoizedHashCode;
        }
        int hash = 41;
        hash = (19 * hash) + getDescriptor().hashCode();
        hash = (29 * hash) + unknownFields.hashCode();
        memoizedHashCode = hash;
        return hash;
    }

    /**
     * {@inheritDoc}
     */
    @java.lang.Override
    public Builder newBuilderForType() {
        return newBuilder();
    }

    /**
     * {@inheritDoc}
     */
    @java.lang.Override
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE
                ? new Builder() : new Builder().mergeFrom(this);
    }

    /**
     * {@inheritDoc}
     */
    @java.lang.Override
    protected Builder newBuilderForType(
            com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        Builder builder = new Builder(parent);
        return builder;
    }

    /**
     * {@inheritDoc}
     */
    @java.lang.Override
    public com.google.protobuf.Parser<LinkerCrossRoomUpdateContent> getParserForType() {
        return PARSER;
    }

    /**
     * {@inheritDoc}
     */
    @java.lang.Override
    public cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCrossRoomUpdateContent getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    /**
     * <pre>
     * 更新时间 : 2023-01-11
     * </pre>
     * <p>
     * Protobuf type {@code LinkerCrossRoomUpdateContent}
     */
    public static final class Builder extends
            com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
            // @@protoc_insertion_point(builder_implements:LinkerCrossRoomUpdateContent)
            cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCrossRoomUpdateContentOrBuilder {
        // Construct using cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCrossRoomUpdateContent.newBuilder()
        private Builder() {
            maybeForceBuilderInitialization();
        }

        private Builder(
                com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
            super(parent);
            maybeForceBuilderInitialization();
        }

        public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
            return cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCrossRoomUpdateContentOuterClass.internal_static_LinkerCrossRoomUpdateContent_descriptor;
        }

        @java.lang.Override
        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
            return cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCrossRoomUpdateContentOuterClass.internal_static_LinkerCrossRoomUpdateContent_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCrossRoomUpdateContent.class, cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCrossRoomUpdateContent.Builder.class);
        }

        private void maybeForceBuilderInitialization() {
            if (com.google.protobuf.GeneratedMessageV3
                    .alwaysUseFieldBuilders) {
            }
        }

        @java.lang.Override
        public Builder clear() {
            super.clear();
            return this;
        }

        @java.lang.Override
        public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
            return cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCrossRoomUpdateContentOuterClass.internal_static_LinkerCrossRoomUpdateContent_descriptor;
        }

        @java.lang.Override
        public cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCrossRoomUpdateContent getDefaultInstanceForType() {
            return cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCrossRoomUpdateContent.getDefaultInstance();
        }

        @java.lang.Override
        public cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCrossRoomUpdateContent build() {
            cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCrossRoomUpdateContent result = buildPartial();
            if (!result.isInitialized()) {
                throw newUninitializedMessageException(result);
            }
            return result;
        }

        @java.lang.Override
        public cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCrossRoomUpdateContent buildPartial() {
            cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCrossRoomUpdateContent result = new cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCrossRoomUpdateContent(this);
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
            if (other instanceof cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCrossRoomUpdateContent) {
                return mergeFrom((cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCrossRoomUpdateContent) other);
            } else {
                super.mergeFrom(other);
                return this;
            }
        }

        public Builder mergeFrom(cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCrossRoomUpdateContent other) {
            if (other == cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCrossRoomUpdateContent.getDefaultInstance())
                return this;
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
            cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCrossRoomUpdateContent parsedMessage = null;
            try {
                parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
            } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                parsedMessage = (cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCrossRoomUpdateContent) e.getUnfinishedMessage();
                throw e.unwrapIOException();
            } finally {
                if (parsedMessage != null) {
                    mergeFrom(parsedMessage);
                }
            }
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


        // @@protoc_insertion_point(builder_scope:LinkerCrossRoomUpdateContent)
    }

}


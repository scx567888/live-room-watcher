// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: webcast/im/LinkerCreateContent.proto

package cool.scx.live_room_watcher.douyin.proto_entity.webcast.im;

/**
 * <pre>
 * 更新时间 : 2023-01-11
 * </pre>
 * <p>
 * Protobuf type {@code LinkerCreateContent}
 *
 * @author scx567888
 * @version $Id: $Id
 */
public final class LinkerCreateContent extends
        com.google.protobuf.GeneratedMessageV3 implements
        // @@protoc_insertion_point(message_implements:LinkerCreateContent)
        LinkerCreateContentOrBuilder {
    /**
     * Constant <code>serialVersionUID=0L</code>
     */
    private static final long serialVersionUID = 0L;
    // Use LinkerCreateContent.newBuilder() to construct.
    /**
     * Constant <code>DEFAULT_INSTANCE</code>
     */
    private static final cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCreateContent DEFAULT_INSTANCE;
    /**
     * Constant <code>PARSER</code>
     */
    private static final com.google.protobuf.Parser<LinkerCreateContent>
            PARSER = new com.google.protobuf.AbstractParser<LinkerCreateContent>() {
        @java.lang.Override
        public LinkerCreateContent parsePartialFrom(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return new LinkerCreateContent(input, extensionRegistry);
        }
    };

    static {
        DEFAULT_INSTANCE = new cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCreateContent();
    }

    private byte memoizedIsInitialized = -1;

    /**
     * <p>Constructor for LinkerCreateContent.</p>
     *
     * @param builder a {@link com.google.protobuf.GeneratedMessageV3.Builder} object
     */
    private LinkerCreateContent(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
        super(builder);
    }

    /**
     * <p>Constructor for LinkerCreateContent.</p>
     */
    private LinkerCreateContent() {
    }

    /**
     * <p>Constructor for LinkerCreateContent.</p>
     *
     * @param input             a {@link com.google.protobuf.CodedInputStream} object
     * @param extensionRegistry a {@link com.google.protobuf.ExtensionRegistryLite} object
     * @throws com.google.protobuf.InvalidProtocolBufferException if any.
     */
    private LinkerCreateContent(
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
        return cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCreateContentOuterClass.internal_static_LinkerCreateContent_descriptor;
    }

    /**
     * <p>parseFrom.</p>
     *
     * @param data a {@link java.nio.ByteBuffer} object
     * @return a {@link cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCreateContent} object
     * @throws com.google.protobuf.InvalidProtocolBufferException if any.
     */
    public static cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCreateContent parseFrom(
            java.nio.ByteBuffer data)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    /**
     * <p>parseFrom.</p>
     *
     * @param data              a {@link java.nio.ByteBuffer} object
     * @param extensionRegistry a {@link com.google.protobuf.ExtensionRegistryLite} object
     * @return a {@link cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCreateContent} object
     * @throws com.google.protobuf.InvalidProtocolBufferException if any.
     */
    public static cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCreateContent parseFrom(
            java.nio.ByteBuffer data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    /**
     * <p>parseFrom.</p>
     *
     * @param data a {@link com.google.protobuf.ByteString} object
     * @return a {@link cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCreateContent} object
     * @throws com.google.protobuf.InvalidProtocolBufferException if any.
     */
    public static cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCreateContent parseFrom(
            com.google.protobuf.ByteString data)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    /**
     * <p>parseFrom.</p>
     *
     * @param data              a {@link com.google.protobuf.ByteString} object
     * @param extensionRegistry a {@link com.google.protobuf.ExtensionRegistryLite} object
     * @return a {@link cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCreateContent} object
     * @throws com.google.protobuf.InvalidProtocolBufferException if any.
     */
    public static cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCreateContent parseFrom(
            com.google.protobuf.ByteString data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    /**
     * <p>parseFrom.</p>
     *
     * @param data an array of {@link byte} objects
     * @return a {@link cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCreateContent} object
     * @throws com.google.protobuf.InvalidProtocolBufferException if any.
     */
    public static cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCreateContent parseFrom(byte[] data)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    /**
     * <p>parseFrom.</p>
     *
     * @param data              an array of {@link byte} objects
     * @param extensionRegistry a {@link com.google.protobuf.ExtensionRegistryLite} object
     * @return a {@link cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCreateContent} object
     * @throws com.google.protobuf.InvalidProtocolBufferException if any.
     */
    public static cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCreateContent parseFrom(
            byte[] data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    /**
     * <p>parseFrom.</p>
     *
     * @param input a {@link java.io.InputStream} object
     * @return a {@link cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCreateContent} object
     * @throws java.io.IOException if any.
     */
    public static cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCreateContent parseFrom(java.io.InputStream input)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseWithIOException(PARSER, input);
    }

    /**
     * <p>parseFrom.</p>
     *
     * @param input             a {@link java.io.InputStream} object
     * @param extensionRegistry a {@link com.google.protobuf.ExtensionRegistryLite} object
     * @return a {@link cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCreateContent} object
     * @throws java.io.IOException if any.
     */
    public static cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCreateContent parseFrom(
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
     * @return a {@link cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCreateContent} object
     * @throws java.io.IOException if any.
     */
    public static cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCreateContent parseDelimitedFrom(java.io.InputStream input)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseDelimitedWithIOException(PARSER, input);
    }

    /**
     * <p>parseDelimitedFrom.</p>
     *
     * @param input             a {@link java.io.InputStream} object
     * @param extensionRegistry a {@link com.google.protobuf.ExtensionRegistryLite} object
     * @return a {@link cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCreateContent} object
     * @throws java.io.IOException if any.
     */
    public static cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCreateContent parseDelimitedFrom(
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
     * @return a {@link cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCreateContent} object
     * @throws java.io.IOException if any.
     */
    public static cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCreateContent parseFrom(
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
     * @return a {@link cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCreateContent} object
     * @throws java.io.IOException if any.
     */
    public static cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCreateContent parseFrom(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseWithIOException(PARSER, input, extensionRegistry);
    }

    /**
     * <p>newBuilder.</p>
     *
     * @return a {@link cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCreateContent.Builder} object
     */
    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    /**
     * <p>newBuilder.</p>
     *
     * @param prototype a {@link cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCreateContent} object
     * @return a {@link cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCreateContent.Builder} object
     */
    public static Builder newBuilder(cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCreateContent prototype) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }

    /**
     * <p>getDefaultInstance.</p>
     *
     * @return a {@link cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCreateContent} object
     */
    public static cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCreateContent getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /**
     * <p>parser.</p>
     *
     * @return a {@link com.google.protobuf.Parser} object
     */
    public static com.google.protobuf.Parser<LinkerCreateContent> parser() {
        return PARSER;
    }

    /**
     * {@inheritDoc}
     */
    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(
            UnusedPrivateParameter unused) {
        return new LinkerCreateContent();
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
        return cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCreateContentOuterClass.internal_static_LinkerCreateContent_fieldAccessorTable
                .ensureFieldAccessorsInitialized(
                        cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCreateContent.class, cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCreateContent.Builder.class);
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
        if (!(obj instanceof cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCreateContent)) {
            return super.equals(obj);
        }
        cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCreateContent other = (cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCreateContent) obj;

        if (!unknownFields.equals(other.unknownFields)) return false;
        return true;
    }

    // @@protoc_insertion_point(class_scope:LinkerCreateContent)

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
    public com.google.protobuf.Parser<LinkerCreateContent> getParserForType() {
        return PARSER;
    }

    /**
     * {@inheritDoc}
     */
    @java.lang.Override
    public cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCreateContent getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    /**
     * <pre>
     * 更新时间 : 2023-01-11
     * </pre>
     * <p>
     * Protobuf type {@code LinkerCreateContent}
     */
    public static final class Builder extends
            com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
            // @@protoc_insertion_point(builder_implements:LinkerCreateContent)
            cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCreateContentOrBuilder {
        // Construct using cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCreateContent.newBuilder()
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
            return cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCreateContentOuterClass.internal_static_LinkerCreateContent_descriptor;
        }

        @java.lang.Override
        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
            return cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCreateContentOuterClass.internal_static_LinkerCreateContent_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCreateContent.class, cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCreateContent.Builder.class);
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
            return cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCreateContentOuterClass.internal_static_LinkerCreateContent_descriptor;
        }

        @java.lang.Override
        public cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCreateContent getDefaultInstanceForType() {
            return cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCreateContent.getDefaultInstance();
        }

        @java.lang.Override
        public cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCreateContent build() {
            cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCreateContent result = buildPartial();
            if (!result.isInitialized()) {
                throw newUninitializedMessageException(result);
            }
            return result;
        }

        @java.lang.Override
        public cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCreateContent buildPartial() {
            cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCreateContent result = new cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCreateContent(this);
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
            if (other instanceof cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCreateContent) {
                return mergeFrom((cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCreateContent) other);
            } else {
                super.mergeFrom(other);
                return this;
            }
        }

        public Builder mergeFrom(cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCreateContent other) {
            if (other == cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCreateContent.getDefaultInstance())
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
            cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCreateContent parsedMessage = null;
            try {
                parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
            } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                parsedMessage = (cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.LinkerCreateContent) e.getUnfinishedMessage();
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


        // @@protoc_insertion_point(builder_scope:LinkerCreateContent)
    }

}


// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: webcast/im/ActionType.proto

package cool.scx.live_room_watcher.douyin.proto_entity.webcast.im;

/**
 * <pre>
 * 更新时间 : 2023-01-10
 * </pre>
 * <p>
 * Protobuf enum {@code ActionType}
 *
 * @author scx567888
 * @version $Id: $Id
 */
public enum ActionType
        implements com.google.protobuf.ProtocolMessageEnum {
    /**
     * <code>DEFAULT = 0;</code>
     */
    DEFAULT(0),
    /**
     * <code>REFRESH_BANNER = 1;</code>
     */
    REFRESH_BANNER(1),
    UNRECOGNIZED(-1),
    ;

    /**
     * <code>DEFAULT = 0;</code>
     */
    public static final int DEFAULT_VALUE = 0;
    /**
     * <code>REFRESH_BANNER = 1;</code>
     */
    public static final int REFRESH_BANNER_VALUE = 1;
    /**
     * Constant <code>internalValueMap</code>
     */
    private static final com.google.protobuf.Internal.EnumLiteMap<
            ActionType> internalValueMap =
            new com.google.protobuf.Internal.EnumLiteMap<ActionType>() {
                public ActionType findValueByNumber(int number) {
                    return ActionType.forNumber(number);
                }
            };
    /**
     * Constant <code>VALUES</code>
     */
    private static final ActionType[] VALUES = values();
    /**
     * <p>Constructor for ActionType.</p>
     *
     * @param value a int
     */
    private final int value;

    private ActionType(int value) {
        this.value = value;
    }

    /**
     * <p>valueOf.</p>
     *
     * @param value The numeric wire value of the corresponding enum entry.
     * @return The enum associated with the given numeric wire value.
     * @deprecated Use {@link #forNumber(int)} instead.
     */
    @java.lang.Deprecated
    public static ActionType valueOf(int value) {
        return forNumber(value);
    }

    /**
     * <p>forNumber.</p>
     *
     * @param value The numeric wire value of the corresponding enum entry.
     * @return The enum associated with the given numeric wire value.
     */
    public static ActionType forNumber(int value) {
        switch (value) {
            case 0:
                return DEFAULT;
            case 1:
                return REFRESH_BANNER;
            default:
                return null;
        }
    }

    /**
     * <p>internalGetValueMap.</p>
     *
     * @return a {@link com.google.protobuf.Internal.EnumLiteMap} object
     */
    public static com.google.protobuf.Internal.EnumLiteMap<ActionType>
    internalGetValueMap() {
        return internalValueMap;
    }

    /**
     * <p>getDescriptor.</p>
     *
     * @return a {@link com.google.protobuf.Descriptors.EnumDescriptor} object
     */
    public static final com.google.protobuf.Descriptors.EnumDescriptor
    getDescriptor() {
        return cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.ActionTypeOuterClass.getDescriptor().getEnumTypes().get(0);
    }

    /**
     * <p>valueOf.</p>
     *
     * @param desc a {@link com.google.protobuf.Descriptors.EnumValueDescriptor} object
     * @return a {@link cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.ActionType} object
     */
    public static ActionType valueOf(
            com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
        if (desc.getType() != getDescriptor()) {
            throw new java.lang.IllegalArgumentException(
                    "EnumValueDescriptor is not for this type.");
        }
        if (desc.getIndex() == -1) {
            return UNRECOGNIZED;
        }
        return VALUES[desc.getIndex()];
    }

    /**
     * <p>getNumber.</p>
     *
     * @return a int
     */
    public final int getNumber() {
        if (this == UNRECOGNIZED) {
            throw new java.lang.IllegalArgumentException(
                    "Can't get the number of an unknown enum value.");
        }
        return value;
    }

    /**
     * <p>getValueDescriptor.</p>
     *
     * @return a {@link com.google.protobuf.Descriptors.EnumValueDescriptor} object
     */
    public final com.google.protobuf.Descriptors.EnumValueDescriptor
    getValueDescriptor() {
        if (this == UNRECOGNIZED) {
            throw new java.lang.IllegalStateException(
                    "Can't get the descriptor of an unrecognized enum value.");
        }
        return getDescriptor().getValues().get(ordinal());
    }

    /**
     * <p>getDescriptorForType.</p>
     *
     * @return a {@link com.google.protobuf.Descriptors.EnumDescriptor} object
     */
    public final com.google.protobuf.Descriptors.EnumDescriptor
    getDescriptorForType() {
        return getDescriptor();
    }

    // @@protoc_insertion_point(enum_scope:ActionType)
}


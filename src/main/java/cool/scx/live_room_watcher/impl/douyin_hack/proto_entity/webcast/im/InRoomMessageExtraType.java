// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: douyin_hack/webcast/im/InRoomMessageExtraType.proto

// Protobuf Java Version: 4.26.1
package cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im;

/**
 * <pre>
 * 更新时间 : 2023-01-11
 * </pre>
 *
 * Protobuf enum {@code InRoomMessageExtraType}
 */
public enum InRoomMessageExtraType
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <code>ITEMDATA = 0;</code>
   */
  ITEMDATA(0),
  /**
   * <code>ITEMADD = 1;</code>
   */
  ITEMADD(1),
  /**
   * <code>ITEMDELETE = 2;</code>
   */
  ITEMDELETE(2),
  UNRECOGNIZED(-1),
  ;

  static {
    com.google.protobuf.RuntimeVersion.validateProtobufGencodeVersion(
      com.google.protobuf.RuntimeVersion.RuntimeDomain.PUBLIC,
      /* major= */ 4,
      /* minor= */ 26,
      /* patch= */ 1,
      /* suffix= */ "",
      InRoomMessageExtraType.class.getName());
  }
  /**
   * <code>ITEMDATA = 0;</code>
   */
  public static final int ITEMDATA_VALUE = 0;
  /**
   * <code>ITEMADD = 1;</code>
   */
  public static final int ITEMADD_VALUE = 1;
  /**
   * <code>ITEMDELETE = 2;</code>
   */
  public static final int ITEMDELETE_VALUE = 2;


  public final int getNumber() {
    if (this == UNRECOGNIZED) {
      throw new java.lang.IllegalArgumentException(
          "Can't get the number of an unknown enum value.");
    }
    return value;
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   * @deprecated Use {@link #forNumber(int)} instead.
   */
  @java.lang.Deprecated
  public static InRoomMessageExtraType valueOf(int value) {
    return forNumber(value);
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   */
  public static InRoomMessageExtraType forNumber(int value) {
    switch (value) {
      case 0: return ITEMDATA;
      case 1: return ITEMADD;
      case 2: return ITEMDELETE;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<InRoomMessageExtraType>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      InRoomMessageExtraType> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<InRoomMessageExtraType>() {
          public InRoomMessageExtraType findValueByNumber(int number) {
            return InRoomMessageExtraType.forNumber(number);
          }
        };

  public final com.google.protobuf.Descriptors.EnumValueDescriptor
      getValueDescriptor() {
    if (this == UNRECOGNIZED) {
      throw new java.lang.IllegalStateException(
          "Can't get the descriptor of an unrecognized enum value.");
    }
    return getDescriptor().getValues().get(ordinal());
  }
  public final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptorForType() {
    return getDescriptor();
  }
  public static final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptor() {
    return cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.InRoomMessageExtraTypeOuterClass.getDescriptor().getEnumTypes().get(0);
  }

  private static final InRoomMessageExtraType[] VALUES = values();

  public static InRoomMessageExtraType valueOf(
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

  private final int value;

  private InRoomMessageExtraType(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:InRoomMessageExtraType)
}


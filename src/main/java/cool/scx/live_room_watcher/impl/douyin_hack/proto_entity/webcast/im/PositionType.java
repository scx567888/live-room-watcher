// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: douyin_hack/webcast/im/PositionType.proto

// Protobuf Java Version: 3.25.2
package cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im;

/**
 * <pre>
 *更新时间 : 2023-01-11
 * </pre>
 *
 * Protobuf enum {@code PositionType}
 */
public enum PositionType
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <code>UNDEFINED = 0;</code>
   */
  UNDEFINED(0),
  /**
   * <code>BOTTOM_RIGHT = 1;</code>
   */
  BOTTOM_RIGHT(1),
  /**
   * <code>TOP_RIGHT = 2;</code>
   */
  TOP_RIGHT(2),
  /**
   * <code>TOP_LEFT = 3;</code>
   */
  TOP_LEFT(3),
  /**
   * <code>BOTTOM_LEFT = 4;</code>
   */
  BOTTOM_LEFT(4),
  /**
   * <code>ACTIVITY_TOP_RIGHT = 5;</code>
   */
  ACTIVITY_TOP_RIGHT(5),
  /**
   * <code>ACTIVITY_VS_INTERACTIVE = 6;</code>
   */
  ACTIVITY_VS_INTERACTIVE(6),
  /**
   * <code>ACTIVITY_INTERACTIVE = 7;</code>
   */
  ACTIVITY_INTERACTIVE(7),
  /**
   * <code>ACTIVITY_VS_BOTTOM_RIGHT = 8;</code>
   */
  ACTIVITY_VS_BOTTOM_RIGHT(8),
  UNRECOGNIZED(-1),
  ;

  /**
   * <code>UNDEFINED = 0;</code>
   */
  public static final int UNDEFINED_VALUE = 0;
  /**
   * <code>BOTTOM_RIGHT = 1;</code>
   */
  public static final int BOTTOM_RIGHT_VALUE = 1;
  /**
   * <code>TOP_RIGHT = 2;</code>
   */
  public static final int TOP_RIGHT_VALUE = 2;
  /**
   * <code>TOP_LEFT = 3;</code>
   */
  public static final int TOP_LEFT_VALUE = 3;
  /**
   * <code>BOTTOM_LEFT = 4;</code>
   */
  public static final int BOTTOM_LEFT_VALUE = 4;
  /**
   * <code>ACTIVITY_TOP_RIGHT = 5;</code>
   */
  public static final int ACTIVITY_TOP_RIGHT_VALUE = 5;
  /**
   * <code>ACTIVITY_VS_INTERACTIVE = 6;</code>
   */
  public static final int ACTIVITY_VS_INTERACTIVE_VALUE = 6;
  /**
   * <code>ACTIVITY_INTERACTIVE = 7;</code>
   */
  public static final int ACTIVITY_INTERACTIVE_VALUE = 7;
  /**
   * <code>ACTIVITY_VS_BOTTOM_RIGHT = 8;</code>
   */
  public static final int ACTIVITY_VS_BOTTOM_RIGHT_VALUE = 8;


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
  public static PositionType valueOf(int value) {
    return forNumber(value);
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   */
  public static PositionType forNumber(int value) {
    switch (value) {
      case 0: return UNDEFINED;
      case 1: return BOTTOM_RIGHT;
      case 2: return TOP_RIGHT;
      case 3: return TOP_LEFT;
      case 4: return BOTTOM_LEFT;
      case 5: return ACTIVITY_TOP_RIGHT;
      case 6: return ACTIVITY_VS_INTERACTIVE;
      case 7: return ACTIVITY_INTERACTIVE;
      case 8: return ACTIVITY_VS_BOTTOM_RIGHT;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<PositionType>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      PositionType> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<PositionType>() {
          public PositionType findValueByNumber(int number) {
            return PositionType.forNumber(number);
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
    return cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.PositionTypeOuterClass.getDescriptor().getEnumTypes().get(0);
  }

  private static final PositionType[] VALUES = values();

  public static PositionType valueOf(
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

  private PositionType(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:PositionType)
}


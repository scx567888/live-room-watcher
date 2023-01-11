// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: webcast/im/Message.proto

package cool.scx.live_room_watcher.douyin.proto_entity.webcast.im;

/**
 * <p>MessageOrBuilder interface.</p>
 *
 * @author scx567888
 * @version $Id: $Id
 */
public interface MessageOrBuilder extends
        // @@protoc_insertion_point(interface_extends:Message)
        com.google.protobuf.MessageOrBuilder {

    /**
     * <code>string method = 1;</code>
     *
     * @return The method.
     */
    java.lang.String getMethod();

    /**
     * <code>string method = 1;</code>
     *
     * @return The bytes for method.
     */
    com.google.protobuf.ByteString
    getMethodBytes();

    /**
     * <code>bytes payload = 2;</code>
     *
     * @return The payload.
     */
    com.google.protobuf.ByteString getPayload();

    /**
     * <code>int64 msgId = 3;</code>
     *
     * @return The msgId.
     */
    long getMsgId();

    /**
     * <code>int32 msgType = 4;</code>
     *
     * @return The msgType.
     */
    int getMsgType();

    /**
     * <code>int64 offset = 5;</code>
     *
     * @return The offset.
     */
    long getOffset();

    /**
     * <code>bool needWrdsStore = 6;</code>
     *
     * @return The needWrdsStore.
     */
    boolean getNeedWrdsStore();

    /**
     * <code>int64 wrdsVersion = 7;</code>
     *
     * @return The wrdsVersion.
     */
    long getWrdsVersion();

    /**
     * <code>string wrdsSubKey = 8;</code>
     *
     * @return The wrdsSubKey.
     */
    java.lang.String getWrdsSubKey();

    /**
     * <code>string wrdsSubKey = 8;</code>
     *
     * @return The bytes for wrdsSubKey.
     */
    com.google.protobuf.ByteString
    getWrdsSubKeyBytes();

    /**
     * <code>map&lt;string, string&gt; messageExtraMap = 9;</code>
     *
     * @return a int
     */
    int getMessageExtraMapCount();

    /**
     * <code>map&lt;string, string&gt; messageExtraMap = 9;</code>
     *
     * @param key a {@link java.lang.String} object
     * @return a boolean
     */
    boolean containsMessageExtraMap(
            java.lang.String key);

    /**
     * Use {@link #getMessageExtraMapMap()} instead.
     *
     * @return a {@link java.util.Map} object
     */
    @java.lang.Deprecated
    java.util.Map<java.lang.String, java.lang.String>
    getMessageExtraMap();

    /**
     * <code>map&lt;string, string&gt; messageExtraMap = 9;</code>
     *
     * @return a {@link java.util.Map} object
     */
    java.util.Map<java.lang.String, java.lang.String>
    getMessageExtraMapMap();

    /**
     * <code>map&lt;string, string&gt; messageExtraMap = 9;</code>
     *
     * @param key          a {@link java.lang.String} object
     * @param defaultValue a {@link java.lang.String} object
     * @return a {@link java.lang.String} object
     */
    java.lang.String getMessageExtraMapOrDefault(
            java.lang.String key,
            java.lang.String defaultValue);

    /**
     * <code>map&lt;string, string&gt; messageExtraMap = 9;</code>
     *
     * @param key a {@link java.lang.String} object
     * @return a {@link java.lang.String} object
     */
    java.lang.String getMessageExtraMapOrThrow(
            java.lang.String key);
}

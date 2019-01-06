package com.ljheee.chat.model;

/**
 */
public class ChatRoomRequest {

    private String fromName;//发送人
    private String chatValue; // 内容
    private String toUserId; // 接收人

    public ChatRoomRequest() {

    }

    public ChatRoomRequest(String fromName, String chatValue, String toUserId) {
        this.fromName = fromName;
        this.chatValue = chatValue;
        this.toUserId = toUserId;
    }

    public String getFromName() {
        return fromName;
    }

    public void setFromName(String fromName) {
        this.fromName = fromName;
    }

    public String getChatValue() {
        return chatValue;
    }

    public void setChatValue(String chatValue) {
        this.chatValue = chatValue;
    }

    public String getToUserId() {
        return toUserId;
    }

    public void setToUserId(String toUserId) {
        this.toUserId = toUserId;
    }
}

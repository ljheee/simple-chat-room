package com.ljheee.chat.model;

/**
 * Created by lijianhua04 on 2019/1/5.
 */
public class ChatRoomResponse {

    private String fromName;//发送人
    private String chatValue; // 内容



    public ChatRoomResponse() {

    }

    public ChatRoomResponse(String fromName, String chatValue) {
        this.fromName = fromName;
        this.chatValue = chatValue;
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

}

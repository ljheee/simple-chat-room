package com.ljheee.chat.controller;

import com.ljheee.chat.model.ChatRoomRequest;
import com.ljheee.chat.model.ChatRoomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

/**
 *  https://blog.csdn.net/liyongzhi1992/article/details/81221103
 */
@Controller
public class StompController {

    @Autowired
    private SimpMessagingTemplate template;

    //群发
    @MessageMapping("/massRequest")
    @SendTo("/mass/getResponse")//SendTo 发送至 Broker 下的指定订阅路径
    public ChatRoomResponse mass(ChatRoomRequest chatRoomRequest) {
        //方法用于群发测试
        System.out.println("name = " + chatRoomRequest.getFromName() + ",chatValue = " + chatRoomRequest.getChatValue());
        ChatRoomResponse response = new ChatRoomResponse();
        response.setFromName(chatRoomRequest.getFromName());
        response.setChatValue(chatRoomRequest.getChatValue());
        return response;
    }

    //单独聊天
    @MessageMapping("/aloneRequest")
    public ChatRoomResponse alone(ChatRoomRequest chatRoomRequest) {//参数ChatRoomRequest属性，要和前端发送请求body属性一致
        //方法用于一对一测试
        System.out.println("FromName = " + chatRoomRequest.getFromName() + ",chatValue = " + chatRoomRequest.getChatValue() + ",toUserId = " + chatRoomRequest.getToUserId());
        ChatRoomResponse response = new ChatRoomResponse();
        response.setFromName(chatRoomRequest.getFromName());
        response.setChatValue(chatRoomRequest.getChatValue());
        this.template.convertAndSendToUser(chatRoomRequest.getToUserId() + "", "/alone/getResponse", response);
        return response;
    }


}

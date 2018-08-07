package com.example.netty.lengthfieldbasedframedecoder.server;

import lombok.Data;

@Data
public class Message {
    //消息类型
    private byte type;

    //消息长度
    private int length;

    //消息体
    private String msgBody;

    public Message(byte type, int length, String msgBody) {
        this.type = type;
        this.length = length;
        this.msgBody = msgBody;
    }
}

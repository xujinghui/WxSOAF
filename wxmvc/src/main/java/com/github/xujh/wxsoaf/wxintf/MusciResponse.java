package com.github.xujh.wxsoaf.wxintf;

import com.github.xujh.wxsoaf.annotation.ResponseType;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;

@XStreamAlias("xml")
public class MusciResponse extends AbstractPushResponse {

    // @XStreamAlias("ToUserName")
    // private String toUserName;
    // @XStreamAlias("FromUserName")
    // private String fromUserName;
    // @XStreamAlias("CreateTime")
    // private String createTime;
    // @XStreamAlias("MsgType")
    // private String msgType;

    @XStreamAlias("Music")
    private Music music;

    @XStreamAlias("FuncFlag")
    private int funcFlag;

    public MusciResponse() {
        super(ResponseType.music);
    }

    // public String getToUserName() {
    // return toUserName;
    // }
    //
    // public void setToUserName(String toUserName) {
    // this.toUserName = toUserName;
    // }
    //
    // public String getFromUserName() {
    // return fromUserName;
    // }
    //
    // public void setFromUserName(String fromUserName) {
    // this.fromUserName = fromUserName;
    // }
    //
    // public String getCreateTime() {
    // return createTime;
    // }
    //
    // public void setCreateTime(String createTime) {
    // this.createTime = createTime;
    // }
    //
    // public String getMsgType() {
    // return msgType;
    // }
    //
    // public void setMsgType(String msgType) {
    // this.msgType = msgType;
    // }

    public Music getMusic() {
        return music;
    }

    public void setMusic(Music music) {
        this.music = music;
    }

    public int getFuncFlag() {
        return funcFlag;
    }

    public void setFuncFlag(int funcFlag) {
        this.funcFlag = funcFlag;
    }

}

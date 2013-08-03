/**
 * 
 */
package com.github.xujh.wxsoaf.wxintf;

import com.github.xujh.wxsoaf.annotation.RequestType;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @author stevenxu
 * 
 */
public abstract class AbstractPushRequest implements IPushRequest {
    @XStreamAlias("ToUserName")
    private String toUserName;
    @XStreamAlias("FromUserName")
    private String fromUserName;
    @XStreamAlias("CreateTime")
    private String createTime;
    @XStreamAlias("MsgType")
    private String msgType;

    public AbstractPushRequest(RequestType type) {
        this.msgType = type.name();
    }

    public String getToUserName() {
        return toUserName;
    }

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getFromUserName() {
        return fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    public String getCreateTime() {
        return createTime;
    }

    // @XStreamAlias("ToUserName")
    // private String toUserName;
    // @XStreamAlias("FromUserName")
    // private String fromUserName;
    // @XStreamAlias("CreateTime")
    // private String createTime;
    // @XStreamAlias("MsgType")
    // private String msgType;
    // @XStreamAlias("MsgId")
    // private String msgId;
    //
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
    //
    // public String getMsgId() {
    // return msgId;
    // }
    //
    // public void setMsgId(String msgId) {
    // this.msgId = msgId;
    // }

}

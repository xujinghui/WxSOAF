/**
 * 
 */
package com.github.xujh.wxsoaf.wxintf;

import com.github.xujh.wxsoaf.annotation.ResponseType;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @author stevenxu
 * 
 */
public abstract class AbstractPushResponse implements IPushResponse {
    @XStreamAlias("ToUserName")
    private String toUserName;
    @XStreamAlias("FromUserName")
    private String fromUserName;
    @XStreamAlias("CreateTime")
    private String createTime;
    @XStreamAlias("MsgType")
    private String msgType;

    public AbstractPushResponse(ResponseType type) {
        this.msgType = type.name();
    }

    public String getToUserName() {
        return toUserName;
    }

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
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

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getMsgType() {
        return msgType;
    }

}

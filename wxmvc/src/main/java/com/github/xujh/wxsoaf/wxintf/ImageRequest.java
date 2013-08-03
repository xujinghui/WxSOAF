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
@XStreamAlias("xml")
public class ImageRequest extends AbstractPushRequest {

    // @XStreamAlias("ToUserName")
    // private String toUserName;
    // @XStreamAlias("FromUserName")
    // private String fromUserName;
    // @XStreamAlias("CreateTime")
    // private String createTime;
    // @XStreamAlias("MsgType")
    // private String msgType;

    @XStreamAlias("PicUrl")
    private String picUrlt;

    @XStreamAlias("MsgId")
    private String msgId;

    public ImageRequest() {
        super(RequestType.image);
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public String getPicUrlt() {
        return picUrlt;
    }

    public void setPicUrlt(String picUrlt) {
        this.picUrlt = picUrlt;
    }

}

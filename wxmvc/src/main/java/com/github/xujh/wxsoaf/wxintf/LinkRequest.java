package com.github.xujh.wxsoaf.wxintf;

import com.github.xujh.wxsoaf.annotation.RequestType;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("xml")
public class LinkRequest extends AbstractPushRequest {
    // @XStreamAlias("ToUserName")
    // private String toUserName;
    // @XStreamAlias("FromUserName")
    // private String fromUserName;
    // @XStreamAlias("CreateTime")
    // private String createTime;
    // @XStreamAlias("MsgType")
    // private String msgType;

    @XStreamAlias("Title")
    private String title;
    @XStreamAlias("Description")
    private String description;
    @XStreamAlias("Url")
    private String url;
    
    public LinkRequest(){
        super(RequestType.link);
    }

    @XStreamAlias("MsgId")
    private String msgId;

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}

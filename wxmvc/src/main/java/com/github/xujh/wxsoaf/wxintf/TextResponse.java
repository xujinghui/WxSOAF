package com.github.xujh.wxsoaf.wxintf;

import com.github.xujh.wxsoaf.annotation.ResponseType;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("xml")
public class TextResponse extends AbstractPushResponse {

//    @XStreamAlias("ToUserName")
//    private String toUserName;
//    @XStreamAlias("FromUserName")
//    private String fromUserName;
//    @XStreamAlias("CreateTime")
//    private String createTime;
//    @XStreamAlias("MsgType")
//    private String msgType;

    @XStreamAlias("Content")
    private String content;

    @XStreamAlias("FuncFlag")
    private int funcFlag;

    public TextResponse() {
        super(ResponseType.text);
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getFuncFlag() {
        return funcFlag;
    }

    public void setFuncFlag(int funcFlag) {
        this.funcFlag = funcFlag;
    }

}

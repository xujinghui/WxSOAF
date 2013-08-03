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
public class TextRequest extends AbstractPushRequest {

    @XStreamAlias("Content")
    private String content;

    @XStreamAlias("MsgId")
    private String msgId;

    public TextRequest() {
        super(RequestType.text);
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }
}

package com.github.xujh.wxsoaf.wxintf;

import com.github.xujh.wxsoaf.annotation.RequestType;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("xml")
public class EventRequest extends AbstractPushRequest {
    // @XStreamAlias("ToUserName")
    // private String toUserName;
    // @XStreamAlias("FromUserName")
    // private String fromUserName;
    // @XStreamAlias("CreateTime")
    // private String createTime;
    // @XStreamAlias("MsgType")
    // private String msgType;
    @XStreamAlias("Event")
    private String event;
    @XStreamAlias("EventKey")
    private String eventKey;

    public EventRequest() {
        super(RequestType.event);
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getEventKey() {
        return eventKey;
    }

    public void setEventKey(String eventKey) {
        this.eventKey = eventKey;
    }

}

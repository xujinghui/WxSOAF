package com.github.xujh.wxsoaf.mvc;

import com.github.xujh.wxsoaf.wxintf.IPushRequest;

public interface IProcessHandler<T extends IPushRequest> {

    // IPushResponse handle(T req, WxContext ctx);

    // public Class getMsgType();

    Controller getController(T req);
}

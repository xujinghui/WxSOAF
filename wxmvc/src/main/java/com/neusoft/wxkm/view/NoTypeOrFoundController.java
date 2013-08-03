/**
 * 
 */
package com.neusoft.wxkm.view;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;

import com.github.xujh.wxsoaf.mvc.Controller;
import com.github.xujh.wxsoaf.servlet.WxContext;
import com.github.xujh.wxsoaf.wxintf.AbstractPushRequest;
import com.github.xujh.wxsoaf.wxintf.IPushResponse;
import com.github.xujh.wxsoaf.wxintf.TextResponse;

/**
 * @author stevenxu
 * 
 */
public class NoTypeOrFoundController implements Controller<AbstractPushRequest> {
    @Autowired
    private ResourceBundleMessageSource messageSource;

    public IPushResponse handleRequest(AbstractPushRequest req, WxContext ctx) {
        TextResponse tr = new TextResponse();
        tr.setFromUserName(req.getToUserName());
        tr.setToUserName(req.getFromUserName());
        tr.setCreateTime("");
        tr.setFuncFlag(0);

        String content = null;

        // if (!userBindService.isBinded(req.getFromUserName())) {
        //
        // }

        content = messageSource.getMessage("show_m", new Object[] { req.getFromUserName(), "参数2" },
                null, Locale.CHINA);
        tr.setContent(content);

        System.out.println("content:" + content);

        return tr;
    }

}

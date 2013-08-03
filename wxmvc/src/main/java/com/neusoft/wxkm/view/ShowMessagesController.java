/**
 * 
 */
package com.neusoft.wxkm.view;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;

import com.github.xujh.wxsoaf.mvc.TextController;
import com.github.xujh.wxsoaf.servlet.WxContext;
import com.github.xujh.wxsoaf.wxintf.IPushResponse;
import com.github.xujh.wxsoaf.wxintf.TextRequest;
import com.github.xujh.wxsoaf.wxintf.TextResponse;
import com.neusoft.wxkm.services.intf.IUserBindService;

/**
 * @author stevenxu
 * 
 */

public class ShowMessagesController implements TextController {
    @Autowired
    private IUserBindService userBindService = null;

    @Autowired
    private ResourceBundleMessageSource messageSource;

    public IPushResponse handleRequest(TextRequest req, WxContext ctx) {
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
                null,Locale.getDefault());
        tr.setContent(content);

        System.out.println("content:" + content);

        return tr;
    }

}

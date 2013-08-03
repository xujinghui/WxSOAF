/**
 * 
 */
package com.neusoft.wxkm.view;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.xujh.wxsoaf.mvc.TextController;
import com.github.xujh.wxsoaf.servlet.WxContext;
import com.github.xujh.wxsoaf.stereotype.RequestMapping;
import com.github.xujh.wxsoaf.wxintf.IPushResponse;
import com.github.xujh.wxsoaf.wxintf.TextRequest;
import com.neusoft.wxkm.services.intf.IUserBindService;

/**
 * @author stevenxu
 * 
 */
public class NavigateTreeController implements TextController {

    @Autowired
    private IUserBindService userBindService = null;

    @RequestMapping(value = "m")
    public String showMessage() {

        return "redirect:";
    }

    @RequestMapping(value = "helloworld")
    public String showHelloworld() {

        return "redirect:hello";
    }

    public IPushResponse handleRequest(TextRequest req, WxContext ctx) {
        // TODO Auto-generated method stub
        return null;
    }

}

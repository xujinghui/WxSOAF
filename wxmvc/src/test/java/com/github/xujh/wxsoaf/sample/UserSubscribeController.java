/**
 * 
 */
package com.github.xujh.wxsoaf.sample;

import com.github.xujh.wxsoaf.annotation.RequestType;
import com.github.xujh.wxsoaf.stereotype.RequestMapping;
import com.github.xujh.wxsoaf.stereotype.WxController;

/**
 * @author stevenxu
 * 
 */
@WxController(type = RequestType.text)
public class UserSubscribeController {

    @RequestMapping(value = "hello")
    public String showHello() {

        return "m";
    }

    @RequestMapping(value = "m")
    public String showMessage() {

        return "redirect:";
    }

    @RequestMapping(value = "helloworld")
    public String showHelloworld() {

        return "redirect:hello";
    }
}

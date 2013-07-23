/**
 * 
 */
package com.github.xujh.wxsoaf.sample;

import org.springframework.web.servlet.ModelAndView;

import com.github.xujh.wxsoaf.annotation.RequestType;
import com.github.xujh.wxsoaf.stereotype.RequestMapping;
import com.github.xujh.wxsoaf.stereotype.WxController;

/**
 * @author stevenxu
 * 
 */
@WxController
public class UserSubscribeController {

	@RequestMapping(value = "hello", type = RequestType.text)
	public String showHello() {

		return "m";
	}

	@RequestMapping(value = "m", type = RequestType.text)
	public ModelAndView showMessage() {

		return "redirect:";
	}

	@RequestMapping(value = "helloworld", type = RequestType.text)
	public String showHelloworld() {

		return "redirect:hello";
	}
}

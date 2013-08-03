/**
 * 
 */
package com.github.xujh.wxsoaf.anno2;

import com.github.xujh.wxsoaf.annotation.RequestType;
import com.github.xujh.wxsoaf.servlet.WxContext;
import com.github.xujh.wxsoaf.stereotype.MatchType;
import com.github.xujh.wxsoaf.stereotype.RequestMapping;
import com.github.xujh.wxsoaf.stereotype.WxController;
import com.github.xujh.wxsoaf.wxintf.IPushResponse;
import com.github.xujh.wxsoaf.wxintf.LocationRequest;

/**
 * @author stevenxu
 * 
 */
@WxController(type = RequestType.text)
public class SomeTextReceiveController {

	@RequestMapping(value = "m", match = MatchType.Equals)
	public IPushResponse handle1(LocationRequest req, WxContext ctx) {
		// TODO Auto-generated method stub

		return null;
	}

	@RequestMapping(value = "mm", match = MatchType.StartsWith)
	public IPushResponse handle2(LocationRequest req, WxContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}
}

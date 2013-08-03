/**
 * 
 */
package com.neusoft.wxkm.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.xujh.wxsoaf.mvc.LocationController;
import com.github.xujh.wxsoaf.servlet.WxContext;
import com.github.xujh.wxsoaf.wxintf.IPushResponse;
import com.github.xujh.wxsoaf.wxintf.LocationRequest;
import com.github.xujh.wxsoaf.wxintf.TextResponse;
import com.neusoft.wxkm.model.UserLocationInfo;
import com.neusoft.wxkm.services.intf.ILocRegisterService;
import com.neusoft.wxkm.services.intf.IUserBindService;
import com.neusoft.wxkm.services.intf.LocationVO;

/**
 * @author stevenxu
 * 
 */
public class LocRegisterController implements LocationController {

    @Autowired
    private ILocRegisterService locRegisterService = null;

    @Autowired
    private IUserBindService userBindService = null;

    public IPushResponse handleRequest(LocationRequest req, WxContext ctx) {
        TextResponse tr = new TextResponse();
        tr.setFromUserName(req.getToUserName());
        tr.setToUserName(req.getFromUserName());
        tr.setCreateTime("");
        tr.setFuncFlag(0);

        StringBuilder sb = new StringBuilder();
        sb.append(" 信息摘要： \n");
        sb.append(" x: " + req.getLocation_X());
        sb.append("\n");
        sb.append(" y: " + req.getLocation_Y());
        sb.append("\n");
        sb.append(" scale: " + req.getScale());
        sb.append("\n");
        sb.append(" label: " + req.getLabel());
        sb.append("\n");

//        LocationVO vo = new LocationVO();
//        vo.setLocation_X(req.getLocation_X());
//        vo.setLocation_Y(req.getLocation_Y());
//        List<UserLocationInfo> list = locRegisterService.service(req.getFromUserName(), vo);
//        sb.append("\n返回内容(" + list.size() + "): \n");
//        for (UserLocationInfo info : list) {
//            sb.append("" + info.getUser() + "\n");
//        }
        sb.append("\n");

        // if (!userBindService.isBinded(req.getFromUserName())) {
        //
        // }

        tr.setContent(sb.toString());

        System.out.println("content:" + sb.toString());

        return tr;
    }
}

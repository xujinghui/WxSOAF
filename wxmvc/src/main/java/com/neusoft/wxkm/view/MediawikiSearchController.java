/**
 * 
 */
package com.neusoft.wxkm.view;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.xujh.wxsoaf.mvc.TextController;
import com.github.xujh.wxsoaf.servlet.WxContext;
import com.github.xujh.wxsoaf.wxintf.IPushResponse;
import com.github.xujh.wxsoaf.wxintf.Item;
import com.github.xujh.wxsoaf.wxintf.PictureTextResponse;
import com.github.xujh.wxsoaf.wxintf.TextRequest;
import com.neusoft.wxkm.services.intf.IMediawikiSearchService;
import com.neusoft.wxkm.services.intf.IUserBindService;

/**
 * @author stevenxu
 * 
 */
public class MediawikiSearchController implements TextController {
    @Autowired
    private IUserBindService userBindService = null;

    private IMediawikiSearchService mediawikiSearchService = null;

    public IPushResponse handleRequest(TextRequest req, WxContext ctx) {
        PictureTextResponse ptr = new PictureTextResponse();
        ptr.setFromUserName(req.getToUserName());
        ptr.setToUserName(req.getFromUserName());
        ptr.setCreateTime("");

        List<Item> itemList = new ArrayList<Item>();
        {
            Item item1 = new Item();
            item1.setTitle("【创业说】：微信校园O2O的那点事");
            item1.setDescription("最近一个朋友在学校里利用微信公众账号做了一个O2O创业的小项目，流光也跟着掺和了一把，就赶在微信5.0发布的前夜谈谈微信校园O2O的那点事吧。");
            item1.setPicUrl("http://a.36krcnd.com/photo/0fcebbb46ec151f0a45b25d3d7ebec61.jpg!feature");
            item1.setUrl("http://www.36kr.com/p/205055.html");
            itemList.add(item1);
        }
        {
            Item item2 = new Item();
            item2.setTitle("杜琪峰电影不够大卖，是犯了电影工业的什么忌？");
            item2.setDescription("杜Sir一直在努力的“结构性创新”，却给杜氏电影的宣传带来了极大的困扰");
            item2.setPicUrl("http://u.img.huxiu.com/portal/201307/31/070703vl1rlgigr5877v7g.jpg");
            item2.setUrl("http://www.huxiu.com/article/17873/1.html");
            itemList.add(item2);
        }

        {
            Item item3 = new Item();
            
            item3.setTitle("微信与联通合作幕后的10个细节");
            item3.setDescription("腾讯与中国联通合作的“微信沃”卡已于昨日发布，笔者在与广东联通副总经理杨城中、以及多名腾讯现场工作人员聊天中，获悉了诸多幕后细节");
            item3.setPicUrl("http://u.img.huxiu.com/portal/201307/31/092952c6772kt7k2ittkmx.jpg");
            item3.setUrl("http://www.huxiu.com/article/18027/1.html");
            itemList.add(item3);
        }

        ptr.setArticles(itemList);
        ptr.setArticleCount(itemList.size());

        ptr.setFuncFlag(1);

        return ptr;
    }

}

/**
 * 
 */
package com.neusoft.wxkm.view;

import com.github.xujh.wxsoaf.mvc.TextController;
import com.github.xujh.wxsoaf.servlet.WxContext;
import com.github.xujh.wxsoaf.wxintf.IPushResponse;
import com.github.xujh.wxsoaf.wxintf.MusciResponse;
import com.github.xujh.wxsoaf.wxintf.Music;
import com.github.xujh.wxsoaf.wxintf.TextRequest;

/**
 * @author stevenxu
 * 
 */
public class OneMp3ResponseController implements TextController {

    @Override
    public IPushResponse handleRequest(TextRequest req, WxContext ctx) {
        MusciResponse tr = new MusciResponse();
        tr.setFromUserName(req.getToUserName());
        tr.setToUserName(req.getFromUserName());
        tr.setCreateTime("");
        tr.setFuncFlag(0);

        String content = null;

        // if (!userBindService.isBinded(req.getFromUserName())) {
        //
        // }
//        String musicUrl = "http://yzjfds.com/images/qian.mp3";
        String musicUrl = "http://zhangmenshiting.baidu.com/data2/music/64313818/126259821600128.mp3?xcode=d7acefd0abdf98a52ea7fb4febd8cf5dc641dd56c7eeeccc";

        Music music = new Music();
        music.setDescription("Desc");
        music.setTitle("Music coming!");
        music.sethQMusicUrl(musicUrl);
        music.setMusicUrl(musicUrl);
        tr.setMusic(music);

        System.out.println("OneMp3ResponseController:" + content);

        return tr;
    }

}

/**
 * 
 */
package com.github.xujh.wxsoaf.wxintf;

import java.util.List;

import com.github.xujh.wxsoaf.annotation.ResponseType;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @author stevenxu
 * 
 */
@XStreamAlias("xml")
public class PictureTextResponse extends AbstractPushResponse {

    // @XStreamAlias("ToUserName")
    // private String toUserName;
    // @XStreamAlias("FromUserName")
    // private String fromUserName;
    // @XStreamAlias("CreateTime")
    // private String createTime;
    // @XStreamAlias("MsgType")
    // private String msgType;

    @XStreamAlias("ArticleCount")
    private int articleCount;

    @XStreamAlias("Articles")
    private List<Item> articles;

    @XStreamAlias("FuncFlag")
    private int funcFlag;

    public PictureTextResponse() {
        super(ResponseType.news);
    }

    public int getArticleCount() {
        return articleCount;
    }

    public void setArticleCount(int articleCount) {
        this.articleCount = articleCount;
    }

    public List<Item> getArticles() {
        return articles;
    }

    public void setArticles(List<Item> articles) {
        this.articles = articles;
    }

    public int getFuncFlag() {
        return funcFlag;
    }

    public void setFuncFlag(int funcFlag) {
        this.funcFlag = funcFlag;
    }

}

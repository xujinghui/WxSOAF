/**
 * 
 */
package com.neusoft.wxkm.services.intf;

import java.util.List;

/**
 * @author stevenxu
 * 
 */
public interface IMediawikiSearchService {

    /**
     * 通过关键字搜索wiki，返回内容列表
     * 
     * @param keyWord
     *            搜索关键字
     * @param number
     *            返回内容的数目；
     */
    List<ArticleItemVO> search(String keyWord, int number);

    String getArticle(String url);


}

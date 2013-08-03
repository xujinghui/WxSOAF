package com.neusoft.wxkm.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.GetMethod;
import org.codehaus.jackson.map.type.TypeFactory;
import org.codehaus.jackson.type.TypeReference;

import com.neusoft.wxkm.services.intf.ArticleItemVO;
import com.neusoft.wxkm.services.intf.IMediawikiSearchService;
import com.neusoft.wxkm.utils.JsonUtil;

public class MediawikiSearchServiceImpl implements IMediawikiSearchService{


private String loginUrl="http://10.10.129.193/midwikitest/api.php?action=login&lgname=wx&lgpassword=wx123";
private String searchUrl="http://10.10.129.193/midwikitest/api.php?action=query&list=search&srsearch=test&srprop=timestamp&format=json";

	@Override
	public List<ArticleItemVO> search(String keyWord, int number) {

		HttpClient httpclient = new HttpClient();
		GetMethod httpLogin = new GetMethod(loginUrl);
		GetMethod httpSearch = new GetMethod(searchUrl);
		String content= null;
		try {
			httpclient.executeMethod(httpLogin);
			httpclient.executeMethod(httpSearch);
			content=httpSearch.getResponseBodyAsString();
		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<ArticleItemVO> list=JsonUtil.getObject(content,new ArrayList<ArticleItemVO>().getClass());
		return list;
	}

	@Override
	public String getArticle(String url) {

		HttpClient httpclient = new HttpClient();
		GetMethod httpget = new GetMethod(url);
		
		String content= null;
		try {
			httpclient.executeMethod(httpget);
			content=httpget.getResponseBodyAsString();
		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return content;
	}


}

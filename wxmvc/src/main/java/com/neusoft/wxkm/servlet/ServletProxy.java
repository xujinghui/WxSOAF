package com.neusoft.wxkm.servlet;

import javax.servlet.http.HttpServlet;

import com.neusoft.wxkm.services.intf.IMediawikiSearchService;
import com.neusoft.wxkm.services.intf.IUserBindService;

public class ServletProxy {

	
	public static class UserBindServletProxy {
		
		private static IUserBindService userBindService=null;
		private static UserBindServlet targetServlet=null;
		public IUserBindService getUserBindService() {
			return userBindService;
		}

		public void setUserBindService(IUserBindService userBindService) {
			UserBindServletProxy.userBindService = userBindService;
			if(targetServlet!=null){
				targetServlet.setUserBindService(userBindService);
			}
			
		}

		public static HttpServlet getTargetServlet() {
			return targetServlet;
		}

		public static void setTargetServlet(UserBindServlet targetServlet) {
			UserBindServletProxy.targetServlet = targetServlet;
			if(userBindService!=null){
				UserBindServletProxy.targetServlet.setUserBindService(userBindService);
			}
		}

	}

	public static class MediawWikeSearchServletProxy {
		
		private static IMediawikiSearchService wikiSearchService=null;
		private static MediawWikiSearchServlet targetServlet=null;
		public IMediawikiSearchService getWikiSearchService() {
			return wikiSearchService;
		}

		public void setWikiSearchService(IMediawikiSearchService wikiSearchService) {
			MediawWikeSearchServletProxy.wikiSearchService = wikiSearchService;
			if(targetServlet!=null){
				targetServlet.setWikiSearchService(wikiSearchService);
			}
		}

		public static MediawWikiSearchServlet getTargetServlet() {
			return targetServlet;
		}

		public static void setTargetServlet(MediawWikiSearchServlet targetServlet) {
			MediawWikeSearchServletProxy.targetServlet = targetServlet;
			if(wikiSearchService!=null){
				MediawWikeSearchServletProxy.targetServlet.setWikiSearchService(wikiSearchService);
			}
		}  

	}
}

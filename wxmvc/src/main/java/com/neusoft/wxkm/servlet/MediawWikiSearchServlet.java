package com.neusoft.wxkm.servlet;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.neusoft.wxkm.services.intf.IMediawikiSearchService;

/**
 * Servlet implementation class MediawWikiSearchServlet
 */
@WebServlet("/MediawWikiSearchServlet")
public class MediawWikiSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IMediawikiSearchService wikiSearchService=null;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MediawWikiSearchServlet() {
        super();
        ServletProxy.MediawWikeSearchServletProxy.setTargetServlet(this);
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = request.getParameter("url");
		Writer writer = response.getWriter();
		try {
			String article = wikiSearchService.getArticle(url);
			response.setContentType("text;html;charset=utf-8");
			writer.write(article);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (writer != null) {
				writer.close();
			}
		}

	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	public IMediawikiSearchService getWikiSearchService() {
		return wikiSearchService;
	}

	public void setWikiSearchService(IMediawikiSearchService wikiSearchService) {
		this.wikiSearchService = wikiSearchService;
	}

}

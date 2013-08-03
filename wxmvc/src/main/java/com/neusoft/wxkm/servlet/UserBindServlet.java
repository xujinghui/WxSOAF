package com.neusoft.wxkm.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import com.neusoft.wxkm.model.User;
import com.neusoft.wxkm.services.intf.IUserBindService;

/**
 * Servlet implementation class UserBindServlet
 */
@WebServlet("/UserBindServlet")
public class UserBindServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IUserBindService userBindService=null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserBindServlet() {
        super();
        ServletProxy.UserBindServletProxy.setTargetServlet(this);
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

//		if(request.getRequestURI().endsWith("edit"))
//		{
//			 response.sendRedirect("edit.jsp");
//			 return ;
//		}else{
			//request.getRequestURI().endsWith("apply");
			User user=loadUser(request);
			String info=userBindService.bind(user.getUserAlias(),user.getName(),user.getEmployeeId());
			if(StringUtils.isBlank(info)){
				request.getRequestDispatcher("success.jsp").forward(request, response);
			}else{
				request.setAttribute("errorInfo", info);
				request.getRequestDispatcher("failure.jsp").forward(request, response);
			}
			return ;
//		}
	}

	private User loadUser(HttpServletRequest request) {
		// TODO Auto-generated method stub
		User user=new User();
		user.setName((String)request.getParameter("name"));
		user.setEmployeeId((String)request.getParameter("employee_id"));
		user.setUserAlias((String)request.getParameter("user_alias"));
		return user;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	public IUserBindService getUserBindService() {
		return userBindService;
	}

	public void setUserBindService(IUserBindService userBindService) {
		this.userBindService = userBindService;
	}

}

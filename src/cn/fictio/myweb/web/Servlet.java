package cn.fictio.myweb.web;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import cn.fictio.myweb.domain.CommentPage;
import cn.fictio.myweb.domain.Comments;
import cn.fictio.myweb.domain.Contacter;
import cn.fictio.myweb.service.ContactService;
import cn.fictio.myweb.service.CommentService;

public class Servlet extends HttpServlet {
	//get方法分发器
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String page = request.getParameter("page");
		
		System.out.println("page="+page);
		
		//根据传进来的page属性,确定转发路径
		if("index".equals(page) || page==null){
			this.toIndex(request,response);
		}else if("contact".equals(page)){
			this.toContact(request,response);
		}else if("collection".equals(page)){
			this.toCollection(request,response);
		}else if("content_1".equals(page)){
			this.toContent_1(request,response);
		}else if("content_2".equals(page)){
			this.toContent_2(request,response);
		}
	}

	//转发到收藏
	private void toCollection(HttpServletRequest request,
			HttpServletResponse response) {
		request.setAttribute("page", "collection");
		dispatcherByPage(request, response);
	}

	//转发到内容2
	private void toContent_2(HttpServletRequest request,
			HttpServletResponse response) {
		request.setAttribute("page", "content_2");
		dispatcherByPage(request, response);
	}

	//转发到内容1
	private void toContent_1(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("page", "content_1");
		this.getComments(request, response);
	}
	//转contact页面
	private void toContact(HttpServletRequest request,
			HttpServletResponse response) {
		request.setAttribute("page", "contact");
		dispatcherByPage(request, response);
	}
	//转index页面
	private void toIndex(HttpServletRequest request,
			HttpServletResponse response) {
		request.setAttribute("page", "index");
		dispatcherByPage(request, response);
	}
	
	//转发至模版
	private void dispatcherByPage(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			request.getRequestDispatcher("/WEB-INF/new1.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//post方法分发器
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String method = request.getParameter("method");
		
		System.out.println("method="+method);
		
		if("insertContacter".equals(method)){
			this.insertContacter(request,response);
		}else if("revert".equals(method)){
			this.revert(request,response);
		}
	}

	//将comments(文章评论)对象存入数据库
	private void revert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CommentService cs = new CommentService();
		Comments comment = new Comments();
		
		comment.setIp(request.getLocalAddr());
		comment.setTitle((String) request.getParameter("title"));
		comment.setText((String) request.getParameter("comments"));
		
		try {
			cs.insert(comment);
			request.setAttribute("message", "评论成功");
			request.getRequestDispatcher("/WEB-INF/new1.jsp").forward(request, response);
		} catch (Exception e) {
			request.setAttribute("page", "message");
			request.setAttribute("message", "评论失败");
			request.getRequestDispatcher("/WEB-INF/new1.jsp").forward(request, response);
		}
	}
	//将评论数据取出并放入页面
	private void getComments(HttpServletRequest request,HttpServletResponse response) 
			throws ServletException, IOException{
		int currPage;
		
		if(request.getParameter("currPage")==null){
			currPage = 1;
		}else{
			currPage = Integer.parseInt(request.getParameter("currPage"));
		}
		
		String title = request.getParameter("page");
		
		System.out.println("title="+title);
		
		CommentPage commentPage = new CommentPage();
		CommentService cs = new CommentService();
		
		try {
			commentPage = cs.findComments(title, currPage);
			//将commentPage对象存放与域对象中
			request.setAttribute("comentPage", commentPage);
			request.setAttribute("page", "content_1");
			
			this.dispatcherByPage(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("page", "message");
			request.setAttribute("message", "评论页面取出失败");		
			request.getRequestDispatcher("/WEB-INF/new1.jsp").forward(request, response);
		}
		
	}

	//将contacter(联系我)对象存入数据库
	private void insertContacter(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		ContactService cs = new ContactService();
		//收集信息
		Contacter contacter = new Contacter();
		Enumeration<String> enums = request.getParameterNames();
		while(enums.hasMoreElements()){
			String key = enums.nextElement();
			String[]values = request.getParameterValues(key);
			
			System.out.println("key="+key);
			System.out.println("value="+values[0]);
			
			try {
				BeanUtils.setProperty(contacter, key, values);
			} catch (Exception e) {
				System.out.println("数据打包失败");
				e.printStackTrace();
			}
		}
		
		try {
			cs.insertText(contacter);
			request.setAttribute("page", "message");
			request.setAttribute("message", "提交成功");	
			request.getRequestDispatcher("/WEB-INF/new1.jsp").forward(request, response);
		} catch (Exception e) {
			request.setAttribute("page", "message");
			request.setAttribute("message", "提交失败");		
			request.getRequestDispatcher("/WEB-INF/new1.jsp").forward(request, response);
		}
	}

}

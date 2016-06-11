package cn.fictio.myweb.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.fictio.myweb.dao.Dao;
import cn.fictio.myweb.domain.CommentPage;
import cn.fictio.myweb.domain.Comments;

//实现评论功能的类
public class CommentService {
	
	//向数据库中存入评论
	public void insert(Comments comment) throws Exception {
		Dao dao = new Dao();
		try {
			dao.insert(comment);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("评论存入数据库失败");
		}
	}
		
	//从数据库中取出评论
	public CommentPage findComments(String title,int currPage) throws Exception{
		CommentPage commentPage = new CommentPage(); 
		Dao dao = new Dao();
		
		try {
			//设置当前页面
			commentPage.setCurrPage(currPage);
			//设置总评论个数,已知一页显示多少评论数,所以可以同时设置总页数,
			commentPage.setSumComments(dao.getCommentsNum(title));
			//设置查询位置和长度
			int size = commentPage.getCurrPageNum();
			int start = (commentPage.getCurrPage()-1)*size;
			
			
			commentPage.setCommentPageList(dao.findComment(title,start,size));
			
			System.out.println(commentPage.toString());
			
		} catch (SQLException e) { 
			e.printStackTrace();
			throw new Exception("评论取出数据库失败");
		}
		return commentPage;
	}

}

package cn.fictio.myweb.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.fictio.myweb.domain.Comments;
import cn.fictio.myweb.domain.Contacter;
import cn.fictio.myweb.utils.JdbcUtil;

public class Dao {

	//向数据库存入一个contacter对象
	public void insert(Contacter contacter) throws SQLException {
		
		QueryRunner runner = new QueryRunner(JdbcUtil.getDataSource());
		String sql = "insert into contacter(name,email,comments) value(?,?,?)";
		
		runner.update(sql, new Object[]{contacter.getName(),
										contacter.getEmail(),
										contacter.getComments(),
		});
	}

	//向数据库存入一个评论Comment对象
	public void insert(Comments comment) throws SQLException {
		QueryRunner runner = new QueryRunner(JdbcUtil.getDataSource());
		String sql = "insert into comments(text,title,ip) value(?,?,?)";
		
		runner.update(sql, new Object[]{comment.getText(),
										comment.getTitle(),
										comment.getIp()
		});
	}
	
	//从数据库取出一个comment对象集
	public List<Comments> findComment(String title,int start,int size) throws SQLException{
		List<Comments> commentList = new ArrayList<Comments>();
		
		QueryRunner runner = new QueryRunner(JdbcUtil.getDataSource());
		String sql = "select * from comments where title=? limit ?,?";
		
		commentList = (List<Comments>) runner.query(sql, new Object[]{
						title,start,size}, new BeanListHandler(Comments.class));
		
		return commentList;
	}

	//查询数据库,返回指定title的comment数目
	public int getCommentsNum(String title) throws SQLException {
		QueryRunner runner = new QueryRunner(JdbcUtil.getDataSource());
		String sql = "select count(*) from comments where title=?";
		Object[] arr = (Object[]) runner.query(sql, title, new ArrayHandler());
		Long temp = (Long) arr[0];
		int rel = temp.intValue();
		return rel;
	}

}

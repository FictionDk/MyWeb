package cn.fictio.myweb.service;

import java.sql.SQLException;

import cn.fictio.myweb.dao.Dao;
import cn.fictio.myweb.domain.Contacter;

public class ContactService {
	//将contacter写入数据库
	public void insertText(Contacter contacter) throws Exception{
		Dao dao = new Dao();
		try {
			dao.insert(contacter);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("contacter对象写入异常");
			throw new Exception();
		}
		
	}

}

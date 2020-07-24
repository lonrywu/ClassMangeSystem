package com.lonry.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.lonry.util.DbUtil;

/**
 * 
 * @author 吴长江
 * 创建数据库连接对象，整个项目与数据库的联系都用这一个对象.
 */
public class BaseDao {
	public Connection con = new DbUtil().getCon();
	public void closeDao() {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

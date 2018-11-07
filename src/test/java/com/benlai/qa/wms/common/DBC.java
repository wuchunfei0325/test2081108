package com.benlai.qa.wms.common;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

public class DBC {
	private Connection con;

	private PreparedStatement pstm;

	private String user;

	private String password;

	private String ip;

	private String port;

	private String dbName;

	private String url;

	public DBC() {
		try {
			getDbConnProp();
		} catch (Exception e) {
			System.out.println("加载数据库驱动失败！");
			e.printStackTrace();
		}
	}

	private void getDbConnProp() {
		try {
			InputStream in = getClass().getClassLoader().getResourceAsStream("config.properties");
			Properties proHelper = new Properties();
			proHelper.load(in);
			in.close();

			ip = proHelper.getProperty("dburl");
			port = proHelper.getProperty("dbport");
			user = proHelper.getProperty("dbuser");
			password = proHelper.getProperty("dbpass");
			dbName = proHelper.getProperty("dbName");

			url = "jdbc:sqlserver://" + ip + ";port="+port+ ";databaseName="+dbName+";user="+user+";password="+password;
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/** 创建数据库连接 */
	public Connection getCon() {
		try {
			/*try {
				Class.forName("org.gjt.mm.mysql.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			con=DriverManager.getConnection(url);
			//con = DriverManager.getConnection("jdbc:sqlserver://192.168.60.49;databaseName=BenlaiSales;user=sa;password=cc.123");
		} catch (SQLException e) {
			System.out.println("创建数据库连接失败！");
			con = null;
			e.printStackTrace();
		}
		return con;
	}

	public void doPstm(String sql, Object[] params) {
		if (sql != null && !sql.equals("")) {
			if (params == null)
				params = new Object[0];

			getCon();
			if (con != null) {
				try {
					//System.out.println(sql);
					pstm = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
					for (int i = 0; i < params.length; i++) {
						pstm.setObject(i + 1, params[i]);
						
					}
					pstm.execute();
				} catch (SQLException e) {
					System.out.println("doPstm()方法出错！");
					e.printStackTrace();
				}
			}
		}
	}

	public ResultSet getRs() throws SQLException {
		return pstm.getResultSet();
	}

	public int getCount() throws SQLException {
		return pstm.getUpdateCount();
	}

	public void closed() {
		try {
			if (pstm != null)
				pstm.close();
		} catch (SQLException e) {
			System.out.println("关闭pstm对象失败！");
			e.printStackTrace();
		}
		try {
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			System.out.println("关闭con对象失败！");
			e.printStackTrace();
		}
	}
/*	public static ResultSet Query_Inventory() throws SQLException {
		String sql = "Select * From Inventory Where ProductSysNo=?";
		Object[] params = { "2063544" };
		DBC mydb = new DBC();
		mydb.doPstm(sql, params);
		ResultSet rs = mydb.getRs();
		try {
			while (rs.next()) {
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			mydb.closed();
		}
		return rs;
	}*/
	public static ArrayList Query_Inventory() throws SQLException{
		String sql = "Select * From Inventory Where ProductSysNo=?";
		Object[] params = { "2063844" };
		DBC mydb = new DBC();
		mydb.doPstm(sql, params);
		ResultSet rs = mydb.getRs();
		try {
			while (rs.next()) {
				// 通过字段检索
				ArrayList list=new ArrayList();
				//财务
				list.add(rs.getInt("AccountQty"));
				//可用
				list.add(rs.getInt("AvailableQty"));
				//可售
				list.add(rs.getInt("SalableQty"));
				//已用
				list.add(rs.getInt("AllocatedQty"));
				return list;

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			mydb.closed();
		}
		return null;
		
	}
	
}

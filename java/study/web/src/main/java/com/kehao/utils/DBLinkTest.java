package com.kehao.utils;

import java.sql.*;

public class DBLinkTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if (args.length < 6) {
			System.out.println("Usage: DBLinkTest DBType DBAddr DBPort DBName User Pwd");
			System.out.println("       DBType -- 0 : Oracle");
			System.out.println("                 1 : SQLServer");
			System.out.println("                 2 : MySQL");
			System.out.println("       DBAddr -- Database server's ip address");
			System.out.println("       DBPort -- Database server's port");
			System.out.println("       DBName -- Database name");
			System.out.println("       User   -- User name");
			System.out.println("       Pwd    -- User password");
			System.exit(-1);
		}

		int dbType = Integer.parseInt(args[0]);
		String dbAddr = args[1];
		String dbPort = args[2];
		String dbName = args[3];
		String usrName = args[4];
		String usrPwd = args[5];

		String driver = "";
		String url = "";
		switch (dbType) {
		case 0:
			driver = "oracle.jdbc.driver.OracleDriver";
			url = "jdbc:oracle:thin:@" + dbAddr + ":" + dbPort + ":" + dbName;
			break;
		case 1:
			driver = "net.sourceforge.jtds.jdbc.Driver";
			url = "jdbc:jtds:sqlserver://" + dbAddr + ":" + dbPort + "/" + dbName;
			break;
		case 2:
			driver = "com.mysql.jdbc.Driver";
			url = "jdbc:mysql://" + dbAddr + ":" + dbPort + "/" + dbName;
			break;
		default:
			System.out.println("Unsupported DB Type!");
			System.exit(-2);
		}

		try {
			Class.forName(driver);
		} catch (Exception e) {
			System.out.println("Can not load database driver!");
			System.exit(-3);
		}

		for (int i = 0; i < 3; i++) {
			try {
				Connection con = DriverManager.getConnection(url, usrName, usrPwd);
				System.out.println("Connect to database successful!");
				try {
					if (!con.isClosed())
						con.close();
				} catch (Exception e) {
				}
				System.exit(0);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		System.out.println("Connect to database failed!");
		System.exit(-4);
	}
}

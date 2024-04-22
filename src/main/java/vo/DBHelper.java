package vo;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBHelper {
	public static Connection getConnection() throws Exception{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = null;
		String dburl = "jdbc:oracle:thin:@ghban5962_high?TNS_ADMIN=D:/div/auth/Wallet_ghban5962";
		String dbUser = "admin";
		
		// 보안 이슈로 로컬에서 설정 파일 로드
		FileReader fr = new FileReader("D:\\div\\auth\\oracle.properties");
		Properties prop = new Properties();
		prop.load(fr);
		String dbPw = prop.getProperty("pw");
		System.out.println("pw: " + dbPw);
		conn = DriverManager.getConnection(dburl, dbUser, dbPw); 
		
		return conn;
	}
	public static void main(String [] args) throws Exception {
		Connection conn = DBHelper.getConnection();
		System.out.println(conn);
	}
}

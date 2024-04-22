package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import oracle.jdbc.driver.HAManager;
import vo.DBHelper;
import vo.Emp;
public class EmpDAO {
		public static ArrayList<String> selectJobCaseList() throws Exception {
			ArrayList<String> list = new ArrayList<>();
			return list;
		}
	
		// 중복을 제외한 DEPTNO 목록을 출력하는 메서드
		public static ArrayList<Integer> selectDeptNoList() throws Exception {
			ArrayList<Integer> list = new ArrayList<>();
			Connection conn = null;
			conn = DBHelper.getConnection();
			String sql = "SELECT DISTINCT deptno deptNo "
					+ "FROM emp "
					+ "WHERE deptno IS NOT NULL "
					+ "ORDER BY deptno ASC ";
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = null;
			rs = stmt.executeQuery();
			while(rs.next()) {
				Integer i = rs.getInt("deptNo");
				list.add(i);
			}
			conn.close();
			 
			return list;
		}
		public static ArrayList<HashMap<String, Object>> selectEmpAndDeptList() throws Exception{
			ArrayList<HashMap<String, Object>> list = new ArrayList<>();
			Connection conn = DBHelper.getConnection();
			String sql ="select "
					+ "emp.empno empNo, emp.ename ename, emp.deptno deptNo, "
					+ "dept.dname dname "
					+ "from emp Inner JOIN dept "
					+ "ON emp.deptno = dept.deptno ";
			PreparedStatement stmt = null;
			stmt = conn.prepareStatement(sql);
			ResultSet rs = null;
			rs = stmt.executeQuery();
			while(rs.next()) {
				HashMap<String, Object> m = new HashMap<>();
				m.put("empNo", rs.getInt("empNo"));
				m.put("ename", rs.getString("ename"));
				m.put("deptNo", rs.getInt("deptNo"));
				m.put("dname", rs.getString("dname"));
				
				list.add(m);
			}
			return list;
	}
		// vo 사용
		public static ArrayList<Emp> selectEmpList() throws Exception {
			ArrayList<Emp> list = new ArrayList<>();
			
			Connection conn = DBHelper.getConnection();
			String sql = "SELECT "
					+ "empno empNo, ename, sal "
					+ "FROM emp ";
			
			PreparedStatement stmt = null;
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Emp e = new Emp();
				e.empno = rs.getInt("empNo");
				e.ename = rs.getString("ename");
				e.sal = rs.getInt("sal");
				list.add(e);
			}
		return list;	
	}
}

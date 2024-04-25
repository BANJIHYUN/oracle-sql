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
		public static ArrayList<Emp>selectEmpListSort(String col, String sort) throws Exception{
			// 디버깅
			System.out.println("col: " + col);
			System.out.println("sort: " + sort);
			
			ArrayList<Emp> list = new ArrayList<>();
			Connection conn = DBHelper.getConnection();
			
			String sql = "SELECT empno, ename "
					+ "FROM emp";
			
			if(col != null && sort != null) {
				sql = sql + "ORDER BY " + col +" " + sort;
			}
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			System.out.println(stmt); 
			
			ResultSet rs = null;
			/*
			 * while(rs.next()) { Emp }
			 */
			/*
			 * 동적쿼리(쿼리문자열이 매개값에 분기되어 차이가 나는 경우
			 * empno ASC 
			 * empno DESC
			 * ename ASC
			 */
			return list;
		}
		public static ArrayList<Emp>selectEmpListByGrade(ArrayList<Integer> ckList) throws Exception {
			ArrayList<Emp> list = new ArrayList<>();
			Connection conn = DBHelper.getConnection();
			String sql = "SELECT ename, grade "
					+ "FROM emp "
					+ "WHERE grade IN";
			PreparedStatement stmt = null;
			if(ckList.size() == 1) {
				sql = sql + "(?)";
				stmt = conn.prepareStatement(sql);
				stmt.setInt(1, ckList.get(0));
			} else if(ckList.size() == 2) {
				sql = sql + "(?, ?)";
				stmt = conn.prepareStatement(sql);
				stmt.setInt(1, ckList.get(0));
				stmt.setInt(2, ckList.get(1));
			} else if(ckList.size() == 3) {
				sql = sql + "(?, ?, ?)";
				stmt = conn.prepareStatement(sql);
				stmt.setInt(1, ckList.get(0));
				stmt.setInt(2, ckList.get(1));
				stmt.setInt(3, ckList.get(2));
			}else if(ckList.size() == 4) {
				sql = sql + "(?, ?, ?, ?)";
				stmt = conn.prepareStatement(sql);
				stmt.setInt(1, ckList.get(0));
				stmt.setInt(2, ckList.get(1));
				stmt.setInt(3, ckList.get(2));
				stmt.setInt(4, ckList.get(3));
			} else if(ckList.size() == 5) {
				sql = sql + "(?, ?, ?, ?, ?)";
				stmt = conn.prepareStatement(sql);
				stmt.setInt(1, ckList.get(0));
				stmt.setInt(2, ckList.get(1));
				stmt.setInt(3, ckList.get(2));
				stmt.setInt(4, ckList.get(3));
				stmt.setInt(5, ckList.get(4));
			}
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Emp e = new Emp();
				e.setEname(rs.getString("ename"));
				e.setGrade(rs.getInt("grade"));
			}
					
			return list;
		}
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
				/* e.ename = rs.getString("ename"); */
				e.sal = rs.getInt("sal");
				list.add(e);
			}
		return list;	
	}
	/*
	 * if(ckList.get) ReasultSet rs = stmt.excuteQuery(); while(rs.getString) else
	 * if(ckList)
	 */
}

/*
 * package dao;
 * 
 * import java.sql.Connection; import java.sql.PreparedStatement; import
 * java.sql.ResultSet; import java.util.ArrayList; import java.util.HashMap;
 * 
 * import vo.DBHelper; import vo.Dept;
 * 
 * public class DeptDAO { public static ArrayList<HashMap<String, Object>>
 * selectDeptOnOffList() throws Exception { ArrayList<HashMap<String, Object>>
 * list = new ArrayList<>();
 * 
 * Connection conn = DBHelper.getConnection(); String sql = "select " +
 * "deptno deptNo, dname, loc, 'ON' OnOff " + "FROM dept "; PreparedStatement
 * stmt = null; stmt = conn.prepareStatement(sql); ResultSet rs = null; rs =
 * stmt.executeQuery(); while(rs.next()) { HashMap<String, Object> m = new
 * HashMap<>(); m.put("deptNo", rs.getInt("deptNo")); m.put("dname",
 * rs.getString("dname")); m.put("loc", rs.getString("loc")); m.put("OnOff",
 * rs.getString("OnOff"));
 * 
 * list.add(m); }
 * 
 * return list; }
 * 
 * public static ArrayList<Dept> selectDeptList() throws Exception {
 * ArrayList<Dept> list = new ArrayList<>();
 * 
 * Connection conn = DBHelper.getConnection(); String sql = "SELECT " +
 * " deptno deptNo, dname, loc " + " FROM dept"; PreparedStatement stmt = null;
 * stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery();
 * while(rs.next()) { Dept d = new Dept(); d.deptNo = rs.getInt("deptNo");
 * d.dname = rs.getString("dname"); d.loc = rs.getString("loc");
 * 
 * list.add(d); } return list; }
 * 
 * }
 */
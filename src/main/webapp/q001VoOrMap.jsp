<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>
<%@ page import = "vo.*" %>
<%@ page import = "dao.*" %>
<%
	ArrayList<Dept> deptList = DeptDAO.selectDeptList();
	ArrayList<Emp> emplist = EmpDAO.selectEmpList();
	ArrayList<HashMap<String, Object>> deptOnOffList = DeptDAO.selectDeptOnOffList();
	ArrayList<HashMap<String, Object>> EmpAndDeptList = EmpDAO.selectEmpAndDeptList();
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>예제</title>
</head>
<body>
	<h1>DEPT LIST</h1>
	<table border="1">
		<tr>
			<th>deptNo</th>
			<th>dname</th>
			<th>loc</th>
		</tr>
		<%
			for(Dept d : deptList){
		%>
			<tr>
				<td><%=d.deptNo%></td>
				<td><%=d.dname%></td>
				<td><%=d.loc %></td>
			</tr>
		<%
			}
		%>
	</table>
	<h1>EMP LIST</h1>
	<table border="1">
		<tr>
			<td>empNo</td>
			<td>ename</td>
			<td>sal</td>
		</tr>
		<%
			for(Emp e : emplist){
		%>
			<tr>
				<td><%=e.empno%></td>
				<td><%=e.ename%></td>
				<td><%=e.sal%></td>
			</tr>
		<%
			}
		%>
	</table>
	<h1>Dept + OnOff List</h1>
		<table border ="1">
			<tr>
				<td>deptNo</td>
				<td>dname</td>
				<td>loc</td>
				<td>OnOff</td>
			</tr>
			<%
				for(HashMap<String, Object> dol:  deptOnOffList){
			%>
				<tr>
					<td>(Integer) <%=dol.get("deptNo")%></td>
					<td>(String) <%=dol.get("dname")%></td>
					<td>(String) <%=dol.get("loc")%></td>
					<td>(String)<%=dol.get("OnOff")%></td>
				</tr>
			<%
				}
			%>
		</table>
	<h1>Emp INNER JOIN Dept List</h1>
	<table border ="1">
		<tr>
			<td>empNo</td>
			<td>empName</td>
			<td>deptNo</td>
			<td>dname</td>
		</tr>
		<%
			for(HashMap<String, Object> ed : EmpAndDeptList) {
		%>
			<tr>
				<td><%=(Integer)(ed.get("empNo"))%></td>
				<td><%=(String)(ed.get("ename"))%></td>
				<td><%=(Integer)(ed.get("deptNo"))%></td>
				<td><%=(String)(ed.get("dname"))%></td>
			</tr>
		<%
			}
		%>
	</table>
</body>
</html>
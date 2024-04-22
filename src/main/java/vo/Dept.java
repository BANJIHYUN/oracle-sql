package vo;

// VO(Value Object)> DTO(Data Transfer Object) Domain(속성 값의 범위)

public class Dept {

	private int deptNo;
	private String dname;
	private String loc;
	private int getDeptNo() {
		return deptNo;
	}
	private void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}
	private String getDname() {
		return dname;
	}
	private void setDname(String dname) {
		this.dname = dname;
	}
	private String getLoc() {
		return loc;
	}
	private void setLoc(String loc) {
		this.loc = loc;
	}
}
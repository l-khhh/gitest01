//value object
//인터페이스 테이블을 위한 jobuservo 객체


package myspring.user.vo;

public class JobUserVO {

	private String Id;
	private String name;
	private	String sex;
	private String position;
	private String dept;
	private String sal;
	private String state;

	public JobUserVO() {}
	
	public JobUserVO(String Id, String name, String sex, String position, String dept, String sal, String state) {
		this.Id = Id;
		this.name = name;
		this.sex = sex;
		this.position = position;
		this.dept = dept;
		this.sal = sal;
		this.state=state;
	}

	
	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getSal() {
		return sal;
	}

	public void setSal(String sal) {
		this.sal = sal;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String toString() {
		return "User [Id=" + Id + ", name=" + name + ", gender="
				+ sex + ", position=" + position +  ", dept" + dept  +", sal=" + sal +", state=" + state+"]";
	}
	
}

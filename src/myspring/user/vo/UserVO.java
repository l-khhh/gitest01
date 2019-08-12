//value object
//인터페이스 테이블을 위한 uservo 객체

package myspring.user.vo;

public class UserVO {

	private String Id;
	private String name;
	private	String sex;
	private String position;
	private String dept;
	private String sal;

	public UserVO() {}
	
	public UserVO(String Id, String name, String sex, String position, String dept, String sal) {
		this.Id = Id;
		this.name = name;
		this.sex = sex;
		this.position = position;
		this.dept = dept;
		this.sal = sal;
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

	public String toString() {
		return "User [Id=" + Id + ", name=" + name + ", gender="
				+ sex + ", position=" + position +  ", dept" + dept  +", sal=" + sal +"]";
	}
	
}

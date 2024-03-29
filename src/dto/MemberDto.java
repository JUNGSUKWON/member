package dto;

public class MemberDto {
	
	//번호
	private int num;
	
	//이름
	private String name;
	
	//전공
	private String major;
	
	@Override
	public String toString() {
		return "MemberDto [num=" + num + ", name=" + name + ", major=" + major + ", email=" + email + "]";
	}

	//이메일
	private String email;
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}




	

}

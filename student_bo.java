package student_bo;

public class student_bo 
{
	private String user_name,mob,email,dob,pass,con_pass;

	public String getUser_name() {
		return user_name;
	}

	public String getMob() {
		return mob;
	}

	public String getEmail() {
		return email;
	}

	public String getDob() {
		return dob;
	}

	public String getPass() {
		return pass;
	}

	public String getCon_pass() {
		return con_pass;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public void setMob(String mob) {
		this.mob = mob;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public void setCon_pass(String con_pass) {
		this.con_pass = con_pass;
	}
	

	public student_bo(String user_name, String mob, String email, String dob, String pass, String con_pass) {
		super();
		this.user_name = user_name;
		this.mob = mob;
		this.email = email;
		this.dob = dob;
		this.pass = pass;
		this.con_pass = con_pass;
	}

	public student_bo() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "student_bo [user_name=" + user_name + ", mob=" + mob + ", email=" + email + ", dob=" + dob + ", pass="
				+ pass + ", con_pass=" + con_pass + "]";
	}
	
}

package student_bo;

public class emp_bo 
{
	private int id;
    private String name;
    private String email;
    private String phone;
    private String doj;
    private String dob;
    private String adhar;
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public String getPhone() {
		return phone;
	}
	public String getDoj() {
		return doj;
	}
	public String getDob() {
		return dob;
	}
	public String getAdhar() {
		return adhar;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setDoj(String doj) {
		this.doj = doj;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public void setAdhar(String adhar) {
		this.adhar = adhar;
	}
	@Override
	public String toString() {
		return "emp_bo [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", doj=" + doj
				+ ", dob=" + dob + ", adhar=" + adhar + "]";
	}
	public emp_bo(int id, String name, String email, String phone, String doj, String dob, String adhar) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.doj = doj;
		this.dob = dob;
		this.adhar = adhar;
	}
	public emp_bo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}

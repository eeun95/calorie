package member.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Member implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 794607514232733095L;
	private String member_id;
	private String member_pw;
	private String member_name;
	private String gender;
	private String phone;
	private String email;
	private String address;
	private Date member_date;
	
	public Member() {}

	public Member(String member_id, String member_pw, String member_name, String gender, String phone, String email,
			String address, Date member_date) {
		this.member_id = member_id;
		this.member_pw = member_pw;
		this.member_name = member_name;
		this.gender = gender;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.member_date = member_date;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getMember_pw() {
		return member_pw;
	}

	public void setMember_pw(String member_pw) {
		this.member_pw = member_pw;
	}

	public String getMember_name() {
		return member_name;
	}

	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getMember_date() {
		return member_date;
	}

	public void setMember_date(Date member_date) {
		this.member_date = member_date;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Member [member_id=" + member_id + ", member_pw=" + member_pw + ", member_name=" + member_name
				+ ", gender=" + gender + ", phone=" + phone + ", email=" + email + ", address=" + address
				+ ", member_date=" + member_date + "]";
	}
	
	
}

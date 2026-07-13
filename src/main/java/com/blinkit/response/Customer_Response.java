package com.blinkit.response;

public class Customer_Response {
	private long custId;
	private String custName;
	private String custEmail;
	private Long custPhone;
	private Integer custAge;
	private String custStatus;

	public String getCustEmail() {
		return custEmail;
	}

	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}

	public Long getCustPhone() {
		return custPhone;
	}

	public void setCustPhone(Long custPhone) {
		this.custPhone = custPhone;
	}

	public long getCustId() {
		return custId;
	}

	public void setCustId(long custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public Integer getCustAge() {
		return custAge;
	}

	public void setCustAge(Integer custAge) {
		this.custAge = custAge;
	}

	public String getCustStatus() {
		return custStatus;
	}

	public void setCustStatus(String custStatus) {
		this.custStatus = custStatus;
	}
}

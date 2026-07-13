package com.blinkit.requestDTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CustomerRequest {
	@NotBlank(message = "Customer name is required")
	@Size(min = 3, max = 50)
	private String custName;

	@Email(message = "Invalid email address")
	@NotBlank(message = "Email is required")
	private String custEmail;

	@NotNull(message = "Phone number is required")
	private Long custPhone;

	@NotNull(message = "password is required")
	private String password;

	@NotNull(message = "Confirm password is required")
	private String confirmPassword;

	@NotNull(message = "Age is required")
	@Min(18)
	@Max(100)
	private Integer custAge;

	@NotBlank(message = "Status is Required")
	private String custStatus;

	// getters setters
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

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustStatus() {
		return custStatus;
	}

	public Integer getCustAge() {
		return custAge;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public void setCustAge(Integer custAge) {
		this.custAge = custAge;
	}

	public void setCustStatus(String custStatus) {
		this.custStatus = custStatus;
	}
}

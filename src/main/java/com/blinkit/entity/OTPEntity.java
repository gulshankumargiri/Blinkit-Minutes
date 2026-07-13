package com.blinkit.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "otp")
public class OTPEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long otpId;

	private String status;
	private int otp;

	public long getOtpId() {
		return otpId;
	}

	public void setOtpId(long otpId) {
		this.otpId = otpId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getOtp() {
		return otp;
	}

	public void setOtp(int otp) {
		this.otp = otp;
	}

}

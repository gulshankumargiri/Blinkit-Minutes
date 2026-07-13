package com.blinkit.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "customers")
public class CustomerEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long custId;

	@Column(nullable = false)
	private String custName;

	@Column(nullable = false, unique = true)
	private String custEmail;

	@Column(nullable = false, unique = true)
	private Long custPhone;

	@Column(nullable = false)
	private String password;

	@Column(nullable = false)
	private Integer custAge;

	@Column(nullable = false)
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

	@OneToMany(mappedBy = "customerEntity", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<OrderEntity> orderEntities;

	public long getCustId() {
		return custId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public List<OrderEntity> getOrderEntities() {
		return orderEntities;
	}

	public void setOrderEntities(List<OrderEntity> orderEntities) {
		this.orderEntities = orderEntities;
	}

}

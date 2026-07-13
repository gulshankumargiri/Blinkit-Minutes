package com.blinkit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blinkit.entity.OTPEntity;

public interface OTPRepository extends JpaRepository<OTPEntity, Long> {

}

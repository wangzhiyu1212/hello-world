package com.example.helloworld.entity;

import lombok.Data;

/**
 * policyInfo
 */
@Data
public class PolicyInfo {
	private Integer policyId;
	private String policyNo;
	private Integer insuranceId;
	private Integer policyHolderId;
	private Integer packageId;
}

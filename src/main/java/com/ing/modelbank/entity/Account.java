package com.ing.modelbank.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Account implements Serializable{

	private static final long serialVersionUID = 2880381434860074260L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long accountId;
	private Integer accountNumber;
	private double balance;
	private String accountType;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customerId", referencedColumnName = "customerId")
	private Customer customer;


}

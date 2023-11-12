package com.employee.entity;

import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.lang.NonNull;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table (name = "empSystem")
public @Data class Employee {

	@Id
	@GeneratedValue(strategy =GenerationType.AUTO , generator = "native")
	@GenericGenerator(strategy = "native", name = "native")
	private int id;
	
	private String firstName;
	private String lastName;
	private String street;
	private String address;
	private String city;
	private String state;
	private String email;
	private String phone;
	
}

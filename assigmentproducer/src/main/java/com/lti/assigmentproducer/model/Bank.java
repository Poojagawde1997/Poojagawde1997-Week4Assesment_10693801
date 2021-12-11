package com.lti.assigmentproducer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bank")
public class Bank {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Integer id;
	@Column(name="name")
	private String name;
	@Column(name="age")
	private long age;
	@Column(name="address")
	private String address;
	@Column(name="typeofacc")
	private String typeofacc;
	public Bank() {
		super();

	}
	public Bank(Integer id, String name, long age, String address, String typeofacc) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.address = address;
		this.typeofacc = typeofacc;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getAge() {
		return age;
	}
	public void setAge(long age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTypeofacc() {
		return typeofacc;
	}
	public void setTypeofacc(String typeofacc) {
		this.typeofacc = typeofacc;
	}
	@Override
	public String toString() {
		return "Bank [id=" + id + ", name=" + name + ", age=" + age + ", address=" + address + ", typeofacc="
				+ typeofacc + "]";
	}
	
	
}

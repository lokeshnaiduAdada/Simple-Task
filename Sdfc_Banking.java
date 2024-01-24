package com.web.entity;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Sdfc_Banking {
	@Id
	private long accno;
	private String name;
	private String psw;
	private double amount;
	private long mno;
	private String address;
	private String status;
	public Sdfc_Banking() {
		super();
	}
	public Sdfc_Banking(long accno, String name, String psw, double amount, long mno, String address, String status) {
		super();
		this.accno = accno;
		this.name = name;
		this.psw = psw;
		this.amount = amount;
		this.mno = mno;
		this.address = address;
		this.status = status;
	}
	public long getAccno() {
		return accno;
	}
	public void setAccno(long accno) {
		this.accno = accno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPsw() {
		return psw;
	}
	public void setPsw(String psw) {
		this.psw = psw;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public long getMno() {
		return mno;
	}
	public void setMno(long mno) {
		this.mno = mno;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Sdfc_Banking [accno=" + accno + ", name=" + name + ", psw=" + psw + ", amount=" + amount + ", mno="
				+ mno + ", address=" + address + ", status=" + status + "]";
	}
	
	

}

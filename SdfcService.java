package com.web.service;

import com.web.entity.Sdfc_Banking;

public interface SdfcService {
	public String save(Sdfc_Banking bank,String cpsw,String psw);
	public String login(Sdfc_Banking bank,long accno,String name,String psw);
	public Sdfc_Banking Balance(Sdfc_Banking bank);
	public String deposite(Sdfc_Banking bank,double amount);
	public String withDraw(Sdfc_Banking bank,double amount);
	public String transfer(Sdfc_Banking bank,long accno,double amount,long taccno);
	public Sdfc_Banking close(Sdfc_Banking bank);
}

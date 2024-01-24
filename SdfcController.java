package com.web.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.entity.Sdfc_Banking;
import com.web.service.SdfcServiceImp;

@Controller
public class SdfcController {
	
	@Autowired
	private SdfcServiceImp service;
	@GetMapping("/")
	public String home()
	{
		return "home";
	}
	
	@GetMapping("/home")
	public String display()
	{
		return "home";
	}
	
	@GetMapping("/account")
	public String newAccountForm()
	{
		return "newaccount";
	}
	
	@GetMapping("/newaccount")
	public String Register(ModelMap model, Sdfc_Banking bank, @RequestParam String cpsw, @RequestParam String psw)
	{
		model.put("view",service.save(bank,cpsw,psw));
		return "accountadded";
	}
	
	@GetMapping("/login")
	public String LoginForm()
	{
		return "loginform";
	}
	
	@PostMapping("/userlogin")
	public String login(ModelMap model, Sdfc_Banking bank,@RequestParam long accno,@RequestParam String name,@RequestParam String psw)
	{
		model.put("view",service.login(bank,accno,name,psw));
		return "service";
	}
	
	@GetMapping("/balance")
	public String balanceForm()
	{
		return "balance";
	}
	
	@PostMapping("/Accnobalance")
	public String Balance(Sdfc_Banking bank,ModelMap model)
	{
		model.put("balance", service.Balance(bank));
		return "viewbalance";
	}
	
	@GetMapping("/deposite")
	public String depoiteForm()
	{
		return "deposit";
	}
	
	@PostMapping("/amountdeposite")
	public String deposite(ModelMap model,Sdfc_Banking bank,@RequestParam double amount)
	{
		model.put("view", service.deposite(bank,amount));
		return "depositesuccess";
	}
	
	@GetMapping("/withdraw")
	public String withdrawForm()
	{
		return "withdraw";
	}
	
	@GetMapping("/amountwithdraw")
	public String withdraw(ModelMap model, Sdfc_Banking bank,@RequestParam double amount)
	{
		model.put("view", service.withDraw(bank, amount));
		return "withdrawsuccess";
	}
	
	@GetMapping("/transfer")
	public String TransferForm()
	{
		return "transfer";
	}
	
	@PostMapping("/amttransfer")
	public String Transfer(ModelMap model,Sdfc_Banking bank,@RequestParam long accno,@RequestParam long taccno,@RequestParam double amount)
	{
		model.put("view",service.transfer(bank,accno,amount,taccno));
		return "transfersuccess";
	}
	
	@GetMapping("/close")
	public String closeForm()
	{
		return "close";
	}
	
	@PostMapping("/closeaccno")
	public String Close(ModelMap model, Sdfc_Banking bank)
	{
		model.put("view", service.close(bank));
		return "closesucess";
	}
	
	@GetMapping("/about")
	public String aboutUs()
	{
		return "aboutus";
	}
	
	@GetMapping("/aboutus")
	public String about()
	{
		return "aboutus1";
	}
}

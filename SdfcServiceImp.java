package com.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.InputMismatchException;

import com.web.entity.Sdfc_Banking;
import com.web.repo.SdfcRepo;
@Service
public class SdfcServiceImp implements SdfcService {
	
	@Autowired
	private SdfcRepo repo;
	
	public String save(Sdfc_Banking bank,String cpsw,String psw) 
	{
		
		if(cpsw.equals(psw))
		{
			repo.save(bank);
			return "successfully account created......";
		}
		else
		{
			return "Account creation Failed...."+" "+"Please give Valid Input....."; 
		}
	}

	@Override
	public String login(Sdfc_Banking bank,long accno,String name,String psw) {
		Sdfc_Banking data= repo.findById(accno).get();
		if(data.getStatus().equals("1"))
		{
			if(data.getAccno()==accno && data.getName().equals(name) && data.getPsw().equals(psw))
			{
				return "Successfully login....";
			}
			else
			{
				return "login Failed...Invalid Credentials...";
			}
		}
		else
		{
			return "Before Login Please Activate your Account";
		}
	}

	@Override
	public Sdfc_Banking Balance(Sdfc_Banking bank) 
	{
		Sdfc_Banking data=repo.findById(bank.getAccno()).get();
		return data;
	}

	@Override
	public String deposite(Sdfc_Banking bank,double amount) {
		Sdfc_Banking data=repo.findById(bank.getAccno()).get();
		if(data.getStatus().equals("1"))
		{
			if(data.getAccno()==bank.getAccno() && data.getName().equals(bank.getName()) && data.getPsw().equals(bank.getPsw()))
			{
				double amount1=amount+data.getAmount();
				data.setAmount(amount1);
				repo.save(data);
				return "Deposite Success...";
			}
			else
			{
				return "Invalid Credentials";
			}
		}
		else
		{
			return "Please Activate your Account...";
		}
		
	}

	@Override
	public String withDraw(Sdfc_Banking bank,double amount) {
		Sdfc_Banking data=repo.findById(bank.getAccno()).get();
		if(data.getStatus().equals("1"))
		{
			if(data.getAccno()==bank.getAccno() && data.getName().equals(bank.getName()) && data.getPsw().equals(bank.getPsw()))
			{
				double amount1=data.getAmount()-amount;
				data.setAmount(amount1);
				repo.save(data);
				return "Withdraw Success...";
			}
			else
			{
				return "Invalid Credentials";
			}
		}
		else
		{
			return "Please Activate your Account...";
		}
	}
	
	@Override
	public String transfer(Sdfc_Banking bank,long accno,double amount,long taccno) {
		Sdfc_Banking curr_acc=repo.findById(accno).get();
		Sdfc_Banking des_acc=repo.findById(taccno).get();
		if(curr_acc.getAccno()==accno && des_acc.getAccno()==taccno)
		{
			if(curr_acc.getStatus().equals("1"))
			{
				if(des_acc.getStatus().equals("1"))
				{
					double curr_amount=curr_acc.getAmount()-amount;
					curr_acc.setAmount(curr_amount);
					repo.save(curr_acc);
					double des_amount=des_acc.getAmount()+amount;
					des_acc.setAmount(des_amount);
					repo.save(des_acc);
					return "Transfer Success....";
				}
				else
				{
					return "Destination Account was Deactivated";
				}
			}
			else
			{
				return "Please activate Current Account";
			}
		}
		else
		{
			return "Something went Wrong";
		}
	}

	@Override
	public Sdfc_Banking close(Sdfc_Banking bank) {
		Sdfc_Banking data=repo.findById(bank.getAccno()).get();
		data.setStatus("0");
		repo.save(data);
		return data;
	}

}

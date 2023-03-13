package com.example.paymentgateway.paymentgateway;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ItemService {

List<Transaction> lst;
	
	public ItemService() {
		lst=new ArrayList<>();
		lst.add(new Transaction(101,2,350,LocalDateTime.now()));
		}
	
	public List<Transaction> getLst() {
		return lst;
	}

	public void setLst(List<Transaction> lst) {
		this.lst = lst;
	}
    
	


	public List<Transaction> getTransactions(){
		try {
			return lst;
		}
		catch(Exception e)
		{
			System.out.println("exception occurred in getting transactions");
		}
		return null;
	}
	public Transaction makePayment(Transaction t)
	{
		try{
			lst.add(t);
		}
		catch(Exception e){
		   System.out.println("Exception occured in service");	
		}
		return t;
	}
}

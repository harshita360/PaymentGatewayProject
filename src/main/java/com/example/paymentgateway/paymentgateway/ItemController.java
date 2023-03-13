package com.example.paymentgateway.paymentgateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {
	
	@Autowired
	ItemService itemservice;
	
	
	
	@GetMapping("/getpayments")
	public ResponseEntity<List<Transaction>> getallTransactions(){
		try {
			List<Transaction> lst=itemservice.getTransactions();
			return ResponseEntity.ok(lst);
		}
		catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,"Server error",e);
		}
	
	 
	 
	}
	
    @PostMapping("/makepayment")
	public ResponseEntity<Transaction> makePaymentUtil(@RequestBody Item item) 
	{
		
    try {
    	Transaction transaction=itemservice.makePayment(new Transaction(105,item.getId(),item.getPrice(),LocalDateTime.now()));
    	return ResponseEntity.status(HttpStatus.CREATED).body(transaction);   	
    }
    catch(Exception e)
    {
    	e.printStackTrace();
    	throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,"Server error",e);
    }
	
	}
	
	
	
}

//package com.example.paymentgateway.paymentgateway;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//
//public class ItemServiceTest {
//	
//	Item item;
//	Transaction t1;
//	Transaction t2;
//	
//	ItemService s
//  
//	@BeforeEach
//	public void setUp() {
//	  item = new Item(1,"item1",280);
//	  
//	  t1 = new Transaction(105,item.getId(),item.getPrice(),LocalDateTime.now());
//	  t2 = new Transaction(106,item.getId(),item.getPrice(),LocalDateTime.now());
//	  
//	}
//	
//	@Test
//	public void testmaketransaction()
//	{
//		int l1=this.itemservice.getLst().size();
//		assertNotNull(l1);
//		
//	}
//}
package com.example.paymentgateway.paymentgateway;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

@ExtendWith(MockitoExtension.class)
public class ItemServiceTest {
	
	@InjectMocks
	ItemService itemservice;
	
	Item item;
	Transaction t1;
	Transaction t2;
	
  
	@BeforeEach
	public void setUp() {
	  item = new Item(1,"item1",280);
	  
	  t1 = new Transaction(105,item.getId(),item.getPrice(),LocalDateTime.now());
	  t2 = new Transaction(106,item.getId(),item.getPrice(),LocalDateTime.now());
	  
	}
	
	
	@DisplayName("should add transaction to the lst")
	@Test
	public void testmaketransactionSuccess()
	{
		int l1=itemservice.getLst().size();
		Transaction t=itemservice.makePayment(t1);
		assertEquals(itemservice.getLst().size(),l1+1);
	}
	
	@DisplayName("should add correct values")
	@Test
	public void testcheckTransactionResponse() {
		Transaction t=itemservice.makePayment(t1);
		int size=itemservice.getLst().size();
		assertEquals(itemservice.getLst().get(size-1).getTotal(),280);
		
	}
	
	@DisplayName("should return all transactions")
	@Test
	public void testGetAllTransactionsSuccess() {
		assertNotNull(itemservice.getTransactions());
	}
	
	
	

}


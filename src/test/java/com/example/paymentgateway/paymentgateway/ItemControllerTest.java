package com.example.paymentgateway.paymentgateway;

import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(controllers = ItemController.class)
public class ItemControllerTest {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	ItemService itemservice;

	Item item;
	Transaction t;

	@BeforeEach
	public void setUp() {
		item = new Item(1, "item1", 200);
		t = new Transaction(105, item.getId(), item.getPrice(), LocalDateTime.now());

	}

	@DisplayName("should get all the payment transactions")
	@Test
	void testGetPayments() throws Exception {
		String url = "http://localhost:8080/items/getpayments";
		mockMvc.perform(get(url)).andExpect(status().isOk());
	}

	@DisplayName("should successfully add a transaction")
	@Test
	void testmakePayment() throws Exception {
		String url = "http://localhost:8080/items/makepayment";
		Mockito.when(itemservice.makePayment(Mockito.any(Transaction.class))).thenReturn(t);

		mockMvc.perform(MockMvcRequestBuilders.post(url).content(asJsonString(item))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated());
	}
	
	@DisplayName("Raise error on bad request")
	@Test
	void testmakePaymentFailure() throws Exception {
		String url = "http://localhost:8080/items/payment";
		Mockito.when(itemservice.makePayment(Mockito.any(Transaction.class))).thenThrow(ResponseStatusException.class);
		mockMvc.perform(MockMvcRequestBuilders.post(url).content(asJsonString(item))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().is4xxClientError());
		
	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}
}

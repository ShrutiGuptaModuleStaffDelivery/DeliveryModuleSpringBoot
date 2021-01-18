package com.egas.delivery.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


import com.egas.delivery.entity.CustomerGasBooking;
import com.egas.delivery.entity.Staff_Member;
import com.egas.delivery.repository.CustomerAccessoriesBookingRepository;
import com.egas.delivery.repository.CustomerGasBookingRepository;
import com.egas.delivery.repository.StaffMemberRepository;
import com.egas.delivery.service.StaffMemberServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class TestStaffMemberController {

	private static final ObjectMapper om = new ObjectMapper();
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private StaffMemberServiceImpl staffService;
	
	@MockBean
	private StaffMemberRepository staffMemberRepository;
	
	@MockBean
	private CustomerGasBookingRepository gasRepository;
	
	@MockBean
	private CustomerAccessoriesBookingRepository accessoriesRepository;
	
	@Test
	public void saveStaffMember() throws Exception{
		
		Staff_Member newStaff=new Staff_Member(1,"GHTRE7895T","Ayush","Shrivastava","male","Mumbai","ayush123@gmail.com","9403802748","ayush$321","Pending");
		when(staffMemberRepository.save(any(Staff_Member.class))).thenReturn(newStaff);
		
		mockMvc.perform(MockMvcRequestBuilders.post("/staffmembers/register")
				.content(om.writeValueAsString(newStaff))
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated())
				.andExpect(jsonPath("$.staffId").value(1))
				.andExpect(jsonPath("$.pancardNumber").value("GHTRE7895T"))
				.andExpect(jsonPath("$.fname").value("Ayush"))
				.andExpect(jsonPath("$.lname").value("Shrivastava"))
				.andExpect(jsonPath("$.gender").value("male"))
				.andExpect(jsonPath("$.city").value("Mumbai"))
				.andExpect(jsonPath("$.email").value("ayush123@gmail.com"))
				.andExpect(jsonPath("$.contact").value("9403802748"))
				.andExpect(jsonPath("$.password").value("ayush$321"))
				.andExpect(jsonPath("$.status").value("Pending"));
		
		verify(staffMemberRepository, times(1)).save(any(Staff_Member.class));
		
	}
	
	@Test
	public void viewCustomerGasBooking() throws Exception
	{
		CustomerGasBooking customer1=new CustomerGasBooking("AGSFT2323T","Shruti","Gupta","Maharashtra","Nagpur","Chatrapati Square","8346378373");
		CustomerGasBooking customer2=new CustomerGasBooking("AGSFR2323E","Shivani","Manchewar","Maharashtra","Nagpur","Shivaji Square","8327439295");
		List<CustomerGasBooking> custGas=new ArrayList<>();
		custGas.add(customer1);
		custGas.add(customer2);
		
		when(staffService.getAllCustomerGasBooking()).thenReturn(custGas);
		
		mockMvc.perform(MockMvcRequestBuilders.get("/staffmembers/getCustomerGasBooking"))
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$").value(hasSize(2)))
		.andExpect(jsonPath("$[0].custPancard").value("AGSFT2323T"))
		.andExpect(jsonPath("$[0].custFirstName").value("Shruti"))
		.andExpect(jsonPath("$[0].custLastName").value("Gupta"))
		.andExpect(jsonPath("$[0].custState").value("Maharashtra"))
		.andExpect(jsonPath("$[0].custCity").value("Nagpur"))
		.andExpect(jsonPath("$[0].custAddress").value("Chatrapati Square"))
		.andExpect(jsonPath("$[0].custContact").value("8346378373"))
		.andExpect(jsonPath("$[1].custPancard").value("AGSFR2323E"))
		.andExpect(jsonPath("$[1].custFirstName").value("Shivani"))
		.andExpect(jsonPath("$[1].custLastName").value("Manchewar"))
		.andExpect(jsonPath("$[1].custState").value("Maharashtra"))
		.andExpect(jsonPath("$[1].custCity").value("Nagpur"))
		.andExpect(jsonPath("$[1].custAddress").value("Shivaji Square"))
		.andExpect(jsonPath("$[1].custContact").value("8327439295"));
		
		verify(staffService,times(1)).getAllCustomerGasBooking();
		
		}
	
//	@Test
//	public void testFindByCity() throws Exception
//	{
//		CustomerGasBooking c1=new CustomerGasBooking(1,"AGSFT2323T","Shruti","Gupta","Maharashtra","Nagpur","Chatrapati Square","8346378373");
//		List<CustomerGasBooking> custGas=new ArrayList<>();
//		custGas.add(c1);
//		Mockito.when(staffService.findByCustCity(Mockito.anyString())).thenReturn(custGas);
//		String URI="/staffmembers/custCity/Nagpur";
//		
//		RequestBuilder requestBuilder=MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON);
//		MvcResult result=mockMvc.perform(requestBuilder).andReturn();
//		String expectedJson=this.mapToJson(c1);
//		String outputInJson=result.getResponse().getContentAsString();
//		assertThat(outputInJson).isEqualTo(expectedJson);
//		
//		
//		
//	}

	private String mapToJson(Object object) throws JsonProcessingException {
		// TODO Auto-generated method stub
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(object);
	}
	}
	


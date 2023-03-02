package com.stg.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stg.model.Hostel;
import com.stg.service.HostelService;

//@MockitoSettings(strictness = Strictness.LENIENT)
@ExtendWith(MockitoExtension.class)
class HostelControllerTest {

	@Mock
	private HostelService hostelService;

	@InjectMocks
	private Hostelcontroller hostelController;

	@Autowired
	private MockMvc mockMvc;

	private Hostel hostel;

	private ObjectMapper mapper = new ObjectMapper();

	@BeforeEach
	void setUp() throws Exception {
		//hostel = Hostel.builder().hostCode(10).hostName("Hello").city("chennai").build();

		this.mockMvc = MockMvcBuilders.standaloneSetup(hostelController).build();
	}

	@Test
	void testCreatehost() throws Exception {

		//Hostel newHostel = Hostel.builder().hostCode(10).hostName("Hello").city("chennai").build();

		//Mockito.when(hostelService.createhost(newHostel)).thenReturn(newHostel);

//		Hostel hostel2 = hostelController.createhost(hostel).getBody();
//		
//		Assertions.assertNotNull(hostel2);

		//String hostelObj = mapper.writeValueAsString(newHostel);

		//ResultActions response = mockMvc
				//.perform(MockMvcRequestBuilders.post("/host/hostel").contentType(MediaType.APPLICATION_JSON_VALUE)
						//.accept(MediaType.APPLICATION_JSON_VALUE).content(hostelObj));

		//response.andDo(MockMvcResultHandlers.print()).andExpect(status().isCreated())
		//		.andExpect(jsonPath("$", notNullValue())).andExpect(jsonPath("$.hostName", is(hostel.getHostName())));
//		
//		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/host/hostel")
//				.contentType(MediaType.APPLICATION_JSON_VALUE).accept(MediaType.APPLICATION_JSON_VALUE)
//				.content(hostelObj);
//
//		// then - verify the result or output using assert statements
//		mockMvc.perform(mockRequest).andDo(MockMvcResultHandlers.print()).andExpect(status().isCreated())
//				.andExpect(jsonPath("$", notNullValue(null))).andExpect(jsonPath("$.hostName", is(hostel.getHostName())));

	}

//	Hostel hostel2 = hostelController.createhost(hostel).getBody();
//	assertEquals(hostel2.getHostName(), hostel.getHostName());

//	@Test
//	void testReadByHostCode() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testReadHostByName() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetAll() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetHostelByHostCode() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testUpdateHost() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testDeleteHostByCode() {
//		fail("Not yet implemented");
//	}

}

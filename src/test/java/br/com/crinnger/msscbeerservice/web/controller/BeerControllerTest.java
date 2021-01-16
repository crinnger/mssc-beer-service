package br.com.crinnger.msscbeerservice.web.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.UUID;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.crinnger.msscbeerservice.web.model.BeerDto;

@WebMvcTest(BeerController.class)
class BeerControllerTest {

	@Autowired
	MockMvc mockMvc;
	
	@Autowired
	ObjectMapper objectMapper;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@Test
	void testGetBeerById() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/beer/" + UUID.randomUUID().toString())
				                              .accept(MediaType.APPLICATION_JSON))
				       .andExpect(MockMvcResultMatchers.status().isOk());		
	}

	@Test
	void testSaveNewBeerBeerDto()  throws Exception{
		BeerDto beerDto=BeerDto.builder().build();
		String jsonBeerDto=objectMapper.writeValueAsString(beerDto);
		mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/beer/")
				.contentType(MediaType.APPLICATION_JSON)
				.content(jsonBeerDto))
				.andExpect(MockMvcResultMatchers.status().isCreated());
	}

	@Test
	void testSaveNewBeerUUIDBeerDto() throws Exception {
		BeerDto beerDto=BeerDto.builder().build();
		String jsonBeerDto=objectMapper.writeValueAsString(beerDto);
		mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/beer/" + UUID.randomUUID().toString())
				.contentType(MediaType.APPLICATION_JSON)
				.content(jsonBeerDto))
				.andExpect(MockMvcResultMatchers.status().isNoContent());
	}

}

package com.cs.validation.web;

import com.cs.ValidationApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ValidationApplication.class)
@WebAppConfiguration
public class ValidationControllerTest {

	@Autowired
	private WebApplicationContext context;

	private MockMvc mvc;

	@Before
	public void setUp() {
		mvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@Test
	public void shouldValidateSuccessWhenCorrectTradeGiven() throws Exception {
		mvc.perform(post("/validate").content(readFile("emp.json")).contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(jsonPath("$[0].validationStatus", is("success")));
	}

	@Test
	public void shouldValidationFailWhenIncorrectTradeGiven() throws Exception {
		mvc.perform(post("/validate").content(readFile("valueDateAfterTradeDate.json")).contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(jsonPath("$[0].validationStatus", is("failed")))
				.andExpect(jsonPath("$[0].failedReasons", hasSize(1)))
				.andExpect(jsonPath("$[0].failedReasons[0]", is("Value date cannot be after trade date.")));
	}

	@Test
	public void shouldValidationFailForInputWithManyTrades() throws Exception {
		mvc.perform(post("/validate").content(readFile("manyIncorrectTrades.json")).contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(jsonPath("$[0].validationStatus", is("failed")))
				.andExpect(jsonPath("$[0].failedReasons", hasSize(2)))
				.andExpect(jsonPath("$[0].failedReasons", hasItems("Value date cannot be after trade date.", "Value date cannot fall on weekend or non-working day.")))
				.andExpect(jsonPath("$[1].validationStatus", is("failed")))
				.andExpect(jsonPath("$[1].failedReasons", hasSize(1)))
				.andExpect(jsonPath("$[1].failedReasons", hasItem("Value date cannot be after trade date.")));
	}

	private String readFile(String fileName) {
		try {
			ClassLoader classLoader = getClass().getClassLoader();
			File file = new File(classLoader.getResource(fileName).getFile());
			return new String(Files.readAllBytes(file.toPath()));
		} catch (IOException e) {
			throw new IllegalArgumentException("File not found: " + fileName, e);
		}
	}
}
package com.qa.cardatabase;

import com.qa.cardatabase.web.CarController;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
//@AutoConfigureMockMvc
class CardatabaseApplicationTests {

	@Autowired
	private CarController carController;

//	@Autowired
//	private MockMvc mockMvc;

	@Test
	void contextLoads() {
		assertThat(carController).isNotNull();
	}

}

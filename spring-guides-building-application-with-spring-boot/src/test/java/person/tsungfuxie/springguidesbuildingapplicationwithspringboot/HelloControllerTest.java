/**
 * 
 */
package person.tsungfuxie.springguidesbuildingapplicationwithspringboot;

import static org.hamcrest.Matchers.equalTo;
//import static org.springframework.test.web.client.match.MockRestRequestMatchers.content; wrong import
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/*
 * MockMvc comes from Spring Test and lets you, through a set of convenient builder classes, 
 * send HTTP requests into the DispatcherServlet and make assertions about the result. 
 * Note the use of @AutoConfigureMockMvc and @SpringBootTest to inject a MockMvc instance. 
 * Having used @SpringBootTest, we are asking for the whole application context to be created.
 */

@SpringBootTest
@AutoConfigureMockMvc
public class HelloControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void getHello() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(content().string(equalTo("Greetings from Spring Boot!")));
//				.andExpect(content().string("Greetings from Spring Boot!"));
	}

}

package lesiak.jakub.Tank.Museum;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class TankMuseumApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private TankRepository repository;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	public void completeTestThroughAllLayers() throws Exception{
		Tank tank = new Tank("t-34","T-34",20.0);

		mockMvc
				.perform(post("/")
				.contentType("application/json")
				.content(objectMapper.writeValueAsString(tank))
				).andExpect(status().isOk());

		List<Tank> tanks = repository.findAllById("t-34");

		for(Tank t: tanks) {
			assertThat(t.getName()).isEqualTo("T-34");
			assertThat(Double.toString(t.getWeight())).isEqualTo("20.0");
		}
	}

	@Test
	public void shouldReturnExpectedText() throws Exception {
		mockMvc
				.perform(get("/"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string("[{\"id\":\"t-34\",\"name\":\"T-34\",\"weight\":20.0}]"));
	}

	@Test
	public void testDelete() throws Exception{
		mockMvc
				.perform(delete("/t-34"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string(""));
	}
}

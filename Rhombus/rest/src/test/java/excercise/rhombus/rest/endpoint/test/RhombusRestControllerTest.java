package excercise.rhombus.rest.endpoint.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.springframework.http.MediaType;

public class RhombusRestControllerTest extends AbstractRestControllerTest {

	@Test
	public void getRhombus_ShouldReturnA64SimetricRhombus() throws Exception {

		mockMvc.perform(get("/rhombus")) //
				.andExpect(status().isOk()) //
				.andExpect(content().contentType(MediaType.TEXT_PLAIN_VALUE)) //
				.andExpect(content().string(RHOMBUS_64));

	}

}

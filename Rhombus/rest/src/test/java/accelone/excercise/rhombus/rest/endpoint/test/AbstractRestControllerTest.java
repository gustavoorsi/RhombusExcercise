package accelone.excercise.rhombus.rest.endpoint.test;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import accelone.RootTestApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { RootTestApplication.class })
@WebAppConfiguration
public abstract class AbstractRestControllerTest {

	protected MockMvc mockMvc;

	@Autowired
	protected WebApplicationContext webApplicationContext;

	protected final String RHOMBUS_64;

	{
		StringBuilder builder = new StringBuilder();
		builder.append("            1             \n");
		builder.append("          1 2 1           \n");
		builder.append("        1 2 4 2 1         \n");
		builder.append("      1 2 4 8 4 2 1       \n");
		builder.append("    1 2 4 8 16 8 4 2 1     \n");
		builder.append("  1 2 4 8 16 32 16 8 4 2 1   \n");
		builder.append("1 2 4 8 16 32 64 32 16 8 4 2 1 \n");
		builder.append("1 2 4 8 16 32 64 32 16 8 4 2 1 \n");
		builder.append("  1 2 4 8 16 32 16 8 4 2 1   \n");
		builder.append("    1 2 4 8 16 8 4 2 1     \n");
		builder.append("      1 2 4 8 4 2 1       \n");
		builder.append("        1 2 4 2 1         \n");
		builder.append("          1 2 1           \n");
		builder.append("            1             \n");

		RHOMBUS_64 = builder.toString();

	}

	protected final String RHOMBUS_64_WELL_FORMED;

	{
		StringBuilder builder = new StringBuilder();

		builder.append("                   1                   \n");
		builder.append("                1  2  1                \n");
		builder.append("             1  2  4  2  1             \n");
		builder.append("          1  2  4  8  4  2  1          \n");
		builder.append("       1  2  4  8 16  8  4  2  1       \n");
		builder.append("    1  2  4  8 16 32 16  8  4  2  1    \n");
		builder.append(" 1  2  4  8 16 32 64 32 16  8  4  2  1 \n");
		builder.append(" 1  2  4  8 16 32 64 32 16  8  4  2  1 \n");
		builder.append("    1  2  4  8 16 32 16  8  4  2  1    \n");
		builder.append("       1  2  4  8 16  8  4  2  1       \n");
		builder.append("          1  2  4  8  4  2  1          \n");
		builder.append("             1  2  4  2  1             \n");
		builder.append("                1  2  1                \n");
		builder.append("                   1                   \n");

		RHOMBUS_64_WELL_FORMED = builder.toString();

	}

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

}

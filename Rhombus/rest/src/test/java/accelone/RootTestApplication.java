package accelone;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication(exclude = { EnableWebSecurity.class })
public class RootTestApplication {

}

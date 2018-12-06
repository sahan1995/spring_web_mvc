package lk.ijse.dep.main;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan("lk.ijse.dep")
@Import(WebRootConfig.class)
@EnableJpaRepositories("lk.ijse.dep")
@EnableWebMvc
public class WebAppConfig {
}

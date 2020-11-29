package configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

@Configuration
@ComponentScan(basePackages = {"entrypoint", "configuration"})
public class TestConfiguration {

  @Bean
  PropertySourcesPlaceholderConfigurer propConfig() {
    PropertySourcesPlaceholderConfigurer ppc = new PropertySourcesPlaceholderConfigurer();
    ppc.setLocation(new ClassPathResource("test.properties"));
    return ppc;
  }
}

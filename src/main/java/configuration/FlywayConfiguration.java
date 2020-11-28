package configuration;

import org.flywaydb.core.Flyway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;


@Configuration
public class FlywayConfiguration {

  @Bean(initMethod = "migrate")
  public Flyway flyway(DataSource dataSource) {
    Flyway flyway = new Flyway();
    flyway.setBaselineOnMigrate(true);
    flyway.setDataSource(dataSource);
    return flyway;
  }
}
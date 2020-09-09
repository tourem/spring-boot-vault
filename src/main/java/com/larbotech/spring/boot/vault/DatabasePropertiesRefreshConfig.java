package com.larbotech.spring.boot.vault;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@RefreshScope
public class DatabasePropertiesRefreshConfig {
  @Value("${spring.datasource.username}")
  private String username;

  @Value("${spring.datasource.password}")
  private String password;

  @Value("${spring.datasource.url}")
  private String dbUrl;

  @Bean
  @Primary
  @RefreshScope
  public DataSource getDatasource() {
    return DataSourceBuilder.create().url(dbUrl).username(username).password(password).build();
  }

}

package com.larbotech.spring.boot.vault;

import java.sql.SQLException;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${message.welcome}")
    private String message;

    @Autowired
    private DataSource dataSource;

    @GetMapping("/demo")
    public String getConnection() throws SQLException {
        return message + " \\n"+ username + " and " + password + " from vault and connected to  database " +  dataSource.getConnection();
    }

}

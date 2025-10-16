package com.Springboot.UserAuth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.sql.DataSource;
import java.sql.Connection;

@RestController
public class DBCheckController {

    @Autowired
    private DataSource dataSource;

    @GetMapping("/dbcheck")
    public String checkDB() {
        try (Connection conn = dataSource.getConnection()) {
            return "✅ Database connected successfully: " + conn.getMetaData().getURL();
        } catch (Exception e) {
            e.printStackTrace();
            return "❌ Database connection failed: " + e.getMessage();
        }
    }
}

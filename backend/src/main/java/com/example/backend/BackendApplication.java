package com.example.backend;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.Statement;
import java.util.stream.Collectors;

@SpringBootApplication
@Slf4j
@RequiredArgsConstructor
public class BackendApplication implements CommandLineRunner {

    static {
        log.info("11 GOOGLE_API_KEY= {}", System.getenv("google.api.key"));
        var key = System.getenv("google.api.key");
        if (key == null || key.equals("null") || key.isEmpty() || key.isBlank())
            throw new AssertionError("create app/.env files google.api.key=GOOGLE_API_KEY");
    }

    private final Connection connection;

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {

        String sql ;
        ClassLoader classLoader = this.getClass().getClassLoader();
        try (InputStream is = classLoader.getResourceAsStream("files/sql/init.sql")) {
            if (is == null) throw new NullPointerException();
            try (InputStreamReader isr = new InputStreamReader(is); BufferedReader reader = new BufferedReader(isr)) {
                sql=  reader.lines().collect(Collectors.joining(System.lineSeparator()));
            }
        }
        try {
            log.warn("\nsql ok.................... {}",sql);

            Statement statement = connection.createStatement();
            connection.beginRequest();
            statement.execute(sql);
            connection.commit();
        } catch (Throwable throwable) {
            connection.rollback();
            log.warn(throwable.getMessage(), throwable);
        } finally {
            connection.endRequest();
        }
    }
}

package com.example.backend.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Slf4j
@Configuration
public class Config {

    static {
        String url = System.getenv("postgresql.url");
        String username = System.getenv("postgresql.username");
        String password = System.getenv("postgresql.password");

        log.warn("url {}",url);
        log.warn("username {}",username);
        log.warn("password {}",password);

        if (url==null || url.equals("null") || url.isEmpty())
            throw new AssertionError("env [postgresql.url] error");
        if (username==null || username.equals("null") || username.isEmpty())
            throw new AssertionError("env [postgresql.username] error");
        if (password==null || password.equals("null") || password.isEmpty())
            throw new AssertionError("env [postgresql.password] error");
    }

    @Bean
    public Connection connection() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        String url = System.getenv("postgresql.url");
        String username = System.getenv("postgresql.username");
        String password = System.getenv("postgresql.password");

        //var con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/test8", "postgres", "ogun");
         var con = DriverManager.getConnection(url, username, password);

        con.setReadOnly(false);
        con.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
        con.setAutoCommit(false);
        con.setHoldability(con.getMetaData().getResultSetHoldability());
        log.warn("\ncon ok....................");
        return con;
    }

    @Bean
    public ThreadPoolExecutor threadPoolExecutor() {
        var size = Runtime.getRuntime().availableProcessors();
        var threadFactory = Thread.ofVirtual()
                .name("Custom Thread Pool",0)
                .inheritInheritableThreadLocals(true)
                .factory();

        return new ThreadPoolExecutor(
                size / 2,
                size,
                10, TimeUnit.MINUTES,
                new LinkedBlockingQueue<>(),
                (Runnable r) -> {
                    var thread = threadFactory.newThread(r);
                    thread.setPriority(Thread.MAX_PRIORITY);
                    return thread;
                },
                new ThreadPoolExecutor.AbortPolicy()
        );
    }
}

package br.com.basis.sgt;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(
        properties = {
                "spring.datasource.url=jdbc:postgresql://localhost:5432/postgres_test",
                "spring.liquibase.drop-first=true"})
public interface SGTTestConfig {
}

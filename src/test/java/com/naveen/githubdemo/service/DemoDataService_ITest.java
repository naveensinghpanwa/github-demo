package com.naveen.githubdemo.service;

import com.naveen.githubdemo.config.IntegrationTestConfig;
import com.naveen.githubdemo.model.DemoData;
import com.naveen.githubdemo.repository.DemoDataRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.jdbc.SqlConfig.TransactionMode;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Sql(
        scripts = "/setupDB.sql",
        config = @SqlConfig(transactionMode = TransactionMode.ISOLATED),
        executionPhase = ExecutionPhase.BEFORE_TEST_METHOD
)
@ContextConfiguration(classes = {IntegrationTestConfig.class})
@TestPropertySource("classpath:application-test.properties")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DemoDataService_ITest {

    @Autowired
    private DemoDataService subject;

    @Autowired
    private DemoDataRepository repo;

    @Test
    void updateTechnology() {
        // Given
        var expectedTechnology = new DemoData("40bb5bdf-80d2-47b5-a615-178e14c65760", "dummy name", "ring");

        var technology = subject.update(expectedTechnology);

        assertEquals("dummy name", technology.getName());

    }
}

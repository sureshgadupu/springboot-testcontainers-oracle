package dev.fullstackcode.eis;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.OracleContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ContextConfiguration(initializers = BaseIT2.TestEnvInitializer.class)
@Testcontainers
@DirtiesContext
public  class BaseIT2 {

    @Autowired
    protected TestRestTemplate testRestTemplate ;



    @Container
    public static OracleContainer oracleDB = new OracleContainer("gvenzl/oracle-xe:21-slim");



//    public static OracleContainer oracleDB;
//
//
//    static {
//         oracleDB = new OracleContainer("gvenzl/oracle-xe:21-slim");
//
//         oracleDB.start();
//    }


    static class TestEnvInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

        @Override
        public void initialize(ConfigurableApplicationContext applicationContext) {
            TestPropertyValues values = TestPropertyValues.of(
                    "spring.datasource.url=" + oracleDB.getJdbcUrl(),
                    "spring.datasource.password=" + oracleDB.getPassword(),
                    "spring.datasource.username=" + oracleDB.getUsername()
            );
            values.applyTo(applicationContext);

        }

    }

}
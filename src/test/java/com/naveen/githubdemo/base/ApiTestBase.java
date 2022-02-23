package com.naveen.githubdemo.base;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.naveen.githubdemo.annotations.ApiTest;
import com.naveen.githubdemo.config.ApiTestConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@ApiTest(config = ApiTestConfig.class)
public class ApiTestBase {

    protected static final String STATUS_TEXT = "$.statusText";
    protected static final String STATUS_CODE = "$.statusCode";
    protected static final String STATUS_MESSAGE = "$.message";
    protected static final String RESPONSE_DATA = "$.data";

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private WebApplicationContext context;

    protected MockMvc mockMvc;

    @BeforeEach
    protected void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context)
                .build();
    }

    protected String toJson(Object o) {
        try {
            return objectMapper.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Couldn't convert object to JSON", e);
        }
    }

    protected void validate200OKRequest(MockHttpServletRequestBuilder request) {
        try {
            var temp = mockMvc.perform(request)
                    .andExpect(status().isOk());
//                    .andExpect(jsonPath("$.statusText").value("ok"))
//                    .andExpect(jsonPath("$.statusCode").value("ok"))
//                    .andExpect(jsonPath("$.data").exists());

        } catch (Exception e) {
            throw new RuntimeException("Failed to validate API", e);
        }
    }

}

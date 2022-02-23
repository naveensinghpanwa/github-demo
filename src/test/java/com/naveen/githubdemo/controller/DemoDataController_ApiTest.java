package com.naveen.githubdemo.controller;

import com.naveen.githubdemo.base.ApiTestBase;
import com.naveen.githubdemo.model.DemoData;
import com.naveen.githubdemo.service.DemoDataService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.reset;

public class DemoDataController_ApiTest extends ApiTestBase {

    private static final String TECHNOLOGY_CONTROLLER_ENDPOINT = "/demo";
    private static final String APPLICATION_JSON_VALUE = "application/json";

    @MockBean
    private DemoDataService demoDataService;

    @BeforeEach
    protected void setup() {
        super.setup();
        reset(demoDataService);
    }

    @Test
    void updateTechnology_UpdateTechnology_WhenDataExistInDatabase() {

        var expectedTechnology = new DemoData("40bb5bdf-80d2-47b5-a615-178e14c65760", "dummy name", "ring");

        doReturn(expectedTechnology).when(demoDataService).update(expectedTechnology);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .put(TECHNOLOGY_CONTROLLER_ENDPOINT +"/update")
                .content(toJson(expectedTechnology))
                .contentType(APPLICATION_JSON_VALUE);

        validate200OKRequest(request);
    }
}

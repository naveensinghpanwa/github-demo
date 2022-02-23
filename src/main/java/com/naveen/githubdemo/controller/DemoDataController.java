package com.naveen.githubdemo.controller;

import com.naveen.githubdemo.model.DemoData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * This controller is designed to create, update, get and delete the technology.
 */
@RestController
@RequestMapping("/demo")
@Api("Technology API endpoints. Used for creating, updating, retrieving, or removing technology from a Knoldus Radar.")
public class DemoDataController {

    //@Autowired
    //private DemoDataService demoDataService;

    @ApiOperation(
            value = "Update the technology if exist"
    )
    @ApiResponses({
            @ApiResponse(
                    code = 200,
                    message = "All the fields related to the technology "
            ),
            @ApiResponse(
                    code = 404,
                    message = "Unable to find the given technology."
            ),
    })
    @PutMapping("/update")
    public DemoData updateData(@RequestBody DemoData technology) {

       return null;//demoDataService.update(technology);
    }

    @ApiOperation(
            value = "Delete the technology if exist"
    )
    @ApiResponses({
            @ApiResponse(
                    code = 200,
                    message = "Technology is deleted with the given Id"
            ),
            @ApiResponse(
                    code = 404,
                    message = "Unable to find the given technology."
            ),
    })
    @GetMapping("/get")
    public List<DemoData> getData() {
        return null;//demoDataService.getData();
    }

    @ApiOperation(
            value = "fetch hello world response"
    )
    @ApiResponses({
            @ApiResponse(
                    code = 200,
                    message = "Technology is deleted with the given Id"
            ),
            @ApiResponse(
                    code = 404,
                    message = "Unable to find the given technology."
            ),
    })
    @GetMapping("/get/hello")
    public String getHelloData() {
        return "Hello World";
    }
}

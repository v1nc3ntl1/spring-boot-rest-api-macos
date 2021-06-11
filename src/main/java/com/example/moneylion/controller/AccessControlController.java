package com.example.moneylion.controller;


import com.example.moneylion.model.ModifyAccessRequest;
import com.example.moneylion.services.AccessControlServices;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class AccessControlController {
    @Autowired
    AccessControlServices services;

    @ApiOperation(value = "get all features")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @GetMapping(value = "/features")
    public ResponseEntity getAccessDetails() {
        List<ModifyAccessRequest> accessDetails = services.getAccessDetails();

        return ResponseEntity.ok(accessDetails);
    }

    @ApiOperation(value = "get a feature")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @GetMapping(value = "/feature")
    public ResponseEntity getAccessDetails(
            @RequestParam(name = "email") String email,
            @RequestParam(name = "featureName") String featureName
    ) {
        return ResponseEntity.ok(services.getAccessDetails(email, featureName));
    }

    @ApiOperation(value = "add a feature")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @PostMapping(value = "/feature")
    public ResponseEntity modifyAccess(
            @Valid @RequestBody ModifyAccessRequest request
    ) {
        return new ResponseEntity<>(services.modifyAccess(request));
    }
}

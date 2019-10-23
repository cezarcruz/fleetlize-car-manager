package com.fleetlize.webapp.gateways.rest;

import com.fleetlize.webapp.gateways.rest.mappers.CarMapper;
import com.fleetlize.webapp.gateways.rest.request.CarRequest;
import com.fleetlize.webapp.gateways.rest.response.CarResponse;
import com.fleetlize.webapp.usecases.impl.CreateCar;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/car")
@AllArgsConstructor
@Api(value = "Car")
public class CarController {

    private CreateCar createCar;
    private CarMapper carMapper;

    @ApiOperation(value = "Creates a new Car")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Car created successfully"),
            @ApiResponse(code = 400, message = "API doesn't recognize sent parameters"),
            @ApiResponse(code = 412, message = "Car already exists"),
            @ApiResponse(code = 500, message = "Internal Server Error"),
    })
    @PostMapping
    public ResponseEntity<CarResponse> create(@RequestBody @Valid final CarRequest carRequest) {

        final var carToSave = carMapper.from(carRequest);
        final var carSaved = createCar.execute(carToSave);
        final var carResponse = carMapper.from(carSaved);
        return ResponseEntity.status(HttpStatus.CREATED).body(carResponse);

    }

}

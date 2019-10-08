package com.fleetlize.webapp.gateways.rest;

import com.fleetlize.webapp.entities.CarModel;
import com.fleetlize.webapp.gateways.rest.converter.CarModelRequestToCarModel;
import com.fleetlize.webapp.gateways.rest.converter.CarModelToCarModelResponse;
import com.fleetlize.webapp.gateways.rest.request.CarModelRequest;
import com.fleetlize.webapp.gateways.rest.response.CarModelResponse;
import com.fleetlize.webapp.usecases.impl.CreateCarModel;
import com.fleetlize.webapp.usecases.impl.DeleteCarModel;
import com.fleetlize.webapp.usecases.impl.GetCarModel;
import com.fleetlize.webapp.usecases.impl.UpdateCarModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/car-model")
@AllArgsConstructor
@Api(value = "Car Model")
public class CarModelController {

    private CreateCarModel createCarModel;
    private GetCarModel getCarModel;
    private DeleteCarModel deleteCarModel;
    private UpdateCarModel updateCarModel;

    @ApiOperation(value = "Creates a new Car Model")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Car Model created successfully"),
            @ApiResponse(code = 400, message = "API doesn't recognize sent parameters"),
            @ApiResponse(code = 412, message = "Car Model already exists"),
            @ApiResponse(code = 500, message = "Internal Server ErrorResponse"),
    })
    @PostMapping
    public ResponseEntity<CarModelResponse> create(@RequestBody @Valid final CarModelRequest carModelRequest) {

        final CarModel carModelToSave = CarModelRequestToCarModel.from(carModelRequest);
        final CarModel carModelSaved = createCarModel.execute(carModelToSave);
        final CarModelResponse carModelResponse = CarModelToCarModelResponse.from(carModelSaved);
        return ResponseEntity.status(HttpStatus.CREATED).body(carModelResponse);

    }

    @ApiOperation(value = "List Car Model")
    @ApiResponses({
            @ApiResponse(code = 200, message = "List successfully"),
            @ApiResponse(code = 400, message = "API doesn't recognize sent parameters"),
            @ApiResponse(code = 500, message = "Internal Server ErrorResponse"),
    })
    @GetMapping("/")
    public ResponseEntity<List<CarModelResponse>> list() {
        final List<CarModel> carModelList = getCarModel.execute();

        final List<CarModelResponse> carModelResponse = CarModelToCarModelResponse.from(carModelList);

        return ResponseEntity.ok(carModelResponse);
    }

    @ApiOperation(value = "Get Car Model Detail")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Car Model Found"),
            @ApiResponse(code = 404, message = "Car Model Not Found")
    })
    @GetMapping(value = "/{id}")
    public ResponseEntity<CarModelResponse> getById(@PathVariable final Long id) {
        final CarModel carModel = getCarModel.execute(id);

        final CarModelResponse carModelResponse = CarModelToCarModelResponse.from(carModel);

        return ResponseEntity.ok(carModelResponse);

    }

    @ApiOperation(value = "Delete Car Model")
    @ApiResponses({
            @ApiResponse(code = 404, message = "Car Model Not Found"),
            @ApiResponse(code = 204, message = "Car Model deleted successfully")
    })
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable final Long id) {
        deleteCarModel.execute(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


    @ApiOperation(value = "Update Car Model")
    @ApiResponses({
            @ApiResponse(code = 404, message = "Car Model Or Manufacturer Not Found"),
            @ApiResponse(code = 200, message = "Car Model Update SuccessFully")
    })
    @PutMapping("/{id}")
    public ResponseEntity<CarModelResponse> update(@PathVariable final Long id,
                                                   @RequestBody final CarModelRequest carModelRequest) {

        log.info("updating car model {}", id);

        final CarModel carModel = CarModelRequestToCarModel.from(carModelRequest, id);

        final CarModel updatedCarModel = updateCarModel.execute(carModel);

        return ResponseEntity.ok(CarModelToCarModelResponse.from(updatedCarModel));

    }

}

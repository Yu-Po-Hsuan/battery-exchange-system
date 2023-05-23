package com.yupohsuan.batteryexchangesystem.controller;


import com.yupohsuan.batteryexchangesystem.dto.VehicleCreateRequest;
import com.yupohsuan.batteryexchangesystem.dto.VehicleDataRequest;
import com.yupohsuan.batteryexchangesystem.model.Vehicle;
import com.yupohsuan.batteryexchangesystem.service.VehicleService;
import com.yupohsuan.batteryexchangesystem.util.VehiclesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin("*")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

//    @CrossOrigin(origins = "http://localhost:3001")
    @GetMapping("/vehicles")
    public ResponseEntity<List<VehiclesResponse>> getVehicles() {

        List<VehiclesResponse> vehiclesResponseList = vehicleService.getVehicles();

        return ResponseEntity.status(HttpStatus.OK).body(vehiclesResponseList);
    }

//    @GetMapping("/vehicles/{vehicleId}")
//    public Integer getBatteryId(@PathVariable Integer vehicleId) {
//
//        return vehicleService.getBatteryId(vehicleId);
//    }
//
//    @PutMapping("/vehicles/{MyVehicleId}")
//    public ResponseEntity<?> exchange(@PathVariable Integer MyVehicleId,
//                                      @RequestParam Integer TargetVehicleId) {
//        vehicleService.exchange(MyVehicleId, TargetVehicleId);
//        return ResponseEntity.status(HttpStatus.OK).build();
//    }


    @PostMapping("/vehicles")
    public ResponseEntity<Vehicle> createVehicle(@RequestBody VehicleCreateRequest vehicleCreateRequest) {
        Integer vehicleId = vehicleService.createVehicle(vehicleCreateRequest);
        Vehicle vehicle = vehicleService.getVehicleById(vehicleId);
        return ResponseEntity.status(HttpStatus.CREATED).body(vehicle);
    }

    @PutMapping("/vehicles")
    public ResponseEntity<?> updateVehicleData(@RequestBody VehicleDataRequest vehicleDataRequest) {
        vehicleService.updateVehicleData(vehicleDataRequest);
        return ResponseEntity.status((HttpStatus.OK)).build();
    }
}

package com.yupohsuan.batteryexchangesystem.controller;


import com.yupohsuan.batteryexchangesystem.service.VehicleService;
import com.yupohsuan.batteryexchangesystem.util.VehiclesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @GetMapping("/vehicles")
    public ResponseEntity<List<VehiclesResponse>> getVehicles() {

        List<VehiclesResponse> vehiclesResponseList = vehicleService.getVehicles();

        return ResponseEntity.status(HttpStatus.OK).body(vehiclesResponseList);
    }

    @GetMapping("/vehicles/{vehicleId}")
    public Integer getBatteryId(@PathVariable Integer vehicleId) {

        return vehicleService.getBatteryId(vehicleId);
    }

    @PutMapping("/vehicles/{MyVehicleId}")
    public ResponseEntity<?> exchange(@PathVariable Integer MyVehicleId,
                                      @RequestParam Integer TargetVehicleId) {
        vehicleService.exchange(MyVehicleId, TargetVehicleId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}

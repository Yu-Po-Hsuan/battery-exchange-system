package com.yupohsuan.batteryexchangesystem.controller;

import com.yupohsuan.batteryexchangesystem.model.Battery;
import com.yupohsuan.batteryexchangesystem.service.BatteryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Validated
@RestController
public class BatteryController {

    @Autowired
    private BatteryService batteryService;



    @GetMapping("/batteries/{batteryId}")
    public ResponseEntity<Battery> getBatteryById(@PathVariable Integer batteryId) {
        Battery battery =batteryService.getBatteryById(batteryId);

        return ResponseEntity.status(HttpStatus.OK).body(battery);
    }

    @PostMapping("/batteries")
    public ResponseEntity<Battery> createBattery(@RequestParam @Min(0) @Max(100) Integer batteryLevel) {
        Integer battetyId = batteryService.createBattery(batteryLevel);

        Battery battery = batteryService.getBatteryById(battetyId);

        return ResponseEntity.status(HttpStatus.CREATED).body(battery);
    }

    @PutMapping("/batteries/{batteryId}")
    public ResponseEntity<Battery> updateBattery(@PathVariable Integer batteryId,
                                                 @RequestParam @Min(0) @Max(100) Integer batteryLevel) {
        Battery battery = batteryService.getBatteryById(batteryId);

        if (battery == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }else {
            batteryService.updateBattery(batteryId, batteryLevel);

            Battery updatedBattery = batteryService.getBatteryById(batteryId);

            return ResponseEntity.status(HttpStatus.OK).body(updatedBattery);
        }
    }



    @DeleteMapping("/batteries/{batteryId}")
    public ResponseEntity<?> deleteBattery(@PathVariable Integer batteryId) {
        batteryService.deleteBattery(batteryId);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

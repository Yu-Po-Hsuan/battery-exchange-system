package com.yupohsuan.batteryexchangesystem.controller;

import com.yupohsuan.batteryexchangesystem.dto.BatteryRequest;
import com.yupohsuan.batteryexchangesystem.model.Battery;
import com.yupohsuan.batteryexchangesystem.service.BatteryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
    public ResponseEntity<Battery> createBattery(@RequestBody @Valid BatteryRequest batteryRequest) {
        Integer battetyId = batteryService.createBattery(batteryRequest);

        Battery battery = batteryService.getBatteryById(battetyId);

        return ResponseEntity.status(HttpStatus.CREATED).body(battery);
    }

    @PutMapping("/batteries/{batteryId}")
    public ResponseEntity<Battery> updateBattery(@PathVariable Integer batteryId,
                                                 @RequestBody @Valid BatteryRequest batteryRequest) {
        Battery battery = batteryService.getBatteryById(batteryId);

        if (battery == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }else {
            batteryService.updateBattery(batteryId, batteryRequest);

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

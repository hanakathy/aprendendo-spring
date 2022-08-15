package com.api.parkingcontrol.controllers;

import com.api.parkingcontrol.services.ParkingSpotService;
import com.api.parkingcontrol.models.ParkingSpotModel;
import com.api.parkingcontrol.dtos.ParkingSpotDto;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.ZoneId;

@RestController //Api Rest Controller
@CrossOrigin(origins = "*", maxAge = 3600) //permite que seja acessado de qualquer fonte
@RequestMapping("/parking-spot") //Solicitar Mapping a nivel de classe (pode ser de método também)
public class ParkingSpotController {
    final ParkingSpotService parkingSpotService;
    public ParkingSpotController(ParkingSpotService parkingSpotService){
        this.parkingSpotService = parkingSpotService;
    }

    @PostMapping //Primeiro Passo: Método Post
    public ResponseEntity<Object> saveParkingSpot(@RequestBody @Valid ParkingSpotDto parkingSpotDto){
        var parkingSpotModel = new ParkingSpotModel(); //Dentro de um escopo fechado, pode-se usar o var
        BeanUtils.copyProperties(parkingSpotDto, parkingSpotModel);
        parkingSpotModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(parkingSpotService.save(parkingSpotModel));
    }
}

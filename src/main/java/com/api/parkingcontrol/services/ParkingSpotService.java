package com.api.parkingcontrol.services;

import com.api.parkingcontrol.models.ParkingSpotModel;
import com.api.parkingcontrol.repositories.ParkingSpotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ParkingSpotService {
    @Autowired  //Ponto de Injeção
    ParkingSpotRepository parkingSpotRepository;

    /* Outra maneira de fazer: Construtor
    final ParkingSpotRepository parkingSpotRepository;

    public ParkingSpotService(ParkingSpotRepository parkingSpotRepository){
        this.parkingSpotRepository = parkingSpotRepository;
    }
     */

    @Transactional //Usado em métodos onde se faz transações, para garantir que não se perca dados
    public ParkingSpotModel save(ParkingSpotModel parkingSpotModel){ //método save do Controller
        return parkingSpotRepository.save(parkingSpotModel);
    }
}

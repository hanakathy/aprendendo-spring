package com.api.parkingcontrol.repositories;

import com.api.parkingcontrol.models.ParkingSpotModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository //Esteriótipo para transações com base de dados (Não obrigatório)
public interface ParkingSpotRepository extends JpaRepository<ParkingSpotModel, UUID> {
    //
}

package com.example.SupportTeam.repository;

import com.example.SupportTeam.entity.Vehicle;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface VehicleRepository
        extends JpaRepository<Vehicle, Long> {

    List<Vehicle> findAll();
    List<Vehicle> findAll(Sort sort);
    Optional<Vehicle> findVehicleById (Long id);

}

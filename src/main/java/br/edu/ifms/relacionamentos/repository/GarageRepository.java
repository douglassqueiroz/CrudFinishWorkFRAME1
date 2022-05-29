package br.edu.ifms.relacionamentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifms.relacionamentos.model.Garage;

@Repository
public interface GarageRepository extends JpaRepository<Garage, Integer> {
    
}

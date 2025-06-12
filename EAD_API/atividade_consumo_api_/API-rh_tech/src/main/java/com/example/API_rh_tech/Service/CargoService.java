package com.example.API_rh_tech.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.API_rh_tech.Model.CargoModel;
import com.example.API_rh_tech.Repository.CargoRepository;

@Service
public class CargoService {

    @Autowired
    private CargoRepository cargoRepository;

    public CargoModel registrarCargo (CargoModel cargoModel) {
        return cargoRepository.save(cargoModel);

    }
    
    public List<CargoModel> listarcargo() {
        return cargoRepository.findAll();
    }

    public Optional<CargoModel> buscarPorId (Long id) {
        return cargoRepository.findById(id);
    }

    public void deletarcargo (Long id) {
         cargoRepository.deleteById(id);
    
    }

    public CargoModel atualizaCargoModel (Long id, CargoModel cargoModel) {
        cargoModel.setId(id);
        return cargoRepository.save(cargoModel);
    }

}

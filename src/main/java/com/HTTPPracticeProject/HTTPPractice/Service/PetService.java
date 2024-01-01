package com.HTTPPracticeProject.HTTPPractice.Service;

import com.HTTPPracticeProject.HTTPPractice.Entity.PetEntity;
import com.HTTPPracticeProject.HTTPPractice.Repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {
    private final PetRepository petRepository;



    @Autowired
    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public List<PetEntity> getAllPetEntities() {
        return petRepository.findAll();
    }

    public PetEntity getPetEntityById(Long id) {
        return petRepository.findById(id).orElse(null);
    }

    public PetEntity postPetEntity(PetEntity petEntity){
        return petRepository.save(petEntity);
    }

    public PetEntity updatePetEntity(PetEntity petEntity){
        PetEntity petEntityForUpdate = new PetEntity();
        if (null != petEntity.getPetName() && !petEntity.getPetName().isEmpty()) {
            petEntityForUpdate.setPetName(petEntity.getPetName());
        }
        if (null != petEntity.getPetType() && !petEntity.getPetType().isEmpty()) {
        petEntityForUpdate.setPetType(petEntity.getPetType());
        }
        if (petEntity.getPetAge() != 0) {
            petEntityForUpdate.setPetAge(petEntity.getPetAge());
        }
        if (null != petEntity.getPetBreed() && !petEntity.getPetBreed().isEmpty()) {
            petEntityForUpdate.setPetBreed(petEntity.getPetBreed());
        }
        if (null != petEntity.getPetFavoriteToy() && !petEntity.getPetFavoriteToy().isEmpty()) {
            petEntityForUpdate.setPetFavoriteToy(petEntity.getPetFavoriteToy());
        }
        return petRepository.save(petEntityForUpdate);
    }

    public void deleteEntityById(Long id){
        petRepository.deleteById(id);
    }

}

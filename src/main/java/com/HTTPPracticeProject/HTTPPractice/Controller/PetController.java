package com.HTTPPracticeProject.HTTPPractice.Controller;

import com.HTTPPracticeProject.HTTPPractice.Entity.PetEntity;
import com.HTTPPracticeProject.HTTPPractice.Service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pet")
public class PetController {

    private final PetService petService;

    @Autowired
    public PetController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping("/returnCatGreeting")
    public String helloWorld(){
        return "Greetings cat!";
    }

    @GetMapping("/GETServiceName")
    public String returnServiceName(){
        return "Service name is HTTPPractice";
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<PetEntity>> getAllEntities() {
        List<PetEntity> petEntities = petService.getAllPetEntities();
        return new ResponseEntity<>(petEntities, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<PetEntity> getPetEntityById(@PathVariable Long id){
        PetEntity petEntity = petService.getPetEntityById(id);

        if (null != petEntity) {
            return new ResponseEntity<>(petEntity, HttpStatus.OK);
        }
        else {
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/post")
    public ResponseEntity<PetEntity> postEntity(@RequestBody PetEntity petEntityForPost){
        PetEntity savedPetEntity = petService.postPetEntity(petEntityForPost);
        return new ResponseEntity<>(savedPetEntity, HttpStatus.OK);
    }

    @PostMapping("/put/{id}")
    public ResponseEntity<PetEntity> putEntity(@PathVariable Long id, @RequestBody PetEntity petEntityForPut){
        petEntityForPut.setId(id);
        PetEntity updatedPetEntity = petService.updatePetEntity(petEntityForPut);
        return new ResponseEntity<>(updatedPetEntity, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePetEntityById(@PathVariable Long id){
        petService.deleteEntityById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

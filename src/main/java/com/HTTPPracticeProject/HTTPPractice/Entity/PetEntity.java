package com.HTTPPracticeProject.HTTPPractice.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PetEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String petName;
    private String petType;
    private int petAge;
    private String petBreed;
    private String petFavoriteToy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getPetType() {
        return petType;
    }

    public void setPetType(String petType) {
        this.petType = petType;
    }

    public int getPetAge() {
        return petAge;
    }

    public void setPetAge(int petAge) {
        this.petAge = petAge;
    }

    public String getPetBreed() {
        return petBreed;
    }

    public void setPetBreed(String petBreed) {
        this.petBreed = petBreed;
    }

    public String getPetFavoriteToy() {
        return petFavoriteToy;
    }

    public void setPetFavoriteToy(String petFavoriteToy) {
        this.petFavoriteToy = petFavoriteToy;
    }

    @Override
    public String toString() {
        return "PetEntity{" +
                "id=" + id +
                ", petName='" + petName + '\'' +
                ", petType='" + petType + '\'' +
                ", petAge=" + petAge +
                ", petBreed='" + petBreed + '\'' +
                ", petFavoriteToy='" + petFavoriteToy + '\'' +
                '}';
    }

    public PetEntity(){

    }
}

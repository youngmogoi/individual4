package csc340.individual4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalService {

    @Autowired
    private csc340.individual4.AnimalRepository repository;

    public List<csc340.individual4.Animal> getAllAnimals() {
        return repository.findAll();
    }

    public csc340.individual4.Animal getAnimalById(int id) {
        return repository.findById(id).orElse(null);
    }

    public void addNewAnimal(csc340.individual4.Animal animal) {
        repository.save(animal);
    }

    public void updateAnimal(csc340.individual4.Animal animal) {
        repository.save(animal); // save will update if animal already exists
    }

    public void deleteAnimal(int id) {
        repository.deleteById(id);
    }
}

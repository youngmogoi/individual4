package csc340.individual4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/animals")
public class AnimalController {

    @Autowired
    private AnimalService service;


    /**
     * Get a list of all Animals in the database.
     * http://localhost:8080/animals/all
     *
     * @return a list of Animal objects.
     */
    @GetMapping("/all")
    public List<Animal> getAllAnimals() {
        return service.getAllAnimals();
    }



    /**
     * Get a specific Animal by Id.
     * http://localhost:8080/animals/{animalId}
     *
     * @param animalId the unique Id for a Animal.
     * @return One Animal object.
     */
    @GetMapping("/{animalId}")
    public Animal getAnimalById(@PathVariable int animalId) {
        return service.getAnimalById(animalId);
    }




    /**
     * Get a list of Animals based on their species.
     * http://localhost:8080/animals?species={species}
     *
     * @param species the search key.
     * @return A list of Animals objects matching the search key.
     */
    @GetMapping("")
    public List<Animal> getAnimalsBySpecies(@RequestParam(name = "species", defaultValue = "") String species) {
        return service.getAnimalsBySpecies(species);
    }




    /**
     * list of animals whose names contain the specified string
     * http://localhost:8080/animals/search?name={name}
     *
     * @param name
     * @return list of animals whose names contain the specified string.
     */
    @GetMapping("/search")
    public List<Animal> getAnimalsByNameContaining(@RequestParam(name = "name") String name) {
        return service.getAnimalsByNameContaining(name);
    }




    /**
     * Create a new Animal entry.
     * http://localhost:8080/animals/new --data
     * '{
     *   "name": "Elephant",
     *   "scientificName": "Loxodonta africana",
     *   "species": "Mammal",
     *   "habitat": "Savannah",
     *   "description": "Large herbivorous mammal with a trunk."
     * }'
     *
     * @param animal the new Animal object.
     * @return the updated list of Animals.
     */
    @PostMapping("/new")
    public List<Animal> addNewAnimal(@RequestBody Animal animal) {
        service.addNewAnimal(animal);
        return service.getAllAnimals();
    }



    /**
     * Update an existing Student object.
     * http://localhost:8080/animals/update/{animalId} --data
     *
     * '{
     *   "name": "African Elephant",
     *   "scientificName": "Loxodonta africana",
     *   "species": "Mammal",
     *   "habitat": "Savannah",
     *   "description": "Large mammal with tusks."
     * }'
     *
     * @param animalId the unique Animal Id.
     * @param animal the new update Animal details.
     * @return the updated Animal object.
     */

    @PutMapping("/update/{animalId}")
    public Animal updateAnimal(@PathVariable int animalId, @RequestBody Animal animal) {
        service.updateAnimal(animalId, animal);
        return service.getAnimalById(animalId);
    }



    /**
     * Delete a Animal object.
     * http://localhost:8080/animals/delete/2
     *
     * @param animalId the unique Animal Id.
     * @return the updated list of Animals.
     */
    @DeleteMapping("/delete/{animalId}")
    public List<Animal> deleteAnimalById(@PathVariable int animalId) {
        service.deleteAnimalById(animalId);
        return service.getAllAnimals();
    }
}

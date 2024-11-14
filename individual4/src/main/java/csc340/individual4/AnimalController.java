package csc340.individual4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/animals")
public class AnimalController {

    @Autowired
    private csc340.individual4.AnimalService service;

    // Display all animals
    @GetMapping("/all")
    public String getAllAnimals(Model model) {
        model.addAttribute("animalList", service.getAllAnimals());
        model.addAttribute("title", "All Animals");
        return "animal-list"; // animal-list.html
    }

    // Display a specific animal
    @GetMapping("/{id}")
    public String getAnimal(@PathVariable int id, Model model) {
        model.addAttribute("animal", service.getAnimalById(id));
        model.addAttribute("title", "Animal Details");
        return "animal-details"; // animal-details.html
    }

    // Show the form to create a new animal
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("animal", new Animal());
        return "animal-create"; // animal-create.html
    }

    // Handle creating a new animal
    @PostMapping("/new")
    public String createAnimal(@ModelAttribute Animal animal) {
        service.addNewAnimal(animal);
        return "redirect:/animals/all";
    }

    // Show the update form for an animal
    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable int id, Model model) {
        model.addAttribute("animal", service.getAnimalById(id));
        return "animal-update"; // animal-update.html
    }

    // Handle updating an existing animal
    @PostMapping("/update")
    public String updateAnimal(@ModelAttribute Animal animal) {
        service.updateAnimal(animal);
        return "redirect:/animals/{id}";
    }

    // Delete an animal
    @GetMapping("/delete/{id}")
    public String deleteAnimal(@PathVariable int id) {
        service.deleteAnimal(id);
        return "redirect:/animals/all";
    }
}

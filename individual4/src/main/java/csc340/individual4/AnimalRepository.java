package csc340.individual4;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {

    List<Animal> findBySpecies(String species);

    @Query(value = "SELECT * FROM animals WHERE name LIKE %?1%", nativeQuery = true)
    List<Animal> findByNameContaining(String name);
}
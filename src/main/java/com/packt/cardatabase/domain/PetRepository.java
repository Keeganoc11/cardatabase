package com.packt.cardatabase.domain;

import com.packt.cardatabase.domain.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}

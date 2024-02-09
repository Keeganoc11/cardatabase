package com.packt.cardatabase;

import java.time.LocalDate;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.packt.cardatabase.domain.Car;
import com.packt.cardatabase.domain.CarRepository;
import com.packt.cardatabase.domain.Owner;
import com.packt.cardatabase.domain.OwnerRepository;
import com.packt.cardatabase.domain.Pet;
import com.packt.cardatabase.domain.PetRepository;

@SpringBootApplication
public class CardatabaseApplication implements CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(CardatabaseApplication.class);

	private final CarRepository carRepository;
	private final OwnerRepository ownerRepository;
	private final PetRepository petRepository; // Added PetRepository

	public CardatabaseApplication(CarRepository carRepository, OwnerRepository ownerRepository, PetRepository petRepository) {
		this.carRepository = carRepository;
		this.ownerRepository = ownerRepository;
		this.petRepository = petRepository; // Initializing PetRepository
	}

	public static void main(String[] args) {
		SpringApplication.run(CardatabaseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Add owner objects and save these to db
		Owner owner1 = new Owner("John" , "Johnson");
		Owner owner2 = new Owner("Mary" , "Robinson");
		Owner owner3 = new Owner("John" , "Connor");
		Owner owner4 = new Owner("Sarah" , "Rob");
		Owner owner5 = new Owner("Jon" , "Jones");
		Owner owner6 = new Owner("Connor" , "McGregor");
		Owner owner7 = new Owner("Bruce" , "Wayne");
		Owner owner8 = new Owner("Alfred" , "Pennyworth");
		Owner owner9 = new Owner("Mary" , "Ann");
		Owner owner10 = new Owner("Clark" , "Kent");

		ownerRepository.saveAll(Arrays.asList(owner1, owner2, owner3, owner4, owner5, owner6, owner7, owner8, owner9, owner10));

		// Add car objects with owners and save these to db
		carRepository.save(new Car("Ford", "Mustang", "Red", "ADF-1121", 2023, 59000, owner1));
		carRepository.save(new Car("Nissan", "Leaf", "White", "SSJ-3002", 2020, 29000, owner2));
		carRepository.save(new Car("Toyota", "Prius", "Silver", "KKO-0212", 2022, 39000, owner2));
		carRepository.save(new Car("Honda", "Civic", "Blue", "HND-1422", 2021, 20000, owner4));
		carRepository.save(new Car("Chevrolet", "Impala", "Black", "CHV-7389", 2019, 25000, owner5));
		carRepository.save(new Car("Hyundai", "Elantra", "Gray", "HYD-4829", 2020, 21000, owner6));
		carRepository.save(new Car("BMW", "3 Series", "Maroon", "BMW-3921", 2023, 42000, owner7));
		carRepository.save(new Car("Audi", "A4", "Beige", "AUD-1298", 2022, 46000, owner8));
		carRepository.save(new Car("Mercedes", "Benz C-Class", "Navy", "MBZ-5643", 2021, 47000, owner9));
		carRepository.save(new Car("Volkswagen", "Golf", "Lime", "VW-6421", 2023, 23000, owner10));

		// Add pet objects with owners and save these to db
		petRepository.save(new Pet("Rex", "Dog", LocalDate.of(2018, 3, 7), owner1));
		petRepository.save(new Pet("Mittens", "Cat", LocalDate.of(2019, 6, 15), owner2));
		petRepository.save(new Pet("Charlie", "Parrot", LocalDate.of(2016, 12, 11), owner4));
		petRepository.save(new Pet("Max", "Rabbit", LocalDate.of(2020, 5, 23), owner5));
		petRepository.save(new Pet("Bella", "Cat", LocalDate.of(2021, 1, 4), owner6));
		petRepository.save(new Pet("Luna", "Dog", LocalDate.of(2019, 10, 30), owner7));
		petRepository.save(new Pet("Lucy", "Hamster", LocalDate.of(2018, 2, 18), owner8));
		petRepository.save(new Pet("Daisy", "Cat", LocalDate.of(2022, 3, 14), owner9));
		petRepository.save(new Pet("Bailey", "Dog", LocalDate.of(2020, 11, 9), owner10));
		petRepository.save(new Pet("Buddy", "Dog", LocalDate.of(2017, 8, 19), owner3));

		// Fetch all cars and log to console
		for (Car car : carRepository.findAll()) {
			logger.info("Car brand: {}, model: {}", car.getBrand(), car.getModel());
		}

		// Fetch all pets and log to console
		for (Pet pet : petRepository.findAll()) {
			logger.info("Pet name: {}, species: {}, dob: {}", pet.getName(), pet.getSpecies(), pet.getDob());
		}
	}
}


package by.zhurava.dog_farm.entity.dog.pool;

import java.util.ArrayList;
import java.util.List;

import by.zhurava.dog_farm.entity.dog.Dog;
import by.zhurava.dog_farm.entity.dog.DogAgeGroup;
import by.zhurava.dog_farm.service.DogCreator;
import by.zhurava.dog_farm.util.printer.ConsolePrinter;

public class DogPool {

	private static final DogPool instance = new DogPool();

	private List<Dog> allDogs;
	private List<Dog> puppies;
	private List<Dog> adults;
	private List<Dog> oldDogs;

	private DogPool() {

		allDogs = new ArrayList<Dog>();
		puppies = new ArrayList<Dog>();
		adults = new ArrayList<Dog>();
		oldDogs = new ArrayList<Dog>();

	}

	public static DogPool getInstance() {
		return instance;
	}

	
	
	public void initDogPool() {

		List<Dog> dogs = DogCreator.createListOfDogs();

		for (Dog dog : dogs) {
			
			ConsolePrinter.getInstance().printInfoAboutGodWakeUp(dog);
			
			allDogs.add(dog);
			
			DogAgeGroup thisDogAgeGroup = dog.getAge();

			switch (thisDogAgeGroup) {
			case PUPPY: {
				puppies.add(dog);
				break;
			}
			case ADULT: {
				adults.add(dog);
				break;
			}
			case OLD: {
				oldDogs.add(dog);
				break;
			}
			default: {
				break;
			}

			}

		}

	}

	public List<Dog> getAllDogs() {
		return allDogs;
	}

	public List<Dog> getPuppies() {
		return puppies;
	}

	public List<Dog> getAdults() {
		return adults;
	}

	public List<Dog> getOldDogs() {
		return oldDogs;
	}
}

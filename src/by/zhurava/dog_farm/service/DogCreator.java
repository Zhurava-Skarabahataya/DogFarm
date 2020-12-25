package by.zhurava.dog_farm.service;

import java.util.ArrayList;
import java.util.List;

import by.zhurava.dog_farm.dao.DogDAO;
import by.zhurava.dog_farm.entity.dog.AdultDog;
import by.zhurava.dog_farm.entity.dog.Dog;
import by.zhurava.dog_farm.entity.dog.DogAgeGroup;
import by.zhurava.dog_farm.entity.dog.OlderDog;
import by.zhurava.dog_farm.entity.dog.Puppy;
import by.zhurava.dog_farm.util.parser.DogParser;
import by.zhurava.dog_farm.util.parser.Parser;

public class DogCreator {

	private static final DogCreator instance = new DogCreator();

	private DogCreator() {

	}

	public static DogCreator getInstance() {
		return instance;
	}

	public static List<Dog> createListOfDogs() {

		List<Dog> allDogs = new ArrayList<Dog>();

		DogDAO dogDAO = DogDAO.getInstance();
		String allDogsInfo = dogDAO.findDogsInfo();

		Parser parser = DogParser.getInstance();

		String[] infoAboutDogs = parser.parseWholeTextIntoStrings(allDogsInfo);

		for (String infoAboutOneDog : infoAboutDogs) {

			if (!infoAboutOneDog.isEmpty()) {

				Dog employee = createNewDog(infoAboutOneDog);
				allDogs.add(employee);

			}

		}
		return allDogs;

	}

	private static Dog createNewDog(String infoAboutOneDog) {

		Dog dog;

		Parser parser = DogParser.getInstance();
		String[] dogInfo = parser.parseOneString(infoAboutOneDog);

		String name = dogInfo[0];
		int weight = Integer.parseInt(dogInfo[1]);
		double age = Double.parseDouble(dogInfo[2]);
		int healthNum = Integer.parseInt(dogInfo[3]);
		DogAgeGroup dogAgeGroup = DogAgeGroup.defineAgeGroup(age);

		switch (dogAgeGroup) {
		case PUPPY: {
			dog = new Puppy();
			break;
		}
		case ADULT: {
			dog = new AdultDog();
			break;

		}
		case OLD: {
			dog = new OlderDog();
			break;

		}
		default:{
			dog = new AdultDog();
		}
		}

		dog.setName(name);
		dog.setAge(dogAgeGroup);
		dog.setWeight(weight);

		if (healthNum == 1) {
			dog.setHealthy(true);

		} else {
			dog.setHealthy(false);
		}

		return dog;
	}

}

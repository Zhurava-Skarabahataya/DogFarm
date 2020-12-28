package by.zhurava.dog_farm.entity.employee;

import by.zhurava.dog_farm.entity.dog.Dog;
import by.zhurava.dog_farm.entity.dog.DogAgeGroup;
import by.zhurava.dog_farm.util.printer.ConsolePrinter;
import by.zhurava.dog_farm.util.printer.Printer;

public class Worker extends Employee implements Feeding, Cleaning {

	@Override
	public void feedDog(Dog dog) {

		dog.setHungry(false);

		int amountOfFood = 0;

		DogAgeGroup dogAgeGroup = dog.getAge();

		switch (dogAgeGroup) {
		case PUPPY: {
			amountOfFood += 200;
		}
		case ADULT: {
			amountOfFood += 100;
		}
		case OLD: {
			amountOfFood += 50;
		}
		}

		int timeToFeed = amountOfFood * 2;

		try {
			Thread.sleep(timeToFeed);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String workerName = this.getFirstName() + " " + this.getSecondName();

		Printer printer = ConsolePrinter.getInstance();

		printer.printInfoDogIsFed(dog, workerName);

	}

	@Override
	public void cleanCages() {

		Printer printer = ConsolePrinter.getInstance();
		String workerName = this.getFirstName() + " " + this.getSecondName();
		
		printer.printCageIsClean(workerName);
		
		
	}

}

package by.zhurava.dog_farm.util.printer;

import by.zhurava.dog_farm.entity.dog.Dog;
import by.zhurava.dog_farm.entity.employee.Driver;
import by.zhurava.dog_farm.entity.employee.Employee;
import by.zhurava.dog_farm.entity.employee.Position;
import by.zhurava.dog_farm.entity.employee.Trainer;

public class ConsolePrinter implements Printer {

	private static final ConsolePrinter instance = new ConsolePrinter();

	private ConsolePrinter() {

	}

	public static ConsolePrinter getInstance() {
		return instance;
	}

	@Override
	public void printInfoAboutWorkerArrival(Employee employee) {

		String firstName = employee.getFirstName();
		String secondName = employee.getSecondName();

		Position position = employee.getPosition();

		System.out.printf("%s %s, %s, arrived to work.%n", firstName, secondName, position.name().toLowerCase());

	}

	@Override
	public void printInfoAboutGodWakeUp(Dog dog) {

		String dogName = dog.getName();

		System.out.printf("The dog named %s is awake.%n", dogName);

	}

	@Override
	public void printInfoAllDogsAreFull() {

		System.out.println("All dogs are fed.");

	}

	@Override
	public void printInfoDogIsFed(Dog dog, String workerName) {

		String dogName = dog.getName();

		System.out.printf("The dog %s is fed by %s.%n", dogName, workerName);

	}

	@Override
	public void printInfoFarmOpens() {

		System.out.println("DOG FARM OPENS!");

	}

	@Override
	public void printDogIsHealthy(Dog dog) {

		String dogName = dog.getName();

		System.out.printf("%s is healthy, no need of treatment.%n", dogName);

	}

	@Override
	public void printDogIsCured(String dogName) {

		System.out.printf("%s is cured!%n", dogName);

	}

	@Override
	public void printVeterinarianIsTreating(String doctorName, String dogName) {

		System.out.printf("%s is treating %s...%n", doctorName, dogName);

	}

	@Override
	public void printAllDogsHealthy() {

		System.out.println("All dogs are healthy!");
	}

	@Override
	public void printCageIsClean(String workerName) {

		System.out.printf("%s cleaned cages.%n", workerName);

	}

	@Override
	public void printOldDogActivity(Dog dog) {

		String dogName = dog.getName();
		System.out.printf("%s is chilling in bed.%n", dogName);

	}

	@Override
	public void driveDogToWork(Driver driver, Dog dog) {

		String driverName = driver.getFirstName() + " " + driver.getSecondName();
		String dogName = dog.getName();
		
		System.out.printf("%s is driving %s to work.%n", driverName, dogName);

	}

	@Override
	public void dogIsWorking(Dog dog) {

		String dogName = dog.getName();

		System.out.printf("%s is working%n", dogName);

	}

	@Override
	public void driveDogFromWork(Driver driver, Dog dog) {

		String driverName = driver.getFirstName() + " " + driver.getSecondName();
		String dogName = dog.getName();
		
		System.out.printf("%s brought %s back.%n", driverName, dogName);

	}

	@Override
	public void puppyTrained(Trainer trainer, Dog dog) {
		
		String trainerName = trainer.getFirstName() + " " + trainer.getSecondName();
		String dogName = dog.getName();
		
		System.out.printf("%s is training %s.%n", trainerName, dogName);
		
	}

	@Override
	public void printFarmCloses() {
		System.out.println("The farm closes.");
	}

}

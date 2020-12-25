package by.zhurava.dog_farm.util.printer;

import by.zhurava.dog_farm.entity.dog.Dog;
import by.zhurava.dog_farm.entity.employee.Driver;
import by.zhurava.dog_farm.entity.employee.Employee;
import by.zhurava.dog_farm.entity.employee.Trainer;

public interface Printer {
	
	void printInfoAboutWorkerArrival(Employee employee);

	void printInfoAboutGodWakeUp(Dog dog);

	void printInfoAllDogsAreFull();

	void printInfoDogIsFed(Dog dog, String workerName);

	void printInfoFarmOpens();

	void printDogIsHealthy(Dog dog);

	void printVeterinarianIsTreating(String doctorName, String dogName);

	void printDogIsCured(String dogName);

	void printAllDogsHealthy();

	void printCageIsClean(String workerName);

	void printOldDogActivity(Dog dog);

	void driveDogToWork(Driver driver, Dog dog);

	void dogIsWorking(Dog dog);

	void driveDogFromWork(Driver driver,Dog dog);

	void puppyTrained(Trainer trainer, Dog puppy);

	void printFarmCloses();


}

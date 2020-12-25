package by.zhurava.dog_farm.controller;

import java.util.List;
import java.util.Queue;

import by.zhurava.dog_farm.entity.dog.Dog;
import by.zhurava.dog_farm.entity.dog.pool.DogPool;
import by.zhurava.dog_farm.entity.employee.Employee;
import by.zhurava.dog_farm.entity.employee.Veterenarian;
import by.zhurava.dog_farm.entity.employee.Worker;
import by.zhurava.dog_farm.entity.employee.pool.StaffPool;
import by.zhurava.dog_farm.util.printer.ConsolePrinter;
import by.zhurava.dog_farm.util.printer.Printer;

public class DogFarm {

	private static final DogFarm instance = new DogFarm();
	
	private static final Printer printer = ConsolePrinter.getInstance();

	private DogFarm() {

	}

	public static DogFarm getInstance() {
		return instance;
	}

	public void function() {

		printer.printInfoFarmOpens();
		
		startNewDay();

		mainActivity();
		
		printer.printFarmCloses();

	}

	private void mainActivity() {
		
		feedDogs();

		veterenarianCheckUp();

		cleaning();

		dogActivity();

		feedDogs();
	}

	private void dogActivity() {

		List <Dog> dogs = DogPool.getInstance().getAllDogs();
		
		for (Dog dog :dogs) {
			dog.doActivity();
		}
		
	}

	private void cleaning() {

		StaffPool staff = StaffPool.getInstance();

		Queue<Employee> workers = staff.getFreeWorkers();
		
		for (Employee employee : workers) {
			
			Worker worker = (Worker) employee;
			
			worker.cleanCages();
		}
		
	}

	private void veterenarianCheckUp() {

		List <Dog> dogsToTreat = DogPool.getInstance().getAllDogs();
		
		StaffPool staff = StaffPool.getInstance();

		for (Dog dog : dogsToTreat) {
			
			Veterenarian veterenarian = (Veterenarian) staff.getFreeVeterenarian();
			
			veterenarian.treatDog(dog);
			
			staff.releaseVeterenarian(veterenarian);
			
		}
		
		printer.printAllDogsHealthy();

		
	}

	private void feedDogs() {
		
		List <Dog> dogsToFeed = DogPool.getInstance().getAllDogs();
		
		StaffPool staff = StaffPool.getInstance();
		
		for (Dog hungryDog : dogsToFeed) {
			
			Worker worker = (Worker) staff.getFreeWorker();
			
			worker.feedDog(hungryDog);
			
			staff.releaseWorker(worker);
		}
		
		printer.printInfoAllDogsAreFull();
		
	}

	private void startNewDay() {

		bringWorkersToFarm();
		wakeUpDogs();

	}

	private void wakeUpDogs() {

		DogPool dogPool = DogPool.getInstance();
		dogPool.initDogPool();

	}

	private void bringWorkersToFarm() {

		StaffPool staffPool = StaffPool.getInstance();
		staffPool.initStaffPool();

	}

}

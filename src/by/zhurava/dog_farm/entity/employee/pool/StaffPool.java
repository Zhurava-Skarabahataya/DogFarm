package by.zhurava.dog_farm.entity.employee.pool;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

import by.zhurava.dog_farm.entity.employee.Employee;
import by.zhurava.dog_farm.entity.employee.Position;
import by.zhurava.dog_farm.service.EmployeeCreator;
import by.zhurava.dog_farm.util.printer.ConsolePrinter;

public class StaffPool {

	private static final StaffPool instance = new StaffPool();

	private Queue<Employee> freeVeterenarians;
	private Queue<Employee> freeTrainers;
	private Queue<Employee> freeDrivers;
	private Queue<Employee> freeWorkers;

	private StaffPool() {

		freeVeterenarians = new ArrayDeque<Employee>();
		freeTrainers = new ArrayDeque<Employee>();
		freeDrivers = new ArrayDeque<Employee>();
		freeWorkers = new ArrayDeque<Employee>();

	}

	public static StaffPool getInstance() {
		return instance;
	}

	public void initStaffPool() {

		List<Employee> employees = EmployeeCreator.createListOfEmployees();

		for (Employee employee : employees) {

			Position position = employee.getPosition();

			ConsolePrinter.getInstance().printInfoAboutWorkerArrival(employee);

			switch (position) {

			case VETERINARIAN: {
				freeVeterenarians.add(employee);
				break;
			}
			case TRAINER: {
				freeTrainers.add(employee);
				break;

			}
			case DRIVER: {
				freeDrivers.add(employee);
				break;
			}
			case WORKER: {
				freeWorkers.add(employee);
				break;
			}
			default: {
				break;
			}
			}

		}

	}

	public Queue<Employee> getFreeWorkers() {
		return freeWorkers;
	}

	public Employee getFreeVeterenarian() {

		Employee veterinarian;

		veterinarian = freeVeterenarians.poll();

		while (veterinarian == null) {
			System.out.println("Все ветеринары заняты.");
			try {
				Thread.sleep(10000);
				veterinarian = freeVeterenarians.poll();
			} catch (InterruptedException e) {

				throw new RuntimeException("The thread was interrupted.", e);
			}
		}

		return veterinarian;
	}

	public void releaseVeterenarian(Employee veterenarian) {

		freeVeterenarians.add(veterenarian);
	}

	public Employee getFreeWorker() {

		Employee worker;

		worker = freeWorkers.poll();

		while (worker == null) {
			System.out.println("All workers are occupied.");
			try {
				Thread.sleep(10000);
				worker = freeWorkers.poll();
			} catch (InterruptedException e) {

				throw new RuntimeException("The thread was interrupted.", e);
			}
		}

		return worker;

	}

	public void releaseWorker(Employee worker) {

		freeWorkers.add(worker);
	}

	public Employee getFreeDriver() {

		Employee driver;

		driver = freeDrivers.poll();

		while (driver == null) {
			System.out.println("All drivers are occupied.");
			try {
				Thread.sleep(10000);
				driver = freeDrivers.poll();
			} catch (InterruptedException e) {
				throw new RuntimeException("The thread was interrupted.", e);
			}
		}

		return driver;

	}

	public void releaseDriver(Employee driver) {

		freeDrivers.add(driver);
	}

	public Employee getFreeTrainer() {

		Employee trainer;

		trainer = freeTrainers.poll();

		while (trainer == null) {
			System.out.println("All trainers are occupied.");
			try {
				Thread.sleep(10000);
				trainer = freeDrivers.poll();
			} catch (InterruptedException e) {
				
				throw new RuntimeException("The thread was interrupted.", e);
			}
		}

		return trainer;

	}

	public void releaseTrainer(Employee trainer) {

		freeTrainers.add(trainer);
	}

}

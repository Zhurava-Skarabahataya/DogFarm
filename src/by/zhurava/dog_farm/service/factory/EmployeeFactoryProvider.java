package by.zhurava.dog_farm.service.factory;

import java.util.HashMap;
import java.util.Map;

import by.zhurava.dog_farm.entity.employee.Position;

public class EmployeeFactoryProvider {

	private static final EmployeeFactoryProvider instance = new EmployeeFactoryProvider();

	private final Map<Position, EmployeeFactory> factories;

	private EmployeeFactoryProvider() {

		factories = new HashMap<Position, EmployeeFactory>();

		factories.put(Position.DIRECTOR, new DirectorFactory());
		factories.put(Position.DRIVER, new DriverFactory());
		factories.put(Position.TRAINER, new TrainerFactory());
		factories.put(Position.VETERINARIAN, new VeterenarianFactory());
		factories.put(Position.WORKER, new WorkerFactory());

	}

	public static EmployeeFactoryProvider getInstance() {
		return instance;
	}

	public EmployeeFactory getEmployeeFactory(String position) {

		EmployeeFactory employeeFactory;

		String positionName = position.toUpperCase();

		Position currentPosition = Position.valueOf(positionName);

		employeeFactory = factories.get(currentPosition);
		return employeeFactory;

	}

}

package by.zhurava.dog_farm.service.factory;

import by.zhurava.dog_farm.entity.employee.Employee;
import by.zhurava.dog_farm.entity.employee.Position;
import by.zhurava.dog_farm.entity.employee.Trainer;

public class TrainerFactory implements EmployeeFactory {

	@Override
	public Employee createEmployee(String[] employeeInfo) {
		
		Employee employee;

		String firstName = employeeInfo[0];
		String secondName = employeeInfo[1];
		String position = employeeInfo[2];
		
		employee = new Trainer();
		employee.setFirstName(firstName);
		employee.setSecondName(secondName);
		employee.setPosition(Position.valueOf(position.toUpperCase()));
		
		return employee;
	}

}

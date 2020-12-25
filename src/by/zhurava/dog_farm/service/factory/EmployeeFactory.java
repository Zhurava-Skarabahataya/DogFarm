package by.zhurava.dog_farm.service.factory;

import by.zhurava.dog_farm.entity.employee.Employee;

public interface EmployeeFactory {
	
	Employee createEmployee(String[] employeeInfo);

}

package by.zhurava.dog_farm.service;

import java.util.ArrayList;
import java.util.List;

import by.zhurava.dog_farm.dao.EmployeeDAO;
import by.zhurava.dog_farm.entity.employee.Employee;
import by.zhurava.dog_farm.service.factory.EmployeeFactory;
import by.zhurava.dog_farm.service.factory.EmployeeFactoryProvider;
import by.zhurava.dog_farm.util.parser.EmployeeParser;
import by.zhurava.dog_farm.util.parser.Parser;

public class EmployeeCreator {

	private static final EmployeeCreator instance = new EmployeeCreator();

	private EmployeeCreator() {

	}

	public static EmployeeCreator getInstance() {
		return instance;
	}

	public static List<Employee> createListOfEmployees() {

		List<Employee> allEmployees = new ArrayList<Employee>();

		EmployeeDAO employeeDAO = EmployeeDAO.getInstance();
		String allEmployeesData = employeeDAO.findEmployeesInfo();

		Parser parser = EmployeeParser.getInstance();

		String[] infoAboutEmployees = parser.parseWholeTextIntoStrings(allEmployeesData);

		for (String infoAboutOneEmployee : infoAboutEmployees) {

			if (!infoAboutOneEmployee.isEmpty()) {

				Employee employee = createNewEmployee(infoAboutOneEmployee);
				allEmployees.add(employee);

			}

		}
		return allEmployees;
	}

	private static Employee createNewEmployee(String infoAboutOneEmployee) {

		Employee employee;

		Parser parser = EmployeeParser.getInstance();

		String[] employeeInfo = parser.parseOneString(infoAboutOneEmployee);

		String position = employeeInfo[2];

		EmployeeFactory employeeFactory = EmployeeFactoryProvider.getInstance().getEmployeeFactory(position);
		employee = employeeFactory.createEmployee(employeeInfo);
		
		return employee;

	}

}

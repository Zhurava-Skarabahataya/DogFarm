package by.zhurava.dog_farm.dao;

public class EmployeeDAO {

	private static final EmployeeDAO instance = new EmployeeDAO();

	private static final String FILE_PATH = "resource\\employees.txt";

	private EmployeeDAO() {

	}

	public static EmployeeDAO getInstance() {
		return instance;
	}

	public String findEmployeesInfo() {

		FileReaderDAO fileReaderDAO = FileReaderDAO.getInstance();
		String completeEmployeesInfo = fileReaderDAO.readTextFromFile(FILE_PATH);

		return completeEmployeesInfo;
	}

}

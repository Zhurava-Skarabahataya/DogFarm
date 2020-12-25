package by.zhurava.dog_farm.util.parser;

public class EmployeeParser implements Parser{
	
	private static final EmployeeParser instance = new EmployeeParser();
	
	private static final String EMPLOYEE_STRING_DELIMITER = "\n";
	private static final String EMPLOYEE_INFO_DELIMITER = ", ";

	private EmployeeParser() {
	}
	
	
	public static EmployeeParser getInstance() {
		return instance;
	}
	
	
	@Override
	public String[] parseWholeTextIntoStrings(String source) {
		
		String[] infoAboutEmployees = source.split(EMPLOYEE_STRING_DELIMITER); 
		return infoAboutEmployees;
	}


	@Override
	public String[] parseOneString(String source) {
		
		String[] employeeInfo = source.split(EMPLOYEE_INFO_DELIMITER);
		return employeeInfo;
	}

	
	
}

package by.zhurava.dog_farm.util.parser;

public class DogParser implements Parser{
	
private static final DogParser instance = new DogParser();
	
	private static final String DOG_STRING_DELIMITER = "\n";
	private static final String DOG_INFO_DELIMITER = ", ";
	
	private DogParser() {
	}
	
	
	public static DogParser getInstance() {
		return instance;
	}
	

	@Override
	public String[] parseWholeTextIntoStrings(String sourse) {
		
		String[] infoAboutDogs = sourse.split(DOG_STRING_DELIMITER); 
		return infoAboutDogs;
	}

	@Override
	public String[] parseOneString(String source) {
		
		String[] dogInfo = source.split(DOG_INFO_DELIMITER);
		return dogInfo;
	}

	
	
}

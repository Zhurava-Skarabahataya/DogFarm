package by.zhurava.dog_farm.dao;

public class DogDAO {

	private static final DogDAO instance = new DogDAO();

	private static final String FILE_PATH = "resource\\dogs.txt";

	private DogDAO() {

	}

	public static DogDAO getInstance() {
		return instance;
	}

	public String findDogsInfo() {

		FileReaderDAO fileReaderDAO = FileReaderDAO.getInstance();
		String completeDogInfo = fileReaderDAO.readTextFromFile(FILE_PATH);

		return completeDogInfo;

	}

}

package by.zhurava.dog_farm.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderDAO {

	private static final FileReaderDAO instance = new FileReaderDAO();

	private FileReaderDAO() {

	}

	public static FileReaderDAO getInstance() {
		return instance;
	}

	public String readTextFromFile(String fileName) {

		StringBuilder completeTextFromFile = new StringBuilder();

		try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {

			String line = reader.readLine();

			while (line != null) {
				completeTextFromFile.append(line);
				completeTextFromFile.append("\n");

				line = reader.readLine();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return completeTextFromFile.toString();
	}

}

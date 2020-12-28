package by.zhurava.dog_farm.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import by.zhurava.dog_farm.dao.exception.DAOException;

public class FileReaderDAO {

	private static final FileReaderDAO instance = new FileReaderDAO();

	private FileReaderDAO() {

	}

	public static FileReaderDAO getInstance() {
		return instance;
	}

	/**
	 * Method that reads some text file and returns its content.
	 * 
	 * @param fileName name of file
	 * @return A String containing all file information
	 */
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

			throw new DAOException("Problems with file: file not found.");
		} catch (IOException e) {
			
			throw new DAOException("Problems with reding file.");
		}

		return completeTextFromFile.toString();
	}

}

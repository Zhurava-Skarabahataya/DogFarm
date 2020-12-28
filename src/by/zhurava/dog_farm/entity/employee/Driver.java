package by.zhurava.dog_farm.entity.employee;

import by.zhurava.dog_farm.entity.dog.Dog;
import by.zhurava.dog_farm.util.printer.ConsolePrinter;
import by.zhurava.dog_farm.util.printer.Printer;

public class Driver extends Employee{

	public void driveDogToWork(Dog dog){
		
		Printer printer = ConsolePrinter.getInstance();
		printer.driveDogToWork(this, dog);
		
	}

	public void driveDogFromWork(Dog dog) {
		Printer printer = ConsolePrinter.getInstance();
		printer.driveDogFromWork(this, dog);
		
		
	}

}

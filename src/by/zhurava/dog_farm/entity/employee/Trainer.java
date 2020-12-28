package by.zhurava.dog_farm.entity.employee;

import by.zhurava.dog_farm.entity.dog.Puppy;
import by.zhurava.dog_farm.util.printer.ConsolePrinter;
import by.zhurava.dog_farm.util.printer.Printer;

public class Trainer extends Employee{

	public void trainPuppy(Puppy puppy) {
		
		puppy.setTrained(true);
		
		Printer printer = ConsolePrinter.getInstance();
		printer.puppyTrained(this, puppy);
		
	}

}

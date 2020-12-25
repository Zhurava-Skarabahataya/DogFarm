package by.zhurava.dog_farm.entity.dog;

import by.zhurava.dog_farm.util.printer.ConsolePrinter;
import by.zhurava.dog_farm.util.printer.Printer;

public class OlderDog extends Dog {

	@Override
	public void doActivity() {

		stayInBed();
		
	}

	private void stayInBed() {
		
		Printer printer = ConsolePrinter.getInstance();
		printer.printOldDogActivity(this);
		
	}

}

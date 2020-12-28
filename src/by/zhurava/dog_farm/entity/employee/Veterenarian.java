package by.zhurava.dog_farm.entity.employee;

import by.zhurava.dog_farm.entity.dog.Dog;
import by.zhurava.dog_farm.util.printer.ConsolePrinter;
import by.zhurava.dog_farm.util.printer.Printer;

public class Veterenarian extends Employee implements Treating{

	@Override
	public void treatDog(Dog dog) {
		
		Printer printer = ConsolePrinter.getInstance();
		
		boolean isDogHealthy = dog.isHealthy();
		
		if (isDogHealthy) {
			
			printer.printDogIsHealthy(dog);
		}
		else {
			try {
				String doctorName = this.getFirstName().concat(" ").concat(getSecondName());
				String dogName = dog.getName();
				
				printer.printVeterinarianIsTreating(doctorName, dogName);
				
				Thread.sleep(5000);
				dog.setHealthy(true);
				
				printer.printDogIsCured(dogName);
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		
	}

}

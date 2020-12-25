package by.zhurava.dog_farm.entity.dog;

import by.zhurava.dog_farm.entity.employee.Driver;
import by.zhurava.dog_farm.entity.employee.pool.StaffPool;
import by.zhurava.dog_farm.util.printer.ConsolePrinter;
import by.zhurava.dog_farm.util.printer.Printer;

public class AdultDog extends Dog {

	@Override
	public void doActivity() {

		goToWork();
		work();
		returnFromWork();
		
	}

	private void returnFromWork() {
		
		StaffPool staff = StaffPool.getInstance();

		Driver driver = (Driver) staff.getFreeDriver();
		
		driver.driveDogFromWork(this);
		staff.releaseDriver(driver);
		
	}

	private void work() {
		Printer printer = ConsolePrinter.getInstance();
		printer.dogIsWorking(this);
		
	}

	private void goToWork() {
		
		StaffPool staff = StaffPool.getInstance();

		Driver driver = (Driver) staff.getFreeDriver();
		
		driver.driveDogToWork(this);
		staff.releaseDriver(driver);
		
		
		
	}

}

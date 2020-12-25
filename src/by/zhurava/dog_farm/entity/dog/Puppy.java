package by.zhurava.dog_farm.entity.dog;

import by.zhurava.dog_farm.entity.employee.Trainer;
import by.zhurava.dog_farm.entity.employee.pool.StaffPool;

public class Puppy extends Dog {

	@Override
	public void doActivity() {

		train();
		
	}

	private void train() {

		StaffPool staff = StaffPool.getInstance();

		Trainer trainer = (Trainer) staff.getFreeTrainer();
		
		trainer.trainPuppy(this);
		
		staff.releaseTrainer(trainer);
		
	}

}

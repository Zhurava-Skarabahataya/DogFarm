package by.zhurava.dog_farm.entity.dog;

public enum DogAgeGroup {

	PUPPY(0, 1), ADULT(1, 8), OLD(8, 24);

	private final int minAge;
	private final int maxAge;

	private DogAgeGroup(int minAge, int maxAge) {
		this.minAge = minAge;
		this.maxAge = maxAge;
	}

	public static DogAgeGroup defineAgeGroup(double age) {

		for (DogAgeGroup ageGroup : DogAgeGroup.values()) {
			if (age > ageGroup.minAge && age <= ageGroup.maxAge) {
				return ageGroup;
			}
		}

		return null;

	}

}

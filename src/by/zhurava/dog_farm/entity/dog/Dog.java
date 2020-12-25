package by.zhurava.dog_farm.entity.dog;

public abstract class Dog {

	private String name;

	private int weight;

	private DogAgeGroup age;

	private boolean healthy;
	private boolean hungry;
	private boolean trained;

	public String getName() {
		return name;
	}

	public int getWeight() {
		return weight;
	}

	public DogAgeGroup getAge() {
		return age;
	}

	public boolean isHealthy() {
		return healthy;
	}

	public boolean isHungry() {
		return hungry;
	}

	public boolean isTrained() {
		return trained;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public void setAge(DogAgeGroup age) {
		this.age = age;
	}

	public void setHealthy(boolean healthy) {
		this.healthy = healthy;
	}

	public void setHungry(boolean hungry) {
		this.hungry = hungry;
	}

	public void setTrained(boolean trained) {
		this.trained = trained;

	}
	
	public abstract void doActivity();
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((age == null) ? 0 : age.hashCode());
		result = prime * result + (healthy ? 1231 : 1237);
		result = prime * result + (hungry ? 1231 : 1237);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + (trained ? 1231 : 1237);
		result = prime * result + weight;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dog other = (Dog) obj;
		if (age != other.age)
			return false;
		if (healthy != other.healthy)
			return false;
		if (hungry != other.hungry)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (trained != other.trained)
			return false;
		if (weight != other.weight)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Dog [name=" + name + ", weight=" + weight + ", age=" + age + ", healthy=" + healthy + ", hungry="
				+ hungry + ", trained=" + trained + "]";
	}

}

package phase2;

public class MartyrRecord implements Comparable<MartyrRecord>{ //Class martyr :

	private String name;
	private int age;
	private String gender;

	public MartyrRecord() {

		this.name = "";
		this.age = 0;
		this.gender = "";
	}

	public MartyrRecord(String name, int age, String gender) {

		this.name = name;
		this.age = age;
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {

		return "Martyr [name=" + name + ", age=" + age +
				 ", gender=" + gender + "]\n";
	}

	@Override
	public int compareTo(MartyrRecord o) {

		if (this.age-o.age==0) {

			return this.gender.toUpperCase().compareTo(o.gender.toUpperCase());
		}

		return (int) (this.age -o.age);

	}

	public boolean equals(Object o) {

		if (o instanceof MartyrRecord) {

			return this.name.equalsIgnoreCase(((MartyrRecord)o).name);
		}

		return false;
	}

	public int compareToByName(MartyrRecord o) {

		return this.name.toUpperCase().compareTo(o.name.toUpperCase());

	}
}

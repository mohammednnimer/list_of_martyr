package application;

public class Martyr implements Comparable<Martyr> {
	
	String name;
	int age;
	String location;
	String DateOfdeath;
	char gender;
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
		if(age>=0)
		{
			this.age = age;
		}
		else {
			System.out.println(age);
         System.out.println("sorry the age is anvlaid");
		}
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDateOfdeath() {
		return DateOfdeath;
	}
	public void setDateOfdeath(String dateOfdeath) {
		DateOfdeath = dateOfdeath;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		if(gender == 'F' || gender == 'M')
		     this.gender = gender;
		else
			System.out.println("sorry the enter error");
	}
	public Martyr(String name, int age, String location, String dateOfdeath, char gender) {
		super();
		this.name = name;
		setAge(age);
		this.location = location;
		DateOfdeath = dateOfdeath;
		setGender(gender);
	}
	@Override
	public String toString() {
		return "Martyr [name=" + name + ", age=" + age + ", location=" + location + ", DateOfdeath=" + DateOfdeath
				+ ", gender=" + gender + "]";
	}
	@Override
	public int compareTo(Martyr o) {
		// TODO Auto-generated method stub
		return this.name.compareTo(o.name);
	}
	
	
	

}

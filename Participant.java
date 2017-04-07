/**
 * The is the Participant class of Ozlympic Game Program
 * An abstract class for Officials and Athletes
 *
 * @author  Rita Tse
 * @version 1.0
 * @since   2017-04-07
 */
public abstract class Participant {

	private String ID;
	private String name;
	private int age;
	private String state;

	//Constructor
	public Participant (String ID, String name, int age, String state ) 
	{
		this.ID = ID;
		this.name = name;
		this.age = age;
		this.state = state;  		
	}

	//Getters and Setters
	public String getID() {
		return ID;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public String getState() {
		return state;
	}

	public void setID(String Id) {
		this.ID=Id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setState(String state) {
		this.state = state;

	}
}

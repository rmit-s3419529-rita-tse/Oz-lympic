import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * The is the Participant class of Ozlympic Game Program
 * An abstract class for Officials and Athletes
 *
 * @author  Rita Tse
 * @version 1.0
 * @since   2017-04-07
 */
public abstract class Participant {

	private SimpleStringProperty ID;
	private SimpleStringProperty name;
	private SimpleStringProperty type;
	private SimpleIntegerProperty age;
	private SimpleStringProperty state;

	//Constructor
	public Participant (String ID, String type, String name, int age, String state ) 
	{
		this.ID =  new SimpleStringProperty(ID);
		this.type = new SimpleStringProperty(type);
		this.name = new SimpleStringProperty(name);
		this.age = new SimpleIntegerProperty(age);
		this.state = new SimpleStringProperty(state);  		
	}

	//Getters and Setters
	public String getID() {
		return ID.get();
	}
	public String getName() {
		return name.get();
	}
	public int getAge() {
		return age.get();
	}
	public String getState() {
		return state.get();
	}
	
	public String getType() {
		return type.get();
	}
}

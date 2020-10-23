/* Name: Nihal Punjani
 * Date: 07.28.20
 * Program Description: This file contains variables and methods for the NBAPlayer file, this methods and variables will be used in the NBAPlayoff file
 */
public class NBAPlayer {
	
	//Declaring a String variable for name
	String name;
	//declaring an integer variable for age
	int age;
	
	//method to return the value for name
	public String getName() {
		return name;
	}
	
	//method to set a new value for name
	public void setName(String name) {
		this.name = name;
	}
	
	//method to return the value of age
	public int getAge() {
		return age;
	}
	
	//method to set a new value for age
	public void setAge(int age) {
		this.age = age;
	}
	
	//empty constructor for NBAPlayer
	public NBAPlayer() {
		//assigning this instance of name to nothing
		this.name="";
		//assigning this instance of age to 0
		this.age= 0;
	}
	
	//constructor with parameters name and age
	public NBAPlayer(String name, int age) {
		//assigning this instance of name to the parameter name
		this.name = name;
		//assigning this instance of age to the parameter age
		this.age = age;
	}
	

}

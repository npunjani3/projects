/* Name: Nihal Punjani
 * Date: 07.28.20
 * Program Description: This file contains variables and methods for NBATeam. The variables and methods will be used in the NBAPlayoff file
 */

//importing ArrayList class
import java.util.ArrayList;

public class NBATeam {
	
	//declaring an array list of NBAPlayers
	ArrayList<NBAPlayer> roster;
	//declaring a string variable for team name
	String TeamName;
	//declaring an integer variable for max age
	int MaxAge;
	//declaring an integer variable for minimum age
	int MinAge;
	//declaring an integer variable for average age
	int AvgAge;
	//declaring an integer variable for total age
	int TotalAge;

	//empty constructor
	public NBATeam() {
		//assigning TeamName to no value
		TeamName = "";
		//assigning roster to a new NBAPlayer array list
		roster = new ArrayList<NBAPlayer>();
		//assigning MinAge to a larger value since most age values are larger than 0
		MinAge = 9999;
		//assigning MaxAge to 0
		MaxAge = 0;
		//assigning AvgAge to 0
		AvgAge =0;
	}
	
	//constructor with parameter TeamName
	public NBATeam(String TeamName) {
		//assigning this instance of TeamName to the parameter
		this.TeamName = TeamName;
		//assigning roster to a new NBAPlayer array list
		roster = new ArrayList<NBAPlayer>();
		//assigning MinAge to a larger value since most age values are larger than 0
		MinAge = 9999;
		//assigning MaxAge to 0
		MaxAge = 0;
		//assigning AvgAge to 0
		AvgAge =0;

	}
	
	//method to return value for TeamName
	public String getTeamName() {
		return TeamName;
	}
	
	//method to return value for MinAge	
	public int getMinAge() {
		return MinAge;
	}
	
	//method to return value for MaxAge
	public int getMaxAge() {
		return MaxAge;
	}
	
	//method to return value for AvgAge
	public int getAvgAge() {
		return AvgAge;
	}
	
	//method to add player to roster array list, method will simultaneously set minimum and maximum age. Then it will calculate the average age
	public void addAPlayer (String playerName, int age) {
		//calling the NBAPlayer String and Int constructor and adding to the roster array list 
		roster.add(new NBAPlayer(playerName,age));
		//if condition when age is less than MinAge
		if (age< MinAge)
			//assigning MinAge to age
			MinAge = age;
		//if condition when age is greater than MaxAge
		if(age > MaxAge)
			//assigning MaxAge to age
			MaxAge = age;
		//incrementing TotalAge with the value of age
		TotalAge += age;
		//Calculating the value of average age and assigning it to AvgAge
		AvgAge = TotalAge / roster.size();
	}
	
	//method to return the size of the array list roster
	public int getNumOfPlayer() {
		return roster.size();
	}
	
	//method to return values of roster
	public ArrayList<NBAPlayer> getNbaPlayers() {
		return roster;
	}
}

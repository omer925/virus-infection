package infected;

public class ColdCountry extends Country {
	public ColdCountry(String name, int population, int wealth) {
		super(name, population, wealth);
	}
	
	
	/*
	 * Returns all the attributes of the object in a readable format
	 */
	public String getInfo() {
        String tmp = "";
        tmp = "Name: " + super.getName() + 
        		"\nPopulation: " + String.format("%,d", super.getPop()) +
        		"\nTemperature: " + "Cold" +
        		"\nWealth: " + super.getWealth() + "/5";
        return tmp;		
	}
}

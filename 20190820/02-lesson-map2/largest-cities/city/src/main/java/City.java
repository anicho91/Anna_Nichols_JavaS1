import java.util.*;

public class City {
    //create properties name & pop for City
    private String name;
    private int population;

    //constructor to set the city name & population
    public City(String name, int population) {
        this.name = name;
        this.population = population;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //set city objects
        City newYork = new City("New York", 8654321);
        City losAngeles = new City("Los Angeles", 4563218);
        City chicago = new City("Chicago", 2716520);
        City denver = new City("Denver", 704621);
        City desMoines = new City("Des Moines", 217521);
        City atlanta = new City("Atlanta", 486213);

        //create State Map
        Map<String, City> state = new HashMap<>();

        //create State key names and City objects assigned to the corresponding State
        state.put("New York", newYork);
        state.put("California", losAngeles);
        state.put("Illinois", chicago);
        state.put("Colorado", denver);
        state.put("Iowa", desMoines);
        state.put("Georgia", atlanta);

        //Map.Entry to put the key State with City name and City population together and print them
        Set<Map.Entry<String, City>> myEntries = state.entrySet();
        for(Map.Entry<String, City> entry : myEntries){
            System.out.println("\nState: " + entry.getKey() + "\nCity: " + entry.getValue().name +
                    "\nPopulation: " + entry.getValue().population);
        }

        //ask user for population input
        System.out.println("\nEnter a population number.");
        int userInput = scan.nextInt();

        //Map.Entry to compare the population the userInput to the population value
        //and print States & Cities where population values are higher than the userInput
        for(Map.Entry<String, City>entry:myEntries){
            if(userInput<entry.getValue().population){
                System.out.println("\nState: " + entry.getKey() + "\nCity: " + entry.getValue().name);
            }
        }
    }
}


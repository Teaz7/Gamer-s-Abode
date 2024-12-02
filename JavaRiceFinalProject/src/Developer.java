import java.util.LinkedList;

public class Developer extends AccountUser{
    private String category;
    private LinkedList<Game> developerGameList;

    public Developer(String firstName, String lastName, String country, String emailAddress, Store store, Library library, String category) {
        super(firstName, lastName, country, emailAddress, store, library);
        this.category = category;
        this.developerGameList = new LinkedList<>();
    }

    public void changeAccountDetails() {
    	System.out.println("Change Account Details functionality is not yet implemented.");
    }

    public void displayAccountDetails() {
    	super.displayAccountDetails(); // Calling parent method to show basic account details
        System.out.println("Category: " + category);
        System.out.println("Number of Games Published: " + developerGameList.size());
    }

    public void publishGame(Game Game) {
    	developerGameList.add(Game);
        System.out.println("Game " + Game.getName() + " has been published by " + getFullName());
    }
}

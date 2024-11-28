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

    }

    public void displayAccountDetails() {

    }

    public void publishGame() {

    }
}

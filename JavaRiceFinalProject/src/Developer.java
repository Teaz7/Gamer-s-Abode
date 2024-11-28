import java.util.LinkedList;

public class Developer extends AccountUser{
    private String category;
    private LinkedList<Game> gameList;

    public Developer(String firstName, String lastName, String country, String emailAddress, Store store, Library library, String category) {
        super(firstName, lastName, country, emailAddress, store, library);
        this.category = category;
        this.gameList = new LinkedList<>();
    }

    public void publishGame() {

    }
}

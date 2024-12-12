import javax.swing.*;
import java.util.LinkedList;

public class Developer extends AccountUser{
    private String category;
    private LinkedList<Game> developerGameList;

    public Developer(String firstName, String lastName, String country, String emailAddress, Store store, Library library, String category) {
        super(firstName, lastName, country, emailAddress, store, library);
        this.category = category;
        this.developerGameList = new LinkedList<>();
    }

    @Override
    public void changeAccountDetails() {
    	System.out.println("Change Account Details functionality is not yet implemented.");
    }

    @Override
    public void displayAccountDetails() {
        String message = "";
        message += "Name: " + getFullName() + "\n";
        message += "Email: " + getEmailAddress() + "\n";
        message += "Country: " + getCountry() + "\n";
        message += "Category: " + category + "\n";
        message += "Number of Games: " + developerGameList.size() + "\n";

        JOptionPane.showMessageDialog(null, message, UITitle, JOptionPane.INFORMATION_MESSAGE);
    }

    public void publishGame(Game Game) {
    	developerGameList.add(Game);
        getStore().getStoreGameList().add(Game);
    }

    public void removeGame(Game Game) {
        developerGameList.remove(Game);
        System.out.println("Game " + Game.getName() + " has been removed by " + getFullName());
    }
}

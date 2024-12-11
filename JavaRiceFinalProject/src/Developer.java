import javax.swing.*;
import java.util.LinkedList;

public class Developer extends AccountUser{
    private String category;
    private LinkedList<Game> developerGameList;

    public Developer(String firstName, String lastName, String country, String emailAddress, Store store, Library library) {
        super(firstName, lastName, country, emailAddress, store, library);
        this.category = "Indie";
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
        System.out.println("Game " + Game.getName() + " has been published by " + getFullName());
    }

    public void removeGame(Game Game) {
        developerGameList.remove(Game);
        System.out.println("Game " + Game.getName() + " has been removed by " + getFullName());
    }
}

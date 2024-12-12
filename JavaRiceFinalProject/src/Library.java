import javax.swing.*;
import java.util.LinkedList;

public class Library implements GameDisplayFunctions {
    static String UITitle = "BSIT-2A Java Rice | Gamer's Abode Client";

    private LinkedList<Game> libraryGameList;
    private AccountUser accountUser = null;

    public Library() {
        libraryGameList = new LinkedList<>();
    }

    public void install(Game game) {
        game.setInstalled(true);
    }

    public void uninstall(Game game) {
        game.setInstalled(false);
    }

    public void addGameToLibrary(Game game) {
        libraryGameList.add(game);
    }

    public void removeGameFromLibrary(Game game) { libraryGameList.remove(game); }

    public AccountUser getAccountUser() {
        return accountUser;
    }

    public void setAccountUser(AccountUser accountUser) {
        this.accountUser = accountUser;
    }

    public LinkedList<Game> getLibraryGameList() {
        return libraryGameList;
    }

    @Override
    public void displayGames() {
        String message = "";

        message += "Name " + "\t\t\t" + "Year " + "\t\t\t" + "Owned" + "\t\t\t" + "Installed" + "\n";

        for (Game game : libraryGameList) {
            message += game.getName() + "\t\t\t" + game.getYear() + "\t\t\t" + game.getIsOwned() + "\t\t\t" + game.getIsInstalled() + "\n";
        }

        JOptionPane.showMessageDialog(null, new JTextArea(message), UITitle, JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void sortGamesName(int start, int end) {

    }
}

import java.util.LinkedList;

public class Library implements GameDisplayFunctions {
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

    }

    @Override
    public void sortGames() {

    }
}

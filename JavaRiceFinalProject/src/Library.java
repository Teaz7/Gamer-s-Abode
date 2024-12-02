import java.util.LinkedList;

public class Library implements GameDisplayFunctions {
    private LinkedList<Game> libraryGameList;
    private AccountUser accountUser = null;

    public Library() {
        libraryGameList = new LinkedList<>();
    }

    public AccountUser getAccountUser() {
        return accountUser;
    }

    public void setAccountUser(AccountUser accountUser) {
        this.accountUser = accountUser;
    }

    @Override
    public void displayGames() {

    }

    @Override
    public void sortGames() {

    }

	public void addGameToLibrary(Game game) {
		// TODO Auto-generated method stub
		
	}
}

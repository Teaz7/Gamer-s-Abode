import java.util.LinkedList;

public class Library implements GameDisplayFunctions {
    private LinkedList<Game> gameList;
    private AccountUser accountUser = null;

    public Library() {
        gameList = new LinkedList<>();
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
}

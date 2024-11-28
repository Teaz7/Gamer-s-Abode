import java.util.LinkedList;

public class Store implements GameDisplayFunctions {
    private LinkedList<Game> gameList;
    private Wishlist wishlist;

    public Store() {
        gameList = new LinkedList<>();
    }

    public void purchase(Game game) {

    }

    public void refund(Game game) {

    }

    @Override
    public void displayGames() {

    }

    @Override
    public void sortGames() {

    }
}

import java.util.LinkedList;

public class Store implements GameDisplayFunctions {
    private LinkedList<Game> storeGameList;
    private Wishlist wishlist;

    public Store() {
        storeGameList = new LinkedList<>();
    }

    public void purchase(Game game) {

    }

    public void refund(Game game) {

    }

    public LinkedList<Game> getStoreGameList() {
        return storeGameList;
    }

    @Override
    public void displayGames() {

    }

    @Override
    public void sortGames() {

    }
}

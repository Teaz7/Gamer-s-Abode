import java.util.Queue;
import java.util.LinkedList;

public class Wishlist {
    private Store store;
    private Queue<Game> gameWishList;

    public Wishlist(Store store) {
        this.store = store;
        gameWishList = new LinkedList<Game>();
    }

    public void addToWishlist(Game game) {
        gameWishList.add(game);
        System.out.println(game.getName() + " has been added to your wishlist.");
    }

    public void removeFromWishlist(Game game) {
        if (gameWishList.remove(game)) {
            System.out.println(game.getName() + " has been removed from your wishlist.");
        } else {
            System.out.println(game.getName() + " is not in your wishlist.");
        }
    }

    public void displayWishlist() {
        System.out.println("Your Wishlist:");
        for (Game game : gameWishList) {
            System.out.println("- " + game.getName());
        }
    }
}




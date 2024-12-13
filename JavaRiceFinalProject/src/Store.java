import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import java.util.LinkedList;
import java.util.Queue;

public class Store implements GameDisplayFunctions, WishlistFunctions {
    static String UITitle = "BSIT-2A Java Rice | Gamer's Abode Client";

    private AccountUser accountUser = null;
    private LinkedList<Game> storeGameList;
    private Queue<Game> wishList;

    public Store() {
        storeGameList = new LinkedList<>();
        wishList = new LinkedList<>();
    }

    public void purchase(Game game) {
        accountUser.getLibrary().addGameToLibrary(game);
        game.setIsOwned(true);
    }

    public void refund(Game game) {
        accountUser.getLibrary().removeGameFromLibrary(game);
        game.setIsOwned(false);
    }

    public LinkedList<Game> getStoreGameList() {
        return storeGameList;
    }

    public Queue<Game> getWishList() {
        return wishList;
    }

    public void setAccountUser(AccountUser accountUser) {
        this.accountUser = accountUser;
    }

    @Override
    public void displayGames() {
        LinkedList<Game> tempList = new LinkedList<>(storeGameList);

        tempList.removeIf(game -> wishList.contains(game));

        String message = "";

        message += "NAME" + "\t\t" + "PRICE" + "\t\t" + "DEVELOPER" + "\t\n\n";
        message += "WISHLIST\n";

        for (Game game: wishList) {
            message += game.getName();
            if (game.getName().length() > 15) {
                message += "\t";
            } else {
                message += "\t\t";
            }

            message += "P" + game.getPrice() + "\t\t" + game.getDeveloper().getFirstName() + "\t\n";
        }

        if (!wishList.isEmpty()) {
            message += "\n\nSTORE LIST\n";
        }

        for (Game game : tempList) {
            message += game.getName();
            if (game.getName().length() > 15) {
                message += "\t";
            } else {
                message += "\t\t";
            }

            message += "P" + game.getPrice() + "\t\t" + game.getDeveloper().getFirstName() + "\t\n";
        }

        JOptionPane.showMessageDialog(null, new JTextArea(message), UITitle, JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void sortGames(int start, int end, int type) {
        if (start >= end) {
            return;
        }

        int i = start;
        int j = end;

        switch (type) {
            case 0:
                String pivotName = storeGameList.get((start + end) / 2).getName();
                while (i <= j) {
                    while (storeGameList.get(i).getName().compareTo(pivotName) < 0) {
                        i++;
                    }
                    while (storeGameList.get(j).getName().compareTo(pivotName) > 0) {
                        j--;
                    }
                    if (i <= j) {
                        Game temp = storeGameList.get(i);
                        storeGameList.set(i, storeGameList.get(j));
                        storeGameList.set(j, temp);
                        i++;
                        j--;
                    }
                }
                break;

            case 1:
                double pivotPrice = storeGameList.get((start + end) / 2).getPrice();
                while (i <= j) {
                    while (storeGameList.get(i).getPrice() < pivotPrice) {
                        i++;
                    }
                    while (storeGameList.get(j).getPrice() > pivotPrice) {
                        j--;
                    }
                    if (i <= j) {
                        Game temp = storeGameList.get(i);
                        storeGameList.set(i, storeGameList.get(j));
                        storeGameList.set(j, temp);
                        i++;
                        j--;
                    }
                }
                break;

            case 2:
                String pivotDev = storeGameList.get((start + end) / 2).getDeveloper().getFirstName();
                while (i <= j) {
                    while (storeGameList.get(i).getDeveloper().getFirstName().compareTo(pivotDev) < 0) {
                        i++;
                    }
                    while (storeGameList.get(j).getDeveloper().getFirstName().compareTo(pivotDev) > 0) {
                        j--;
                    }
                    if (i <= j) {
                        Game temp = storeGameList.get(i);
                        storeGameList.set(i, storeGameList.get(j));
                        storeGameList.set(j, temp);
                        i++;
                        j--;
                    }
                }
                break;
        }

        sortGames(start, j, type);
        sortGames(i, end, type);
    }

    @Override
    public void addToWishlist(Game game) {
        wishList.offer(game);
    }

    @Override
    public void removeFromWishlist(Game game) {
        wishList.remove(game);
    }

    @Override
    public void displayWishlist() {
        String message = "";

        message += "NAME" + "\t\t" + "PRICE" + "\t\t" + "DEVELOPER" + "\t\n\n";

        for (Game game : wishList) {
            message += game.getName();
            if (game.getName().length() > 15) {
                message += "\t";
            } else {
                message += "\t\t";
            }

            message += "P" + game.getPrice() + "\t\t" + game.getDeveloper().getFirstName() + "\t\n";
        }

        JOptionPane.showMessageDialog(null, new JTextArea(message), UITitle, JOptionPane.INFORMATION_MESSAGE);
    }
}

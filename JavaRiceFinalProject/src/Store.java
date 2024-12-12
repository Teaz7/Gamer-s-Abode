import javax.swing.*;
import java.util.LinkedList;

public class Store implements GameDisplayFunctions {
    static String UITitle = "BSIT-2A Java Rice | Gamer's Abode Client";

    private AccountUser accountUser = null;
    private LinkedList<Game> storeGameList;
    private Wishlist wishlist;

    public Store() {
        storeGameList = new LinkedList<>();
    }

    public void purchase() {
        String message = "";
        Game game = null;

        message = "Do you want to purchase a game?\n";
        int promptConfirm = JOptionPane.showConfirmDialog(null, message, UITitle, JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (promptConfirm == JOptionPane.YES_OPTION) {
            message = "Input Game Name:\n";
            String userInput = JOptionPane.showInputDialog(null, message, UITitle, JOptionPane.PLAIN_MESSAGE);

            boolean gameFound = false;
            for (int i = 0; i < storeGameList.size(); i++) {
                if (storeGameList.get(i).getName().equalsIgnoreCase(userInput)) {
                    gameFound = true;
                    game = storeGameList.get(i);
                    break;
                }
            }

            if (gameFound) {
                message = "Do you want to purchase " + userInput + "?";
                promptConfirm = JOptionPane.showConfirmDialog(null, message, UITitle, JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);

                if (promptConfirm == JOptionPane.YES_OPTION) {
                    accountUser.getLibrary().addGameToLibrary(game);
                    JOptionPane.showMessageDialog(null, "Purchase Successful!", UITitle, JOptionPane.INFORMATION_MESSAGE);

                }
            }
        }
    }

    public void refund() {
        String message = "";
        Game game = null;

        message = "Do you want to refund a game?\n";
        int promptConfirm = JOptionPane.showConfirmDialog(null, message, UITitle, JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (promptConfirm == JOptionPane.YES_OPTION) {
            message = "Input Game Name:\n";
            String userInput = JOptionPane.showInputDialog(null, message, UITitle, JOptionPane.PLAIN_MESSAGE);

            boolean gameFound = false;
            for (int i = 0; i < storeGameList.size(); i++) {
                if (storeGameList.get(i).getName().equalsIgnoreCase(userInput)) {
                    gameFound = true;
                    game = storeGameList.get(i);
                    break;
                }
            }

            if (gameFound) {
                message = "Do you want to refund " + userInput + "?";
                promptConfirm = JOptionPane.showConfirmDialog(null, message, UITitle, JOptionPane.INFORMATION_MESSAGE);
                if (promptConfirm == JOptionPane.YES_OPTION) {
                    accountUser.getLibrary().removeGameFromLibrary(game);
                    JOptionPane.showMessageDialog(null, "Refund Successful!", UITitle, JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }

    }

    public LinkedList<Game> getStoreGameList() {
        return storeGameList;
    }

    public void setAccountUser(AccountUser accountUser) {
        this.accountUser = accountUser;
    }

    @Override
    public void displayGames() {
        String message = "";

        message += "Name " + "\t\t\t" + "Price" + "\n";

        for (Game game : storeGameList) {
            message += game.getName() + "\t\t\t" + game.getPrice() + "\n";
        }

        JOptionPane.showMessageDialog(null, new JTextArea(message), UITitle, JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void sortGamesName(int start, int end) {
        if (start >= end) {
            return;
        }

        int i = start;
        int j = end;
        String pivot = storeGameList.get((start + end) / 2).getName();

        while (i <= j) {
            while (storeGameList.get(i).getName().compareTo(pivot) < 0) {
                i++;
            }

            while (storeGameList.get(j).getName().compareTo(pivot) > 0) {
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

        sortGamesName(start, j);
        sortGamesName(i, end);
    }
}

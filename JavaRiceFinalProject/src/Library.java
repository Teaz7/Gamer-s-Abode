import javax.swing.JOptionPane;
import javax.swing.JTextArea;
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

        message += "NAME" + "\t\t" + "YEAR" + "\t\t" + "OWNED" + "\t\t" + "INSTALLED" + "\t\n\n";

        for (Game game : libraryGameList) {
            message += game.getName() + "\t\t" + game.getYear() + "\t\t" + game.getIsOwned() + "\t\t" + game.getIsInstalled() + "\t\n";
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
                String pivotName = libraryGameList.get((start + end) / 2).getName();
                while (i <= j) {
                    while (libraryGameList.get(i).getName().compareTo(pivotName) < 0) {
                        i++;
                    }
                    while (libraryGameList.get(j).getName().compareTo(pivotName) > 0) {
                        j--;
                    }
                    if (i <= j) {
                        Game temp = libraryGameList.get(i);
                        libraryGameList.set(i, libraryGameList.get(j));
                        libraryGameList.set(j, temp);
                        i++;
                        j--;
                    }
                }
                break;

            case 1:
                double pivotYear = libraryGameList.get((start + end) / 2).getYear();
                while (i <= j) {
                    while (libraryGameList.get(i).getYear() < pivotYear) {
                        i++;
                    }
                    while (libraryGameList.get(j).getYear() > pivotYear) {
                        j--;
                    }
                    if (i <= j) {
                        Game temp = libraryGameList.get(i);
                        libraryGameList.set(i, libraryGameList.get(j));
                        libraryGameList.set(j, temp);
                        i++;
                        j--;
                    }
                }
                break;
        }

        sortGames(start, j, type);
        sortGames(i, end, type);
    }
}

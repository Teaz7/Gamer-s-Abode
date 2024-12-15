import javax.swing.*;
import java.util.LinkedList;

public class Main {
    static String UITitle = "BSIT-2A Java Rice | Gamer's Abode Client";

    /*------------           FUNCTIONS          ------------*/
    public static String drawBorder(int count) {
        String border = "";
        for (int i = 0; i < count; i++) {
            border += "- ";
        }
        border += "\n";
        return border;
    }

    public static void promptEmptyInputs() {
        JOptionPane.showMessageDialog(null, "Please enter the name of the game", UITitle, JOptionPane.INFORMATION_MESSAGE);
    }

    public static void promptErrorMessage(String message) {
        JOptionPane.showMessageDialog(null, message,
                UITitle, JOptionPane.ERROR_MESSAGE);
    }

    /*------------          MAIN           ------------*/
    public static void main(String[] args) {
        String[][] uiOptions = {{"Store", "Library", "Account", "Developer", "Exit"}, //Home
                                {"Purchase Game", "Refund Game", "Display Games", "Sort Games", "Wishlist", "Back"}, //Store
                                {"Install Game", "Uninstall Game", "Display Games", "Sort Games", "Back"}, //Library
                                {"Deposit Funds", "Display Account Details", "Change Account Details", "Back"}, //Customer Account
                                {"Use Developer", "Add Developer", "Remove Developer", "Display Developers", "Back"}, //Developer Account - Choose Developer
                                {"Publish Game", "Remove Game", "Display Details", "Edit Details", "Back"}, //Developer Account - Developer Functions
                                {"Add to Wishlist", "Remove from WIshlist", "Display Wishlist", "Back"}}; // Wishlist

        String[] storeSortOptions = {"Sort Name", "Sort Price", "Sort Developer", "Back"};
        String[] librarySortOptions = {"Sort Name", "Sort Year", "Back"};
        LinkedList<Developer> instancedDeveloperList = new LinkedList<>();
        boolean programRerun = true;
        boolean chosenOptionRerun = true;
        boolean developerOptionRerun = true;
        boolean wishlistOptionRerun = true;
        Store store = new Store();
        Library library = new Library();


        /*---------        INITIALIZED DEVELOPERS       ---------*/
        String[][] initialDevelopers = {{"InnerSloth", "America", "InnerSloth@gmail.com", "Company"},
                                        {"Respawn", "United States", "contact@respawn.com", "Company"},
                                        {"Studio Wildcard", "Canada", "support@studiowildcard.com", "Company"},
                                        {"CAPCOM", "Japan", "info@capcom.com", "Company"},
                                        {"idSoftware", "Japan", "idSoft@software.com", "Company"},
                                        {"FromSoftware Inc.", "South Korea", "info@fromsoftware.jp", "Company"},
                                        {"Type Moon", "France", "contact@typemoon.com", "Company"},
                                        {"Scott Cawthon", "United Kingdom", "scott@fnaf.com", "Individual"},
                                        {"Facepunch Studios", "Australia", "support@facepunch.com", "Company"},
                                        {"RobTop Games", "Norway", "contact@robtopgames.com", "Company"},
                                        {"Rockstar Games", "Germany", "support@rockstargames.com", "Company"},
                                        {"Team Cherry", "Italy", "contact@teamcherry.com.au", "Company"},
                                        {"Valve", "United States", "contact@valvesoftware.com", "Company"},
                                        {"peropero", "Spain", "contact@peropero.com", "Company"},
                                        {"Blizzard Entertainment", "Sweden", "support@blizzard.com", "Company"},
                                        {"PopCap Games", "India", "info@popcap.com", "Company"},
                                        {"Re-Logic", "Brazil", "info@re-logic.com", "Company"}};

        for (int i = 0; i < initialDevelopers.length; i++) {
            Developer developer = new Developer(initialDevelopers[i][0], "", initialDevelopers[i][1], initialDevelopers[i][2], store, library, initialDevelopers[i][3]);
            instancedDeveloperList.add(developer);
        }


        /*---------        INITIALIZED GAMES        --------=*/
        String[][] initialGames = {{"Overwatch 2", "0", "2023", "false", "false", "Blizzard Entertainment"},
                                    {"Fate Grand Order", "0", "2016", "false", "false", "Type Moon"},
                                    {"Ark: Survival Evolved", "500", "2017", "false", "false", "Studio Wildcard"},
                                    {"Hollow Knight", "500", "2017", "false", "false", "Team Cherry"},
                                    {"Monster Hunter World", "1200", "2018", "false", "false", "CAPCOM"},
                                    {"Apex Legends", "0", "2020", "false", "false", "Respawn"},
                                    {"Terraria", "335", "2011", "false", "false", "Re-Logic"},
                                    {"Plants vs Zombies", "170", "2009", "false", "false", "PopCap Games"},
                                    {"Among Us", "100", "2018", "false", "false", "InnerSloth"},
                                    {"Doom Eternal", "1200", "2020", "false", "false", "idSoftware"},
                                    {"Five Nights at Freddy's", "160", "2014", "false", "false", "Scott Cawthon"},
                                    {"Elden Ring", "2400", "2022", "false", "false", "FromSoftware Inc."},
                                    {"Muse Dash", "150", "2019", "false", "false", "peropero"},
                                    {"Garry's Mod", "300", "2006", "false", "false", "Facepunch Studios"},
                                    {"Geometry Dash", "176", "2014", "false", "false", "RobTop Games"},
                                    {"Devil May Cry", "1500", "2019", "false", "false", "CAPCOM"},
                                    {"Left 4 Dead 2", "335", "2009", "false", "false", "Valve"},
                                    {"GTA 5", "1000", "2013", "false", "false", "Rockstar Games"}};

        for (int i = 0; i < initialGames.length; i++) {
            boolean developerFound = false;
            Developer developer = null;
            for (int j = 0; j < instancedDeveloperList.size(); j++) {
                if (instancedDeveloperList.get(j).getFirstName().equals(initialGames[i][5])) {
                    developer = instancedDeveloperList.get(j);
                    developerFound = true;
                    break;
                }
            }

            if (developerFound) {
                Game game = new Game(initialGames[i][0], Double.parseDouble(initialGames[i][1]), Integer.parseInt(initialGames[i][2]), Boolean.parseBoolean(initialGames[i][3]), Boolean.parseBoolean(initialGames[i][3]), developer);
                developer.publishGame(game);
            }
        }


        /*---------        SETUP ACCOUNT        ---------*/
        /*
        JOptionPane.showMessageDialog(null, "Account not detected yet. Enter Name, Country,\nand Email Address to create an Account.",
                UITitle, JOptionPane.WARNING_MESSAGE);
        String accountFirstName, accountLastName, accountCountry, accountEmailAddress;

        while (true) {
            accountFirstName = JOptionPane.showInputDialog(null, "CREATE AN ACCOUNT\n" + drawBorder(20) +
                    "Enter First Name below:", UITitle, JOptionPane.PLAIN_MESSAGE);
            accountLastName = JOptionPane.showInputDialog(null, "CREATE AN ACCOUNT\n" + drawBorder(20) +
                    "Enter Last name below:", UITitle, JOptionPane.PLAIN_MESSAGE);
            accountCountry = JOptionPane.showInputDialog(null, "CREATE AN ACCOUNT\n" + drawBorder(20) +
                    "Enter Country below:", UITitle, JOptionPane.PLAIN_MESSAGE);
            accountEmailAddress = JOptionPane.showInputDialog(null, "CREATE AN ACCOUNT\n" + drawBorder(20) +
                    "Enter Email Address below:", UITitle, JOptionPane.PLAIN_MESSAGE);

            if (accountFirstName.isEmpty() || accountLastName.isEmpty() || accountCountry.isEmpty() || accountEmailAddress.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please don't leave any blanks on the required fields",
                        UITitle, JOptionPane.ERROR_MESSAGE);
            } else {
                break;
            }
        }

        Customer customerAccount = new Customer(accountFirstName, accountLastName, accountCountry, accountEmailAddress, store, library);

         */

        Customer customerAccount = new Customer("accountFirstName", "accountLastName", "accountCountry", "accountEmailAddress", store, library);


        /*---------        PROGRAM START        ---------*/
        while (programRerun) {
            chosenOptionRerun = true;
            int userOption = JOptionPane.showOptionDialog(null, "G A M E R ' S   A B O D E :   H O M E\n" + drawBorder(65) +
                            "Welcome to Gamer's Abode! Navigate through the options to explore the store, \n" +
                            "manage your library, update your account, or access developer tools.\n\n" +
                            "Number of Games in Store: " + store.getStoreGameList().size() + "\nNumber of Games Owned: " + library.getLibraryGameList().size(),
                    UITitle, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, uiOptions[0], uiOptions[0][0]);
            int userOption2;
            Game game;
            boolean gameFound;
            int promptConfirm;

            switch (userOption) {


                /*---------       STORE     ---------*/
                case 0:
                    while (chosenOptionRerun) {
                        userOption2 = JOptionPane.showOptionDialog(null, "G A M E R ' S   A B O D E :   S T O R E\n" + drawBorder(65) +
                                "Welcome to the store! Discover and purchase new games to add to your library.\n\n" +
                                "Number of Games in Store: " + store.getStoreGameList().size(),
                                UITitle, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, uiOptions[1], uiOptions[1][0]);

                        switch (userOption2) {
                            /*------    PURCHASE   ------*/
                            case 0:
                                if (!store.getStoreGameList().isEmpty()) {
                                    game = null;
                                    gameFound = false;
                                    promptConfirm = JOptionPane.showConfirmDialog(null, "Do you want to purchase a game?",
                                            UITitle, JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);

                                    if (promptConfirm == JOptionPane.YES_OPTION) {
                                        while (true) {
                                            String userInput = JOptionPane.showInputDialog(null, "Input Game Name:\n" + "Current amount in wallet: P" +
                                                    customerAccount.getWalletAmount(), UITitle, JOptionPane.PLAIN_MESSAGE);
                                            if (userInput == null) {
                                                promptErrorMessage("Purchasing cancelled.");
                                                break;
                                            } else if (userInput.isEmpty()) {
                                                promptEmptyInputs();
                                            } else {
                                                for (int i = 0; i < store.getStoreGameList().size(); i++) {
                                                    if (store.getStoreGameList().get(i).getName().equalsIgnoreCase(userInput)) {
                                                        gameFound = true;
                                                        game = store.getStoreGameList().get(i);
                                                        break;
                                                    }
                                                }

                                                if (gameFound) {
                                                    String message = "Do you want to purchase " + userInput + "?\n" + "Game price: P" + game.getPrice();
                                                    promptConfirm = JOptionPane.showConfirmDialog(null, message, UITitle, JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);

                                                    if (promptConfirm == JOptionPane.NO_OPTION) {
                                                        promptErrorMessage("Purchasing cancelled.");
                                                    } else if (promptConfirm == JOptionPane.YES_OPTION && customerAccount.getWalletAmount() >= game.getPrice()) {
                                                        if (!game.getIsOwned()) {
                                                            store.purchase(game);
                                                            customerAccount.setWalletAmount(customerAccount.getWalletAmount() - game.getPrice());
                                                            JOptionPane.showMessageDialog(null, "Purchase Successful!\n" + "Current wallet amount: P" +
                                                                    customerAccount.getWalletAmount(), UITitle, JOptionPane.INFORMATION_MESSAGE);

                                                            int repeat = JOptionPane.showConfirmDialog(null, "Do you want to keep adding?\n" +
                                                                    "Current amount in wallet: P" + customerAccount.getWalletAmount(), UITitle, JOptionPane.YES_NO_OPTION);
                                                            if (repeat == JOptionPane.NO_OPTION) {
                                                                break;
                                                            }
                                                        } else {
                                                            JOptionPane.showMessageDialog(null, "Game is already purchased",
                                                                    UITitle, JOptionPane.INFORMATION_MESSAGE);
                                                            break;
                                                        }

                                                    } else {
                                                        JOptionPane.showMessageDialog(null, "Not enough money\n" + "Current wallet amount: P" +
                                                                customerAccount.getWalletAmount(), UITitle, JOptionPane.INFORMATION_MESSAGE);
                                                        break;
                                                    }
                                                } else {
                                                    JOptionPane.showMessageDialog(null, userInput + " not found.",
                                                            UITitle, JOptionPane.INFORMATION_MESSAGE);
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    promptErrorMessage("There is no game available for purchase.\nThe Store is currently empty.");
                                }

                                break;

                            /*------    REFUND   ------*/
                            case 1:
                                if (!library.getLibraryGameList().isEmpty()) {
                                    game = null;
                                    gameFound = false;
                                    promptConfirm = JOptionPane.showConfirmDialog(null, "Do you want to refund a game?",
                                            UITitle, JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);

                                    if (promptConfirm == JOptionPane.YES_OPTION) {
                                        while (true) {
                                            String userInput = JOptionPane.showInputDialog(null, "Input Game Name:",
                                                    UITitle, JOptionPane.PLAIN_MESSAGE);

                                            if (userInput == null) {
                                                promptErrorMessage("Refunding cancelled.");
                                                break;
                                            } else if (userInput.isEmpty()) {
                                                promptEmptyInputs();
                                            } else {
                                                for (int i = 0; i < library.getLibraryGameList().size(); i++) {
                                                    if (library.getLibraryGameList().get(i).getName().equalsIgnoreCase(userInput)) {
                                                        gameFound = true;
                                                        game = library.getLibraryGameList().get(i);
                                                        break;
                                                    }
                                                }

                                                if (gameFound) {
                                                    String message = "Do you want to refund " + userInput + "?";
                                                    promptConfirm = JOptionPane.showConfirmDialog(null, message, UITitle, JOptionPane.INFORMATION_MESSAGE);
                                                    if (promptConfirm == JOptionPane.YES_OPTION) {
                                                        if (game.getIsOwned()) {
                                                            store.refund(game);
                                                            customerAccount.setWalletAmount(customerAccount.getWalletAmount() + game.getPrice());
                                                            JOptionPane.showMessageDialog(null, "Refund Successful!\n" + "Current wallet amount: P" +
                                                                    customerAccount.getWalletAmount(), UITitle, JOptionPane.INFORMATION_MESSAGE);
                                                            break;
                                                        } else {
                                                            JOptionPane.showMessageDialog(null, "You haven't bought this game yet",
                                                                    UITitle, JOptionPane.INFORMATION_MESSAGE);
                                                            break;
                                                        }
                                                    }
                                                } else {
                                                    JOptionPane.showMessageDialog(null, userInput + " not found.",
                                                            UITitle, JOptionPane.INFORMATION_MESSAGE);
                                                }
                                            }
                                        }
                                    }
                                } else {
                                   promptErrorMessage("There is no game available to refund.\nThe Library is currently empty.");
                                }
                                break;

                            /*------    DISPLAY   ------*/
                            case 2:
                                if (store.getStoreGameList().isEmpty()) {
                                    promptErrorMessage("The store is currently empty. There is nothing to display here.");
                                } else {
                                    store.displayGames();
                                }
                                break;

                            /*------    SORT   ------*/
                            case 3:
                                if (store.getStoreGameList().isEmpty()) {
                                    promptErrorMessage("The store is currently empty. There is nothing to sort here.");
                                } else {
                                    int storeSort = JOptionPane.showOptionDialog(null, "Do you want to sort the current list?\n" +
                                                    "You may choose any of the choices " + "below if you want to sort by Name, Price, or Developer.",
                                            UITitle, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, storeSortOptions, storeSortOptions[0]);
                                    if (storeSort != 3) {
                                        store.sortGames(0, store.getStoreGameList().size()-1, storeSort);
                                        switch (storeSort) {
                                            case 0:
                                                JOptionPane.showMessageDialog(null, "Store list has been alphabetically sorted based on the Game's name",
                                                        UITitle, JOptionPane.INFORMATION_MESSAGE);
                                                break;
                                            case 1:
                                                JOptionPane.showMessageDialog(null, "Store list has been arranged in-order based on the Game's price",
                                                        UITitle, JOptionPane.INFORMATION_MESSAGE);
                                                break;
                                            case 2:
                                                JOptionPane.showMessageDialog(null, "Store list has been alphabetically sorted based on the Game's Developer Name",
                                                        UITitle, JOptionPane.INFORMATION_MESSAGE);
                                                break;
                                        }
                                    }
                                }
                                break;

                            /*------    WISHLIST   ------*/
                            case 4:
                                wishlistOptionRerun = true;
                                while (wishlistOptionRerun) {
                                    game = null;
                                    gameFound = false;
                                    int userOptionWishlist = JOptionPane.showOptionDialog(null, "This is the wishlist. " +
                                                    "Here you can add games\nto your wishlist to show what games you are prioritizing.",
                                            UITitle, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, uiOptions[6], uiOptions[6][0]);

                                    switch (userOptionWishlist) {
                                        /*------    ADD TO WISHLIST   ------*/
                                        case 0:
                                            if (store.getStoreGameList().isEmpty()) {
                                                promptErrorMessage("The store is currently empty.\nThere is nothing to add to the wishlist.");
                                            } else {
                                                promptConfirm = JOptionPane.showConfirmDialog(null, "Do you want add a game to your wishlist?",
                                                        UITitle, JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);

                                                if (promptConfirm == JOptionPane.YES_OPTION) {
                                                    while (true) {
                                                        String userInput = JOptionPane.showInputDialog(null, "Input Game Name:",
                                                                UITitle, JOptionPane.PLAIN_MESSAGE);

                                                        if (userInput == null) {
                                                            promptErrorMessage("Cancelled adding a game to wishlist.");
                                                            break;
                                                        } else if (userInput.isEmpty()) {
                                                            promptEmptyInputs();
                                                        } else {
                                                            for (int i = 0; i < store.getStoreGameList().size(); i++) {
                                                                if (store.getStoreGameList().get(i).getName().equalsIgnoreCase(userInput)) {
                                                                    gameFound = true;
                                                                    game = store.getStoreGameList().get(i);
                                                                    break;
                                                                }
                                                            }

                                                            if (gameFound) {
                                                                String message = "Do you want to add " + userInput + " to your wishlist?";
                                                                promptConfirm = JOptionPane.showConfirmDialog(null, message, UITitle, JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
                                                                if (promptConfirm == JOptionPane.YES_OPTION) {
                                                                    if (game.getIsOwned()) {
                                                                        JOptionPane.showMessageDialog(null, "You already own the game",
                                                                                UITitle, JOptionPane.INFORMATION_MESSAGE);
                                                                    } else if(store.getWishList().contains(game)) {
                                                                        JOptionPane.showMessageDialog(null, "Game has already been added to the wishlist",
                                                                                UITitle, JOptionPane.INFORMATION_MESSAGE);
                                                                        break;
                                                                    } else {
                                                                        store.addToWishlist(game);
                                                                        JOptionPane.showMessageDialog(null, game.getName() + " has been succesfully added to the wishlist.",
                                                                                UITitle, JOptionPane.INFORMATION_MESSAGE);
                                                                        break;
                                                                    }
                                                                }
                                                            } else {
                                                                JOptionPane.showMessageDialog(null, userInput + " not found.",
                                                                        UITitle, JOptionPane.INFORMATION_MESSAGE);
                                                                break;
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                            break;

                                        /*------    REMOVE FROM WISHLIST   ------*/
                                        case 1:
                                            if (store.getWishList().isEmpty()) {
                                                promptErrorMessage("The wishlist is currently empty.\nThere is nothing to remove here.");
                                            } else {
                                                promptConfirm = JOptionPane.showConfirmDialog(null, "Do you want remove a game from your wishlist?",
                                                        UITitle, JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);

                                                if (promptConfirm == JOptionPane.YES_OPTION) {
                                                    while (true) {
                                                        String userInput = JOptionPane.showInputDialog(null, "Input Game Name:",
                                                                UITitle, JOptionPane.PLAIN_MESSAGE);

                                                        if (userInput == null) {
                                                            promptErrorMessage("Cancelled removing a game from wishlist.");
                                                            break;
                                                        } else if (userInput.isEmpty()) {
                                                            promptEmptyInputs();
                                                        } else {
                                                            for (int i = 0; i < store.getStoreGameList().size(); i++) {
                                                                if (store.getStoreGameList().get(i).getName().equalsIgnoreCase(userInput)) {
                                                                    gameFound = true;
                                                                    game = store.getStoreGameList().get(i);
                                                                    break;
                                                                }
                                                            }

                                                            if (gameFound) {
                                                                String message = "Do you want to remove " + userInput + " from your wishlist?";
                                                                promptConfirm = JOptionPane.showConfirmDialog(null, message, UITitle, JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
                                                                if (promptConfirm == JOptionPane.YES_OPTION) {
                                                                    if(!store.getWishList().contains(game)) {
                                                                        JOptionPane.showMessageDialog(null, game.getName() + " hasn't been added to your wishlist yet",
                                                                                UITitle, JOptionPane.INFORMATION_MESSAGE);
                                                                        break;
                                                                    } else {
                                                                        store.removeFromWishlist(game);
                                                                        JOptionPane.showMessageDialog(null, game.getName() + " has been succesfully removed from your wishlist.",
                                                                                UITitle, JOptionPane.INFORMATION_MESSAGE);
                                                                        break;
                                                                    }
                                                                }
                                                            } else {
                                                                JOptionPane.showMessageDialog(null, userInput + " not found.",
                                                                        UITitle, JOptionPane.INFORMATION_MESSAGE);
                                                                break;
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                            break;

                                        /*------    DISPLAY WISHLIST   ------*/
                                        case 2:
                                            if (store.getWishList().isEmpty()) {
                                                promptErrorMessage("The wishlist is currently empty. There is nothing to display here.");
                                            } else {
                                                store.displayWishlist();
                                            }
                                            break;

                                        /*------    EXIT WISHLIST   ------*/
                                        case 3:
                                            wishlistOptionRerun = false;
                                            break;
                                    }
                                }
                                break;

                            /*------    EXIT STORE   ------*/
                            case 5:
                                chosenOptionRerun = false;
                                break;
                        }
                    }
                    break;


                /*---------       LIBRARY     ---------*/
                case 1:
                    while (chosenOptionRerun) {
                        userOption2 = JOptionPane.showOptionDialog(null, "G A M E R ' S   A B O D E :   L I B R A R Y\n" + drawBorder(65) +
                                        "Here is your game library. Browse and manage your collection of games.\n\n" +
                                        "Number of Games in Library: " + library.getLibraryGameList().size(),
                                UITitle, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, uiOptions[2], uiOptions[2][0]);
                        switch (userOption2) {
                            /*------    INSTALL   ------*/
                            case 0:
                                if (!store.getStoreGameList().isEmpty()) {
                                    game = null;
                                    gameFound = false;
                                    promptConfirm = JOptionPane.showConfirmDialog(null, "Do you want to install a game?",
                                            UITitle, JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);

                                    if (promptConfirm == JOptionPane.YES_OPTION) {
                                        while (true) {
                                            String userInput = JOptionPane.showInputDialog(null, "Enter name of game to install:",
                                                    UITitle, JOptionPane.PLAIN_MESSAGE);

                                            if (userInput == null) {
                                                promptErrorMessage("Installing cancelled.");
                                                break;
                                            } else if (userInput.isEmpty()) {
                                                promptEmptyInputs();
                                            } else {
                                                for (int i = 0; i < library.getLibraryGameList().size(); i++) {
                                                    if (library.getLibraryGameList().get(i).getName().equalsIgnoreCase(userInput)) {
                                                        gameFound = true;
                                                        game = library.getLibraryGameList().get(i);
                                                        break;
                                                    }
                                                }

                                                if (gameFound) {
                                                    String message = "Do you want to install " + userInput + "?";
                                                    promptConfirm = JOptionPane.showConfirmDialog(null, message, UITitle, JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
                                                    if (promptConfirm == JOptionPane.YES_OPTION) {
                                                        if (game.getIsOwned()) {
                                                            if (!game.getIsInstalled()) {
                                                                library.install(game);
                                                                JOptionPane.showMessageDialog(null, game.getName() + " successfully installed",
                                                                        UITitle, JOptionPane.INFORMATION_MESSAGE);
                                                                break;
                                                            } else {
                                                                JOptionPane.showMessageDialog(null, game.getName() + " has already been installed",
                                                                        UITitle, JOptionPane.INFORMATION_MESSAGE);
                                                                break;
                                                            }
                                                        } else {
                                                            JOptionPane.showMessageDialog(null, "Game is not yet owned",
                                                                    UITitle, JOptionPane.INFORMATION_MESSAGE);
                                                            break;
                                                        }
                                                    }
                                                } else {
                                                    JOptionPane.showMessageDialog(null, userInput + " not found.",
                                                            UITitle, JOptionPane.INFORMATION_MESSAGE);
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    promptErrorMessage("There is no game available for installing.\nThe store is currently empty.");
                                }

                                break;

                            /*------    UNINSTALL   ------*/
                            case 1:
                                if (!library.getLibraryGameList().isEmpty()) {
                                    game = null;
                                    gameFound = false;
                                    promptConfirm = JOptionPane.showConfirmDialog(null, "Do you want to uninstall a game?",
                                            UITitle, JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);

                                    if (promptConfirm == JOptionPane.YES_OPTION) {
                                        while (true) {
                                            String userInput = JOptionPane.showInputDialog(null, "Enter name of game to uninstall:",
                                                    UITitle, JOptionPane.PLAIN_MESSAGE);
                                            if (userInput == null) {
                                                promptErrorMessage("Uninstalling cancelled.");
                                                break;
                                            } else if (userInput.isEmpty()) {
                                                promptEmptyInputs();
                                            } else {
                                                for (int i = 0; i < library.getLibraryGameList().size(); i++) {
                                                    if (library.getLibraryGameList().get(i).getName().equalsIgnoreCase(userInput)) {
                                                        gameFound = true;
                                                        game = library.getLibraryGameList().get(i);
                                                        break;
                                                    }
                                                }

                                                if (gameFound) {
                                                    String message = "Do you want to uninstall " + userInput + "?";
                                                    promptConfirm = JOptionPane.showConfirmDialog(null, message, UITitle, JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
                                                    if (promptConfirm == JOptionPane.YES_OPTION) {
                                                        if (game.getIsOwned()) {
                                                            if (game.getIsInstalled()) {
                                                                library.uninstall(game);
                                                                JOptionPane.showMessageDialog(null, game.getName() + " successfully uninstalled",
                                                                        UITitle, JOptionPane.INFORMATION_MESSAGE);
                                                                break;
                                                            } else {
                                                                JOptionPane.showMessageDialog(null, game.getName() + " is not installed",
                                                                        UITitle, JOptionPane.INFORMATION_MESSAGE);
                                                                break;
                                                            }
                                                        } else {
                                                            JOptionPane.showMessageDialog(null, "Game is not yet owned",
                                                                    UITitle, JOptionPane.INFORMATION_MESSAGE);
                                                            break;
                                                        }
                                                    }
                                                } else {
                                                    JOptionPane.showMessageDialog(null, userInput + " not found.",
                                                            UITitle, JOptionPane.INFORMATION_MESSAGE);
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    promptErrorMessage("There is no game available for uninstalling.\nThe library is currently empty.");
                                }

                                break;

                            /*------    DISPLAY   ------*/
                            case 2:
                                if (library.getLibraryGameList().isEmpty()) {
                                    promptErrorMessage("The library is currently empty. There is nothing to display here.");
                                } else {
                                    library.displayGames();
                                }
                                break;

                            /*------    SORT   ------*/
                            case 3:
                                if (library.getLibraryGameList().isEmpty()) {
                                    promptErrorMessage("The library is currently empty. There is nothing to sort here.");
                                } else {
                                    int librarySort = JOptionPane.showOptionDialog(null, "Do you want to sort your library?\n" +
                                                    "You may choose any of the choices " + "below if you want to sort by Name or Year released.",
                                            UITitle, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, librarySortOptions, librarySortOptions[0]);
                                    library.sortGames(0, library.getLibraryGameList().size() - 1, librarySort);
                                    if (librarySort != 2) {
                                        switch (librarySort) {
                                            case 0:
                                                JOptionPane.showMessageDialog(null, "Library has been alphabetically sorted based on the Game's name",
                                                        UITitle, JOptionPane.INFORMATION_MESSAGE);
                                                break;
                                            case 1:
                                                JOptionPane.showMessageDialog(null, "Library has been arranged in-order based on the Game's year release",
                                                        UITitle, JOptionPane.INFORMATION_MESSAGE);
                                                break;
                                        }
                                    }
                                }

                                break;

                            /*------    EXIT LIBRARY   ------*/
                            case 4:
                                chosenOptionRerun = false;
                                break;
                        }
                    }
                    break;


                /*---------       ACCOUNT     ---------*/
                case 2:
                    while (chosenOptionRerun) {
                        userOption2 = JOptionPane.showOptionDialog(null, "G A M E R ' S   A B O D E :   A C C O U N T\n" + drawBorder(65) +
                                        "Here is you Account. Deposit funds into your wallet and purchase games from the store.\n\n" +
                                        "Current Amount in Wallet: P" + customerAccount.getWalletAmount(),
                                UITitle, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, uiOptions[3], uiOptions[3][0]);
                        switch (userOption2) {
                            /*------    DEPOSIT TO WALLET   ------*/
                            case 0:
                                while (true) {
                                    String amountInput = JOptionPane.showInputDialog(null, "Input number to add to wallet:\n" +
                                            "Current amount in wallet: P" + customerAccount.getWalletAmount(), UITitle, JOptionPane.PLAIN_MESSAGE);
                                    if (amountInput == null) {
                                        promptErrorMessage("Cancelled depositing money into wallet");
                                        break;
                                    } else {
                                        try {
                                            double amount = Double.parseDouble(amountInput);
                                            if (amount == 0) {
                                                JOptionPane.showMessageDialog(null, "Input a number besides 0 to add to your wallet.",
                                                        UITitle, JOptionPane.ERROR_MESSAGE);
                                            } else if (amount < 0 || amountInput.isEmpty()) {
                                                JOptionPane.showMessageDialog(null, "Invalid number. Please input a proper number.",
                                                        UITitle, JOptionPane.ERROR_MESSAGE);
                                            } else {
                                                int confirmDeposit = JOptionPane.showConfirmDialog(null, "Do you want to deposit P" +
                                                        amount + " into your wallet?", UITitle, JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
                                                if (confirmDeposit == JOptionPane.YES_OPTION) {
                                                    customerAccount.depositFunds(amount);
                                                    JOptionPane.showMessageDialog(null, "Amount deposited successfully\n" +
                                                            "Current amount in wallet: P" + amount, UITitle, JOptionPane.INFORMATION_MESSAGE);
                                                }
                                                break;
                                            }
                                        } catch (NumberFormatException e) {
                                            JOptionPane.showMessageDialog(null, "Invalid number. Please input again",
                                                    UITitle, JOptionPane.ERROR_MESSAGE);
                                        }
                                    }
                                }
                                break;

                            /*------    DISPLAY   ------*/
                            case 1:
                                customerAccount.displayAccountDetails();
                                break;

                            /*------    EDIT ACCOUNT   ------*/
                            case 2:
                                customerAccount.changeAccountDetails();
                                break;

                            /*------    EXIT   ------*/
                            case 3:
                                chosenOptionRerun = false;
                                break;
                        }
                    }
                    break;


                /*---------       CHOOSE DEVELOPER       ---------*/
                case 3:
                    while (chosenOptionRerun) {
                        developerOptionRerun = true;
                        userOption2 = JOptionPane.showOptionDialog(null, "G A M E R ' S   A B O D E :   D E V E L O P E R\n" + drawBorder(65) +
                                        "Access developer tools and resources here. Manage developed game projects and updates.\n\n",
                                UITitle, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, uiOptions[4], uiOptions[4][0]);
                        switch (userOption2) {
                            /*---       DEVELOPER       ---*/
                            case 0:
                                if (instancedDeveloperList.isEmpty()) {
                                    promptErrorMessage("Unable to use this function.\nCurrently there are no developers that have been created.");
                                } else {
                                    boolean found = false;
                                    Developer foundDeveloper = null;
                                    int userDeveloperOption;

                                    while (true) {
                                        String inputtedDeveloper = JOptionPane.showInputDialog(null, "Input Developer Name:",
                                                UITitle, JOptionPane.PLAIN_MESSAGE);

                                        if (inputtedDeveloper == null) {
                                            promptErrorMessage("Cancelled using developer tool");
                                            break;
                                        } else {
                                            for (Developer developer : instancedDeveloperList) {
                                                if (developer.getFirstName().equalsIgnoreCase(inputtedDeveloper)) {
                                                    found = true;
                                                    foundDeveloper = developer;
                                                    break;
                                                }
                                            }

                                            if (found) {
                                                while (developerOptionRerun) {
                                                    userDeveloperOption = JOptionPane.showOptionDialog(null, "You choose among the options whether to add or remove a game.",
                                                            UITitle, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, uiOptions[5], uiOptions[5][0]);

                                                    switch (userDeveloperOption) {
                                                        case 0:
                                                            String gameName, gamePrice, gameYear;
                                                            boolean nullPublish = false, publishFound = false;
                                                            while (true) {
                                                                gameName = JOptionPane.showInputDialog(null, "Enter the name of the game to publish: ",
                                                                        UITitle, JOptionPane.PLAIN_MESSAGE);
                                                                gamePrice = JOptionPane.showInputDialog(null, "Enter the price of the game to publish: ",
                                                                        UITitle, JOptionPane.PLAIN_MESSAGE);
                                                                gameYear = JOptionPane.showInputDialog(null, "Enter the game's year of release to publish: ",
                                                                        UITitle, JOptionPane.PLAIN_MESSAGE);

                                                                if (gameName != null && gamePrice != null && gameYear != null) {
                                                                    for (Game gamePublished : store.getStoreGameList()) {
                                                                        if (gamePublished.getName().equalsIgnoreCase(gameName)) {
                                                                            publishFound = true;
                                                                        }
                                                                    }
                                                                }

                                                                if (gameName == null || gamePrice == null || gameYear == null) {
                                                                    nullPublish = true;
                                                                    break;
                                                                } else if(publishFound) {
                                                                    promptErrorMessage("The name " + gameName + " already exists. Please add another game");
                                                                } else if (gameName.isEmpty() || gamePrice.isEmpty() || gameYear.isEmpty()) {
                                                                    JOptionPane.showMessageDialog(null, "Please don't leave any blanks on the required fields",
                                                                            UITitle, JOptionPane.ERROR_MESSAGE);
                                                                } else {
                                                                    break;
                                                                }
                                                            }

                                                            if (nullPublish) {
                                                                promptErrorMessage("Cancelled publishing a game.");
                                                            } else {
                                                                Game devGame = new Game(gameName, Double.parseDouble(gamePrice), Integer.parseInt(gameYear), false, false, foundDeveloper);

                                                                foundDeveloper.publishGame(devGame);
                                                                JOptionPane.showMessageDialog(null, devGame.getName() + " has successfully been published to the store",
                                                                        UITitle, JOptionPane.INFORMATION_MESSAGE);
                                                            }
                                                            break;

                                                        case 1:
                                                            String devGameRemove;
                                                            boolean nullRemove = false;
                                                            if (foundDeveloper.getDeveloperGameList().isEmpty()) {
                                                                promptErrorMessage("The developer hasn't published a game yet.\nThere is nothing to remove here.");
                                                            } else {
                                                                while (true) {
                                                                    devGameRemove = JOptionPane.showInputDialog(null, "Enter name of game to remove:",
                                                                            UITitle, JOptionPane.PLAIN_MESSAGE);

                                                                    if (devGameRemove == null) {
                                                                        nullRemove = true;
                                                                        break;
                                                                    } else if (devGameRemove.isEmpty()) {
                                                                        JOptionPane.showMessageDialog(null, "Please don't leave any blanks on the required fields",
                                                                                UITitle, JOptionPane.ERROR_MESSAGE);
                                                                    } else {
                                                                        break;
                                                                    }
                                                                }

                                                                if (nullRemove) {
                                                                    promptErrorMessage("Cancelled removing a game.");
                                                                } else {
                                                                    Game gameToRemove = null;

                                                                    for (Game g: foundDeveloper.getDeveloperGameList()) {
                                                                        if (g.getName().equalsIgnoreCase(devGameRemove)) {
                                                                            gameToRemove = g;
                                                                            break;
                                                                        }
                                                                    }

                                                                    int confirmRemove = JOptionPane.showConfirmDialog(null, "Are you sure you want to remove " +
                                                                            gameToRemove.getName() + "?", UITitle, JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
                                                                    if (confirmRemove == JOptionPane.YES_OPTION) {
                                                                        JOptionPane.showMessageDialog(null, "Successfully removed " + gameToRemove.getName(),
                                                                                UITitle, JOptionPane.INFORMATION_MESSAGE);
                                                                        foundDeveloper.removeGame(gameToRemove);
                                                                    } else {
                                                                        promptErrorMessage("Cancelled removing " + gameToRemove.getName());
                                                                    }
                                                                }
                                                            }

                                                            break;

                                                        case 2:
                                                            foundDeveloper.displayAccountDetails();
                                                            break;

                                                        case 3:
                                                            foundDeveloper.changeAccountDetails();
                                                            break;

                                                        case 4:
                                                            developerOptionRerun = false;
                                                            break;
                                                    }
                                                }
                                                break;
                                            } else {
                                                JOptionPane.showMessageDialog(null, "Developer not found",
                                                        UITitle, JOptionPane.PLAIN_MESSAGE);
                                            }
                                        }

                                    }
                                }

                                break;

                            /*------    ADD DEVELOPER   ------*/
                            case 1:
                                String[] devTypeChoices = {"Independent", "Company"};
                                JOptionPane.showMessageDialog(null, "To add a developer, you need to fill up the following fields:\n" +
                                                "Developer Name, Developer Email, Developer Country, and Developer Type",
                                        UITitle, JOptionPane.PLAIN_MESSAGE);
                                String devNameAdd, devEmail, devCountry;
                                boolean nullAdd = false, devFound = false;
                                while (true) {
                                    devNameAdd = JOptionPane.showInputDialog(null, "Enter Developer Name: ", UITitle, JOptionPane.PLAIN_MESSAGE);
                                    devEmail = JOptionPane.showInputDialog(null, "Enter Developer Email Address: ", UITitle, JOptionPane.PLAIN_MESSAGE);
                                    devCountry = JOptionPane.showInputDialog(null, "Enter Developer Country: ", UITitle, JOptionPane.PLAIN_MESSAGE);

                                    if (devNameAdd != null && devEmail != null && devCountry != null) {
                                        for (Developer developer : instancedDeveloperList) {
                                            if (devNameAdd.equalsIgnoreCase(developer.getFirstName())) {
                                                devFound = true;
                                                break;
                                            }
                                        }
                                    }

                                    if (devNameAdd == null || devEmail == null || devCountry == null) {
                                        nullAdd = true;
                                        break;
                                    } else if (devNameAdd.isEmpty() || devEmail.isEmpty() || devCountry.isEmpty()) {
                                        JOptionPane.showMessageDialog(null, "Please don't leave any blanks on the required fields",
                                                UITitle, JOptionPane.ERROR_MESSAGE);
                                    } else if(devFound) {
                                        promptErrorMessage("The name " + devNameAdd + " already exists. Please add another name.");
                                    } else {
                                        break;
                                    }
                                }

                                if (nullAdd) {
                                    promptErrorMessage("Cancelled adding a developer.");
                                } else {
                                    String devType = "";
                                    int devTypeOption = JOptionPane.showOptionDialog(null, "Choose Developer Type:",
                                            UITitle, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, devTypeChoices, devTypeChoices[0]);
                                    switch (devTypeOption) {
                                        case 0:
                                            devType = "Independent";
                                            break;
                                        case 1:
                                            devType = "Company";
                                            break;
                                    }

                                    Developer developer = new Developer(devNameAdd, "", devCountry, devEmail, store, library, devType);
                                    instancedDeveloperList.add(developer);
                                    JOptionPane.showMessageDialog(null, "Succesfully created account", UITitle, JOptionPane.PLAIN_MESSAGE);
                                }

                                break;

                            /*------    REMOVE DEVELOPER   ------*/
                            case 2:
                                boolean nullRemove = false;
                                if (instancedDeveloperList.isEmpty()) {
                                    promptErrorMessage("The list is currently empty.\nThere is nothing to remove here.");
                                } else {
                                    String devNameRemove;
                                    while (true) {
                                        devNameRemove = JOptionPane.showInputDialog(null, "input developer name to remove", UITitle, JOptionPane.PLAIN_MESSAGE);
                                        if (devNameRemove == null) {
                                            nullRemove = true;
                                            break;
                                        } else if (devNameRemove.isEmpty()) {
                                            JOptionPane.showMessageDialog(null, "Please input a developer's name", UITitle, JOptionPane.ERROR_MESSAGE);
                                        } else {
                                            break;
                                        }
                                    }
                                    if (nullRemove) {
                                        promptErrorMessage("Cancelled removing a developer.");
                                    } else {
                                        boolean devNameFound = false;
                                        Developer developerToRemove = null;
                                        for (int i = 1; i < instancedDeveloperList.size(); i++) {
                                            if (instancedDeveloperList.get(i).getFirstName().equals(devNameRemove)) {
                                                developerToRemove = instancedDeveloperList.get(i);
                                                devNameFound = true;
                                                break;
                                            }
                                        }

                                        if (devNameFound) {
                                            int confirmRemoveDev = JOptionPane.showConfirmDialog(null, "Do you want to remove " + developerToRemove.getFirstName() +"?",
                                                    UITitle, JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
                                            if (confirmRemoveDev == JOptionPane.YES_OPTION) {
                                                for (Game g: developerToRemove.getDeveloperGameList()) {
                                                    developerToRemove.removeGame(g);
                                                }
                                                instancedDeveloperList.remove(developerToRemove);
                                                JOptionPane.showMessageDialog(null, "developer removed", UITitle, JOptionPane.PLAIN_MESSAGE);
                                            }
                                        } else {
                                            JOptionPane.showMessageDialog(null, "developer not found", UITitle, JOptionPane.PLAIN_MESSAGE);
                                        }
                                    }
                                }

                                break;

                            /*------    DISPLAY DEVELOPER   ------*/
                            case 3:
                                if (instancedDeveloperList.isEmpty()) {
                                    promptErrorMessage("The list is currently empty.\nThere is nothing to remove here.");
                                } else {
                                    String devMessage = "";
                                    devMessage += "NAME\t\t\t" + "COUNTRY\t\t" + "CATEGORY\t" + "NO. OF GAMES\n";
                                    for (Developer dev : instancedDeveloperList) {
                                        devMessage += dev.getFirstName() + "\t\t";
                                        if (dev.getFirstName().length() < 17) {
                                            devMessage += "\t";
                                        }

                                        devMessage += dev.getCountry() + "\t\t" + dev.getCategory() + "\t" + dev.getDeveloperGameList().size() + "\t\n";
                                    }
                                    JOptionPane.showMessageDialog(null, new JTextArea(devMessage), UITitle, JOptionPane.PLAIN_MESSAGE);
                                }
                                break;

                            /*------    EXIT DEVELOPERS   ------*/
                            case 4:
                                chosenOptionRerun = false;
                                break;
                        }
                    }
                    break;


                /*---------       EXIT        ---------*/
                case 4:
                    JOptionPane.showMessageDialog(null, "G A M E R ' S   A B O D E :   E X I T\n" + drawBorder(60) +
                            "Thank you for using our system, Gamer's Abode! - JavaRice, BSIT 2-A <3");
                    programRerun = false;
                    break;
            }
        }
    }
}
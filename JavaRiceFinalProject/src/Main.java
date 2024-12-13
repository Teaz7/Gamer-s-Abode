import javax.swing.JOptionPane;
import java.util.LinkedList;

public class Main {
    static String UITitle = "BSIT-2A Java Rice | Gamer's Abode Client";

    /*---       FUNCTIONS       ---*/
    public static String drawBorder(int count) {
        String border = "";
        for (int i = 0; i < count; i++) {
            border += "- ";
        }
        border += "\n";
        return border;
    }

    /*---       MAIN       ---*/
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

        /*---       INITIALIZED DEVELOPERS      ---*/
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

        /*---       INITIALIZED GAMES       --=*/
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

        /*---       SETUP ACCOUNT       ---*/
        JOptionPane.showMessageDialog(null, "Account not detected yet. Enter Name, Country,\nand Email Address to create an Account.",
                UITitle, JOptionPane.WARNING_MESSAGE);

        String accountFirstName = JOptionPane.showInputDialog(null, "CREATE AN ACCOUNT\n" + drawBorder(20) +
                        "Enter First Name below:", UITitle, JOptionPane.PLAIN_MESSAGE);
        String accountLastName = JOptionPane.showInputDialog(null, "CREATE AN ACCOUNT\n" + drawBorder(20) +
                        "Enter Last name below:",
                    UITitle, JOptionPane.PLAIN_MESSAGE);
        String accountCountry = JOptionPane.showInputDialog(null, "CREATE AN ACCOUNT\n" + drawBorder(20) +
                        "Enter Country below:",
                    UITitle, JOptionPane.PLAIN_MESSAGE);
        String accountEmailAddress = JOptionPane.showInputDialog(null, "CREATE AN ACCOUNT\n" + drawBorder(20) +
                        "Enter Email Address below:",
                    UITitle, JOptionPane.PLAIN_MESSAGE);

        Customer customerAccount = new Customer(accountFirstName, accountLastName, accountCountry, accountEmailAddress, store, library);

        /*---       PROGRAM START       ---*/
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
                /*---       STORE     ---*/
                case 0:
                    while (chosenOptionRerun) {
                        userOption2 = JOptionPane.showOptionDialog(null, "G A M E R ' S   A B O D E :   S T O R E\n" + drawBorder(65) +
                                "Welcome to the store! Discover and purchase new games to add to your library.\n\n" +
                                "Number of Games in Store: " + store.getStoreGameList().size(),
                                UITitle, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, uiOptions[1], uiOptions[1][0]);

                        switch (userOption2) {
                            case 0:
                                game = null;
                                gameFound = false;
                                promptConfirm = JOptionPane.showConfirmDialog(null, "Do you want to purchase a game?",
                                        UITitle, JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);

                                if (promptConfirm == JOptionPane.YES_OPTION) {
                                    String userInput = JOptionPane.showInputDialog(null, "Input Game Name:\n" + "Current amount in wallet: P" +
                                                    customerAccount.getWalletAmount(), UITitle, JOptionPane.PLAIN_MESSAGE);
                                    if (userInput == null) {
                                        JOptionPane.showMessageDialog(null, "Purchasing cancelled,",
                                                UITitle, JOptionPane.ERROR_MESSAGE);
                                    } else if (userInput == "") {
                                        JOptionPane.showMessageDialog(null, "Input the name of the game",
                                                UITitle, JOptionPane.PLAIN_MESSAGE);
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
                                                JOptionPane.showMessageDialog(null, "Purchasing cancelled,",
                                                        UITitle, JOptionPane.ERROR_MESSAGE);
                                            } else if (promptConfirm == JOptionPane.YES_OPTION && customerAccount.getWalletAmount() >= game.getPrice()) {
                                                if (!game.getIsOwned()) {
                                                    store.purchase(game);
                                                    customerAccount.setWalletAmount(customerAccount.getWalletAmount() - game.getPrice());
                                                    JOptionPane.showMessageDialog(null, "Purchase Successful!\n" + "Current wallet amount: P" +
                                                            customerAccount.getWalletAmount(), UITitle, JOptionPane.INFORMATION_MESSAGE);
                                                } else {
                                                    JOptionPane.showMessageDialog(null, "Game is already purchased",
                                                            UITitle, JOptionPane.INFORMATION_MESSAGE);
                                                }

                                            } else {
                                                JOptionPane.showMessageDialog(null, "Not enough money\n" + "Current wallet amount: P" +
                                                        customerAccount.getWalletAmount(), UITitle, JOptionPane.INFORMATION_MESSAGE);
                                            }
                                        } else {
                                            JOptionPane.showMessageDialog(null, userInput + " not found.",
                                                    UITitle, JOptionPane.INFORMATION_MESSAGE);
                                        }
                                    }
                                }

                                break;
                            case 1:
                                game = null;
                                gameFound = false;
                                promptConfirm = JOptionPane.showConfirmDialog(null, "Do you want to refund a game?",
                                        UITitle, JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);

                                if (promptConfirm == JOptionPane.YES_OPTION) {
                                    String userInput = JOptionPane.showInputDialog(null, "Input Game Name:",
                                            UITitle, JOptionPane.PLAIN_MESSAGE);

                                    if (userInput == null) {
                                        JOptionPane.showMessageDialog(null, "Refunding cancelled,",
                                                UITitle, JOptionPane.PLAIN_MESSAGE);
                                    } else if (userInput == "") {
                                        JOptionPane.showMessageDialog(null, "Input the name of the game",
                                                UITitle, JOptionPane.PLAIN_MESSAGE);
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
                                            if (promptConfirm == JOptionPane.YES_NO_OPTION) {
                                                if (game.getIsOwned()) {
                                                    store.refund(game);
                                                    customerAccount.setWalletAmount(customerAccount.getWalletAmount() + game.getPrice());
                                                    JOptionPane.showMessageDialog(null, "Refund Successful!\n" + "Current wallet amount: P" +
                                                            customerAccount.getWalletAmount(), UITitle, JOptionPane.INFORMATION_MESSAGE);
                                                } else {
                                                    JOptionPane.showMessageDialog(null, "You haven't bought this game yet",
                                                            UITitle, JOptionPane.INFORMATION_MESSAGE);
                                                }
                                            }
                                        } else {
                                            JOptionPane.showMessageDialog(null, userInput + " not found.",
                                                    UITitle, JOptionPane.INFORMATION_MESSAGE);
                                        }
                                    }
                                }

                                break;
                            case 2:
                                store.displayGames();
                                break;
                            case 3:
                                int storeSort = JOptionPane.showOptionDialog(null, "Do you want to sort the current list?\n" +
                                                "You may choose any of the choices " + "below if you want to sort by Name, Price, or Developer.",
                                        UITitle, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, storeSortOptions, storeSortOptions[0]);
                                if (storeSort != 3) {
                                    store.sortGames(0, store.getStoreGameList().size()-1, storeSort);
                                }
                                break;
                            case 4:
                                wishlistOptionRerun = true;
                                while (wishlistOptionRerun) {
                                    int userOptionWishlist = JOptionPane.showOptionDialog(null, "This is the wishlist. " +
                                                    "Here you can add games\nto your wishlist to show what games you are prioritizing.",
                                            UITitle, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, uiOptions[6], uiOptions[6][0]);

                                    switch (userOptionWishlist) {
                                        case 0:
                                            break;
                                        case 1:
                                            break;
                                        case 2:
                                            break;
                                        case 3:
                                            wishlistOptionRerun = false;
                                            break;
                                    }
                                }
                                break;
                            case 5:
                                chosenOptionRerun = false;
                                break;
                        }
                    }

                    break;


                /*---       LIBRARY     ---*/
                case 1:
                    while (chosenOptionRerun) {
                        userOption2 = JOptionPane.showOptionDialog(null, "G A M E R ' S   A B O D E :   L I B R A R Y\n" + drawBorder(65) +
                                        "Here is your game library. Browse and manage your collection of games.\n\n" +
                                        "Number of Games in Library: " + library.getLibraryGameList().size(),
                                UITitle, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, uiOptions[2], uiOptions[2][0]);
                        switch (userOption2) {
                            case 0:
                                game = null;
                                gameFound = false;
                                promptConfirm = JOptionPane.showConfirmDialog(null, "Do you want to install a game?",
                                        UITitle, JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);

                                if (promptConfirm == JOptionPane.YES_OPTION) {
                                    String userInput = JOptionPane.showInputDialog(null, "Enter name of game to install:",
                                            UITitle, JOptionPane.PLAIN_MESSAGE);

                                    for (int i = 0; i < library.getLibraryGameList().size(); i++) {
                                        if (library.getLibraryGameList().get(i).getName().equalsIgnoreCase(userInput)) {
                                            gameFound = true;
                                            game = library.getLibraryGameList().get(i);
                                            break;
                                        }
                                    }

                                    if (gameFound) {
                                        String message = "Do you want to install " + userInput + "?";
                                        promptConfirm = JOptionPane.showConfirmDialog(null, message, UITitle, JOptionPane.INFORMATION_MESSAGE);
                                        if (promptConfirm == JOptionPane.YES_OPTION) {
                                            if (game.getIsOwned()) {
                                                if (!game.getIsInstalled()) {
                                                    library.install(game);
                                                    JOptionPane.showMessageDialog(null, game.getName() + " successfully installed",
                                                            UITitle, JOptionPane.INFORMATION_MESSAGE);
                                                } else {
                                                    JOptionPane.showMessageDialog(null, game.getName() + " has already been installed",
                                                            UITitle, JOptionPane.INFORMATION_MESSAGE);
                                                }
                                            } else {
                                                JOptionPane.showMessageDialog(null, "Game is not yet owned",
                                                        UITitle, JOptionPane.INFORMATION_MESSAGE);
                                            }
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog(null, userInput + " not found.",
                                                UITitle, JOptionPane.INFORMATION_MESSAGE);
                                    }
                                }

                                break;
                            case 1:
                                game = null;
                                gameFound = false;
                                promptConfirm = JOptionPane.showConfirmDialog(null, "Do you want to uninstall a game?",
                                        UITitle, JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);

                                if (promptConfirm == JOptionPane.YES_OPTION) {
                                    String userInput = JOptionPane.showInputDialog(null, "Enter name of game to uninstall:",
                                            UITitle, JOptionPane.PLAIN_MESSAGE);

                                    for (int i = 0; i < library.getLibraryGameList().size(); i++) {
                                        if (library.getLibraryGameList().get(i).getName().equalsIgnoreCase(userInput)) {
                                            gameFound = true;
                                            game = library.getLibraryGameList().get(i);
                                            break;
                                        }
                                    }

                                    if (gameFound) {
                                        String message = "Do you want to uninstall " + userInput + "?";
                                        promptConfirm = JOptionPane.showConfirmDialog(null, message, UITitle, JOptionPane.INFORMATION_MESSAGE);
                                        if (promptConfirm == JOptionPane.YES_OPTION) {
                                            if (game.getIsOwned()) {
                                                if (game.getIsInstalled()) {
                                                    library.install(game);
                                                    JOptionPane.showMessageDialog(null, game.getName() + " successfully uninstalled",
                                                            UITitle, JOptionPane.INFORMATION_MESSAGE);
                                                } else {
                                                    JOptionPane.showMessageDialog(null, game.getName() + " is not installed",
                                                            UITitle, JOptionPane.INFORMATION_MESSAGE);
                                                }
                                            } else {
                                                JOptionPane.showMessageDialog(null, "Game is not yet owned",
                                                        UITitle, JOptionPane.INFORMATION_MESSAGE);
                                            }
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog(null, userInput + " not found.",
                                                UITitle, JOptionPane.INFORMATION_MESSAGE);
                                    }
                                }

                                break;
                            case 2:
                                library.displayGames();
                                break;
                            case 3:
                                int storeSort = JOptionPane.showOptionDialog(null, "message",
                                        UITitle, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, librarySortOptions, librarySortOptions[0]);
                                library.sortGames(0, library.getLibraryGameList().size() - 1, storeSort); //to fix
                                break;
                            case 4:
                                chosenOptionRerun = false;
                                break;
                        }
                    }

                    break;


                /*---       ACCOUNT     ---*/
                case 2:
                    while (chosenOptionRerun) {
                        userOption2 = JOptionPane.showOptionDialog(null, "G A M E R ' S   A B O D E :   A C C O U N T\n" + drawBorder(65) +
                                        "Here is you Account. Deposit funds into your wallet and purchase games from the store.\n\n" +
                                        "Current Amount in Wallet: " + customerAccount.getWalletAmount(),
                                UITitle, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, uiOptions[3], uiOptions[3][0]);
                        switch (userOption2) {
                            case 0:
                                String amountInput = JOptionPane.showInputDialog(null, "Input number to add to wallet: " +
                                        "Current amount in waller: P" + customerAccount.getWalletAmount(), UITitle, JOptionPane.PLAIN_MESSAGE);
                                customerAccount.depositFunds(Double.parseDouble(amountInput));
                                break;
                            case 1:
                                customerAccount.displayAccountDetails();
                                break;
                            case 2:
                                customerAccount.changeAccountDetails();
                                break;
                            case 3:
                                chosenOptionRerun = false;
                                break;
                        }
                    }

                    break;


                /*---       CHOOSE DEVELOPER       ---*/
                case 3:
                    while (chosenOptionRerun) {
                        developerOptionRerun = true;
                        userOption2 = JOptionPane.showOptionDialog(null, "G A M E R ' S   A B O D E :   D E V E L O P E R\n" + drawBorder(65) +
                                        "Access developer tools and resources here. Manage developed game projects and updates.\n\n" +
                                        "Enter name of developer to use: ",
                                UITitle, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, uiOptions[4], uiOptions[4][0]);
                        switch (userOption2) {
                            /*---       DEVELOPER       ---*/
                            case 0:
                                boolean found = false;
                                Developer foundDeveloper = null;
                                int userDeveloperOption;

                                for (int i = 0; i < instancedDeveloperList.size(); i++) {
                                    Developer developer = instancedDeveloperList.get(i);
                                    if (developer.getFirstName().equals(userOption2)) {
                                        found = true;
                                        foundDeveloper = developer;
                                    }
                                }

                                if (found) {
                                    while (developerOptionRerun) {
                                        userDeveloperOption = JOptionPane.showOptionDialog(null, "message",
                                                UITitle, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, uiOptions[5], uiOptions[5][0]);

                                        switch (userDeveloperOption) {
                                            case 0:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                        }
                                    }
                                }
                                break;
                            case 1:
                                String[] devTypeChoices = {"Independent", "Company"};
                                JOptionPane.showMessageDialog(null, "to add a dev, u need: name, email, country, and type.",
                                        UITitle, JOptionPane.PLAIN_MESSAGE);
                                String devNameAdd = JOptionPane.showInputDialog(null, "Enter dev name: ", UITitle, JOptionPane.PLAIN_MESSAGE);
                                String devEmail = JOptionPane.showInputDialog(null, "Enter email: ", UITitle, JOptionPane.PLAIN_MESSAGE);
                                String devCountry = JOptionPane.showInputDialog(null, "Enter country: ", UITitle, JOptionPane.PLAIN_MESSAGE);
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
                                JOptionPane.showMessageDialog(null, "succesfully created account", UITitle, JOptionPane.PLAIN_MESSAGE);
                                break;
                            case 2:
                                String devNameRemove = JOptionPane.showInputDialog(null, "input developer name to remove", UITitle, JOptionPane.PLAIN_MESSAGE);
                                boolean devNameFound = false;
                                for (int i = 1; i < instancedDeveloperList.size(); i++) {
                                    if (instancedDeveloperList.get(i).getFirstName().equals(devNameRemove)) {
                                        instancedDeveloperList.remove(i);
                                        devNameFound = true;
                                    }
                                }

                                if (devNameFound) {
                                    JOptionPane.showMessageDialog(null, "developer removed", UITitle, JOptionPane.PLAIN_MESSAGE);
                                } else {
                                    JOptionPane.showMessageDialog(null, "developer not found", UITitle, JOptionPane.PLAIN_MESSAGE);
                                }

                                break;
                            case 3:
                                String devMessage = "";
                                for (int i = 0; i < instancedDeveloperList.size(); i++) {
                                    devMessage += instancedDeveloperList.get(i).getFirstName() + ",  " + instancedDeveloperList.get(i).getEmailAddress() + "\n";
                                }
                                JOptionPane.showMessageDialog(null, "List of Developers:\n" + devMessage, UITitle, JOptionPane.PLAIN_MESSAGE);
                                break;
                            case 4:
                                chosenOptionRerun = false;
                                break;
                        }
                    }

                    break;


                /*---       EXIT        ---*/
                case 4:
                    programRerun = false;
                    break;
            }
        }
    }
}
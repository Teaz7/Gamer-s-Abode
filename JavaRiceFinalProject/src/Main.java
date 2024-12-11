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
        String[][] UIOptions = {{"Store", "Library", "Account", "Developer", "Exit"}, //Home
                                {"Purchase Game", "Refund Game", "Display Games", "Sort Games", "Back"}, //Store
                                {"Install Game", "Uninstall Game", "Display Games", "Sort Games", "Back"}, //Library
                                {"Deposit Funds", "Display Account Details", "Change Account Details", "Back"}, //Customer Account
                                {"Use Developer", "Add Developer", "Remove Developer", "Display Developers", "Back"}, //Developer Account - Choose Developer
                                {"Publish Game", "Remove Game", "Display Details", "Edit Details", "Back"}}; //Developer Account - Developer Functions
        LinkedList<Developer> instancedDeveloperList = new LinkedList<>();
        boolean programRerun = true;
        boolean chosenOptionRerun = true;
        Store store = new Store();
        Library library = new Library();

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
                    UITitle, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, UIOptions[0], UIOptions[0][0]);
            int userOption2;

            switch (userOption) {
                /*---       STORE     ---*/
                case 0:
                    while (chosenOptionRerun) {
                        userOption2 = JOptionPane.showOptionDialog(null, "G A M E R ' S   A B O D E :   H O M E\n" + drawBorder(65) +
                                "Welcome to the store! Discover and purchase new games to add to your library.\n\n" +
                                "Number of Games in Store: " + store.getStoreGameList().size(),
                                UITitle, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, UIOptions[1], UIOptions[1][0]);
                        switch (userOption2) {
                            case 0:
                                break;
                            case 1:
                                break;
                            case 2:
                                break;
                            case 3:
                                break;
                            case 4:
                                chosenOptionRerun = false;
                                break;
                        }
                    }

                    break;

                /*---       LIBRARY     ---*/
                case 1:
                    while (chosenOptionRerun) {
                        userOption2 = JOptionPane.showOptionDialog(null, "G A M E R ' S   A B O D E :   H O M E\n" + drawBorder(65) +
                                        "Here is your game library. Browse and manage your collection of games.\n\n" +
                                        "Number of Games in Library: " + library.getLibraryGameList().size(),
                                UITitle, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, UIOptions[2], UIOptions[2][0]);
                        switch (userOption2) {
                            case 0:
                                break;
                            case 1:
                                break;
                            case 2:
                                break;
                            case 3:
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
                        userOption2 = JOptionPane.showOptionDialog(null, "G A M E R ' S   A B O D E :   H O M E\n" + drawBorder(65) +
                                        "Here is you Account. Deposit funds into your wallet and purchase games from the store.\n\n" +
                                        "Current Amount in Wallet: " + customerAccount.getWalletAmount(),
                                UITitle, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, UIOptions[3], UIOptions[3][0]);
                        switch (userOption2) {
                            case 0:
                                String amountInput = JOptionPane.showInputDialog(null, "input number: ", UITitle, JOptionPane.PLAIN_MESSAGE);
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
                        userOption2 = JOptionPane.showOptionDialog(null, "G A M E R ' S   A B O D E :   H O M E\n" + drawBorder(65) +
                                        "Access developer tools and resources here. Manage developed game projects and updates.\n\n" +
                                        "Number of Developers: " + instancedDeveloperList.size(),
                                UITitle, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, UIOptions[4], UIOptions[4][0]);
                        switch (userOption2) {
                            case 0:
                                break;
                            case 1:
                                break;
                            case 2:
                                break;
                            case 3:
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
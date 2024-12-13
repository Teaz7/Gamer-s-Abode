import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Customer extends AccountUser {
    private double walletAmount;

    public Customer(String firstName, String lastName, String country, String emailAddress, Store store, Library library) {
        super(firstName, lastName, country, emailAddress, store, library);
        this.walletAmount = 0;
    }

    @Override
    public void changeAccountDetails() {
    	String[] changeAccountOptions = {"Change Name", "Change Email", "Change Country", "Back"};
        boolean changeAccountRerun = true;
        String userInput = "";
        int confirmOption;

        while (changeAccountRerun) {
            int changeAccountPrompt = JOptionPane.showOptionDialog(null, "You may choose to change your acccount name, email, or country" +
                            "\nCurrent Account Name: " + this.getFullName() + "\nCurrent Email Address: " + this.getEmailAddress() + "\nCurrent Account Country: " +
                            this.getCountry(), UITitle, JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, changeAccountOptions, changeAccountOptions[0]);

            switch (changeAccountPrompt) {
                case 0:
                    confirmOption = JOptionPane.showConfirmDialog(null, "Do you want to change your account's name?",
                            UITitle, JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                    if (confirmOption == JOptionPane.YES_OPTION) {
                        String inputFirstName = JOptionPane.showInputDialog(null, "Input first name:\n" + "Current first name: " +
                                this.getFirstName(), UITitle, JOptionPane.PLAIN_MESSAGE);
                        String inputLastName = JOptionPane.showInputDialog(null, "Input last name:\n" + "CUrrent last name" +
                                this.getLastName(), UITitle, JOptionPane.PLAIN_MESSAGE);

                        if (inputFirstName == null || inputLastName == null) {
                            JOptionPane.showMessageDialog(null, "Cancelled changing of account name",
                                    UITitle, JOptionPane.ERROR_MESSAGE);
                        } else if (inputFirstName.isEmpty() || inputLastName.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Please refrain from adding a blank name",
                                    UITitle, JOptionPane.PLAIN_MESSAGE);
                        } else {
                            String newName = inputFirstName + " " + inputLastName;
                            confirmOption = JOptionPane.showConfirmDialog(null, "Are you sure you want to change your name?\n" +
                                    "Current Name: " + this.getFullName() + "\nNew Name: " + newName,
                                    UITitle, JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                            if (confirmOption == JOptionPane.YES_OPTION) {
                                this.setFirstName(inputFirstName);
                                this.setLastName(inputLastName);
                                JOptionPane.showMessageDialog(null, "Changed your acocount name successfully",
                                        UITitle, JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(null, "Cancelled changing of account name",
                                        UITitle, JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    }
                    break;

                case 1:
                    confirmOption = JOptionPane.showConfirmDialog(null, "Do you want to change your account's email address?",
                            UITitle, JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                    if (confirmOption == JOptionPane.YES_OPTION) {
                        String inputEmail = JOptionPane.showInputDialog(null, "Input email address:\n" + "Current email address: " +
                                this.getEmailAddress(), UITitle, JOptionPane.PLAIN_MESSAGE);

                        if (inputEmail == null) {
                            JOptionPane.showMessageDialog(null, "Cancelled changing of account email address",
                                    UITitle, JOptionPane.ERROR_MESSAGE);
                        } else if (inputEmail.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Please refrain from adding a blank email address",
                                    UITitle, JOptionPane.PLAIN_MESSAGE);
                        } else {
                            confirmOption = JOptionPane.showConfirmDialog(null, "Are you sure you want to change your email address?\n" +
                                            "Current Email Address: " + this.getEmailAddress() + "\nNew Email Address: " + inputEmail,
                                    UITitle, JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                            if (confirmOption == JOptionPane.YES_OPTION) {
                                this.setEmailAddress(inputEmail);
                                JOptionPane.showMessageDialog(null, "Changed your account email address successfully",
                                        UITitle, JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(null, "Cancelled changing of account email address",
                                        UITitle, JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    }
                    break;

                case 2:
                    confirmOption = JOptionPane.showConfirmDialog(null, "Do you want to change your account's country?",
                            UITitle, JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                    if (confirmOption == JOptionPane.YES_OPTION) {
                        String inputCountry = JOptionPane.showInputDialog(null, "Input country:\n" + "Current country: " +
                                this.getCountry(), UITitle, JOptionPane.PLAIN_MESSAGE);

                        if (inputCountry == null) {
                            JOptionPane.showMessageDialog(null, "Cancelled changing of account country",
                                    UITitle, JOptionPane.ERROR_MESSAGE);
                        } else if (inputCountry.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Please refrain from adding a blank country",
                                    UITitle, JOptionPane.PLAIN_MESSAGE);
                        } else {
                            confirmOption = JOptionPane.showConfirmDialog(null, "Are you sure you want to change your country?\n" +
                                            "Current Country: " + this.getCountry() + "\nNew Country: " + inputCountry,
                                    UITitle, JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                            if (confirmOption == JOptionPane.YES_OPTION) {
                                this.setCountry(inputCountry);
                                JOptionPane.showMessageDialog(null, "Changed your account country successfully",
                                        UITitle, JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(null, "Cancelled changing of account country",
                                        UITitle, JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    }
                    break;

                case 3:
                    changeAccountRerun = false;
                    break;
            }
        }
    }

    @Override
    public void displayAccountDetails() {
        String message = "";
        message += "Name:\t\t" + getFullName() + "\t\n";
        message += "Email:\t\t" + getEmailAddress() + "\t\n";
        message += "Country:\t\t" + getCountry() + "\t\n";
        message += "Wallet Amount:\t\t" + getWalletAmount() + "\t\n";

        JOptionPane.showMessageDialog(null, new JTextArea(message), UITitle, JOptionPane.INFORMATION_MESSAGE);
    }
                         
    public void depositFunds(double amount) {
        walletAmount += amount;
    }

    public boolean purchaseGame(Game game) {
        if (walletAmount >= game.getPrice()) {
            walletAmount -= game.getPrice();
            getLibrary().addGameToLibrary(game); // Use library from the parent class
            System.out.println("Game purchased: " + game.getName());
            return true;
        } else {
            System.out.println("Insufficient funds to purchase " + game.getName());
            return false;
        }
    }

    public double getWalletAmount() {
        return walletAmount;
    }

    public void setWalletAmount(double walletAmount) {
        this.walletAmount = walletAmount;
    }
}
    

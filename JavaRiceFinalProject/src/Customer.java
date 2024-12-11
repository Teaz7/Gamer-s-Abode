import javax.swing.*;

public class Customer extends AccountUser {
    private double walletAmount;

    public Customer(String firstName, String lastName, String country, String emailAddress, Store store, Library library) {
        super(firstName, lastName, country, emailAddress, store, library);
        this.walletAmount = 0;
    }

    @Override
    public void changeAccountDetails() {
    	String[] changeAccountOptions = {"Change Name", "Change Email", "Change Country", "Exit"};
        boolean changeAccountRerun = true;

        while (changeAccountRerun) {
            int changeAccountPrompt = JOptionPane.showOptionDialog(null, "message",
                    UITitle, JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, changeAccountOptions, changeAccountOptions[0]);

            switch (changeAccountPrompt) {
                case 0:
                    break;
                case 1:
                    break;
                case 2:
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
        message += "Name: " + getFullName() + "\n";
        message += "Email: " + getEmailAddress() + "\n";
        message += "Country: " + getCountry() + "\n";
        message += "Wallet Amount: " + getWalletAmount() + "\n";

        JOptionPane.showMessageDialog(null, message, UITitle, JOptionPane.INFORMATION_MESSAGE);
    }
                         
    public void depositFunds(double amount) {
        if (amount == 0) {
            JOptionPane.showMessageDialog(null, "Amount cannot be zero.", null, JOptionPane.WARNING_MESSAGE);
        } else if (amount < 0) {
            JOptionPane.showMessageDialog(null, "Amount cannot be negative.", null, JOptionPane.WARNING_MESSAGE);
        } else {
            walletAmount += amount;
            JOptionPane.showMessageDialog(null, "Deposited " + amount + " into account.", UITitle, JOptionPane.PLAIN_MESSAGE);
        }
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
}
    

public class Customer extends AccountUser {
    private double walletAmount;

    public Customer(String firstName, String lastName, String country, String emailAddress, Store store, Library library, double walletAmount) {
        super(firstName, lastName, country, emailAddress, store, library);
        this.walletAmount = walletAmount;
    }

    public void changeAccountDetails() {
    	System.out.println("Change Account Details functionality is not yet implemented.");

    }
    
    @Override
    public void displayAccountDetails() {
    	super.displayAccountDetails(); // Call the parent method to show basic account details
        System.out.println("Wallet Balance: $" + walletAmount);
        
    }
                         
    public void depositFunds(double amount) {
         if (amount > 0) {
             walletAmount += amount;
             System.out.println("Wallet updated. Current balance: $" + walletAmount);
         } else {
             System.out.println("Invalid amount. Please add a positive value.");
         }
    }
    
 // Purchase a game and add it to the library
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

    // Display the customer's library
    public void displayLibrary() {
        getLibrary().displayGames(); // Use library from the parent class
    }

    // Get the wallet amount
    public double getWalletAmount() {
        return walletAmount;
    }
}
    

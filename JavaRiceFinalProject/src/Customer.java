public class Customer extends AccountUser {
    private double walletAmount;

    public Customer(String firstName, String lastName, String country, String emailAddress, Store store, Library library, double walletAmount) {
        super(firstName, lastName, country, emailAddress, store, library);
        this.walletAmount = walletAmount;
    }

    public void changeAccountDetails() {

    }

    public void displayAccountDetails() {

    }
}

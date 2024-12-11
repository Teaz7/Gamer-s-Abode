public abstract class AccountUser {
    static String UITitle = "BSIT-2A Java Rice | Gamer's Abode Client";

    private String firstName;
    private String lastName;
    private String country;
    private String emailAddress;
    private Store store;
    private Library library;

    public AccountUser(String firstName, String lastName, String country, String emailAddress, Store store, Library library) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.emailAddress = emailAddress;
        this.store = store;
        this.library = library;
        this.library.setAccountUser(this);
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public abstract void changeAccountDetails();
    public abstract void displayAccountDetails();

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCountry() {
        return country;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public Store getStore() {
        return store;
    }

    public Library getLibrary() {
        return library;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}


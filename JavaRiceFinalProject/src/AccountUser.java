public abstract class AccountUser {
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

    public void changeAccountDetails(String newFirstName, String newLastName, String newEmail, String newCountry) {
    	this.firstName = newFirstName;
        this.lastName = newLastName;
        this.emailAddress = newEmail;
        this.country = newCountry;
        System.out.println("Account details updated.");
    }

    public void displayAccountDetails() {
    	System.out.println("Name: " + getFullName());
        System.out.println("Email: " + emailAddress);
        System.out.println("Country: " + country);

    }

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


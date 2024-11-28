public class Game {
    private String name;
    private double price;
    private int year;
    private boolean isOwned;
    private boolean isInstalled;
    private Developer developer;
    private Store store;
    private Library library;

    public Game(String name, double price, int year, boolean isOwned, boolean isInstalled, Developer developer) {
        this.name = name;
        this.price = price;
        this.year = year;
        this.isOwned = isOwned;
        this.isInstalled = isInstalled;
        this.developer = developer;
    }

    public void displayGameDetails() {

    }
}

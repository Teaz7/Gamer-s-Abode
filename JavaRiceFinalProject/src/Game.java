public class Game {
    private String name;
    private double price;
    private int year;
    private boolean isOwned;
    private boolean isInstalled;
    private Developer developer;

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

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

    public int getYear() {
        return year;
    }

    public boolean getIsOwned() {
        return isOwned;
    }

    public boolean getIsInstalled() {
        return isInstalled;
    }

    public void setIsOwned(boolean owned) {
        isOwned = owned;
    }

    public void setInstalled(boolean installed) {
        isInstalled = installed;
    }
}

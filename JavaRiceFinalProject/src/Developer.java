import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import java.util.LinkedList;

public class Developer extends AccountUser{
    private String category;
    private LinkedList<Game> developerGameList;

    public Developer(String firstName, String lastName, String country, String emailAddress, Store store, Library library, String category) {
        super(firstName, lastName, country, emailAddress, store, library);
        this.category = category;
        this.developerGameList = new LinkedList<>();
    }

    @Override
    public void changeAccountDetails() {
    	String[] changeAccountOptions = {"Change Name", "Change Email", "Change Country", "Change Category", "Back"};
        boolean changeAccountRerun = true;
        String userInput = "";
        int confirmOption;

        while (changeAccountRerun) {
            int changeAccountPrompt = JOptionPane.showOptionDialog(null, "You may choose to change a developer's name, email, country, or category" +
                    "\nCurrent Developer Name: " + this.getFirstName() + "\nCurrent Developer Email Address: " + this.getEmailAddress() +
                    "\nCurrent Developer Account Country: " + this.getCountry() + "\nCurrent Developer Category: " + this.category,
                    UITitle, JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, changeAccountOptions, changeAccountOptions[0]);

            switch (changeAccountPrompt) {
                case 0:
                    confirmOption = JOptionPane.showConfirmDialog(null, "Do you want to change the developer's name",
                            UITitle, JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                    if (confirmOption == JOptionPane.YES_OPTION) {
                        String inputName = JOptionPane.showInputDialog(null, "Input name:\n" + "Current developer name: " +
                                this.getFirstName(), UITitle, JOptionPane.PLAIN_MESSAGE);

                        if (inputName == null) {
                            JOptionPane.showMessageDialog(null, "Cancelled changing of developer name",
                                    UITitle, JOptionPane.ERROR_MESSAGE);
                        } else if (inputName.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Please refrain from adding a blank name",
                                    UITitle, JOptionPane.PLAIN_MESSAGE);
                        } else {
                            confirmOption = JOptionPane.showConfirmDialog(null, "Are you sure you want to change the developer's name?\n" +
                                            "Developer's Current Name: " + this.getFirstName() + "\nDeveloper's New Name: " + inputName,
                                    UITitle, JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                            if (confirmOption == JOptionPane.YES_OPTION) {
                                this.setFirstName(inputName);
                                JOptionPane.showMessageDialog(null, "Changed the developer's name successfully",
                                        UITitle, JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(null, "Cancelled changing of developer name",
                                        UITitle, JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    }
                    break;

                case 1:
                    confirmOption = JOptionPane.showConfirmDialog(null, "Do you want to change the developer's email address",
                            UITitle, JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                    if (confirmOption == JOptionPane.YES_OPTION) {
                        String inputEmail = JOptionPane.showInputDialog(null, "Input name:\n" + "Current developer email address: " +
                                this.getEmailAddress(), UITitle, JOptionPane.PLAIN_MESSAGE);

                        if (inputEmail == null) {
                            JOptionPane.showMessageDialog(null, "Cancelled changing of developer email address",
                                    UITitle, JOptionPane.ERROR_MESSAGE);
                        } else if (inputEmail.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Please refrain from adding a blank email address",
                                    UITitle, JOptionPane.PLAIN_MESSAGE);
                        } else {
                            confirmOption = JOptionPane.showConfirmDialog(null, "Are you sure you want to change the developer's email address?\n" +
                                            "Developer's Current Email Address: " + this.getEmailAddress() + "\nDeveloper's New Email Address: " + inputEmail,
                                    UITitle, JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                            if (confirmOption == JOptionPane.YES_OPTION) {
                                this.setEmailAddress(inputEmail);
                                JOptionPane.showMessageDialog(null, "Changed the developer's email address successfully",
                                        UITitle, JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(null, "Cancelled changing of developer email address",
                                        UITitle, JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    }
                    break;

                case 2:
                    confirmOption = JOptionPane.showConfirmDialog(null, "Do you want to change the developer's country",
                            UITitle, JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                    if (confirmOption == JOptionPane.YES_OPTION) {
                        String inputCountry = JOptionPane.showInputDialog(null, "Input country:\n" + "Current developer country: " +
                                this.getCountry(), UITitle, JOptionPane.PLAIN_MESSAGE);

                        if (inputCountry == null) {
                            JOptionPane.showMessageDialog(null, "Cancelled changing of developer country",
                                    UITitle, JOptionPane.ERROR_MESSAGE);
                        } else if (inputCountry.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Please refrain from adding a blank country",
                                    UITitle, JOptionPane.PLAIN_MESSAGE);
                        } else {
                            confirmOption = JOptionPane.showConfirmDialog(null, "Are you sure you want to change the developer's country?\n" +
                                            "Developer's Current Country: " + this.getCountry() + "\nDeveloper's New Country: " + inputCountry,
                                    UITitle, JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                            if (confirmOption == JOptionPane.YES_OPTION) {
                                this.setCountry(inputCountry);
                                JOptionPane.showMessageDialog(null, "Changed the developer's country successfully",
                                        UITitle, JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(null, "Cancelled changing of developer country",
                                        UITitle, JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    }
                    break;

                case 3:
                    String[] categoryChoices = {"Independent", "Company"};
                    confirmOption = JOptionPane.showConfirmDialog(null, "Do you want to change the developer's country",
                            UITitle, JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                    if (confirmOption == JOptionPane.YES_OPTION) {
                        int inputCategory = JOptionPane.showOptionDialog(null, "Choose Independent or Company to change the developer's category\n" +
                                        "Developer's current category: " + this.category,
                            UITitle, JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, categoryChoices, categoryChoices[0]);
                        String chosenChoice = "";
                        switch (inputCategory) {
                            case 0:
                                chosenChoice = "Independent";
                                break;
                            case 1:
                                chosenChoice = "Company";
                                break;
                        }

                        confirmOption = JOptionPane.showConfirmDialog(null, "Are you sure you want to change the developer's category?\n" +
                                        "Developer's Current Category: " + this.category + "\nDeveloper's New Category: " + inputCategory,
                                UITitle, JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                        if (confirmOption == JOptionPane.YES_OPTION) {
                            this.category = chosenChoice;
                            JOptionPane.showMessageDialog(null, "Changed the developer's category successfully",
                                    UITitle, JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "Cancelled changing of developer category",
                                    UITitle, JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    break;

                case 4:
                    changeAccountRerun = false;
                    break;
            }
        }
    }

    @Override
    public void displayAccountDetails() {
        String message = "";
        message += "Name:\t\t" + getFirstName() + "\t\n";
        message += "Email:\t\t" + getEmailAddress() + "\t\n";
        message += "Country:\t\t" + getCountry() + "\t\n";
        message += "Category:\t\t" + category + "\t\n";
        message += "No. of Games:\t\t" + developerGameList.size() + "\t\n";

        JOptionPane.showMessageDialog(null, new JTextArea(message), UITitle, JOptionPane.INFORMATION_MESSAGE);
    }

    public void publishGame(Game game) {
    	developerGameList.add(game);
        getStore().getStoreGameList().add(game);
    }

    public void removeGame(Game game) {
        developerGameList.remove(game);
        getStore().getStoreGameList().remove(game);
    }

    public LinkedList<Game> getDeveloperGameList() {
        return developerGameList;
    }
}

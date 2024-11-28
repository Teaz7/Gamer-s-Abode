import javax.swing.JOptionPane;

public class Main {
    static String UITitle = "BSIT-2A Java Rice | Gamer's Abode Client";

    public static void main(String[] args) {
        String[][] UIOptions = {{"Store", "Library", "Customer", "Developer", "Exit"}, //Home
                                {"Add Game", "Remove Game", "Purchase Game", "Refund Game", "Display Games", "Sort Games", "Exit"}, //Store
                                {"Install Game", "Uninstall Game", "Display Games", "Sort Games", "Exit"}, //Library
                                {"Display Account Details", "Change Account Details", "Exit"}, //Customer Account
                                {"Publish Game", "Display Account Details", "Change Account Details", "Exit"}}; //Developer Account
        boolean programRerun = true;

        while (programRerun) {
            int userOption = JOptionPane.showOptionDialog(null, "message",
                    UITitle, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, UIOptions[0], UIOptions[0][0]);
            int userOption2;

            switch (userOption) {
                case 0:
                    userOption2 = JOptionPane.showOptionDialog(null, "message",
                            UITitle, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, UIOptions[1], UIOptions[1][0]);
                    break;
                case 1:
                    userOption2 = JOptionPane.showOptionDialog(null, "message",
                            UITitle, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, UIOptions[2], UIOptions[2][0]);
                    break;
                case 2:
                    userOption2 = JOptionPane.showOptionDialog(null, "message",
                            UITitle, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, UIOptions[3], UIOptions[3][0]);
                    break;
                case 3:
                    userOption2 = JOptionPane.showOptionDialog(null, "message",
                            UITitle, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, UIOptions[4], UIOptions[4][0]);
                    break;
                case 4:
                    programRerun = false;
                    break;
            }
        }
    }
}
import java.io.File;
import java.util.IllegalFormatException;
import java.util.Scanner;

import controller.GameController;
import controller.GameException;
import view.ConsoleUI;
import view.GameUI;

/**
 * Class : GameStart.java
 *
 * @author: Rick Price
 * @version: 1.2
 * Course: ITEC 3860
 * Written: October 9, 2021
 * This class is the launch point for the DB demo
 */
public class GameStart {

    public static void main(String[] args) {
        boolean valid = true;
        GameController gc = new GameController();
        try {
            gc.start();
        } catch (GameException ge) {
            valid = false;
            System.out.println(ge.getMessage());
        }

        if (valid) {
            Scanner input = new Scanner(System.in);
            int choice = 0;
            do {
                try {
                    System.out.println("Please enter 1 to play from the console, 2 to play from the UI.");
                    choice = input.nextInt();
                } catch (IllegalFormatException ife) {
                    System.out.println("You must enter an integer.");
                }
                if (!(choice == 1 || choice == 2)) {
                    System.out.println("You must enter 1 or 2");
                }
            } while (!(choice == 1 || choice == 2));
            if (choice == 1) {
                ConsoleUI cui = new ConsoleUI();
                cui.startGame();
            } else { //Comment out else block if you do not want to use FX
//                GameUI.launch(GameUI.class);

                //the next two lines were added to launch on the console if you do not want to use FX.
                ConsoleUI cui = new ConsoleUI();
                cui.startGame();
            }
            input.close();
            System.exit(0);
        }
    }
}

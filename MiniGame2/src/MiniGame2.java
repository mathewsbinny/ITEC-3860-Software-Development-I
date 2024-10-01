import controller.CreateFilesController;
import controller.GameController;
import controller.GameException;
import view.ConsoleUI;

import java.io.File;

/**
 * class: MiniGame2.java
 * @author: Mathews Binny
 * @version: 1.0
 * course: ITEC 3860
 * written: 11 March 2024
 * purpose: This class contains the logic to start the game.
 */
public class MiniGame2 {

    public static void main(String[] args) throws GameException {
        boolean valid = true;
        GameController gc = new GameController();
        /**
        try {
            gc.start();
        } catch (GameException ge) {
            valid = false;
            System.out.println(ge.getMessage());
        }
         */
        gc.start();


        if (valid) {
            ConsoleUI cui = new ConsoleUI();
            try {
                cui.startGame();
            } catch (GameException e) {
                throw new RuntimeException(e);
            }
        }
    }


}
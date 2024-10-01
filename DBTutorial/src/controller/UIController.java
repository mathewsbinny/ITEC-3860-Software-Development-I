package controller;
//
//import java.util.ArrayList;
//
//import javafx.application.Platform;
//import javafx.fxml.FXML;
//import javafx.scene.control.Alert; 
//import javafx.scene.control.TextArea;
//import javafx.scene.control.TextField;
//import javafx.stage.Stage;
//
///**
// * Class : UIController.java
// * @author: Rick Price
// * @version: 1.2
// * Course: ITEC 3860
// * Written: August 27, 2023
// * This class is the UI version of the DB Tutorial
// */
public class UIController {
//    @FXML private TextArea descTA;
//    @FXML private TextField cmdTF;
//    @FXML private TextField numTF;
//
//    private int number = 0;
//
//    private GameController gc = new GameController();
//
//    /**
//     * Method: cancel
//     * Purpose: Closes the DOA application
//     * @return void
//     */
//    @FXML
//    public void cancel() {
//        Stage stage = (Stage) descTA.getScene().getWindow();
//        stage.close();
//        Platform.exit();
//    }
//
//    public void process() throws GameException{
//        String retStr = "";
//        descTA.clear();
//        try {
//            number = Integer.parseInt(cmdTF.getText());
//            switch (number) {
//                case 1: {
//                    retStr = buildStrs(gc.getAllRoomsData());
//                    descTA.setText(retStr);
//                    break;
//                }
//                case 2: {
//                    int room = 0;
//                    try{
//                        room = Integer.parseInt(numTF.getText());
//                        retStr = gc.getRoomData(room);
//                        descTA.setText(retStr);
//                    }
//                    catch(NumberFormatException nfe){
//                        descTA.setText("You must enter an int for the room number");
//                    }
//                    catch(GameException ge){
//                        descTA.setText((ge.getMessage()));
//                    }
//                    break;
//                }
//                case 3: {
//                    retStr = buildStrs(gc.getAllMonstersData());
//                    descTA.setText(retStr);
//                    break;
//                }
//                case 4: {
//                    int monster = 0;
//                    try{
//                        monster = Integer.parseInt(numTF.getText());
//                        retStr = gc.getMonsterData(monster);
//                        descTA.setText(retStr);
//                    }
//                    catch(NumberFormatException nfe){
//                        descTA.setText("You must enter an int for the monster number");
//                    }
//                    catch(GameException ge){
//                        descTA.setText((ge.getMessage()));
//                    }
//                    break;
//                }
//                case 5: {
//                    int room = 0;
//                    try {
//                        room = Integer.parseInt(numTF.getText());
//
//                        retStr = gc.getMonsterRoomData(room);
//                    }
//                    catch(NumberFormatException nfe){
//                        descTA.setText("You must enter an int for the room number");
//                    }
//                    catch(GameException ge){
//                        descTA.setText(ge.getMessage());
//                    }
//                    descTA.setText(retStr);
//                    break;
//                }
//                case 6: {
//                    try {
//                        retStr = buildStrs(gc.getAllMonsterRoomData());
//                        descTA.setText(retStr);
//                    }
//                    catch (GameException ge) {
//                        System.out.println(ge.getMessage());
//                    }
//                    break;
//                }
//                case 7: {
//                    retStr = "Current room 2\n";
//                    retStr += gc.getRoomData(2);
//                    descTA.setText(retStr);
//                    try {
//                        gc.updateRoom();
//                    } catch (GameException ge) {
//                        Alert alert = new Alert(Alert.AlertType.ERROR);
//                        alert.setContentText(ge.getMessage());
//                    }
//                    break;
//                }
//                    default: {
//                    retStr = "Error: Invalid command";
//                    descTA.setText(retStr);
//                }
//            }
//        }
//        catch (GameException e) {
//            descTA.setText(e.getMessage());
//        }
//        catch(NumberFormatException nfe){
//            descTA.setText("You must enter a number for the command");
//        }
//
//    }
//
//    private String buildStrs(ArrayList<String> strs) {
//        String retStr = "";
//        for (String str : strs) {
//            retStr += str;
//            retStr += "\n";
//        }
//        return retStr;
//    }
}

package com.example;

import javafx.scene.control.Button;
import javafx.stage.Stage;
public class ViewSettings
{
    void viewSettings(Stage primaryStage)
    {
        // Modify the primary stage settings
        primaryStage.setTitle("Klotski Game");
        primaryStage.setHeight(4 * 200);
        primaryStage.setWidth(4 * 200);
        primaryStage.setResizable(false);
    }

    //Set the layout and size of each button
    void buttonsSettings(Button up, Button down, Button rigth, Button left, Button config1, Button config2, Button config3, Button config4, Button reset, Button undo, Button bestNextMove, Button save, Button loadGame)
    {
        up.setLayoutX(615);
        up.setLayoutY(350);
        up.setMinSize(50, 10);
        up.setPrefWidth(60);

        down.setLayoutX(615);
        down.setLayoutY(450);
        down.setMinSize(50, 10);
        down.setPrefWidth(60);

        rigth.setLayoutX(680);
        rigth.setLayoutY(400);
        rigth.setMinSize(50, 10);
        rigth.setPrefWidth(60);

        left.setLayoutX(550);
        left.setLayoutY(400);
        left.setMinSize(50, 10);
        left.setPrefWidth(60);

        config1.setLayoutX(586);
        config1.setLayoutY(100);
        config1.setMinSize(50, 10);

        config2.setLayoutX(586);
        config2.setLayoutY(130);
        config2.setMinSize(50, 10);

        config3.setLayoutX(586);
        config3.setLayoutY(160);
        config3.setMinSize(50, 10);

        config4.setLayoutX(586);
        config4.setLayoutY(190);
        config4.setMinSize(50, 10);

        loadGame.setLayoutX(610);
        loadGame.setLayoutY(220);
        loadGame.setMinSize(50, 10);

        undo.setLayoutX(581);
        undo.setLayoutY(580);
        undo.setMinSize(50, 10);
        undo.setPrefWidth(60);

        reset.setLayoutX(581);
        reset.setLayoutY(610);
        reset.setMinSize(50, 10);
        reset.setPrefWidth(60);

        bestNextMove.setLayoutX(650);
        bestNextMove.setLayoutY(580);
        bestNextMove.setMinSize(50, 10);
        bestNextMove.setPrefWidth(60);

        save.setLayoutX(650);
        save.setLayoutY(610);
        save.setMinSize(50, 10);
        save.setPrefWidth(60);
    }
} 

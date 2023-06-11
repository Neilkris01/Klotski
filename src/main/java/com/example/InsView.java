package com.example;

import javafx.scene.control.Button;
import javafx.scene.*;

public class InsView
{
    //insert all buttons on the view
    void insertButtons(Group root, Button up, Button down, Button rigth, Button left, Button config1, Button config2, Button config3, Button config4, Button reset, Button undo, Button bestNextMove, Button save, Button loadGame)
    {
        //change the buttons view settings
        ViewSettings primaryStageSetting = new ViewSettings();
        primaryStageSetting.buttonsSettings(up, down, rigth, left, config1, config2, config3, config4, reset, undo, bestNextMove, save, loadGame);

        root.getChildren().add(down);
        root.getChildren().add(up);
        root.getChildren().add(rigth);
        root.getChildren().add(left);
        root.getChildren().add(reset);
        root.getChildren().add(config1);
        root.getChildren().add(config2);
        root.getChildren().add(config3);
        root.getChildren().add(config4);
        root.getChildren().add(undo);
        root.getChildren().add(bestNextMove);
        root.getChildren().add(save);
        root.getChildren().add(loadGame);
    }
}

package com.example;

import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.Group;
public class Texts
{
    //Display the counter value on the scene
    void counterText(Group root, Board board)
    {
        Text text1 = new Text();
        text1.setText("Counter: " + board.getCounter());
        text1.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        text1.setX(265);
        text1.setY(700);
        root.getChildren().add(text1);
    }
}

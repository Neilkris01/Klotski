package com.example;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.*;

public class PiecesView
{
    private int squareSize = 100;
    Rectangle[] a = new Rectangle[10];

    //Print the pieces on the scene
    Rectangle[] printPiece(Piece[] p, Group root, Board board)
    {

        //Create rectangles and add them to the scene
        for (int i = 0; i <= 8; i++)
        {
            int[] dimensions = p[i].getDims();
            a[i] = new Rectangle(dimensions[0] * squareSize + 100, dimensions[1] * squareSize + 100, dimensions[2] * squareSize, dimensions[3] * squareSize);
            if (board.isSelect(p[i]))
            {a[i].setFill(Color.LIGHTGREY);}
            else
            {a[i].setFill(Color.WHITE);}
            a[i].setStrokeWidth(3);
            a[i].setStroke(Color.BLACK);
            root.getChildren().add(a[i]);
        }
        int[] dimensions = p[9].getDims();
        a[9] = new Rectangle(dimensions[0] * squareSize + 100, dimensions[1] * squareSize + 100, dimensions[2] * squareSize, dimensions[3] * squareSize);
        if (board.isSelect(p[9])) {
            a[9].setFill(Color.FIREBRICK);
        } else {
            a[9].setFill(Color.RED);
        }
        a[9].setStrokeWidth(3);
        a[9].setStroke(Color.BLACK);

        root.getChildren().add(a[9]);
        return a;
    }

    //Reposition and update the pieces on the scene
    Rectangle[] rePrintPiece(Piece[] p, Group root, Board board)
    {
        //Update the position and appearance of the rectangles
        for (int i = 0; i <= 8; i++)
        {
            int[] dimensions = p[i].getDims();
            a[i].setX(dimensions[0] * squareSize + 100);
            a[i].setY(dimensions[1] * squareSize + 100);
            if (board.isSelect(p[i]))
            {a[i].setFill(Color.LIGHTGREY);}
            else
            {a[i].setFill(Color.WHITE);}
            a[i].setStrokeWidth(3);
            a[i].setStroke(Color.BLACK);
            root.getChildren().add(a[i]);
        }

        int[] dimensions = p[9].getDims();
        a[9].setX(dimensions[0] * squareSize + 100);
        a[9].setY(dimensions[1] * squareSize + 100);
        if (board.isSelect(p[9]))
        {a[9].setFill(Color.FIREBRICK);}
        else
        {a[9].setFill(Color.RED);}
        a[9].setStrokeWidth(3);
        a[9].setStroke(Color.BLACK);

        root.getChildren().add(a[9]);
        return a;
    }

    //Clear the pieces from the scene
    void clearPiece(Group root)
    {
        root.getChildren().clear();
    }

}

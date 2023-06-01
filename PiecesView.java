import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.*;

public class PiecesView
{
    private int squareSize = 100;

    void printPiece(Piece[] p, Rectangle[][] squares, Group root)
    {
        
        // Array che rappresenta i pezzi
        Rectangle[] a = new Rectangle[10];
/*

        // Crea i rettangoli e li inserisce nella scena
        for (int i = 0; i <= 8; i++) {
            int[] dimensions = p[i].getDims();
            a[i] = new Rectangle(dimensions[0] * squareSize + 100, dimensions[1] * squareSize + 100, dimensions[2] * squareSize, dimensions[3] * squareSize);
            a[i].setFill(Color.WHITE);
            a[i].setStrokeWidth(3);
            a[i].setStroke(Color.BLACK);
            root.getChildren().add(a[i]);
         }
         */

        int[] dimensions = p[9].getDims();
        a[9] = new Rectangle(dimensions[0] * squareSize + 100, dimensions[1] * squareSize + 100, dimensions[2] * squareSize, dimensions[3] * squareSize);
        a[9].setFill(Color.RED);
        a[9].setStrokeWidth(3);
        a[9].setStroke(Color.BLACK);

        root.getChildren().add(a[9]);
    }

    void clearPiece(Group root)
    {
        root.getChildren().clear();
    }

}

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.*;

public class BoardView {

    void printBoard(Rectangle[][]  squares, Group root)
    {

        int squareSize = 100;

        //Setta il contorno dei pezzi
        Rectangle border = new Rectangle(1 * squareSize, 1 * squareSize, 4 * squareSize, 5 * squareSize);
        border.setStrokeWidth(15);
        border.setStroke(Color.ORANGE);
        border.setFill(Color.BISQUE);
        root.getChildren().add(border);
        
    }
}

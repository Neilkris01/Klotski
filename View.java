/*/
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
*/
import javafx.util.Pair;

public class View /*extends Application*/
{
    Board board;

    public void paintComponent() {

        Piece[] p = board.getPieces();

            int pDim1[] = p[0].getDims();
            int x = pDim1[0];
            int y = pDim1[1];
            int h = pDim1[2];
            int w = pDim1[3];

            int pDim2[] = p[0].getDims();
            int x2 = pDim2[0];
            int y2 = pDim2[1];
            int h2 = pDim2[2];
            int w2 = pDim2[3];
    }
}
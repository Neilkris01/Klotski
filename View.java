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

            int pDim[] = p[0].getDims();
            int x = pDim[0];
            int y = pDim[1];
            int h = pDim[2];
            int w = pDim[3];
            //restituisce: x, y, altezza e larghezza
    }
/*
    private Rectangle square;

    @Override
        public void start(Stage primaryStage) throws Exception {
            
            // Creazione di un rettangolo per rappresentare un pezzo da 2x1
            Rectangle piece21 = new Rectangle(50, 100, 100, 50);
            piece21.setFill(Color.RED);
            
            // Creazione di un rettangolo per rappresentare un pezzo da 1x1
            Rectangle piece11 = new Rectangle(200, 150, 50, 50);
            piece11.setFill(Color.BLUE);

            //Creazione griglia 5x4
            square = new Rectangle(100, 100, Color.RED);
            square.setStroke(Color.BLACK);
            square.setStrokeWidth(2);

            StackPane root = new StackPane();
            root.getChildren().add(square);
            root.setPadding(new Insets(10));
            root.setAlignment(Pos.CENTER);

            Scene scene = new Scene(root, 300, 250);
            scene.widthProperty().addListener((obs, oldVal, newVal) -> resizeSquare(newVal.doubleValue()));
            scene.heightProperty().addListener((obs, oldVal, newVal) -> resizeSquare(newVal.doubleValue()));

            primaryStage.setTitle("Resizable Square");
            primaryStage.setScene(scene);
            primaryStage.show();
            
    }*/
}
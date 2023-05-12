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
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.AnchorPane;

public class BoardView {

    //crea la fnestra
    void createBoard(Rectangle[][] squares, int squareSize) {
        // Crea i quadrati for each square in the grid
        for (int y = 0; y < 5; y++) {
            for (int x = 0; x < 4; x++) {
                Rectangle square = new Rectangle(squareSize, squareSize, Color.WHITE);
                square.setStroke(Color.BLACK);
                squares[y][x] = square;
            }
        }
    }

    void gridLayout(Rectangle[][] squares, Stage primaryStage)
    {
        // Create a layout grid for the squares
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setAlignment(Pos.CENTER);

        // Create a StackPane to center the grid
        AnchorPane window = new AnchorPane();

        //testo in alto
        Texts texts = new Texts();
        texts.upperText(window);

        // Add the squares to the grid
        for (int y = 0; y < 5; y++) {
            for (int x = 0; x < 4; x++) {
                gridPane.add(squares[y][x], x, y);
            }
        }

        window.getChildren().addAll(gridPane);

        //impostazioni finestra
        ViewSettings settings = new ViewSettings();
        settings.settings(window, primaryStage, gridPane);

    }
}

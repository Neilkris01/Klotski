import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Label;

public class BoardView {

    //crea la fnestra
    void createBoard(Rectangle[][] squares, int squareSize) {
        // Crea i quadrati for each square in the grid
        for (int y = 0; y < 5; y++) {
            for (int x = 0; x < 4; x++) {
                Rectangle square = new Rectangle(squareSize, squareSize, Color.TRANSPARENT);
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
        StackPane stackPane = new StackPane();


        // Create a la frase in alto
        Label label = new Label("Benvenuto nella finestra ViewPoint!");
        label.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
        // Add the label and the rectangle grid to the StackPane layout
        stackPane.getChildren().addAll(gridPane, label);
        // Set the alignment of the label to the top-center of the window
        StackPane.setAlignment(label, Pos.TOP_CENTER);

        // Add the squares to the grid
        for (int y = 0; y < 5; y++) {
            for (int x = 0; x < 4; x++) {
                gridPane.add(squares[y][x], x, y);
            }
        }

        ViewSettings settings = new ViewSettings();
        settings.settings(stackPane, primaryStage);

    }
}

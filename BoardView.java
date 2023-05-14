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
    void createBoard(Rectangle[][] squares, int squareSize) {
        // Create rectangles for each square in the grid
        for (int y = 0; y < 5; y++) {
            for (int x = 0; x < 4; x++) {
                Rectangle square = new Rectangle(squareSize, squareSize, Color.TRANSPARENT);
                square.setStroke(Color.BLACK);
                squares[y][x] = square;
            }
        }
    }

    void gridLayout(Rectangle[][] squares, Stage primaryStage) {
        // Create a layout grid for the squares
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setAlignment(Pos.CENTER);

        // Create a StackPane to center the grid
        StackPane stackPane = new StackPane();

        // Create a label for the window
        Label label = new Label("Benvenuto nella finestra ViewPoint!");
        label.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        // Add the label and the rectangle grid to the StackPane layout
        stackPane.getChildren().addAll(gridPane, label);

        // Set the alignment of the label to the top-center of the window
        StackPane.setAlignment(label, Pos.TOP_CENTER);

        // Set the margins of the label to be proportional to the size of the window
        final double initialHeight = primaryStage.getHeight();
        final double labelMargin = initialHeight * 0.05;
        GridPane.setMargin(label, new Insets(labelMargin, 10, 0, 0));

        // Add the squares to the grid
        for (int y = 0; y < 5; y++) {
            for (int x = 0; x < 4; x++) {
                gridPane.add(squares[y][x], x, y);
            }
        }

        // Set the background color of the scene to blue
        stackPane.setStyle("-fx-background-color: lightgray;");

        // Create the scene with blue background
        Scene scene = new Scene(stackPane, 500, 500, Color.WHITE);

        // Set the scene on the stage
        primaryStage.setScene(scene);
        primaryStage.setTitle("ViewPoint");

        // Center the scene on the stage
        primaryStage.setOnShown(event -> {
            double width = primaryStage.getWidth();
            double height = primaryStage.getHeight();
            stackPane.setPrefSize(width, height);

            // Update the label margin to be proportional to the new window size
            double newLabelMargin = initialHeight * 0.05 * (height / initialHeight);
            GridPane.setMargin(label, new Insets(newLabelMargin, 10, 0, 0));
        });

        primaryStage.show();
    }

    public void updateBoard(Rectangle[][] squares, double squareSize) {
        for (int row = 0; row < squares.length; row++) {
            for (int col = 0; col < squares[row].length; col++) {
                Rectangle square = squares[row][col];
                square.setWidth(squareSize);
                square.setHeight(squareSize);
                square.setX(col * squareSize);
                square.setY(row * squareSize);
            }
        }
    }
}

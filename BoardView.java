import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.layout.GridPane;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BoardView
{
    void createBoard(Rectangle[][] squares, int squareSize)
    {
        // Create rectangles for each square in the grid
        for (int y = 0; y < 5; y++) {
            for (int x = 0; x < 4; x++) {
                Rectangle square = new Rectangle(squareSize, squareSize, Color.WHITE);
                square.setStroke(Color.TRANSPARENT);
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
        // Add the squares to the grid
        for (int y = 0; y < 5; y++)
        {
            for (int x = 0; x < 4; x++)
            {
                gridPane.add(squares[y][x], x, y);
            }
        }

        Group root = new Group();
        root.getChildren().add(gridPane);

        // Create the scene and set its dimensions
        Scene scene = new Scene(root, 500, 500);

        // Set the scene on the stage and display the stage
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
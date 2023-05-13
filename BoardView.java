import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;

public class BoardView {
    void createBoard(Rectangle[][] squares, int squareSize) {
        // Create rectangles for each square in the grid
        for (int y = 0; y < 5; y++) {
            for (int x = 0; x < 4; x++) {
                Rectangle square = new Rectangle(squareSize, squareSize, Color. WHITE);
                square.setStroke(Color.TRANSPARENT);
                squares[y][x] = square;
            }
        }
    }

    void gridLayout(Rectangle[][] squares, Stage primaryStage) {
        // Create a layout grid for the squares
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setAlignment(Pos.CENTER);
            
        // Add the squares to the grid
        for (int y = 0; y < 5; y++) {
            for (int x = 0; x < 4; x++) {
                gridPane.add(squares[y][x], x, y);
            }
        }
            
        // Create a StackPane to center the grid
        StackPane stackPane = new StackPane();
        stackPane.getChildren().add(gridPane);
            
        // Create the scene
        Scene scene = new Scene(stackPane, 500, 500);
        scene.setFill(Color.DARKGRAY);
    
        // Set the scene on the stage
        primaryStage.setScene(scene);
        primaryStage.setTitle("ViewPoint");
    
        // Center the scene on the stage
        primaryStage.setOnShown(event -> {
            double width = primaryStage.getWidth();
            double height = primaryStage.getHeight();
            stackPane.setPrefSize(width, height);
        });
        
        primaryStage.show();
    }
    
}

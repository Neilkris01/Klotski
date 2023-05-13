import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application {

    private int squareSize = 50; // dimensione del lato dei quadrati

    @Override
    public void start(Stage primaryStage) throws Exception {

        // Create rectangles for each square in the grid
        Rectangle[][] squares = new Rectangle[5][4];
        for (int y = 0; y < 5; y++) {
            for (int x = 0; x < 4; x++) {
                Rectangle square = new Rectangle(squareSize, squareSize, Color.WHITE);
                square.setStroke(Color.BLACK);
                squares[y][x] = square;
            }
        }

        // Set up the initial state of the game
        int[] p1 = new int[]{0, 0, 1, 2};
        for (int y = 0; y < p1[3]; y++)
        {
            for (int x = 0; x < p1[2]; x++)
            {
                squares[p1[1]+y][p1[0]+x].setFill(Color.ORANGE);
            }
        }

        int[] p2 = new int[]{0, 2, 1, 2};
        for (int y = 0; y < p2[3]; y++)
        {
            for (int x = 0; x < p2[2]; x++)
            {
                squares[p2[1]+y][p2[0]+x].setFill(Color.BLUE);
            }
        }

        int[] p3 = new int[]{3, 0, 1, 2};
        for (int y = 0; y < p3[3]; y++)
        {
            for (int x = 0; x < p3[2]; x++)
            {
                squares[p3[1]+y][p3[0]+x].setFill(Color.YELLOW);
            }
        }

        int[] p4 = new int[]{3, 2, 1, 2};
        for (int y = 0; y < p4[3]; y++)
        {
            for (int x = 0; x < p4[2]; x++)
            {
                squares[p4[1]+y][p4[0]+x].setFill(Color.GREEN);
            }
        }

        int[] p5 = new int[]{1, 2, 2, 1};
        for (int y = 0; y < p5[3]; y++)
        {
            for (int x = 0; x < p5[2]; x++)
            {
                squares[p5[1]+y][p5[0]+x].setFill(Color.PINK);
            }
        }

        int[] p6 = new int[]{0, 4, 1, 1};
        squares[p6[1]][p6[0]].setFill(Color.PURPLE);

        int[] p7 = new int[]{3, 4, 1, 1};
        squares[p7[1]][p7[0]].setFill(Color.BROWN);

        int[] p8 = new int[]{1, 3, 1, 1};
        squares[p8[1]][p8[0]].setFill(Color.GRAY);

        int[] p9 = new int[]{2, 3, 1, 1};
        squares[p9[1]][p9[0]].setFill(Color.BLACK);

        int[] p10 = new int[]{1, 0, 2, 2};
        for (int y = 0; y < p10[3]; y++)
        {
            for (int x = 0; x < p5[2]; x++)
            {
                squares[p10[1]+y][p10[0]+x].setFill(Color.RED);
            }
        }

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

        // Create the root group and add the grid to it
        Group root = new Group();
        root.getChildren().add(gridPane);

        // Create the scene and set its dimensions
        Scene scene = new Scene(root, 500, 500);

        // Set the scene on the stage and display the stage
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
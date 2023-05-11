import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application {
    private Rectangle square;

    @Override
    public void start(Stage primaryStage) {
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
    }

    private void resizeSquare(double size) {
        square.setWidth(size / 2);
        square.setHeight(size / 2);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
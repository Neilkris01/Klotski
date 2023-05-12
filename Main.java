import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane; //+
import javafx.scene.Group; //+

/*public class Main extends Application {
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
}*/

public class Main extends Application {
    private Rectangle square;
    @Override
    public void start(Stage primaryStage) throws Exception {
        
        // Creazione di un rettangolo per rappresentare un pezzo da 2x1
        Rectangle piece21 = new Rectangle(50, 100, 50, 100);
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
        
        // Creazione di un layout a griglia per disporre i pezzi
        /*GridPane gridPane = new GridPane();
        gridPane.add(piece21, 0, 0, 2, 1);
        gridPane.add(piece11, 5, 5);*/
        
        // Creazione del gruppo per contenere il layout a griglia
        Group root = new Group();
        root.getChildren().add(gridPane);
        
        // Creazione della scena e impostazione della dimensione
        Scene scene = new Scene(root, 300, 300);
                
        // Impostazione della scena sullo stage e visualizzazione dello stage
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
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    private ViewPrint view;

    @Override
    public void start(Stage primaryStage) {
        view = new ViewPrint();
        view.print(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}

// javac Main.java Board.java BoardView.java Errors.java InsView.java Piece.java PiecesView.java ViewPrint.java
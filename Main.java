import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        ViewPrint view = new ViewPrint();
        view.print(primaryStage);
        
        view.print(primaryStage);

    }

    public static void main(String[] args) {
        launch(args);
    }
}


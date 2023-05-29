import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Main extends Application
{

    private ViewPrint view;
    Board board = new Board();
    Piece[] p = board.getPieces();

    private Button sù = new Button("SU");
    private Button giù = new Button("GIU");
    private Button destra = new Button("DESTRA");
    private Button sinistra = new Button("SINISTRA");
    private Button reset = new Button("RESET");
    private Button config1 = new Button("CONFIGURATION 1");
    private Button config2 = new Button("CONFIGURATION 2");
    private Button config3 = new Button("CONFIGURATION 3");
    private Button undo = new Button("UNDO");

    public static void main(String[] args)
    {
        launch(args);
    }

     int f;
     int conf;

    @Override
    public void start(Stage primaryStage)
    {
        view = new ViewPrint();
        view.print(primaryStage, board, p, sù, giù, destra, sinistra, config1, config2, config3, reset, undo);

        board.selectPiece(p[9]);
            
        sù.setOnAction(new EventHandler<ActionEvent>()
        {
        @Override

        public void handle(ActionEvent event)
        {
            board.movePiece(0);
            view.rePrint(primaryStage, board, p, sù, giù, destra, sinistra, config1, config2, config3, reset, undo);
        }

        });

        giù.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override

            public void handle(ActionEvent event)
            {
                board.movePiece(2);
                view.rePrint(primaryStage, board, p, sù, giù, destra, sinistra, config1, config2, config3, reset, undo);
            }

        });

        destra.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override

            public void handle(ActionEvent event)
            {
                board.movePiece(1);
                view.rePrint(primaryStage, board, p, sù, giù, destra, sinistra, config1, config2, config3, reset, undo);
            }

        });

        sinistra.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override

            public void handle(ActionEvent event)
            {
                board.movePiece(3);
                view.rePrint(primaryStage, board, p, sù, giù, destra, sinistra, config1, config2, config3, reset, undo);
            }

        });
        
        config1.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override

            public void handle(ActionEvent event)
            {
                board.reset();
                board.setConfig(1);
                view.resetPrint(primaryStage, board, p, sù, giù, destra, sinistra, config1, config2, config3, reset, undo);
                view.print(primaryStage, board, p, sù, giù, destra, sinistra, config1, config2, config3, reset, undo);
            }

        });

        config2.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override

            public void handle(ActionEvent event)
            {
                board.reset();
                board.setConfig(2);
                view.resetPrint(primaryStage, board, p, sù, giù, destra, sinistra, config1, config2, config3, reset, undo);
                view.print(primaryStage, board, p, sù, giù, destra, sinistra, config1, config2, config3, reset, undo);
            }
        });

        config3.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override

            public void handle(ActionEvent event)
            {
                board.reset();
                board.setConfig(3);
                view.resetPrint(primaryStage, board, p, sù, giù, destra, sinistra, config1, config2, config3, reset, undo);
                view.print(primaryStage, board, p, sù, giù, destra, sinistra, config1, config2, config3, reset, undo);
            }

        });
        
    }
}

// javac Main.java Board.java BoardView.java Errors.java InsView.java Piece.java PiecesView.java ViewPrint.java
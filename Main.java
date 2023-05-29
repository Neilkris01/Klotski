import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.control.Button;

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

    @Override
    public void start(Stage primaryStage)
    {
        view = new ViewPrint();
        view.print(primaryStage, board, p, sù, giù, destra, sinistra, config1, config2, config3, reset, undo);


        board.selectPiece(p[9]);
        while(!board.checkWin())
        {
            f = -1;
            f = insertValue();
            if(f != -1)
            {
                board.movePiece(f);
                view.rePrint(primaryStage, board, p, sù, giù, destra, sinistra, config1, config2, config3, reset, undo);
            }
            
        }
        System.out.println("HAI VINTO!!!!");
        
    }

    int result = 2;//cambiae in -1

    int insertValue()
    {
        sù.setOnAction(event -> {
            result = 0;
        });

        giù.setOnAction(event -> {
            result = 2;
        });

        destra.setOnAction(event -> {
            result = 1;
        });

        sinistra.setOnAction(event -> {
            result = 3;
        });

        return result;
    }


}

// javac Main.java Board.java BoardView.java Errors.java InsView.java Piece.java PiecesView.java ViewPrint.java
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class Main extends Application
{

    private ViewPrint view;
    Board board = new Board();
    Piece[] p = board.getPieces();

    private Button sù = new Button("sù");
    private Button giù = new Button("giù");
    private Button destra = new Button("destra");
    private Button sinistra = new Button("sinistra");

    public static void main(String[] args)
    {
        launch(args);
    }

     int f;

    @Override
    public void start(Stage primaryStage)
    {
        view = new ViewPrint();
        view.print(primaryStage, board, p, sù, giù, destra, sinistra);

        board.selectPiece(p[9]);
        while(!board.checkWin())
        {
            f = -1;
            f = insertValue();
            if(f != -1)
            {
                board.movePiece(f);
                view.rePrint(primaryStage, board, p, sù, giù, destra, sinistra);
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
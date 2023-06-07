import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.shape.Rectangle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class Main extends Application
{
    private ViewPrint view;
    Board board = new Board();
    Piece[] p = board.getPieces();

    PiecesView pView = new PiecesView();
    Rectangle[] rect;

    private Button sù = new Button("SU");
    private Button giù = new Button("GIU");
    private Button destra = new Button("DESTRA");
    private Button sinistra = new Button("SINISTRA");
    private Button reset = new Button("RESET");
    private Button config1 = new Button("CONFIGURATION 1");
    private Button config2 = new Button("CONFIGURATION 2");
    private Button config3 = new Button("CONFIGURATION 3");
    private Button config4 = new Button("CONFIGURATION 4");
    private Button undo = new Button("UNDO");
    private Button bestNextMove = new Button("BNXM");
    private Button save = new Button("SAVE");
    private Button caricaPartita = new Button("CARICA  (LOG FILE)");

    public static void main(String[] args)
    {launch(args);}

    int f;
    int conf;

    @Override
    public void start(Stage primaryStage)
    {
        view = new ViewPrint();
        rect = view.print(primaryStage, board, p, sù, giù, destra, sinistra, config1, config2, config3, config4, reset, undo, bestNextMove, save, caricaPartita);
        board.deleteFile();
        board.logWrite();
        
        rect[0].setOnMouseClicked(new EventHandler<MouseEvent>() 
        {
            @Override
            public void handle(MouseEvent t)
            {
                for(int i = 0; i<10; i++)
                {
                    rect[i].setFill(Color.WHITE);
                }
                rect[0].setFill(Color.LIGHTGREY);
                rect[9].setFill(Color.RED);
                board.selectPiece(p[0]);
            }
        });

        rect[1].setOnMouseClicked(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent t)
            {
                for (int i = 0; i < 10; i++)
                {
                    rect[i].setFill(Color.WHITE);
                }
                rect[1].setFill(Color.LIGHTGREY);
                rect[9].setFill(Color.RED);
                board.selectPiece(p[1]);
            }
        });

        rect[2].setOnMouseClicked(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent t)
            {
                for(int i = 0; i < 10; i++)
                { rect[i].setFill(Color.WHITE);}
                rect[2].setFill(Color.LIGHTGREY);
                rect[9].setFill(Color.RED);
                board.selectPiece(p[2]);
            }
        });

        rect[3].setOnMouseClicked(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent t)
            {
                for(int i = 0; i < 10; i++)
                { rect[i].setFill(Color.WHITE);}
                rect[3].setFill(Color.LIGHTGREY);
                rect[9].setFill(Color.RED);
                board.selectPiece(p[3]);
            }
        });

        rect[4].setOnMouseClicked(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent t)
            {
                for(int i = 0; i < 10; i++)
                {rect[i].setFill(Color.WHITE);}
                rect[4].setFill(Color.LIGHTGREY);
                rect[9].setFill(Color.RED);
                board.selectPiece(p[4]);
            }
        });

        rect[5].setOnMouseClicked(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent t)
            {
                for (int i = 0; i < 10; i++)
                {rect[i].setFill(Color.WHITE);}
                rect[5].setFill(Color.LIGHTGREY);
                rect[9].setFill(Color.RED);
                board.selectPiece(p[5]);
            }
        });

        rect[6].setOnMouseClicked(new EventHandler<MouseEvent>() 
        {
            @Override
            public void handle(MouseEvent t)
            {
                for (int i = 0; i < 10; i++)
                {rect[i].setFill(Color.WHITE);}
                rect[6].setFill(Color.LIGHTGREY);
                rect[9].setFill(Color.RED);
                board.selectPiece(p[6]);
            }
        });

        rect[7].setOnMouseClicked(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent t)
            {
                for (int i = 0; i < 10; i++)
                {rect[i].setFill(Color.WHITE);}
                rect[7].setFill(Color.LIGHTGREY);
                rect[9].setFill(Color.RED);
                board.selectPiece(p[7]);
            }
        });

        rect[8].setOnMouseClicked(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent t)
            {
                for (int i = 0; i < 10; i++)
                {rect[i].setFill(Color.WHITE);}
                rect[8].setFill(Color.LIGHTGREY);
                rect[9].setFill(Color.RED);
                board.selectPiece(p[8]);
            }
        });
        rect[9].setOnMouseClicked(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent t)
            {
                for (int i = 0; i < 10; i++)
                {rect[i].setFill(Color.WHITE);}
                rect[9].setFill(Color.FIREBRICK);
                board.selectPiece(p[9]);
            }
        });
        
            
        sù.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override

            public void handle(ActionEvent event)
            {
                board.movePiece(0);
                view.rePrint(primaryStage, board, p, sù, giù, destra, sinistra, config1, config2, config3, config4, reset, undo, bestNextMove, save, caricaPartita);
            }
        });

        giù.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override

            public void handle(ActionEvent event)
            {
                board.movePiece(2);
                view.rePrint(primaryStage, board, p, sù, giù, destra, sinistra, config1, config2, config3, config4, reset, undo, bestNextMove, save, caricaPartita);
                if(board.checkWin())
                {
                    view.winView(board);
                    System.exit(0);

                }
            }
        });

        destra.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override

            public void handle(ActionEvent event)
            {
                board.movePiece(1);
                view.rePrint(primaryStage, board, p, sù, giù, destra, sinistra, config1, config2, config3, config4, reset, undo, bestNextMove, save, caricaPartita);
            }
        });

        sinistra.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override

            public void handle(ActionEvent event)
            {
                board.movePiece(3);
                view.rePrint(primaryStage, board, p, sù, giù, destra, sinistra, config1, config2, config3, config4, reset, undo, bestNextMove, save, caricaPartita);
            }
        });
        
        config1.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override

            public void handle(ActionEvent event)
            {
                board.reset(1);
                p = board.getPieces();
                view.rePrint(primaryStage, board, p, sù, giù, destra, sinistra, config1, config2, config3, config4, reset, undo, bestNextMove, save, caricaPartita);
                board.fileOutDelater();
                board.logWrite();
            }
        });

        config2.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override

            public void handle(ActionEvent event)
            {
                board.reset(2);
                p = board.getPieces();
                board.fileOutDelater();
                board.logWrite();
                view.rePrint(primaryStage, board, p, sù, giù, destra, sinistra, config1, config2, config3, config4, reset, undo, bestNextMove, save, caricaPartita);
            }
        });

        config3.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override

            public void handle(ActionEvent event)
            {
                board.reset(3);
                p = board.getPieces();
                view.rePrint(primaryStage, board, p, sù, giù, destra, sinistra, config1, config2, config3, config4, reset, undo, bestNextMove, save, caricaPartita);
                board.fileOutDelater();
                board.logWrite();
            }
        });

        config4.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override

            public void handle(ActionEvent event)
            {
                board.reset(4);
                p = board.getPieces();
                view.rePrint(primaryStage, board, p, sù, giù, destra, sinistra, config1, config2, config3, config4,  reset, undo, bestNextMove, save, caricaPartita);
                board.fileOutDelater();
                board.logWrite();
            }
        });

        reset.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override

            public void handle(ActionEvent event)
            {
                board.reset(board.getConfig());
                p = board.getPieces();
                view.rePrint(primaryStage, board, p, sù, giù, destra, sinistra, config1, config2, config3, config4, reset, undo, bestNextMove, save, caricaPartita);
            }
        });

        undo.setOnAction(new EventHandler<ActionEvent>()
        {
             @Override

            public void handle(ActionEvent event)
            {
                if(board.getCounter() != 0)
                {
                    board.undo();
                }
                view.rePrint(primaryStage, board, p, sù, giù, destra, sinistra, config1, config2, config3, config4, reset, undo, bestNextMove, save, caricaPartita);
            }
        });

        bestNextMove.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override

            public void handle(ActionEvent event)
            {
                System.out.println("Miao");
                view.rePrint(primaryStage, board, p, sù, giù, destra, sinistra, config1, config2, config3, config4, reset, undo, bestNextMove, save, caricaPartita);
            }
        });

        save.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override

            public void handle(ActionEvent event)
            {
                    if(view.saveView(board))
                    {System.exit(0);}
            }
        });

        caricaPartita.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override

            public void handle(ActionEvent event)
            {
                view.loadView(board);
                view.rePrint(primaryStage, board, p, sù, giù, destra, sinistra, config1, config2, config3, config4, reset, undo, bestNextMove, save, caricaPartita);
            }
        });
    }
}

// javac Main.java Board.java BoardView.java Errors.java InsView.java Piece.java PiecesView.java ViewPrint.java
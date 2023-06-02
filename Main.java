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
    private Button undo = new Button("UNDO");

    public static void main(String[] args)
    {launch(args);}

    int f;
    int conf;

    @Override
    public void start(Stage primaryStage)
    {
        view = new ViewPrint();
        rect = view.print(primaryStage, board, p, sù, giù, destra, sinistra, config1, config2, config3, reset, undo);
        
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
                for (int i = 0; i < 10; i++) {
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
                for (int i = 0; i < 10; i++) {
                    rect[i].setFill(Color.WHITE);
                }
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
                for (int i = 0; i < 10; i++) {
                    rect[i].setFill(Color.WHITE);
                }
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
                for (int i = 0; i < 10; i++) {
                    rect[i].setFill(Color.WHITE);
                }
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
                for (int i = 0; i < 10; i++) {
                    rect[i].setFill(Color.WHITE);
                }
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
                for (int i = 0; i < 10; i++) {
                    rect[i].setFill(Color.WHITE);
                }
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
                for (int i = 0; i < 10; i++) {
                    rect[7].setFill(Color.WHITE);
                }
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
                for (int i = 0; i < 10; i++) {
                    rect[i].setFill(Color.WHITE);
                }
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
                for (int i = 0; i < 10; i++) {
                    rect[i].setFill(Color.WHITE);
                }
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
                rect = view.rePrint(primaryStage, board, p, sù, giù, destra, sinistra, config1, config2, config3, reset, undo);
            }
        });

        giù.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override

            public void handle(ActionEvent event)
            {
                board.movePiece(2);
                rect = view.rePrint(primaryStage, board, p, sù, giù, destra, sinistra, config1, config2, config3, reset, undo);
            }
        });

        destra.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override

            public void handle(ActionEvent event)
            {
                board.movePiece(1);
                rect = view.rePrint(primaryStage, board, p, sù, giù, destra, sinistra, config1, config2, config3, reset, undo);
            }
        });

        sinistra.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override

            public void handle(ActionEvent event)
            {
                board.movePiece(3);
                rect = view.rePrint(primaryStage, board, p, sù, giù, destra, sinistra, config1, config2, config3, reset, undo);
            }
        });
        
        config1.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override

            public void handle(ActionEvent event)
            {
                board.setConfig(1);
                board.reset();
                p = board.getPieces();
                rect = view.rePrint(primaryStage, board, p, sù, giù, destra, sinistra, config1, config2, config3, reset, undo);
            }
        });

        config2.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override

            public void handle(ActionEvent event)
            {
                board.setConfig(2);
                board.reset();
                p = board.getPieces();
                rect = view.rePrint(primaryStage, board, p, sù, giù, destra, sinistra, config1, config2, config3, reset, undo);
            }
        });

        config3.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override

            public void handle(ActionEvent event)
            {
                board.setConfig(3);
                board.reset();
                p = board.getPieces();
                rect = view.rePrint(primaryStage, board, p, sù, giù, destra, sinistra, config1, config2, config3, reset, undo);
            }
        });

        reset.setOnAction(new EventHandler<ActionEvent>() {
            @Override

            public void handle(ActionEvent event) {
                board.reset();
                p = board.getPieces();
                rect = view.rePrint(primaryStage, board, p, sù, giù, destra, sinistra, config1, config2, config3, reset, undo);
            }
        });
        
    }
}

// javac Main.java Board.java BoardView.java Errors.java InsView.java Piece.java PiecesView.java ViewPrint.java
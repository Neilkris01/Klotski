import com.example.Board;
import com.example.LogFile;
import com.example.Piece;
import com.example.PiecesView;
import com.example.Solver;
import com.example.ViewPrint;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application
{

    //create the board, view and the solver
    Board board = new Board();
    PiecesView pView = new PiecesView();
    Solver solver = new Solver();

    //inizialize the variables
    Piece[] p = board.getPieces();
    LogFile logFile = board.getLog();
    ViewPrint view;
    Rectangle[] rect;
    int f;
    int conf;
    int a = 1;

    //create all buttons
    private Button up = new Button("UP");
    private Button down = new Button("DOWN");
    private Button rigth = new Button("RIGHT");
    private Button left = new Button("LEFT");
    private Button reset = new Button("RESET");
    private Button config1 = new Button("CONFIGURATION 1");
    private Button config2 = new Button("CONFIGURATION 2");
    private Button config3 = new Button("CONFIGURATION 3");
    private Button config4 = new Button("CONFIGURATION 4");
    private Button undo = new Button("UNDO");
    private Button bestNextMove = new Button("BNXM");
    private Button save = new Button("SAVE");
    private Button loadGame = new Button("LOAD FILE");

    //main constructor (runner)
    public static void main(String[] args)
    {launch(args);}

    @Override

    public void start(Stage primaryStage1)
    {
        //inizialize the game and the view
        final Stage primaryStage = primaryStage1;
        view = new ViewPrint();
        rect = view.print(primaryStage, board, p, up, down, rigth, left, config1, config2, config3, config4, reset, undo, bestNextMove, save, loadGame);
        logFile.deleteFile();
        logFile.logWrite(p, board);
        
        //select p0
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

        //select p1 rectangle and change the selected rectangle color
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

        //select p2 rectangle and change the selected rectangle color
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

        //select p3 rectangle and change the selected rectangle color
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

        //select p4 rectangle and change the selected rectangle color
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

        //select p5 rectangle and change the selected rectangle color
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

        //select p6 rectangle and change the selected rectangle color
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

        //select p7 rectangle and change the selected rectangle color
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

        //select p8 rectangle and change the selected rectangle color
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

        //select p9 rectangle and change the selected rectangle color
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
        
        //buttons implementations (makes the selected rectangle move)
        up.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override

            public void handle(ActionEvent event)
            {
                board.movePiece(board, 0);
                view.rePrint(primaryStage, board, p, up, down, rigth, left, config1, config2, config3, config4, reset, undo, bestNextMove, save, loadGame);
            }
        });

        down.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override

            public void handle(ActionEvent event)
            {
                board.movePiece(board, 2);
                view.rePrint(primaryStage, board, p, up, down, rigth, left, config1, config2, config3, config4, reset, undo, bestNextMove, save, loadGame);
                //check if the red rectangle is on the win posiction
                if(board.checkWin())
                {
                    view.winView(board, logFile);
                    System.exit(0);

                }
            }
        });

        rigth.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override

            public void handle(ActionEvent event)
            {
                board.movePiece(board, 1);
                view.rePrint(primaryStage, board, p, up, down, rigth, left, config1, config2, config3, config4, reset, undo, bestNextMove, save, loadGame);
            }
        });

        left.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override

            public void handle(ActionEvent event)
            {
                board.movePiece(board, 3);
                view.rePrint(primaryStage, board, p, up, down, rigth, left, config1, config2, config3, config4, reset, undo, bestNextMove, save, loadGame);
            }
        });
        
        //select the start configuration nad update the log file (restatrt the game with the new config. if the game is already started)
        config1.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override

            public void handle(ActionEvent event)
            {
                board.reset(1);
                p = board.getPieces();
                view.rePrint(primaryStage, board, p, up, down, rigth, left, config1, config2, config3, config4, reset, undo, bestNextMove, save, loadGame);
                logFile.fileOutDelater();
                logFile.logWrite(p, board);
            }
        });

        config2.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override

            public void handle(ActionEvent event)
            {
                board.reset(2);
                p = board.getPieces();
                logFile.fileOutDelater();
                logFile.logWrite(p, board);
                view.rePrint(primaryStage, board, p, up, down, rigth, left, config1, config2, config3, config4, reset, undo, bestNextMove, save, loadGame);
            }
        });

        config3.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override

            public void handle(ActionEvent event)
            {
                board.reset(3);
                p = board.getPieces();
                view.rePrint(primaryStage, board, p, up, down, rigth, left, config1, config2, config3, config4, reset, undo, bestNextMove, save, loadGame);
                logFile.fileOutDelater();
                logFile.logWrite(p, board);
            }
        });

        config4.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override

            public void handle(ActionEvent event)
            {
                board.reset(4);
                p = board.getPieces();
                view.rePrint(primaryStage, board, p, up, down, rigth, left, config1, config2, config3, config4,  reset, undo, bestNextMove, save, loadGame);
                logFile.fileOutDelater();
                logFile.logWrite(p, board);
            }
        });

        //restart the game and logLile (keep the current config) 
        reset.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override

            public void handle(ActionEvent event)
            {
                board.reset(board.getConfig());
                p = board.getPieces();
                view.rePrint(primaryStage, board, p, up, down, rigth, left, config1, config2, config3, config4,  reset, undo, bestNextMove, save, loadGame);
                logFile.fileOutDelater();
                logFile.logWrite(p, board);
            }
        });

        //put in the board the last rect. onfiguration (undo the move) and remove the last move from the log file
        undo.setOnAction(new EventHandler<ActionEvent>()
        {
             @Override

            public void handle(ActionEvent event)
            {
                if(board.getCounter() != 0)
                {
                    logFile.undo(p, board);
                }
                view.rePrint(primaryStage, board, p, up, down, rigth, left, config1, config2, config3, config4, reset, undo, bestNextMove, save, loadGame);
            }
        });


        bestNextMove.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override

            public void handle(ActionEvent event)
            {
                solver.solve(board, p, view);
                view.rePrint(primaryStage, board, p, up, down, rigth, left, config1, config2, config3, config4, reset, undo, bestNextMove, save, loadGame);
                a++;
            }
        });

        //save all the move playad sinse now in this game in the file log and name it
        save.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override

            public void handle(ActionEvent event)
            {
                    if(view.saveView(board, logFile))
                    {System.exit(0);}
            }
        });

        //load all the move playad in a game and rewrite the file
        loadGame.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override

            public void handle(ActionEvent event)
            {
                view.loadView(board, logFile);
                view.rePrint(primaryStage, board, p, up, down, rigth, left, config1, config2, config3, config4, reset, undo, bestNextMove, save, loadGame);
            }
        });
    }
}
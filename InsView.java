import javafx.scene.control.Button;
import javafx.scene.*;

import java.util.concurrent.Semaphore;

public class InsView {
    private int result = -1;
    private Semaphore semaphore = new Semaphore(0);

    private Button sù = new Button("sù");
    private Button giù = new Button("giù");
    private Button destra = new Button("destra");
    private Button sinistra = new Button("sinistra");

    void insertButtons(Board board, Piece[] p, Group root) {
        sù.setLayoutX(615);
        sù.setLayoutY(350);

        giù.setLayoutX(615);
        giù.setLayoutY(450);

        destra.setLayoutX(650);
        destra.setLayoutY(400);

        sinistra.setLayoutX(550);
        sinistra.setLayoutY(400);

        root.getChildren().add(giù);
        root.getChildren().add(sù);
        root.getChildren().add(destra);
        root.getChildren().add(sinistra);
    }

    int insertValue(Board board, Piece[] p, Group root) throws InterruptedException {
        sù.setOnAction(event -> {
            result = 0;
            semaphore.release();
        });

        giù.setOnAction(event -> {
            result = 2;
            semaphore.release();
        });

        destra.setOnAction(event -> {
            result = 1;
            semaphore.release();
        });

        sinistra.setOnAction(event -> {
            result = 3;
            semaphore.release();
        });

        semaphore.acquire(); // Attendere finché il pulsante non viene premuto
        return result;
    }
}

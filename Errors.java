import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
public class Errors
{
    void insErrorType()
    {
        Alert alertError = new Alert(AlertType.ERROR);
        alertError.setTitle("Errore");
        alertError.setHeaderText("Input non valido");
        alertError.setContentText("L'input inserito non è un numero");
        alertError.showAndWait();
    }

    void insErrorNumber() {
        Alert alertError = new Alert(AlertType.ERROR);
        alertError.setTitle("Errore");
        alertError.setHeaderText("Input non valido");
        alertError.setContentText("L'input inserito non è un numero tra 0 e 3");
        alertError.showAndWait();
    }
}

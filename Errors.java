import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
public class Errors
{
    void insError()
    {
        Alert alertError = new Alert(AlertType.ERROR);
        alertError.setTitle("Errore");
        alertError.setHeaderText("Input non valido");
        alertError.setContentText("L'input inserito non è un numero intero valido.");
        alertError.showAndWait();
    }
}

import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Label;
public class Texts
{
    void upperText(AnchorPane window)
    {
        // Create the label for the upper text
        Label upperText = new Label("Benvenuto nella finestra ViewPoint!");
        upperText.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        // Set the alignment of the GridPane to center it within the AnchorPane
        //AnchorPane.setLeftAnchor(upperText, 800.0);

        // Add the label and the rectangle grid to the AnchorPane layout
        window.getChildren().addAll(upperText);
    }
}

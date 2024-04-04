package vidmot.goldrush;
import javafx.fxml.FXMLLoader;
import java.io.IOException;
/******************************************************************************
 * Nafn : Ebba Þóra Hvannberg
 * T-póstur: ebba@hi.is
 *
 * Lýsing : Lesa fxml skrá - Gefinn klasi
 *****************************************************************************/
public class FXML_Lestur {
    public static void lesa(Object controller, String fxmlSkra) {
        FXMLLoader fxmlLoader = new
                FXMLLoader(controller.getClass().getResource(fxmlSkra));
        fxmlLoader.setClassLoader(controller.getClass().getClassLoader()); // EÞH
        fxmlLoader.setRoot(controller);
        fxmlLoader.setController(controller);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
}


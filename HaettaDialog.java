package vidmot.goldrush;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;

public class HaettaDialog {
    private static final String I_LAGI = "Í lagi";
    public static final ButtonType BTYPE = new ButtonType(I_LAGI,
            ButtonBar.ButtonData.OK_DONE);
    private static final String HAETTA_VID = "Hætta við";
    public static final ButtonType HTYPE = new ButtonType(HAETTA_VID,
            ButtonBar.ButtonData.CANCEL_CLOSE);


    public static Alert HaettaDialog() {
        Alert a = new Alert(Alert.AlertType.NONE,  "Viltu hætta í leiknum?", BTYPE, HTYPE);
        a.setTitle("Hætta leik");
        a.setHeaderText("Hætta");
        return a;
    }
}

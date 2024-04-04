package vidmot.goldrush;

import javafx.scene.control.Alert;

public class UmDialog {

    public static Alert UmDialog() {
        Alert d = new Alert(Alert.AlertType.INFORMATION);
        d.setTitle("Um Leikinn");
        d.setHeaderText("Goldrush leikur");
        d.setContentText("Leikur þar sem markmiðið er að ná eins mörgum gull stöngum og hægt er á tímanum sem gefinn er. " +
                "Hægt er að stjórna gullgrafaranum er örvatökkunum og stilla erfiðleikastigið, ásamt því að hætta í leiknum eða hefja nýjan leik.");
        return d;
    }
}

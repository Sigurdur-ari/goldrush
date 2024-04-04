package vidmot.goldrush;

import javafx.fxml.FXMLLoader;
import javafx.scene.shape.Rectangle;

import java.io.IOException;

public class Grafari extends Rectangle {

    private Stefna stefna;
    private final int HRADI = 50;
    public Grafari(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/grafari-view.fxml"));
        fxmlLoader.setRoot(this);   // rótin á viðmótstrénu sett hér
        fxmlLoader.setController(this); // controllerinn settur hér en ekki í .fxml skránni
        try {
            fxmlLoader.load();          // viðmótstréð lesið inn (þ.e. .fxml skráin)
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    public void afram(){
        Leikbord parent = (Leikbord) this.getParent();

        if (getStefna() == Stefna.HAEGRI || getStefna() == Stefna.VINSTRI) {
            setX(Math.max(0, Math.min(parent.getWidth() - getWidth(), getX() + Math.cos(Math.toRadians(getGradur())) * HRADI / 2)));
        } else if (getStefna() == Stefna.UPP || getStefna() == Stefna.NIDUR) {
            setY(Math.max(0, Math.min(parent.getHeight() - getHeight(), getY() + Math.sin(Math.toRadians(getGradur())) * HRADI / 2)));
        }
    }

    public void setStefna(Stefna stefna){
        this.stefna = stefna;
    }
    private Stefna getStefna(){
        return this.stefna;
    }

    private double getGradur(){
        return stefna.getGradur();
    }
}

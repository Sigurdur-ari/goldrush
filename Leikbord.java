package vidmot.goldrush;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import vinnsla.goldrush.Leikur;

import java.io.IOException;
import java.util.Random;

public class Leikbord extends Pane {
    private Leikur leikurVinnsla;
    private ObservableList<Gull> gullListi = FXCollections.observableArrayList();
    @FXML
    private Grafari fxGrafari;

    private static final Random r = new Random();

    public void initialize(){

    }

    public Leikbord() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/leikbord-view.fxml"));
        fxmlLoader.setRoot(this);   // rótin á viðmótstrénu sett hér
        fxmlLoader.setController(this); // controllerinn settur hér en ekki í .fxml skránni
        try {
            fxmlLoader.load();          // viðmótstréð lesið inn (þ.e. .fxml skráin)
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    public void setStefna(Stefna stefna){
        fxGrafari.setStefna(stefna);
    }

    public void afram(){
        fxGrafari.afram();
        if(erGrefurgull()){
            leikurVinnsla.haekkaStigin();
        }
    }

    public void meiraGull() {
        framleidaGull();
    }

    private void framleidaGull(){
        Gull gull = new Gull(r.nextInt((int)getWidth()), r.nextInt((int)getHeight())); //r.nextInt((int)getWidth()), r.nextInt((int)getHeight())
        getChildren().add(gull);
        gullListi.add(gull);
    }

    private boolean erGrefurgull(){
        for(Gull g: gullListi){
            if(fxGrafari.getBoundsInParent().intersects(g.getBoundsInParent())){
                getChildren().remove(g);
                gullListi.remove(g);
                return true;
            }
        }
        return false;
    }



    public void setLeikur(Leikur leikur){
        this.leikurVinnsla = leikur;
    }

}

package vidmot.goldrush;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;
import vinnsla.goldrush.Klukka;
import vinnsla.goldrush.Leikur;

import java.util.HashMap;

public class GoldController {
    private final HashMap<KeyCode, Stefna> map= new HashMap<KeyCode, Stefna>();

    private int erfidleiki = 1;
    private static int[] timaFylki = {60, 45, 30};

    @FXML
    private MenuController menuStyringController;
    @FXML
    private Leikbord fxLeikbord;

    public Klukka klukka = new Klukka(30);

    public Timeline timeline;
    private Timeline leikTimeline;

    public Leikur leikurVinnsla;

    @FXML
    private Label fxStigin;
    @FXML
    private Label fxTimiEftir;

    private boolean leikurIGangi;


    public void setMenuController(MenuController menuController) {
        this.menuStyringController = menuController;
    }

    public void initialize(){
        leikurVinnsla = new Leikur();
        leikurIGangi = true;
        fxLeikbord.setLeikur(leikurVinnsla);
        fxLeikbord.requestFocus();
        fxTimiEftir.textProperty().bind(klukka.timiProperty().asString());
        fxStigin.textProperty().bind(leikurVinnsla.stiginProperty().asString());
    }


    public void setErfidleiki(String Id){
        if(Id == "fxLett"){
            erfidleiki = 0;
        }
        else if(Id == "fxMid"){
            erfidleiki = 1;
        }
        else if (Id == "fxErfitt") {
            erfidleiki = 2;
        }
        else erfidleiki = 1;
    }


    public void orvatakkar() {
        map.put(KeyCode.UP, Stefna.UPP);
        map.put(KeyCode.DOWN, Stefna.NIDUR);
        map.put(KeyCode.RIGHT, Stefna.HAEGRI);
        map.put(KeyCode.LEFT, Stefna.VINSTRI);
        fxLeikbord.getScene().addEventFilter(KeyEvent.ANY, this::stefna);

    }

    private void stefna(KeyEvent event){
        if(map.get(event.getCode()) != null && leikurIGangi){
            fxLeikbord.setStefna(map.get(event.getCode()));
            fxLeikbord.afram();
        }
    }

    public void raesaKlukku() {
        klukka.setTiminn(timaFylki[erfidleiki]);
        KeyFrame k = new KeyFrame(Duration.seconds(1),
                e -> klukka.tic());
        timeline = new Timeline(k);
        timeline.setCycleCount(timaFylki[erfidleiki]);
        timeline.setOnFinished(event -> {
            if (klukka.getTiminn() == 0) {
                timeline.stop();
                leikurIGangi = false;
                stopGoldProduction();
            }
        });
        timeline.play();
    }

    public void hefjaLeik() {
        raesaKlukku();
        KeyFrame k = new KeyFrame(Duration.seconds(3),
                e -> fxLeikbord.meiraGull());
        Timeline leikTimeline = new Timeline(k);
        leikTimeline.setCycleCount(Timeline.INDEFINITE);
        leikTimeline.play();
        setLeikTimeline(leikTimeline);
    }

    private void stopGoldProduction() {
        Timeline leikTimeline = getLeikTimeline();
        if (leikTimeline != null) {
            leikTimeline.stop();
        }
    }

    private void setLeikTimeline(Timeline timeline) {
        this.leikTimeline = timeline;
    }

    private Timeline getLeikTimeline() {
        return leikTimeline;
    }
}

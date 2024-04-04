package vidmot.goldrush;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.RadioMenuItem;

import java.util.Optional;

public class MenuController {
    @FXML
    private GoldController goldController;

    public void setGoldController(GoldController aThis) {
        goldController = aThis;
    }

    public void initialize(){

    }

    public void onErfidleikastig(ActionEvent actionEvent) {
        RadioMenuItem valinnHnappur = (RadioMenuItem) actionEvent.getSource();
        System.out.println(valinnHnappur.getText());
        goldController.setErfidleiki(valinnHnappur.getId());
        onNyrLeikur();
    }

    public void onNyrLeikur(){
        goldController.hefjaLeik();
    }

    public void onHaetta(ActionEvent actionEvent) {
        Alert a = HaettaDialog.HaettaDialog();
        Optional<ButtonType> u = a.showAndWait();
        if (u.isPresent() && u.get().getButtonData().isDefaultButton()) {
            System.exit(0);
        }
    }

    public void umHandler(ActionEvent actionEvent) {
        Alert d = UmDialog.UmDialog();
        Optional<ButtonType> u = d.showAndWait();
    }
}

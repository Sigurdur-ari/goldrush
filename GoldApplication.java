package vidmot.goldrush;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class GoldApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        Scene s = new Scene(new Pane());
        ViewSwitcher.setScene (s);
        ViewSwitcher.switchTo(View.GOLD);
        GoldController goldController = (GoldController) ViewSwitcher.lookup(View.GOLD);
        stage.setTitle("Gold Rush!");
        stage.setScene(s);
        stage.show();

        goldController.orvatakkar();
        goldController.hefjaLeik();
    }


    public static void main(String[] args) {
        launch();
    }
}

package vinnsla.goldrush;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Leikur {
    private final IntegerProperty stigin = new SimpleIntegerProperty();

    public Leikur(){
        setStigin(0);
    }

    public void setStigin(int stigin) {
        this.stigin.set(stigin);
    }

    public int getStigin() {
        return stigin.get();
    }

    public IntegerProperty stiginProperty() {
        return stigin;
    }

    public void haekkaStigin(){
        setStigin(getStigin()+1);
    }
}

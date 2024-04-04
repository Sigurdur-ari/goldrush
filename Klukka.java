package vinnsla.goldrush;

import javafx.beans.property.SimpleIntegerProperty;

public class Klukka {
    protected SimpleIntegerProperty timinn = new SimpleIntegerProperty();

    public Klukka(int timi){
        setTiminn(timi);
    }

    public void tic(){
        int timi = getTiminn();
        if(timi > 0){
            timi--;
            setTiminn(timi);
        }
        else{
            setTiminn(0);
        }
    }

    public void setTiminn(int timinn) {
        this.timinn.set(timinn);
    }

    public int getTiminn() {
        return timinn.get();
    }

    public SimpleIntegerProperty timiProperty() {
        return timinn;
    }

}

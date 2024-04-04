package vidmot.goldrush;

public enum Stefna {
    UPP (270),
    NIDUR(90),
    VINSTRI(180),
    HAEGRI(360);
    private final int gradur;

    Stefna(int s) {
        gradur=s;
    }
    public int getGradur() {
        return gradur;
    }
}


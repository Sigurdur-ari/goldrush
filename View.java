package vidmot.goldrush;

public enum View {
    MENU("/menu-view.fxml"),

    GOLD("/goldrush-view.fxml");


    private final String fileName;

    View(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }
}

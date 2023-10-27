package models;

public enum CarModelClass {
    CITY_CAR("City car/A"),
    SUPERMINI("Supermini/B"),
    COMPACT_CAR("Compact car/C"),
    MID_SIZE_CAR("Mid-size car/D"),
    EXECUTIVE_CAR("Executive car/E"),
    LUXURY_CAR("Luxury car/F");

    private final String displayedText;

    CarModelClass(String displayedText) {
        this.displayedText = displayedText;
    }

    public String getDisplayedText() {
        return displayedText;
    }

}

public enum CardinalPoints {
    NORTH("N"),
    EAST("E"),
    SOUTH("S"),
    WEST("W");

    private String value;

    CardinalPoints(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static CardinalPoints fromValue(String value) {
        for (CardinalPoints cardinalPoint : CardinalPoints.values()) {
            if (cardinalPoint.getValue().equals(value)) {
                return cardinalPoint;
            }
        }
        throw new IllegalArgumentException("Invalid cardinal point: " + value);
    }
}

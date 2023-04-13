import java.awt.*;

public class Battleship extends Ship {

    private boolean[] isolated;

    public Battleship(Point startPoint, Point endPoint) throws Exception {
        super(startPoint, endPoint);
        this.isolated = new boolean[getSize()];
        for (int i = 0; i < getSize(); i++) {
            isolated[i] = true;
        }
    }

    public boolean getShot(Point shotPoint) {
        if (isSunk()) {
            return false;
        }

        if (shotPoint.getX() >= getStartPoint().getX() && shotPoint.getX() <= getEndPoint().getX() &&
                shotPoint.getY() >= getStartPoint().getY() && shotPoint.getY() <= getEndPoint().getY()) {

            int hitIndex = -1;
            for (int i = 0; i < getSize(); i++) {
                Point point = new Point(getStartPoint());
                if (getDirection() == CardinalPoints.NORTH || getDirection() == CardinalPoints.SOUTH) {
                    point.translate(i, 0);
                } else {
                    point.translate(0, i);
                }
                if (shotPoint.equals(point)) {
                    hitIndex = i;
                    break;
                }
            }

            if (hitIndex == -1) {
                return false;
            }

            hits.add(shotPoint);
            isolated[hitIndex] = false;

            for (boolean isolatedPart : isolated) {
                if (isolatedPart) {
                    return true;
                }
            }

            return true;
        }

        return false;
    }
}
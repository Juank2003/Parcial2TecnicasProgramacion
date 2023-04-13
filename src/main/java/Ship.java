import java.awt.*;
import java.util.HashSet;

public class Ship {
    private Point startPoint;
    private Point endPoint;
    private int size;
    private CardinalPoints direction;
    HashSet<Point> hits;

    public Ship(Point startPoint, Point endPoint) throws Exception {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.size = (int) (Math.max(Math.abs(startPoint.getX() - endPoint.getX()),
                        Math.abs(startPoint.getY() - endPoint.getY())) + 1);

        if (startPoint.getX() == endPoint.getX()) {
            if (startPoint.getY() > endPoint.getY()) {
                this.direction = CardinalPoints.NORTH;
            } else {
                this.direction = CardinalPoints.SOUTH;
            }
        } else if (startPoint.getY() == endPoint.getY()) {
            if (startPoint.getX() > endPoint.getX()) {
                this.direction = CardinalPoints.WEST;
            } else {
                this.direction = CardinalPoints.EAST;
            }
        } else {
            throw new Exception("Coordenadas de barco no válidas: debe ser una línea recta.");
        }

        this.hits = new HashSet<>();
    }

    public Point getStartPoint() {
        return startPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }

    public int getSize() {
        return size;
    }

    public CardinalPoints getDirection() {
        return direction;
    }

    public boolean isSunk() {
        return hits.size() == size;
    }

    public boolean getShot(Point shotPoint) {
        if (isSunk()) {
            return false;
        }

        if (shotPoint.getX() >= startPoint.getX() && shotPoint.getX() <= endPoint.getX() &&
                shotPoint.getY() >= startPoint.getY() && shotPoint.getY() <= endPoint.getY()) {

            Point hitPoint = new Point((int) shotPoint.getX(), (int) shotPoint.getY());
            if (hits.contains(hitPoint)) {
                return false;
            } else {
                hits.add(hitPoint);
                return true;
            }
        }

        return false;
    }
}

import java.awt.*;
import java.util.HashSet;

    public class User {
        private String name;
        private HashSet<Ship> ships;
        private boolean isAlive;

        public User(String name, HashSet<Ship> ships) throws IllegalArgumentException {
            if (name == null || name.trim().equals("")) {
                throw new IllegalArgumentException("El nombre no puede ser nulo o estar vacío");
            }
            if (ships == null || ships.isEmpty()) {
                throw new IllegalArgumentException("El usuario debe tener al menos un barco.");
            }
            this.name = name;
            this.ships = ships;
            this.isAlive = true;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            if (name == null || name.trim().equals("")) {
                throw new IllegalArgumentException("El nombre no puede ser nulo o estar vacío");
            }
            this.name = name;
        }

        public HashSet<Ship> getShips() {
            return ships;
        }

        public boolean isAlive() {
            return isAlive;
        }

        public void die() {
            isAlive = false;
        }

        public boolean attack(Point shotPoint, User user) throws IllegalArgumentException {
            if (shotPoint == null) {
                throw new IllegalArgumentException("El punto de disparo no puede ser nulo");
            }
            if (user == null) {
                throw new IllegalArgumentException("El usuario objetivo no puede ser nulo");
            }
            for (Ship ship : user.getShips()) {
                if (!ship.isSunk() && ship.getShot(shotPoint)) {
                    return true;
                }
            }
            return false;
        }

        public void getShot(Point shotPoint) throws IllegalArgumentException {
            if (shotPoint == null) {
                throw new IllegalArgumentException("El punto de disparo no puede ser nulo");
            }
            for (Ship ship : ships) {
                ship.getShot(shotPoint);
            }
        }
    }



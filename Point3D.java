import java.math.BigDecimal;
import java.math.RoundingMode;

public class Point3D {
    private double x;
    private double y;
    private double z;

    public Point3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Point3D() {
        this.x = 0.0;
        this.y = 0.0;
        this.z = 0.0;
    }

    public double getX() {
        return this.x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return this.y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return this.z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public boolean equals(Point3D point) {
        return this.x == point.getX() && this.y == point.getY() && this.z == point.getZ();
    }

    public int compare(Point3D point) {
        if (this.radiusVector() > point.radiusVector()) {
            return 1;
        } else if (this.radiusVector() == point.radiusVector()) {
            return 0;
        } else {
            return -1;
        }
    }

    public double radiusVector() {
        return Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
    }

    public double distanceTo(Point3D point) {
        double distance = (new Point3D(this.x - point.getX(), this.y - point.getY(), this.z - point.getZ()))
                .radiusVector();

        return round(distance, 2);
    }

    public String toString() {
        return "(" + Double.toString(this.x) + ", " + Double.toString(this.y) + ", " + Double.toString(this.z) + ")";
    }

    private static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}

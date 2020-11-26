import java.util.Scanner;

public class Lab1 {
    private static boolean isOnOneLine(Point3D A, Point3D B, Point3D C) {
        double x1, x2, x3, y1, y2, y3, z1, z2, z3;
        x1 = A.getX(); y1 = A.getY(); z1 = A.getZ();
        x2 = B.getX(); y2 = B.getY(); z2 = B.getZ();
        x3 = C.getX(); y3 = C.getY(); z3 = C.getZ();

        return  (x3 - x1) / (x2 - x1) == (y3 - y1) / (y2 - y1) &&
                (x3 - x1) / (x2 - x1) == (z3 - z1) / (z2 - z1) &&
                (y3 - y1) / (y2 - y1) == (z3 - z1) / (z2 - z1);
    }

    public static Point3D createPoint() {
        Scanner sc = new Scanner(System.in);
        double x, y, z;

        System.out.println("Enter X, Y, Z to create point");
        x = sc.nextDouble();
        y = sc.nextDouble();
        z = sc.nextDouble();

        return new Point3D(x, y, z);
    }

    public static double computeArea(Point3D A, Point3D B, Point3D C) {
        if (A.equals(B) || A.equals(C) || B.equals(C)) {
            System.out.println("There are 2 or more equal points");
            return 0;
        } else if (isOnOneLine(A, B, C)) {
            System.out.println("All 3 point are on the one line");
            return 0;
        } else {
            double AB = A.distanceTo(B);
            double BC = B.distanceTo(C);
            double AC = A.distanceTo(C);
            double P = AB + BC + AC;

            return Math.sqrt(P * (P - AB) * (P - BC) * (P - AC));
        }
    }

    public static void main(String[] args) {
        Point3D point1 = new Point3D(4, 8, 12);
        Point3D point2 = new Point3D(1, 5, 3);
        Point3D point3 = new Point3D(1, 5, 3);

        System.out.println(point2.distanceTo(point3));
        System.out.printf("%.2f", computeArea(point1, point2, point3));
    }
}

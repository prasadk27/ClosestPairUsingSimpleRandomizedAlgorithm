public class CP {

    private Point a;
    private Point b;
    private Double distance;

    public CP(Point a, Point b, Double distance) {
        this.a = a;
        this.b = b;
        this.distance = distance;
    }

    public Point getA() {
        return a;
    }

    public void setA(Point a) {
        this.a = a;
    }

    public Point getB() {
        return b;
    }

    public void setB(Point b) {
        this.b = b;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "The Closest Pair is: " + a + "," + b + "\n" + "distance is: " + distance;
    }
}
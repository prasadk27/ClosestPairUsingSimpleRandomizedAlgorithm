public class Box implements Comparable<Box>{

    private int x;
    private int y;

    public Box(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "("+x+","+y+")";
    }
    
    @Override
    public int hashCode() {
    	int result = x;
        result = 31 * result + y;
        return result;
    }

    @Override
    public int compareTo(Box o) {
    	if (this == o) return 1;
        if (o == null || getClass() != o.getClass()) return 0;

        Box box = (Box) o;

        if (x != box.x) return 0;
        if (y != box.y) return 0;

        return 1;
    	
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Box box = (Box) o;

        if (x != box.x) return false;
        if (y != box.y) return false;

        return true;
    }
}
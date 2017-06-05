import java.util.List;

public class BruteForce {
    /*
     * Brute Force methodology for Closest Pair problem. Time complexity is O(n2).
     */
    public static CP findCP(List<Point> points) {
        CP cP = new CP(points.get(0),points.get(1),Double.POSITIVE_INFINITY);
        int counter = 0;
        for(int i=0; i<points.size(); i++) {					//nested for loops
        	for(int j=0; j<points.size(); j++) {
                Point a = points.get(i);
                Point b = points.get(j);
                counter ++;
                if(!a.equals(b)) {
                    Double dist = FindClosestPair.EuclideanDistance(a, b);

                    if(dist < cP.getDistance()) {
                        cP.setDistance(dist);
                        cP.setA(a);
                        cP.setB(b);
                    }
                }
            }
        }
        System.out.println("Iteration counter in Brute Force is : " + counter);
        return cP;
        
    }
}
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;


public class Hash {
	static int counter = 0;
	/*
	 * Simple Randomized closest pair problem using Hashing. Time complexity is O(n)
	 */

	private static List<Point> random(List<Point> points) {
		Random random = new Random();      						//Function for random input
		for(int i=points.size()-1; i > 0; i--) {
			int j = random.nextInt(i+1);
			Collections.swap(points, i, j);
		}
		return points;
	}

	private static Box findGridBox(Point p, Double dist) {				//function to find out box indices of point.
		int xBox = (int) (p.getX()/Math.floor(dist));
		int yBox = (int) (p.getY()/Math.floor(dist));
		return new Box(xBox,yBox);
	}

	public static CP findCP(List<Point> points) {

		List<Point> RandomPoints = random(points);				//input of points in random order

		Double d = FindClosestPair.EuclideanDistance(RandomPoints.get(0), RandomPoints.get(1));  //distance between first two points
		CP cP = new CP(RandomPoints.get(0),RandomPoints.get(1),d);

		List<Point> currentPoints = new ArrayList<Point>();
		currentPoints.add(RandomPoints.get(0));
		currentPoints.add(RandomPoints.get(1));
		Map<Box,List<Point>> grid = BuildGrid(currentPoints,d);  //Build grid with distance of first two points (Algorithm Line 1) 

		for(int i=2; i<RandomPoints.size();i++) {					//Iterate through the list of points (Algorithm Line 2)
			Point currentPoint = RandomPoints.get(i);
			Box box = findGridBox(currentPoint,d);					//find grid box of current point.
			List<Box> Report = Neighbors(box);					//Report operation which will return list containing points in Grid box. 
			Report.add(box);										//(Algorithm Line 4)

			List<Point> adjacentPoints = new ArrayList<Point>();
			for(Box c : Report) {
				if(grid.containsKey(c)) {
					counter ++;
					adjacentPoints.addAll(grid.get(c));
				}
			}

			boolean distChanged = false;

			for(Point adjacentPoint : adjacentPoints) {					//Check if the minimum distance is changes. (Algorithm Line 5) 
				Double currentDist = FindClosestPair.EuclideanDistance(adjacentPoint, currentPoint);
				if(currentDist < d) {
					d = currentDist;
					distChanged = true;
					cP.setA(currentPoint);
					cP.setB(adjacentPoint);
					cP.setDistance(d);
				}
			}

			currentPoints.add(currentPoint);										

			if(distChanged) {
				grid = BuildGrid(currentPoints, d);			//if new distance is less than previous min distance, rebuild the grid. (Algorithm Line 7) 
			} else {
				if(grid.containsKey(box)) {
					List<Point> list = grid.get(box);
					list.add(currentPoint);						//else insert that point into the Grid.(Algorithm Line 6)
				}
				else {
					List<Point> list = new ArrayList<Point>();
					list.add(currentPoint);
					grid.put(box, list);						//if box is not present, hen add new box to the grid.
				}
			}
		}
		System.out.println("Iteration counter in Hashing is : " + counter );
		return cP;
	}

	private static Map<Box,List<Point>> BuildGrid(List<Point> points, Double dist) {		//function for Building new grid.
		Map<Box,List<Point>> grid = new HashMap<Box, List<Point>>();

		for(Point p : points) {
			Box box = findGridBox(p,dist);

			if(grid.containsKey(box)) {
				List<Point> list = grid.get(box);
				list.add(p);
			}
			else {
				List<Point> list = new ArrayList<Point>();
				list.add(p);
				grid.put(box, list);
			}
		}
		return grid;
	}

	private static List<Box> Neighbors(Box box) {					//function for finding 9 neighbors.
		Box box2 = new Box(box.getX()+1,box.getY());
		Box box3 = new Box(box.getX()+1,box.getY()-1);
		Box box4 = new Box(box.getX(),box.getY()-1);
		Box box5 = new Box(box.getX()-1,box.getY()-1);
		Box box6 = new Box(box.getX()-1,box.getY());
		Box box7 = new Box(box.getX()-1,box.getY()+1);
		Box box8 = new Box(box.getX(),box.getY()+1);
		Box box9 = new Box(box.getX()+1,box.getY()+1);

		return new ArrayList<Box>(Arrays.asList(box2,box3,box4,box5,box6,box7,box8,box9));
	}

}
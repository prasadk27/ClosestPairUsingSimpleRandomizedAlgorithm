import java.util.*;

public class FindClosestPair {
/*
 * This java file contains main function. This is a 2D implementation of the Closest Pair Problem using the Brute Force 
 * and the simple randomized algorithm using Balanced Search Tree and using Hashing as the underlying 
 * dictionary for holding box indices.
 * Project By: Prasad Khedekar and Sarthak Sheth
 */
	 public static Double EuclideanDistance(Point a, Point b) { 
	        double xPow = Math.pow(a.getX()-b.getX(),2); 	//this method is used to calculate Eclidean Distance between two points.
	        double yPow = Math.pow(a.getY()-b.getY(),2);
	        return Math.sqrt(xPow + yPow);
	    }

    public static void main(String[] args) {
        System.out.print("\n");
        System.out.println("********************Closest Pair Problem********************");
        List<Point> points = InputPoints.inputpoints();
        System.out.println("Brute Force");
        Long starttime = System.currentTimeMillis(); 				
        CP cP = BruteForce.findCP(points);							//For Brute Force
        Long endtime = System.currentTimeMillis();
        Long totaltime = endtime-starttime;
        System.out.println(cP);
        System.out.println("Time required in milliseconds is : " + totaltime);
        System.out.print("************************************************************\n");
        System.out.println("Balanced Binary Search Tree");
        starttime = System.currentTimeMillis();
        cP = BST.findCP(points);										//For BST				
        endtime = System.currentTimeMillis();
        totaltime = endtime-starttime;								
        System.out.println(cP);
        System.out.println("Time required in milliseconds is : " + totaltime);
        System.out.print("************************************************************\n");
        System.out.println("Hashing");
        starttime = System.currentTimeMillis();
        cP = Hash.findCP(points);									//For Hashing		
        endtime = System.currentTimeMillis();
        totaltime = endtime-starttime;
        System.out.println(cP);
        System.out.println("Time required in milliseconds is : " + totaltime);
        System.out.print("************************************************************");
    }

}
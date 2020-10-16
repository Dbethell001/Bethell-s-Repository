//CSCI 317 Agile & Efficient Computing
//DeAndre Bethell
//October 1st 2020

//imports packages;
import java.util.*;
import java.lang.Math;


// creates Dart Game;
public class DartGame 
{
 
 // Runs the dart game by implementing a random Generator
 public DartGame() 
 {
 }
 //Creates and returns a new HashMap
 public HashMap<Double, Double> randomGenerator(int size) 
 {
  int count = size;
  HashMap<Double, Double> pairs = new HashMap<Double, Double>();
  	while(count > 0) 
	{
  	Double x = (Math.random() * 1) - 0.5;
  	Double y = (Math.random() * 1) - 0.5;
  	pairs.put(x, y);
  	count--;
  	}
  return pairs;
 }
	
 // Computes the center Distance of the Dart Board
 public Double[] centerDistance(HashMap<Double, Double> pairs) 
 {
  Set<Double> keys = pairs.keySet();
  Double[] array = keys.toArray(new Double[keys.size()]);
  Double[] distance = new Double[keys.size()];
  	for(int i = 0; i <= pairs.size() - 1; i++) 
	{
   	Double x = array[i];
   	Double y = pairs.get(x);
   	Double d = Math.sqrt(x*x+y*y);
   	distance[i] = d;
  }
  return distance;
 }
	
 // Returns the points computed
 public double radiusCount(Double[] dis) 
 {
 double points = 0.0;
 for(int i = 0; i <= dis.length - 1; i++) 
	{
   if(dis[i] < 0.5) 
	{
    	points ++;
   	}
   else;
  }
  System.out.println(points);
  return points;
 }
	
 //Returns the standardDeviation
 public double standDev(Double[] dis) 
 {
  double sum = 0;
  double mean = 0;
  double standardDev = 0.0;
  
  for (int i = 0; i < dis.length; i++)
  {
   sum = sum + dis[i];
  }
  mean = sum / dis.length;
  
  for(int i = 0; i < dis.length; i++) 
  {
   standardDev += Math.pow((dis[i] - mean) * (dis[i] - mean), 2);
  }
  double standDeviation = Math.sqrt(standardDev);
  return standDeviation;
 }
	
// Main Method
 public static void main(String args[]) 
 {	 
  DartGame dartGame = new DartGame();
  int range = (5000) + 40000;
  int numGames = (int)(Math.random() * range);
  System.out.println("Number of Games: " + numGames);
  HashMap<Double, Double> pairs = dartGame.randomGenerator(numGames);
  Double[] distance = dartGame.centerDistance(pairs);
  double standardDeviation = dartGame.standDev(distance);
  System.out.println("Standard Deviation: " + standardDeviation);
  double radiusCount = dartGame.radiusCount(distance);
  double gamesPlayed = 4 * (radiusCount / pairs.size());
  System.out.println(gamesPlayed);
 }
}

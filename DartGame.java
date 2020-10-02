//CSCI 317 Agile & Efficient Computing
//DeAndre Bethell
//October 1st 2020

import java.util.*;
import java.lang.Math;

public class DartGame {
	 
	 public DartGame() {
	 }
	 
	 public HashMap<Double, Double> randomGen(int size) {
	  int counter = size;
	  HashMap<Double, Double> pairs = new HashMap<Double, Double>();
	  while(counter > 0) {
	  Double a = Math.random() * 8.875;
	  Double b = Math.random() * 8.875;
	  pairs.put(a, b);
	  counter --;
	  }
	   return pairs;
	  }
	  
	 
	 public Double[] centerDistance(HashMap<Double, Double> pairs) {
	  Set<Double> keys = pairs.keySet();
	  Double[] keyArray = keys.toArray(new Double[keys.size()]);
	  Double[] distance = new Double[keys.size()];
	  for(int i =0; i <= pairs.size()-1; i++) {
	   Double a = keyArray[i];
	   Double b = pairs.get(a);
	   Double c = Math.sqrt((a*a)+(b*b));
	   distance [i] = c;
	  }
	  
	  return distance;
	 }
	 
	  public double radiusCount(Double[] distance) {
	  double dartPoints = 0.0;
	  for(int i = 0; i <= distance.length - 1; i++) {
	   if(distance[i] < 8.875) {
	    dartPoints ++;
	   }
	   else;
	  }
	  System.out.println();
	  return dartPoints;
	 }
	  public double standDev(Double[] distance) {
		  double sum = 0;
		  double max = 0;
		  double min = distance[0];
		  double sd = 0.0;
		  for (int i = 0; i < distance.length; i++){
		  sum = sum + distance[i];
		  }
		  double average = sum / distance.length;
		  for(int i = 0; i < distance.length; i++) {
		  if(distance[i] > max) {
		  max = distance[i];
		  }
		  }
		  for (int i = 0; i <distance.length; i++) {
		  if(distance[i] < min) {
		  min = distance[i];
		  }
		  }
		  for(int i = 0; i < distance.length; i++) {
		  sd += Math.pow((distance[i] - average) / distance.length, 2);
		  }
		  double standDeviation = Math.sqrt(sd);
		  return standDeviation;
		  } 
// Main method
	 public static void main(String args[]) {
	  
	  DartGame game = new DartGame();
	  int dartGame = (int)(Math.random()* 20)+1;
	  System.out.println("Number of games: "  + dartGame);
	  HashMap<Double, Double> pairs = game.randomGen(dartGame);
	  Double[] distance = game.centerDistance(pairs);
	  double radCount = game.radiusCount(distance);
	  double attempt = 4 * (radCount / (pairs.size()));
	  System.out.println(attempt);
	  
	 }
	}



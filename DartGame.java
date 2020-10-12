//CSCI 317 Agile & Efficient Computing
//DeAndre Bethell
//October 1st 2020

import java.lang.Math;

public class DartGame {
	 
	 public DartGame() {
	 }
	 
	 public Double [][] randomGen(int size){
		  int count = size;
		  Double[][] pairs = new Double[size][size * 2];
		  for(int i = 0; i < count; i++){
			 for(int j = 0; j < count; j++) {
				  Double x = Math.random() * 0.5;
				  Double y = Math.random() * 0.5;
				  pairs[i][j] = x;
				  j++;
				  pairs[i][j] = y;
			 }
		  }
		  return pairs;
	 }
	  
	 
	 public Double[] centerDistance(Double [][] pairs) {
	  Double[] distance = new Double[pairs.length];
	  for(int i =0; i <= pairs.length-1; i++) {
		  for(int j = 0; j < (pairs.length-1) * 2; j++) {
			   Double x = pairs[i][j];
			   j++;
			   Double y = pairs[i][j];
			   Double z = Math.sqrt((x*x)+(y*y));
			   distance [i] = z;
		  }
	  }
	  
	  return distance;
	 }
	 
	  public double radiusCount(Double[] distance) {
	  double dartPoints = 0.0;
	  for(int i = 0; i <= distance.length - 1; i++) {
	   if(distance[i] < 0.5) {
	    dartPoints ++;
	   }
	   else;
	  }
	  System.out.println();
	  return dartPoints;
	 }
	  public double standDev(Double[] distance) {
		  double sum = 0.0;
		  double mean = 0.0;
		  double min = distance[0];
		  double sd = 0.0;
		  
		  for (int i = 0; i < distance.length; i++){
		  sum = sum + distance[i];
		  }
		  mean = sum / distance.length;
		  
		  for(int i = 0; i < distance.length; i++) {
		  sd += Math.pow(distance[i] - mean, sd) *(distance[i] - mean) / distance.length;
		  }
		  double standDeviation = Math.sqrt(sd);
		 System.out.println("Standard Deviation" + standDeviation);
		  return standDeviation;
		  } 
// Main method
	 public static void main(String args[]) {
	  
	  DartGame game = new DartGame();
	  int dartGame = (int) ((Math.random()* 500)+1.0);
	  System.out.println("Number of games: "  + dartGame);
	  Double [][] pairs = game.randomGen(dartGame);
	  Double[] distance = game.centerDistance(pairs);
	  double radCount = game.radiusCount(distance);
	  double attempt = 4 * (radCount / pairs.length);
	  System.out.println(attempt);
	  
	 }
}

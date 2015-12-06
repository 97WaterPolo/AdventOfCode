package us.siglerdev.sigler;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Day6 {
	private static int[][] array;
	private static int SIZE = 1000;
	public static void main(String[] args) throws IOException{
		File f = new File("Data"+File.separator + "Day6"+ File.separator + "lights.txt");
		List<String> values = Files.readAllLines(Paths.get(f.toURI()));	
		array = new int[SIZE][SIZE];
		//turn on 606,361 through 892,600
		//turn off 448,208 through 645,684
		//toggle 50,472 through 452,788
		int x =0;
		for (String s : values){
			String temp = s;
			temp = temp.replace(" ","");
			String[] points = temp.split("through");
			if (s.contains("on")){
				points[0] = points[0].substring(6);
				turnOn(translate(points[0]), translate(points[1]));
			}else if (s.contains("off")){
				points[0] = points[0].substring(7);
				turnOff(translate(points[0]), translate(points[1]));
			}else if (s.contains("toggle")){
				points[0] = points[0].substring(6);
				toggle(translate(points[0]), translate(points[1]));
			}
			if (x < 10){
				System.out.println("VAL: " + s + "  Final: " + points[0] + "  " + points[1] + " Total: " + countLights());
			}
			x++;
		}
		//toggle(new int[]{2,2}, new int[]{7,5});
		for (int j = 0; j < 8; j++){
			for (int k = 0; k < 8; k++){
				System.out.print("("+j+","+k+")"+array[j][k] + " - ");
			}
			System.out.println("");
		}
		System.out.println("The total is: " + countLights());
	}

	// (499, 499) (500,500)
	private static void toggle(int[] a1, int[] a2){
		for (int x = a1[0]; x <= a2[0]; x++)
			for (int y = a1[1]; y <= a2[1];y++){
				int val = array[x][y];
				if (val == 0)
					array[x][y] = 1;
				else
					array[x][y] = 0;
			}
	}

	private static void turnOff(int[] a1, int[] a2){
		for (int x = a1[0]; x <= a2[0]; x++)
			for (int y = a1[1]; y <= a2[1];y++){
				array[x][y] = 0;
			}
	}

	private static void turnOn(int[] a1, int[] a2){
		for (int x = a1[0]; x <= a2[0]; x++)
			for (int y = a1[1]; y <= a2[1];y++){
				array[x][y] = 1;
			}
	}

	private static int countLights(){
		int count = 0;
		for (int i =0; i < SIZE; i++)
			for (int j = 0; j < SIZE; j++)
				if (array[i][j] == 1)
					count++;
		return count;
	}
	
	private static int[] translate(String value){
		int[] array = new int[2];
		array[0] = Integer.parseInt(value.split(",")[0]);
		array[1] = Integer.parseInt(value.split(",")[1]);
		return array;
	}
}

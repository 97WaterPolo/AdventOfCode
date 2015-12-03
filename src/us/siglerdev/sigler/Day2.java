package us.siglerdev.sigler;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Day2 {
	//L W H
	// 2*l*w + 2*w*h + 2*h*l
	public static void main(String[] args) throws IOException{
		File f = new File("Data"+File.separator + "Day2"+ File.separator + "dimensions.txt");
		List<String> values = Files.readAllLines(Paths.get(f.toURI()));
		int totalSquareFeet = 0;
		for (String s : values){
			int[] a = convertTo(s.split("x"));
			int base = (2*a[0]*a[1]) + (2*a[1]*a[2]) + (2*a[2]*a[0]);
			int extra = getProductOfLowest(a);
			totalSquareFeet+= base+extra;
		}
		System.out.println("The total square feet needed is: " + totalSquareFeet);
	}
	
	private static int[] convertTo(String[] array){
		int[] a = new int[array.length];
		for (int x = 0; x < array.length; x++){
			a[x] = Integer.valueOf(array[x]);
		}
		return a;
	}
	private static int getProductOfLowest(int[] a){
		Arrays.sort(a);
		return (a[0]*a[1]);
	}
}

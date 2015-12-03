package us.siglerdev.sigler;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Day1 {
	public static void main(String[] args) throws IOException{
		File f = new File("Data"+File.separator + "Day1"+ File.separator + "floors.txt");
		List<String> floors = Files.readAllLines(Paths.get(f.toURI()));
		int currentFloor = 0, up = 0, down = 0;
		for (String s : floors){
			for (int x = 0; x < s.length(); x++){
				char c = s.charAt(x);
				if (c == '('){
					currentFloor++;
					up++;
				}
				else if (c ==')'){
					currentFloor--;
					down++;
				}
					
			}
		}
		System.out.println("Santa went up " + up + " and went down " + down + " times!");
		System.out.println("Santa's final floor is: " + currentFloor);
	}
 }
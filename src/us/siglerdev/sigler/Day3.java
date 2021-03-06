package us.siglerdev.sigler;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Day3 {
	public static void main (String[] args) throws IOException{
		long startTime = System.currentTimeMillis();
		File f = new File("Data"+File.separator + "Day3"+ File.separator + "directions.txt");
		List<String> values = Files.readAllLines(Paths.get(f.toURI()));
		List<String> usedValues = new ArrayList<>();
		int x =0, y = 0;
		usedValues.add(""+x+"-"+y);
		for (String s : values){
			for (int i= 0; i < s.length(); i++){
				char c = s.charAt(i);
				if (c =='^')
					y++;
				else if (c == '<')
					x--;
				else if (c == '>')
					x++;
				else if (c == 'v' || c == 'V')
					y--;
				updateList(usedValues, x, y);
			}
		}
		System.out.println("Santa Visited a total of " + usedValues.size() + " unique houses");
		long endTime = System.currentTimeMillis();
		System.out.println("Start: " + startTime + "  End: " + endTime + "  Diff: " + (endTime-startTime) + " or " + (endTime-startTime)/1000D);
	}
	
	private static void updateList(List<String> list, int x, int y){
		if (!list.contains(""+x+"-"+y))
			list.add(""+x+"-"+y);
	}
}

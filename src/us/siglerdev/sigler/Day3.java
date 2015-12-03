package us.siglerdev.sigler;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Day3 {
	public static void main (String[] args) throws IOException{
		File f = new File("Data"+File.separator + "Day3"+ File.separator + "directions.txt");
		List<String> values = Files.readAllLines(Paths.get(f.toURI()));
		List<String> usedValues = new ArrayList<>();
		int x =0, y = 0;
		usedValues.add(""+x+"-"+y);
		for (String s : values){
			for (int i= 0; i < s.length(); i++){
				char c = s.charAt(i);
				if (c =='^'){
					x++;
					if (!usedValues.contains(""+x+"-"+y))
						usedValues.add(""+x+"-"+y);
				}else if (c == '<'){
					y--;
					if (!usedValues.contains(""+x+"-"+y))
						usedValues.add(""+x+"-"+y);
				}else if (c == '>'){
					y++;
					if (!usedValues.contains(""+x+"-"+y))
						usedValues.add(""+x+"-"+y);
				}else if (c == 'v' || c == 'V'){
					x--;
					if (!usedValues.contains(""+x+"-"+y))
						usedValues.add(""+x+"-"+y);
				}
			}
		}
		System.out.println("Santa Visited a total of " + usedValues.size() + " unique houses");
	}
}

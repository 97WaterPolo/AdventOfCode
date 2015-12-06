package us.siglerdev.sigler;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Day5 {
	public static String[] badWords = new String[]{"ab","cd","pq","xy"};
	public static void main(String[] args) throws IOException{
		File f = new File("Data"+File.separator + "Day5"+ File.separator + "persons.txt");
		List<String> values = Files.readAllLines(Paths.get(f.toURI()));	
		int goodPeople = 0;
		for (String s : values){
			boolean vowels = false, doubleLetter = false, notContain = false;
			vowels = checkVowels(s);
			doubleLetter = checkDoubleLetter(s);
			notContain = checkNotContains(s);
			if (vowels && doubleLetter && notContain)
				goodPeople++;
		}
		System.out.println("The total number of good kids is " + goodPeople);
	}
	
	private static boolean checkNotContains(String s){
		for (String badWord : badWords)
			if (s.contains(badWord))
				return false;
		return true;
	}
	
	private static boolean checkDoubleLetter(String s){
		for (int i = 0; i < s.length()-1; i++){
			if (s.charAt(i) == s.charAt(i+1))
				return true;
		}
		return false;
	}
	
	private static boolean checkVowels(String s){
		int x = 0;
		for (int i = 0; i < s.length(); i++){
			if (isVowel(s.charAt(i)))
				x++;
		}
		return (x >= 3);
	}
	
	private static boolean isVowel(char c){
		switch (Character.toLowerCase(c)) {
		  case 'a':
		  case 'e':
		  case 'i':
		  case 'o':
		  case 'u': return true;
		  default: return false;
		}
	}
}

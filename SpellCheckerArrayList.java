import java.io.*;
import java.util.*;

public class SpellCheckerArrayList {
    
	public static void main(String[] args) throws IOException {
        
		BufferedReader inputStream = null;
		String lineRead;
        ArrayList<String> dictionary = new ArrayList<String>();
        Scanner keyboard = new Scanner(System.in);
        String word = null;
        boolean match = false;
        
		try {
		    inputStream = new BufferedReader(new FileReader("dictionary.txt"));
			lineRead = inputStream.readLine();
       
			while (lineRead != null) {
				dictionary.add(lineRead);
           		lineRead = inputStream.readLine();
			}
			
			System.out.println("Please enter a sentence");
			StringTokenizer words = new StringTokenizer(keyboard.nextLine());
			
			while (words.hasMoreTokens()) {
				
				word = words.nextToken().toLowerCase();
				match = false;
				
				for (int i = 0; i < dictionary.size(); i++)
					if (word.equals(dictionary.get(i))) {
						match = true;
						break;
					}
				
				if (match == false)
					System.out.println(word + " does not exist in the dictionary!");
				
			}
		}

		catch (FileNotFoundException exception) {
			System.out.println("Error opening file");
		}

		finally {		
			if (inputStream != null)
				inputStream.close();
		}
	}
}

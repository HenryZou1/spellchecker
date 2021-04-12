import java.io.*;
import java.util.*;

public class SpellCheckerArray {
        
    public static void main(String[] args) throws IOException {
        
        BufferedReader inputStream = null;
        String[] dictionary = new String[118619];
        Scanner keyboard = new Scanner(System.in);
                
		try {     	
			inputStream = new BufferedReader(new FileReader("dictionary.txt"));
						
			for (int i = 0; i < dictionary.length; i++)
				dictionary[i] = inputStream.readLine();
           	          		
			System.out.println("Please enter a sentence!");
			StringTokenizer words = new StringTokenizer(keyboard.nextLine());
     		boolean found = false;
     		String word = "";
     		
     		while (words.hasMoreTokens()) {
         		
         		word = words.nextToken();
         		
         		for (int i = 0; i < dictionary.length; i++) {	
         			found = false;
         			
         			if (dictionary[i].equals(word)) {
         				found = true;
         				break;
         			}
         		}
         		
         		if (found == false)
					System.out.println(word + " does not exist in our dictionary.");
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

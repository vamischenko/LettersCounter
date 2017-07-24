package counter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class LettersCounterMain {
	
	private static final char[] vowels = {'A','a','E','e','I','i','O','o','U','u','Y','y'};
	
    private static String readString() throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String str = br.readLine();
		return str;
	}
    
    private static Map<Character, Integer> getVowelsMap(String str) {
    	
		Map<Character, Integer> vowelsMap = new HashMap<>();
		for(int i = 0; i < vowels.length; i++){
			vowelsMap.put(vowels[i], 0);
		}
		for(int j = 0; j < str.length(); j++){
			Character key = str.charAt(j);
			if(vowelsMap.containsKey(key)){
				vowelsMap.put(key, vowelsMap.get(key) + 1);
			}
		}
		return vowelsMap;
	}
    
    private static Integer vowelsCount(Map<Character, Integer> vowelsMap){
    	
    	Integer vowelsCount = 0;
    	Collection<Integer> mapValues = vowelsMap.values(); 
    	Iterator<Integer> iter = mapValues.iterator();
    	while(iter.hasNext()){
    		vowelsCount += iter.next();
    	}
    	return vowelsCount;
    }

	public static void main(String[] args) throws IOException {
		
		System.out.println("Input string:");
	    String str = readString();
	    System.out.println("Vowels count:");
	    Map<Character, Integer> vowelsMap = getVowelsMap(str);
        System.out.println(vowelsCount(vowelsMap));
        System.out.println("Letter|count");
        for(int i = 0; i < vowels.length; i = i + 2){
        	Integer count = vowelsMap.get(vowels[i]) + vowelsMap.get(vowels[i+1]);
        	if(count > 0){
        		System.out.println(vowels[i+1] + "     |" + count);
        	}
        }
	}

}

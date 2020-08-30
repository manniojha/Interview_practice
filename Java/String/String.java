package DataStructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Stringss {
	
	//1. Reverse a String 
	public String reverseString(String str1) {
		/*char[] str = str1.toCharArray();
		StringBuffer sb = new StringBuffer();
		for(int j=(str.length)-1;j>=0;j--) {
			sb.append(str[j]);
		}
		System.out.println(sb);*/
		if(str1.length()<2) {
			 return str1;
		}
		return reverseString(str1.substring(1)) + str1.charAt(0);
	}
	//2.Print duplicate characters from a string 
	public void duplicateCharacter(String str) {
		char[] characters = str.toCharArray();
		
		Map<Character, Integer> charMap = new HashMap<Character, Integer>();	
		for(char ch : characters) {
			if(charMap.containsKey(ch)) {
				charMap.put(ch,charMap.get(ch)+1);
			} else {
				charMap.put(ch, 1);
			}
		}
		Set<Map.Entry<Character, Integer>> entryset = charMap.entrySet();
		System.out.println("List of Duplicates characters are");
		for(Map.Entry<Character,Integer> entry : entryset) {
			if(entry.getValue() > 1) {
				System.out.println(entry.getKey() + " --- " + entry.getValue());
			}
		}
	}
	
	//3.String Anagram Checker
	//Complexity time O(n) and space = O(nlogn)
	public void anagramChecker(String str1, String str2) {
	/*	char[] character1 = str1.toCharArray();
		char[] character2 = str2.toCharArray();
		Arrays.sort(character1);
		Arrays.sort(character2);
		if(Arrays.equals(character1, character2)) {
			System.out.println("Anagram");
		} else {
			System.out.println("Not Anagram");
		}
	*/	
		if(str1.length() != str2.length()) {
			System.out.println("FALSE");
		} else {
			char[] character1 = str1.toCharArray();
			char[] character2 = str2.toCharArray();
			int count[] = new int[256]; Arrays.fill(count,0);
			for(int i=0;i<str1.length();i++) {
				count[character1[i]]++;
				count[character2[i]]--;
				}
			for(int i=0;i<256;i++) {
				if(count[i] != 0) {
					System.out.println("Not Anagram");
				}
				}
			System.out.println("Anagram");
			  }
	}
	//4.Finding Permutation of String
	public void StringPermutation(String perm , String str) {
		if(str.isEmpty()) {
			System.err.println(perm + str);
		} else {
			for(int i=0;i<=str.length()-1;i++) {
				StringPermutation(perm + str.charAt(i),str.substring(0,i)+str.substring(i+1));
			}
		}
	}
	public List<List<Integer>> permuteArr(int[] nums){
		List<List<Integer>> results = new ArrayList<>();
		permutations(nums,0,results);
		return results;
	}
	private void permutations(int[] nums,int start,List<List<Integer>> results) {
		if(start>=nums.length) {
			results.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
			System.out.println(results);
		}else {
			for(int i=start;i<nums.length;i++) {
				System.out.println("i::"+i+":::start::"+start);
				swap(nums,i,start);
				print(nums);
				permutations(nums, start+1, results);
				print(nums);
				swap(nums, i,start);
				print(nums);
			}
		}
	}
	private void print(int[] nums) {
		for(int i : nums) {
			System.out.print(i + " ");
		}
	}
	private void swap(int[] nums,int i,int j) {
		int temp = nums[i];
		nums[i]=nums[j];
		nums[j]=temp;
	}
	//5.Regular Expression to check number in String
	public void numberStringChecker(String str) {
		Pattern pattern = Pattern.compile(".*[0-9].*"); 
		Pattern pattern1 = Pattern.compile("\\d{6}");
		System.out.println(pattern1.matcher(str).matches());
	}
	//6.Vowel Consonants Counter in a string
	public void vCCounter(String str1) {
		char[] str = str1.toCharArray();
		int vowel = 0;
		StringBuffer sbvowel = new StringBuffer();
		StringBuilder sbconsonats = new StringBuilder();
		for(char ch:str) {
			if(ch=='a'|| ch=='e'|| ch=='i'|| ch=='o'|| ch=='u'|| ch=='A'|| ch=='E'|| ch=='I'|| ch=='O'|| ch=='U') {
				vowel++;
				sbvowel.append(ch);
			}
			else {
				sbconsonats.append(ch);
			}
		}
		int consonants = (str.length-1)-vowel;
		System.out.println("No of Vowels are " + vowel + " and No of consonats are " + consonants );
		System.out.println(sbvowel + " - " + sbconsonats);
	}
	//7.Reverse words in a string
	public void reverseWordInALetter(String str1) {
		String[] str = str1.split(" ");	
		StringBuffer sb = new StringBuffer();
		for(int j=(str.length)-1;j>=0;j--) {
			sb.append(str[j]);
			sb.append(" ");
		}
		System.out.println(sb.toString().trim());
	}
	//8.Checking if 2 strings are Rotation of each Other
	public void rotationCheckerOfString(String original , String rotated) {
		String concated = original + original;
		if(concated.indexOf(rotated) != -1) {
			System.out.println("Matched");
		}else {
			System.out.println("Not Matched");
		}
	}
	//9.Replace Character in a String
	//System.out.println(str.replace(orgch, newch));
	//10.Maximum Occuring Character in a String
	public void MaximumOccuringCharInString(String str) {
		char[] strr = str.toCharArray();
		Map<Character,Integer> charmap = new HashMap<Character, Integer>();
		for(char ch: strr) {
			if(charmap.containsKey(ch)) {
				charmap.put(ch,charmap.get(ch)+1);
			} else {
				charmap.put(ch,1);
			}
		}
		Set<Map.Entry<Character,Integer>> entrybucket = charmap.entrySet();
		int max = 0;
		char c = ' ';
		for(Map.Entry<Character,Integer> entry : entrybucket) {
			if(entry.getValue() > max) {
				max = entry.getValue();
			    c = entry.getKey();
			}
		}
		System.out.println(c + " -> " + max);
	}
	//11.Remove Duplicate Character in a String
	public void RemoveDuplicateInString(String str1) {
		char[] str = str1.toCharArray();
		Map<Character,Integer> charmap = new LinkedHashMap<Character, Integer>();
		for(char ch: str) {
			if(!charmap.containsKey(ch)) {
				charmap.put(ch,1);
			}
		}
		Set<Map.Entry<Character,Integer>> entrybucket = charmap.entrySet();
		StringBuilder sbb = new StringBuilder();
		for(Map.Entry<Character,Integer> entry : entrybucket) {
			sbb.append(entry.getKey());
		}
		System.out.println(sbb);
	}
	
	//12.Longest Pallandrome SubString and its length in a String
	public void PallandromeSubStringAndLength(String str){
		int max_length = 1;
		int start = 0;
		int len = str.length();
		int low,high;
		for(int i=1;i<len;i++) {
			low = i-1;
			high=i;
			while(low>=0 && high< len && str.charAt(low) == str.charAt(high)) {
				if(high - low +1 > max_length) {
					start = low;
					max_length = high - low + 1;
				}
				--low;
				++high;
			}
			low = i-1;
			high = i+1;
			while(low>=0 && high< len && str.charAt(low) == str.charAt(high)) {
				if(high - low + 1 > max_length) {
					start = low;
					max_length = high - low + 1;
				}
				--low;
				++high;
			}
		}
		System.out.println(str.substring(start, start+max_length));
	}
	//13.Input = "geeksforgeeks" Output = "gksforgks";
	public void removeConsecutiveString(String str1) {
		char[] str = str1.toCharArray();
		StringBuffer sb = new StringBuffer();
		int i=0;
		for(;i<str.length-1;i++) {
			if(str[i] != str[i+1]) {
				sb.append(str[i]);
			}else {
				while(str[i] == str[i+1]) {
					i++;
				}
			}
		}
		sb.append(str[i]);
		System.out.print(sb);
	}
	//14.Panagram checking
	public void PanagramChecking(String str) {
		System.out.println(str.toLowerCase().trim());
		String str1 = str.replaceAll("\\s+",""); 
		char[] str2 = str1.toLowerCase().toCharArray();
		int[] count = new int[26];
		for(char ch:str2) {
			count[ch-97]++;
		}
		for(int i=0; i<count.length;i++) {
			if(count[i] == 0 ) {
				System.out.print((char)((char)i+97) + "->");
			}
		}
	}
	//15.remove punctions of every kind
	public void punctionsRemoveral(String str) {
		String str1 = str.replaceAll("\\p{Punct}", "");
		System.out.println(str1);
	}
	//16.Print First letter of a word in caps
	public void FirstLetter(String str) {
		System.out.print(Character.toUpperCase(str.charAt(0)));
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i) == ' ') {
				System.out.print("->" + Character.toUpperCase(str.charAt(i+1)));
			}
		}
		
	}
	//17.Encryption by a given String
	public void encrypt(String key,String plain) {
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<plain.length();i++) {
			char plainStr = plain.charAt(i);
			int ascii = (int)plainStr;
			ascii -= 97;
			sb.append(key.charAt(ascii));
		}
		System.out.println(sb);
	}
	//18.Swap first and last character of a word in a sentence 
	public void swapLetterOfWordInSentence(String str1) {
		char[] str = str1.toCharArray();
		int i,j;
		i=j=0;
		for(;i<=str.length-1;i++) {
			if(str[i]==' ') {
				char temp = str[j];
				str[j] = str[i-1];
				str[i-1] = temp;
				j=i+1;
			}
		}
		str.toString();
		System.out.println(str);
	}
	//19.American Express Question : ccddffbbecee : ans 6
	public void countDistinct(String str1) {
		char[] str = str1.toCharArray();
		Map<Character,Integer> map = new HashMap<Character,Integer>();
		for(char ch: str) {
			if(map.containsKey(ch)) {
				map.put(ch,map.get(ch)+1);
			} else {
				map.put(ch,1);
			}
		} 
		ArrayList<Integer> al = new ArrayList<Integer>();
		 int result = 0;
		 Set<Map.Entry<Character,Integer>> entrybucket = map.entrySet();
		 for(Map.Entry<Character,Integer> entry : entrybucket) {
			 if(!al.contains(entry.getValue())) {
				 al.add(entry.getValue());
			 } else {
				 int data = entry.getValue();
				 while(al.contains(data)) {
					 data--;
					 result++;
				 }
				 if(data>0) {
					 al.add(data);
				 }
			 }
		 }
		 System.out.println(result);
	}
	//20.Longest distinct substring in a string
	public void longestDistinctSubStringInAString(String str) {
		Set<Character> st = new HashSet<Character>();
		int i,j,max_count;
		i=j=max_count= 0;
		while(j<str.length()) {
			if(!st.contains(str.charAt(j))) {
				st.add(str.charAt(j));
				j++;
				max_count = Math.max(max_count,j-i);
			} else {
				st.remove(str.charAt(i));
				i++;
			}
		}
		System.out.println(max_count);
	}
	//21.longest common prefix in a string
	public void longestCommonPrefix(String[] arr) {
		String prefix = arr[0];
		for(int i=1;i<arr.length-1;i++) {
			while(arr[i].indexOf(prefix) != 0) {
				System.out.println(prefix);
				prefix = prefix.substring(0,prefix.length()-1);
			}
		}
		System.out.println(prefix);
	}
	//22.Most Frequent Word In An Array
	public void mostFrequentWordInAString(String str1) {
		Map<String,Integer> map = new LinkedHashMap<String, Integer>();
		String[] str = str1.split(" ");
		for(int i=0;i<str.length;i++) {
			if(map.containsKey(str[i])) {
				map.put(str[i],map.get(str[i])+1);
			}else {
				map.put(str[i],1);
			}
		}
		int max = 0;
		String sb = new String();
		Set<Map.Entry<String,Integer>> entrybucket = map.entrySet();
		for(Map.Entry<String,Integer> entry: entrybucket) {
			if(max<=entry.getValue()) {
				max=entry.getValue();
				sb=entry.getKey();
			}		
		}
		System.out.println(sb + ":" + max);
		
	}
	//23.Second most repeated string in a sequence
	public void secondMostRepeatedSring(String str) {
		String[] strarr = str.split(" ");
		Map<String,Integer> map = new HashMap<String,Integer>();
		for(String st : strarr) {
			if(map.containsKey(st)) {
				map.put(st,map.get(st)+1);
			} else {
				map.put(st,1);
			}
		}
		int max,max2;
		max = max2 = 0;
		String sb = new String();
		Set<Map.Entry<String,Integer>> entrybucket = map.entrySet();
		for(Map.Entry<String,Integer> entry : entrybucket) {
			if(max<entry.getValue()) {
				max2 = max;
				max = entry.getValue();
			} else if(entry.getValue()>max2) {
				max2 = entry.getValue();
				sb = entry.getKey();
			}
		}
		System.out.println(max2 + ":" + sb);
	}
	//24.String Ignorance
	public void stringIgnorance(String str1) {
		char[] str = str1.toCharArray();
		Set<Character> st = new HashSet<Character>();
		StringBuffer sb = new StringBuffer();
		for(char ch:str) {
			if(st.contains(ch)) {
				st.remove(ch);
			} else {
				st.add(ch);
				sb.append(ch);
			}
		}
		System.out.println(sb);
	}
	//25.Remove Common Character from both String and Concatenate
	public void removeCommonAndConcatenate(String str1 , String str2) {
		Set<Character> al = new LinkedHashSet<Character>();
		for(int i=0;i<str1.length();i++) {
			if(!al.contains(str1.charAt(i))) {
				al.add(str1.charAt(i));
			}
		}
		for(int i=0;i<str2.length();i++) {
			if(al.contains(str2.charAt(i))) {
				al.remove(str2.charAt(i));
			} else {
				al.add(str2.charAt(i));
			}
		}
		System.out.println(al);
		/*for(int i=0;i<str1.length() || i<str2.length();i++) {
			if(str2.indexOf(""+str1.charAt(i))>0){
				str2 = str2.substring(0,i)+str2.substring(i+1);
				str1 = str1.substring(0,i)+str2.substring(i+1);
			}
		}
		System.out.println(str1 + ":" + str2);*/
	}
	//26.Alphabetically Sorting
	/*
	 *i/p=== Hi Hello HelloWorld HiTech HiGeek HiTechWorld HiTechCity HiTechLab
	 *o/p=== Hello HelloWorld Hi HiGeek HiTech HiTechCity HiTechLab HiTechWorld*/
	public void alphabeticallySorting(String s) {
		String[] str = s.split(" ");
		for(int i=0;i<str.length;i++) {
			for(int j=i+1;j<str.length;j++) {
				if(str[i].compareTo(str[j])>0) {
					String temp = str[i];
					str[i] = str[j];
					str[j] = temp;
				}	
			}
		}
		for(String sr : str) {
			System.out.print(sr + "->");
		}
	}
	 //27.sort an string of array length wise
	//example : ['apple' , 'banana' , 'cat' , 'dog'] = ['cat','dog','apple','banana']
	public void stringSortLengthWise(String[] arr) {
		for(int i=0;i<arr.length;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(arr[i].length()>arr[j].length()) {
					String temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		for(String st:arr) {
			System.out.print(st+"->");
		}
	}
	public void backSpaceAndNextLine() {
		String str = "This is the main\b\b\nThis is next line\b\b\b\nThis is something\b\b";
		StringBuffer sb = new StringBuffer();
		int j = 0;
		while(j<=str.length()-1) {
			if(str.charAt(j)=='\b') {
				int index = sb.length();
				sb = sb.delete(index-1,index);
				j++; continue;
				} else if(str.charAt(j)=='\n') {
					System.out.println(sb);
					sb = new StringBuffer();
				j++;continue;
				}
				sb.append(str.charAt(j));
			    j++;	
		}
		System.out.println(sb);
	}
	public void ComapreVersionCheck(String s1 ,String s2) {
		
	}
	//28.Part of a String Containing all the character of a given String
	public void stringPartContainer(String str, String target) {
		//char[] str = str1.toCharArray();
		int i,j,z;
		i=j=z=0;
		while(j<str.length() && z<target.length()) {
			if(str.charAt(j) == target.charAt(z)) {
				j++;
				z++;
			} else {
				i=j;
				j++;
			}
		}
		System.out.println(str.substring(i,j));
	}
	//30.Rearrange characters in a string such that no two adjacent are same - Amazon Interview
	/*Input: aaabc 
      Output: abaca
      Input: aa 
      Output: Not Possible
     */
	public void rearrangeChar(String str1) {
		char[] str = str1.toCharArray();
		
	}
}





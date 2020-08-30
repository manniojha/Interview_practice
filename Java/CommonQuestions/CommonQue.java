 package competativeprograming;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.prefs.BackingStoreException;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
public class CommonQue {
		
	//1.Integer to Roman Number
		public void intToRoman(int num) {
			String[] numericals = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
			int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
			StringBuffer sb = new StringBuffer();
			if( num > 3999 || num < 1) throw new IllegalArgumentException();
			int i=0;
			while(num>0 && i<values.length) {
				if(num - values[i] >= 0) {
					sb.append(numericals[i]);
					num = num - values[i];
				}else {
					i++;	
				}
			}
			System.out.println(sb);
		}
		public void romanToInt(String s) {
			String[] numericals = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
			int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
			int[] num = new int[s.length()];
			for(int i = 0;i<s.length();i++) {
				switch(s.charAt(i)) {
				case 'M' : num[i] = 1000;break;
				case 'D' : num[i] = 500;break;
				case 'C' : num[i] = 100;break;
				case 'L' : num[i] = 50;break;
				case 'X' : num[i] = 10;break;
				case 'V' : num[i] = 5;break;
				case 'I' : num[i] = 1;break;
				}
				i++;
			}
			int sum = 0;
			for(int i = 0;i<=num.length-1;i++){ {
				if(num[i]<num[i+1]) {
					sum -= num[i];
				}else {
					sum+= num[i];
				}
			}
		}
			System.out.println(sum);
	}
		//2.given sum
		 public int[] twoSum(int[] nums, int target) {
			 Map<Integer,Integer> map = new HashMap<Integer, Integer>();
			 for(int i=0;i<nums.length;i++) {
				 int complement = target - nums[i];
				 if(map.containsKey(complement)) {
					 return new int[] { map.get(complement) , i };
					 }
				 map.put(nums[i],i);
				 }
			 return null;
		 }
	//3.Coin Change problem condition no of ways you can make change of a given amount
		public void coinChange1(int[] coins , int amt) {
			int[] ways = new int[amt+1];
			ways[0] = 1;
			for(int i=0;i<coins.length;i++) {
				for(int j=0;j<amt;j++) {
					if(j>= coins[i]) {
						ways[j] = ways[j] + ways[j-coins[i]];
					} 
				}
			}
			System.out.println(ways[amt] > amt ? -1 : ways[amt-1]) ;
		}
		//minimum number of coins to give a required sum
		public void coinChange2(int[] coins , int sum) {
			int[] dp = new int[sum+1];
			Arrays.fill(dp,sum+1);
			dp[0] = 0;
			for(int i=0;i<=sum;i++) {
				for(int j=0;j<coins.length;j++) {
					if(i>=coins[j]) {
						dp[i] = Math.min(dp[i],1+dp[i-coins[j]]);
					}
				}
			}
			for(int elem : dp) {
				System.out.print(elem + "-");
			}
			System.out.println();
			System.out.println(dp[sum] > sum ? -1 : dp[sum]);
		}
		//4.Valid Parenthesis
		public void isValidParenthesis(String s) {
			Stack<Character> stk = new Stack<Character>();
			for(char el : s.toCharArray()) {
				if( el == '{' || el == '[' || el == '('  ) {
					stk.push(el);
				} else if( el == ')' && !stk.isEmpty() && stk.peek() == '(') {
					stk.pop();
				} else if( el == ']' && !stk.isEmpty() && stk.peek() == '[') {
					stk.pop();
				} else if( el == '}' && !stk.isEmpty() && stk.peek() == '{') {
					stk.pop();
				} else {
					System.out.println("Not valid Parenthesis");
				}
			}
			System.out.println(stk.isEmpty());
		}
		private void backtracking(int left,int right,String current,List<String> result) {
			if(left==0 && right==0) {
				result.add(current);
				return;
				}
			if(left>0) {
				backtracking(left-1, right, current+"(", result);
			}
			if(right>0 && right>left) {
				backtracking(left, right-1, current+")", result);
			}
		}
		public void generateParenthesis(int n) {
			List<String> result = new ArrayList<String>();
			if(n==0) {
				throw new IllegalArgumentException();
			}
			backtracking(n,n,"",result);
			System.out.println(result);
		}
		//5.kth largest element in a array
		public void kthLargestElement(int[] arr , int k) {
			PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
			for(int elem : arr) {
				minHeap.add(elem);
				if(minHeap.size()>k) {
					minHeap.remove();
				}
			}
			System.out.println(minHeap.remove());
		}
		//6.Valid palindrome
		public boolean isValidPallandrome(String s) {
			int i = 0 , j = s.length() -1 ;
			while(i<j) {
				if(s.charAt(i) != s.charAt(j)) {
				 return isPallandrome(s,i+1,j) || isPallandrome(s,i,j-1);
				} 
				  i++;
				  j--;
			}
			return true;
		}
		public boolean isPallandrome(String s, int i , int j) {
			while(i<j) {
				if(s.charAt(i++) != s.charAt(j--)) {
					return false;
				}
			}
			return true;
		}
		//7.Prime Count
		public void primeCount(int num) {
			boolean[] boolArr = new boolean[num+1];
			boolArr[0] = boolArr[1] = true;
			for(int i=2;i*i<boolArr.length;i++) {
				if(!boolArr[i]) {
					for(int j=i;j*i<boolArr.length;j++) {
						boolArr[j*i] = true;
					}
				}
			}
			int primeCount = 0;
			for(int i=2;i<boolArr.length;i++) {
				if(!boolArr[i]) {
					primeCount++;
				}
			}
			System.out.println(primeCount);
		}
		//8. Happy number 19 = 82 = 68 = 100 = 1
		public boolean hppyNumber(int num) {
			Set<Integer> st = new HashSet<Integer>();
			while( num != 1 ) {
				int sum = 0;
				while(num != 0) {
					int remainder = num % 10;
					sum = sum + remainder * remainder;
					num = num / 10;
				}
				if(st.contains(sum)) {
					return false;
				} else {
					st.add(sum);
				}
			num=sum;
			}
		return true;
		}
		//9.Valid Mountain array
		public boolean isValidMountainArray(int[] arr) {
			if(arr.length < 3 ) {
				return false;
			}
			int i = 0;
			while( i < arr.length && i+1 < arr.length && arr[i] < arr[i+1]) {
				i++;
			}
			if(i==0 || i>=arr.length) {
				return false;
			}
			while(i < arr.length && i+1 < arr.length ) {
				if(arr[i] <= arr[i++ + 1]) {
					return false;
				}
			}
			return true;
		}
		//10.License Key formating
		public String licenseKeyFormating(String s ,int k) {
			s = s.toUpperCase();
			StringBuilder sb = new StringBuilder();
			int count = 0, i = s.length()-1;
			for(;i >= 0 ; i--) {
				if(s.charAt(i) == '-') {
					continue;
				} else {
					sb.append(s.charAt(i));
					count++;
					if(count == k) {
						if(i != 0) {
							sb.append('-');
						}
						count = 0;
					}
				}
			}
			return sb.reverse().toString();
		}
		//11.Sum of AlphaNumeric Number ex-> Nav14Preet20Kaur
		public int sumOfAlphaNumeric(String s) {
			int sum = 0; String num = "";
			for(int i = 0;i < s.length() -1 ; i++) {
				if( Character.isDigit(s.charAt(i))  ) {
					num += s.charAt(i);
				} else {
					if(!num.equals("")) {
						sum = sum + Integer.parseInt(num);
						num = "";
					}
						
				}
			}
			return sum;
		}
		//12.BackSpace String compare
		public String backSpaceString(String s) {
			for(int i=0;i<s.length();i++) {
				if(s.charAt(i) == '#') {
					s = s.substring(0,i-1) + s.substring(i+1);
				}
			}
			return s;
		}
		//13.Best time to buy and sell stock
		public int bestTimeToBuyAndSellStock(int[] stock) {
			int max = 0,min = Integer.MAX_VALUE;
			for(int i=0;i<stock.length;i++) {
				if(stock[i] < min) {
					min = stock[i];
				} else {
					max = Math.max(max, stock[i] - min);
				}
			}
			return max;
		}
		//14.plus one 
		/*public int[] plusOne(int[] arr) {
			int remainder = 0;
			for(int j=arr.length-1;j>=0;j--) {
				if(arr[j] < 9) {
					arr[j]++;
					return arr;
				}
				digit[j] = 0;
			}
		}*/
		public int hammingDistance(int x, int y) {
	        ArrayList<Integer> xarr = binaryGenerator(x);
	        System.out.println(xarr);
	        ArrayList<Integer> yarr = binaryGenerator(y);
	        System.out.println(yarr);
	        int change = 0;
	        for(int i=0;i < xarr.size() && i< yarr.size() ;i++){
	            if(xarr.get(i) != yarr.get(i)){
	                change ++ ;
	            }
	        }
	        return change;
	    }
	    public ArrayList<Integer> binaryGenerator(int x){
	        ArrayList<Integer> arr = new ArrayList<>();
	        while(x!=0){
	            arr.add(x%2);
	            x= x/2;
	        }
	        return arr;
	    }
	   public void phoneNumber(String digits) {
		  if(digits.length() == 0 || digits == null) throw new IllegalArgumentException();
		  List<String> result = new ArrayList<String>();
		  String[] mapping = {"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
		  
		  lettercombinationResursive(result,digits,"",0,mapping);
		  System.out.println(result);
	   }
	   private void lettercombinationResursive(List<String> result , String digits , String current , int index , String[] mapping) {
		   if(index == digits.length()) {
			   result.add(current);
			   return;
		   }
		   String letters = mapping[digits.charAt(index) - '0'];
		   System.out.println(letters);
		   for(int i = 0;i<letters.length();i++) {
			   System.out.println(result + "::" + digits + "::" + current + letters.charAt(i) + "::" + index+1);
			   lettercombinationResursive(result, digits, current + letters.charAt(i), index+1, mapping);
		   }
	   }
	  public void diagonal(String[][] arr){
		  List<Integer> finalarr = new ArrayList<Integer>();
		  int row =0;
	        int col;

	        while(row<arr.length){
	            col =0;
	            int rowTemp = row;
	            int temp = 0;
	            while(rowTemp>=0){
	               // System.out.print(arr[rowTemp][col] + " "); 
	            	temp = temp + Integer.parseInt(arr[rowTemp][col]);
	                rowTemp--;
	                col++;
	            }
	            finalarr.add(temp);
	            row++;
	        }

	        //print second half
	        col = 1;

	        while(col<arr.length){
	            int colTemp = col;
	            row = arr.length-1;
	            int temp = 0;
	            while(colTemp<=arr.length-1){
	               // System.out.print(arr[row][colTemp] + " ");
	            	temp = temp + Integer.parseInt(arr[row][colTemp]);
	                row--;
	                colTemp++;
	            }
	            finalarr.add(temp);
	            col++;
	        }
		  System.out.println(finalarr);
	  }
	public static void main(String[] args) throws ClassNotFoundException {
		CommonQue cmm = new CommonQue();
		//cmm.intToRoman(99);
		//cmm.romanToInt("XV");
     	int[] ar = cmm.twoSum(new int[] {2,5,7,4,10}, 11);
     	for(int i : ar) {
     		System.out.print(i + " ");
     	}
		//cmm.coinChange1(new int[] {1,5,10},12);
		//cmm.coinChange2(new int[] {1,2,5},11);
		//cmm.isValidParenthesis("{[()]}");
		//cmm.generateParenthesis(3);
		//System.out.println( cmm.isValidPallandrome("abcca") );
		//cmm.kthLargestElement(new int[] {1,2,4,5,3,6},3);
		//cmm.primeCount(10);
		//System.out.println(cmm.hppyNumber(19));
		//System.out.println(cmm.isValidMountainArray(new int[] {0,3,2,1}));
		//System.out.println(cmm.licenseKeyFormating("5F3Z-2e-9-w",4)); //2-5g-3-J =
		//System.out.println(cmm.sumOfAlphaNumeric("Nav30Preet19Kaur"));
		//System.out.println(cmm.backSpaceString("ab#c"));
		//System.out.println(cmm.bestTimeToBuyAndSellStock(new int[] {7,1,5,3,6,4}));
		//cmm.plusOne(new int[] {1,2,3});
		//cmm.phoneNumber("");
		//cmm.hammingDistance(1,4);
		//cmm.diagonal(new String[][] {{"1","2","3"},{"4","5","6"},{"7","8","9"}});
	}
	
}

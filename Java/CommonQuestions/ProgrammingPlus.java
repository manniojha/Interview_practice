package competativeprograming;

import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

public class ProgrammingPlus {
	
	//1.trainling zero 
	public int factorial(int n ) {
		if(n==1) {
			return n;
		}
		 return n * factorial(n-1);
	}
	public void countTraillingZero(int n) {
		int fact = factorial(n);
		int count = 0;
		while(n != 0) {
			int remain = fact % 10 ;
			if(remain == 0) {
				count++;
			}
			n = n/ 10;
		}
		System.out.println(count);
	}
		
	//2.Equilibrium point of an array 
	public void equilibriumPointFind(int[] arr) {
		if(arr.length == 1 || arr.length == 2) throw new IllegalArgumentException();
		int[] sum = new int[arr.length];
		sum[0] = arr[0];
		for(int i = 1;i<arr.length;i++) {
			sum[i] = sum[i-1] + arr[i];				// arr=  [1,2,6,4,0,-1]
		}											// sum = [1,2,9,13,13,12]
		int total = sum[sum.length-1];
		for(int i = 1;i<=sum.length;i++) {
			int lsum = sum[i] - arr[i];
			int rsum = total - sum[i];
			if(lsum == rsum) {
				System.out.println("Equillibrium point :" + i);
				break;
			}
		}
	}
	//3. din = (((  recede = ()()()
	public void stringConvertor(String s) {
		Map<Character,Integer> map = new HashMap<Character,Integer>();
		for(char c : s.toCharArray()) {
			if(map.containsKey(c)) {
				map.put(c,map.get(c)+1);
			}else {
				map.put(c,1);
			}
		}
		StringBuffer sb = new StringBuffer();
	 	for(int i = 0; i<s.length(); i++) {
	 		if(map.get(s.charAt(i))>1) {
	 			sb.append(")");;
	 		}else {
	 			sb.append("(");
	 		}
	 	}
	 	System.out.println(sb);
	}
	//4.
	public void desc(int n) {
		if(n<0) throw new IllegalArgumentException();
		ArrayList<Integer> arr = new ArrayList<Integer>();
		while(n!=0) {
			arr.add(n%10);
			n/=10;
		}
		Collections.sort(arr,Collections.reverseOrder());
		System.out.println(arr);
	}
	//5.
	public void divider(int n) {
		StringBuffer sb = new StringBuffer();
		ArrayList<Integer> arr = new ArrayList<Integer>();
		int counter = 1;
		while(n != 0) {
			int remain = n%10*counter;
			if(remain!=0) {
				arr.add(remain);
			}
			n/=10;
			counter *= 10;
		}
		for(int i= arr.size()-1;i>=0;i--) {
			sb.append(arr.get(i));
			if(i!=0) {
				sb.append("+");
			}
		}
		System.out.println(sb);
	}
	//6.
	public void binaryStringAddToHexaDecimal(String b1 , String b2) {
		int  n1 = Integer.parseInt(b1);
		int n2 = Integer.parseInt(b2);
		StringBuffer sb = new StringBuffer();
		int carry = 0;
		while(n1 != 0 || n2 != 0) {
			sb.append( (int)( (n1 % 10) + (n2 % 10) + carry) % 2  );
			carry = (int)( (n1 % 10) + (n2 % 10) + carry) / 2;
			n1 /= 10;
			n2 /= 10;
		}
		if(carry != 0) {
			sb.append(carry);
		}
		sb = sb.reverse();
		System.out.println(Integer.toHexString(Integer.parseInt(sb.toString(),2)));
	}
	//7.
	public int factorialof(int n) {
		if(n==1) {
			return n;
		}
		return n * factorialof(n-1);
	}
	public void valueCalculator(int x) {
		int sum = 0;
		for(int i=0;i<=x;i++) {
			int temp = (int)(Math.pow(x,2*i+1)/factorialof(2*i+1));
			if(i%2==0) {
				sum += temp;
			} else {
				sum -= temp;
			}
			
		}
	}
	//8.kabhi nahi chalne wala
	public boolean primechecker(int n) {
		for(int i=2;i<n;i++) {
			if(n%i==0) {
				return false;
			} 
		}
		return true;
	}
	public void print10PrimeNumberWhichIsDivisibleBy235() {
		int counter = 0; int i = 2;
		while(counter != 10) {
			if(primechecker(i)) {
				if(i % 2 == 0 && i % 3 == 0  && i % 5 == 0) {
					counter++;
				}
			}
			i++;
		}
		System.out.println(i);
	}
	//9.
	public void print10NumberWhichIsDivisible235() {
		int counter = 0; int i = 30;
		while(counter != 10) {
			if(i % 2 == 0 && i % 3 == 0  && i % 5 == 0) {
				System.out.println(i);
				counter++;
			}
			i++;
		}
		System.out.println(i-1);
	}
	public void complexNumberMultiplication(String s1 ,String s2) {
		String[] result = s1.split("\\+|i");
		for(String s : result) {
			System.out.print(s + "->");
		}
	}
	
	public static void main(String[] args) {
		ProgrammingPlus p = new ProgrammingPlus();
		//p.countTraillingZero(12);
		//p.equilibriumPointFind(new int[] {1,2});
		//p.stringConvertor(new String("recede"));
		//p.desc(21445);
		//p.divider(70304);
		//p.binaryStringAddToHexaDecimal("110","101");
		//p.print10PrimeNumberWhichIsDivisibleBy235();
		//p.print10NumberWhichIsDivisible235();
		p.complexNumberMultiplication("1-1i","1+1i");
		
		
	}
}

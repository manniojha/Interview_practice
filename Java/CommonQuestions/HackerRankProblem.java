package competativeprograming;

import java.util.Map;
import java.util.HashMap;

public class HackerRankProblem {
	//1.
	public void hourglassproblem() {
		int[][] arr = {{-1,-1,0,-9,-2,-2}, 
			       {-2,-1,-6,-8,-2,-5},
			       {-1,-1,-1,-2,-3,-4},
			       {-1,-9,-2,-4,-4,-5},
			       {-7,-3,-3,-2,-9,-9},
			       {-1,-3,-1,-2,-4,-5}
				  };
	int[][] res = new int[4][4];
	for(int i=0;i<4;i++) {
		for(int j=0;j<4;j++) {
			res[i][j] = arr[i][j] + arr[i][j+1] + arr[i][j+2] + arr[i+1][j+1] + arr[i+2][j] +  arr[i+2][j+1] + arr[i+2][j+2];
		}
	} int max = res[0][0];
	for(int i=0;i<4;i++) {
		for(int j=0;j<4;j++) {
			if(max < res[i][j]) {
				max = res[i][j];
			}
			System.out.println();
		}
	}
	System.out.println(max);
	}
	public int gcd(int a,int b) {
		if(b==0) {
			return a;
		}
		 return gcd(b,a%b);
	}
	//2.
	public void arrayRotation() {
		int d =4;
		int []arr = {1,2,3,4,5};
		int n = arr.length;
		int j,k = 0;
		int g_c_d = gcd(d,n);
		for(int i=0;i<g_c_d;i++) {
			int temp = arr[i];
			j=i;
			while(true) {
				k = j+d;
				if(k>=n) {
					k = k-n;
				}
				if(k==i) {
					break;
				}
				arr[j] = arr[k];
				j=k;
			}
			arr[j] = temp;
		}
		for(int i=0;i<n;i++) {
			System.out.println(arr[i] + " ");
		}
		
	}
	public void swap(int[] arr , int a , int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	//3.
	public void newyearChoasProblem() {
		int[] arr = {2,1,3,5,3,4};
		int swapcount = 0;
		for(int i=arr.length-1;i>=0;i++) {
			if(arr[i] != i+1) {
				if(((i-1)>=0) && arr[i-1] == (i+1)) {
					swapcount++;
					swap(arr, i, i-1);
				} else if(((i-2)>=0) && arr[i-2] == (i+1)) {
					swapcount+=2;
					swap(arr, i-2, i-1);
					swap(arr, i-1, i);
				} else {
					System.out.println("Too Chaoctic");
					return ;
				}
			}
		}
		System.out.println(swapcount);
	}//4.
	public void primeSum(int n1 , int n2) {
		int max1,max2;
		max1 = max2 = 2;
		for(int i = 2;i<=n1;i++) {
			int counter = 0;
			for(int j=1;j<=i;j++) {
				if(i%j == 0) {
					counter++;
				}
			}
			if(counter == 2) {
				max1 = i;
			}
		}
		for(int i = 2;i<=n2;i++) {
			int counter = 0;
			for(int j=1;j<=i;j++) {
				if(i%j == 0) {
					counter++;
				}
			}
			if(counter == 2) {
				max2 = i;
			}
		}
		System.out.println(max1+max2);
	}
	//5.
	public void subArrayWithSum(int sum) {
		int[] arr = {4, 2, -3, 1, 6};//{15,2,4,8,9,5,10,23};
		int left,right;
		left=right=0;
		int result = 0;
		while(right<arr.length) {
			while(result < sum && right<arr.length) {
				result+=arr[right];
				right++;
			}
			if(result>sum) {
				while(result>sum) {
					result-=arr[left];
					left++;
				}
			}
			if(result == sum) {
				System.out.println(left + ":" + (right-1));
				break;
			}
		}
	}
	public void primefactorization(int n) {
		for(int i = 2;i<=n;i++) {
			if(n%i==0) {
				int counter = 0;
				while(n%i==0) {
					n = n/i;
					counter++;
				}
				System.out.println(i+" : "+counter);
			}
		}
	}
	public static void main(String[] args) {
		HackerRankProblem hrp = new HackerRankProblem();
		//hrp.hourglassproblem();
		//hrp.arrayRotation();
		//hrp.newyearChoasProblem();
		//hrp.primeSum(5, 5);
		//hrp.subArrayWithSum(0);
		hrp.primefactorization(46);
	}
}























































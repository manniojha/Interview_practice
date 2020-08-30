package competativeprograming;

public class Pattern {
	
	//1.Rectangle
		public void rectangle() {
			for(int i=1;i<=3;i++) {
				for(int j=1;j<=5;j++) {
					System.out.print("*");
				}
				System.out.println();
			}
		}
		//2.Hollow Rectangle
		public void hollowRectangle() {
			for(int i=1;i<=3;i++) {
				for(int j=1;j<=5;j++) {
					if( i==1 || i==3 || j==1 || j==5 ) {
						System.out.print("*");
					}else {
						System.out.print(" ");
					}
				}
				System.out.println();
			}
		}
		//3. Triangle pattern
		public void trianglePattern() {
			for(int i=1;i<=5;i++) {
				for(int j=1;j<=i;j++) {
					System.out.print("*");
				}
				System.out.println();
			}
		}
		//4.Inverted Triangle Pattern
		public void invertedTrianglePattern() {
			for(int i=5;i>=1;i--) {
				for(int j=1;j<=i;j++) {
					System.out.print("*");
				}
				System.out.println();
			}
		}
		//5.Hollow Triangle pattern
		public void hollowTrianglepattern() {
			for(int i=1;i<=5;i++) {
				for(int j=1;j<=i;j++) {
					if( i==1 || i==5 || j==1 || j==i ) {
						System.out.print("*");
					}else {
						System.out.print(" ");
					}
				}
				System.out.println();
			}
		}
		//6.Inverted Hollow Triangle Pattern
		public void hollowInvertedTriangle() {
			for(int i=1;i<=5;i++) {
				for(int j=5;j>=i;j--) {
					if(i==1||i==5||j==5||j==i) {
						System.out.print("*");
					}
					else {
						System.out.print(" ");
					}
				}
				System.out.println();
			}
		}
		//7.Pyramid
		public void pyramid() {
			for(int i=1;i<=5;i++) {
				for(int j=1;j<=5-i;j++) {
					System.out.print(" ");
				}
				for(int k=0;k<2*i-1;k++) {
					System.out.print("*");
				}
				System.out.println();
			}
		}
		//8.Inverted Pyramid 
		public void invertedPyramid(int n) {
			for(int i=n;i>=1;i--) {
				for(int j=1;j<=5-i;j++) {
					System.out.print(" ");
				}
				for(int k=0;k<2*i-1;k++) {
					System.out.print("*");
				}
				System.out.println();
			}
		}
		//9.Hollow Pyramid
		public void hollowPyramid() {
			for(int i=1;i<=5;i++) {
				for(int j=1;j<=5-i;j++) {
					System.out.print(" ");
				}
				for(int k=0;k<2*i-1;k++) {
					if( i==1 || i==5 || k==0 || k==2*i-2 ) {
						System.out.print("*");
					}else {
						System.out.print(" ");
					}
				}
				System.out.println();
			}
		}
		//10.Hollow Inverted Pyramid
		public void hollowInvertedPyramid() {
			for(int i=5;i>=1;i--) {
				for(int j=1;j<=5-i;j++) {
					System.out.print(" ");
				}
				for(int k=0;k<2*i-1;k++) {
					if( i==1 || i==5 || k==0 || k==2*i-2 ) {
						System.out.print("*");
					}else {
						System.out.print(" ");
					}
				}
				System.out.println();
			}
		}
		//11.Diamond
		public void diamond() {
			for(int i=1;i<=5;i++) {
				for(int j=1;j<=5-i;j++) {
					System.out.print(" ");
				}
				for(int k=0;k<2*i-1;k++) {
					System.out.print("*");
				}
				System.out.println();
			}
				for( int l=4;l>=1;l--) {
					for(int m=6;m<=10-l;m++) {
						System.out.print(" ");
					}
					for(int n=0;n<2*l-1;n++) {
							System.out.print("*");
						}
					System.out.println();
					}
				}
		//12.Hollow Diamond
		public void hollowDiamond() {
			for(int i=1;i<=5;i++) {
				for(int j=1;j<=5-i;j++) {
					System.out.print(" ");
				}
				for(int k=0;k<2*i-1;k++) {
					if(i==1 || k==0 || k==2*i-2) {
						System.out.print("*");
					}else {
						System.out.print(" ");
					}
				}
				System.out.println();
			} 
			for(int i=4;i>=1;i--) {
				for(int j=6;j<=10-i;j++) {
					System.out.print(" ");
				}
				for(int k=0;k<2*i-1;k++) {
					if(i==1 || k==0 || k==2*i-2) {
						System.out.print("*");
					}else {
						System.out.print(" ");
					}
				}
				System.out.println();
			}
		}
		//13.Half Diamond 
		public void halfDiamond() {
			for(int i=1;i<=5;i++) {
				for(int j=1;j<=i;j++) {
					System.out.print("*");
				}
				System.out.println();
			}
			for(int i=4;i>=1;i--) {
				for(int j=1;j<=i;j++) {
					System.out.print("*");
				}
				System.out.println();
			}
		}
		
		//14.Heart
			public void heart2()
			{
				final String message = " I Love You ";
				final int n = 10;

				for (int i = 0; i < n; i++) {
					for (int j = 0; j <= 4 * n; j++) {
						double d1 = Math.sqrt(Math.pow(i - n, 2) + Math.pow(j - n, 2));
						double d2 = Math.sqrt(Math.pow(i - n, 2) + Math.pow(j - 3 * n, 2));

						if (d1 < n + 0.5 || d2 < n + 0.5) {
							System.out.print('*');
						} else {
							System.out.print(' ');
						}
					}
					System.out.print(System.lineSeparator());
				}

				for (int i = 1; i < 2 * n; i++) {
					for (int j = 0; j < i; j++) {
						System.out.print(' ');
					}

					for (int j = 0; j < 4 * n + 1 - 2 * i; j++) {
						if (i >= 2 && i <= 4) {
							int idx = j - (4 * n - 2 * i - message.length()) / 2;
							if (idx < message.length() && idx >= 0) {
								if (i == 3) {
									System.out.print(message.charAt(idx));
								} else {
									System.out.print(' ');
								}
							} else {
								System.out.print('*');
							}
						} else {
							System.out.print('*');
						}
					}
					System.out.print(System.lineSeparator());
				}
			}
			//15.Hollow Diamond Rectangle
			public void hollowDiamondRectangle() {
				for(int i=1;i<5;i++) {
					for(int j=0;j<5-i;j++) {
						System.out.print("*");
					}
					for(int k=0;k<2*i-1;k++) {
						System.out.print(" ");
					}
					for(int l=i;l<5;l++) {
						System.out.print("*");
					}
					System.out.println();
				}
				for(int i=5;i>=1;i--) {
					for(int j=0;j<5-i;j++) {
						System.out.print("*");
					}
					for(int k=0;k<2*i-1;k++) {
						System.out.print(" ");
					}
					for(int l=i;l<5;l++) {
						System.out.print("*");
					}
					System.out.println();
				}
			}
		public static void main(String[] args) {
			Pattern p = new Pattern();
			//p.rectangle();
			//p.hollowRectangle();
			//p.trianglePattern();
			//p.invertedTrianglePattern();
			//p.hollowTrianglepattern();
			//p.hollowInvertedTriangle();
			//p.pyramid();
			//p.invertedPyramid(5);
			//p.hollowPyramid();
			//p.hollowInvertedPyramid();
			//p.diamond();
			//p.hollowDiamond();
			//p.halfDiamond();
			//p.heart2();
			p.hollowDiamondRectangle();
		}
}

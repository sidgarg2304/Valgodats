package com.vishal.algorithms.matrix;

public class NumMatrix {
	
	public static void main(String[] args){
		int [][] matrix = new int[4][4];
		matrix[0] = new int[]{1,2,3,4};
		matrix[1] = new int[]{3,1,2,4};
		matrix[2] = new int[]{1,2,3,2};
		matrix[3] = new int[]{4,3,1,2};
		
		MatrixBasicAlgorithms.printMatrix(matrix);
		
		NumMatrix(matrix);
		MatrixBasicAlgorithms.printMatrix(sum);
		
		System.out.println(sumRegion(1,1,2,2));
	}
   static int [][] sum;

   public static void NumMatrix(int[][] matrix) {
       if(matrix==null || matrix.length==0||matrix[0].length==0)
           return;

       int m = matrix.length;
       int n = matrix[0].length;
       sum = new int[m][n];

       for(int i=0; i<m; i++){
           int sumRow=0;
           for(int j=0; j<n; j++){
               if(i==0){
                   sumRow += matrix[i][j];
                   sum[i][j]=sumRow;
               }else{
                   sumRow += matrix[i][j];
                   sum[i][j]=sumRow+sum[i-1][j];
               }

           }
       }
   }

   public static int sumRegion(int row1, int col1, int row2, int col2) {
       if(sum==null) 
           return 0;

       int topRightX = row1;
       int topRightY = col2;

       int bottomLeftX=row2;
       int bottomLeftY= col1;

       int result=0;

       if(row1==0 && col1==0){
           result = sum[row2][col2];
       }else if(row1==0){
           result = sum[row2][col2]
                   -sum[bottomLeftX][bottomLeftY-1];

       }else if(col1==0){
           result = sum[row2][col2]
                   -sum[topRightX-1][topRightY];
       }else{
      	 System.out.println("sum[row2][col2] " + sum[row2][col2]);
      	 System.out.println("sum[topRightX-1][topRightY] " + sum[topRightX-1][topRightY]);
      	 System.out.println("sum[bottomLeftX][bottomLeftY-1] " + sum[bottomLeftX][bottomLeftY-1]);
      	 System.out.println("um[row1-1][col1-1] " + sum[row1-1][col1-1]);
           result = sum[row2][col2]
                   -sum[topRightX-1][topRightY]
                   -sum[bottomLeftX][bottomLeftY-1]
                   +sum[row1-1][col1-1];
       }

       return result;
   }
}
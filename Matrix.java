/*	Name: Nihal Punjani
 *  Date: 10.10.20
 *  Program Description: Matrix class creates matrixes of integer arrays and performs add and multiply operations
 */


public class Matrix {
	//Declaring data values for matrix
	int rows;
	int columns;	
	int[][] matrix;	
	String dimensions;	
	
	//empty constructor for matrix
	Matrix(){}
	

	//constructor with two int parmeters
	Matrix(int rows, int columns){
		//assigning this instance of rows to parameter value
		this.rows= rows;	
		//assigning this instance of columns to parameter value
		this.columns = columns;	
		//initializing new int array
		matrix = new int[rows][columns];
		this.dimensions = rows + "x" + columns;	
	}
	

	//constructor with double int array as parameter
	Matrix(int[][] m){
		//assigning this instance of matrix array to m
		this.matrix = m;	
		//assigning rows to m.length
		this.rows = m.length;	
		//compare columns to make sure they are same in each row
		if(compareColumns(m, m.length)==true) {	
			//assigning columns to length of second dimension of m array
			this.columns = m[0].length;	
		}
		//assigning dimensions to rows by columns
		this.dimensions = rows + "x" + columns;	
	}
	
	
	//method to return value of dimensions
	String getDimensions() {
		return dimensions;	
	}
	

	//method to return value of rows
	int getRows(){
		return rows;	
	}
	
	//O(1); Runtime 1
	//method to return value of columns
	int getColumns(){
		return columns;
	}
	

	//method to check if columns are equal values, takes in parameter of double int array and int variable
	static boolean compareColumns(int[][] m, int size){
		//for-loop to check columns by inputed column size
		for(int i =1; i < size; i++) {	
			if(m[i-1].length!=m[i].length) { 
				return false;	
			}
		}
		return true;	
	}
	
	//setter method to set new value in matrix takes three parameter values
	void setAt(int value, int rows, int columns) {
		matrix[rows][columns] = value;	
	}
	
	
	//getter method to return value at certain index of matrix
	int getValueAt( int rows, int columns) {
		return matrix[rows][columns];
	}
	
	//matrix add operator method takes in three matrixes and the int size of the matrixes
	//linear algebra state matrixes must be nxn size to do add operation
	static void matrixAdd(Matrix a, Matrix b, Matrix c, int n){
		//if condition to make sure matrixes are the same size
		if(a.getRows()!=b.getRows() || a.getColumns()!=b.getColumns()) {	
			//print statement if matrixes are not the same
			System.out.println("Matricies do not have same dimensions");	
		}
		//if condition when matrixes are the same size
		if(a.getRows()==b.getRows() && a.getColumns()==b.getColumns()) {	
			//for-loop to iterate throught the matrixes
			for(int i = 0; i < n; i++) {	
				for (int j = 0; j < n; j++) {	
					//initialzing variable to hold sum value
					//reassigns to 0 each loop
					int sum = 0;
					//adding sum of matrixes at index i,j
					sum = a.getValueAt(i, j) + b.getValueAt(i, j);
					//setting the value of sum to the index
					c.setAt(sum, i, j);	
				}
			}
		}
	}
	
	//matrix multiply operator method takes in three matrixes and the int size of the end result size n1xm2
	//linear algebra state matrixes must be nxn size to do add operation
	static void matrixMultiply(Matrix a, Matrix b, Matrix c, int n, int col){
		//runtime exception if columns in first matrix do not equal number of rows in matrix b
	if(a.columns != b.rows) throw new RuntimeException("Illegal matrix dimensions");	
		//first for-loop for rows
	   for(int i = 0; i < n; i++) {	
		   //second for-loop for columns of second matrix
	      for (int j = 0; j < n; j++)
	      {
	    	  //int variable for sum value
	         int sum = 0;
	         //3rd loop for columns of of first matrix
	         for (int k = 0; k < col; k++) {	
	        	 //incrementing sum with index values of both matrixes
	        	 sum += a.getValueAt(i, k) * b.getValueAt(k, j);
	        	 //inserting sum value at index of new matrix
	        	 c.setAt(sum, i, j);
	         }
	      }
	   }
	}
	
	//method to output matrix values with parameters of int rows and columns
	void printMatrix(int rows, int columns) {
		//for-loop to iterate through rows
		for(int i = 0; i < rows; i++) {	
			//for loops to iterate through columns
			for(int j = 0; j< columns; j++) { 
				System.out.print(matrix[i][j]+"\t");	
			}
			System.out.println();	
		}
	}
	
	public static void main(String[] args) {
		//initializing double int arrays for matrixes
		int[][] a= {{1,2,3},{4,5,6},{7,8,9}};
		int[][] b= {{9,8,7},{6,5,4},{3,2,1}};	
		int[][] c= new int[3][3];	
		int[][] d= new int[2][2];
		int[][] e= {{1,2,3},{4,5,6}};
		int[][] f= {{9,8},{7,6},{5,4}};
		
		//initializing matrixes with array paramters
		Matrix neo = new Matrix(a);
		Matrix morpheus = new Matrix(b);
		Matrix trinity = new Matrix(c);	 
		Matrix AgentJ = new Matrix(e);
		Matrix AgentK = new Matrix (f); 
		Matrix AgentA = new Matrix(d); 
		matrixAdd(neo, morpheus, trinity, 3);
		matrixMultiply(AgentJ, AgentK, AgentA, 2, 2);
		trinity.printMatrix(3, 3);
		System.out.println();
		AgentA.printMatrix(2, 2);

		

	}

}

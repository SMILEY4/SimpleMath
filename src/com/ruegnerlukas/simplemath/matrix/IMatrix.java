package com.ruegnerlukas.simplemath.matrix;



public interface IMatrix {

	
	

	/**
	 * @return the number of columns of this matrix
	 * */
	public int getNumberColumns();
	
	
	/**
	 * @return the number of rows of this matrix
	 * */
	public int getNumberRows();
	
	
	
	
	/**
	 * Sets the value at the given column and row of the this matrix.
	 * @return this Matrix for chaining
	 * */
	public IMatrix set(int column, int row, Number value);
	
	
	/** @return the value of the component at the given column and row as a int */
	public int getInt(int column, int row);

	
	/** @return the value of the component at the given column and row as a long */
	public long getLong(int column, int row);
	
	
	/** @return the value of the component at the given column and row as a float */
	public float getFloat(int column, int row);
	
	
	/** @return the value of the component at the given column and row as a double */
	public double getDouble(int column, int row);
	
	
	
	
	/**
	 * Gets a submatrix of this matrix
	 * @param colStart	first column index
	 * @param rowStart	first row index
	 * @param colEnd	last column index (inclusive)
	 * @param rowEnd	last row index (inclusive)
	 * @param dest		the destination matrix (must be the same size)
	 * */
	public void getSubmatrix(int colStart, int rowStart, int colEnd, int rowEnd, IMatrix dest);
	
	
	/**
	 * Creates a submatrix of this matrix
	 * @param colStart	first column index
	 * @param rowStart	first row index
	 * @param colEnd	last column index (inclusive)
	 * @param rowEnd	last row index (inclusive)
	 * @return the created submatrix
	 * */
	public IMatrix getSubmatrix(int colStart, int rowStart, int colEnd, int rowEnd);
	
	
	
	
	/**
	 * Switches the two columns with the given indices
	 * @param c0 the index of the first column
	 * @param c1 the index of the second column
	 * @return this matrix for chaining
	 * */
	public IMatrix switchColumns(int c0, int c1);
	
	
	/**
	 * Switches the two rows with the given indices
	 * @param r0 the index of the first row
	 * @param r1 the index of the second row
	 * @return this matrix for chaining
	 * */
	public IMatrix switchRows(int r0, int r1);
	
	
	
	
	/**
	 * copies the int values of this matrix into the given array
	 * @param data the destination array (must be the sames size as this matrix) or null
	 * @return the (created) destination array with the same values as this matrix
	 * */
	public IMatrix copyData(int[][] data);
	
	
	
	
	/**
	 * copies the float values of this matrix into the given array
	 * @param data the destination array (must be the sames size as this matrix) or null
	 * @return the (created) destination array with the same values as this matrix
	 * */
	public IMatrix copyData(float[][] data);
	
	
	
	
	/**
	 * copies the double values of this matrix into the given array
	 * @param data the destination array (must be the sames size as this matrix) or null
	 * @return the (created) destination array with the same values as this matrix
	 * */
	public IMatrix copyData(double[][] data);
	
	
	
	
	/**
	 * Adds the given matrix to this matrix
	 * @param mat the other matrix
	 * @return this matrix for chaining
	 * */
	public IMatrix add(IMatrix mat);
	
	
	
	
	/**
	 * Subtracts the given matrix from this matrix
	 * @param mat the other matrix
	 * @return this matrix for chaining
	 * */
	public IMatrix sub(IMatrix mat);
	
	
	
	
	/**
	 * Multiplies this matrix by the given scalar
	 * @param scalar the scalar
	 * @return this matrix for chaining
	 * */
	public IMatrix scale(Number scalar);
	
	
	
	
	/**
	 * Multiplies this matrix by the given matrix
	 * @param mat the other matrix (the number of columns of the given matrix must match the number of rows of this matrix)
	 * @return this matrix for chaining
	 * */
	public IMatrix mul(IMatrix mat);
	
	
	
	
	/**
	 * Multiplies this matrix by the given matrix
	 * @param mat 	the other matrix(the number of columns of the given matrix must match the number of rows of this matrix)
	 * @param dest	the destination matrix or null (null creates new matrix)
	 * @return the result / destination matrix
	 * */
	public IMatrix mul(IMatrix mat, IMatrix dest);

	
	
	
	/**
	 * Negates this matrix
	 * @return this matrix for chaining
	 * */
	public IMatrix negate();
	
	
	
	
	/**
	 * @return true, if this matrix is a square matrix (number of columns = number of rows)
	 * */
	public boolean isSquare();
	
	
	
	
	/**
	 * @return true if the size and elements of this matrix matches the given matrix
	 * */
	public boolean compare(IMatrix mat);
	
	
	
	
	/**
	 * @return true if the size of this matrix matches the given matrix
	 * */
	public boolean compareSize(IMatrix mat);
	
	
	
	
	/**
	 * Calculates the transpose of this matrix
	 * @return this matrix for chaining
	 * */
	public IMatrix transpose();
	
	
	
	
	/**
	 * @return true, if this matrix is a square matrix and an upper triangular matrix (zeros below diagonal)
	 * */
	public boolean isUpperTriangular();
	
	
	
	
	/**
	 * Calculates the upper triangular matrix of this matrix (this matrix must be a square matrix)
	 * @return this matrix for chaining
	 * */
	public IMatrix toUpperTriangle();

	
	
	
	/**
	 * @return the determinant of this matrix. This matrix must be a square matrix
	 * */
	public Number determinantGen();
	
	
	
	
	/**
	 * @return the trace of this matrix. This matrix must be a square matrix
	 * */
	public Number traceGen();
	
	
	
	
	/**
	 * Sets this matrix to an identity matrix. This matrix must be square
	 * @return this matrix for chaining
	 * */
	public IMatrix setToIdentity();
	
	
	
	
	/**
	 * @return this matrix as a string for debugging
	 * */
	public String toFormattedString();
	
	
	
	
	/**
	 * Creates a new matrix  with the same values and size as this matrix.
	 * @return the created matrix
	 * */
	public IMatrix copy();
	
	
	
	
	/**
	 * Whether or not to check for exceptions.
	 * */
	public IMatrix setUnsafe(boolean unsafe);
	
	
	
	/**
	 * Whether or not this matrix checks for exceptions.
	 * */
	public boolean isUnsafe();
	
}


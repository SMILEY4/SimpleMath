package com.ruegnerlukas.simplemath.matrix.matrixN;

import com.ruegnerlukas.simplemath.matrix.IMatrix;
import com.ruegnerlukas.simplemath.vectors.IVector;

public interface IMatrixl extends IMatrix {

	
	
	
	/**
	 * @return the content of this matrix as a 2d array
	 * */
	public long[][] getData();
	
	
	
	
	/**
	 * @return the value of the element at the given indices i and j
	 * */
	public long getData(int i, int j);
	
	
	
	/**
	 * Writes the values of the given row "row" into the given array "dest"
	 * @param row	the index of the row
	 * @param dest	the destination array ( must be the same size as the row (number of columns) ) or null
	 * @return the row (dest) as an array
	 * */
	public long[] getRow(int row, long[] dest);
	
	
	/**
	 * Writes the values of the given column "column" into the given array "dest"
	 * @param column	the index of the column
	 * @param dest		the destination array ( must be the same size as the column (number of rows) ) or null
	 * @return the column (dest) as an array
	 * */
	public long[] getColumn(int column, long[] dest);
	
	
	/**
	 * @return the row at the given index as an array
	 * */
	public long[] getRow(int row);
	
	
	/**
	 * @return the column at the given index as an array
	 * */
	public long[] getColumn(int column);
	
	
	/**
	 * @return the row at the given index as an Vector
	 * */
	public IVector getRowVector(int row);
	
	
	/**
	 * @return the column at the given index as an Vector
	 * */
	public IVector getColumnVector(int column);
	
	
	
	
	/**
	 * Uses the given array as new values of this matrix. Changes number of rows and columns.
	 * @return this matrix for chaining
	 * */
	public IMatrixl set(long[][] data);
	
	
	
	/**
	 * Sets the value of this matrix at the given index
	 * @return this matrix for chaining
	 * */
	public IMatrixl set(int i, int j, long v);
	
	
	/**
	 * Sets the values of the given column
	 * @param column 	the index of the column
	 * @param data 		the array containg the new values (must be the same size as the column)
	 * @return this matrix for chaining
	 * */
	public IMatrixl setColumn(int column, long[] data);
	
	
	/**
	 * Sets the values of the given row
	 * @param row 	the index of the row
	 * @param data 	the array containg the new values (must be the same size as the row)
	 * @return this matrix for chaining
	 * */
	public IMatrixl setRow(int row, long[] data);

	
	
}

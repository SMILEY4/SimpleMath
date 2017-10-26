package com.ruegnerlukas.simplemath.matrix;

import com.ruegnerlukas.simplemath.vectors.IVector;

public interface IMatrixf extends IMatrix {

	
	
	
	/**
	 * @return the content of this matrix as a 2d-float array
	 * */
	public float[][] getData();
	
	
	
	
	/**
	 * @return the value of the element at the given indices i and j
	 * */
	public float getData(int i, int j);
	
	
	
	/**
	 * Writes the values of the given row "row" into the given array "dest"
	 * @param row	the index of the row
	 * @param dest	the destination array ( must be the same size as the row (number of columns) ) or null
	 * @return the row (->dest) as an array
	 * */
	public float[] getRow(int row, float[] dest);
	
	
	/**
	 * Writes the values of the given column "column" into the given array "dest"
	 * @param column	the index of the column
	 * @param dest		the destination array ( must be the same size as the column (number of rows) ) or null
	 * @return the column (->dest) as an array
	 * */
	public float[] getColumn(int column, float[] dest);
	
	
	/**
	 * @return the row at the given index as an array
	 * */
	public float[] getRow(int row);
	
	
	/**
	 * @return the column at the given index as an array
	 * */
	public float[] getColumn(int column);
	
	
	/**
	 * @return the row at the given index as an Vector
	 * */
	public IVector getRowVector(int row);
	
	
	/**
	 * @return the column at the given index as an Vector
	 * */
	public IVector getColumnVector(int column);
	
	
	
	
	/**
	 * copies the values of this given array into this matrix
	 * @return this matrix for chaining
	 * */
	public IMatrixf setData(float[][] data);
	
	
	
	/**
	 * Sets the value of this matrix at the given index
	 * @return this matrix for chaining
	 * */
	public IMatrixf setData(int i, int j, float v);
	
	
	/**
	 * Sets the values of the given column
	 * @param row 	the index of the column
	 * @param data 	the array containg the new values (must be the same size as the column)
	 * @return this matrix for chaining
	 * */
	public IMatrixf setDataCol(int column, float[] data);
	
	
	/**
	 * Sets the values of the given row
	 * @param row 	the index of the row
	 * @param data 	the array containg the new values (must be the same size as the row)
	 * @return this matrix for chaining
	 * */
	public IMatrixf setDataRow(int row, float[] data);

	
	
}

package com.ruegnerlukas.simplemath.matrix;



public interface IMatrix {

	
	public IMatrix clone();
	
	public int getNumberColumns();
	public int getNumberRows();
	
	public float[][] getData();
	public float getData(int i, int j);
	public void getRow(int row, float[] dest);
	public void getColum(int column, float[] dest);
	
	public IMatrix setData(int i, int j, float v);
	public IMatrix setDataCol(int column, float[] data);
	public IMatrix setDataRow(int row, float[] data);

	public IMatrix switchColumns(int c0, int c1);
	public IMatrix switchRows(int r0, int r1);

	
	/*
	
	add matrix a to b
	subtract matrix b from a
	multiply matrix a by matrix b
	mutiply matrix by scalar value
	transpose matrix
	invert matrix
	get minor of matrix
	calculate determinant
	calulate rank
	...
	
	
	*/
	
}

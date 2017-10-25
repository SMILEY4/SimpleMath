package com.ruegnerlukas.simplemath.matrix;

import com.ruegnerlukas.simplemath.vectors.IVector;

public interface IMatrix {

	
	public IMatrix clone();
	
	public int getNumberColumns();
	public int getNumberRows();
	
	public float[][] getData();
	public float getData(int i, int j);
	public void getRow(int row, float[] dest);
	public void getColumn(int column, float[] dest);
	public float[] getRow(int row);
	public float[] getColumn(int column);
	
	public IVector getRowVector(int row);
	public IVector getColumnVector(int column);
	
	
	public void getSubmatrix(int c0, int r0, int c1, int r1, IMatrix dest);
	public IMatrix getSubmatrix(int c0, int r0, int c1, int r1);

	public IMatrix copyData(float[][] data);
	public IMatrix setData(float[][] data);
	public IMatrix setData(int i, int j, float v);
	public IMatrix setDataCol(int column, float[] data);
	public IMatrix setDataRow(int row, float[] data);

	public IMatrix switchColumns(int c0, int c1);
	public IMatrix switchRows(int r0, int r1);

	public boolean isSquare();
	public boolean compare(IMatrix mat);
	public boolean compareSize(IMatrix mat);

	public IMatrix transpose();
	
	public IMatrix add(IMatrix mat);
	public IMatrix sub(IMatrix mat);
	
	public IMatrix scale(float scalar);
	public IMatrix mul(IMatrix mat);
	public IMatrix mul(IMatrix mat, IMatrix dest);

	public String toFormattedString();
	
	public IMatrix toUpperTriangle();
	public boolean isUpperTriangular();

	public float determinant();
	public float trace();
	
	public IMatrix copy();
	
}

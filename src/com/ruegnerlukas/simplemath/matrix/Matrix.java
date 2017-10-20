package com.ruegnerlukas.simplemath.matrix;



public class Matrix implements IMatrix {

	
	
	
	private final float[][] data;
	private final int columns;
	private final int rows;
	
	
	
	
	
	
	public Matrix(int columns, int rows) {
		this(columns, rows, 0f);
	}
	
	
	public Matrix(int columns, int rows, float fill) {
		this.columns = columns;
		this.rows = rows;
		this.data = new float[columns][rows];
		for(int i=0; i<data.length; i++) {
			for(int j=0; j<data[i].length; j++) {
				data[i][j] = fill;
			}
		}
	}
	
	
	public Matrix(float[][] data) {
		this.data = data;
		this.columns = data.length;
		this.rows = data[0].length;
	}
	
	
	
	
	
	
	@Override
	public IMatrix clone() {
		return new Matrix(this.data);
	}

	
	
	
	@Override
	public int getNumberColumns() {
		return this.columns;
	}

	
	
	
	@Override
	public int getNumberRows() {
		return this.rows;
	}

	
	
	
	@Override
	public float[][] getData() {
		return this.data;
	}

	
	
	
	@Override
	public float getData(int i, int j) {
		if(i < 0 || i >= getNumberColumns() || j < 0 || j >= getNumberRows()) {
			throw new IndexOutOfBoundsException("Index: " + i+","+j + ", size: " + getNumberColumns() + "," + getNumberRows());
		}
		return this.data[i][j];
	}

	
	
	
	@Override
	public void getRow(int row, float[] dest) {
		if(dest.length != getNumberColumns()) {
			throw new IllegalArgumentException("Destination array length invalid: " + dest.length + ". Should be " + getNumberColumns());
		}
		for(int i=0; i<getNumberColumns(); i++) {
			dest[i] = getData(i, row);
		}
	}

	
	
	
	@Override
	public void getColum(int column, float[] dest) {
		if(dest.length != getNumberRows()) {
			throw new IllegalArgumentException("Destination array length invalid: " + dest.length + ". Should be " + getNumberRows());
		}
		for(int j=0; j<getNumberRows(); j++) {
			dest[j] = getData(column, j);
		}
	}

	
	
	
	@Override
	public IMatrix setData(int i, int j, float v) {
		if(i < 0 || i >= getNumberColumns() || j < 0 || j >= getNumberRows()) {
			throw new IndexOutOfBoundsException("Index: " + i+","+j + ", size: " + getNumberColumns() + "," + getNumberRows());
		}
		this.data[i][j] = v;
		return this;
	}

	
	
	
	@Override
	public IMatrix setDataCol(int column, float[] data) {
		if(column < 0 || column >= getNumberColumns()) {
			throw new IndexOutOfBoundsException("Index: " + column + ", size: " + getNumberColumns());
		}
		if(data.length != getNumberRows()) {
			throw new IllegalArgumentException("Input array length invalid: " + data.length + ". Should be " + getNumberRows());
		}
		for(int j=0; j<getNumberRows(); j++) {
			this.data[column][j] = data[j];
		}
		return this;
	}
	
	
	

	@Override
	public IMatrix setDataRow(int row, float[] data) {
		if(row < 0 || row >= getNumberRows()) {
			throw new IndexOutOfBoundsException("Index: " + row + ", size: " + getNumberRows());
		}
		if(data.length != getNumberColumns()) {
			throw new IllegalArgumentException("Input array length invalid: " + data.length + ". Should be " + getNumberColumns());
		}
		for(int i=0; i<getNumberColumns(); i++) {
			this.data[i][row] = data[i];
		}
		return this;
	}
	
	
	

	@Override
	public IMatrix switchColumns(int c0, int c1) {
		if( (c0 < 0) || (c0 >= getNumberColumns()) ) {
			throw new IndexOutOfBoundsException("Index: " + c0 + ", size: " + getNumberColumns());
		}
		if( (c1 < 0) || (c1 >= getNumberColumns()) ) {
			throw new IndexOutOfBoundsException("Index: " + c1 + ", size: " + getNumberColumns());
		}
		float tmp;
		for(int j=0; j<getNumberRows(); j++) {
			tmp = this.data[c0][j];
			data[c0][j] = data[c1][j];
			data[c1][j] = tmp;
		}
		return this;
	}

	
	
	
	@Override
	public IMatrix switchRows(int r0, int r1) {
		if( (r0 < 0) || (r0 >= getNumberRows()) ) {
			throw new IndexOutOfBoundsException("Index: " + r0 + ", size: " + getNumberRows());
		}
		if( (r1 < 0) || (r1 >= getNumberRows()) ) {
			throw new IndexOutOfBoundsException("Index: " + r1 + ", size: " + getNumberRows());
		}
		float tmp;
		for(int i=0; i<getNumberColumns(); i++) {
			tmp = this.data[i][r0];
			data[i][r0] = data[i][r1];
			data[i][r1] = tmp;
		}
		return this;
	}

	
}

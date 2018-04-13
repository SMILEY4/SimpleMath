package com.ruegnerlukas.simplemath.matrix.matrixN;

import com.ruegnerlukas.simplemath.matrix.IMatrix;
import com.ruegnerlukas.simplemath.matrix.matrix4.Matrix4l;
import com.ruegnerlukas.simplemath.vectors.IVector;
import com.ruegnerlukas.simplemath.vectors.vec2.Vector2l;
import com.ruegnerlukas.simplemath.vectors.vec3.Vector3l;
import com.ruegnerlukas.simplemath.vectors.vec4.Vector4l;
import com.ruegnerlukas.simplemath.vectors.vecN.VectorNl;

public class Matrixl implements IMatrix {

	
	
	
	/**
	 * @return an identity matrix with the given size
	 * */
	public static Matrixl createIdentity(int size) {
		Matrixl mat = null;
		if(size == 4) {
			mat = new Matrix4l();
		} else {
			mat = new Matrixl(size, size);
		}
		boolean wasUnsafe = mat.isUnsafe();
		mat.setUnsafe(true);
		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				if(i == j) {
					mat.set(i, j, 1);
				} else {
					mat.set(i, j, 0);
				}
			}
		}
		mat.setUnsafe(wasUnsafe);
		return mat;
	}
	
	
	
	
	
	
	private long[][] data;
	private int columns;
	private int rows;

	private boolean unsafe = false;
	
	
	
	
	
	
	/**
	 * creates a zero-matrix with the given number of rows and columns
	 * */
	public Matrixl(int columns, int rows) {
		this(columns, rows, 0);
	}
	
	
	/**
	 * creates matrix filled with the given value and with the given number of rows and columns
	 * */
	public Matrixl(int columns, int rows, long fill) {
		this.columns = columns;
		this.rows = rows;
		this.data = new long[columns][rows];
		for(int i=0; i<data.length; i++) {
			for(int j=0; j<data[i].length; j++) {
				data[i][j] = fill;
			}
		}
	}
	
	
	/**
	 * Creates a new matrix with the given data
	 * */
	public Matrixl(long[][] data) {
		this.data = data;
		this.columns = data.length;
		this.rows = data[0].length;
	}
	
	
	/**
	 * Creates a new matrix with the given vectors as either rows or columns
	 * */
	public Matrixl(IVector[] vectors, boolean asColumns) {
		int dim = vectors[0].getDimensions();
		if(!unsafe) {
			for(int i=0; i<vectors.length; i++) {
				if(dim != vectors[i].getDimensions()) {
					throw new IllegalArgumentException("All vectors must have the same dimension.");
				}
			}
		}
		
		this.columns = asColumns ? vectors.length : dim;
		this.rows = asColumns ? dim : vectors.length;
		this.data = new long[this.columns][this.rows];
		
		for(int i=0; i<this.columns; i++) {
			for(int j=0; j<this.rows; j++) {
				this.data[i][j] = asColumns ? vectors[i].getLong(j) : vectors[j].getLong(i);
			}
		}
		
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
	public int getInt(int column, int row) {
		return (int) this.getData(column, row);
	}

	
	

	@Override
	public long getLong(int column, int row) {
		return (long) this.getData(column, row);
	}


	
	
	@Override
	public float getFloat(int column, int row) {
		return (float) this.getData(column, row);
	}
	
	


	@Override
	public double getDouble(int column, int row) {
		return (double) this.getData(column, row);
	}
	
	
	
	
	/**
	 * @return the content of this matrix as a 2d array
	 * */
	public long[][] getData() {
		return this.data;
	}

	
	
	
	/**
	 * @return the value of the element at the given indices i and j
	 * */
	public long getData(int i, int j) {
		if( !unsafe && (i < 0 || i >= getNumberColumns() || j < 0 || j >= getNumberRows()) ) {
			throw new IndexOutOfBoundsException("Index: " + i+","+j + ", size: " + getNumberColumns() + "," + getNumberRows());
		}
		return this.data[i][j];
	}

	
	
	
	/**
	 * Writes the values of the given row "row" into the given array "dest"
	 * @param row	the index of the row
	 * @param dest	the destination array ( must be the same size as the row (number of columns) ) or null
	 * @return the row (dest) as an array
	 * */
	public long[] getRow(int row, long[] dest) {
		if(!unsafe) {
			if(dest.length != getNumberColumns()) {
				throw new IllegalArgumentException("Destination array length invalid: " + dest.length + ". Should be " + getNumberColumns());
			}
			if(row < 0 || row >= getNumberRows()) {
				throw new IndexOutOfBoundsException("Index: " + row + ", size: " + getNumberRows());
			}
		}
		for(int i=0; i<getNumberColumns(); i++) {
			dest[i] = getData(i, row);
		}
		return dest;
	}

	
	
	
	/**
	 * Writes the values of the given column "column" into the given array "dest"
	 * @param column	the index of the column
	 * @param dest		the destination array ( must be the same size as the column (number of rows) ) or null
	 * @return the column (dest) as an array
	 * */
	public long[] getColumn(int column, long[] dest) {
		if(!unsafe) {
			if(dest.length != getNumberRows()) {
				throw new IllegalArgumentException("Destination array length invalid: " + dest.length + ". Should be " + getNumberRows());
			}
			if(column < 0 || column >= getNumberColumns()) {
				throw new IndexOutOfBoundsException("Index: " + column + ", size: " + getNumberColumns());
			}
		}
		for(int j=0; j<getNumberRows(); j++) {
			dest[j] = getData(column, j);
		}
		return dest;
	}
	
	
	

	/**
	 * @return the row at the given index as an array
	 * */
	public long[] getRow(int row) {
		long[] data = new long[getNumberColumns()];
		getRow(row, data);
		return data;
	}

	
	
	
	/**
	 * @return the column at the given index as an array
	 * */
	public long[] getColumn(int column) {
		long[] data = new long[getNumberRows()];
		getColumn(column, data);
		return data;
	}

	
	
	
	/**
	 * @return the row at the given index as an Vector
	 * */
	public IVector getRowVector(int row) {
		final int n = getNumberColumns();
		if(n == 2) {
			return new Vector2l(data[0][row], data[1][row]);
		} else if(n ==3) {
			return new Vector3l(data[0][row], data[1][row], data[2][row]);
		} else if(n == 4) {
			return new Vector4l(data[0][row], data[1][row], data[2][row], data[3][row]);
		} else {
			return new VectorNl(getRow(row));
		}
	}

	
	
	
	/**
	 * @return the column at the given index as an Vector
	 * */
	public IVector getColumnVector(int column) {
		final int n = getNumberRows();
		if(n == 2) {
			return new Vector2l(data[column][0], data[column][1]);
		} else if(n == 3) {
			return new Vector3l(data[column][0], data[column][1], data[column][2]);
		} else if(n == 4) {
			return new Vector4l(data[column][0], data[column][1], data[column][2], data[column][3]);
		} else {
			return new VectorNl(getColumn(column));
		}
	}
	
	
	
	
	@Override
	public void getSubmatrix(int colStart, int rowStart, int colEnd, int rowEnd, IMatrix dest) {
		if(!unsafe) {
			if(colStart < 0 || colStart >= getNumberColumns()) {
				throw new IndexOutOfBoundsException("Index (colStart): " + colStart + ", size: " + getNumberColumns());
			}
			if(colEnd < 0 || colEnd >= getNumberColumns()) {
				throw new IndexOutOfBoundsException("Index (colEnd): " + colEnd + ", size: " + getNumberColumns());
			}
			if(rowStart < 0 || rowStart >= getNumberRows()) {
				throw new IndexOutOfBoundsException("Index (rowStart): " + rowStart + ", size: " + getNumberRows());
			}
			if(rowEnd < 0 || rowEnd >= getNumberRows()) {
				throw new IndexOutOfBoundsException("Index (rowEnd): " + rowEnd + ", size: " + getNumberRows());
			}
			if(dest.getNumberColumns() != colEnd-colStart+1) {
				throw new IllegalArgumentException("Destination matrix invalid: number of columns:" + dest.getNumberColumns() + ". Should be " + (colEnd-colStart+1) );
			}
			if(dest.getNumberRows() != rowEnd-rowStart+1) {
				throw new IllegalArgumentException("Destination matrix invalid: number of rows:" + dest.getNumberRows() + ". Should be " + (rowEnd-rowStart+1) );
			}
		}
		for(int c=colStart, i=0; c<=colEnd; c++, i++) {
			for(int r=rowStart, j=0; r<=rowEnd; r++, j++) {
				dest.set(i, j, this.data[c][r]);
			}
		}
	}

	
	
	
	@Override
	public Matrixl getSubmatrix(int colStart, int rowStart, int colEnd, int rowEnd) {
		Matrixl mat = new Matrixl(colEnd-colStart+1, rowEnd-rowStart+1);
		getSubmatrix(colStart, rowStart, colEnd, rowEnd, mat);
		return mat;
	}

	
	
	
	@Override
	public Matrixl switchColumns(int c0, int c1) {
		if(!unsafe) {
			if( (c0 < 0) || (c0 >= getNumberColumns()) ) {
				throw new IndexOutOfBoundsException("Index: " + c0 + ", size: " + getNumberColumns());
			}
			if( (c1 < 0) || (c1 >= getNumberColumns()) ) {
				throw new IndexOutOfBoundsException("Index: " + c1 + ", size: " + getNumberColumns());
			}
		}
		long tmp;
		for(int j=0; j<getNumberRows(); j++) {
			tmp = this.data[c0][j];
			data[c0][j] = data[c1][j];
			data[c1][j] = tmp;
		}
		return this;
	}

	
	
	
	@Override
	public Matrixl switchRows(int r0, int r1) {
		if(!unsafe) {
			if( (r0 < 0) || (r0 >= getNumberRows()) ) {
				throw new IndexOutOfBoundsException("Index: " + r0 + ", size: " + getNumberRows());
			}
			if( (r1 < 0) || (r1 >= getNumberRows()) ) {
				throw new IndexOutOfBoundsException("Index: " + r1 + ", size: " + getNumberRows());
			}
		}
		long tmp;
		for(int i=0; i<getNumberColumns(); i++) {
			tmp = this.data[i][r0];
			data[i][r0] = data[i][r1];
			data[i][r1] = tmp;
		}
		return this;
	}

	
	
	
	/**
	 * Uses the given array as new values of this matrix. Changes number of rows and columns.
	 * @return this matrix for chaining
	 * */
	public Matrixl set(long[][] data) {
		this.data = data;
		this.columns = data.length;
		this.rows = data[0].length;
		return this;
	}

	
	
	
	@Override
	public IMatrix set(int column, int row, Number value) {
		return this.set(column, row, value.longValue());
	}
	
	
	
	
	/**
	 * Sets the value of this matrix at the given index
	 * @return this matrix for chaining
	 * */
	public Matrixl set(int i, int j, long v) {
		if( !unsafe && (i < 0 || i >= getNumberColumns() || j < 0 || j >= getNumberRows()) ) {
			throw new IndexOutOfBoundsException("Index: " + i+","+j + ", size: " + getNumberColumns() + "," + getNumberRows());
		}
		this.data[i][j] = v;
		return this;
	}

	
	
	
	/**
	 * Sets the values of the given column
	 * @param column 	the index of the column
	 * @param data 		the array containg the new values (must be the same size as the column)
	 * @return this matrix for chaining
	 * */
	public Matrixl setColumn(int column, long[] data) {
		if(!unsafe) {
			if(column < 0 || column >= getNumberColumns()) {
				throw new IndexOutOfBoundsException("Index: " + column + ", size: " + getNumberColumns());
			}
			if(data.length != getNumberRows()) {
				throw new IllegalArgumentException("Input array length invalid: " + data.length + ". Should be " + getNumberRows());
			}
		}
		for(int j=0; j<getNumberRows(); j++) {
			this.data[column][j] = data[j];
		}
		return this;
	}

	
	
	
	/**
	 * Sets the values of the given row
	 * @param row 	the index of the row
	 * @param data 	the array containg the new values (must be the same size as the row)
	 * @return this matrix for chaining
	 * */
	public Matrixl setRow(int row, long[] data) {
		if(!unsafe) {
			if(row < 0 || row >= getNumberRows()) {
				throw new IndexOutOfBoundsException("Index: " + row + ", size: " + getNumberRows());
			}
			if(data.length != getNumberColumns()) {
				throw new IllegalArgumentException("Input array length invalid: " + data.length + ". Should be " + getNumberColumns());
			}
		}
		for(int i=0; i<getNumberColumns(); i++) {
			this.data[i][row] = data[i];
		}
		return this;
	}

	
	
	
	@Override
	public Matrixl copyData(int[][] data) {
		if( !unsafe && (data.length != this.getNumberColumns() || data[0].length != this.getNumberRows()) ) {
			throw new IllegalArgumentException("Input array length invalid: " + data.length + "," + data[0].length + ". Should be " + getNumberColumns() + "," + getNumberRows());
		}
		for(int i=0; i<this.getNumberColumns(); i++) {
			for(int j=0; j<this.getNumberRows(); j++) {
				this.data[i][j] = (long) data[i][j];
			}
		}
		return this;
	}

	
	
	
	@Override
	public Matrixl copyData(long[][] data) {
		if( !unsafe && (data.length != this.getNumberColumns() || data[0].length != this.getNumberRows()) ) {
			throw new IllegalArgumentException("Input array length invalid: " + data.length + "," + data[0].length + ". Should be " + getNumberColumns() + "," + getNumberRows());
		}
		for(int i=0; i<this.getNumberColumns(); i++) {
			for(int j=0; j<this.getNumberRows(); j++) {
				this.data[i][j] = (long) data[i][j];
			}
		}
		return this;
	}
	
	
	

	@Override
	public Matrixl copyData(float[][] data) {
		if( !unsafe && (data.length != this.getNumberColumns() || data[0].length != this.getNumberRows()) ) {
			throw new IllegalArgumentException("Input array length invalid: " + data.length + "," + data[0].length + ". Should be " + getNumberColumns() + "," + getNumberRows());
		}
		for(int i=0; i<this.getNumberColumns(); i++) {
			for(int j=0; j<this.getNumberRows(); j++) {
				this.data[i][j] = (long) data[i][j];
			}
		}
		return this;
	}

	
	

	@Override
	public Matrixl copyData(double[][] data) {
		if( !unsafe && (data.length != this.getNumberColumns() || data[0].length != this.getNumberRows()) ) {
			throw new IllegalArgumentException("Input array length invalid: " + data.length + "," + data[0].length + ". Should be " + getNumberColumns() + "," + getNumberRows());
		}
		for(int i=0; i<this.getNumberColumns(); i++) {
			for(int j=0; j<this.getNumberRows(); j++) {
				this.data[i][j] = (long) data[i][j];
			}
		}
		return this;
	}
	
	
	
	
	@Override
	public Matrixl add(IMatrix mat) {
		if(!unsafe && !compareSize(mat)) {
			throw new IllegalArgumentException("Input matrix size invalid: " + mat.getNumberColumns() + "," + mat.getNumberRows()
			+ ". Should be " + this.getNumberColumns() + "," + this.getNumberRows());
		}
		for(int j=0; j<this.getNumberRows(); j++) {
			for(int i=0; i<this.getNumberColumns(); i++) {
				this.data[i][j] += mat.getLong(i, j);
			}
		}
		return this;
	}

	
	
	
	@Override
	public Matrixl sub(IMatrix mat) {
		if(!unsafe && !compareSize(mat)) {
			throw new IllegalArgumentException("Input matrix size invalid: " + mat.getNumberColumns() + "," + mat.getNumberRows()
			+ ". Should be " + this.getNumberColumns() + "," + this.getNumberRows());
		}
		for(int j=0; j<this.getNumberRows(); j++) {
			for(int i=0; i<this.getNumberColumns(); i++) {
				this.data[i][j] -= mat.getLong(i, j);
			}
		}
		return this;
	}

	
	
	
	@Override
	public Matrixl mul(Number scalar) {
		return this.mul(scalar.doubleValue());
	}
	
	
	/**
	 * Multiplies this matrix by the given scalar
	 * @param scalar the scalar
	 * @return this matrix for chaining
	 * */
	public Matrixl mul(double scalar) {
		for(int j=0; j<this.getNumberRows(); j++) {
			for(int i=0; i<this.getNumberColumns(); i++) {
				this.data[i][j] *= scalar;
			}
		}
		return this;
	}
	

	
	
	@Override
	public Matrixl mul(IMatrix mat) {
		Matrixl.mul(this, mat, this, this.isUnsafe());
		return this;
	}

	
	@Override
	public Matrixl mul(IMatrix mat, IMatrix dest) {
		Matrixl.mul(this, mat, dest, this.isUnsafe());
		return this;
	}
	
	
	@Override
	public IMatrix mulLeft(IMatrix mat) {
		Matrixl.mul(mat, this, this, this.isUnsafe());
		return this;
	}
	

	@Override
	public IMatrix mulLeft(IMatrix mat, IMatrix dest) {
		Matrixl.mul(mat, this, dest, this.isUnsafe());
		return this;
	}
	
	
	/**
	 * Multiplies the left matrix with the right matrix and stores the result into the dest-matrix
	 * @return false, if dest is null
	 * */
	private static boolean mul(IMatrix left, IMatrix right, IMatrix dest, boolean unsafe) {
		
		if(dest == null) {
			return false;
		}
		
		IMatrix matA = left;
		IMatrix matB = right;
		
		int aCols = matA.getNumberColumns();// l
		int aRows = matA.getNumberRows();	// m 
		int bCols = matB.getNumberColumns();// m
		int bRows = matB.getNumberRows();	// n

		if(!unsafe && aRows != bCols) {
			throw new IllegalArgumentException("The number of columns (" +bCols + ") of the input matrix "
					+ "must match the number of rows (" + aRows + ") of this matrix.");
		}
		
		
		if( (matA instanceof Matrixl && matB instanceof Matrixi) || (matA instanceof Matrixi && matB instanceof Matrixl) ) {
			long[][] dataC = new long[aCols][bRows];	// l x n
			for(int i=0; i<aCols; i++) {
				for(int j=0; j<bRows; j++) {
					for(int k=0; k<aRows; k++) {
						dataC[i][j] += matA.getLong(i, k) * matB.getLong(k, j);
					}
				}
			}
			dest.copyData(dataC);
			
		} else {
			double[][] dataC = new double[aCols][bRows];	// l x n
			for(int i=0; i<aCols; i++) {
				for(int j=0; j<bRows; j++) {
					for(int k=0; k<aRows; k++) {
						dataC[i][j] += matA.getDouble(i, k) * matB.getDouble(k, j);
					}
				}
			}
			dest.copyData(dataC);
		}
		
		return true;
	}
	
	
	
	
	@Override
	public Matrixl negate() {
		for(int j=0; j<this.getNumberRows(); j++) {
			for(int i=0; i<this.getNumberColumns(); i++) {
				this.data[i][j] = -this.data[i][j];
			}
		}
		return this;
	}
	
	
	
	
	@Override
	public boolean isSquare() {
		return getNumberColumns() == getNumberRows();
	}

	
	
	
	@Override
	public boolean compare(IMatrix mat) {
		if(this.getNumberColumns() != mat.getNumberColumns() || this.getNumberRows() != mat.getNumberRows()) {
			return false;
		}
		for(int j=0; j<this.getNumberRows(); j++) {
			for(int i=0; i<this.getNumberColumns(); i++) {
				if(this.data[i][j] == mat.getLong(i, j)) {
					return false;
				}
			}
		}
		return true;
	}

	
	
	
	@Override
	public boolean compareSize(IMatrix mat) {
		if(this.getNumberColumns() != mat.getNumberColumns() || this.getNumberRows() != mat.getNumberRows()) {
			return false;
		} else {
			return true;
		}
	}

	
	
	
	@Override
	public Matrixl transpose() {
		long[][] dataTransp = new long[getNumberColumns()][getNumberRows()];
		for(int i=0; i<getNumberColumns(); i++) {
			for(int j=0; j<getNumberRows(); j++) {
				dataTransp[i][j] = this.data[j][i];
			}
		}
		this.data = dataTransp;
		return this;
	}

	
	
	
	@Override
	public boolean isUpperTriangular() {
		if(!unsafe) {
			if(!isSquare()) {
				throw new IllegalArgumentException("Matrix must be square.");
			}
			if(getNumberRows() == 1) {
				return true;
			}
		}
		for(int row=0; row<getNumberRows(); row++) {
			for(int col=0; col<getNumberColumns(); col++) {
				if(row > col && this.data[col][row] != 0) {
					return false;
				}
			}
		}
		return true;
	}

	
	
	
	@Override
	public Matrixl toUpperTriangle() {
		if(!unsafe && !isSquare()) {
			throw new IllegalArgumentException("Matrix must be square.");
		}
		
		long[][] m = this.data;
		long f1 = 0;
		long temp = 0;
		int tms = getNumberColumns();
		int v = 1;
		int iDF = 1;
		
		for(int col=0; col<tms-1; col++) {
			for(int row=col+1; row<tms; row++) {
				v = 1;
				
				out: while(m[col][col]==0) {
					if(col+v >= tms) {
						iDF = 0;
						break out;
					} else {
						for(int c=0; c<tms; c++) {
							temp = m[c][col];
							m[c][col] = m[c][col+v];
							m[c][col+v] = temp;
						}
						v++;
						iDF = iDF *= -1;
					}
				}
				
				if(m[col][col] != 0) {
					try {
						f1 = (-1) * m[col][row] / m[col][col];
						for(int i=col; i<tms; i++) {
							m[i][row] = f1 * m[i][col] + m[i][row];
						}
					} catch(Exception e) {
						// division by 0 -> ignore
					}
				}
				
			}
		}
		
		this.data = m;
		return this;
	}

	
	
	
	@Override
	public Number determinantGen() {
		return this.determinant();
	}
	
	
	/**
	 * @return the determinant of this matrix. This matrix must be a square matrix
	 * */
	public long determinant() {
		return determinant(this.data, unsafe);
	}

	
	private static long determinant(long[][] matrix, boolean unsafe) {
		
		if(!unsafe && matrix.length != matrix[0].length) {
			throw new IllegalArgumentException("Matrix must be square.");
		}
		
		if(matrix.length == 1) { // 1x1 matrix
			return matrix[0][0];
		}
		
		if(matrix.length == 2) { // 2x2 matrix
			return (matrix[0][0]*matrix[1][1]) - (matrix[0][1]*matrix[1][0]);
		}
		

		// NxN matrix
		int n = matrix.length;
		long det = 0;
		
		for(int i=0; i<n; i++) {
			long[][] smaller = new long[n-1][n-1];
			
			for(int a=1; a<n; a++) {
				for(int b=0; b<n; b++) {
					if(b < i) {
						smaller[a-1][b] = matrix[a][b];
					} else if(b > i) {
						smaller[a-1][b-1] = matrix[a][b];
					}
				}
			}

			int s = -1;
			if(i%2 == 0) {
				s = 1;
			}
			det += s * matrix[0][i] * determinant(smaller, unsafe);
		
		}
		
		return det;
	}
	
	
	
	
	@Override
	public Number traceGen() {
		return this.trace();
	}
	
	
	/**
	 * @return the trace of this matrix. This matrix must be a square matrix
	 * */
	public long trace() {
		if(!unsafe && !isSquare()) {
			throw new IllegalArgumentException("Matrix must be square.");
		}
		
		long trace = 0;
		for(int i=0; i<getNumberColumns(); i++) {
			trace += this.data[i][i];
		}
		return trace;
	}

	
	
	
	@Override
	public IMatrix setToIdentity() {
		if(!unsafe && !isSquare()) {
			throw new IllegalArgumentException("Matrix must be square.");
		}		
		for(int i=0; i<getNumberColumns(); i++) {
			for(int j=0; j<getNumberRows(); j++) {
				if(i == j) {
					getData()[i][j] = 1;
				} else {
					getData()[i][j] = 0;
				}
			}
		}
		return this;
	}
	
	
	
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("Matrix (long), " + this.getNumberColumns() + "x" + this.getNumberRows()).append(" (").append(Integer.toHexString(this.hashCode())).append(")");
		sb.append(System.lineSeparator());
		
		for(int j=0; j<this.getNumberRows(); j++) {
			sb.append("[");
			for(int i=0; i<this.getNumberColumns(); i++) {
				String strNumber = ""+this.data[i][j];
				sb.append(String.format("%1$10s", strNumber));
				if(i != getNumberColumns()-1) {
					sb.append(", ");
				}
			}
			
			sb.append("]").append(System.lineSeparator());
		}
		
		return sb.toString();
	}

	
	
	
	@Override
	public Matrixl copy() {
		return new Matrixl(getNumberColumns(), getNumberRows()).copyData(this.data);
	}

	
	
	
	@Override
	public Matrixl setUnsafe(boolean unsafe) {
		this.unsafe = unsafe;
		return this;
	}

	
	
	
	@Override
	public boolean isUnsafe() {
		return this.unsafe;
	}


}

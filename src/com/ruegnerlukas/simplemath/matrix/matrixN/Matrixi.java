package com.ruegnerlukas.simplemath.matrix.matrixN;

import com.ruegnerlukas.simplemath.matrix.IMatrix;
import com.ruegnerlukas.simplemath.matrix.matrix4.Matrix4i;
import com.ruegnerlukas.simplemath.vectors.IVector;
import com.ruegnerlukas.simplemath.vectors.vec2.Vector2i;
import com.ruegnerlukas.simplemath.vectors.vec3.Vector3i;
import com.ruegnerlukas.simplemath.vectors.vec4.Vector4i;
import com.ruegnerlukas.simplemath.vectors.vecN.VectorNi;

public class Matrixi implements IMatrixi {

	
	
	
	/**
	 * @return an identity matrix with the given size
	 * */
	public static Matrixi createIdentity(int size) {
		Matrixi mat = null;
		if(size == 4) {
			mat = new Matrix4i();
		} else {
			mat = new Matrixi(size, size);
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
	
	
	
	
	
	
	private int[][] data;
	private int columns;
	private int rows;

	private boolean unsafe = false;
	
	
	
	
	
	
	/**
	 * creates a zero-matrix with the given number of rows and columns
	 * */
	public Matrixi(int columns, int rows) {
		this(columns, rows, 0);
	}
	
	
	/**
	 * creates matrix filled with the given value and with the given number of rows and columns
	 * */
	public Matrixi(int columns, int rows, int fill) {
		this.columns = columns;
		this.rows = rows;
		this.data = new int[columns][rows];
		for(int i=0; i<data.length; i++) {
			for(int j=0; j<data[i].length; j++) {
				data[i][j] = fill;
			}
		}
	}
	
	
	/**
	 * Creates a new matrix with the given data
	 * */
	public Matrixi(int[][] data) {
		this.data = data;
		this.columns = data.length;
		this.rows = data[0].length;
	}
	
	
	/**
	 * Creates a new matrix with the given vectors as either rows or columns
	 * */
	public Matrixi(IVector[] vectors, boolean asColumns) {
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
		this.data = new int[this.columns][this.rows];
		
		for(int i=0; i<this.columns; i++) {
			for(int j=0; j<this.rows; j++) {
				this.data[i][j] = asColumns ? vectors[i].getInt(j) : vectors[j].getInt(i);
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
	
	
	
	
	@Override
	public int[][] getData() {
		return this.data;
	}

	
	
	
	@Override
	public int getData(int i, int j) {
		if( !unsafe && (i < 0 || i >= getNumberColumns() || j < 0 || j >= getNumberRows()) ) {
			throw new IndexOutOfBoundsException("Index: " + i+","+j + ", size: " + getNumberColumns() + "," + getNumberRows());
		}
		return this.data[i][j];
	}

	
	
	
	@Override
	public int[] getRow(int row, int[] dest) {
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

	
	
	
	@Override
	public int[] getColumn(int column, int[] dest) {
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
	
	
	

	@Override
	public int[] getRow(int row) {
		int[] data = new int[getNumberColumns()];
		getRow(row, data);
		return data;
	}

	
	
	
	@Override
	public int[] getColumn(int column) {
		int[] data = new int[getNumberRows()];
		getColumn(column, data);
		return data;
	}

	
	
	
	@Override
	public IVector getRowVector(int row) {
		final int n = getNumberColumns();
		if(n == 2) {
			return new Vector2i(data[0][row], data[1][row]);
		} else if(n ==3) {
			return new Vector3i(data[0][row], data[1][row], data[2][row]);
		} else if(n == 4) {
			return new Vector4i(data[0][row], data[1][row], data[2][row], data[3][row]);
		} else {
			return new VectorNi(getRow(row));
		}
	}

	
	
	
	@Override
	public IVector getColumnVector(int column) {
		final int n = getNumberRows();
		if(n == 2) {
			return new Vector2i(data[column][0], data[column][1]);
		} else if(n == 3) {
			return new Vector3i(data[column][0], data[column][1], data[column][2]);
		} else if(n == 4) {
			return new Vector4i(data[column][0], data[column][1], data[column][2], data[column][3]);
		} else {
			return new VectorNi(getColumn(column));
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
	public Matrixi getSubmatrix(int colStart, int rowStart, int colEnd, int rowEnd) {
		Matrixi mat = new Matrixi(colEnd-colStart+1, rowEnd-rowStart+1);
		getSubmatrix(colStart, rowStart, colEnd, rowEnd, mat);
		return mat;
	}

	
	
	
	@Override
	public Matrixi switchColumns(int c0, int c1) {
		if(!unsafe) {
			if( (c0 < 0) || (c0 >= getNumberColumns()) ) {
				throw new IndexOutOfBoundsException("Index: " + c0 + ", size: " + getNumberColumns());
			}
			if( (c1 < 0) || (c1 >= getNumberColumns()) ) {
				throw new IndexOutOfBoundsException("Index: " + c1 + ", size: " + getNumberColumns());
			}
		}
		int tmp;
		for(int j=0; j<getNumberRows(); j++) {
			tmp = this.data[c0][j];
			data[c0][j] = data[c1][j];
			data[c1][j] = tmp;
		}
		return this;
	}

	
	
	
	@Override
	public Matrixi switchRows(int r0, int r1) {
		if(!unsafe) {
			if( (r0 < 0) || (r0 >= getNumberRows()) ) {
				throw new IndexOutOfBoundsException("Index: " + r0 + ", size: " + getNumberRows());
			}
			if( (r1 < 0) || (r1 >= getNumberRows()) ) {
				throw new IndexOutOfBoundsException("Index: " + r1 + ", size: " + getNumberRows());
			}
		}
		int tmp;
		for(int i=0; i<getNumberColumns(); i++) {
			tmp = this.data[i][r0];
			data[i][r0] = data[i][r1];
			data[i][r1] = tmp;
		}
		return this;
	}

	
	
	
	@Override
	public Matrixi set(int[][] data) {
		this.data = data;
		this.columns = data.length;
		this.rows = data[0].length;
		return this;
	}

	
	
	
	@Override
	public IMatrix set(int column, int row, Number value) {
		return this.set(column, row, value.intValue());
	}
	
	
	
	
	@Override
	public Matrixi set(int i, int j, int v) {
		if( !unsafe && (i < 0 || i >= getNumberColumns() || j < 0 || j >= getNumberRows()) ) {
			throw new IndexOutOfBoundsException("Index: " + i+","+j + ", size: " + getNumberColumns() + "," + getNumberRows());
		}
		this.data[i][j] = v;
		return this;
	}

	
	
	
	@Override
	public Matrixi setColumn(int column, int[] data) {
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

	
	
	
	@Override
	public Matrixi setRow(int row, int[] data) {
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
	public Matrixi copyData(int[][] data) {
		if( !unsafe && (data.length != this.getNumberColumns() || data[0].length != this.getNumberRows()) ) {
			throw new IllegalArgumentException("Input array length invalid: " + data.length + "," + data[0].length + ". Should be " + getNumberColumns() + "," + getNumberRows());
		}
		for(int i=0; i<this.getNumberColumns(); i++) {
			for(int j=0; j<this.getNumberRows(); j++) {
				this.data[i][j] = (int) data[i][j];
			}
		}
		return this;
	}
	
	
	
	@Override
	public Matrixi copyData(long[][] data) {
		if( !unsafe && (data.length != this.getNumberColumns() || data[0].length != this.getNumberRows()) ) {
			throw new IllegalArgumentException("Input array length invalid: " + data.length + "," + data[0].length + ". Should be " + getNumberColumns() + "," + getNumberRows());
		}
		for(int i=0; i<this.getNumberColumns(); i++) {
			for(int j=0; j<this.getNumberRows(); j++) {
				this.data[i][j] = (int) data[i][j];
			}
		}
		return this;
	}

	
	

	@Override
	public Matrixi copyData(float[][] data) {
		if( !unsafe && (data.length != this.getNumberColumns() || data[0].length != this.getNumberRows()) ) {
			throw new IllegalArgumentException("Input array length invalid: " + data.length + "," + data[0].length + ". Should be " + getNumberColumns() + "," + getNumberRows());
		}
		for(int i=0; i<this.getNumberColumns(); i++) {
			for(int j=0; j<this.getNumberRows(); j++) {
				this.data[i][j] = (int) data[i][j];
			}
		}
		return this;
	}

	
	

	@Override
	public Matrixi copyData(double[][] data) {
		if( !unsafe && (data.length != this.getNumberColumns() || data[0].length != this.getNumberRows()) ) {
			throw new IllegalArgumentException("Input array length invalid: " + data.length + "," + data[0].length + ". Should be " + getNumberColumns() + "," + getNumberRows());
		}
		for(int i=0; i<this.getNumberColumns(); i++) {
			for(int j=0; j<this.getNumberRows(); j++) {
				this.data[i][j] = (int) data[i][j];
			}
		}
		return this;
	}
	
	
	
	
	@Override
	public Matrixi add(IMatrix mat) {
		if(!unsafe && !compareSize(mat)) {
			throw new IllegalArgumentException("Input matrix size invalid: " + mat.getNumberColumns() + "," + mat.getNumberRows()
			+ ". Should be " + this.getNumberColumns() + "," + this.getNumberRows());
		}
		for(int j=0; j<this.getNumberRows(); j++) {
			for(int i=0; i<this.getNumberColumns(); i++) {
				this.data[i][j] += mat.getInt(i, j);
			}
		}
		return this;
	}

	
	
	
	@Override
	public Matrixi sub(IMatrix mat) {
		if(!unsafe && !compareSize(mat)) {
			throw new IllegalArgumentException("Input matrix size invalid: " + mat.getNumberColumns() + "," + mat.getNumberRows()
			+ ". Should be " + this.getNumberColumns() + "," + this.getNumberRows());
		}
		for(int j=0; j<this.getNumberRows(); j++) {
			for(int i=0; i<this.getNumberColumns(); i++) {
				this.data[i][j] -= mat.getInt(i, j);
			}
		}
		return this;
	}

	
	
	
	@Override
	public Matrixi mul(Number scalar) {
		return this.scale(scalar.floatValue());
	}
	
	
	/**
	 * Multiplies this matrix by the given scalar
	 * @param scalar the scalar
	 * @return this matrix for chaining
	 * */
	public Matrixi scale(float scalar) {
		for(int j=0; j<this.getNumberRows(); j++) {
			for(int i=0; i<this.getNumberColumns(); i++) {
				this.data[i][j] *= scalar;
			}
		}
		return this;
	}
	

	
	
	@Override
	public Matrixi mul(IMatrix mat) {
		Matrixi.mul(this, mat, this, this.isUnsafe());
		return this;
	}

	
	@Override
	public Matrixi mul(IMatrix mat, IMatrix dest) {
		Matrixi.mul(this, mat, dest, this.isUnsafe());
		return this;
	}
	
	
	@Override
	public IMatrix mulLeft(IMatrix mat) {
		Matrixi.mul(mat, this, this, this.isUnsafe());
		return this;
	}
	

	@Override
	public IMatrix mulLeft(IMatrix mat, IMatrix dest) {
		Matrixi.mul(mat, this, dest, this.isUnsafe());
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
		
		
		if( (matA instanceof Matrixi && matB instanceof Matrixi) || (matA instanceof Matrixl && matB instanceof Matrixl) ) {
			int[][] dataC = new int[aCols][bRows];	// l x n
			for(int i=0; i<aCols; i++) {
				for(int j=0; j<bRows; j++) {
					for(int k=0; k<aRows; k++) {
						dataC[i][j] += matA.getInt(i, k) * matB.getInt(k, j);
					}
				}
			}
			dest.copyData(dataC);
			
		} else {
			float[][] dataC = new float[aCols][bRows];	// l x n
			for(int i=0; i<aCols; i++) {
				for(int j=0; j<bRows; j++) {
					for(int k=0; k<aRows; k++) {
						dataC[i][j] += matA.getFloat(i, k) * matB.getFloat(k, j);
					}
				}
			}
			dest.copyData(dataC);
		}
		
		return true;
	}
	
	
	
	
	@Override
	public Matrixi negate() {
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
				if(this.data[i][j] == mat.getInt(i, j)) {
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
	public Matrixi transpose() {
		int[][] dataTransp = new int[getNumberColumns()][getNumberRows()];
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
	public Matrixi toUpperTriangle() {
		if(!unsafe && !isSquare()) {
			throw new IllegalArgumentException("Matrix must be square.");
		}
		
		int[][] m = this.data;
		int f1 = 0;
		int temp = 0;
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
	public int determinant() {
		return determinant(this.data, unsafe);
	}

	
	private static int determinant(int[][] matrix, boolean unsafe) {
		
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
		int det = 0;
		
		for(int i=0; i<n; i++) {
			int[][] smaller = new int[n-1][n-1];
			
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
		return this.traceGen();
	}
	
	
	/**
	 * @return the trace of this matrix. This matrix must be a square matrix
	 * */
	public int trace() {
		if(!unsafe && !isSquare()) {
			throw new IllegalArgumentException("Matrix must be square.");
		}
		
		int trace = 0;
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
		
		sb.append("Matrix (int), " + this.getNumberColumns() + "x" + this.getNumberRows()).append(" (").append(Integer.toHexString(this.hashCode())).append(")");
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
	public Matrixi copy() {
		return new Matrixi(getNumberColumns(), getNumberRows()).copyData(this.data);
	}

	
	
	
	@Override
	public Matrixi setUnsafe(boolean unsafe) {
		this.unsafe = unsafe;
		return this;
	}

	
	
	
	@Override
	public boolean isUnsafe() {
		return this.unsafe;
	}




}

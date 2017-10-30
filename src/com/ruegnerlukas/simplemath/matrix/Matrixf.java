package com.ruegnerlukas.simplemath.matrix;

import com.ruegnerlukas.simplemath.MathUtils;
import com.ruegnerlukas.simplemath.vectors.IVector;
import com.ruegnerlukas.simplemath.vectors.vec2.Vector2f;
import com.ruegnerlukas.simplemath.vectors.vec3.Vector3f;
import com.ruegnerlukas.simplemath.vectors.vec4.Vector4f;
import com.ruegnerlukas.simplemath.vectors.vecN.VectorNf;

public class Matrixf implements IMatrixf {

	
	
	
	/**
	 * @return an identity matrix with the given size
	 * */
	public static Matrixf createIdentity(int size) {
		Matrixf mat = null;
		if(size == 4) {
			mat = new Matrix4f();
		} else {
			mat = new Matrixf(size, size);
		}
		boolean wasUnsafe = mat.isUnsafe();
		mat.setUnsafe(true);
		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				if(i == j) {
					mat.set(i, j, 1f);
				} else {
					mat.set(i, j, 0f);
				}
			}
		}
		mat.setUnsafe(wasUnsafe);
		return mat;
	}
	
	
	
	
	
	
	private float[][] data;
	private int columns;
	private int rows;

	private boolean unsafe = false;
	
	
	
	
	
	
	/**
	 * creates a zero-matrix with the given number of rows and columns
	 * */
	public Matrixf(int columns, int rows) {
		this(columns, rows, 0f);
	}
	
	
	/**
	 * creates matrix filled with the given value and with the given number of rows and columns
	 * */
	public Matrixf(int columns, int rows, float fill) {
		this.columns = columns;
		this.rows = rows;
		this.data = new float[columns][rows];
		for(int i=0; i<data.length; i++) {
			for(int j=0; j<data[i].length; j++) {
				data[i][j] = fill;
			}
		}
	}
	
	
	/**
	 * Creates a new matrix with the given data
	 * */
	public Matrixf(float[][] data) {
		this.data = data;
		this.columns = data.length;
		this.rows = data[0].length;
	}
	
	
	/**
	 * Creates a new matrix with the given vectors as either rows or columns
	 * */
	public Matrixf(IVector[] vectors, boolean asColumns) {
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
		this.data = new float[this.columns][this.rows];
		
		for(int i=0; i<this.columns; i++) {
			for(int j=0; j<this.rows; j++) {
				this.data[i][j] = asColumns ? vectors[i].getFloat(j) : vectors[j].getFloat(i);
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
	public float[][] getData() {
		return this.data;
	}

	
	
	
	@Override
	public float getData(int i, int j) {
		if( !unsafe && (i < 0 || i >= getNumberColumns() || j < 0 || j >= getNumberRows()) ) {
			throw new IndexOutOfBoundsException("Index: " + i+","+j + ", size: " + getNumberColumns() + "," + getNumberRows());
		}
		return this.data[i][j];
	}

	
	
	
	@Override
	public float[] getRow(int row, float[] dest) {
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
	public float[] getColumn(int column, float[] dest) {
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
	public float[] getRow(int row) {
		float[] data = new float[getNumberColumns()];
		getRow(row, data);
		return data;
	}

	
	
	
	@Override
	public float[] getColumn(int column) {
		float[] data = new float[getNumberRows()];
		getColumn(column, data);
		return data;
	}

	
	
	
	@Override
	public IVector getRowVector(int row) {
		final int n = getNumberColumns();
		if(n == 2) {
			return new Vector2f(data[0][row], data[1][row]);
		} else if(n ==3) {
			return new Vector3f(data[0][row], data[1][row], data[2][row]);
		} else if(n == 4) {
			return new Vector4f(data[0][row], data[1][row], data[2][row], data[3][row]);
		} else {
			return new VectorNf(getRow(row));
		}
	}

	
	
	
	@Override
	public IVector getColumnVector(int column) {
		final int n = getNumberRows();
		if(n == 2) {
			return new Vector2f(data[column][0], data[column][1]);
		} else if(n == 3) {
			return new Vector3f(data[column][0], data[column][1], data[column][2]);
		} else if(n == 4) {
			return new Vector4f(data[column][0], data[column][1], data[column][2], data[column][3]);
		} else {
			return new VectorNf(getColumn(column));
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
		if(dest instanceof IMatrixf) {
			IMatrixf destf = (IMatrixf)dest;
			for(int c=colStart, i=0; c<=colEnd; c++, i++) {
				for(int r=rowStart, j=0; r<=rowEnd; r++, j++) {
					destf.set(i, j, this.data[c][r]);
				}
			}
		} else {
			// TODO: other matrix-types
		}
		
	}

	
	
	
	@Override
	public Matrixf getSubmatrix(int colStart, int rowStart, int colEnd, int rowEnd) {
		Matrixf mat = new Matrixf(colEnd-colStart+1, rowEnd-rowStart+1);
		getSubmatrix(colStart, rowStart, colEnd, rowEnd, mat);
		return mat;
	}

	
	
	
	@Override
	public Matrixf switchColumns(int c0, int c1) {
		if(!unsafe) {
			if( (c0 < 0) || (c0 >= getNumberColumns()) ) {
				throw new IndexOutOfBoundsException("Index: " + c0 + ", size: " + getNumberColumns());
			}
			if( (c1 < 0) || (c1 >= getNumberColumns()) ) {
				throw new IndexOutOfBoundsException("Index: " + c1 + ", size: " + getNumberColumns());
			}
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
	public Matrixf switchRows(int r0, int r1) {
		if(!unsafe) {
			if( (r0 < 0) || (r0 >= getNumberRows()) ) {
				throw new IndexOutOfBoundsException("Index: " + r0 + ", size: " + getNumberRows());
			}
			if( (r1 < 0) || (r1 >= getNumberRows()) ) {
				throw new IndexOutOfBoundsException("Index: " + r1 + ", size: " + getNumberRows());
			}
		}
		float tmp;
		for(int i=0; i<getNumberColumns(); i++) {
			tmp = this.data[i][r0];
			data[i][r0] = data[i][r1];
			data[i][r1] = tmp;
		}
		return this;
	}

	
	
	
	@Override
	public Matrixf set(float[][] data) {
		this.data = data;
		this.columns = data.length;
		this.rows = data[0].length;
		return this;
	}

	
	
	
	@Override
	public IMatrix set(int column, int row, Number value) {
		return this.set(column, row, value.floatValue());
	}
	
	
	
	
	@Override
	public Matrixf set(int i, int j, float v) {
		if( !unsafe && (i < 0 || i >= getNumberColumns() || j < 0 || j >= getNumberRows()) ) {
			throw new IndexOutOfBoundsException("Index: " + i+","+j + ", size: " + getNumberColumns() + "," + getNumberRows());
		}
		this.data[i][j] = v;
		return this;
	}

	
	
	
	@Override
	public Matrixf setColumn(int column, float[] data) {
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
	public Matrixf setRow(int row, float[] data) {
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
	public Matrixf copyData(int[][] data) {
		if( !unsafe && (data.length != this.getNumberColumns() || data[0].length != this.getNumberRows()) ) {
			throw new IllegalArgumentException("Input array length invalid: " + data.length + "," + data[0].length + ". Should be " + getNumberColumns() + "," + getNumberRows());
		}
		for(int i=0; i<this.getNumberColumns(); i++) {
			for(int j=0; j<this.getNumberRows(); j++) {
				this.data[i][j] = (float) data[i][j];
			}
		}
		return this;
	}

	
	

	@Override
	public Matrixf copyData(float[][] data) {
		if( !unsafe && (data.length != this.getNumberColumns() || data[0].length != this.getNumberRows()) ) {
			throw new IllegalArgumentException("Input array length invalid: " + data.length + "," + data[0].length + ". Should be " + getNumberColumns() + "," + getNumberRows());
		}
		for(int i=0; i<this.getNumberColumns(); i++) {
			for(int j=0; j<this.getNumberRows(); j++) {
				this.data[i][j] = data[i][j];
			}
		}
		return this;
	}

	
	

	@Override
	public Matrixf copyData(double[][] data) {
		if( !unsafe && (data.length != this.getNumberColumns() || data[0].length != this.getNumberRows()) ) {
			throw new IllegalArgumentException("Input array length invalid: " + data.length + "," + data[0].length + ". Should be " + getNumberColumns() + "," + getNumberRows());
		}
		for(int i=0; i<this.getNumberColumns(); i++) {
			for(int j=0; j<this.getNumberRows(); j++) {
				this.data[i][j] = (float) data[i][j];
			}
		}
		return this;
	}
	
	
	
	
	@Override
	public Matrixf add(IMatrix mat) {
		if(!unsafe && !compareSize(mat)) {
			throw new IllegalArgumentException("Input matrix size invalid: " + mat.getNumberColumns() + "," + mat.getNumberRows()
			+ ". Should be " + this.getNumberColumns() + "," + this.getNumberRows());
		}
		if(mat instanceof IMatrixf) {
			IMatrixf matf = (IMatrixf)mat;
			for(int j=0; j<this.getNumberRows(); j++) {
				for(int i=0; i<this.getNumberColumns(); i++) {
					this.data[i][j] += matf.getData()[i][j];
				}
			}
		} else {
			// TODO: other matrix-types
		}
		return this;
	}

	
	
	
	@Override
	public Matrixf sub(IMatrix mat) {
		if(!unsafe && !compareSize(mat)) {
			throw new IllegalArgumentException("Input matrix size invalid: " + mat.getNumberColumns() + "," + mat.getNumberRows()
			+ ". Should be " + this.getNumberColumns() + "," + this.getNumberRows());
		}
		if(mat instanceof IMatrixf) {
			IMatrixf matf = (IMatrixf)mat;
			for(int j=0; j<this.getNumberRows(); j++) {
				for(int i=0; i<this.getNumberColumns(); i++) {
					this.data[i][j] -= matf.getData()[i][j];
				}
			}
		} else {
			// TODO: other matrix-types
		}
		return this;
	}

	
	
	
	@Override
	public Matrixf scale(Number scalar) {
		return this.scale(scalar.floatValue());
	}
	
	
	/**
	 * Multiplies this matrix by the given scalar
	 * @param scalar the scalar
	 * @return this matrix for chaining
	 * */
	public Matrixf scale(float scalar) {
		for(int j=0; j<this.getNumberRows(); j++) {
			for(int i=0; i<this.getNumberColumns(); i++) {
				this.data[i][j] *= scalar;
			}
		}
		return this;
	}
	

	
	
	@Override
	public Matrixf mul(IMatrix mat) {
		Matrixf dest = this;
		mul(mat, dest);
		return this;
	}

	
	
	
	@Override
	public Matrixf mul(IMatrix mat, IMatrix dest) {
		
		Matrixf matA = this;
		IMatrix matB = mat;
		
		int aCols = matA.getNumberColumns();// l
		int aRows = matA.getNumberRows();	// m 
		int bCols = matB.getNumberColumns();// m
		int bRows = matB.getNumberRows();	// n

		if(!unsafe && aRows != bCols) {
			throw new IllegalArgumentException("The number of columns (" +bCols + ") of the input matrix "
					+ "must match the number of rows (" + aRows + ") of this matrix.");
		}
		
		float[][] dataA = matA.getData();
		float[][] dataB = null;
		if(matB instanceof IMatrixf) {
			dataB = ((IMatrixf)matB).getData();
		} else {
			// TODO: other matrix types
			return this;
		}
		float[][] dataC = new float[aCols][bRows];	// l x n
		
		for(int i=0; i<aCols; i++) {
			for(int j=0; j<bRows; j++) {
				for(int k=0; k<aRows; k++) {
					dataC[i][j] += dataA[i][k] * dataB[k][j];
				}
			}
		}
		

		if(dest == null) {
			return new Matrixf(dataC);
		} else {
			return (Matrixf) dest.copyData(dataC);
		}
	}

	
	
	
	@Override
	public Matrixf negate() {
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
		float[][] dataMat = null;
		if(mat instanceof IMatrixf) {
			dataMat = ((IMatrixf)mat).getData();
		} else {
			// TODO: other matrix types
			return false;
		}
		for(int j=0; j<this.getNumberRows(); j++) {
			for(int i=0; i<this.getNumberColumns(); i++) {
				if( !MathUtils.isNearlyEqual(this.data[i][j], dataMat[i][j], true) ) {
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
	public Matrixf transpose() {
		float[][] dataTransp = new float[getNumberColumns()][getNumberRows()];
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
				if(row > col && !MathUtils.isNearlyEqual(this.data[col][row], 0f)) {
					return false;
				}
			}
		}
		return true;
	}

	
	
	
	@Override
	public Matrixf toUpperTriangle() {
		if(!unsafe && !isSquare()) {
			throw new IllegalArgumentException("Matrix must be square.");
		}
		
		float[][] m = this.data;
		float f1 = 0;
		float temp = 0;
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
				
				if(!MathUtils.isNearlyEqual(m[col][col], 0)) {
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
	public float determinant() {
		return determinant(this.data, unsafe);
	}

	
	private static float determinant(float[][] matrix, boolean unsafe) {
		
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
		float det = 0;
		
		for(int i=0; i<n; i++) {
			float[][] smaller = new float[n-1][n-1];
			
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
	public float trace() {
		if(!unsafe && !isSquare()) {
			throw new IllegalArgumentException("Matrix must be square.");
		}
		
		float trace = 0;
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
		
		sb.append("Matrix (float), " + this.getNumberColumns() + "x" + this.getNumberRows()).append(" (").append(Integer.toHexString(this.hashCode())).append(")");
		sb.append(System.lineSeparator());
		
		for(int j=0; j<this.getNumberRows(); j++) {
			sb.append("[");
			for(int i=0; i<this.getNumberColumns(); i++) {
				String strNumber = String.format("%.4f", this.data[i][j]);
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
	public Matrixf copy() {
		return new Matrixf(getNumberColumns(), getNumberRows()).copyData(this.data);
	}

	
	
	
	@Override
	public Matrixf setUnsafe(boolean unsafe) {
		this.unsafe = unsafe;
		return this;
	}

	
	
	
	@Override
	public boolean isUnsafe() {
		return this.unsafe;
	}




}

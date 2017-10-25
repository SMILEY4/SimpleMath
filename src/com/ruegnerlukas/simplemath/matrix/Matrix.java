package com.ruegnerlukas.simplemath.matrix;

import com.ruegnerlukas.simplemath.MathUtils;
import com.ruegnerlukas.simplemath.vectors.IVector;
import com.ruegnerlukas.simplemath.vectors.vec2.Vector2f;
import com.ruegnerlukas.simplemath.vectors.vec3.Vector3f;
import com.ruegnerlukas.simplemath.vectors.vec4.Vector4f;
import com.ruegnerlukas.simplemath.vectors.vecN.VectorNf;

public class Matrix implements IMatrix {

	
	
	
	private float[][] data;
	private int columns;
	private int rows;

	private boolean unsafe = false;
	
	
	
	
	
	
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
	
	
	
	
	public Matrix(IVector[] vectors, boolean asColumns) {
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
	public Matrix clone() {
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
		if( !unsafe && (i < 0 || i >= getNumberColumns() || j < 0 || j >= getNumberRows()) ) {
			throw new IndexOutOfBoundsException("Index: " + i+","+j + ", size: " + getNumberColumns() + "," + getNumberRows());
		}
		return this.data[i][j];
	}

	
	
	
	@Override
	public void getRow(int row, float[] dest) {
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
	}

	
	
	
	@Override
	public void getColumn(int column, float[] dest) {
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
	public void getSubmatrix(int c0, int r0, int c1, int r1, IMatrix dest) {	// c1, r1 included
		if(!unsafe) {
			if(c0 < 0 || c0 >= getNumberColumns()) {
				throw new IndexOutOfBoundsException("Index (c0): " + c0 + ", size: " + getNumberColumns());
			}
			if(c1 < 0 || c1 >= getNumberColumns()) {
				throw new IndexOutOfBoundsException("Index (c1): " + c1 + ", size: " + getNumberColumns());
			}
			if(r0 < 0 || r0 >= getNumberRows()) {
				throw new IndexOutOfBoundsException("Index (r0): " + r0 + ", size: " + getNumberRows());
			}
			if(r1 < 0 || r1 >= getNumberRows()) {
				throw new IndexOutOfBoundsException("Index (r1): " + r1 + ", size: " + getNumberRows());
			}
			if(dest.getNumberColumns() != c1-c0+1) {
				throw new IllegalArgumentException("Destination matrix invalid: number of columns:" + dest.getNumberColumns() + ". Should be " + (c1-c0) );
			}
			if(dest.getNumberRows() != r1-r0+1) {
				throw new IllegalArgumentException("Destination matrix invalid: number of rows:" + dest.getNumberRows() + ". Should be " + (r1-r0) );
			}
		}
		for(int c=c0, i=0; c<=c1; c++, i++) {
			for(int r=r0, j=0; r<=r1; r++, j++) {
				dest.setData(i, j, this.data[c][r]);
			}
		}
		
	}


	
	
	@Override
	public Matrix getSubmatrix(int c0, int r0, int c1, int r1) {
		Matrix mat = new Matrix(c1-c0+1, r1-r0+1);
		getSubmatrix(c0, r0, c1, r1, mat);
		return mat;
	}
	
	
	
	
	@Override
	public Matrix setData(float[][] data) {
		this.data = data;
		this.columns = data.length;
		this.rows = data[0].length;
		return this;
	}
	
	
	
	
	@Override
	public Matrix copyData(float[][] data) {
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
	public Matrix setData(int i, int j, float v) {
		if( !unsafe && (i < 0 || i >= getNumberColumns() || j < 0 || j >= getNumberRows()) ) {
			throw new IndexOutOfBoundsException("Index: " + i+","+j + ", size: " + getNumberColumns() + "," + getNumberRows());
		}
		this.data[i][j] = v;
		return this;
	}

	
	
	
	@Override
	public Matrix setDataCol(int column, float[] data) {
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
	public Matrix setDataRow(int row, float[] data) {
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
	public Matrix switchColumns(int c0, int c1) {
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
	public Matrix switchRows(int r0, int r1) {
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
				if( !MathUtils.isNearlyEqual(this.data[i][j], mat.getData()[i][j], true) ) {
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
	public Matrix transpose() {
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
	public Matrix add(IMatrix mat) {
		if(!unsafe && !compareSize(mat)) {
			throw new IllegalArgumentException("Input matrix size invalid: " + mat.getNumberColumns() + "," + mat.getNumberRows()
			+ ". Should be " + this.getNumberColumns() + "," + this.getNumberRows());
		}
		for(int j=0; j<this.getNumberRows(); j++) {
			for(int i=0; i<this.getNumberColumns(); i++) {
				this.data[i][j] += mat.getData()[i][j];
			}
		}
		return this;
	}


	
	
	@Override
	public Matrix sub(IMatrix mat) {
		if(!unsafe && !compareSize(mat)) {
			throw new IllegalArgumentException("Input matrix size invalid: " + mat.getNumberColumns() + "," + mat.getNumberRows()
			+ ". Should be " + this.getNumberColumns() + "," + this.getNumberRows());
		}
		for(int j=0; j<this.getNumberRows(); j++) {
			for(int i=0; i<this.getNumberColumns(); i++) {
				this.data[i][j] -= mat.getData()[i][j];
			}
		}
		return this;
	}

	
	

	@Override
	public Matrix scale(float scalar) {
		for(int j=0; j<this.getNumberRows(); j++) {
			for(int i=0; i<this.getNumberColumns(); i++) {
				this.data[i][j] *= scalar;
			}
		}
		return this;
	}

	
	

	@Override
	public Matrix mul(IMatrix mat) {
		Matrix dest = this;
		mul(mat, dest);
		return this;
	}
	
	
	@Override
	public IMatrix mul(IMatrix mat, IMatrix dest) {
		
		Matrix matA = this;
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
		float[][] dataB = matB.getData();
		float[][] dataC = new float[aCols][bRows];	// l x n
		
		for(int i=0; i<aCols; i++) {
			for(int j=0; j<bRows; j++) {
				for(int k=0; k<aRows; k++) {
					dataC[i][j] += dataA[i][k] * dataB[k][j];
				}
			}
		}
		

		if(dest == null) {
			return new Matrix(dataC);
		} else {
			return dest.copyData(dataC);
		}
		
	}



	
	@Override
	public String toFormattedString() {
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
	public Matrix toUpperTriangle() {
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

	
	
	
	public Matrix inverse() {
		
		int tms = getNumberColumns();
		float[][] m = new float[tms][tms];
		float[][] mm = adjoint(this.copy(), unsafe).getData();
		float det = determinant();
		float dd = 0;

		if(MathUtils.isNearlyEqual(det, 0f)) {
			// determinant = 0 -> not invertable
			return this;
		} else {
			dd = 1f / det;
		}

		for(int i=0; i<tms; i++) {
			for(int j=0; j<tms; j++) {
				m[i][j] = dd * mm[i][j];
			}
		}
		
		this.data = m;
		return this;
	}

	
	
	
	public Matrix adjoint() {
		return adjoint(this, unsafe);
	}
	
	private static Matrix adjoint(Matrix mat, boolean unsafe) {
		
		float[][] a = mat.getData();
		int tms = mat.getNumberColumns();
		float[][] m = new float[tms][tms];
		int ii, jj, ia, ja;
		float det;
		
		for(int i=0; i<tms; i++) {
			for(int j=0; j<tms; j++) {
				
				ia = ja = 0;
				float[][] ap = new float[tms-1][tms-1];
				
				for(ii=0; ii<tms; ii++) {
					
					for(jj=0; jj<tms; jj++) {
						if( (ii!=i) && (jj!=j)) {
							ap[ia][ja] = a[ii][jj];
							ja++;
						}
					}
					if( (ii!=i) && (jj!=j) ) {
						ia++;
					}
					ja=0;
				}
				
				det = determinant(ap, unsafe);
				m[i][j] = (float)Math.pow(-1, i+j) * det;
			}
		}
		
		mat.setData(m);
		mat.transpose();
		return mat;
		
	}
	
	
	public Matrix copy() {
		return new Matrix(getNumberColumns(), getNumberRows()).copyData(this.data);
	}

	
	
	
	public Matrix setUnsafe(boolean unsafe) {
		this.unsafe = unsafe;
		return this;
	}
	
	
	public boolean isUnsafe() {
		return this.unsafe;
	}
	

}















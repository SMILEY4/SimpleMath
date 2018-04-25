package com.ruegnerlukas.simplemath.vectors.vecN;

import java.util.Arrays;


public class VectorNd implements IVectorN {

	
	
	
	/** Used when comparing two double values. */
	public static final double EPSILON = 0.0000001f;
	
	
	
	
	/** the values of the components of this vector*/
	private final double[] values;
	
	/** the size / number of dimensions of this vector */
	private final int size;
	
	
	
	
	
	
	/**
	 * creates a zero-vector with the given size
	 * */
	public VectorNd(int size) {
		this(new double[size]);
	}
	

	/**
	 * creates a vector with the same values and size as the given vector
	 * */
	public VectorNd(IVectorN vec) {
		this.size = vec.getDimensions();
		this.values = new double[vec.getDimensions()];
		if(vec instanceof VectorNd) {
			System.arraycopy( ((VectorNd)vec).get(), 0, this.values, 0, getDimensions());
		} else {
			for(int i=getDimensions()-1; i>=0; i--) {
				values[i] = vec.getDouble(i);
			}
		}
	}
	
	
	/**
	 * creates a vector with the given values and the size of the given array
	 * */
	public VectorNd(double[] values) {
		this.values = values;
		this.size = values.length;
	}
	
	
	
	
	
	
	@Override
	public int getDimensions() {
		return size;
	}

	
	
	
	@Override
	public VectorNd setAt(int index, Number value) {
		if( (0 <= index) && (index < getDimensions()) ) {
			values[index] = value.doubleValue();
			return this;
		} else {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + getDimensions());
		}
	}

	
	
	
	@Override
	public int getInt(int index) {
		if( (0 <= index) && (index < getDimensions()) ) {
			return (int) values[index];
		} else {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + getDimensions());
		}
	}

	
	@Override
	public long getLong(int index) {
		if( (0 <= index) && (index < getDimensions()) ) {
			return (long) values[index];
		} else {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + getDimensions());
		}
	}

	
	@Override
	public float getFloat(int index) {
		if( (0 <= index) && (index < getDimensions()) ) {
			return (float) values[index];
		} else {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + getDimensions());
		}
	}

	
	@Override
	public double getDouble(int index) {
		if( (0 <= index) && (index < getDimensions()) ) {
			return (double) values[index];
		} else {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + getDimensions());
		}
	}

	
	
	
	/**
	 * @return the array of values of this vector
	 * */
	public double[] get() {
		return this.values;
	}
	
	
	
	
	@Override
	public VectorNd negate() {
		for(int i=getDimensions()-1; i>=0; i--) {
			values[i] = -values[i];
		}
		return this;
	}

	
	
	
	@Override
	public VectorNd normalize() {
		final double len = length();
		for(int i=getDimensions()-1; i>=0; i--) {
			values[i] /= len;
		}
		return this;
	}

	
	
	
	@Override
	public VectorNd copy() {
		return new VectorNd(this);
	}

	
	
	
	@Override
	public VectorNd set(IVectorN v) {
		if(this.getDimensions() == v.getDimensions()) {
			if(v instanceof VectorNd) {
				System.arraycopy( ((VectorNd)v).get(), 0, this.values, 0, this.getDimensions());
			} else {
				for(int i=getDimensions()-1; i>=0; i--) {
					values[i] = v.getDouble(i);
				}
			}
			return this;
		} else {
			throw new IllegalArgumentException("Size Input: " + v.getDimensions() + ", size Vector: " + getDimensions());
		}
	}

	
	
	
	@Override
	public VectorNd setGen(Number... a) {
		if(a.length == 1) {
			Arrays.fill(this.values, a[0].doubleValue());
			return this;
		} else if(this.getDimensions() == a.length) {
			for(int i=getDimensions()-1; i>=0; i--) {
				values[i] = a[i].doubleValue();
			}
			return this;
		} else {
			throw new IllegalArgumentException("Size Input: " + a.length + ", size Vector: " + getDimensions());
		}
	}

	
	/**
	 * Sets the components of this vector.
	 * @param a a list of values. The list must have the same size as this vector or the size 1
	 * @return this vector for chaining
	 * */
	public VectorNd set(double... a) {
		if(a.length == 1) {
			Arrays.fill(this.values, a[0]);
			return this;
		} else if(this.getDimensions() == a.length) {
			System.arraycopy(a, 0, this.values, 0, this.getDimensions());
			return this;
		} else {
			throw new IllegalArgumentException("Size Input: " + a.length + ", size Vector: " + getDimensions());
		}
	}
	
	
	
	
	@Override
	public VectorNi toIntVector() {
		return new VectorNi(this);
	}

	
	@Override
	public VectorNl toLongVector() {
		return new VectorNl(this);
	}

	
	@Override
	public VectorNf toFloatVector() {
		return new VectorNf(this);
	}

	
	@Override
	public VectorNd toDoubleVector() {
		return this.copy();
	}

	
	@Override
	public String toString() {
		String str = "VectorNd." + this.hashCode() + "(";
		for(int i=0; i<values.length; i++) {
			str += values[i];
			if(i!=values.length-1) {
				str += ", ";
			}
		}
		str += ")";
		return str;
	}
	
	
	
	
	@Override
	public VectorNd add(IVectorN vec) {
		if(this.getDimensions() == vec.getDimensions()) {
			for(int i=getDimensions()-1; i>=0; i--) {
				values[i] += vec.getDouble(i);
			}
			return this;
		} else {
			throw new IllegalArgumentException("Size Input: " + vec.getDimensions() + ", size Vector: " + getDimensions());
		}
	}
	

	@Override
	public VectorNd addGen(Number... values) {
		if(values.length == 1) {
			double value = values[0].doubleValue();
			for(int i=getDimensions()-1; i>=0; i--) {
				this.values[i] += value;
			}
			return this;
		} else if(this.getDimensions() == values.length) {
			for(int i=getDimensions()-1; i>=0; i--) {
				this.values[i] += values[i].doubleValue();
			}
			return this;
		} else {
			throw new IllegalArgumentException("Size Input: " + values.length + ", size Vector: " + getDimensions());
		}
	}

	
	/**
	 * Adds the given values to this vector.
	 * @param values the list of values. The list must have the same size as this vector or the size 1
	 * @return this vector for chaining
	 * */
	public VectorNd add(double... values) {
		if(values.length == 1) {
			double value = values[0];
			for(int i=getDimensions()-1; i>=0; i--) {
				this.values[i] += value;
			}
			return this;
		} else if(this.getDimensions() == values.length) {
			for(int i=getDimensions()-1; i>=0; i--) {
				this.values[i] += values[i];
			}
			return this;
		} else {
			throw new IllegalArgumentException("Size Input: " + values.length + ", size Vector: " + getDimensions());
		}
	}
	

	
	
	@Override
	public VectorNd sub(IVectorN vec) {
		if(this.getDimensions() == vec.getDimensions()) {
			for(int i=getDimensions()-1; i>=0; i--) {
				this.values[i] -= vec.getDouble(i);
			}
			return this;
		} else {
			throw new IllegalArgumentException("Size Input: " + vec.getDimensions() + ", size Vector: " + getDimensions());
		}
	}

	
	@Override
	public VectorNd subGen(Number... values) {
		if(values.length == 1) {
			double value = values[0].doubleValue();
			for(int i=getDimensions()-1; i>=0; i--) {
				this.values[i] -= value;
			}
			return this;
		} else if(this.getDimensions() == values.length) {
			for(int i=getDimensions()-1; i>=0; i--) {
				this.values[i] -= values[i].doubleValue();
			}
			return this;
		} else {
			throw new IllegalArgumentException("Size Input: " + values.length + ", size Vector: " + getDimensions());
		}
	}

	
	/**
	 * Subtracts the given values from this vector.
	 * @param values the list of values. The list must have the same size as this vector or the size 1
	 * @return this vector for chaining
	 * */
	public VectorNd sub(double... values) {
		if(values.length == 1) {
			double value = values[0];
			for(int i=getDimensions()-1; i>=0; i--) {
				this.values[i] -= value;
			}
			return this;
		} else if(this.getDimensions() == values.length) {
			for(int i=getDimensions()-1; i>=0; i--) {
				this.values[i] -= values[i];
			}
			return this;
		} else {
			throw new IllegalArgumentException("Size Input: " + values.length + ", size Vector: " + getDimensions());
		}
	}
	
	
	
	
	@Override
	public VectorNd mul(IVectorN vec) {
		if(this.getDimensions() == vec.getDimensions()) {
			for(int i=getDimensions()-1; i>=0; i--) {
				this.values[i] *= vec.getDouble(i);
			}
			return this;
		} else {
			throw new IllegalArgumentException("Size Input: " + vec.getDimensions() + ", size Vector: " + getDimensions());
		}
	}
	

	@Override
	public VectorNd mulGen(Number... values) {
		if(values.length == 1) {
			double value = values[0].doubleValue();
			for(int i=getDimensions()-1; i>=0; i--) {
				this.values[i] *= value;
			}
			return this;
		} else if(this.getDimensions() == values.length) {
			for(int i=getDimensions()-1; i>=0; i--) {
				this.values[i] *= values[i].doubleValue();
			}
			return this;
		} else {
			throw new IllegalArgumentException("Size Input: " + values.length + ", size Vector: " + getDimensions());
		}
	}

	
	/**
	 * Multiplies this vector with the given vector.
	 * @param values the vector as a list of values with the same size as this vector
	 * @return this vector for chaining
	 * */
	public VectorNd mul(double... values) {
		if(values.length == 1) {
			double value = values[0];
			for(int i=getDimensions()-1; i>=0; i--) {
				this.values[i] *= value;
			}
			return this;
		} else if(this.getDimensions() == values.length) {
			for(int i=getDimensions()-1; i>=0; i--) {
				this.values[i] *= values[i];
			}
			return this;
		} else {
			throw new IllegalArgumentException("Size Input: " + values.length + ", size Vector: " + getDimensions());
		}
	}
	
	
	
	
	@Override
	public VectorNd div(IVectorN vec) {
		if(this.getDimensions() == vec.getDimensions()) {
			for(int i=getDimensions()-1; i>=0; i--) {
				this.values[i] /= vec.getDouble(i);
			}
			return this;
		} else {
			throw new IllegalArgumentException("Size Input: " + vec.getDimensions() + ", size Vector: " + getDimensions());
		}
	}

	@Override
	public VectorNd divGen(Number... values) {
		if(values.length == 1) {
			double value = values[0].doubleValue();
			for(int i=getDimensions()-1; i>=0; i--) {
				this.values[i] /= value;
			}
			return this;
		} else if(this.getDimensions() == values.length) {
			for(int i=getDimensions()-1; i>=0; i--) {
				this.values[i] /= values[i].doubleValue();
			}
			return this;
		} else {
			throw new IllegalArgumentException("Size Input: " + values.length + ", size Vector: " + getDimensions());
		}
	}

	

	
	/**
	 * Divides this vector by the given values (component-wise).
	 * @param values the list of values. The list must have the same size as this vector or the size 1
	 * @return this vector for chaining
	 * */
	public VectorNd div(double... values) {
		if(values.length == 1) {
			double value = values[0];
			for(int i=getDimensions()-1; i>=0; i--) {
				this.values[i] /= value;
			}
			return this;
		} else if(this.getDimensions() == values.length) {
			for(int i=getDimensions()-1; i>=0; i--) {
				this.values[i] /= values[i];
			}
			return this;
		} else {
			throw new IllegalArgumentException("Size Input: " + values.length + ", size Vector: " + getDimensions());
		}
	}
	

	
	
	@Override
	public Number dotGen(IVectorN vec) {
		if(this.getDimensions() == vec.getDimensions()) {
			double result = 0;
			for(int i=getDimensions()-1; i>=0; i--) {
				result += (this.values[i] * vec.getDouble(i));
			}
			return result;
		} else {
			throw new IllegalArgumentException("Size Input: " + vec.getDimensions() + ", size Vector: " + getDimensions());
		}
	}

	
	@Override
	public Number dotGen(Number... values) {
		if(this.getDimensions() == values.length) {
			double result = 0;
			for(int i=getDimensions()-1; i>=0; i--) {
				result += (this.values[i] * values[i].doubleValue());
			}
			return result;
		} else {
			throw new IllegalArgumentException("Size Input: " + values.length + ", size Vector: " + getDimensions());
		}
	}
	
	
	/**
	 * Calculates the dot product between this vector and the given vector with the same size.
	 * @param vec the vector the same size as this vector.
	 * @return the result
	 * */
	public double dot(IVectorN vec) {
		if(this.getDimensions() == vec.getDimensions()) {
			double result = 0;
			for(int i=getDimensions()-1; i>=0; i--) {
				result += (this.values[i] * vec.getDouble(i));
			}
			return result;
		} else {
			throw new IllegalArgumentException("Size Input: " + vec.getDimensions() + ", size Vector: " + getDimensions());
		}
	}
	
	
	/**
	 * Calculates the dot product between this vector and the given vector-components.
	 * @param values the list of values. The list must have the same size as this vector.
	 * @return the result
	 * */
	public double dot(double... values) {
		if(this.getDimensions() == values.length) {
			double result = 0;
			for(int i=getDimensions()-1; i>=0; i--) {
				result += (this.values[i] * values[i]);
			}
			return result;
		} else {
			throw new IllegalArgumentException("Size Input: " + values.length + ", size Vector: " + getDimensions());
		}
	}
	
	
	

	@Override
	public Number dist2Gen(IVectorN vec) {
		return dist2(vec);
	}

	
	@Override
	public Number dist2Gen(Number... pos) {
		if(this.getDimensions() == pos.length) {
			double result = 0;
			for(int i=getDimensions()-1; i>=0; i--) {
				result += (pos[i].doubleValue() - this.values[i]) * (pos[i].doubleValue() - this.values[i]);
			}
			return result;
		} else {
			throw new IllegalArgumentException("Size Input: " + pos.length + ", size Vector: " + getDimensions());
		}
	}

	
	/**
	 * Calculates the squared distance between this vector and the given vector.
	 * @param vec the vector with the same size as this vector
	 * @return the result
	 * */
	public double dist2(IVectorN vec) {
		if(this.getDimensions() == vec.getDimensions()) {
			double result = 0;
			for(int i=getDimensions()-1; i>=0; i--) {
				result += (vec.getDouble(i) - this.values[i]) * (vec.getDouble(i) - this.values[i]);
			}
			return result;
		} else {
			throw new IllegalArgumentException("Size Input: " + vec.getDimensions() + ", size Vector: " + getDimensions());
		}
	}
	
	
	/**
	 * Calculates the squared distance between this vector and the given position.
	 * @param pos the list of values for the position. The list must have the same size as this vector.
	 * @return the result
	 * */
	public double dist2(double... pos) {
		if(this.getDimensions() == pos.length) {
			double result = 0;
			for(int i=getDimensions()-1; i>=0; i--) {
				result += (pos[i] - this.values[i]) * (pos[i] - this.values[i]);
			}
			return result;
		} else {
			throw new IllegalArgumentException("Size Input: " + pos.length + ", size Vector: " + getDimensions());
		}
	}
	
	
	
	@Override
	public Number distGen(IVectorN vec) {
		return Math.sqrt(dist2(vec));
	}

	
	@Override
	public Number distGen(Number... pos) {
		return Math.sqrt(dist2Gen(pos).doubleValue());
	}
	
	
	/**
	 * Calculates the distance between this vector and the given vector.
	 * @param vec the vector with the same size as this vector
	 * @return the result
	 * */
	public double dist(IVectorN vec) {
		return Math.sqrt(dist2(vec));
	}


	/**
	 * Calculates the distance between this vector and the given position.
	 * @param pos the list of values for the position. The list must have the same size as this vector.
	 * @return the result
	 * */
	public double dist(double... pos) {
		return Math.sqrt(dist2(pos));
	}
	
	

	
	@Override
	public Number length2Gen() {
		return this.length2();
	}

	
	/**
	 * Calculates the squared length of this vector.
	 * @return the result
	 * */
	public double length2() {
		double result = 0;
		for(int i=getDimensions()-1; i>=0; i--) {
			result += values[i]*values[i];
		}
		return result;
	}
	
	
	
	
	@Override
	public Number lengthGen() {
		return this.length();
	}
	
	
	/**
	 * Calculates the length of this vector.
	 * @return the result
	 * */
	public double length() {
		return Math.sqrt(this.length2());
	}
	
	

	
	@Override
	public VectorNd setLength(Number length) {
		return this.setLength(length.doubleValue());
	}

	
	/**
	 * Sets the length of this vector.
	 * @param length the new length
	 * @return this vector for chaining
	 * */
	public VectorNd setLength(double length) {
		normalize();
		mul(length);
		return this;
	}
	
	
	

	@Override
	public VectorNd limitLength(Number maxLength) {
		return this.limitLength(maxLength.doubleValue());
	}
	
	
	/**
	 * Limits the length of this vector to the given maximum length.
	 * @param maxLength the maximum length
	 * @return this vector for chaining
	 * */
	public VectorNd limitLength(double maxLength) {
		double len = length();
		if(len > maxLength) {
			div(len);
			mul(maxLength);
		}
		return this;
	}
	
	
	

	@Override
	public VectorNd clampLength(Number minLength, Number maxLength) {
		return this.clampLength(minLength.doubleValue(), maxLength.doubleValue());
	}
	
	
	/**
	 * Limits the length of this vector to the given minimum and maximum length.
	 * @param minLength the minimum length
	 * @param maxLength the maximum length
	 * @return this vector for chaining
	 * */
	public VectorNd clampLength(double minLength, double maxLength) {
		double len = length();
		if(len < minLength) {
			div(len);
			mul(minLength);
		}
		if(len > maxLength) {
			div(len);
			mul(maxLength);
		}
		return this;
	}
	
	
	

	@Override
	public Number componentSumGen() {
		return this.componentSum();
	}

	
	/**
	 * Calculates the sum of the components.
	 * @return the result
	 * */
	public double componentSum() {
		double sum = 0;
		for(int i=getDimensions()-1; i>=0; i--) {
			sum += this.values[i];
		}
		return sum;
	}
	
	
	
	
	@Override
	public Number componentMinGen() {
		return this.componentMin();
	}
	
	
	/**
	 * Calculates the smallest component.
	 * @return the result
	 * */
	public double componentMin() {
		double min = Float.MAX_VALUE;
		for(int i=getDimensions()-1; i>=0; i--) {
			min = Math.min(min, this.values[i]);
		}
		return min;
	}
	
	

	
	@Override
	public Number componentMaxGen() {
		return this.componentMax();
	}
	
	
	/**
	 * Calculates the largest component.
	 * @return the result
	 * */
	public double componentMax() {
		double max = Float.NEGATIVE_INFINITY;
		for(int i=getDimensions()-1; i>=0; i--) {
			max = Math.max(max, this.values[i]);
		}
		return max;
	}
	

	
	
	@Override
	public VectorNd clampComponents(Number min, Number max) {
		return this.clampComponents(min.doubleValue(), max.doubleValue());
	}
	
	
	/**
	 * Clamps the components between the given minimum and maximum values.
	 * @param min the minimum value
	 * @param max the maximum value
	 * @return the result
	 * */
	public VectorNd clampComponents(double min, double max) {
		for(int i=getDimensions()-1; i>=0; i--) {
			this.values[i] = Math.min(max, Math.max(this.values[i], min));
		}
		return this;
	}
	
	

	
	@Override
	public boolean compare(IVectorN vec) {
		for(int i=getDimensions()-1; i>=0; i--) {
			if(Math.abs(this.values[i] - vec.getDouble(i)) > EPSILON) { return false; }
		}
		return true;
	}

	
	
	
	@Override
	public boolean isUnit() {
		if(Math.abs(length2() - 1f) > EPSILON) {
			return false;
		} else {
			return true;
		}
	}

	
	
	@Override
	public boolean isZero() {
		for(int i=getDimensions()-1; i>=0; i--) {
			if(Math.abs(this.values[i]) > EPSILON) { return false; }
		}
		return true;
	}
	
	
}

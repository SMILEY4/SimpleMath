package com.ruegnerlukas.simplemath.vectors.vecN;

import java.util.Arrays;

import com.ruegnerlukas.simplemath.vectors.IVector;

public class VectorNl implements IVectorN {

	
	
	
	
	
	/** the values of the components of this vector*/
	private final long[] values;
	
	/** the size / number of dimensions of this vector */
	private final int size;
	
	
	
	
	
	
	/**
	 * creates a zero-vector with the given size
	 * */
	public VectorNl(int size) {
		this(new long[size]);
	}
	

	/**
	 * creates a vector with the same values and size as the given vector
	 * */
	public VectorNl(IVectorN vec) {
		this.size = vec.getDimensions();
		this.values = new long[vec.getDimensions()];
		if(vec instanceof VectorNl) {
			System.arraycopy( ((VectorNl)vec).get(), 0, this.values, 0, getDimensions());
		} else {
			for(int i=getDimensions()-1; i>=0; i--) {
				values[i] = vec.getLong(i);
			}
		}
	}
	
	
	/**
	 * creates a vector with the given values and the size of the given array
	 * */
	public VectorNl(long[] values) {
		this.values = values;
		this.size = values.length;
	}
	
	
	
	
	
	
	@Override
	public int getDimensions() {
		return size;
	}

	
	
	
	@Override
	public VectorNl setAt(int index, Number value) {
		if( (0 <= index) && (index < getDimensions()) ) {
			values[index] = value.longValue();
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
	public long[] get() {
		return this.values;
	}
	
	
	
	
	@Override
	public IVector negate() {
		for(int i=getDimensions()-1; i>=0; i--) {
			values[i] = -values[i];
		}
		return this;
	}

	
	
	
	@Override
	public IVector normalize() {
		final float len = length();
		for(int i=getDimensions()-1; i>=0; i--) {
			values[i] /= len;
		}
		return this;
	}

	
	
	
	@Override
	public VectorNl copy() {
		return new VectorNl(this);
	}

	
	
	
	@Override
	public VectorNl set(IVectorN v) {
		if(this.getDimensions() == v.getDimensions()) {
			if(v instanceof VectorNl) {
				System.arraycopy( ((VectorNl)v).get(), 0, this.values, 0, this.getDimensions());
			} else {
				for(int i=getDimensions()-1; i>=0; i--) {
					values[i] = v.getLong(i);
				}
			}
			return this;
		} else {
			throw new IllegalArgumentException("Size Input: " + v.getDimensions() + ", size Vector: " + getDimensions());
		}
	}

	
	
	
	@Override
	public VectorNl setGen(Number... a) {
		if(a.length == 1) {
			Arrays.fill(this.values, a[0].longValue());
			return this;
		} else if(this.getDimensions() == a.length) {
			for(int i=getDimensions()-1; i>=0; i--) {
				values[i] = a[i].longValue();
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
	public VectorNl set(long... a) {
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
		return new VectorNd(this);
	}

	
	@Override
	public String toString() {
		String str = "VectorNl." + this.hashCode() + "(";
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
	public VectorNl add(IVectorN vec) {
		if(this.getDimensions() == vec.getDimensions()) {
			for(int i=getDimensions()-1; i>=0; i--) {
				values[i] += vec.getLong(i);
			}
			return this;
		} else {
			throw new IllegalArgumentException("Size Input: " + vec.getDimensions() + ", size Vector: " + getDimensions());
		}
	}
	

	@Override
	public VectorNl addGen(Number... values) {
		if(values.length == 1) {
			long value = values[0].longValue();
			for(int i=getDimensions()-1; i>=0; i--) {
				this.values[i] += value;
			}
			return this;
		} else if(this.getDimensions() == values.length) {
			for(int i=getDimensions()-1; i>=0; i--) {
				this.values[i] += values[i].longValue();
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
	public VectorNl add(long... values) {
		if(values.length == 1) {
			long value = values[0];
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
	public VectorNl sub(IVectorN vec) {
		if(this.getDimensions() == vec.getDimensions()) {
			for(int i=getDimensions()-1; i>=0; i--) {
				this.values[i] -= vec.getLong(i);
			}
			return this;
		} else {
			throw new IllegalArgumentException("Size Input: " + vec.getDimensions() + ", size Vector: " + getDimensions());
		}
	}

	
	@Override
	public VectorNl subGen(Number... values) {
		if(values.length == 1) {
			long value = values[0].longValue();
			for(int i=getDimensions()-1; i>=0; i--) {
				this.values[i] -= value;
			}
			return this;
		} else if(this.getDimensions() == values.length) {
			for(int i=getDimensions()-1; i>=0; i--) {
				this.values[i] -= values[i].longValue();
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
	public VectorNl sub(long... values) {
		if(values.length == 1) {
			long value = values[0];
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
	public VectorNl mul(IVectorN vec) {
		if(this.getDimensions() == vec.getDimensions()) {
			for(int i=getDimensions()-1; i>=0; i--) {
				this.values[i] *= vec.getLong(i);
			}
			return this;
		} else {
			throw new IllegalArgumentException("Size Input: " + vec.getDimensions() + ", size Vector: " + getDimensions());
		}
	}
	

	@Override
	public VectorNl mulGen(Number... values) {
		if(values.length == 1) {
			float value = values[0].longValue();
			for(int i=getDimensions()-1; i>=0; i--) {
				this.values[i] *= value;
			}
			return this;
		} else if(this.getDimensions() == values.length) {
			for(int i=getDimensions()-1; i>=0; i--) {
				this.values[i] *= values[i].longValue();
			}
			return this;
		} else {
			throw new IllegalArgumentException("Size Input: " + values.length + ", size Vector: " + getDimensions());
		}
	}

	
	/**
	 * Multiplies this vector with the given vector.
	 * @param values the vector as a list with the same size as this vector
	 * @return this vector for chaining
	 * */
	public VectorNl mul(long... values) {
		if(values.length == 1) {
			long value = values[0];
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
	
	
	/**
	 * Multiplies this vector with the given vector.
	 * @param values the vector as a list with the same size as this vector
	 * @return this vector for chaining
	 * */
	public VectorNl mul(float... values) {
		if(values.length == 1) {
			float value = values[0];
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
	public VectorNl div(IVectorN vec) {
		if(this.getDimensions() == vec.getDimensions()) {
			for(int i=getDimensions()-1; i>=0; i--) {
				this.values[i] /= vec.getLong(i);
			}
			return this;
		} else {
			throw new IllegalArgumentException("Size Input: " + vec.getDimensions() + ", size Vector: " + getDimensions());
		}
	}

	
	@Override
	public VectorNl divGen(Number... values) {
		if(values.length == 1) {
			long value = values[0].longValue();
			for(int i=getDimensions()-1; i>=0; i--) {
				this.values[i] /= value;
			}
			return this;
		} else if(this.getDimensions() == values.length) {
			for(int i=getDimensions()-1; i>=0; i--) {
				this.values[i] /= values[i].longValue();
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
	public VectorNl div(long... values) {
		if(values.length == 1) {
			long value = values[0];
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
	
	
	/**
	 * Divides this vector by the given values (component-wise).
	 * @param values the list of values. The list must have the same size as this vector or the size 1
	 * @return this vector for chaining
	 * */
	public VectorNl div(float... values) {
		if(values.length == 1) {
			float value = values[0];
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
			long result = 0;
			for(int i=getDimensions()-1; i>=0; i--) {
				result += (this.values[i] * vec.getLong(i));
			}
			return result;
		} else {
			throw new IllegalArgumentException("Size Input: " + vec.getDimensions() + ", size Vector: " + getDimensions());
		}
	}

	
	@Override
	public Number dotGen(Number... values) {
		if(this.getDimensions() == values.length) {
			long result = 0;
			for(int i=getDimensions()-1; i>=0; i--) {
				result += (this.values[i] * values[i].longValue());
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
	public long dot(IVectorN vec) {
		if(this.getDimensions() == vec.getDimensions()) {
			long result = 0;
			for(int i=getDimensions()-1; i>=0; i--) {
				result += (this.values[i] * vec.getLong(i));
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
	public long dot(long... values) {
		if(this.getDimensions() == values.length) {
			long result = 0;
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
			long result = 0;
			for(int i=getDimensions()-1; i>=0; i--) {
				result += (pos[i].longValue() - this.values[i]) * (pos[i].longValue() - this.values[i]);
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
	public long dist2(IVectorN vec) {
		if(this.getDimensions() == vec.getDimensions()) {
			long result = 0;
			for(int i=getDimensions()-1; i>=0; i--) {
				result += (vec.getLong(i) - this.values[i]) * (vec.getLong(i) - this.values[i]);
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
	public long dist2(long... pos) {
		if(this.getDimensions() == pos.length) {
			long result = 0;
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
		return (float) Math.sqrt(dist2(vec));
	}

	
	@Override
	public Number distGen(Number... pos) {
		return (float) Math.sqrt(dist2Gen(pos).longValue());
	}
	
	
	/**
	 * Calculates the distance between this vector and the given vector.
	 * @param vec the vector with the same size as this vector
	 * @return the result
	 * */
	public float dist(IVectorN vec) {
		return (float) Math.sqrt(dist2(vec));
	}


	/**
	 * Calculates the distance between this vector and the given position.
	 * @param pos the list of values for the position. The list must have the same size as this vector.
	 * @return the result
	 * */
	public float dist(long... pos) {
		return (float) Math.sqrt(dist2(pos));
	}
	
	

	
	@Override
	public Number length2Gen() {
		return this.length2();
	}

	
	/**
	 * Calculates the squared length of this vector.
	 * @return the result
	 * */
	public long length2() {
		long result = 0;
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
	public float length() {
		return (float) Math.sqrt(this.length2());
	}
	
	

	
	@Override
	public VectorNl setLength(Number length) {
		return this.setLength(length.longValue());
	}

	
	/**
	 * Sets the length of this vector.
	 * @param length the new length
	 * @return this vector for chaining
	 * */
	public VectorNl setLength(float length) {
		normalize();
		mul(length);
		return this;
	}
	
	
	

	@Override
	public VectorNl limitLength(Number maxLength) {
		return this.limitLength(maxLength.longValue());
	}
	
	
	/**
	 * Limits the length of this vector to the given maximum length.
	 * @param maxLength the maximum length
	 * @return this vector for chaining
	 * */
	public VectorNl limitLength(float maxLength) {
		float len = length();
		if(len > maxLength) {
			div(len);
			mul(maxLength);
		}
		return this;
	}
	
	
	

	@Override
	public VectorNl clampLength(Number minLength, Number maxLength) {
		return this.clampLength(minLength.longValue(), maxLength.longValue());
	}
	
	
	/**
	 * Limits the length of this vector to the given minimum and maximum length.
	 * @param minLength the minimum length
	 * @param maxLength the maximum length
	 * @return this vector for chaining
	 * */
	public VectorNl clampLength(float minLength, float maxLength) {
		float len = length();
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
	public long componentSum() {
		long sum = 0;
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
	public long componentMin() {
		long min = Long.MAX_VALUE;
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
	public long componentMax() {
		long max = Long.MIN_VALUE;
		for(int i=getDimensions()-1; i>=0; i--) {
			max = Math.max(max, this.values[i]);
		}
		return max;
	}
	

	
	
	@Override
	public VectorNl clampComponents(Number min, Number max) {
		return this.clampComponents(min.longValue(), max.longValue());
	}
	
	
	/**
	 * Clamps the components between the given minimum and maximum values.
	 * @param min the minimum value
	 * @param max the maximum value
	 * @return the result
	 * */
	public VectorNl clampComponents(long min, long max) {
		for(int i=getDimensions()-1; i>=0; i--) {
			this.values[i] = Math.min(max, Math.max(this.values[i], min));
		}
		return this;
	}
	
	

	
	@Override
	public boolean compare(IVectorN vec) {
		for(int i=getDimensions()-1; i>=0; i--) {
			if(Math.abs(this.values[i] - vec.getLong(i)) > 0) { return false; }
		}
		return true;
	}

	
	
	
	@Override
	public boolean isUnit() {
		if(Math.abs(length2() - 1f) > 0) {
			return false;
		} else {
			return true;
		}
	}

	
	
	@Override
	public boolean isZero() {
		for(int i=getDimensions()-1; i>=0; i--) {
			if(Math.abs(this.values[i]) > 0) { return false; }
		}
		return true;
	}
	
	
}

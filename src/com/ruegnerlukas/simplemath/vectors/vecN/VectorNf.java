package com.ruegnerlukas.simplemath.vectors.vecN;

import java.util.Arrays;

import com.ruegnerlukas.simplemath.vectors.IVector;
import com.ruegnerlukas.simplemath.vectors.vec3.IVector3;
import com.ruegnerlukas.simplemath.vectors.vec3.Vector3f;

public class VectorNf implements IVectorN {

	
	
	
	/** Used when comparing two float values. */
	public static final float EPSILON = 0.000001f;
	
	
	
	
	/** the values of the components of this vector*/
	private final float[] values;
	
	/** the size / number of dimensions of this vector */
	private final int size;
	
	
	
	
	
	
	/**
	 * creates a zero-vector with the given size
	 * */
	public VectorNf(int size) {
		this(new float[size]);
	}
	

	/**
	 * creates a vector with the same values and size as the given vector
	 * */
	public VectorNf(IVectorN vec) {
		this.size = vec.getDimensions();
		this.values = new float[vec.getDimensions()];
		if(vec instanceof VectorNf) {
			System.arraycopy( ((VectorNf)vec).get(), 0, this.values, 0, getDimensions());
		} else {
			for(int i=getDimensions()-1; i>=0; i--) {
				values[i] = vec.getFloat(i);
			}
		}
	}
	
	
	/**
	 * creates a vector with the given values and the size of the given array
	 * */
	public VectorNf(float[] values) {
		this.values = values;
		this.size = values.length;
	}
	
	
	
	
	
	
	@Override
	public int getDimensions() {
		return size;
	}

	
	
	
	@Override
	public VectorNf set(int index, Number value) {
		if( (0 <= index) && (index < getDimensions()) ) {
			values[index] = value.floatValue();
			return this;
		} else {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + getDimensions());
		}
	}

	
	
	
	@Override
	public short getShort(int index) {
		if( (0 <= index) && (index < getDimensions()) ) {
			return (short) values[index];
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
	public float[] get() {
		return this.values;
	}
	
	
	
	
	@Override
	public VectorNf negate() {
		for(int i=getDimensions()-1; i>=0; i--) {
			values[i] = -values[i];
		}
		return this;
	}

	
	
	
	@Override
	public VectorNf normalize() {
		final float len = length();
		for(int i=getDimensions()-1; i>=0; i--) {
			values[i] /= len;
		}
		return this;
	}

	
	
	
	@Override
	public VectorNf copy() {
		return new VectorNf(this);
	}

	
	
	
	@Override
	public VectorNf set(IVectorN v) {
		if(this.getDimensions() == v.getDimensions()) {
			if(v instanceof VectorNf) {
				System.arraycopy( ((VectorNf)v).get(), 0, this.values, 0, this.getDimensions());
			} else {
				for(int i=getDimensions()-1; i>=0; i--) {
					values[i] = v.getFloat(i);
				}
			}
			return this;
		} else {
			throw new IllegalArgumentException("Size Input: " + v.getDimensions() + ", size Vector: " + getDimensions());
		}
	}

	
	
	
	@Override
	public VectorNf setGen(Number... a) {
		if(a.length == 1) {
			Arrays.fill(this.values, a[0].floatValue());
			return this;
		} else if(this.getDimensions() == a.length) {
			for(int i=getDimensions()-1; i>=0; i--) {
				values[i] = a[i].floatValue();
			}
			return this;
		} else {
			throw new IllegalArgumentException("Size Input: " + a.length + ", size Vector: " + getDimensions());
		}
	}

	
	public VectorNf set(float... a) {
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
		return this.copy();
	}

	
	@Override
	public VectorNd toDoubleVector() {
		return new VectorNd(this);
	}

	
	@Override
	public String toString() {
		String str = "VectorNf." + this.hashCode() + "(";
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
	public VectorNf add(IVectorN vec) {
		if(this.getDimensions() == vec.getDimensions()) {
			for(int i=getDimensions()-1; i>=0; i--) {
				values[i] += vec.getFloat(i);
			}
			return this;
		} else {
			throw new IllegalArgumentException("Size Input: " + vec.getDimensions() + ", size Vector: " + getDimensions());
		}
	}
	

	@Override
	public VectorNf addGen(Number... values) {
		if(values.length == 1) {
			float value = values[0].floatValue();
			for(int i=getDimensions()-1; i>=0; i--) {
				this.values[i] += value;
			}
			return this;
		} else if(this.getDimensions() == values.length) {
			for(int i=getDimensions()-1; i>=0; i--) {
				this.values[i] += values[i].floatValue();
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
	public VectorNf add(float... values) {
		if(values.length == 1) {
			float value = values[0];
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
	public VectorNf sub(IVectorN vec) {
		if(this.getDimensions() == vec.getDimensions()) {
			for(int i=getDimensions()-1; i>=0; i--) {
				this.values[i] -= vec.getFloat(i);
			}
			return this;
		} else {
			throw new IllegalArgumentException("Size Input: " + vec.getDimensions() + ", size Vector: " + getDimensions());
		}
	}

	
	@Override
	public VectorNf subGen(Number... values) {
		if(values.length == 1) {
			float value = values[0].floatValue();
			for(int i=getDimensions()-1; i>=0; i--) {
				this.values[i] -= value;
			}
			return this;
		} else if(this.getDimensions() == values.length) {
			for(int i=getDimensions()-1; i>=0; i--) {
				this.values[i] -= values[i].floatValue();
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
	public VectorNf sub(float... values) {
		if(values.length == 1) {
			float value = values[0];
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
	public VectorNf mul(IVectorN vec) {
		if(this.getDimensions() == vec.getDimensions()) {
			for(int i=getDimensions()-1; i>=0; i--) {
				this.values[i] *= vec.getFloat(i);
			}
			return this;
		} else {
			throw new IllegalArgumentException("Size Input: " + vec.getDimensions() + ", size Vector: " + getDimensions());
		}
	}
	

	@Override
	public VectorNf mulGen(Number... values) {
		if(values.length == 1) {
			float value = values[0].floatValue();
			for(int i=getDimensions()-1; i>=0; i--) {
				this.values[i] *= value;
			}
			return this;
		} else if(this.getDimensions() == values.length) {
			for(int i=getDimensions()-1; i>=0; i--) {
				this.values[i] *= values[i].floatValue();
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
	public VectorNf mul(float... values) {
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
	public VectorNf div(IVectorN vec) {
		if(this.getDimensions() == vec.getDimensions()) {
			for(int i=getDimensions()-1; i>=0; i--) {
				this.values[i] /= vec.getFloat(i);
			}
			return this;
		} else {
			throw new IllegalArgumentException("Size Input: " + vec.getDimensions() + ", size Vector: " + getDimensions());
		}
	}

	@Override
	public VectorNf divGen(Number... values) {
		if(values.length == 1) {
			float value = values[0].floatValue();
			for(int i=getDimensions()-1; i>=0; i--) {
				this.values[i] /= value;
			}
			return this;
		} else if(this.getDimensions() == values.length) {
			for(int i=getDimensions()-1; i>=0; i--) {
				this.values[i] /= values[i].floatValue();
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
	public VectorNf div(float... values) {
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
			float result = 0;
			for(int i=getDimensions()-1; i>=0; i--) {
				result += (this.values[i] * vec.getFloat(i));
			}
			return result;
		} else {
			throw new IllegalArgumentException("Size Input: " + vec.getDimensions() + ", size Vector: " + getDimensions());
		}
	}

	
	@Override
	public Number dotGen(Number... values) {
		if(this.getDimensions() == values.length) {
			float result = 0;
			for(int i=getDimensions()-1; i>=0; i--) {
				result += (this.values[i] * values[i].floatValue());
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
	public float dot(IVectorN vec) {
		if(this.getDimensions() == vec.getDimensions()) {
			float result = 0;
			for(int i=getDimensions()-1; i>=0; i--) {
				result += (this.values[i] * vec.getFloat(i));
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
	public float dot(float... values) {
		if(this.getDimensions() == values.length) {
			float result = 0;
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
			float result = 0;
			for(int i=getDimensions()-1; i>=0; i--) {
				result += (pos[i].floatValue() - this.values[i]) * (pos[i].floatValue() - this.values[i]);
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
	public float dist2(IVectorN vec) {
		if(this.getDimensions() == vec.getDimensions()) {
			float result = 0;
			for(int i=getDimensions()-1; i>=0; i--) {
				result += (vec.getFloat(i) - this.values[i]) * (vec.getFloat(i) - this.values[i]);
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
	public float dist2(float... pos) {
		if(this.getDimensions() == pos.length) {
			float result = 0;
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
		return (float) Math.sqrt(dist2Gen(pos).floatValue());
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
	public float dist(float... pos) {
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
	public float length2() {
		float result = 0;
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
	public VectorNf setLength(Number length) {
		return this.setLength(length.floatValue());
	}

	
	/**
	 * Sets the length of this vector.
	 * @param length the new length
	 * @return this vector for chaining
	 * */
	public VectorNf setLength(float length) {
		normalize();
		mul(length);
		return this;
	}
	
	
	

	@Override
	public VectorNf limitLength(Number maxLength) {
		return this.limitLength(maxLength.floatValue());
	}
	
	
	/**
	 * Limits the length of this vector to the given maximum length.
	 * @param maxLength the maximum length
	 * @return this vector for chaining
	 * */
	public VectorNf limitLength(float maxLength) {
		float len = length();
		if(len > maxLength) {
			div(len);
			mul(maxLength);
		}
		return this;
	}
	
	
	

	@Override
	public VectorNf clampLength(Number minLength, Number maxLength) {
		return this.clampLength(minLength.floatValue(), maxLength.floatValue());
	}
	
	
	/**
	 * Limits the length of this vector to the given minimum and maximum length.
	 * @param minLength the minimum length
	 * @param maxLength the maximum length
	 * @return this vector for chaining
	 * */
	public VectorNf clampLength(float minLength, float maxLength) {
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
	public float componentSum() {
		float sum = 0;
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
	public float componentMin() {
		float min = Float.MAX_VALUE;
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
	public float componentMax() {
		float max = Float.NEGATIVE_INFINITY;
		for(int i=getDimensions()-1; i>=0; i--) {
			max = Math.max(max, this.values[i]);
		}
		return max;
	}
	

	
	
	@Override
	public VectorNf clampComponents(Number min, Number max) {
		return this.clampComponents(min.floatValue(), max.floatValue());
	}
	
	
	/**
	 * Clamps the components between the given minimum and maximum values.
	 * @param min the minimum value
	 * @param max the maximum value
	 * @return the result
	 * */
	public VectorNf clampComponents(float min, float max) {
		for(int i=getDimensions()-1; i>=0; i--) {
			this.values[i] = Math.min(max, Math.max(this.values[i], min));
		}
		return this;
	}
	
	

	
	@Override
	public boolean compare(IVectorN vec) {
		for(int i=getDimensions()-1; i>=0; i--) {
			if(Math.abs(this.values[i] - vec.getFloat(i)) > EPSILON) { return false; }
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

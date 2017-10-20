package com.ruegnerlukas.simplemath.vectors;

import com.ruegnerlukas.simplemath.vectors.vec3.IVector3;

public interface IVector {
	
	/**
	 * @return the number of dimensions of this vector
	 * */
	public int getDimensions();
	
	/**
	 * Sets the value at the given index of the this vector.
	 * @return this vector for chaining
	 * */
	public IVector set(int index, Number value);

	/** @return the value of the component at the given index as a short */
	public short getShort(int index);
	
	/** @return the value of the component at the given index as an integer */
	public int 	getInt(int index);
	
	/** @return the value of the component at the given index as a long */
	public long getLong(int index);
	
	/** @return the value of the component at the given index as a float */
	public float getFloat(int index);
	
	/** @return the value of the component at the given index as a double */
	public double getDouble(int index);

	
	/**
	 * Negates all components of this vector.
	 * @return this vector for chaining
	 * */
	public IVector negate();
	
	/**
	 * Normalizes this vector.
	 * @return this vector for chaining
	 * */
	public IVector normalize();
	
	
	/**
	 * Creates a new vector with the same values as this vector.
	 * @return the created vector
	 * */
	public IVector copy();
	
	
	
	
	/**
	 * Calculates the squared length of this vector.
	 * @return the result as a {@link java.lang.Number}
	 * */
	public Number length2Gen();
	
	/**
	 * Calculates the length of this vector.
	 * @return the result as a {@link java.lang.Number}
	 * */
	public Number lengthGen();
	
	/**
	 * Sets the length of this vector.
	 * @param length the new length
	 * @return this vector for chaining
	 * */
	public IVector setLength(Number length);
	
	/**
	 * Limits the length of this vector to the given maximum length.
	 * @param maxLength the maximum length
	 * @return this vector for chaining
	 * */
	public IVector limitLength(Number maxLength);
	
	/**
	 * Limits the length of this vector to the given minimum and maximum length.
	 * @param minLength the minimum length
	 * @param maxLength the maximum length
	 * @return this vector for chaining
	 * */
	public IVector clampLenght(Number minLength, Number maxLength);
	
	
	
	
	/**
	 * Calculates the sum of the components.
	 * @return the result as a {@link java.lang.Number}
	 * */
	public Number componentSumGen();
	
	/**
	 * Calculates the smallest component.
	 * @return the result as a {@link java.lang.Number}
	 * */
	public Number componentMinGen();
	
	/**
	 * Calculates the largest component.
	 * @return the result as a {@link java.lang.Number}
	 * */
	public Number componentMaxGen();
	
	/**
	 * Clamps the components between the given minimum and maximum values.
	 * @param min the minimum value
	 * @param max the maximum value
	 * @return the result as a {@link java.lang.Number}
	 * */
	public IVector clampComponents(Number min, Number max);
	
	
	
	
	/**
	 * @return true, if this vector has a length of 1
	 * */
	public boolean isUnit();
	
	
	/**
	 * @return true, if all components of this vector are zero
	 * */
	public boolean isZero();
	
}

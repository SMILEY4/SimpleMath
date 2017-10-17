package com.ruegnerlukas.simplemath.vecmath;


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
	
}

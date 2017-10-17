package com.ruegnerlukas.simplemath.vecmath;


public interface IVector {
	
	public int getDimensions();
	
	public IVector 	set(int index, Number value);

	public short 	getShort(int index);
	public int 		getInt(int index);
	public long 	getLong(int index);
	public float 	getFloat(int index);
	public double 	getDouble(int index);

	public IVector negate();
	public IVector normalize();
	
	public IVector copy();
	
}

package com.ruegnerlukas.simplemath.geometry.shapes;

import com.ruegnerlukas.simplemath.geometry.shapes.rectangle.IRectangle;
import com.ruegnerlukas.simplemath.vectors.vec2.IVector2;
import com.ruegnerlukas.simplemath.vectors.vec4.IVector4;

public interface IShape {

	
	

	/**
	 * @return the minimal x position of this shape
	 * */
	public int getMinXInt();
	
	/**
	 * @return the minimal x position of this shape
	 * */
	public float getMinXFloat();
	
	/**
	 * @return the minimal x position of this shape
	 * */
	public double getMinXDouble();
	
	
	/**
	 * @return the minimal y position of this shape
	 * */
	public int getMinYInt();
	
	/**
	 * @return the minimal y position of this shape
	 * */
	public float getMinYFloat();
	
	/**
	 * @return the minimal y position of this shape
	 * */
	public double getMinYDouble();

	
	/**
	 * @return the maximal x position of this shape
	 * */
	public int getMaxXInt();
	
	/**
	 * @return the maximal x position of this shape
	 * */
	public float getMaxXFloat();
	
	/**
	 * @return the maximal x position of this shape
	 * */
	public double getMaxXDouble();
	
	
	/**
	 * @return the maximal y position of this shape
	 * */
	public int getMaxYInt();
	
	/**
	 * @return the maximal y position of this shape
	 * */
	public float getMaxYFloat();
	
	/**
	 * @return the maximal y position of this shape
	 * */
	public double getMaxYDouble();
	
	
	/**
	 * @return the minimal x and y position as a vector2
	 * */
	public IVector2 getMin();
	
	
	/**
	 * @param dest the destination vector or null
	 * @return the minimal x and y position as a vector2
	 * */
	public IVector2 getMin(IVector2 dest);
	
	
	/**
	 * @return the maximal x and y position as a vector2
	 * */
	public IVector2 getMax();
	
	
	/**
	 * @param dest the destination vector or null
	 * @return the maximal x and y position as a vector2
	 * */
	public IVector2 getMax(IVector2 dest);
	
	
	/**
	 * @return the bounding rectangle of this shape
	 * */
	public IRectangle getBounds();
	
	
	/**
	 * @param dest the destination rectangle or null
	 * @return the bounding rectangle of this shape
	 * */
	public IRectangle getBounds(IRectangle dest);
	
	
	/**
	 * @return the bounding rectangle of this shape as a vector
	 * */
	public IVector4 getBoundsVec();
	
	
	/**
	 * @param dest the destination vector or null
	 * @return the bounding rectangle of this shape as a vector
	 * */
	public IVector4 getBoundsVec(IVector4 dest);
	
	
	/**
	 * @return the minimal radius of this shape
	 * */
	public int getRadiusInt();
	
	
	/**
	 * @return the minimal radius of this shape
	 * */
	public float getRadiusFloat();
	
	
	/**
	 * @return the minimal radius of this shape
	 * */
	public double getRadiusDouble();
	
	
	/**
	 * Checks whether the given shape intersects this shape.
	 * @param other the other shape
	 * @return true, if this shape intersects the given shape
	 * */
	public boolean intersects(IShape other);
	
	
	/**
	 * Creates a new shape with the same values as this shape.
	 * @return the created shape
	 * */
	public IShape copy();

	
	/**
	 * Sets the name of this shape.
	 * @param name the name
	 * @return this shape for chaining
	 * */
	public IShape setName(String name);
	
	
	/**
	 * @return the name of this shape or an empty String
	 * */
	public String getName();
	
	
}

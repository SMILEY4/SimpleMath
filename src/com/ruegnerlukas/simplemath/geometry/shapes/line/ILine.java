package com.ruegnerlukas.simplemath.geometry.shapes.line;

import com.ruegnerlukas.simplemath.geometry.shapes.IShape;
import com.ruegnerlukas.simplemath.vectors.vec2.IVector2;

public interface ILine extends IShape {

	/**
	 * @return the x-position of the start of this line as an int
	 * */
	public int getStartXInt();
	
	/**
	 * @return the y-position of the start of this line as an int
	 * */
	public int getStartYInt();
	
	/**
	 * @return the x-position of the end of this line as an int
	 * */
	public int getEndXInt();
	
	/**
	 * @return the y-position of the end of this line as an int
	 * */
	public int getEndYInt();
	
	/**
	 * @return the x-position of the center of this line as an int
	 * */
	public int getCenterXInt();
	
	/**
	 * @return the x-position of the center of this line as an int
	 * */
	public int getCenterYInt();
	
	/**
	 * @return the x-position of the start of this line as an float
	 * */
	public float getStartXFloat();
	
	/**
	 * @return the y-position of the start of this line as an float
	 * */
	public float getStartYFloat();
	
	/**
	 * @return the x-position of the end of this line as an float
	 * */
	public float getEndXFloat();
	
	/**
	 * @return the y-position of the end of this line as an float
	 * */
	public float getEndYFloat();
	
	/**
	 * @return the x-position of the center of this line as an float
	 * */
	public float getCenterXFloat();
	
	/**
	 * @return the x-position of the center of this line as an float
	 * */
	public float getCenterYFloat();
	
	/**
	 * @return the x-position of the start of this line as an double
	 * */
	public double getStartXDouble();
	
	/**
	 * @return the y-position of the start of this line as an double
	 * */
	public double getStartYDouble();
	
	/**
	 * @return the x-position of the end of this line as an double
	 * */
	public double getEndXDouble();
	
	/**
	 * @return the y-position of the end of this line as an double
	 * */
	public double getEndYDouble();
	
	/**
	 * @return the x-position of the center of this line as an double
	 * */
	public double getCenterXDouble();
	
	/**
	 * @return the x-position of the center of this line as an double
	 * */
	public double getCenterYDouble();
	
	/**
	 * @return the position of the starting point of this line
	 * */
	public IVector2 getStart();
	
	/**
	 * @param dest the destination vector for the position (or null)
	 * @return the vector containing the position of the starting point of this line.
	 * */
	public IVector2 getStart(IVector2 dest);
	
	/**
	 * @return the position of the starting end of this line
	 * */
	public IVector2 getEnd();
	
	/**
	 * @param dest the destination vector for the position (or null)
	 * @return the vector containing the position of the end point of this line.
	 * */
	public IVector2 getEnd(IVector2 dest);

	/**
	 * @return the position of the center point of this line
	 * */
	public IVector2 getCenter();
	
	/**
	 * @param dest the destination vector for the position (or null)
	 * @return the vector containing the position of the center point of this line.
	 * */
	public IVector2 getCenter(IVector2 dest);
	
	/**
	 * @return the squared distance between the start and end point as a number
	 * */
	public Number getLength2Gen();
	
	/**
	 * @return the distance between the start and end point as a number
	 * */
	public Number getLengthGen();

	/**
	 * @return the vector perpendicular to this line. The vector is not normalized
	 * */
	public IVector2 getNormal();
	
	/**
	 * @param dest the destination vector for the normal (or null)
	 * @return the vector perpendicular to this line. The vector is not normalized
	 * */
	public IVector2 getNormal(IVector2 dest);
	
	/**
	 * Sets the start end end position of this line to the start and end position of the given line.
	 * @param line the line
	 * @return this line for chaining
	 * */
	public ILine set(ILine line);
	
	/**
	 * Sets the start and end position of this line
	 * @param x0 the new x position of the start of this line as a Number
	 * @param y0 the new y position of the start of this line as a Number
	 * @param x1 the new x position of the end of this line as a Number
	 * @param y1 the new y position of the end of this line as a Number
	 * @return this line for chaining
	 * */
	public ILine set(Number x0, Number y0, Number x1, Number y1);
	
	/**
	 * Sets the start position of this line
	 * @param x the new x position of the start of this line as a Number
	 * @param y the new y position of the start of this line as a Number
	 * @return this line for chaining
	 * */
	public ILine setStart(Number x, Number y);
	
	/**
	 * Sets the end position of this line
	 * @param x the new x position of the end of this line as a Number
	 * @param y the new y position of the end of this line as a Number
	 * @return this line for chaining
	 * */
	public ILine setEnd(Number x, Number y);
	
	/**
	 * Sets the start position of this line
	 * @param x the new x position of the start of this line as a Number
	 * @return this line for chaining
	 * */
	public ILine setStartX(Number x);
	
	/**
	 * Sets the start position of this line
	 * @param y the new y position of the start of this line as a Number
	 * @return this line for chaining
	 * */
	public ILine setStartY(Number y);
	
	/**
	 * Sets the end position of this line
	 * @param x the new x position of the end of this line as a Number
	 * @return this line for chaining
	 * */
	public ILine setEndX(Number x);
	
	/**
	 * Sets the end position of this line
	 * @param y the new y position of the end of this line as a Number
	 * @return this line for chaining
	 * */
	public ILine setEndY(Number y);

	/**
	 * Switches the start with the end point.
	 * @return this line for chaining
	 * */
	public ILine switchDirection();
	
	/**
	 * Moves this line by the given amount.
	 * @param dx the distance in x-direction
	 * @param dy the distance in y-direction
	 * @return this line for chaining
	 * */
	public ILine translate(Number dx, Number dy);
	
	
	/**
	 * Moves this line by the given amount.
	 * @param dir the vector representing the distance in the x- and y-direction
	 * @return this line for chaining
	 * */
	public ILine translate(IVector2 dir);

	
	/**
	 * Scales this line. The start position does not change.
	 * @param s the scaling factor
	 * @return this line for chaining
	 * */
	public ILine scale(Number s);

	
	/**
	 * Scales the width and height of this line. The start position does not change.
	 * @param sx the scaling in x direction
	 * @param sy the scaling in y direction
	 * @return this line for chaining
	 * */
	public ILine scale(Number sx, Number sy);
	
	
	/**
	 * Scales the width and height of this line. The position does not change.
	 * @param scaling the vector representing the scaling in x and y direction
	 * @return this line for chaining
	 * */
	public ILine scale(IVector2 scaling);
	
	
	/**
	 * Scales this line. The position of the center of does not change.
	 * @param s the scaling factor
	 * @return this line for chaining
	 * */
	public ILine scaleCentered(Number s);
	
	/**
	 * Scales this line. The position of the center of does not change.
	 * @param sx the scaling in x direction
	 * @param sy the scaling in y direction
	 * @return this line for chaining
	 * */
	public ILine scaleCentered(Number sx, Number sy);
	
	/**
	 * Scales the width and height of this line. The position of the center does not change.
	 * @param scaling the vector representing the scaling in x and y direction
	 * @return this line for chaining
	 * */
	public ILine scaleCentered(IVector2 scaling);

	/**
	 * Checks if the given point is on this line
	 * @param point the point
	 * @return true, if the point is on the line
	 * */
	public boolean isPointOnLine(IVector2 point);
	
	/**
	 * Checks if the given point is on this line
	 * @param x the x position of the point
	 * @param y the y position of the point
	 * @return true, if the point is on the line
	 * */
	public boolean isPointOnLine(Number x, Number y);
	
	
	
}

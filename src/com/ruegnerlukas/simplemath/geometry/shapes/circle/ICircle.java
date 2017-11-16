package com.ruegnerlukas.simplemath.geometry.shapes.circle;

import com.ruegnerlukas.simplemath.geometry.shapes.IShape;
import com.ruegnerlukas.simplemath.vectors.vec2.IVector2;

public interface ICircle extends IShape {

	
	/**
	 * @return the x-position of this circle as an int
	 * */
	public int getXInt();
	
	/**
	 * @return the y-position of this circle as an int
	 * */
	public int getYInt();
	
	/**
	 * @return the x-position of the center of this circle as an int
	 * */
	public int getCenterXInt();
	
	/**
	 * @return the y-position of the center  of this circle as an int
	 * */
	public int getCenterYInt();
	
	/**
	 * @return the size/diameter of this circle as an int
	 * */
	public int getSizeInt();
	
	/**
	 * @return the radius of this circle as an int
	 * */
	public int getRadiusInt();
	
	/**
	 * @return the x-position of this circle as a float
	 * */
	public float getXFloat();
	
	/**
	 * @return the y-position of this circle as a float
	 * */
	public float getYFloat();
	
	/**
	 * @return the x-position of the center of this circle as an float
	 * */
	public float getCenterXFloat();
	
	/**
	 * @return the y-position of the center  of this circle as an float
	 * */
	public float getCenterYFloat();
	
	/**
	 * @return the size/diameter of this circle as a float
	 * */
	public float getSizeFloat();
	
	/**
	 * @return the radius of this circle as an float
	 * */
	public float getRadiusFloat();
	
	/**
	 * @return the x-position of this circle as a double
	 * */
	public double getXDouble();
	
	/**
	 * @return the y-position of this circle as a double
	 * */
	public double getYDouble();
	
	/**
	 * @return the x-position of the center of this circle as an double
	 * */
	public double getCenterXDouble();
	
	/**
	 * @return the y-position of the center  of this circle as an double
	 * */
	public double getCenterYDouble();
	
	/**
	 * @return the size/diameter of this circle as a double
	 * */
	public double getSizeDouble();
	
	/**
	 * @return the radius of this circle as an double
	 * */
	public double getRadiusDouble();
	
	
	/**
	 * @return the position of the center of this circle
	 * */
	public IVector2 getCenter();
	
	
	/**
	 * @param dest the destination vector for the position (or null)
	 * @return the vector containing the position of the center of this circle.
	 * */
	public IVector2 getCenter(IVector2 dest);
	
	
	/**
	 * @return the position (corner) of this circle
	 * */
	public IVector2 getPosition();
	
	
	/**
	 * @param dest the destination vector for the position (corner) (or null)
	 * @return the vector containing the position (corner) of this circle.
	 * */
	public IVector2 getPosition(IVector2 dest);
	
	
	
	
	
	
	/**
	 * Sets the position and the size of this circle
	 * @param cx the new x position of the center of this circle as a Number
	 * @param cy the new y position of the center of this circle as a Number
	 * @param radius the new radius of this circle as a Number
	 * @return this circle for chaining
	 * */
	public ICircle set(Number cx, Number cy, Number radius);
	
	
	/**
	 * Sets the position and the size of this circle
	 * @param x the new x position of this circle as a Number
	 * @param y the new y position of this circle as a Number
	 * @param radius the new radius of this circle as a Number
	 * @param setCenter whether or not to set the position of the center or of the corner of this circle
	 * @return this circle for chaining
	 * */
	public ICircle set(Number x, Number y, Number radius, boolean setCenter);
	
	
	/**
	 * Sets the position and the size of this circle
	 * @param center the vector representing the new center of this circle
	 * @param radius the new radius of this circle
	 * @return this circle for chaining
	 * */
	public ICircle set(IVector2 center, Number radius);
	
	
	/**
	 * Sets the x-position of the center of this circle
	 * @param x the new x-position
	 * @return this circle for chaining
	 * */
	public ICircle setCenterX(Number cx);


	/**
	 * Sets the y-position of the center of this circle
	 * @param y the new y-position
	 * @return this circle for chaining
	 * */
	public ICircle setCenterY(Number cy);
	
	
	/**
	 * Sets the position of the center point of this circle.
	 * @param cx the new x position of the center as a Number
	 * @param cy the new y position of the center as a Number
	 * @return this circle for chaining
	 * */
	public ICircle setCenter(Number cx, Number cy);
	
	
	/**
	 * Sets the position of the center point of this circle.
	 * @param center the vector representing the new center of this circle
	 * @return this circle for chaining
	 * */
	public ICircle setCenter(IVector2 center);
	
	
	/**
	 * Sets the x-position (corner) of this circle
	 * @param x the new x-position
	 * @return this circle for chaining
	 * */
	public ICircle setX(Number x);


	/**
	 * Sets the y-position (corner) of this circle
	 * @param y the new y-position
	 * @return this circle for chaining
	 * */
	public ICircle setY(Number y);
	
	
	/**
	 * Sets the x and y position (corner) of this circle.
	 * @param x the new x position of this circle as a Number
	 * @param y the new y position of this circle as a Number
	 * @return this circle for chaining
	 * */
	public ICircle setPosition(Number x, Number y);
	
	
	/**
	 * Sets the x and y position of this circle.
	 * @param position the vector representing the new x and y position of this circle
	 * @return this circle for chaining
	 * */
	public ICircle setPosition(IVector2 position);
	
	
	/**
	 * Sets the radius of this circle
	 * @param radius the new radius
	 * @return this circle for chaining
	 * */
	public ICircle setRadius(Number radius);
	
	
	/**
	 * Sets the size/diameter of this circle
	 * @param diameter the new diameter
	 * @return this circle for chaining
	 * */
	public ICircle setSize(Number diameter);

	
	/**
	 * Sets the minimal x value of this circle.
	 * @param minX the new minimal x value
	 * @return this circle for chaining
	 * */
	public ICircle setMinX(Number minX);
	
	
	/**
	 * Sets the minimal y value of this circle.
	 * @param minY the new minimal y value
	 * @return this circle for chaining
	 * */
	public ICircle setMinY(Number minY);
	
	
	/**
	 * Sets the minimal x and y value of this circle.
	 * @param minX the new minimal x value
	 * @param minY the new minimal y value
	 * @return this circle for chaining
	 * */
	public ICircle setMin(Number minX, Number minY);
	
	
	/**
	 * Sets the minimal x and y value of this circle.
	 * @param min the vector representing the new minimal x and y values
	 * @return this circle for chaining
	 * */
	public ICircle setMin(IVector2 min);
	
	
	/**
	 * Sets the maximal x value of this circle.
	 * @param maxX the new maximal x value
	 * @return this circle for chaining
	 * */
	public ICircle setMaxX(Number maxX);
	
	
	/**
	 * Sets the maximal y value of this circle.
	 * @param maxY the new maximal y value
	 * @return this circle for chaining
	 * */
	public ICircle setMaxY(Number maxY);
	
	
	/**
	 * Sets the maximal x and y value of this circle.
	 * @param maxX the new maximal x value
	 * @param maxY the new maximal y value
	 * @return this circle for chaining
	 * */
	public ICircle setMax(Number maxX, Number maxY);
	
	
	/**
	 * Sets the maximal x and y value of this circle.
	 * @param max the vector representing the new maximal x and y values
	 * @return this circle for chaining
	 * */
	public ICircle setMax(IVector2 max);

	
	
	
	
	
	/**
	 * Moves this circle by the given amount.
	 * @param dx the distance in x-direction
	 * @param dy the distance in y-direction
	 * @return this circle for chaining
	 * */
	public ICircle translate(Number dx, Number dy);
	
	
	/**
	 * Moves this circle by the given amount.
	 * @param dir the vector representing the distance in the x- and y-direction
	 * @return this circle for chaining
	 * */
	public ICircle translate(IVector2 dir);

	
	/**
	 * Scales the size of this circle. The position of the corner does not change.
	 * @param sx the scaling in x direction
	 * @param sy the scaling in y direction
	 * @return this circle for chaining
	 * */
	public ICircle scale(Number s);

	
	/**
	 * Scales the size of this circle. The position of the center of does not change.
	 * @param sx the scaling in x direction
	 * @param sy the scaling in y direction
	 * @return this circle for chaining
	 * */
	public ICircle scaleCentered(Number s);

	
	/**
	 * Grows the size/diameter of this circle.
	 * @param size the additional size to add to this rectangle
	 * @return this circle for chaining
	 * */
	public ICircle grow(Number size);
	
	
	/**
	 * Grows the radius of this circle.
	 * @param size the additional size to add to this circle
	 * @return this circle for chaining
	 * */
	public ICircle growRadius(Number size);
	
	
	/**
	 * Adds the given point to the bounds of this circle.
	 * @param x the x position of the point
	 * @param y the y position of the point
	 * @return this circle for chaining
	 * */
	public ICircle addPoint(Number x, Number y);
	
	
	/**
	 * Adds the given point to the bounds of this circle.
	 * @param point the point
	 * @return this circle for chaining
	 * */
	public ICircle addPoint(IVector2 point);
	
	
	/**
	 * Removes the given point from the bounds of this circle.
	 * @param x the x position of the point
	 * @param y the y position of the point
	 * @return this circle for chaining
	 * */
	public ICircle removePoint(Number x, Number y);
	
	
	/**
	 * Removes the given point from the bounds of this circle.
	 * @param point the point
	 * @return this circle for chaining
	 * */
	public ICircle removePoint(IVector2 point);

	
	/**
	 * Checks whether the given point is inside this circle.
	 * @param x the x position of the point
	 * @param y the y position of the point
	 * @return true, if the point is inside this circle
	 * */
	public boolean containsPoint(Number x, Number y);
	
	
	/**
	 * Checks whether the given point is inside this circle.
	 * @param point the point
	 * @return true, if the point is inside this circle
	 * */
	public boolean containsPoint(IVector2 point);
	
	
	/**
	 * Checks whether the given shape is completely inside this circle.
	 * @param shape the shape
	 * @return true, if the shape is inside this circle
	 * */
	public boolean containsShape(IShape shape);
	
	
	/**
	 * @return the area of this circle as a Number
	 * */
	public Number getAreaGen();
	
	
	/**
	 * @return the circumference of this circle as a Number
	 * */
	public Number getCircumferenceGen();
	
	
}

package com.ruegnerlukas.simplemath.geometry.shapes.rectangle;

import com.ruegnerlukas.simplemath.geometry.shapes.IShape;
import com.ruegnerlukas.simplemath.vectors.vec2.IVector2;

public interface IRectangle extends IShape {
	
	
	
	
	/**
	 * @return the x-position of this rectangle as an int
	 * */
	public int getXInt();
	
	/**
	 * @return the y-position of this rectangle as an int
	 * */
	public int getYInt();
	
	/**
	 * @return the width of this rectangle as an int
	 * */
	public int getWidthInt();
	
	/**
	 * @return the height of this rectangle as an int
	 * */
	public int getHeightInt();
	
	/**
	 * @return the x-position of this rectangle as a float
	 * */
	public float getXFloat();
	
	/**
	 * @return the y-position of this rectangle as a float
	 * */
	public float getYFloat();
	
	/**
	 * @return the width of this rectangle as a float
	 * */
	public float getWidthFloat();
	
	/**
	 * @return the height of this rectangle as a float
	 * */
	public float getHeightFloat();
	
	/**
	 * @return the x-position of this rectangle as a double
	 * */
	public double getXDouble();
	
	/**
	 * @return the y-position of this rectangle as a double
	 * */
	public double getYDouble();
	
	/**
	 * @return the width of this rectangle as a double
	 * */
	public double getWidthDouble();
	
	/**
	 * @return the height of this rectangle as a double
	 * */
	public double getHeightDouble();
	
	
	/**
	 * @return the x position of the center of this rectangle
	 * */
	public Number getCenterXGen();
	
	
	/**
	 * @return the y position of the center of this rectangle
	 * */
	public Number getCenterYGen();
	
	
	/**
	 * @return the position of the center of this rectangle
	 * */
	public IVector2 getCenter();
	
	
	/**
	 * @param dest the destination vector for the position (or null)
	 * @return the vector containing the position of the center of this rectangle.
	 * */
	public IVector2 getCenter(IVector2 dest);
	
	
	/**
	 * @return the position of this rectangle
	 * */
	public IVector2 getPosition();
	
	
	/**
	 * @param dest the destination vector for the position (or null)
	 * @return the vector containing the position of this rectangle.
	 * */
	public IVector2 getPosition(IVector2 dest);
	
	
	/**
	 * @return the size of this rectangle
	 * */
	public IVector2 getSize();
	
	
	/**
	 * @param dest the destination vector for the size (or null)
	 * @return the vector containing the size of this rectangle.
	 * */
	public IVector2 getSize(IVector2 dest);
	
	
	/**
	 * Sets the position and size of this rectangle to the position and size of the given rectangle.
	 * @param rectangle the rectangle
	 * @return this rectangle for chaining
	 * */
	public IRectangle set(IRectangle rectangle);
	
	
	
	
	
	
	/**
	 * Sets the position and the size of this rectangle
	 * @param x the new x position of this rectangle as a Number
	 * @param y the new y position of this rectangle as a Number
	 * @param width the new width of this rectangle as a Number
	 * @param height the new height of this rectangle as a Number
	 * @return this rectangle for chaining
	 * */
	public IRectangle set(Number x, Number y, Number width, Number height);
	
	
	/**
	 * Sets the x-position of this rectangle
	 * @param x the new x-position
	 * @return this rectangle for chaining
	 * */
	public IRectangle setX(Number x);


	/**
	 * Sets the y-position of this rectangle
	 * @param y the new y-position
	 * @return this rectangle for chaining
	 * */
	public IRectangle setY(Number y);
	
	
	/**
	 * Sets the x and y position of this rectangle.
	 * @param x the new x position of this rectangle as a Number
	 * @param y the new y position of this rectangle as a Number
	 * @return this rectangle for chaining
	 * */
	public IRectangle setPosition(Number x, Number y);
	
	
	/**
	 * Sets the x and y position of this rectangle.
	 * @param position the vector representing the new x and y position of this rectangle
	 * @return this rectangle for chaining
	 * */
	public IRectangle setPosition(IVector2 position);

	
	/**
	 * Sets the position of the center point of this rectangle.
	 * @param cx the new x position of the center as a Number
	 * @param cy the new y position of the center as a Number
	 * @return this rectangle for chaining
	 * */
	public IRectangle setCenter(Number cx, Number cy);
	
	
	/**
	 * Sets the position of the center point of this rectangle.
	 * @param center the vector representing the new center of this rectangle
	 * @return this rectangle for chaining
	 * */
	public IRectangle setCenter(IVector2 center);
	
	
	/**
	 * Sets the width of this rectangle
	 * @param width the new width
	 * @return this rectangle for chaining
	 * */
	public IRectangle setWidth(Number width);
	
	
	/**
	 * Sets the height of this rectangle
	 * @param height the new height
	 * @return this rectangle for chaining
	 * */
	public IRectangle setHeight(Number height);
	
	
	/**
	 * Sets the width and height of this rectangle.
	 * @param width the new width of this rectangle as a Number
	 * @param height the new height of this rectangle as a Number
	 * @return this rectangle for chaining
	 * */
	public IRectangle setSize(Number width, Number height);
	
	
	/**
	 * Sets the width and height of this rectangle.
	 * @param size the vector representing the new width and height of this rectangle
	 * @return this rectangle for chaining
	 * */
	public IRectangle setSize(IVector2 size);

	
	/**
	 * Sets the position and the size of this rectangle
	 * @param position the vector representing the new x- and y-position of this rectangle
	 * @param size the vector representing the new width and height of this rectangle
	 * @return this rectangle for chaining
	 * */
	public IRectangle set(IVector2 position, IVector2 size);

	
	/**
	 * Sets the minimal x value of this rectangle.
	 * @param minX the new minimal x value
	 * @return this rectangle for chaining
	 * */
	public IRectangle setMinX(Number minX);
	
	
	/**
	 * Sets the minimal y value of this rectangle.
	 * @param minX the new minimal y value
	 * @return this rectangle for chaining
	 * */
	public IRectangle setMinY(Number minX);
	
	
	/**
	 * Sets the minimal x and y value of this rectangle.
	 * @param minX the new minimal x value
	 * @param minY the new minimal y value
	 * @return this rectangle for chaining
	 * */
	public IRectangle setMin(Number minX, Number minY);
	
	
	/**
	 * Sets the minimal x and y value of this rectangle.
	 * @param min the vector representing the new minimal x and y values
	 * @return this rectangle for chaining
	 * */
	public IRectangle setMin(IVector2 min);
	
	
	/**
	 * Sets the maximal x value of this rectangle.
	 * @param maxX the new maximal x value
	 * @return this rectangle for chaining
	 * */
	public IRectangle setMaxX(Number maxX);
	
	
	/**
	 * Sets the maximal y value of this rectangle.
	 * @param maxY the new maximal y value
	 * @return this rectangle for chaining
	 * */
	public IRectangle setMaxY(Number maxY);
	
	
	/**
	 * Sets the maximal x and y value of this rectangle.
	 * @param maxX the new maximal x value
	 * @param maxY the new maximal y value
	 * @return this rectangle for chaining
	 * */
	public IRectangle setMax(Number maxX, Number maxY);
	
	
	/**
	 * Sets the maximal x and y value of this rectangle.
	 * @param max the vector representing the new maximal x and y values
	 * @return this rectangle for chaining
	 * */
	public IRectangle setMax(IVector2 max);

	
	
	
	
	
	/**
	 * Moves this rectangle by the given amount.
	 * @param dx the distance in x-direction
	 * @param dy the distance in y-direction
	 * @return this rectangle for chaining
	 * */
	public IRectangle translate(Number dx, Number dy);
	
	
	/**
	 * Moves this rectangle by the given amount.
	 * @param dir the vector representing the distance in the x- and y-direction
	 * @return this rectangle for chaining
	 * */
	public IRectangle translate(IVector2 dir);

	
	/**
	 * Scales the width and height of this rectangle. The position does not change.
	 * @param sx the scaling in x direction
	 * @param sy the scaling in y direction
	 * @return this rectangle for chaining
	 * */
	public IRectangle scale(Number sx, Number sy);
	
	
	/**
	 * Scales the width and height of this rectangle. The position does not change.
	 * @param scaling the vector representing the scaling in x and y direction
	 * @return this rectangle for chaining
	 * */
	public IRectangle scale(IVector2 scaling);

	
	/**
	 * Scales the width and height of this rectangle. The position of the center of does not change.
	 * @param sx the scaling in x direction
	 * @param sy the scaling in y direction
	 * @return this rectangle for chaining
	 * */
	public IRectangle scaleCentered(Number sx, Number sy);
	
	
	/**
	 * Scales the width and height of this rectangle. The position of the center does not change.
	 * @param scaling the vector representing the scaling in x and y direction
	 * @return this rectangle for chaining
	 * */
	public IRectangle scaleCentered(IVector2 scaling);

	
	/**
	 * Grows the with and height of this rectangle.
	 * @param width the additional width to add to this rectangle
	 * @param height the additional height to add to this rectangle
	 * @return this rectangle for chaining
	 * */
	public IRectangle grow(Number width, Number height);
	
	
	/**
	 * Grows the with and height of this rectangle.
	 * @param size the additional width and height to add to this rectangle
	 * @return this rectangle for chaining
	 * */
	public IRectangle grow(IVector2 size);
	
	
	/**
	 * Adds the given point to the bounds of this rectangle.
	 * @param x the x position of the point
	 * @param y the y position of the point
	 * @return this rectangle for chaining
	 * */
	public IRectangle addPoint(Number x, Number y);
	
	
	/**
	 * Adds the given point to the bounds of this rectangle.
	 * @param point the point
	 * @return this rectangle for chaining
	 * */
	public IRectangle addPoint(IVector2 point);
	
	
	/**
	 * Removes the given point from the bounds of this rectangle.
	 * @param x the x position of the point
	 * @param y the y position of the point
	 * @param centered whether or not this rectangle should shrink in the direction of its center
	 * @return this rectangle for chaining
	 * */
	public IRectangle removePoint(Number x, Number y, boolean centered);
	
	
	/**
	 * Removes the given point from the bounds of this rectangle.
	 * @param point the point
	 * @param centered whether or not this rectangle should shrink in the direction of its center
	 * @return this rectangle for chaining
	 * */
	public IRectangle removePoint(IVector2 point, boolean centered);

	
	/**
	 * Checks whether the given point is inside this rectangle.
	 * @param x the x position of the point
	 * @param y the y position of the point
	 * @return true, if the point is inside this rectangle
	 * */
	public boolean containsPoint(Number x, Number y);
	
	
	/**
	 * Checks whether the given point is inside this rectangle.
	 * @param point the point
	 * @return true, if the point is inside this rectangle
	 * */
	public boolean containsPoint(IVector2 point);
	
	
	/**
	 * Checks whether the given rectangle is completely inside this rectangle.
	 * @param pos the x and y position of the rectangle
	 * @param size the width and height of this rectangle
	 * @return true, if the rectangle is inside this rectangle
	 * */
	public boolean containsRectangle(IVector2 pos, IVector2 size);
	
	
	/**
	 * Checks whether the given rectangle is completely inside this rectangle.
	 * @param x the x position of the rectangle
	 * @param y the y position of the rectangle
	 * @param width the with of the rectangle
	 * @param height the height of this rectangle
	 * @return true, if the rectangle is inside this rectangle
	 * */
	public boolean containsRectangle(Number x, Number y, Number width, Number height);
	
	
	/**
	 * Checks whether the given rectangle is completely inside this rectangle.
	 * @param rect the rectangle
	 * @return true, if the rectangle is inside this rectangle
	 * */
	public boolean containsRectangle(IRectangle rect);
	
	
	/**
	 * Checks whether the given shape is completely inside this rectangle.
	 * @param shape the shape
	 * @return true, if the shape is inside this rectangle
	 * */
	public boolean containsShape(IShape shape);
	
	
	/**
	 * Calculates the overlapping area of an intersection between this rectangle and another rectangle.
	 * @param pos the position of the rectangle
	 * @param size the size of the rectangle
	 * @param dest the destination or null
	 * @return the overlapping area as a rectangle or null, if they dont overlap
	 * */
	public IRectangle getOverlap(IVector2 pos, IVector2 size, IRectangle dest);
	
	
	/**
	 * Calculates the overlapping area of an intersection between this rectangle and another rectangle.
	 * @param x the x position of the rectangle
	 * @param y the y position of the rectangle
	 * @param width the width of the rectangle
	 * @param height the height of the rectangle
	 * @param dest the destination or null
	 * @return the overlapping area as a rectangle or null, if they dont overlap
	 * */
	public IRectangle getOverlap(Number x, Number y, Number width, Number height, IRectangle dest);
	
	
	/**
	 * Calculates the overlapping area of an intersection between this rectangle and another rectangle.
	 * @param other the other rectangle
	 * @param dest the destination or null
	 * @return the overlapping area as a rectangle or null, if they dont overlap
	 * */
	public IRectangle getOverlap(IRectangle other, IRectangle dest);
	
	
	/**
	 * @return the area of this rectangle as a Number
	 * */
	public Number getAreaGen();
	
	
	/**
	 * @return the circumference of this rectangle as a Number
	 * */
	public Number getCircumferenceGen();
	
	
	/**
	 * Sets the width and height to a positive value and moves this rectangle is neccessary.
	 * @return this rectangle for chaining
	 * */
	public IRectangle normalize();

	
}

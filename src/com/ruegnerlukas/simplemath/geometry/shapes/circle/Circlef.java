package com.ruegnerlukas.simplemath.geometry.shapes.circle;

import com.ruegnerlukas.simplemath.geometry.Intersector;
import com.ruegnerlukas.simplemath.geometry.shapes.IShape;
import com.ruegnerlukas.simplemath.geometry.shapes.line.ILine;
import com.ruegnerlukas.simplemath.geometry.shapes.polygon.IPolygon;
import com.ruegnerlukas.simplemath.geometry.shapes.polygon.Polygonf;
import com.ruegnerlukas.simplemath.geometry.shapes.rectangle.IRectangle;
import com.ruegnerlukas.simplemath.geometry.shapes.rectangle.Rectanglef;
import com.ruegnerlukas.simplemath.vectors.vec2.IVector2;
import com.ruegnerlukas.simplemath.vectors.vec2.Vector2f;
import com.ruegnerlukas.simplemath.vectors.vec3.IVector3;
import com.ruegnerlukas.simplemath.vectors.vec4.IVector4;
import com.ruegnerlukas.simplemath.vectors.vec4.Vector4f;

public class Circlef implements ICircle {
	
	
	
	
	public float cx;
	public float cy;
	public float radius;
	
	public String name;
	
	
	
	
	
	
	/**
	 * Creates a new circle with its center at (0,0) and radius 0-
	 * */
	public Circlef() {
		this(0, 0, 0, true);
	}
	
	
	/**
	 * Creates a circle with the same position and size as the given circle.
	 * */
	public Circlef(Circlef circle) {
		this(circle.getCenterXFloat(), circle.getCenterYFloat(), circle.getRadiusFloat(), true);
	}
	
	
	/**
	 * Creates a circle with the x-position, y-position of the center and radius specified by the given vector.
	 * */
	public Circlef(IVector3 circle) {
		this(circle.getFloatX(), circle.getFloatY(), circle.getFloatZ(), true);
	}
	
	
	/**
	 * Creates a circle with its center at (0,0) with the given radius
	 * */
	public Circlef(float radius) {
		this(0, 0, radius, true);
	}
	
	
	/**
	 * Creates a new circle with its center at (x,y) and radius 0
	 * */
	public Circlef(float x, float y) {
		this(x, y, 0, true);
	}
	
	
	/**
	 * Creates a new circle with its center at (x,y) and radius 0
	 * @param centered whether or not the given position is the center or the corner of this circle
	 * */
	public Circlef(float x, float y, boolean centered) {
		this(x, y, 0, centered);
	}
	
	
	/**
	 * Creates a new circle with its center at the given location and the given radius
	 * */
	public Circlef(float x, float y, float radius) {
		this(x, y, radius, true);
	}
	
	
	/**
	 * Creates a new circle at the given location and the given radius
	 * @param centered whether or not the given position is the center or the corner of this circle
	 * */
	public Circlef(float x, float y, float radius, boolean centered) {
		if(centered) {
			this.cx = x;
			this.cy = y;
			this.radius = radius;
		} else {
			this.cx = x + (radius/2f);
			this.cy = y + (radius/2f);
			this.radius = radius;
		}
	}


	
	
	
	
	
	
	@Override
	public int getMinXInt() {
		return (int) (cx - radius);
	}


	@Override
	public float getMinXFloat() {
		return (float) (cx - radius);
	}


	@Override
	public double getMinXDouble() {
		return (double) (cx - radius);
	}


	@Override
	public int getMinYInt() {
		return (int) (cy - radius);
	}


	@Override
	public float getMinYFloat() {
		return (float) (cy - radius);
	}


	@Override
	public double getMinYDouble() {
		return (double) (cy - radius);
	}


	@Override
	public int getMaxXInt() {
		return (int) (cx + radius);
	}


	@Override
	public float getMaxXFloat() {
		return (float) (cx + radius);
	}


	@Override
	public double getMaxXDouble() {
		return (double) (cx + radius);
	}


	@Override
	public int getMaxYInt() {
		return (int) (cy + radius);
	}


	@Override
	public float getMaxYFloat() {
		return (float) (cy + radius);
	}


	@Override
	public double getMaxYDouble() {
		return (double) (cy + radius);
	}


	@Override
	public IVector2 getMin() {
		return getMin(new Vector2f());
	}


	@Override
	public IVector2 getMin(IVector2 dest) {
		if(dest == null) {
			dest = new Vector2f();
		}
		return dest.set(getMinXFloat(), getMinYFloat());
	}


	@Override
	public IVector2 getMax() {
		return getMax(new Vector2f());
	}


	@Override
	public IVector2 getMax(IVector2 dest) {
		if(dest == null) {
			dest = new Vector2f();
		}
		return dest.set(getMaxXFloat(), getMaxYFloat());
	}


	@Override
	public IRectangle getBounds() {
		return getBounds(new Rectanglef());
	}


	@Override
	public IRectangle getBounds(IRectangle dest) {
		if(dest == null) {
			dest = new Rectanglef();
		}
		return dest.setMin(getMinXFloat(), getMinYFloat()).setSize(radius*2, radius*2);
	}


	@Override
	public IVector4 getBoundsVec() {
		return getBoundsVec(new Vector4f());
	}


	@Override
	public IVector4 getBoundsVec(IVector4 dest) {
		if(dest == null) {
			dest = new Vector4f();
		}
		return dest.set(getMinXFloat(), getMinYFloat(), radius*2, radius*2);
	}


	@Override
	public boolean intersects(IShape other) {
		
		if(other instanceof IRectangle) {
			IRectangle rect = (IRectangle) other;
			return Intersector.intersectsRectangleCircle(rect.getXFloat(), rect.getYFloat(), rect.getWidthFloat(), rect.getHeightFloat(),
					this.cx, this.cy, this.radius);
		
		} else if(other instanceof ICircle) {
			ICircle circle = (ICircle) other;
			return Intersector.intersectsCircleCircle(this.cx, this.cy, this.radius,
					circle.getCenterXFloat(), circle.getCenterYFloat(), circle.getRadiusFloat());
			
		} else if(other instanceof ILine) {
			ILine line = (ILine) other;
			return Intersector.intersectsCircleLine(this.cx, this.cy, this.radius, line.getStartXFloat(),
					line.getStartYFloat(), line.getEndXFloat(), line.getEndYFloat());
			
		} else if(other instanceof Polygonf) {
			Polygonf poly = (Polygonf) other;
			return Intersector.intersectsCirclePolygon(cx, cy, radius, poly.getVertices());
			
		} else if(other instanceof IPolygon) {
			IPolygon poly = (IPolygon) other;
			float[] polyVert = new float[poly.getVerticesGen().length];
			for(int i=0, n=polyVert.length; i<n; i++) {
				polyVert[i] = poly.getVerticesGen()[i].floatValue();
			}
			return Intersector.intersectsCirclePolygon(cx, cy, radius, polyVert);
			
		} else {
			// TODO other shapes
		}
		return false;
	}


	@Override
	public IShape copy() {
		return new Circlef(this);
	}
	
	
	
	
	@Override
	public String toString() {
		return name + ": Circlef." + this.hashCode() + "(" + this.cx + ", " + this.cy + ") r=" + this.radius;
	}


	@Override
	public int getXInt() {
		return (int) (cx - radius);
	}


	@Override
	public int getYInt() {
		return (int) (cy - radius);
	}


	@Override
	public int getCenterXInt() {
		return (int) cx;
	}


	@Override
	public int getCenterYInt() {
		return (int) cy;
	}


	@Override
	public int getSizeInt() {
		return (int) (radius * 2f);
	}


	@Override
	public int getRadiusInt() {
		return (int) radius;
	}


	@Override
	public float getXFloat() {
		return (float) (cx - radius);
	}


	@Override
	public float getYFloat() {
		return (float) (cy - radius);
	}


	@Override
	public float getCenterXFloat() {
		return (float) cx;
	}


	@Override
	public float getCenterYFloat() {
		return (float) cy;
	}


	@Override
	public float getSizeFloat() {
		return (float) (radius * 2f);
	}


	@Override
	public float getRadiusFloat() {
		return (float) radius;
	}


	@Override
	public double getXDouble() {
		return (double) (cx - radius);
	}


	@Override
	public double getYDouble() {
		return (double) (cy - radius);
	}


	@Override
	public double getCenterXDouble() {
		return (double) cx;
	}


	@Override
	public double getCenterYDouble() {
		return (double) cy;
	}


	@Override
	public double getSizeDouble() {
		return (double) (radius * 2f);
	}


	@Override
	public double getRadiusDouble() {
		return (double) radius;
	}


	@Override
	public IVector2 getCenter() {
		return getCenter(new Vector2f());
	}


	@Override
	public IVector2 getCenter(IVector2 dest) {
		if(dest == null) {
			dest = new Vector2f();
		}
		return dest.set(getCenterXFloat(), getCenterYFloat());
	}


	@Override
	public IVector2 getPosition() {
		return getPosition(new Vector2f());
	}


	@Override
	public IVector2 getPosition(IVector2 dest) {
		if(dest == null) {
			dest = new Vector2f();
		}
		return dest.set(getXFloat(), getYFloat());
	}


	@Override
	public Circlef set(Number cx, Number cy, Number radius) {
		return this.set(cx.floatValue(), cy.floatValue(), radius.floatValue());
	}
	
	
	/**
	 * Sets the position and the size of this circle
	 * @param cx the new x position of the center of this circle
	 * @param cy the new y position of the center of this circle
	 * @param radius the new radius of this circle
	 * @return this circle for chaining
	 * */
	public Circlef set(float cx, float cy, float radius) {
		this.cx = cx;
		this.cy = cy;
		this.radius = radius;
		return this;
	}


	@Override
	public Circlef set(Number x, Number y, Number radius, boolean setCenter) {
		return this.set(x.floatValue(), y.floatValue(), radius.floatValue(), setCenter);
	}

	
	/**
	 * Sets the position and the size of this circle
	 * @param x the new x position of this circle
	 * @param y the new y position of this circle
	 * @param radius the new radius of this circle
	 * @param setCenter whether or not to set the position of the center or of the corner of this circle
	 * @return this circle for chaining
	 * */
	public Circlef set(float x, float y, float radius, boolean setCenter) {
		if(setCenter) {
			this.cx = x;
			this.cy = y;
			this.radius = radius;
		} else {
			this.cx = x + radius;
			this.cy = y + radius;
			this.radius = radius;
		}
		return this;
	}
	

	@Override
	public Circlef set(IVector2 center, Number radius) {
		return this.set(center, radius.floatValue());
	}
	
	
	/**
	 * Sets the position and the size of this circle
	 * @param center the vector representing the new center of this circle
	 * @param radius the new radius of this circle
	 * @return this circle for chaining
	 * */
	public Circlef set(IVector2 center, float radius) {
		return this.set(center.getFloatX(), center.getFloatY(), radius);
	}


	@Override
	public Circlef setCenterX(Number cx) {
		return this.setCenterX(cx.floatValue());
	}
	
	
	/**
	 * Sets the x-position of the center of this circle
	 * @param x the new x-position
	 * @return this circle for chaining
	 * */
	public Circlef setCenterX(float cx) {
		this.cx = cx;
		return this;
	}


	@Override
	public Circlef setCenterY(Number cy) {
		return this.setCenterY(cy.floatValue());
	}

	
	/**
	 * Sets the y-position of the center of this circle
	 * @param y the new y-position
	 * @return this circle for chaining
	 * */
	public Circlef setCenterY(float cy) {
		this.cy = cy;
		return this;
	}
	

	@Override
	public Circlef setCenter(Number cx, Number cy) {
		return this.setCenter(cx.floatValue(), cy.floatValue());
	}
	
	
	/**
	 * Sets the position of the center point of this circle.
	 * @param cx the new x position of the center
	 * @param cy the new y position of the center
	 * @return this circle for chaining
	 * */
	public Circlef setCenter(float cx, float cy) {
		this.cx = cx;
		this.cy = cy;
		return this;
	}


	@Override
	public Circlef setCenter(IVector2 center) {
		return this.setCenter(center.getFloatX(), center.getFloatY());
	}


	@Override
	public Circlef setX(Number x) {
		return this.setX(x.floatValue());
	}
	
	
	/**
	 * Sets the x-position (corner) of this circle
	 * @param x the new x-position
	 * @return this circle for chaining
	 * */
	public Circlef setX(float x) {
		this.cx = x + radius;
		return this;
	}


	@Override
	public Circlef setY(Number y) {
		return this.setY(y.floatValue());
	}


	/**
	 * Sets the y-position (corner) of this circle
	 * @param y the new y-position
	 * @return this circle for chaining
	 * */
	public Circlef setY(float y) {
		this.cy  = y + radius;
		return this;
	}


	@Override
	public Circlef setPosition(Number x, Number y) {
		return this.setPosition(x.floatValue(), y.floatValue());
	}
	
	
	/**
	 * Sets the x and y position (corner) of this circle.
	 * @param x the new x position of this circle as a Number
	 * @param y the new y position of this circle as a Number
	 * @return this circle for chaining
	 * */
	public Circlef setPosition(float x, float y) {
		this.cx = x + radius;
		this.cy = y + radius;
		return this;
	}


	@Override
	public Circlef setPosition(IVector2 position) {
		return this.setPosition(position.getFloatX(), position.getFloatY());
	}


	@Override
	public Circlef setRadius(Number radius) {
		return this.setRadius(radius.floatValue());
	}
	
	
	/**
	 * Sets the radius of this circle
	 * @param radius the new radius
	 * @return this circle for chaining
	 * */
	public Circlef setRadius(float radius) {
		this.radius = radius;
		return this;
	}


	@Override
	public Circlef setSize(Number diameter) {
		return this.setSize(diameter.floatValue());
	}
	
	
	/**
	 * Sets the size/diameter of this circle
	 * @param diameter the new diameter
	 * @return this circle for chaining
	 * */
	public Circlef setSize(float diameter) {
		this.radius = diameter / 2f;
		return this;
	}


	@Override
	public Circlef setMinX(Number minX) {
		return this.setMinX(minX.floatValue());
	}
	
	
	/**
	 * Sets the minimal x value of this circle.
	 * @param minX the new minimal x value
	 * @return this circle for chaining
	 * */
	public Circlef setMinX(float minX) {
		return setX(minX);
	}


	@Override
	public Circlef setMinY(Number minY) {
		return this.setMinY(minY.floatValue());
	}
	
	
	/**
	 * Sets the minimal y value of this circle.
	 * @param minY the new minimal y value
	 * @return this circle for chaining
	 * */
	public Circlef setMinY(float minY) {
		return setY(minY);
	}


	@Override
	public Circlef setMin(Number minX, Number minY) {
		return this.setMin(minX.floatValue(), minY.floatValue());
	}
	
	
	/**
	 * Sets the minimal x and y value of this circle.
	 * @param minX the new minimal x value
	 * @param minY the new minimal y value
	 * @return this circle for chaining
	 * */
	public Circlef setMin(float minX, float minY) {
		this.setMinX(minX);
		this.setMinY(minY);
		return this;
	}


	@Override
	public Circlef setMin(IVector2 min) {
		return this.setMin(min.getFloatX(), min.getFloatY());
	}


	@Override
	public Circlef setMaxX(Number maxX) {
		return this.setMaxX(maxX.floatValue());
	}
	
	
	/**
	 * Sets the maximal x value of this circle.
	 * @param maxX the new maximal x value
	 * @return this circle for chaining
	 * */
	public Circlef setMaxX(float maxX) {
		this.cx = maxX - radius;
		return this;
	}


	@Override
	public Circlef setMaxY(Number maxY) {
		return this.setMaxY(maxY.floatValue());
	}
	
	
	/**
	 * Sets the maximal y value of this circle.
	 * @param maxY the new maximal y value
	 * @return this circle for chaining
	 * */
	public Circlef setMaxY(float maxY) {
		this.cy = maxY - radius;
		return this;
	}


	@Override
	public Circlef setMax(Number maxX, Number maxY) {
		return this.setMax(maxX.floatValue(), maxY.floatValue());
	}
	
	
	/**
	 * Sets the maximal x and y value of this circle.
	 * @param maxX the new maximal x value
	 * @param maxY the new maximal y value
	 * @return this circle for chaining
	 * */
	public Circlef setMax(float maxX, float maxY) {
		setMaxX(maxX);
		setMaxY(maxY);
		return this;
	}


	@Override
	public Circlef setMax(IVector2 max) {
		return this.setMax(max.getFloatX(), max.getFloatY());
	}


	@Override
	public Circlef translate(Number dx, Number dy) {
		return this.translate(dx.floatValue(), dy.floatValue());
	}
	
	/**
	 * Moves this circle by the given amount.
	 * @param dx the distance in x-direction
	 * @param dy the distance in y-direction
	 * @return this circle for chaining
	 * */
	public Circlef translate(float dx, float dy) {
		this.cx += dx;
		this.cy += dy;
		return this;
	}


	@Override
	public Circlef translate(IVector2 dir) {
		return this.translate(dir.getFloatX(), dir.getFloatY());
	}


	@Override
	public Circlef scale(Number s) {
		return this.scale(s.floatValue());
	}
	
	
	/**
	 * Scales the size of this circle. The position of the corner does not change.
	 * @param sx the scaling in x direction
	 * @param sy the scaling in y direction
	 * @return this circle for chaining
	 * */
	public Circlef scale(float s) {
		final float x = cx - radius;
		final float y = cy - radius;
		this.radius *= s;
		return this.setPosition(x, y);
	}


	@Override
	public Circlef scaleCentered(Number s) {
		return this.scaleCentered(s.floatValue());
	}
	
	
	/**
	 * Scales the size of this circle. The position of the center of does not change.
	 * @param sx the scaling in x direction
	 * @param sy the scaling in y direction
	 * @return this circle for chaining
	 * */
	public Circlef scaleCentered(float s) {
		this.radius *= s;
		return this;
	}


	@Override
	public Circlef grow(Number size) {
		return this.grow(size.floatValue());
	}
	
	
	/**
	 * Grows the size/diameter of this circle.
	 * @param size the additional size to add to this rectangle
	 * @return this circle for chaining
	 * */
	public Circlef grow(float size) {
		this.radius += size/2f;
		return this;
	}


	@Override
	public Circlef growRadius(Number size) {
		return this.growRadius(size.floatValue());
	}
	
	
	/**
	 * Grows the radius of this circle.
	 * @param size the additional size to add to this circle
	 * @return this circle for chaining
	 * */
	public Circlef growRadius(float size) {
		this.radius += size;
		return this;
	}


	@Override
	public Circlef addPoint(Number x, Number y) {
		return this.addPoint(x.floatValue(), y.floatValue());
	}
	
	
	/**
	 * Adds the given point to the bounds of this circle.
	 * @param x the x position of the point
	 * @param y the y position of the point
	 * @return this circle for chaining
	 * */
	public Circlef addPoint(float x, float y) {
		if(!this.containsPoint(x, y)) {
			this.radius = (float) Math.sqrt( (cx-x)*(cx-x) + (cy-y)*(cy-y) );
		}
		return this;
	}


	@Override
	public Circlef addPoint(IVector2 point) {
		return this.addPoint(point.getFloatX(), point.getFloatY());
	}


	@Override
	public Circlef removePoint(Number x, Number y) {
		return this.removePoint(x.floatValue(), y.floatValue());
	}
	
	
	/**
	 * Removes the given point from the bounds of this circle.
	 * @param x the x position of the point
	 * @param y the y position of the point
	 * @return this circle for chaining
	 * */
	public Circlef removePoint(float x, float y) {
		if(this.containsPoint(x, y)) {
			this.radius = (float) Math.sqrt( (cx-x)*(cx-x) + (cy-y)*(cy-y) );
		}
		return this;
	}


	@Override
	public Circlef removePoint(IVector2 point) {
		return this.removePoint(point.getFloatX(), point.getFloatY());
	}


	@Override
	public boolean containsPoint(Number x, Number y) {
		return this.containsPoint(x.floatValue(), y.floatValue());
	}
	
	
	/**
	 * Checks whether the given point is inside this circle.
	 * @param x the x position of the point
	 * @param y the y position of the point
	 * @return true, if the point is inside this circle
	 * */
	public boolean containsPoint(float x, float y) {
		return ((cx-x)*(cx-x) + (cy-y)*(cy-y)) <= radius;
	}


	@Override
	public boolean containsPoint(IVector2 point) {
		return this.containsPoint(point.getFloatX(), point.getFloatY());
	}


	@Override
	public boolean containsShape(IShape shape) {
		// TODO
		return false;
	}


	@Override
	public Number getAreaGen() {
		return getArea();
	}
	
	
	/**
	 * @return the area of this circle
	 * */
	public float getArea() {
		return (float) (Math.PI * radius*radius) ;
	}


	@Override
	public Number getCircumferenceGen() {
		return getCircumference();
	}
	
	
	/**
	 * @return the circumference of this circle
	 * */
	public float getCircumference() {
		return (float) (Math.PI * 2*radius);
	}
	
	
	
	
	@Override
	public Circlef setName(String name) {
		this.name = name;
		return this;
	}

	
	

	@Override
	public String getName() {
		return this.name;
	}
	
	
	
}

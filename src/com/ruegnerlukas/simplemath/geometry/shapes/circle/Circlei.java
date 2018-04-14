package com.ruegnerlukas.simplemath.geometry.shapes.circle;

import com.ruegnerlukas.simplemath.geometry.Intersector;
import com.ruegnerlukas.simplemath.geometry.shapes.IShape;
import com.ruegnerlukas.simplemath.geometry.shapes.line.ILine;
import com.ruegnerlukas.simplemath.geometry.shapes.polygon.IPolygon;
import com.ruegnerlukas.simplemath.geometry.shapes.polygon.Polygonf;
import com.ruegnerlukas.simplemath.geometry.shapes.rectangle.IRectangle;
import com.ruegnerlukas.simplemath.geometry.shapes.rectangle.Rectanglef;
import com.ruegnerlukas.simplemath.vectors.vec2.IVector2;
import com.ruegnerlukas.simplemath.vectors.vec2.Vector2i;
import com.ruegnerlukas.simplemath.vectors.vec3.IVector3;
import com.ruegnerlukas.simplemath.vectors.vec4.IVector4;
import com.ruegnerlukas.simplemath.vectors.vec4.Vector4f;

public class Circlei implements ICircle {
	
	
	
	
	public int cx;
	public int cy;
	public int radius;
	
	public String name;
	
	
	
	
	
	/**
	 * Creates a new circle with its center at (0,0) and radius 0-
	 * */
	public Circlei() {
		this(0, 0, 0, true);
	}
	
	
	/**
	 * Creates a circle with the same position and size as the given circle.
	 * */
	public Circlei(Circlei circle) {
		this(circle.getCenterXInt(), circle.getCenterYInt(), circle.getRadiusInt(), true);
	}
	
	
	/**
	 * Creates a circle with the x-position, y-position of the center and radius specified by the given vector.
	 * */
	public Circlei(IVector3 circle) {
		this(circle.getIntX(), circle.getIntY(), circle.getIntZ(), true);
	}
	
	
	/**
	 * Creates a circle with its center at (0,0) with the given radius
	 * */
	public Circlei(int radius) {
		this(0, 0, radius, true);
	}
	
	
	/**
	 * Creates a new circle with its center at (x,y) and radius 0
	 * */
	public Circlei(int x, int y) {
		this(x, y, 0, true);
	}
	
	
	/**
	 * Creates a new circle with its center at (x,y) and radius 0
	 * @param centered whether or not the given position is the center or the corner of this circle
	 * */
	public Circlei(int x, int y, boolean centered) {
		this(x, y, 0, centered);
	}
	
	
	/**
	 * Creates a new circle with its center at the given location and the given radius
	 * */
	public Circlei(int x, int y, int radius) {
		this(x, y, radius, true);
	}
	
	
	/**
	 * Creates a new circle at the given location and the given radius
	 * @param centered whether or not the given position is the center or the corner of this circle
	 * */
	public Circlei(int x, int y, int radius, boolean centered) {
		if(centered) {
			this.cx = x;
			this.cy = y;
			this.radius = radius;
		} else {
			this.cx = x + (radius/2);
			this.cy = y + (radius/2);
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
		return getMin(new Vector2i());
	}


	@Override
	public IVector2 getMin(IVector2 dest) {
		if(dest == null) {
			dest = new Vector2i();
		}
		return dest.set((Integer)getMinXInt(), (Integer)getMinYInt());
	}


	@Override
	public IVector2 getMax() {
		return getMax(new Vector2i());
	}


	@Override
	public IVector2 getMax(IVector2 dest) {
		if(dest == null) {
			dest = new Vector2i();
		}
		return dest.set((Integer)getMaxXInt(), (Integer)getMaxYInt());
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
		return dest.setMin(getMinXInt(), getMinYInt()).setSize(radius*2, radius*2);
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
		return dest.set(getMinXInt(), getMinYInt(), radius*2, radius*2);
	}


	@Override
	public boolean intersects(IShape other) {
		
		if(other instanceof IRectangle) {
			IRectangle rect = (IRectangle) other;
			return Intersector.intersectsRectangleCircle(rect.getXInt(), rect.getYInt(), rect.getWidthInt(), rect.getHeightInt(),
					this.cx, this.cy, this.radius);
		
		} else if(other instanceof ICircle) {
			ICircle circle = (ICircle) other;
			return Intersector.intersectsCircleCircle(this.cx, this.cy, this.radius,
					circle.getCenterXInt(), circle.getCenterYInt(), circle.getRadiusInt());
			
		} else if(other instanceof ILine) {
			ILine line = (ILine) other;
			return Intersector.intersectsCircleLine(this.cx, this.cy, this.radius, line.getStartXInt(),
					line.getStartYInt(), line.getEndXInt(), line.getEndYInt());
			
		} else if(other instanceof Polygonf) {
			Polygonf poly = (Polygonf) other;
			return Intersector.intersectsCirclePolygon(cx, cy, radius, poly.getVertices());
			
		} else if(other instanceof IPolygon) {
			IPolygon poly = (IPolygon) other;
			float[] polyVert = new float[poly.getVerticesGen().length];
			for(int i=0, n=polyVert.length; i<n; i++) {
				polyVert[i] = poly.getVerticesGen()[i].intValue();
			}
			return Intersector.intersectsCirclePolygon(cx, cy, radius, polyVert);
			
		} else {
			// TODO other shapes
		}
		return false;
	}


	@Override
	public IShape copy() {
		return new Circlei(this);
	}
	
	
	
	
	@Override
	public String toString() {
		return name + ": Circlei." + this.hashCode() + "(" + this.cx + ", " + this.cy + ") r=" + this.radius;
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
		return getCenter(new Vector2i());
	}


	@Override
	public IVector2 getCenter(IVector2 dest) {
		if(dest == null) {
			dest = new Vector2i();
		}
		return dest.set((Integer)getCenterXInt(), (Integer)getCenterYInt());
	}


	@Override
	public IVector2 getPosition() {
		return getPosition(new Vector2i());
	}


	@Override
	public IVector2 getPosition(IVector2 dest) {
		if(dest == null) {
			dest = new Vector2i();
		}
		return dest.set((Integer)getXInt(), (Integer)getYInt());
	}


	@Override
	public Circlei set(Number cx, Number cy, Number radius) {
		return this.set(cx.intValue(), cy.intValue(), radius.intValue());
	}
	
	
	/**
	 * Sets the position and the size of this circle
	 * @param cx the new x position of the center of this circle
	 * @param cy the new y position of the center of this circle
	 * @param radius the new radius of this circle
	 * @return this circle for chaining
	 * */
	public Circlei set(int cx, int cy, int radius) {
		this.cx = cx;
		this.cy = cy;
		this.radius = radius;
		return this;
	}


	@Override
	public Circlei set(Number x, Number y, Number radius, boolean setCenter) {
		return this.set(x.intValue(), y.intValue(), radius.intValue(), setCenter);
	}

	
	/**
	 * Sets the position and the size of this circle
	 * @param x the new x position of this circle
	 * @param y the new y position of this circle
	 * @param radius the new radius of this circle
	 * @param setCenter whether or not to set the position of the center or of the corner of this circle
	 * @return this circle for chaining
	 * */
	public Circlei set(int x, int y, int radius, boolean setCenter) {
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
	public Circlei set(IVector2 center, Number radius) {
		return this.set(center, radius.intValue());
	}
	
	
	/**
	 * Sets the position and the size of this circle
	 * @param center the vector representing the new center of this circle
	 * @param radius the new radius of this circle
	 * @return this circle for chaining
	 * */
	public Circlei set(IVector2 center, int radius) {
		return this.set(center.getIntX(), center.getIntY(), radius);
	}


	@Override
	public Circlei setCenterX(Number cx) {
		return this.setCenterX(cx.intValue());
	}
	
	
	/**
	 * Sets the x-position of the center of this circle
	 * @param x the new x-position
	 * @return this circle for chaining
	 * */
	public Circlei setCenterX(int cx) {
		this.cx = cx;
		return this;
	}


	@Override
	public Circlei setCenterY(Number cy) {
		return this.setCenterY(cy.intValue());
	}

	
	/**
	 * Sets the y-position of the center of this circle
	 * @param y the new y-position
	 * @return this circle for chaining
	 * */
	public Circlei setCenterY(int cy) {
		this.cy = cy;
		return this;
	}
	

	@Override
	public Circlei setCenter(Number cx, Number cy) {
		return this.setCenter(cx.intValue(), cy.intValue());
	}
	
	
	/**
	 * Sets the position of the center point of this circle.
	 * @param cx the new x position of the center
	 * @param cy the new y position of the center
	 * @return this circle for chaining
	 * */
	public Circlei setCenter(int cx, int cy) {
		this.cx = cx;
		this.cy = cy;
		return this;
	}


	@Override
	public Circlei setCenter(IVector2 center) {
		return this.setCenter(center.getIntX(), center.getIntY());
	}


	@Override
	public Circlei setX(Number x) {
		return this.setX(x.intValue());
	}
	
	
	/**
	 * Sets the x-position (corner) of this circle
	 * @param x the new x-position
	 * @return this circle for chaining
	 * */
	public Circlei setX(int x) {
		this.cx = x + radius;
		return this;
	}


	@Override
	public Circlei setY(Number y) {
		return this.setY(y.intValue());
	}


	/**
	 * Sets the y-position (corner) of this circle
	 * @param y the new y-position
	 * @return this circle for chaining
	 * */
	public Circlei setY(int y) {
		this.cy  = y + radius;
		return this;
	}


	@Override
	public Circlei setPosition(Number x, Number y) {
		return this.setPosition(x.intValue(), y.intValue());
	}
	
	
	/**
	 * Sets the x and y position (corner) of this circle.
	 * @param x the new x position of this circle as a Number
	 * @param y the new y position of this circle as a Number
	 * @return this circle for chaining
	 * */
	public Circlei setPosition(int x, int y) {
		this.cx = x + radius;
		this.cy = y + radius;
		return this;
	}


	@Override
	public Circlei setPosition(IVector2 position) {
		return this.setPosition(position.getIntX(), position.getIntY());
	}


	@Override
	public Circlei setRadius(Number radius) {
		return this.setRadius(radius.intValue());
	}
	
	
	/**
	 * Sets the radius of this circle
	 * @param radius the new radius
	 * @return this circle for chaining
	 * */
	public Circlei setRadius(int radius) {
		this.radius = radius;
		return this;
	}


	@Override
	public Circlei setSize(Number diameter) {
		return this.setSize(diameter.intValue());
	}
	
	
	/**
	 * Sets the size/diameter of this circle
	 * @param diameter the new diameter
	 * @return this circle for chaining
	 * */
	public Circlei setSize(int diameter) {
		this.radius = diameter / 2;
		return this;
	}


	@Override
	public Circlei setMinX(Number minX) {
		return this.setMinX(minX.intValue());
	}
	
	
	/**
	 * Sets the minimal x value of this circle.
	 * @param minX the new minimal x value
	 * @return this circle for chaining
	 * */
	public Circlei setMinX(int minX) {
		return setX(minX);
	}


	@Override
	public Circlei setMinY(Number minY) {
		return this.setMinY(minY.intValue());
	}
	
	
	/**
	 * Sets the minimal y value of this circle.
	 * @param minY the new minimal y value
	 * @return this circle for chaining
	 * */
	public Circlei setMinY(int minY) {
		return setY(minY);
	}


	@Override
	public Circlei setMin(Number minX, Number minY) {
		return this.setMin(minX.intValue(), minY.intValue());
	}
	
	
	/**
	 * Sets the minimal x and y value of this circle.
	 * @param minX the new minimal x value
	 * @param minY the new minimal y value
	 * @return this circle for chaining
	 * */
	public Circlei setMin(int minX, int minY) {
		this.setMinX(minX);
		this.setMinY(minY);
		return this;
	}


	@Override
	public Circlei setMin(IVector2 min) {
		return this.setMin(min.getIntX(), min.getIntY());
	}


	@Override
	public Circlei setMaxX(Number maxX) {
		return this.setMaxX(maxX.intValue());
	}
	
	
	/**
	 * Sets the maximal x value of this circle.
	 * @param maxX the new maximal x value
	 * @return this circle for chaining
	 * */
	public Circlei setMaxX(int maxX) {
		this.cx = maxX - radius;
		return this;
	}


	@Override
	public Circlei setMaxY(Number maxY) {
		return this.setMaxY(maxY.intValue());
	}
	
	
	/**
	 * Sets the maximal y value of this circle.
	 * @param maxY the new maximal y value
	 * @return this circle for chaining
	 * */
	public Circlei setMaxY(int maxY) {
		this.cy = maxY - radius;
		return this;
	}


	@Override
	public Circlei setMax(Number maxX, Number maxY) {
		return this.setMax(maxX.intValue(), maxY.intValue());
	}
	
	
	/**
	 * Sets the maximal x and y value of this circle.
	 * @param maxX the new maximal x value
	 * @param maxY the new maximal y value
	 * @return this circle for chaining
	 * */
	public Circlei setMax(int maxX, int maxY) {
		setMaxX(maxX);
		setMaxY(maxY);
		return this;
	}


	@Override
	public Circlei setMax(IVector2 max) {
		return this.setMax(max.getIntX(), max.getIntY());
	}


	@Override
	public Circlei translate(Number dx, Number dy) {
		return this.translate(dx.intValue(), dy.intValue());
	}
	
	/**
	 * Moves this circle by the given amount.
	 * @param dx the distance in x-direction
	 * @param dy the distance in y-direction
	 * @return this circle for chaining
	 * */
	public Circlei translate(int dx, int dy) {
		this.cx += dx;
		this.cy += dy;
		return this;
	}


	@Override
	public Circlei translate(IVector2 dir) {
		return this.translate(dir.getIntX(), dir.getIntY());
	}


	@Override
	public Circlei scale(Number s) {
		return this.scale(s.intValue());
	}
	
	
	/**
	 * Scales the size of this circle. The position of the corner does not change.
	 * @param sx the scaling in x direction
	 * @param sy the scaling in y direction
	 * @return this circle for chaining
	 * */
	public Circlei scale(int s) {
		final int x = cx - radius;
		final int y = cy - radius;
		this.radius *= s;
		return this.setPosition(x, y);
	}


	@Override
	public Circlei scaleCentered(Number s) {
		return this.scaleCentered(s.intValue());
	}
	
	
	/**
	 * Scales the size of this circle. The position of the center of does not change.
	 * @param sx the scaling in x direction
	 * @param sy the scaling in y direction
	 * @return this circle for chaining
	 * */
	public Circlei scaleCentered(int s) {
		this.radius *= s;
		return this;
	}


	@Override
	public Circlei grow(Number size) {
		return this.grow(size.intValue());
	}
	
	
	/**
	 * Grows the size/diameter of this circle.
	 * @param size the additional size to add to this rectangle
	 * @return this circle for chaining
	 * */
	public Circlei grow(int size) {
		this.radius += size/2f;
		return this;
	}


	@Override
	public Circlei growRadius(Number size) {
		return this.growRadius(size.intValue());
	}
	
	
	/**
	 * Grows the radius of this circle.
	 * @param size the additional size to add to this circle
	 * @return this circle for chaining
	 * */
	public Circlei growRadius(int size) {
		this.radius += size;
		return this;
	}


	@Override
	public Circlei addPoint(Number x, Number y) {
		return this.addPoint(x.intValue(), y.intValue());
	}
	
	
	/**
	 * Adds the given point to the bounds of this circle.
	 * @param x the x position of the point
	 * @param y the y position of the point
	 * @return this circle for chaining
	 * */
	public Circlei addPoint(int x, int y) {
		if(!this.containsPoint(x, y)) {
			this.radius = (int) Math.sqrt( (cx-x)*(cx-x) + (cy-y)*(cy-y) );
		}
		return this;
	}


	@Override
	public Circlei addPoint(IVector2 point) {
		return this.addPoint(point.getIntX(), point.getIntY());
	}


	@Override
	public Circlei removePoint(Number x, Number y) {
		return this.removePoint(x.intValue(), y.intValue());
	}
	
	
	/**
	 * Removes the given point from the bounds of this circle.
	 * @param x the x position of the point
	 * @param y the y position of the point
	 * @return this circle for chaining
	 * */
	public Circlei removePoint(int x, int y) {
		if(this.containsPoint(x, y)) {
			this.radius = (int) Math.sqrt( (cx-x)*(cx-x) + (cy-y)*(cy-y) );
		}
		return this;
	}


	@Override
	public Circlei removePoint(IVector2 point) {
		return this.removePoint(point.getIntX(), point.getIntY());
	}


	@Override
	public boolean containsPoint(Number x, Number y) {
		return this.containsPoint(x.intValue(), y.intValue());
	}
	
	
	/**
	 * Checks whether the given point is inside this circle.
	 * @param x the x position of the point
	 * @param y the y position of the point
	 * @return true, if the point is inside this circle
	 * */
	public boolean containsPoint(int x, int y) {
		return ((cx-x)*(cx-x) + (cy-y)*(cy-y)) <= radius;
	}


	@Override
	public boolean containsPoint(IVector2 point) {
		return this.containsPoint(point.getIntX(), point.getIntY());
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
	public int getArea() {
		return (int) (Math.PI * radius*radius) ;
	}


	@Override
	public Number getCircumferenceGen() {
		return getCircumference();
	}
	
	
	/**
	 * @return the circumference of this circle
	 * */
	public int getCircumference() {
		return (int) (Math.PI * 2*radius);
	}

	
	

	@Override
	public Circlei setName(String name) {
		this.name = name;
		return this;
	}

	
	

	@Override
	public String getName() {
		return this.name;
	}
	
	
	
}

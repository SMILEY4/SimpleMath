package com.ruegnerlukas.simplemath.geometry.shapes.rectangle;

import com.ruegnerlukas.simplemath.geometry.Intersector;
import com.ruegnerlukas.simplemath.geometry.IntersectorInt;
import com.ruegnerlukas.simplemath.geometry.shapes.IShape;
import com.ruegnerlukas.simplemath.geometry.shapes.circle.Circlei;
import com.ruegnerlukas.simplemath.geometry.shapes.circle.ICircle;
import com.ruegnerlukas.simplemath.geometry.shapes.line.ILine;
import com.ruegnerlukas.simplemath.geometry.shapes.polygon.IPolygon;
import com.ruegnerlukas.simplemath.geometry.shapes.polygon.Polygonf;
import com.ruegnerlukas.simplemath.vectors.vec2.IVector2;
import com.ruegnerlukas.simplemath.vectors.vec2.Vector2f;
import com.ruegnerlukas.simplemath.vectors.vec4.IVector4;
import com.ruegnerlukas.simplemath.vectors.vec4.Vector4f;


public class Rectanglei implements IRectangle {

	
	
	
	/**
	 * Creates a new Rectangle
	 * @param min the position of the bottom left corner
	 * @param max the position of the top right corner
	 * @return the created Rectangle
	 * */
	public static Rectanglei createRectangleMinMax(IVector2 min, IVector2 max) {
		return Rectanglei.createRectangleMinMax(min.getIntX(), min.getIntY(), max.getIntX(), max.getIntY());
	}
	
	
	/**
	 * Creates a new Rectangle
	 * @param minX the minimum x-value (bottom left corner)
	 * @param minY the minimum y-value (bottom left corner)
	 * @param maxX the maximum x-value (top right corner)
	 * @param maxY the maximum y-value (top right corner)
	 * @return the created Rectangle
	 * */
	public static Rectanglei createRectangleMinMax(int minX, int minY, int maxX, int maxY) {
		if(minX > maxX || minY>maxY) {
			return Rectanglei.createRectangleMinMax(Math.min(minX, maxX), Math.min(minY, maxY), Math.max(minX, maxX), Math.max(minY, maxY));
		} else {
			return new Rectanglei(minX, minY, maxX-minX, maxY-minY);
		}
	}


	
	
	
	
	
	
	public int x;
	public int y;
	public int width;
	public int height;
	
	public String name;
	
	
	
	
	
	
	/**
	 * Creates a rectangle at (0,0) and size 0
	 * */
	public Rectanglei() {
		this(0, 0, 0, 0);
	}	
	
	/**
	 * Creates a rectangle with the same position and size as the given rectangle.
	 * */
	public Rectanglei(IRectangle rect) {
		this(rect.getXInt(), rect.getYInt(), rect.getWidthInt(), rect.getHeightInt());
	}
	

	/**
	 * Creates a rectangle with the x-position, y-position, width and height specified by the given vector.
	 * */
	public Rectanglei(IVector4 rect) {
		this(rect.getIntX(), rect.getIntY(), rect.getIntZ(), rect.getIntW());
	}
	
	
	/**
	 * Creates a rectangle with the width and height specified by the given vector.
	 * */
	public Rectanglei(IVector2 size) {
		this(size.getIntX(), size.getIntY());
	}
	
	
	/**
	 * Creates a rectangle with the given width and height
	 * */
	public Rectanglei(int width, int height) {
		this(0, 0, width, height);
	}
	
	
	/**
	 * Creates a rectangle with the x-position, y-position, width and height specified by the given vectors.
	 * */
	public Rectanglei(IVector2 pos, IVector2 size) {
		this(pos.getIntX(), pos.getIntY(), size.getIntX(), size.getIntY());
	}
	
	
	/**
	 * Creates a rectangle with the given location and size
	 * */
	public Rectanglei(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	
	
	
	
	
	
	
	@Override
	public int getMinXInt() {
		if(this.width < 0) {
			return (int) (this.x + this.width);
		} else {
			return (int) this.x;
		}
	}




	@Override
	public float getMinXFloat() {
		if(this.width < 0) {
			return (float) (this.x + this.width);
		} else {
			return (float) this.x;
		}	
	}




	@Override
	public double getMinXDouble() {
		if(this.width < 0) {
			return (double) (this.x + this.width);
		} else {
			return (double) this.x;
		}	
	}




	@Override
	public int getMinYInt() {
		if(this.height < 0) {
			return (int) (this.y + this.height);
		} else {
			return (int) this.y;
		}	
	}




	@Override
	public float getMinYFloat() {
		if(this.height < 0) {
			return (float) (this.y + this.height);
		} else {
			return (float) this.y;
		}	
	}




	@Override
	public double getMinYDouble() {
		if(this.height < 0) {
			return (double) (this.y + this.height);
		} else {
			return (double) this.y;
		}	
	}




	@Override
	public int getMaxXInt() {
		if(this.width < 0) {
			return (int) this.x;
		} else {
			return (int) (this.x + this.width);
		}	
	}




	@Override
	public float getMaxXFloat() {
		if(this.width < 0) {
			return (float) this.x;
		} else {
			return (float) (this.x + this.width);
		}	
	}




	@Override
	public double getMaxXDouble() {
		if(this.width < 0) {
			return (double) this.x;
		} else {
			return (double) (this.x + this.width);
		}	
	}




	@Override
	public int getMaxYInt() {
		if(this.height < 0) {
			return (int) this.y;
		} else {
			return (int) (this.y + this.height);
		}	
	}




	@Override
	public float getMaxYFloat() {
		if(this.height < 0) {
			return (float) this.y;
		} else {
			return (float) (this.y + this.height);
		}	
	}




	@Override
	public double getMaxYDouble() {
		if(this.height < 0) {
			return (double) this.y;
		} else {
			return (double) (this.y + this.height);
		}	
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
		return getBounds(new Rectanglei());
	}




	@Override
	public IRectangle getBounds(IRectangle dest) {
		if(dest == null) {
			dest = new Rectanglei();
		}
		return dest.setMin(getMinXFloat(), getMinYFloat()).setSize(Math.abs(width), Math.abs(height));
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
		return dest.set(getMinXFloat(), getMinYFloat(), Math.abs(width), Math.abs(height));
	}




	@Override
	public int getRadiusInt() {
		return (int) (Math.sqrt(width*width + height*height) / 2f);
	}




	@Override
	public float getRadiusFloat() {
		return (float) (Math.sqrt(width*width + height*height) / 2f);

	}




	@Override
	public double getRadiusDouble() {
		return (double) (Math.sqrt(width*width + height*height) / 2f);

	}




	@Override
	public boolean intersects(IShape other) {
		
		if(other instanceof IRectangle) {
			IRectangle rect = (IRectangle) other;
			return IntersectorInt.intersectsRectangleRectangle(this.x, this.y, this.width, this.height,
					rect.getXInt(), rect.getYInt(), rect.getWidthInt(), rect.getHeightInt());
		
		} else if(other instanceof ICircle) {
			ICircle circle = (ICircle) other;
			return IntersectorInt.intersectsRectangleCircle(this.x, this.y, this.width, this.height,
					circle.getCenterXInt(), circle.getCenterYInt(), circle.getRadiusInt());
			
		} else if(other instanceof ILine) {
			ILine line = (ILine) other;
			return IntersectorInt.intersectsRectangleLine(this.x, this.y, this.width, this.height,
					line.getStartXInt(), line.getStartYInt(), line.getEndXInt(), line.getEndYInt(), null);
			
		} else if(other instanceof Polygonf) {
			Polygonf poly = (Polygonf) other;
			return Intersector.intersectsRectanglePolygon(x, y, width, height, poly.getVertices(), null);
			
		} else if(other instanceof IPolygon) {
			IPolygon poly = (IPolygon) other;
			int[] polyVert = new int[poly.getVerticesGen().length];
			for(int i=0, n=polyVert.length; i<n; i++) {
				polyVert[i] = poly.getVerticesGen()[i].intValue();
			}
			return IntersectorInt.intersectsRectanglePolygon(x, y, width, height, polyVert, null);
			
		} else {
			// TODO other shapes
		}
		return false;
	}




	@Override
	public Rectanglei copy() {
		return new Rectanglei(this);
	}
	
	
	
	
	@Override
	public String toString() {
		return name + ": Rectanglei." + this.hashCode() + "(" + this.x + ", " + this.y + ", " + this.width + ", " + this.height + ")";
	}




	@Override
	public int getXInt() {
		return (int) this.x;
	}




	@Override
	public int getYInt() {
		return (int) this.y;
	}




	@Override
	public int getWidthInt() {
		return (int) this.width;
	}




	@Override
	public int getHeightInt() {
		return (int) this.height;
	}




	@Override
	public float getXFloat() {
		return (float) this.x;
	}




	@Override
	public float getYFloat() {
		return (float) this.y;
	}




	@Override
	public float getWidthFloat() {
		return (float) this.width;
	}




	@Override
	public float getHeightFloat() {
		return (float) this.height;
	}




	@Override
	public double getXDouble() {
		return (double) this.x;
	}




	@Override
	public double getYDouble() {
		return (double) this.y;
	}




	@Override
	public double getWidthDouble() {
		return (double) this.width;
	}




	@Override
	public double getHeightDouble() {
		return (double) this.height;
	}




	@Override
	public Number getCenterXGen() {
		return this.getCenterX();
	}

	
	
	
	/**
	 * @return the x position of the center of this rectangle
	 * */
	public int getCenterX() {
		return x + width/2;
	}




	@Override
	public Number getCenterYGen() {
		return this.getCenterY();
	}
	
	
	
	
	/**
	 * @return the y position of the center of this rectangle
	 * */
	public int getCenterY() {
		return y + height/2;
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
		return dest.set((Integer)getCenterX(), (Integer)getCenterY());
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
	public IVector2 getSize() {
		return getSize(new Vector2f());
	}




	@Override
	public IVector2 getSize(IVector2 dest) {
		if(dest == null) {
			dest = new Vector2f();
		}
		return dest.set(getWidthFloat(), getHeightFloat());
	}




	@Override
	public Rectanglei set(IRectangle rectangle) {
		return set(rectangle.getXFloat(), rectangle.getYFloat(), rectangle.getWidthFloat(), rectangle.getHeightFloat());
	}
	
	
	
	
	@Override
	public Rectanglei set(Number x, Number y, Number width, Number height) {
		return set(x.intValue(), y.intValue(), width.intValue(), height.intValue());
	}

	
	
	
	/**
	 * Sets the position and the size of this rectangle
	 * @param x the new x position of this rectangle
	 * @param y the new y position of this rectangle
	 * @param width the new width of this rectangle
	 * @param height the new height of this rectangle
	 * @return this rectangle for chaining
	 * */
	public Rectanglei set(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		return this;
	}



	@Override
	public Rectanglei setX(Number x) {
		return setX(x.intValue());
	}
	
	
	
	
	/**
	 * Sets the x-position of this rectangle
	 * @param x the new x-position
	 * @return this rectangle for chaining
	 * */
	public Rectanglei setX(int x) {
		this.x = x;
		return this;
	}




	@Override
	public Rectanglei setY(Number y) {
		return setY(y.intValue());
	}
	
	
	
	
	/**
	 * Sets the y-position of this rectangle
	 * @param y the new y-position
	 * @return this rectangle for chaining
	 * */
	public Rectanglei setY(int y) {
		this.y = y;
		return this;
	}
	
	
	
	
	@Override
	public Rectanglei setPosition(Number x, Number y) {
		return setPosition(x.intValue(), y.intValue());
	}
	
	
	
	
	/**
	 * Sets the x and y position of this rectangle.
	 * @param x the new x position of this rectangle
	 * @param y the new y position of this rectangle
	 * @return this rectangle for chaining
	 * */
	public Rectanglei setPosition(int x, int y) {
		this.x = x;
		this.y = y;
		return this;
	}




	@Override
	public Rectanglei setPosition(IVector2 position) {
		return this.setPosition(position.getFloatX(), position.getFloatY());
	}




	@Override
	public Rectanglei setCenter(Number cx, Number cy) {
		return this.setCenter(cx.intValue(), cy.intValue());
	}
	
	
	
	
	/**
	 * Sets the position of the center point of this rectangle.
	 * @param cx the new x position of the center
	 * @param cy the new y position of the center
	 * @return this rectangle for chaining
	 * */
	public Rectanglei setCenter(int cx, int cy) {
		this.x = cx - (width/2);
		this.y = cy - (height/2);
		return this;
	}




	@Override
	public Rectanglei setCenter(IVector2 center) {
		return this.setCenter(center.getFloatX(), center.getFloatY());
	}




	@Override
	public Rectanglei setWidth(Number width) {
		return setWidth(width.intValue());
	}
	
	
	
	
	/**
	 * Sets the width of this rectangle
	 * @param width the new width
	 * @return this rectangle for chaining
	 * */
	public Rectanglei setWidth(int width) {
		this.width = width;
		return this;
	}


	

	@Override
	public Rectanglei setHeight(Number height) {
		return setHeight(height.intValue());
	}



	
	/**
	 * Sets the height of this rectangle
	 * @param height the new height
	 * @return this rectangle for chaining
	 * */
	public Rectanglei setHeight(int height) {
		this.height = height;
		return this;
	}




	@Override
	public Rectanglei setSize(Number width, Number height) {
		return setSize(width.intValue(), height.intValue());
	}
	
	
	
	
	/**
	 * Sets the width and height of this rectangle.
	 * @param width the new width of this rectangle
	 * @param height the new height of this rectangle
	 * @return this rectangle for chaining
	 * */
	public Rectanglei setSize(int width, int height) {
		this.width = width;
		this.height = height;
		return this;
	}
	
	
	
	
	@Override
	public Rectanglei set(IVector2 position, IVector2 size) {
		return set(position.getFloatX(), position.getFloatY(), size.getFloatX(), size.getFloatY());
	}




	@Override
	public Rectanglei setMinX(Number minX) {
		return setMinX(minX.intValue());
	}
	
	
	
	
	/**
	 * Sets the minimal x value of this rectangle.
	 * @param minX the new minimal x value
	 * @return this rectangle for chaining
	 * */
	public Rectanglei setMinX(int minX) {
		final int w = (x - minX) + width;
		this.x = minX;
		this.width = w;
		return this;
	}




	@Override
	public Rectanglei setMinY(Number minY) {
		return setMinY(minY.intValue());
	}
	
	
	
	
	/**
	 * Sets the minimal y value of this rectangle.
	 * @param minX the new minimal y value
	 * @return this rectangle for chaining
	 * */
	public Rectanglei setMinY(int minY) {
		int h = (y - minY) + height;
		this.y = minY;
		this.height = h;
		return this;
	}




	@Override
	public Rectanglei setMin(Number minX, Number minY) {
		return setMin(minX.intValue(), minY.intValue());
	}

	
	
	
	/**
	 * Sets the minimal x and y value of this rectangle.
	 * @param minX the new minimal x value
	 * @param minY the new minimal y value
	 * @return this rectangle for chaining
	 * */
	public Rectanglei setMin(int minX, int minY) {
		setMinX(minX);
		setMinY(minY);
		return this;
	}


	

	@Override
	public Rectanglei setMin(IVector2 min) {
		return setMin(min.getFloatX(), min.getFloatY());
	}
	
	
	
	
	@Override
	public Rectanglei setMaxX(Number maxX) {
		return setMaxX(maxX.intValue());
	}
	
	
	
	
	/**
	 * Sets the maximal x value of this rectangle.
	 * @param maxX the new maximal x value
	 * @return this rectangle for chaining
	 * */
	public Rectanglei setMaxX(int maxX) {
		this.width = maxX - x;
		return this;
	}




	@Override
	public Rectanglei setMaxY(Number maxY) {
		return setMaxY(maxY.intValue());
	}
	
	
	
	
	/**
	 * Sets the maximal y value of this rectangle.
	 * @param maxY the new maximal y value
	 * @return this rectangle for chaining
	 * */
	public Rectanglei setMaxY(int maxY) {
		this.height = maxY - y;
		return this;
	}




	@Override
	public Rectanglei setMax(Number maxX, Number maxY) {
		return null;
	}
	
	
	
	
	/**
	 * Sets the maximal x and y value of this rectangle.
	 * @param maxX the new maximal x value
	 * @param maxY the new maximal y value
	 * @return this rectangle for chaining
	 * */
	public Rectanglei setMax(int maxX, int maxY) {
		setMaxX(maxX);
		setMaxY(maxY);
		return this;
	}




	@Override
	public Rectanglei setMax(IVector2 max) {
		return this.setMax(max.getFloatX(), max.getFloatY());
	}




	@Override
	public Rectanglei setSize(IVector2 size) {
		return this.setSize(size.getFloatX(), size.getFloatY());
	}




	@Override
	public Rectanglei translate(Number dx, Number dy) {
		return this.translate(dx.intValue(), dy.intValue());
	}

	
	
	
	/**
	 * Moves this rectangle by the given amount.
	 * @param dx the distance in x-direction
	 * @param dy the distance in y-direction
	 * @return this rectangle for chaining
	 * */
	public Rectanglei translate(int dx, int dy) {
		this.x += dx;
		this.y += dy;
		return this;
	}


	

	@Override
	public Rectanglei translate(IVector2 dir) {
		return this.translate(dir.getFloatX(), dir.getFloatY());
	}




	@Override
	public Rectanglei scale(Number sx, Number sy) {
		return this.scale(sx.intValue(), sy.intValue());
	}
	
	
	
	
	/**
	 * Scales the width and height of this rectangle. The position does not change.
	 * @param sx the scaling in x direction
	 * @param sy the scaling in y direction
	 * @return this rectangle for chaining
	 * */
	public Rectanglei scale(int sx, int sy) {
		this.width *= sx;
		this.height *= sy;
		return this;
	}




	@Override
	public Rectanglei scale(IVector2 scaling) {
		return this.scale(scaling.getFloatX(), scaling.getFloatY());
	}




	@Override
	public Rectanglei scaleCentered(Number sx, Number sy) {
		return null;
	}


	
	
	/**
	 * Scales the width and height of this rectangle. The position of the center of does not change.
	 * @param sx the scaling in x direction
	 * @param sy the scaling in y direction
	 * @return this rectangle for chaining
	 * */
	public Rectanglei scaleCentered(int sx, int sy) {
		final int lastWidth = this.width;
		final int lastHeight = this.height;
		this.width *= sx;
		this.height *= sy;
		final int dx = lastWidth - this.width;
		final int dy = lastHeight - this.height;
		this.x += dx / 2f;
		this.y += dy / 2f;
		return this;
	}




	@Override
	public Rectanglei scaleCentered(IVector2 scaling) {
		return this.scaleCentered(scaling.getFloatX(), scaling.getFloatY());
	}




	@Override
	public Rectanglei grow(Number width, Number height) {
		return this.grow(width.intValue(), height.intValue());
	}
	
	
	
	
	/**
	 * Grows the with and height of this rectangle.
	 * @param width the additional width to add to this rectangle
	 * @param height the additional height to add to this rectangle
	 * @return this rectangle for chaining
	 * */
	public Rectanglei grow(int width, int height) {
		this.width += width;
		this.height += height;
		return this;
	}




	@Override
	public Rectanglei grow(IVector2 size) {
		return this.grow(size.getFloatX(), size.getFloatY());
	}




	@Override
	public Rectanglei addPoint(Number x, Number y) {
		return this.addPoint(x.intValue(), y.intValue());
	}
	
	
	
	
	/**
	 * Adds the given point to the bounds of this rectangle.
	 * @param x the x position of the point
	 * @param y the y position of the point
	 * @return this rectangle for chaining
	 * */
	public Rectanglei addPoint(int x, int y) {
		if(x < getMinXFloat()) {
			setMinX(x);
		} else if(x > getMaxXFloat()) {
			setMaxX(x);
		}
		if(y < getMinYFloat()) {
			setMinY(y);
		} else if(y > getMaxYFloat()) {
			setMaxY(y);
		}
		return this;
	}




	@Override
	public Rectanglei addPoint(IVector2 point) {
		return this.addPoint(point.getFloatX(), point.getFloatY());
	}




	@Override
	public IRectangle removePoint(Number x, Number y, boolean centered) {
		return this.removePoint(x.intValue(), y.intValue(), centered);
	}

	
	
	
	/**
	 * Removes the given point from the bounds of this rectangle.
	 * @param x the x position of the point
	 * @param y the y position of the point
	 * @param centered whether or not this rectangle should shrink in the direction of its center
	 * @return this rectangle for chaining
	 * */
	public IRectangle removePoint(int x, int y, boolean centered) {
		if(containsPoint(x, y)) {
			if(centered) {
				final int cx = getCenterX();
				final int cy = getCenterY();
				final int dx = (x - cx);
				final int dy = (y - cy);
				this.width = Math.abs(dx)*2;
				this.height = Math.abs(dy)*2;
				this.setCenter(cx, cy);
			} else {
				this.setMax(x, y);
			}
		}
		return this;
	}
	
	
	

	@Override
	public IRectangle removePoint(IVector2 point, boolean centered) {
		return this.removePoint(point.getFloatX(), point.getFloatY(), centered);
	}
	
	
	
	
	@Override
	public boolean containsPoint(Number x, Number y) {
		return this.containsPoint(x.intValue(), y.intValue());
	}
	
	
	
	
	/**
	 * Checks whether the given point is inside this rectangle.
	 * @param x the x position of the point
	 * @param y the y position of the point
	 * @return true, if the point is inside this rectangle
	 * */
	public boolean containsPoint(int x, int y) {
		return (getMinXFloat() <= x && x <= getMaxXFloat()) && (getMinYFloat() <= y && y <= getMaxYFloat());
	}




	@Override
	public boolean containsPoint(IVector2 point) {
		return this.containsPoint(point.getFloatX(), point.getFloatY());
	}




	@Override
	public boolean containsRectangle(IVector2 pos, IVector2 size) {
		return this.containsRectangle(pos.getFloatX(), pos.getFloatY(), size.getFloatX(), size.getFloatY());
	}




	@Override
	public boolean containsRectangle(Number x, Number y, Number width, Number height) {
		return this.containsRectangle(x.intValue(), y.intValue(), width.intValue(), height.intValue());
	}
	
	
	
	
	/**
	 * Checks whether the given rectangle is completely inside this rectangle.
	 * @param x the x position of the rectangle
	 * @param y the y position of the rectangle
	 * @param width the with of the rectangle
	 * @param height the height of this rectangle
	 * @return true, if the rectangle is inside this rectangle
	 * */
	public boolean containsRectangle(int x, int y, int width, int height) {
		return containsPoint(x, y) && containsPoint(x+width, y+height);
	}




	@Override
	public boolean containsRectangle(IRectangle rect) {
		return this.containsRectangle(rect.getXFloat(), rect.getYFloat(), rect.getWidthFloat(), rect.getHeightFloat());
	}




	@Override
	public boolean containsShape(IShape shape) {
		if(shape instanceof IRectangle) {
			return containsRectangle((IRectangle)shape);
		} else {
			return containsRectangle(shape.getMinXFloat(), shape.getMinYFloat(), shape.getMaxXFloat()-shape.getMinXFloat(), shape.getMaxYFloat()-shape.getMinYFloat());
			// TODO: other shapes
		}
	}

	
	
	
	@Override
	public IRectangle getOverlap(IVector2 pos, IVector2 size, IRectangle dest) {
		return this.getOverlap(pos.getFloatX(), pos.getFloatY(), size.getFloatX(), size.getFloatY(), dest);
	}




	@Override
	public IRectangle getOverlap(Number x, Number y, Number width, Number height, IRectangle dest) {
		return this.getOverlap(x.intValue(), y.intValue(), width.intValue(), height.intValue(), dest);
	}
	
	
	
	
	/**
	 * Calculates the overlapping area of an intersection between this rectangle and another rectangle.
	 * @param x the x position of the rectangle
	 * @param y the y position of the rectangle
	 * @param width the width of the rectangle
	 * @param height the height of the rectangle
	 * @param dest the destination or null
	 * @return the overlapping area as a rectangle or null, if they dont overlap
	 * */
	public IRectangle getOverlap(int x, int y, int width, int height, IRectangle dest) {
		if(!Intersector.intersectsRectangleRectangle(this.x, this.y, this.width, this.height, x, y, width, height)) {
			return null;
		}
		int minX = Math.max(this.getXInt(), x);
		int minY = Math.max(this.getYInt(), y);
		int maxX = Math.min(this.getMaxXInt(), x+width);
		int maxY = Math.min(this.getMaxYInt(), y+height);
		if(dest == null) {
			return Rectanglei.createRectangleMinMax(minX, minY, maxX, maxY);
		} else {
			return dest.setMin(minX, minY).setMax(maxX, maxY);
		}
	}




	@Override
	public IRectangle getOverlap(IRectangle other, IRectangle dest) {
		return this.getOverlap(other.getXFloat(), other.getYFloat(), other.getWidthFloat(), other.getHeightFloat(), dest);
	}




	@Override
	public Number getAreaGen() {
		return getArea();
	}
	
	
	/**
	 * @return the area of this rectangle as a Number
	 * */
	public int getArea() {
		return Math.abs(this.width) * Math.abs(this.height);
	}
	
	


	@Override
	public Number getCircumferenceGen() {
		return getCircumference();
	}
	
	
	/**
	 * @return the circumference of this rectangle as a Number
	 * */
	public int getCircumference() {
		return Math.abs(this.width)*2 + Math.abs(this.height)*2;
	}
	
	
	
	
	@Override
	public Rectanglei normalize() {
		if(width < 0) {
			width = width * -1;
			x -= width;
		}
		if(height < 0) {
			height = height * -1;
			y -= height;
		}
		return this;
	}
	
	
	
	
	@Override
	public Rectanglei setName(String name) {
		this.name = name;
		return this;
	}

	
	

	@Override
	public String getName() {
		return this.name;
	}

	
}

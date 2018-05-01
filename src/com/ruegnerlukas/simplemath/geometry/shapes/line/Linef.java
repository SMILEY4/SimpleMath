package com.ruegnerlukas.simplemath.geometry.shapes.line;

import com.ruegnerlukas.simplemath.geometry.Intersector;
import com.ruegnerlukas.simplemath.geometry.shapes.IShape;
import com.ruegnerlukas.simplemath.geometry.shapes.circle.ICircle;
import com.ruegnerlukas.simplemath.geometry.shapes.polygon.IPolygon;
import com.ruegnerlukas.simplemath.geometry.shapes.polygon.Polygonf;
import com.ruegnerlukas.simplemath.geometry.shapes.rectangle.IRectangle;
import com.ruegnerlukas.simplemath.geometry.shapes.rectangle.Rectanglef;
import com.ruegnerlukas.simplemath.vectors.vec2.IVector2;
import com.ruegnerlukas.simplemath.vectors.vec2.Vector2f;
import com.ruegnerlukas.simplemath.vectors.vec4.IVector4;
import com.ruegnerlukas.simplemath.vectors.vec4.Vector4f;

public class Linef implements ILine {
	
	
	
	
	public float x0;
	public float y0;
	public float x1;
	public float y1;
	
	public String name;
	
	
	
	
	
	public Linef() {
		this(0,0,0,0);
	}
	
	
	public Linef(Linef line) {
		this(line.getStartXFloat(), line.getStartYFloat(), line.getEndXFloat(), line.getEndYFloat());
	}

	
	public Linef(IVector2 start, IVector2 end) {
		this(start.getFloatX(), start.getFloatY(), end.getFloatX(), end.getFloatY());
	}
	
	
	public Linef(float x0, float y0, float x1, float y1) {
		this.x0 = x0;
		this.y0 = y0;
		this.x1 = x1;
		this.y1 = y1;
	}
	
	
	
	
	
	
	@Override
	public int getMinXInt() {
		return (int) Math.min(x0, x1);
	}

	
	
	
	@Override
	public float getMinXFloat() {
		return (float) Math.min(x0, x1);
	}

	
	
	
	@Override
	public double getMinXDouble() {
		return (double) Math.min(x0, x1);
	}

	
	
	
	@Override
	public int getMinYInt() {
		return (int) Math.min(y0, y1);
	}

	
	
	
	@Override
	public float getMinYFloat() {
		return (float) Math.min(y0, y1);
	}

	
	
	
	@Override
	public double getMinYDouble() {
		return (double) Math.min(y0, y1);
	}
	
	
	

	@Override
	public int getMaxXInt() {
		return (int) Math.max(x0, x1);
	}

	
	
	
	@Override
	public float getMaxXFloat() {
		return (float) Math.max(x0, x1);
	}
	
	
	

	@Override
	public double getMaxXDouble() {
		return (double) Math.max(x0, x1);
	}

	
	
	
	@Override
	public int getMaxYInt() {
		return (int) Math.max(y0, y1);
	}

	
	
	
	@Override
	public float getMaxYFloat() {
		return (float) Math.max(y0, y1);
	}

	
	
	
	@Override
	public double getMaxYDouble() {
		return (double) Math.max(y0, y1);
	}

	
	
	
	@Override
	public IVector2 getMin() {
		return getMin(null);
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
		return getMax(null);
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
		return getBounds(null);
	}
	
	
	

	@Override
	public IRectangle getBounds(IRectangle dest) {
		if(dest == null) {
			dest = new Rectanglef();
		}
		return dest.setMin(getMinXFloat(), getMinYFloat()).setMax(getMaxXFloat(), getMaxYFloat());
	}

	
	
	
	@Override
	public IVector4 getBoundsVec() {
		return getBoundsVec(null);
	}
	
	
	

	@Override
	public IVector4 getBoundsVec(IVector4 dest) {
		if(dest == null) {
			dest = new Vector4f();
		}
		return dest.set(getMinXFloat(), getMinYFloat(), getMaxXFloat(), getMaxYFloat());
	}

	
	
	
	@Override
	public int getRadiusInt() {
		return (int) (getLength()/2);
	}
	
	
	

	@Override
	public float getRadiusFloat() {
		return (float) (getLength()/2);
	}

	
	
	
	@Override
	public double getRadiusDouble() {
		return (double) (getLength()/2);
	}
	
	
	

	@Override
	public boolean intersects(IShape other) {
		if(other instanceof IRectangle) {
			IRectangle rect = (IRectangle) other;
			return Intersector.intersectsRectangleLine(rect.getXFloat(), rect.getYFloat(), rect.getWidthFloat(), rect.getHeightFloat(),
					this.x0, this.y0, this.x1, this.y1, null);
		
		} else if(other instanceof ICircle) {
			ICircle circle = (ICircle) other;
			return Intersector.intersectsCircleLine(circle.getCenterXFloat(), circle.getCenterYFloat(), circle.getRadiusFloat(),
					this.x0, this.y0, this.x1, this.y1);
			
		} else if(other instanceof ILine) {
			ILine line = (ILine) other;
			return Intersector.intersectsLineLine(line.getStartXFloat(), line.getStartYFloat(), line.getEndXFloat(), line.getEndYFloat(),
					this.x0, this.y0, this.x1, this.y1, null);
			
		} else if(other instanceof Polygonf) {
			Polygonf poly = (Polygonf) other;
			return Intersector.intersectsLinePolygon(x0, y0, x1, y1, poly.getVertices());
			
		} else if(other instanceof IPolygon) {
			IPolygon poly = (IPolygon) other;
			float[] polyVert = new float[poly.getVerticesGen().length];
			for(int i=0, n=polyVert.length; i<n; i++) {
				polyVert[i] = poly.getVerticesGen()[i].floatValue();
			}
			return Intersector.intersectsLinePolygon(x0, y0, x1, y1, polyVert);
			
		} else {
			// TODO other shapes
		}
		return false;
	}
	
	
	

	@Override
	public Linef copy() {
		return new Linef(this);
	}
	
	
	
	
	@Override
	public String toString() {
		return (name!=null?name+": ":"") + "Linef." + this.hashCode() + "(" + this.x0 + ", " + this.y0 + ", " + this.x1 + ", " + this.y1 + ")";
	}
	
	
	

	@Override
	public int getStartXInt() {
		return (int) x0;
	}
	
	
	
	
	@Override
	public int getStartYInt() {
		return (int) y0;
	}

	
	
	
	@Override
	public int getEndXInt() {
		return (int) x1;
	}

	
	
	
	@Override
	public int getEndYInt() {
		return (int) y1;
	}
	
	
	

	@Override
	public int getCenterXInt() {
		return (int) (x0 + (x1-y0)/2);
	}
	
	
	
	
	@Override
	public int getCenterYInt() {
		return (int) (y0 + (y1-y0)/2);
	}
	
	
	
	
	@Override
	public float getStartXFloat() {
		return (float) x0;
	}

	
	
	
	@Override
	public float getStartYFloat() {
		return (float) y0;
	}

	
	
	
	@Override
	public float getEndXFloat() {
		return (float) x1;
	}

	
	
	
	@Override
	public float getEndYFloat() {
		return (float) y1;
	}
	
	
	

	@Override
	public float getCenterXFloat() {
		return (float) (x0 + (x1-y0)/2);
	}
	
	
	
	
	@Override
	public float getCenterYFloat() {
		return (float) (y0 + (y1-y0)/2);
	}
	
	
	
	
	@Override
	public double getStartXDouble() {
		return (double) x0;
	}
	
	
	

	@Override
	public double getStartYDouble() {
		return (double) y0;
	}

	
	
	
	@Override
	public double getEndXDouble() {
		return (double) x1;
	}

	
	
	
	@Override
	public double getEndYDouble() {
		return (double) y1;
	}

	
	
	
	@Override
	public double getCenterXDouble() {
		return (double) (x0 + (x1-y0)/2);
	}
	
	
	
	
	@Override
	public double getCenterYDouble() {
		return (double) (y0 + (y1-y0)/2);
	}
	
	
	
	
	@Override
	public IVector2 getStart() {
		return getStart(null);
	}
	
	
	

	@Override
	public IVector2 getStart(IVector2 dest) {
		if(dest == null) {
			dest = new Vector2f();
		}
		return dest.set(getStartXFloat(), getStartYFloat());
	}

	
	
	
	@Override
	public IVector2 getEnd() {
		return getEnd(null);
	}

	
	
	
	@Override
	public IVector2 getEnd(IVector2 dest) {
		if(dest == null) {
			dest = new Vector2f();
		}
		return dest.set(getEndXFloat(), getEndYFloat());
	}

	
	
	
	@Override
	public IVector2 getCenter() {
		return getEnd(null);
	}

	
	
	
	@Override
	public IVector2 getCenter(IVector2 dest) {
		if(dest == null) {
			dest = new Vector2f();
		}
		return dest.set(getCenterXFloat(), getCenterYFloat());
	}
	
	
	
	
	public Number getLength2Gen() {
		return getLength2();
	}
	
	
	
	
	/**
	 * @return the squared distance between the start and end point
	 * */
	public float getLength2() {
		return (x1-x0)*(x1-x0) + (y1-y0)*(y1-y0);
	}
	
	
	
	
	@Override
	public Number getLengthGen() {
		return getLength();
	}
	
	
	/**
	 * @return the distance between the start and end point
	 * */
	public float getLength() {
		return (float) Math.sqrt(getLength2());
	}

	
	
	
	@Override
	public IVector2 getNormal() {
		return getNormal(null);
	}

	
	
	
	@Override
	public IVector2 getNormal(IVector2 dest) {
		if(dest == null) {
			dest = new Vector2f();
		}
		return dest.set(x1, y1).sub(x0, y0);
	}

	
	
	
	@Override
	public Linef set(ILine line) {
		return this.set(line.getStartXFloat(), line.getStartYFloat(), line.getEndXFloat(), line.getEndYFloat());
	}

	
	
	
	@Override
	public Linef set(Number x0, Number y0, Number x1, Number y1) {
		return this.set(x0.floatValue(), y0.floatValue(), x1.floatValue(), y1.floatValue());
	}
	
	
	/**
	 * Sets the start and end position of this line
	 * @param x0 the new x position of the start of this line
	 * @param y0 the new y position of the start of this line
	 * @param x1 the new x position of the end of this line
	 * @param y1 the new y position of the end of this line
	 * @return this line for chaining
	 * */
	public Linef set(float x0, float y0, float x1, float y1) {
		this.x0 = x0;
		this.y0 = y0;
		this.x1 = x1;
		this.y1 = y1;
		return this;
	}
	
	

	@Override
	public Linef setStart(Number x, Number y) {
		return this.setStart(x.floatValue(), y.floatValue());
	}
	
	
	
	
	/**
	 * Sets the start position of this line
	 * @param x the new x position of the start of this line
	 * @param y the new y position of the start of this line
	 * @return this line for chaining
	 * */
	public Linef setStart(float x, float y) {
		this.x0 = x;
		this.y0 = y;
		return this;
	}
	
	

	@Override
	public Linef setEnd(Number x, Number y) {
		return this.setEnd(x.floatValue(), y.floatValue());
	}

	
	
	
	/**
	 * Sets the end position of this line
	 * @param x the new x position of the end of this line
	 * @param y the new y position of the end of this line
	 * @return this line for chaining
	 * */
	public Linef setEnd(float x, float y) {
		this.x1 = x;
		this.y1 = y;
		return this;
	}
	
	
	
	
	@Override
	public Linef setStartX(Number x) {
		return setStartX(x.floatValue());
	}

	
	
	
	/*
	 * Sets the start position of this line
	 * @param x the new x position of the start of this line
	 * @return this line for chaining
	 * */
	public Linef setStartX(float x) {
		this.x0 = x;
		return this;
	}
	
	
	
	
	
	
	
	@Override
	public Linef setStartY(Number y) {
		return setStartY(y.floatValue());
	}

	
	
	
	/**
	 * Sets the start position of this line
	 * @param y the new y position of the start of this line
	 * @return this line for chaining
	 * */
	public Linef setStartY(float y) {
		this.y0 = y;
		return this;
	}
	
	
	
	
	@Override
	public Linef setEndX(Number x) {
		return this.setEndX(x.floatValue());
	}
	
	
	
	
	/**
	 * Sets the end position of this line
	 * @param x the new x position of the end of this line
	 * @return this line for chaining
	 * */
	public Linef setEndX(float x) {
		this.x1 = x;
		return this;
	}

	
	
	
	@Override
	public Linef setEndY(Number y) {
		return this.setEndY(y.floatValue());
	}
	
	
	/**
	 * Sets the end position of this line
	 * @param y the new y position of the end of this line
	 * @return this line for chaining
	 * */
	public Linef setEndY(float y) {
		this.y1 = y;
		return this;
	}
	
	
	
	
	

	@Override
	public Linef switchDirection() {
		final float t0 = x0;
		final float t1 = y0;
		this.x0 = x1;
		this.y0 = y1;
		this.x1 = t0;
		this.y1 = t1;
		return null;
	}

	
	
	
	@Override
	public Linef translate(Number dx, Number dy) {
		return this.translate(dx.floatValue(), dy.floatValue());
	}
	
	
	
	
	/**
	 * Moves this line by the given amount.
	 * @param dx the distance in x-direction
	 * @param dy the distance in y-direction
	 * @return this line for chaining
	 * */
	public Linef translate(float dx, float dy) {
		this.x0 += dx;
		this.y0 += dy;
		this.x1 += dx;
		this.y1 += dy;
		return this;
	}

	
	
	
	@Override
	public Linef translate(IVector2 dir) {
		return this.translate(dir.getFloatX(), dir.getFloatY());
	}

	
	
	
	@Override
	public Linef scale(Number s) {
		return this.scale(s.floatValue());
	}
	
	
	
	
	private Vector2f tmpVec0;
	
	/**
	 * Scales this line. The start position does not change.
	 * @param s the scaling factor
	 * @return this line for chaining
	 * */
	public Linef scale(float s) {
		if(tmpVec0 == null) {
			tmpVec0 = new Vector2f();
		}
		tmpVec0.set(x1, y1).sub(x0, y0).scale(s);
		this.x1 = x0 + tmpVec0.getFloatX();
		this.y1 = y0 + tmpVec0.getFloatY();
		return this;
	}

	
	
	
	@Override
	public Linef scale(Number sx, Number sy) {
		return this.scale(sx.floatValue(), sy.floatValue());
	}

	
	
	
	private Vector2f tmpVec1;
	
	/**
	 * Scales the width and height of this line. The start position does not change.
	 * @param sx the scaling in x direction
	 * @param sy the scaling in y direction
	 * @return this line for chaining
	 * */
	public Linef scale(float sx, float sy) {
		if(tmpVec1 == null) {
			tmpVec1 = new Vector2f();
		}
		tmpVec1.set(x1, y1).sub(x0, y0).mul(sx, sy);
		this.x1 = x0 + tmpVec1.getFloatX();
		this.y1 = y0 + tmpVec1.getFloatY();
		return this;
	}
	
	
	
	
	@Override
	public Linef scale(IVector2 scaling) {
		return this.scale(scaling.getFloatX(), scaling.getFloatY());
	}

	
	
	
	@Override
	public Linef scaleCentered(Number s) {
		return this.scaleCentered(s.floatValue());
	}

	
	
	
	private Vector2f tmpVec2;
	
	/**
	 * Scales this line. The position of the center of does not change.
	 * @param s the scaling factor
	 * @return this line for chaining
	 * */
	public Linef scaleCentered(float s) {
		if(tmpVec2 == null) {
			tmpVec2 = new Vector2f();
		}
		final float cx = getCenterXFloat();
		final float cy = getCenterYFloat();
		tmpVec2.set(x0, y0).sub(cx, cy).scale(s/2f);
		x0 = cx + tmpVec2.getFloatX();
		y0 = cy + tmpVec2.getFloatY();
		tmpVec2.set(x1, y1).sub(cx, cy).scale(s/2f);
		x1 = cx + tmpVec2.getFloatX();
		y1 = cy + tmpVec2.getFloatY();
		return this;
	}
	
	
	
	
	@Override
	public Linef scaleCentered(Number sx, Number sy) {
		return this.scaleCentered(sx.floatValue(), sy.floatValue());
	}
	
	
	
	
	private Vector2f tmpVec3;
	
	/**
	 * Scales this line. The position of the center of does not change.
	 * @param sx the scaling in x direction
	 * @param sy the scaling in y direction
	 * @return this line for chaining
	 * */
	public Linef scaleCentered(float sx, float sy) {
		if(tmpVec3 == null) {
			tmpVec3 = new Vector2f();
		}
		final float cx = getCenterXFloat();
		final float cy = getCenterYFloat();
		tmpVec3.set(x0, y0).sub(cx, cy).mul(sx/2f, sy/2);
		x0 = cx + tmpVec3.getFloatX();
		y0 = cy + tmpVec3.getFloatY();
		tmpVec3.set(x1, y1).sub(cx, cy).mul(sx/2f, sy/2);
		x1 = cx + tmpVec3.getFloatX();
		y1 = cy + tmpVec3.getFloatY();
		return this;
	}
	
	
	

	@Override
	public Linef scaleCentered(IVector2 scaling) {
		return this.scaleCentered(scaling.getFloatX(), scaling.getFloatY());
	}

	
	
	
	@Override
	public boolean isPointOnLine(IVector2 point) {
		return this.isPointOnLine(point.getFloatX(), point.getFloatY());
	}

	
	
	
	@Override
	public boolean isPointOnLine(Number x, Number y) {
		return this.isPointOnLine(x.floatValue(), y.floatValue());
	}
	
	
	
	
	/**
	 * Checks if the given point is on this line
	 * @param x the x position of the point
	 * @param y the y position of the point
	 * @return true, if the point is on the line
	 * */
	public boolean isPointOnLine(float x, float y) {
		return Intersector.pointOnLine(x0, y0, x1, y1, x, y, 0.00001f);
	}
	
	
	
	
	@Override
	public Linef setName(String name) {
		this.name = name;
		return this;
	}

	
	

	@Override
	public String getName() {
		return this.name;
	}

	
	

	@Override
	public Vector2f getRandomPoint() {
		final float dx = x1-x0;
		final float dy = y1-y0;
		final float rand = (float)Math.random();
		Vector2f vec = new Vector2f();
		vec.x = x0 + dx*rand;
		vec.y = y0 + dy*rand;
		return vec;
	}
	
	


	@Override
	public Linef getRandomPoint(IVector2 dst) {
		final float dx = x1-x0;
		final float dy = y1-y0;
		final float rand = (float)Math.random();
		dst.set(x0+dx*rand, y0+dy*rand);
		return this;
	}
	


}

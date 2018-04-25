package com.ruegnerlukas.simplemath.geometry.shapes.line;

import com.ruegnerlukas.simplemath.geometry.Intersector;
import com.ruegnerlukas.simplemath.geometry.IntersectorInt;
import com.ruegnerlukas.simplemath.geometry.shapes.IShape;
import com.ruegnerlukas.simplemath.geometry.shapes.circle.ICircle;
import com.ruegnerlukas.simplemath.geometry.shapes.polygon.IPolygon;
import com.ruegnerlukas.simplemath.geometry.shapes.polygon.Polygonf;
import com.ruegnerlukas.simplemath.geometry.shapes.rectangle.IRectangle;
import com.ruegnerlukas.simplemath.geometry.shapes.rectangle.Rectanglef;
import com.ruegnerlukas.simplemath.vectors.vec2.IVector2;
import com.ruegnerlukas.simplemath.vectors.vec2.Vector2i;
import com.ruegnerlukas.simplemath.vectors.vec4.IVector4;
import com.ruegnerlukas.simplemath.vectors.vec4.Vector4f;

public class Linei implements ILine {
	
	
	
	
	public int x0;
	public int y0;
	public int x1;
	public int y1;
	
	public String name;
	
	
	
	
	
	
	public Linei() {
		this(0,0,0,0);
	}
	
	
	public Linei(Linei line) {
		this(line.getStartXInt(), line.getStartYInt(), line.getEndXInt(), line.getEndYInt());
	}

	
	public Linei(IVector2 start, IVector2 end) {
		this(start.getIntX(), start.getIntY(), end.getIntX(), end.getIntY());
	}
	
	
	public Linei(int x0, int y0, int x1, int y1) {
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
			dest = new Vector2i();
		}
		return dest.set((Integer)getMinXInt(), (Integer)getMinYInt());
	}

	
	
	
	@Override
	public IVector2 getMax() {
		return getMax(null);
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
		return getBounds(null);
	}
	
	
	

	@Override
	public IRectangle getBounds(IRectangle dest) {
		if(dest == null) {
			dest = new Rectanglef();
		}
		return dest.setMin(getMinXInt(), getMinYInt()).setMax(getMaxXInt(), getMaxYInt());
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
		return dest.set(getMinXInt(), getMinYInt(), getMaxXInt(), getMaxYInt());
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
			return IntersectorInt.intersectsRectangleLine(rect.getXInt(), rect.getYInt(), rect.getWidthInt(), rect.getHeightInt(),
					this.x0, this.y0, this.x1, this.y1, null);
		
		} else if(other instanceof ICircle) {
			ICircle circle = (ICircle) other;
			return IntersectorInt.intersectsCircleLine(circle.getCenterXInt(), circle.getCenterYInt(), circle.getRadiusInt(),
					this.x0, this.y0, this.x1, this.y1);
			
		} else if(other instanceof ILine) {
			ILine line = (ILine) other;
			return IntersectorInt.intersectsLineLine(line.getStartXInt(), line.getStartYInt(), line.getEndXInt(), line.getEndYInt(),
					this.x0, this.y0, this.x1, this.y1, null);
			
		} else if(other instanceof Polygonf) {
			Polygonf poly = (Polygonf) other;
			return Intersector.intersectsLinePolygon(x0, y0, x1, y1, poly.getVertices());
			
		} else if(other instanceof IPolygon) {
			IPolygon poly = (IPolygon) other;
			float[] polyVert = new float[poly.getVerticesGen().length];
			for(int i=0, n=polyVert.length; i<n; i++) {
				polyVert[i] = poly.getVerticesGen()[i].intValue();
			}
			return Intersector.intersectsLinePolygon(x0, y0, x1, y1, polyVert);
			
		} else {
			// TODO other shapes
		}
		return false;
	}
	
	
	

	@Override
	public Linei copy() {
		return new Linei(this);
	}
	
	
	
	
	@Override
	public String toString() {
		return name + ": Linei." + this.hashCode() + "(" + this.x0 + ", " + this.y0 + ", " + this.x1 + ", " + this.y1 + ")";
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
			dest = new Vector2i();
		}
		return dest.set((Integer)getStartXInt(), (Integer)getStartYInt());
	}

	
	
	
	@Override
	public IVector2 getEnd() {
		return getEnd(null);
	}

	
	
	
	@Override
	public IVector2 getEnd(IVector2 dest) {
		if(dest == null) {
			dest = new Vector2i();
		}
		return dest.set((Integer)getEndXInt(), (Integer)getEndYInt());
	}

	
	
	
	@Override
	public IVector2 getCenter() {
		return getEnd(null);
	}

	
	
	
	@Override
	public IVector2 getCenter(IVector2 dest) {
		if(dest == null) {
			dest = new Vector2i();
		}
		return dest.set((Integer)getCenterXInt(), (Integer)getCenterYInt());
	}
	
	
	
	
	public Number getLength2Gen() {
		return getLength2();
	}
	
	
	
	
	/**
	 * @return the squared distance between the start and end point
	 * */
	public int getLength2() {
		return (x1-x0)*(x1-x0) + (y1-y0)*(y1-y0);
	}
	
	
	
	
	@Override
	public Number getLengthGen() {
		return getLength();
	}
	
	
	/**
	 * @return the distance between the start and end point
	 * */
	public int getLength() {
		return (int) Math.sqrt(getLength2());
	}

	
	
	
	@Override
	public IVector2 getNormal() {
		return getNormal(null);
	}

	
	
	
	@Override
	public IVector2 getNormal(IVector2 dest) {
		if(dest == null) {
			dest = new Vector2i();
		}
		return dest.set((Integer)x1, (Integer)y1).sub(x0, y0);
	}

	
	
	
	@Override
	public Linei set(ILine line) {
		return this.set(line.getStartXInt(), line.getStartYInt(), line.getEndXInt(), line.getEndYInt());
	}

	
	
	
	@Override
	public Linei set(Number x0, Number y0, Number x1, Number y1) {
		return this.set(x0.intValue(), y0.intValue(), x1.intValue(), y1.intValue());
	}
	
	
	/**
	 * Sets the start and end position of this line
	 * @param x0 the new x position of the start of this line
	 * @param y0 the new y position of the start of this line
	 * @param x1 the new x position of the end of this line
	 * @param y1 the new y position of the end of this line
	 * @return this line for chaining
	 * */
	public Linei set(int x0, int y0, int x1, int y1) {
		this.x0 = x0;
		this.y0 = y0;
		this.x1 = x1;
		this.y1 = y1;
		return this;
	}
	
	

	@Override
	public Linei setStart(Number x, Number y) {
		return this.setStart(x.intValue(), y.intValue());
	}
	
	
	
	
	/**
	 * Sets the start position of this line
	 * @param x the new x position of the start of this line
	 * @param y the new y position of the start of this line
	 * @return this line for chaining
	 * */
	public Linei setStart(int x, int y) {
		this.x0 = x;
		this.y0 = y;
		return this;
	}
	
	

	@Override
	public Linei setEnd(Number x, Number y) {
		return this.setEnd(x.intValue(), y.intValue());
	}

	
	
	
	/**
	 * Sets the end position of this line
	 * @param x the new x position of the end of this line
	 * @param y the new y position of the end of this line
	 * @return this line for chaining
	 * */
	public Linei setEnd(int x, int y) {
		this.x1 = x;
		this.y1 = y;
		return this;
	}
	
	
	
	
	@Override
	public Linei setStartX(Number x) {
		return setStartX(x.intValue());
	}

	
	
	
	/*
	 * Sets the start position of this line
	 * @param x the new x position of the start of this line
	 * @return this line for chaining
	 * */
	public Linei setStartX(int x) {
		this.x0 = x;
		return this;
	}
	
	
	
	
	
	
	
	@Override
	public Linei setStartY(Number y) {
		return setStartY(y.intValue());
	}

	
	
	
	/**
	 * Sets the start position of this line
	 * @param y the new y position of the start of this line
	 * @return this line for chaining
	 * */
	public Linei setStartY(int y) {
		this.y0 = y;
		return this;
	}
	
	
	
	
	@Override
	public Linei setEndX(Number x) {
		return this.setEndX(x.intValue());
	}
	
	
	
	
	/**
	 * Sets the end position of this line
	 * @param x the new x position of the end of this line
	 * @return this line for chaining
	 * */
	public Linei setEndX(int x) {
		this.x1 = x;
		return this;
	}

	
	
	
	@Override
	public Linei setEndY(Number y) {
		return this.setEndY(y.intValue());
	}
	
	
	/**
	 * Sets the end position of this line
	 * @param y the new y position of the end of this line
	 * @return this line for chaining
	 * */
	public Linei setEndY(int y) {
		this.y1 = y;
		return this;
	}
	
	
	
	
	

	@Override
	public Linei switchDirection() {
		final int t0 = x0;
		final int t1 = y0;
		this.x0 = x1;
		this.y0 = y1;
		this.x1 = t0;
		this.y1 = t1;
		return null;
	}

	
	
	
	@Override
	public Linei translate(Number dx, Number dy) {
		return this.translate(dx.intValue(), dy.intValue());
	}
	
	
	
	
	/**
	 * Moves this line by the given amount.
	 * @param dx the distance in x-direction
	 * @param dy the distance in y-direction
	 * @return this line for chaining
	 * */
	public Linei translate(int dx, int dy) {
		this.x0 += dx;
		this.y0 += dy;
		this.x1 += dx;
		this.y1 += dy;
		return this;
	}

	
	
	
	@Override
	public Linei translate(IVector2 dir) {
		return this.translate(dir.getIntX(), dir.getIntY());
	}

	
	
	
	@Override
	public Linei scale(Number s) {
		return this.scale(s.intValue());
	}
	
	
	
	
	private Vector2i tmpVec0;
	
	/**
	 * Scales this line. The start position does not change.
	 * @param s the scaling factor
	 * @return this line for chaining
	 * */
	public Linei scale(int s) {
		if(tmpVec0 == null) {
			tmpVec0 = new Vector2i();
		}
		tmpVec0.set(x1, y1).sub(x0, y0).scale(s);
		this.x1 = x0 + tmpVec0.getIntX();
		this.y1 = y0 + tmpVec0.getIntY();
		return this;
	}

	
	
	
	@Override
	public Linei scale(Number sx, Number sy) {
		return this.scale(sx.intValue(), sy.intValue());
	}

	
	
	
	private Vector2i tmpVec1;
	
	/**
	 * Scales the width and height of this line. The start position does not change.
	 * @param sx the scaling in x direction
	 * @param sy the scaling in y direction
	 * @return this line for chaining
	 * */
	public Linei scale(int sx, int sy) {
		if(tmpVec1 == null) {
			tmpVec1 = new Vector2i();
		}
		tmpVec1.set(x1, y1).sub(x0, y0).mul(sx, sy);
		this.x1 = x0 + tmpVec1.getIntX();
		this.y1 = y0 + tmpVec1.getIntY();
		return this;
	}
	
	
	
	
	@Override
	public Linei scale(IVector2 scaling) {
		return this.scale(scaling.getIntX(), scaling.getIntY());
	}

	
	
	
	@Override
	public Linei scaleCentered(Number s) {
		return this.scaleCentered(s.intValue());
	}

	
	
	
	private Vector2i tmpVec2;
	
	/**
	 * Scales this line. The position of the center of does not change.
	 * @param s the scaling factor
	 * @return this line for chaining
	 * */
	public Linei scaleCentered(int s) {
		if(tmpVec2 == null) {
			tmpVec2 = new Vector2i();
		}
		final int cx = getCenterXInt();
		final int cy = getCenterYInt();
		tmpVec2.set(x0, y0).sub(cx, cy).scale(s/2f);
		x0 = cx + tmpVec2.getIntX();
		y0 = cy + tmpVec2.getIntY();
		tmpVec2.set(x1, y1).sub(cx, cy).scale(s/2f);
		x1 = cx + tmpVec2.getIntX();
		y1 = cy + tmpVec2.getIntY();
		return this;
	}
	
	
	
	
	@Override
	public Linei scaleCentered(Number sx, Number sy) {
		return this.scaleCentered(sx.intValue(), sy.intValue());
	}
	
	
	
	
	private Vector2i tmpVec3;
	
	/**
	 * Scales this line. The position of the center of does not change.
	 * @param sx the scaling in x direction
	 * @param sy the scaling in y direction
	 * @return this line for chaining
	 * */
	public Linei scaleCentered(int sx, int sy) {
		if(tmpVec3 == null) {
			tmpVec3 = new Vector2i();
		}
		final int cx = getCenterXInt();
		final int cy = getCenterYInt();
		tmpVec3.set(x0, y0).sub(cx, cy).mul(sx/2f, sy/2);
		x0 = cx + tmpVec3.getIntX();
		y0 = cy + tmpVec3.getIntY();
		tmpVec3.set(x1, y1).sub(cx, cy).mul(sx/2f, sy/2);
		x1 = cx + tmpVec3.getIntX();
		y1 = cy + tmpVec3.getIntY();
		return this;
	}
	
	
	

	@Override
	public Linei scaleCentered(IVector2 scaling) {
		return this.scaleCentered(scaling.getIntX(), scaling.getIntY());
	}

	
	
	
	@Override
	public boolean isPointOnLine(IVector2 point) {
		return this.isPointOnLine(point.getIntX(), point.getIntY());
	}

	
	
	
	@Override
	public boolean isPointOnLine(Number x, Number y) {
		return this.isPointOnLine(x.intValue(), y.intValue());
	}
	
	
	
	
	/**
	 * Checks if the given point is on this line
	 * @param x the x position of the point
	 * @param y the y position of the point
	 * @return true, if the point is on the line
	 * */
	public boolean isPointOnLine(int x, int y) {
		return IntersectorInt.pointOnLine(x0, y0, x1, y1, x, y, 0);
	}
	
	
	

	@Override
	public Linei setName(String name) {
		this.name = name;
		return this;
	}

	
	

	@Override
	public String getName() {
		return this.name;
	}
	
	
	
	
	@Override
	public Vector2i getRandomPoint() {
		final int dx = x1-x0;
		final int dy = y1-y0;
		final float rand = (float)Math.random();
		Vector2i vec = new Vector2i();
		vec.x = x0 + (int)(dx*rand);
		vec.y = y0 + (int)(dy*rand);
		return vec;
	}
	
	


	@Override
	public Linei getRandomPoint(IVector2 dst) {
		final int dx = x1-x0;
		final int dy = y1-y0;
		final float rand = (float)Math.random();
		dst.set(x0+(int)(dx*rand), y0+(int)(dy*rand));
		return this;
	}

}

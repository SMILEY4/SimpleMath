package com.ruegnerlukas.simplemath.vecmath.vec2;

import com.ruegnerlukas.simplemath.vecmath.IVector;

public class Vector2f implements IVector2 {

	
	
	
	
	
	public static Vector2f createVector(float ax, float ay, float bx, float by) {
		return new Vector2f(bx-ax, by-ay);
	}
	
	
	public static Vector2f createVector(IVector2 a, IVector2 b) {
		return new Vector2f(b.getFloatX()-a.getFloatX(), b.getFloatY()-a.getFloatY());
	}

	
	
	
	public static Vector2f setVector(float ax, float ay, float bx, float by, Vector2f vec) {
		return (Vector2f) vec.set(bx-ax, by-ay);
	}
	
	
	public static Vector2f setVector(IVector2 a, IVector2 b, Vector2f vec) {
		return (Vector2f) vec.set(b.getFloatX()-a.getFloatX(), b.getFloatY()-a.getFloatY());
	}
	
	
	
	
	
	
	
	public float x;
	public float y;
	
	
	
	
	
	
	public Vector2f() {
		this(0f, 0f);
	}

	
	public Vector2f(float value) {
		this(value, value);
	}
	
	
	public Vector2f(IVector2 v) {
		this(v.getFloatX(), v.getFloatY());
	}
	
	
	public Vector2f(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	
	
	
	
	
	////////////////////////////////////////
	//               SETTER               //
	////////////////////////////////////////
	
	@Override
	public Vector2f set(IVector2 v) {
		return set(v.getFloatX(), v.getFloatY());
	}

	
	@Override
	public Vector2f set(short x, short y) {
		return set((float)x, (float)y);
	}
	
	
	@Override
	public Vector2f set(int x, int y) {
		return set((float)x, (float)y);
	}
	
	
	@Override
	public Vector2f set(long x, long y) {
		return set((float)x, (float)y);
	}

	
	@Override
	public Vector2f set(float x, float y) {
		this.x = x;
		this.y = y;
		return this;
	}
	

	@Override
	public Vector2f set(double x, double y) {
		return set((float)x, (float)y);
	}
	
	
	
	
	
	
	////////////////////////////////////////
	//               GETTER               //
	////////////////////////////////////////
	
	@Override
	public short getShortX() {
		return (short)x;
	}

	
	@Override
	public short getShortY() {
		return (short)y;
	}
	

	@Override
	public short getShort(int index) {
		if(index == 0) {
			return getShortX();
		} else if(index == 1) {
			return getShortY();
		} else {
			return 0;
		}
	}

	
	
	
	@Override
	public int getIntX() {
		return (int)x;
	}

	
	@Override
	public int getIntY() {
		return (int)y;
	}
	
	
	@Override
	public int getInt(int index) {
		if(index == 0) {
			return getIntX();
		} else if(index == 1) {
			return getIntY();
		} else {
			return 0;
		}
	}

	
	
	
	@Override
	public long getLongX() {
		return (long)x;
	}

	
	@Override
	public long getLongY() {
		return (long)y;
	}
	
	
	@Override
	public long getLong(int index) {
		if(index == 0) {
			return getLongX();
		} else if(index == 1) {
			return getLongY();
		} else {
			return 0;
		}
	}

	
	
	
	@Override
	public float getFloatX() {
		return x;
	}

	
	@Override
	public float getFloatY() {
		return y;
	}

	
	@Override
	public float getFloat(int index) {
		if(index == 0) {
			return getFloatY();
		} else if(index == 1) {
			return getFloatY();
		} else {
			return 0;
		}
	}

	
	
	
	@Override
	public double getDoubleX() {
		return (double)x;
	}
	

	@Override
	public double getDoubleY() {
		return (double)y;
	}

	
	@Override
	public double getDouble(int index) {
		if(index == 0) {
			return getDoubleX();
		} else if(index == 1) {
			return getDoubleY();
		} else {
			return 0;
		}
	}

	
	
	
	
	
	////////////////////////////////////////
	//             CONVERSION             //
	////////////////////////////////////////
	
	@Override
	public Vector2s toShortVector() {
		return new Vector2s(this);
	}

	
	@Override
	public Vector2i toIntVector() {
		return new Vector2i(this);
	}

	
	@Override
	public Vector2l toLongVector() {
		return new Vector2l(this);
	}

	
	@Override
	public Vector2f toFloatVector() {
		return new Vector2f(this);
	}

	
	@Override
	public Vector2d toDoubleVector() {
		return new Vector2d(this);
	}
	
	
	
	
	
	
	////////////////////////////////////////
	//             BASIC MATH             //
	////////////////////////////////////////
	
	public Vector2f add(float x, float y) {
		this.x += x;
		this.y += y;
		return this;
	}
	
	
	public Vector2f add(float value) {
		return add(value, value);
	}
	

	@Override
	public Vector2f add(IVector2 v) {
		return add(v.getFloatX(), v.getFloatY());
	}
	
	
	

	public Vector2f sub(float x, float y) {
		return add(-x, -y);
	}
	
	
	public Vector2f sub(float value) {
		return sub(value, value);
	}
	
	
	@Override
	public Vector2f sub(IVector2 v) {
		return sub(v.getFloatX(), v.getFloatY());
	}

	
	
	
	public Vector2f mul(float x, float y) {
		this.x *= x;
		this.y *= y;
		return this;
	}
	
	
	@Override
	public Vector2f mul(IVector2 v) {
		return mul(v.getFloatX(), v.getFloatY());
	}

	
	
	
	public Vector2f div(float x, float y) {
		this.x /= x;
		this.y /= y;
		return this;
	}
	
	
	@Override
	public Vector2f div(IVector2 v) {
		return div(v.getFloatX(), v.getFloatY());
	}


	
	
	@Override
	public Vector2f scale(double s) {
		this.x *= s;
		this.y *= s;
		return this;
	}

	
	
	
	
	
	////////////////////////////////////////
	//          OTHER OPERATIONS          //
	////////////////////////////////////////
	
	@Override
	public double angleRadStd(IVector2 v) {
		return angleRadStd(v.getDoubleX(), v.getDoubleY());
	}
	
	
	@Override
	public double angleRadStd(double x, double y) {
		final double cross = crossStd(x, y);
		final double dot   = dotStd(x, y);
		return Math.atan2(cross, dot);
	}
	
	
	public float angleRad(IVector2 v) {
		final float cross = cross(v);
		final float dot   = dot(v);
		return (float)Math.atan2(cross, dot);
	}
	
	
	public float angleRad(float x, float y) {
		final float cross = cross(x, y);
		final float dot   = dot(x, y);
		return (float)Math.atan2(cross, dot);
	}

	
	
	
	@Override
	public double angleDegStd(IVector2 v) {
		return Math.toDegrees(angleRadStd(v));
	}

	
	@Override
	public double angleDegStd(double x, double y) {
		return Math.toDegrees(angleRadStd(x, y));
	}
	
	
	public float angleDeg(IVector2 v) {
		return (float)Math.toDegrees(angleRad(v));
	}

	
	public float angleDeg(float x, float y) {
		return (float)Math.toDegrees(angleRad(x, y));
	}
	
	
	
	
	@Override
	public double crossStd(IVector2 v) {
		return (this.x * v.getDoubleY()) - (this.y * v.getDoubleX());
	}
	
	
	@Override
	public double crossStd(double x, double y) {
		return (this.x * x) - (this.y * y);
	}

	
	public float cross(IVector2 v) {
		return (this.x * v.getFloatY()) - (this.y * v.getFloatX());
	}
	
	
	public float cross(float x, float y) {
		return (this.x * x) - (this.y * y);
	}
	
	
	
	
	@Override
	public double dotStd(IVector2 v) {
		return (x * v.getDoubleX()) + (y * v.getDoubleY());
	}
	
	
	@Override
	public double dotStd(double x, double y) {
		return (this.x * x) + (this.y * y);
	}
	
	
	public float dot(IVector2 v) {
		return (x * v.getFloatX()) + (y * v.getFloatY());
	}
	
	
	public float dot(float x, float y) {
		return (this.x * x) + (this.y * y);
	}

	
	
	
	
	@Override
	public Vector2f negate() {
		this.x = -this.x;
		this.y = -this.y;
		return this;
	}

	
	
	
	
	@Override
	public double componentSumStd() {
		return this.x + this.y;
	}

	
	public float componentSum() {
		return this.x + this.y;
	}
	
	
	
	@Override
	public double componentMinStd() {
		return Math.min((double)this.x, (double)this.y);
	}
	
	
	public float componentMin() {
		return Math.min(this.x, this.y);
	}

	
	
	
	@Override
	public double componentMaxStd() {
		return Math.max((double)this.x, (double)this.y);
	}
	
	
	public float componentMax() {
		return Math.max(this.x, this.y);
	}
	
	
	

	@Override
	public double length2Std() {
		final double x = this.x;
		final double y = this.y;
		return x*x + y*y;
	}


	public float length2() {
		return x*x + y*y;
	}
	
	
	
	
	@Override
	public double lengthStd() {
		return Math.sqrt(length2Std());
	}
	
	
	public float length() {
		return (float) Math.sqrt(length2());
	}
	
	
	

	@Override
	public double dist2Std(IVector2 v) {
		final double x1 = x;
		final double y1 = y;
		final double x2 = v.getDoubleX();
		final double y2 = v.getDoubleY();
		return (x2-x1)*(x2-x1) + (y2-y1)*(y2-y1);
	}

	
	
	public float dist2(IVector2 v) {
		return dist2(v.getFloatX(), v.getFloatY());
	}
	
	
	public float dist2(float x, float y) {
		final float x1 = this.x;
		final float y1 = this.y;
		final float x2 = x;
		final float y2 = y;
		return (x2-x1)*(x2-x1) + (y2-y1)*(y2-y1);
	}
	
	
	public double dist2(double x, double y) {
		final double x1 = this.x;
		final double y1 = this.y;
		final double x2 = x;
		final double y2 = y;
		return (x2-x1)*(x2-x1) + (y2-y1)*(y2-y1);
	}
	
	
	
	
	@Override
	public double distStd(IVector2 v) {
		return Math.sqrt(dist2Std(v));
	}
	
	
	public float dist(IVector2 v) {
		return (float) Math.sqrt(dist2(v));
	}
	
	
	public float dist(float x, float y) {
		return (float) Math.sqrt(dist2(x, y));
	}
	
	
	public double dist(double x, double y) {
		return Math.sqrt(dist2(x, y));
	}
	
	

	
	@Override
	public Vector2f normalize() {
		final double len = lengthStd();
		this.x /= len;
		this.y /= len;
		return this;
	}

	
	
	
	@Override
	public Vector2f setLength(double length) {
		normalize();
		scale(length);
		return this;
	}

	
	
	
	@Override
	public Vector2f limitLength(double max) {
		double len = lengthStd();
		if(len > max) {
			this.x /= len;
			this.y /= len;
		}
		scale(max);
		return this;
	}

	
	
	
	@Override
	public Vector2f clampLength(double min, double max) {
		double len = lengthStd();
		if(len > max) {
			this.x /= len;
			this.y /= len;
			scale(max);
		} else if(len < min) {
			this.x /= len;
			this.y /= len;
			scale(min);
		}
		return this;
	}

	
	
	
	@Override
	public Vector2f clampComponents(double min, double max) {
		this.x = (float) Math.min(max, Math.max(this.x, min));
		this.y = (float) Math.min(max, Math.max(this.y, min));
		return this;
	}

	
	
	
	
	@Override
	public Vector2f rotateRad(double angleRad) {
		final double cos = Math.cos(angleRad);
		final double sin = Math.sin(angleRad);
		this.x = (float) (x*cos - y*sin);
		this.y = (float) (x*sin + y*cos);
		return this;
	}

	@Override
	public Vector2f rotateDeg(double angleDeg) {
		return rotateRad(Math.toRadians(angleDeg));
	}

	@Override
	public Vector2f project(IVector2 vec) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	@Override
	public IVector2 reflect() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public IVector2 refract() {
		// TODO Auto-generated method stub
		return null;
	}
	

	@Override
	public Vector2f copy() {
		// TODO Auto-generated method stub
		return null;
	}




}

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
//		return new Vector2s(this);
		return null;
	}

	
	@Override
	public Vector2i toIntVector() {
//		return new Vector2i(this);
		return null;
	}

	
	@Override
	public Vector2l toLongVector() {
//		return new Vector2l(this);
		return null;
	}

	
	@Override
	public Vector2f toFloatVector() {
		return this.copy();
	}

	
	@Override
	public Vector2d toDoubleVector() {
//		return new Vector2d(this);
		return null;
	}
	
	
	@Override
	public String toString() {
		return "Vector2f." + this.hashCode() + "[" + this.x + ", " + this.y + "]";
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
		this.x -= x;
		this.y -= y;
		return this;
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
	
	public double angleRad(IVector2 v) {
		final double cross = cross(v);
		final double dot   = dot(v);
		return Math.atan2(cross, dot);
	}
	
	
	public double angleRad(float x, float y) {
		final double cross = cross(x, y);
		final double dot   = dot(x, y);
		return Math.atan2(cross, dot);
	}

	
	
	
	public double angleDeg(IVector2 v) {
		return Math.toDegrees(angleRad(v));
	}

	
	public double angleDeg(float x, float y) {
		return Math.toDegrees(angleRad(x, y));
	}
	
	
	

	public float cross(IVector2 v) {
		return (this.x * v.getFloatY()) - (this.y * v.getFloatX());
	}
	
	
	public float cross(float x, float y) {
		return (this.x * y) - (this.y * x);
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
	
	
	
	
	public float componentSum() {
		return this.x + this.y;
	}
	
	
	
	
	public float componentMin() {
		return Math.min(this.x, this.y);
	}

	
	
	
	public float componentMax() {
		return Math.max(this.x, this.y);
	}
	
	
	

	@Override
	public float length2Float() {
		return length2();
	}
	
	
	public float length2() {
		return x*x + y*y;
	}
	
	
	
	
	@Override
	public float lengthFloat() {
		return (float) length();
	}
	
	
	public double length() {
		return Math.sqrt(length2());
	}
	
	
	
	
	@Override
	public float dist2Float(IVector2 v) {
		return (float) dist2(v);
	}
	
	
	@Override
	public float dist2Float(float x, float y) {
		return dist2(x, y);
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
	
	
	
	
	public float distFloat(IVector2 v) {
		return (float) dist(v);
	}
	
	
	public float distFloat(float x, float y) {
		return (float) dist(x, y);
	}
	
	
	public double dist(IVector2 v) {
		return Math.sqrt(dist2(v));
	}
	
	
	public double dist(float x, float y) {
		return Math.sqrt(dist2(x, y));
	}
	

	
	
	@Override
	public Vector2f normalize() {
		final double len = length();
		this.x /= len;
		this.y /= len;
		return this;
	}

	
	
	
	public Vector2f setLength(float length) {
		normalize();
		scale(length);
		return this;
	}

	
	
	
	public Vector2f limitLength(float max) {
		double len = length();
		if(len > max) {
			this.x /= len;
			this.y /= len;
		}
		scale(max);
		return this;
	}

	
	
	
	public Vector2f clampLength(double min, double max) {
		double len = length();
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

	
	
	
	public Vector2f clampComponents(float min, float max) {
		this.x = Math.min(max, Math.max(this.x, min));
		this.y = Math.min(max, Math.max(this.y, min));
		return this;
	}

	
	
	
	
	public Vector2f rotateRad(float angleRad) {
		final double cos = Math.cos(angleRad);
		final double sin = Math.sin(angleRad);
		this.x = (float) (x*cos - y*sin);
		this.y = (float) (x*sin + y*cos);
		return this;
	}

	
	
	
	public Vector2f rotateDeg(float angleDeg) {
		return rotateRad((float)Math.toRadians(angleDeg));
	}

	
	
	
	public Vector2f project(IVector2 v) {
		final double dot = dot(v);
		final double len2 = v.length2Float();
		this.set(v).scale(dot / len2);
		return this;
	}
	
	
	
	
	public Vector2f reflect(IVector2 n) { // n should be normalized before
		// I - 2.0 * dot(N, I) * N
		final double dotN = this.dot(n);
		float rx = (float) (2.0 * dotN * n.getDoubleX());
		float ry = (float) (2.0 * dotN * n.getDoubleY());
		this.sub(rx, ry);
		return this;
	}


	
	
	// https://www.khronos.org/registry/OpenGL-Refpages/gl4/html/refract.xhtml
	public IVector2 refract(IVector2 n, float eta) {
		final double dotN = this.dot(n);
		final double k = 1.0 - eta*eta * (1.0 - dotN*dotN);
		if(k < 0.0) {
			this.set(0f, 0f);
		} else {
			final double sqrtK = Math.sqrt(k);
			float rx = (float) (eta * this.x - (eta * dotN + sqrtK) * n.getDoubleX());
			float ry = (float) (eta * this.y - (eta * dotN + sqrtK) * n.getDoubleY());
			this.set(rx, ry);
		}
		return this;
	}
	

	
	
	@Override
	public Vector2f copy() {
		return new Vector2f(this.x, this.y);
	}


	@Override
	public int getDimensions() {
		return 2;
	}


}

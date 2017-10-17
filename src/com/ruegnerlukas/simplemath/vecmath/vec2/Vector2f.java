package com.ruegnerlukas.simplemath.vecmath.vec2;

import com.ruegnerlukas.simplemath.vecmath.IVector;

public class Vector2f implements IVector2 {

	
	
	
	public static Vector2f createVectorAB(IVector2 a, IVector2 b) {
		return Vector2f.createVectorAB(a.getFloatX(), a.getFloatY(), b.getFloatX(), b.getFloatY());
	}
	
	
	public static Vector2f createVectorAB(float ax, float ay, float bx, float by) {
		return new Vector2f(bx-ax, by-ay);
	}
	
	
	
	
	public static Vector2f setVectorAB(IVector2 a, IVector2 b, Vector2f dst) {
		return Vector2f.setVectorAB(a.getFloatX(), a.getFloatY(), b.getFloatX(), b.getFloatY(), dst);
	}
	
	
	public static Vector2f setVectorAB(float ax, float ay, float bx, float by, Vector2f dst) {
		return dst.set(bx-ax, by-ay);
	}
	
	
	
	
	
	
	public float x;
	public float y;
	
	
	
	
	
	
	public Vector2f() {
		this(0);
	}
	
	
	public Vector2f(float xy) {
		this(xy, xy);
	}
	
	
	public Vector2f(IVector2 vec) {
		this(vec.getFloatX(), vec.getFloatY());
	}

	
	public Vector2f(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	
	
	
	
	
	
	
	@Override
	public int getDimensions() {
		return 2;
	}

	
	
	
	@Override
	public Vector2f set(int index, Number value) {
		if(index == 0) { this.x = value.floatValue(); return this; }
		if(index == 1) { this.y = value.floatValue(); return this; }
		return null;
	}

	
	
	
	
	@Override
	public short getShort(int index) {
		if(index == 0) { return (short) this.x; }
		if(index == 1) { return (short) this.y; }
		return 0;
	}

	
	@Override
	public int getInt(int index) {
		if(index == 0) { return (int) this.x; }
		if(index == 1) { return (int) this.y; }
		return 0;
	}

	
	@Override
	public long getLong(int index) {
		if(index == 0) { return (long) this.x; }
		if(index == 1) { return (long) this.y; }
		return 0;
	}

	
	@Override
	public float getFloat(int index) {
		if(index == 0) { return this.x; }
		if(index == 1) { return this.y; }
		return 0;
	}

	
	@Override
	public double getDouble(int index) {
		if(index == 0) { return (double) this.x; }
		if(index == 1) { return (double) this.y; }
		return 0;
	}

	
	
	
	@Override
	public Vector2f negate() {
		this.x = -x;
		this.y = -y;
		return this;
	}

	
	
	
	@Override
	public Vector2f normalize() {
		final float len = length();
		this.x /= len;
		this.y /= len;
		return this;
	}
	
	
	

	@Override
	public Vector2f copy() {
		return new Vector2f(this);
	}

	
	
	
	
	
	@Override
	public Vector2f set(IVector2 v) {
		return this.set(v.getFloatX(), v.getFloatY());
	}

	
	@Override
	public Vector2f set(Number x, Number y) {
		return this.set(x.floatValue(), y.floatValue());
	}

	
	@Override
	public Vector2f set(Number xy) {
		return this.set(xy.floatValue());
	}
	

	public Vector2f set(float xy) {
		return this.set(xy, xy);
	}
	
	
	public Vector2f set(float x, float y) {
		this.x = x;
		this.y = y;
		return this;
	}
	
	
	
	
	@Override
	public short getShortX() {
		return (short) this.x;
	}

	@Override
	public short getShortY() {
		return (short) this.y;
	}

	@Override
	public int getIntX() {
		return (int) this.x;
	}

	@Override
	public int getIntY() {
		return (int) this.y;
	}

	@Override
	public long getLongX() {
		return (long) this.x;
	}

	@Override
	public long getLongY() {
		return (long) this.y;
	}

	@Override
	public float getFloatX() {
		return this.x;
	}

	@Override
	public float getFloatY() {
		return this.y;
	}

	@Override
	public double getDoubleX() {
		return this.x;
	}

	@Override
	public double getDoubleY() {
		return this.y;
	}

	
	
	
	
	
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
		return (Vector2f) this.copy();
	}

	@Override
	public Vector2d toDoubleVector() {
		return new Vector2d(this);
	}

	
	
	
	
	
	@Override
	public Vector2f add(IVector2 vec) {
		return this.add(vec.getFloatX(), vec.getFloatY());
	}
	

	@Override
	public Vector2f add(Number x, Number y) {
		return this.add(x.floatValue(), y.floatValue());
	}
	
	
	@Override
	public Vector2f add(Number xy) {
		return this.add(xy.floatValue());
	}
	
	
	public Vector2f add(float xy) {
		return this.add(xy, xy);
	}
	
	
	public Vector2f add(float x, float y) {
		this.x += x;
		this.y += y;
		return this;
	}

	
	
	
	@Override
	public Vector2f sub(IVector2 vec) {
		return this.sub(vec.getFloatX(), vec.getFloatY());
	}

	
	@Override
	public Vector2f sub(Number x, Number y) {
		return this.sub(x.floatValue(), y.floatValue());

	}
	
	
	@Override
	public Vector2f sub(Number xy) {
		return this.sub(xy.floatValue());
	}

	
	public Vector2f sub(float xy) {
		return this.sub(xy, xy);
	}
	
	
	public Vector2f sub(float x, float y) {
		this.x -= x;
		this.y -= y;
		return this;
	}
	
	
	
	
	@Override
	public Vector2f mul(IVector2 vec) {
		return this.mul(vec.getFloatX(), vec.getFloatY());
	}
	
	
	@Override
	public Vector2f mul(Number x, Number y) {
		return this.mul(x.floatValue(), y.floatValue());
	}

	
	@Override
	public Vector2f scale(Number xy) {
		return this.scale(xy.floatValue());
	}

	
	public Vector2f scale(float xy) {
		return this.mul(xy, xy);
	}

	
	public Vector2f mul(float x, float y) {
		this.x *= x;
		this.y *= y;
		return this;
	}
	
	
	
	
	@Override
	public Vector2f div(IVector2 vec) {
		return this.div(vec.getFloatX(), vec.getFloatY());
	}

	
	@Override
	public Vector2f div(Number x, Number y) {
		return this.div(x.floatValue(), y.floatValue());
	}
	
	
	@Override
	public Vector2f div(Number xy) {
		return this.div(xy.floatValue());
	}

	
	public Vector2f div(float xy) {
		return this.div(xy, xy);
	}
	
	
	public Vector2f div(float x, float y) {
		this.x /= x;
		this.y /= y;
		return this;
	}
	
	
	
	
	@Override
	public Number crossGen(IVector2 vec) {
		return this.cross(vec);
	}

	
	@Override
	public Number crossGen(Number x, Number y) {
		return this.cross(x.floatValue(), y.floatValue());
	}
	
	
	public float cross(IVector2 vec) {
		return this.cross(vec.getFloatX(), vec.getFloatY());
	}
	
	
	public float cross(float x, float y) {
		return (this.x * y) - (this.y * x);
	}
	
	
	

	@Override
	public Number dotGen(IVector2 vec) {
		return this.dot(vec);
	}

	
	@Override
	public Number dotGen(Number x, Number y) {
		return this.dot(x.floatValue(), y.floatValue());
	}
	
	
	public float dot(IVector2 vec) {
		return this.dot(vec.getFloatX(), vec.getFloatY());
	}
	
	
	public float dot(float x, float y) {
		return (this.x * x) + (this.y * y);
	}
	
	
	

	@Override
	public Number dist2Gen(IVector2 vec) {
		return this.dist2(vec);
	}

	
	@Override
	public Number dist2Gen(Number x, Number y) {
		return this.dist2(x.floatValue(), y.floatValue());
	}
	
	
	public float dist2(IVector2 vec) {
		return this.dist2(vec.getFloatX(), vec.getFloatY());
	}
	
	
	public float dist2(float x, float y) {
		return (x-this.x)*(x-this.x) + (y-this.y)*(y-this.y);
	}
	
	
	
	
	@Override
	public Number distGen(IVector2 vec) {
		return this.dist(vec);
	}

	
	@Override
	public Number distGen(Number x, Number y) {
		return this.dist(x.floatValue(), y.floatValue());
	}
	
	
	public float dist(IVector2 vec) {
		return this.dist(vec.getFloatX(), vec.getFloatY());
	}
	
	
	public float dist(float x, float y) {
		return (float) Math.sqrt(this.dist2(x, y));
	}
	
	

	
	@Override
	public Number length2Gen() {
		return length2();
	}

	
	public float length2() {
		return x*x + y*y;
	}
	
	
	
	
	@Override
	public Number lengthGen() {
		return length();
	}
	
	
	public float length() {
		return (float) Math.sqrt(length2());
	}

	
	
	
	
	@Override
	public Vector2f setLength(Number length) {
		return this.setLength(length.floatValue());
	}
	
	
	public Vector2f setLength(float length) {
		normalize();
		scale(length);
		return this;
	}
	
	

	
	@Override
	public Vector2f limitLength(Number maxLength) {
		return null;
	}
	
	public Vector2f limitLength(float maxLength) {
		float len = length();
		if(len > maxLength) {
			div(len);
			scale(maxLength);
		}
		return this;
	}
	
	

	
	@Override
	public Vector2f clampLenght(Number minLength, Number maxLength) {
		return this.clampLength(minLength.floatValue(), maxLength.floatValue());
	}
	
	
	public Vector2f clampLength(float minLength, float maxLength) {
		float len = length();
		if(len < minLength) {
			div(len);
			scale(minLength);
		}
		if(len > maxLength) {
			div(len);
			scale(maxLength);
		}
		return this;
	}
	

	
	
	@Override
	public Number angleRadGen(IVector2 vec) {
		return this.angleRad(vec);
	}

	
	@Override
	public Number angleRadGen(Number x, Number y) {
		return this.angleRad(x.floatValue(), y.floatValue());
	}


	public float angleRad(IVector2 vec) {
		return this.angleRad(vec.getFloatX(), vec.getFloatY());
	}
	
	
	public float angleRad(float x, float y) {
		final float cross = cross(x, y);
		final float dot   = dot(x, y);
		return (float) Math.atan2(cross, dot);
	}
	
	
	
	
	@Override
	public Number angleDegGen(IVector2 vec) {
		return this.angleDeg(vec);
	}

	
	@Override
	public Number angleDegGen(Number x, Number y) {
		return this.angleDeg(x.floatValue(), y.floatValue());
	}
	
	
	public float angleDeg(IVector2 vec) {
		return this.angleDeg(vec.getFloatX(), vec.getFloatY());
	}
	
	
	public float angleDeg(float x, float y) {
		return (float) Math.toDegrees(angleRad(x, y));
	}
	

	
	
	@Override
	public Vector2f rotateRad(Number angleRad) {
		return this.rotateRad(angleRad.floatValue());
	}

	
	public Vector2f rotateRad(float angleRad) {
		final double cos = Math.cos(angleRad);
		final double sin = Math.sin(angleRad);
		this.x = (float) (x*cos - y*sin);
		this.y = (float) (x*sin + y*cos);
		return this;
	}
	
	
	
	
	@Override
	public Vector2f rotateDeg(Number angleDeg) {
		return this.rotateDeg(angleDeg.floatValue());
	}
	
	
	public Vector2f rotateDeg(float angleDeg) {
		return this.rotateRad(Math.toRadians(angleDeg));
	}
	

	
	
	@Override
	public Vector2f project(IVector2 vec) {
		final float dot = dot(vec);
		final float len2 = vec.length2Gen().floatValue();
		this.set(vec).scale(dot / len2);
		return this;
	}

	
	public Vector2f project(Vector2f vec) {
		final float dot = dot(vec);
		final float len2 = vec.length2();
		this.set(vec).scale(dot / len2);
		return this;
	}
	
	
	
	
	@Override
	public Vector2f reflect(IVector2 n) {  // n should be normalized before
		// I - 2.0 * dot(N, I) * N
		final float dotN = this.dot(n);
		float rx = (2.0f * dotN * n.getFloatX());
		float ry = (2.0f * dotN * n.getFloatY());
		this.sub(rx, ry);
		return this;
	}

	
	
	@Override
	public IVector2 refract(IVector2 n, float eta) { // https://www.khronos.org/registry/OpenGL-Refpages/gl4/html/refract.xhtml
		final float dotN = this.dot(n);
		final float k = 1.0f - eta*eta * (1.0f - dotN*dotN);
		if(k < 0.0) {
			this.set(0f, 0f);
		} else {
			final double sqrtK = Math.sqrt(k);
			float rx = (float) (eta * this.x - (eta * dotN + sqrtK) * n.getFloatX());
			float ry = (float) (eta * this.y - (eta * dotN + sqrtK) * n.getFloatX());
			this.set(rx, ry);
		}
		return this;
	}

	
	
	
	@Override
	public Number componentSumGen() {
		return componentSum();
	}

	
	public float componentSum() {
		return x + y;
	}
	
	
	
	
	@Override
	public Number componentMinGen() {
		return this.componentMin();
	}
	
	
	public float componentMin() {
		return Math.min(x, y);
	}

	
	
	
	@Override
	public Number componentMaxGen() {
		return this.componentMin();
	}
	
	
	public float componentMax() {
		return Math.max(x, y);
	}

	
	
	
	@Override
	public Vector2f clampComponents(Number min, Number max) {
		return this.clampComponents(min.floatValue(), max.floatValue());
	}
	
	
	public Vector2f clampComponents(float min, float max) {
		this.x = Math.min(max, Math.max(this.x, min));
		this.y = Math.min(max, Math.max(this.y, min));
		return this;
	}

	
}

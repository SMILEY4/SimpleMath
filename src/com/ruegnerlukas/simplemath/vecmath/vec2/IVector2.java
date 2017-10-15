package com.ruegnerlukas.simplemath.vecmath.vec2;

import com.ruegnerlukas.simplemath.vecmath.IVector;

public interface IVector2 extends IVector {


	// setter
	public IVector2 set(IVector2 v);
	public IVector2 set(short x, short y);
	public IVector2 set(int x, int y);
	public IVector2 set(long x, long y);
	public IVector2 set(float x, float y);
	public IVector2 set(double x, double y);

	
	// getter
	public short getShortX();
	public short getShortY();
	public short getShort(int index);
	public int getIntX();
	public int getIntY();
	public int getInt(int index);
	public long getLongX();
	public long getLongY();
	public long getLong(int index);
	public float getFloatX();
	public float getFloatY();
	public float getFloat(int index);
	public double getDoubleX();
	public double getDoubleY();
	public double getDouble(int index);
	
	
	// conversion
	public Vector2s toShortVector();
	public Vector2i toIntVector();
	public Vector2l toLongVector();
	public Vector2f toFloatVector();
	public Vector2d toDoubleVector();
	@Override public String toString();

	
	// basic element-wise math operations
	public IVector2 add(IVector2 v);
	public IVector2 sub(IVector2 v);
	public IVector2 mul(IVector2 v);
	public IVector2 div(IVector2 v);
	public IVector2 scale(double s);
	
	
	// other operations
	public double angleRadStd(IVector2 v);	
	public double angleRadStd(double x, double y);

	public double angleDegStd(IVector2 v);	
	public double angleDegStd(double x, double y);

	public double crossStd(IVector2 v);
	public double crossStd(double x, double y);

	public double dotStd(IVector2 v);
	public double dotStd(double x, double y);

	public IVector2 negate();
	
	public double componentSumStd();
	public double componentMinStd();
	public double componentMaxStd();

	public double length2Std();
	public double lengthStd();

	public double dist2Std(IVector2 v);
	public double distStd(IVector2 v);

	public IVector2 normalize();
	public IVector2 setLength(double length);
	public IVector2 limitLength(double max);
	public IVector2 clampLength(double min, double max);
	public IVector2 clampComponents(double min, double max);

	public IVector2 rotateRad(double angleRad);
	public IVector2 rotateDeg(double angleDeg);
	
	public IVector2 project(IVector2 vec);
	public IVector2 reflect();
	public IVector2 refract();

	public IVector2 copy();
	
}







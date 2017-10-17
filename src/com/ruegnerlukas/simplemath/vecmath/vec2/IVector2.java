package com.ruegnerlukas.simplemath.vecmath.vec2;

import com.ruegnerlukas.simplemath.vecmath.IVector;


public interface IVector2 extends IVector {

	

	
	// setter
	public IVector2 set(IVector2 v);
	public IVector2 set(Number x, Number y);
	public IVector2 set(Number xy);




	// getter
	public short getShortX();
	public short getShortY();
	public int getIntX();
	public int getIntY();
	public long getLongX();
	public long getLongY();
	public float getFloatX();
	public float getFloatY();
	public double getDoubleX();
	public double getDoubleY();




	// conversion
	public Vector2s toShortVector();
	public Vector2i toIntVector();
	public Vector2l toLongVector();
	public Vector2f toFloatVector();
	public Vector2d toDoubleVector();
	@Override public String toString();
	
	
	
	// operations
	public IVector2 add(IVector2 vec);
	public IVector2 add(Number n);

	public IVector2 sub(IVector2 vec);
	public IVector2 sub(Number n);

	public IVector2 mul(IVector2 vec);
	public IVector2 scale(Number n);

	public IVector2 div(IVector2 vec);
	public IVector2 div(Number n);

	
	public Number crossGen(IVector2 vec);
	public Number crossGen(Number x, Number y);

	public Number dotGen(IVector2 vec);
	public Number dotGen(Number x, Number y);
	
	
	public Number dist2Gen(IVector2 vec);
	public Number dist2Gen(Number x, Number y);

	public Number distGen(IVector2 vec);
	public Number distGen(Number x, Number y);
	
	
	public Number length2Gen();
	public Number lengthGen();
	
	public IVector2 setLength(Number length);
	public IVector2 limitLength(Number maxLength);
	public IVector2 clampLenght(Number minLength, Number maxLength);

	
	public Number angleRadGen(IVector2 vec);
	public Number angleRadGen(Number x, Number y);
	
	public Number angleDegGen(IVector2 vec);
	public Number angleDegGen(Number x, Number y);
	
	public IVector2 rotateRad(Number angleRad);
	public IVector2 rotateDeg(Number angleDeg);

	public IVector2 project(IVector2 vec);
	public IVector2 reflect(IVector2 n);
	public IVector2 refract(IVector2 n, float eta);
	
	public Number componentSumGen();
	public Number componentMinGen();
	public Number componentMaxGen();
	public IVector2 clampComponents(Number min, Number max);
	
	
}






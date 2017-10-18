package com.ruegnerlukas.simplemath.vecmath.vec2;

import com.ruegnerlukas.simplemath.vecmath.IVector;


public interface IVector2 extends IVector {

	


	/**
	 * Sets this vector from the given vector.
	 * @param v the vector
	 * @return this vector for chaining
	 * */
	public IVector2 set(IVector2 v);
	
	/**
	 * Sets the components of this vector.
	 * @param x the value of the x-component
	 * @param y the value of the y-component
	 * @return this vector for chaining
	 * */
	public IVector2 set(Number x, Number y);
	
	/**
	 * Sets the components of this vector.
	 * @param xy the value of the x- and y-component
	 * @return this vector for chaining
	 * */
	public IVector2 set(Number xy);




	/**  @return the x-component as an integer **/
	public int getIntX();
	
	/**  @return the y-component as an integer **/
	public int getIntY();
	
	/**  @return the x-component as a long **/
	public long getLongX();
	
	/**  @return the y-component as a long **/
	public long getLongY();
	
	/**  @return the x-component as a float **/
	public float getFloatX();
	
	/**  @return the y-component as a float **/
	public float getFloatY();
	
	/**  @return the x-component as a double **/
	public double getDoubleX();
	
	/**  @return the y-component as a doubld **/
	public double getDoubleY();
	


	
	/**
	 * Converts this vector to an integer vector.
	 * @return the created integer vector
	 * */
	public Vector2i toIntVector();
	
	/**
	 * Converts this vector to a long vector.
	 * @return the created long vector
	 * */
	public Vector2l toLongVector();
	
	/**
	 * Converts this vector to a float vector.
	 * @return the created float vector
	 * */
	public Vector2f toFloatVector();
	
	/**
	 * Converts this vector to a double vector.
	 * @return the created double vector
	 * */
	public Vector2d toDoubleVector();
	
	
	
	
	/**
	 * Adds the given vector to this vector.
	 * @param vec the vector
	 * @return this vector for chaining
	 * */
	public IVector2 add(IVector2 vec);
	
	/**
	 * Adds the given components to this vector.
	 * @param x the x-component
	 * @param y the y-component
	 * @return this vector for chaining
	 * */
	public IVector2 add(Number x, Number y);
	
	/**
	 * Adds the given component to this vector.
	 * @param xy the x- and y-component
	 * @return this vector for chaining
	 * */
	public IVector2 add(Number xy);

	
	/**
	 * Subtracts the given vector from this vector.
	 * @param vec the vector
	 * @return this vector for chaining
	 * */
	public IVector2 sub(IVector2 vec);
	
	/**
	 * Subtracts the given components to this vector.
	 * @param x the x-component
	 * @param y the y-component
	 * @return this vector for chaining
	 * */
	public IVector2 sub(Number x, Number y);
	
	/**
	 * Subtracts the given component to this vector.
	 * @param xy the x- and y-component
	 * @return this vector for chaining
	 * */
	public IVector2 sub(Number xy);

	
	/**
	 * Multiplies this vector with the given vector (component-wise).
	 * @param vec the vector
	 * @return this vector for chaining
	 * */
	public IVector2 mul(IVector2 vec);
	
	/**
	 * Multiplies this vector with the given components (component-wise).
	 * @param x the x-component
	 * @param y the y-component
	 * @return this vector for chaining
	 * */
	public IVector2 mul(Number x, Number y);
	
	/**
	 * Scales this vector by the given scalar.
	 * @param xy the scalar
	 * @return this vector for chaining
	 * */
	public IVector2 scale(Number xy);

	
	/**
	 * Divides this vector by the given vector (component-wise).
	 * @param vec the vector
	 * @return this vector for chaining
	 * */
	public IVector2 div(IVector2 vec);
	
	/**
	 * Divides this vector by the given components (component-wise).
	 * @param x the x-component
	 * @param y the y-component
	 * @return this vector for chaining
	 * */
	public IVector2 div(Number x, Number y);
	
	/**
	 * Divides this vector by the given component (component-wise).
	 * @param xy the x- and y-component
	 * @return this vector for chaining
	 * */
	public IVector2 div(Number xy);

	
	/**
	 * Calculates the cross product between this vector and the given vector.
	 * @param vec the vector
	 * @return the result as a {@link java.lang.Number}
	 * */
	public Number crossGen(IVector2 vec);
	
	/**
	 * Calculates the cross product between this vector and the given vector-components.
	 * @param vec the vector
	 * @return the result as a {@link java.lang.Number}
	 * */
	public Number crossGen(Number x, Number y);

	
	/**
	 * Calculates the dot product between this vector and the given vector.
	 * @param vec the vector
	 * @return the result as a {@link java.lang.Number}
	 * */
	public Number dotGen(IVector2 vec);
	
	/**
	 * Calculates the dot product between this vector and the given vector-components.
	 * @param vec the vector
	 * @return the result as a {@link java.lang.Number}
	 * */
	public Number dotGen(Number x, Number y);
	
	
	/**
	 * Calculates the squared distance between this vector and the given vector.
	 * @param vec the vector
	 * @return the result as a {@link java.lang.Number}
	 * */
	public Number dist2Gen(IVector2 vec);
	
	/**
	 * Calculates the squared distance between this vector and the given position.
	 * @param x the x-position
	 * @param y the y-position
	 * @return the result as a {@link java.lang.Number}
	 * */
	public Number dist2Gen(Number x, Number y);
	

	/**
	 * Calculates the distance between this vector and the given vector.
	 * @param vec the vector
	 * @return the result as a {@link java.lang.Number}
	 * */
	public Number distGen(IVector2 vec);
	
	/**
	 * Calculates the distance between this vector and the given position.
	 * @param x the x-position
	 * @param y the y-position
	 * @return the result as a {@link java.lang.Number}
	 * */
	public Number distGen(Number x, Number y);
	
	
	/**
	 * Calculates the squared length of this vector.
	 * @return the result as a {@link java.lang.Number}
	 * */
	public Number length2Gen();
	
	/**
	 * Calculates the length of this vector.
	 * @return the result as a {@link java.lang.Number}
	 * */
	public Number lengthGen();
	
	/**
	 * Sets the length of this vector.
	 * @param length the new length
	 * @return this vector for chaining
	 * */
	public IVector2 setLength(Number length);
	
	/**
	 * Limits the length of this vector to the given maximum length.
	 * @param maxLength the maximum length
	 * @return this vector for chaining
	 * */
	public IVector2 limitLength(Number maxLength);
	
	/**
	 * Limits the length of this vector to the given minimum and maximum length.
	 * @param minLength the minimum length
	 * @param maxLength the maximum length
	 * @return this vector for chaining
	 * */
	public IVector2 clampLenght(Number minLength, Number maxLength);

	
	/**
	 * Calculates the angle between this vector and the given vector in radians.
	 * @param vec the vector
	 * @return the result as a {@link java.lang.Number}
	 * */
	public Number angleRadGen(IVector2 vec);
	
	/**
	 * Calculates the angle between this vector and the given vector in degrees.
	 * @param x the x-component of the vector
	 * @param y the y-component of the vector
	 * @return the result as a {@link java.lang.Number}
	 * */
	public Number angleRadGen(Number x, Number y);
	
	
	/**
	 * Calculates the angle between this vector and the given vector in degrees.
	 * @param vec the vector
	 * @return the result as a {@link java.lang.Number}
	 * */
	public Number angleDegGen(IVector2 vec);
	
	/**
	 * Calculates the angle between this vector and the given vector in degrees.
	 * @param x the x-component of the vector
	 * @param y the y-component of the vector
	 * @return the result as a {@link java.lang.Number}
	 * */
	public Number angleDegGen(Number x, Number y);
	
	
	/**
	 * Rotates this vector by the given angle in radians.
	 * @param angleRad the angle in radians
	 * @return this vector for chaining
	 * */
	public IVector2 rotateRad(Number angleRad);
	
	/**
	 * Rotates this vector by the given angle in degrees.
	 * @param angleRad the angle in degrees
	 * @return this vector for chaining
	 * */
	public IVector2 rotateDeg(Number angleDeg);

	
	/**
	 * Projects this vector on the given vector.
	 * @param vec the vector
	 * @return this vector for chaining
	 * */
	public IVector2 project(IVector2 vec);
	
	/**
	 * Reflects this vector at the given vector
	 * @param vec the (normal) vector. Should be normalized before.
	 * @return this vector for chaining
	 * */
	public IVector2 reflect(IVector2 vec);
	
	/**
	 * Refracts this vector at the given vector
	 * @param vec the (normal) vector. Should be normalized before.
	 * @param eta the ratio of indices of refraction
	 * @return this vector for chaining
	 * */
	public IVector2 refract(IVector2 vec, float eta);
	
	/**
	 * Calculates the sum of the components.
	 * @return the result as a {@link java.lang.Number}
	 * */
	public Number componentSumGen();
	
	/**
	 * Calculates the smallest component.
	 * @return the result as a {@link java.lang.Number}
	 * */
	public Number componentMinGen();
	
	/**
	 * Calculates the biggest component.
	 * @return the result as a {@link java.lang.Number}
	 * */
	public Number componentMaxGen();
	
	/**
	 * Clamps the components between the given minimum and maximum values.
	 * @param min the minimum value
	 * @param max the maximum value
	 * @return the result as a {@link java.lang.Number}
	 * */
	public IVector2 clampComponents(Number min, Number max);
	
	
	
	
	/**
	 * Compares this vector with the given vector.
	 * @return true, if the two vectors are the same
	 * */
	public boolean compare(IVector2 vec);
	
	
	
	/**
	 * @return true, if this vector has a length of 1
	 * */
	public boolean isUnit();
	
	
	/**
	 * @return true, if all components of this vector are zero
	 * */
	public boolean isZero();
	
	
	/**
	 * @return true, if this vector is perpendicular with the given vector
	 * */
	public boolean isPerpendicular(IVector2 vec);
	
	
	
}






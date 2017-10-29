package com.ruegnerlukas.simplemath.vectors.vec3;

import com.ruegnerlukas.simplemath.matrix.IMatrix;
import com.ruegnerlukas.simplemath.vectors.IVector;
import com.ruegnerlukas.simplemath.vectors.Quaternion;


public interface IVector3 extends IVector {

	


	/**
	 * Sets this vector from the given vector.
	 * @param v the vector
	 * @return this vector for chaining
	 * */
	public IVector3 set(IVector3 v);
	
	/**
	 * Sets the components of this vector.
	 * @param x the value of the x-component
	 * @param y the value of the y-component
	 * @param z the value of the z-component
	 * @return this vector for chaining
	 * */
	public IVector3 set(Number x, Number y, Number z);
	
	/**
	 * Sets the components of this vector.
	 * @param xyz the value of the x-, y- and z-component
	 * @return this vector for chaining
	 * */
	public IVector3 set(Number xyz);




	/**  @return the x-component as an integer **/
	public int getIntX();
	
	/**  @return the y-component as an integer **/
	public int getIntY();
	
	/**  @return the z-component as an integer **/
	public int getIntZ();
	
	/**  @return the x-component as a long **/
	public long getLongX();
	
	/**  @return the y-component as a long **/
	public long getLongY();
	
	/**  @return the z-component as a long **/
	public long getLongZ();
	
	/**  @return the x-component as a float **/
	public float getFloatX();
	
	/**  @return the y-component as a float **/
	public float getFloatY();
	
	/**  @return the z-component as a float **/
	public float getFloatZ();
	
	/**  @return the x-component as a double **/
	public double getDoubleX();
	
	/**  @return the y-component as a doubld **/
	public double getDoubleY();
	
	/**  @return the z-component as a doubld **/
	public double getDoubleZ();


	
	/**
	 * Converts this vector to an integer vector.
	 * @return the created integer vector
	 * */
	public Vector3i toIntVector();
	
	/**
	 * Converts this vector to a long vector.
	 * @return the created long vector
	 * */
	public Vector3l toLongVector();
	
	/**
	 * Converts this vector to a float vector.
	 * @return the created float vector
	 * */
	public Vector3f toFloatVector();
	
	/**
	 * Converts this vector to a double vector.
	 * @return the created double vector
	 * */
	public Vector3d toDoubleVector();
	
	
	
	
	/**
	 * Adds the given vector to this vector.
	 * @param vec the vector
	 * @return this vector for chaining
	 * */
	public IVector3 add(IVector3 vec);
	
	/**
	 * Adds the given components to this vector.
	 * @param x the x-component
	 * @param y the y-component
	 * @param z the z-component
	 * @return this vector for chaining
	 * */
	public IVector3 add(Number x, Number y, Number z);
	
	/**
	 * Adds the given component to this vector.
	 * @param xyz the x-, y- and z-component
	 * @return this vector for chaining
	 * */
	public IVector3 add(Number xyz);

	
	/**
	 * Subtracts the given vector from this vector.
	 * @param vec the vector
	 * @return this vector for chaining
	 * */
	public IVector3 sub(IVector3 vec);
	
	/**
	 * Subtracts the given components to this vector.
	 * @param x the x-component
	 * @param y the y-component
	 * @param z the z-component
	 * @return this vector for chaining
	 * */
	public IVector3 sub(Number x, Number y, Number z);
	
	/**
	 * Subtracts the given component to this vector.
	 * @param xyz the x-, y- and z-component
	 * @return this vector for chaining
	 * */
	public IVector3 sub(Number xyz);

	
	/**
	 * Multiplies this vector with the given vector (component-wise).
	 * @param vec the vector
	 * @return this vector for chaining
	 * */
	public IVector3 mul(IVector3 vec);
	
	/**
	 * Multiplies this vector with the given components (component-wise).
	 * @param x the x-component
	 * @param y the y-component
	 * @param z the z-component
	 * @return this vector for chaining
	 * */
	public IVector3 mul(Number x, Number y, Number z);
	
	
	/**
	 * Scales this vector by the given scalar.
	 * @param xyz the scalar
	 * @return this vector for chaining
	 * */
	public IVector3 scale(Number xyz);

	
	/**
	 * Multiplies this vector with the given matrix.
	 * @param mat the matrix
	 * @return this vector for chaining
	 * */
	public IVector3 mul(IMatrix mat);
	
	
	/**
	 * Multiplies this vector with the given quaternion.
	 * @param q the quaternion
	 * @return this vector for chaining
	 * */
	public IVector3 mul(Quaternion q);
	
	
	/**
	 * Divides this vector by the given vector (component-wise).
	 * @param vec the vector
	 * @return this vector for chaining
	 * */
	public IVector3 div(IVector3 vec);
	
	/**
	 * Divides this vector by the given components (component-wise).
	 * @param x the x-component
	 * @param y the y-component
	 * @param z the z-component
	 * @return this vector for chaining
	 * */
	public IVector3 div(Number x, Number y, Number z);
	
	/**
	 * Divides this vector by the given component (component-wise).
	 * @param xyz the x-, y- and z-component
	 * @return this vector for chaining
	 * */
	public IVector3 div(Number xyz);

	
	/**
	 * Calculates the cross product between this vector and the given vector.
	 * @param vec the vector
	 * @return this vector for chaining
	 * */
	public IVector3 crossSetGen(IVector3 vec);
	
	/**
	 * Calculates the cross product between this vector and the given vector-components.
	 * @param x the x-component
	 * @param y the y-component
	 * @param z the z-component
	 * @return this vector for chaining
	 * */
	public IVector3 crossSetGen(Number x, Number y, Number z);

	/**
	 * Calculates the cross product between this vector and the given vector.
	 * @param vec the vector
	 * @return the result as a new vector
	 * */
	public IVector3 crossGen(IVector3 vec);
	
	/**
	 * Calculates the cross product between this vector and the given vector-components.
	 * @param x the x-component
	 * @param y the y-component
	 * @param z the z-component
	 * @return the result as a new vector
	 * */
	public IVector3 crossGen(Number x, Number y, Number z);
	
	
	/**
	 * Calculates the dot product between this vector and the given vector.
	 * @param vec the vector
	 * @return the result as a {@link java.lang.Number}
	 * */
	public Number dotGen(IVector3 vec);
	
	/**
	 * Calculates the dot product between this vector and the given vector-components.
	 * @param x the x-component
	 * @param y the y-component
	 * @param z the z-component
	 * @return the result as a {@link java.lang.Number}
	 * */
	public Number dotGen(Number x, Number y, Number z);
	
	
	/**
	 * Calculates the squared distance between this vector and the given vector.
	 * @param vec the vector
	 * @return the result as a {@link java.lang.Number}
	 * */
	public Number dist2Gen(IVector3 vec);
	
	/**
	 * Calculates the squared distance between this vector and the given position.
	 * @param x the x-position
	 * @param y the y-position
	 * @param z the z-position
	 * @return the result as a {@link java.lang.Number}
	 * */
	public Number dist2Gen(Number x, Number y, Number z);
	

	/**
	 * Calculates the distance between this vector and the given vector.
	 * @param vec the vector
	 * @return the result as a {@link java.lang.Number}
	 * */
	public Number distGen(IVector3 vec);
	
	/**
	 * Calculates the distance between this vector and the given position.
	 * @param x the x-position
	 * @param y the y-position
	 * @param z the z-position
	 * @return the result as a {@link java.lang.Number}
	 * */
	public Number distGen(Number x, Number y, Number z);

	
	/**
	 * Calculates the angle between this vector and the given vector in radians. Both vectors should be normalized before.
	 * @param vec the vector
	 * @return the result as a {@link java.lang.Number}
	 * */
	public Number angleRadGen(IVector3 vec);
	
	/**
	 * Calculates the angle between this vector and the given vector in radians. Both vectors should be normalized before.
	 * @param x the x-component of the vector
	 * @param y the y-component of the vector
	 * @param z the z-component of the vector
	 * @return the result as a {@link java.lang.Number}
	 * */
	public Number angleRadGen(Number x, Number y, Number z);
	
	
	/**
	 * Calculates the angle between this vector and the given vector in degrees. Both vectors should be normalized before.
	 * @param vec the vector
	 * @return the result as a {@link java.lang.Number}
	 * */
	public Number angleDegGen(IVector3 vec);
	
	/**
	 * Calculates the angle between this vector and the given vector in degrees. Both vectors should be normalized before.
	 * @param x the x-component of the vector
	 * @param y the y-component of the vector
	 * @param z the z-component of the vector
	 * @return the result as a {@link java.lang.Number}
	 * */
	public Number angleDegGen(Number x, Number y, Number z);
	
	
	/**
	 * Projects this vector on the given vector.
	 * @param vec the vector
	 * @return this vector for chaining
	 * */
	public IVector3 project(IVector3 vec);
	
	/**
	 * Reflects this vector at the given vector
	 * @param vec the (normal) vector. Should be normalized before.
	 * @return this vector for chaining
	 * */
	public IVector3 reflect(IVector3 vec);
	
	/**
	 * Refracts this vector at the given vector
	 * @param vec the (normal) vector. Should be normalized before.
	 * @param eta the ratio of indices of refraction
	 * @return this vector for chaining
	 * */
	public IVector3 refract(IVector3 vec, float eta);
	
	
	
	
	/**
	 * Compares this vector with the given vector.
	 * @return true, if the two vectors are the same
	 * */
	public boolean compare(IVector3 vec);
	
	
	/**
	 * @return true, if this vector is perpendicular with the given vector
	 * */
	public boolean isPerpendicular(IVector3 vec);
	
	
	
}

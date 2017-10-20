package com.ruegnerlukas.simplemath.vecmath.vecN;

import com.ruegnerlukas.simplemath.vecmath.IVector;


public interface IVectorN extends IVector {

	


	/**
	 * Sets this vector from the given vector with the same size.
	 * @param v the vector
	 * @return this vector for chaining
	 * */
	public IVectorN set(IVectorN v);
	
	/**
	 * Sets the components of this vector.
	 * @param a a list of values. The list must have the same size as this vector or the size 1
	 * @return this vector for chaining
	 * */
	public IVectorN setGen(Number... a);


	

	/**
	 * Converts this vector to an integer vector.
	 * @return the created integer vector
	 * */
	public VectorNi toIntVector();
	
	/**
	 * Converts this vector to a long vector.
	 * @return the created long vector
	 * */
	public VectorNl toLongVector();
	
	/**
	 * Converts this vector to a float vector.
	 * @return the created float vector
	 * */
	public VectorNf toFloatVector();
	
	/**
	 * Converts this vector to a double vector.
	 * @return the created double vector
	 * */
	public VectorNd toDoubleVector();
	
	
	
	
	/**
	 * Adds the given vector to this vector.
	 * @param vec the vector with the same size as this vector
	 * @return this vector for chaining
	 * */
	public IVectorN add(IVectorN vec);
	
	/**
	 * Adds the given values to this vector.
	 * @param values the list of values. The list must have the same size as this vector or the size 1
	 * @return this vector for chaining
	 * */
	public IVectorN addGen(Number... values);

	
	/**
	 * Subtracts the given vector from this vector.
	 * @param vec the vector with the same size as this vector
	 * @return this vector for chaining
	 * */
	public IVectorN sub(IVectorN vec);
	
	/**
	 * Subtracts the given values from this vector.
	 * @param values the list of values. The list must have the same size as this vector or the size 1
	 * @return this vector for chaining
	 * */
	public IVectorN subGen(Number... values);

	
	/**
	 * Multiplies this vector with the given vector.
	 * @param vec the vector with the same size as this vector
	 * @return this vector for chaining
	 * */
	public IVectorN mul(IVectorN vec);
	
	/**
	 * Multiplies this vector with the given values (component-wise).
	 * @param values the list of values. The list must have the same size as this vector or the size 1
	 * @return this vector for chaining
	 * */
	public IVectorN mulGen(Number... values);

	
	/**
	 * Divides this vector by the given vector (component-wise).
	 * @param vec the vector with the same size as this vector.
	 * @return this vector for chaining
	 * */
	public IVectorN div(IVectorN vec);
	
	/**
	 * Divides this vector by the given values (component-wise).
	 * @param values the list of values. The list must have the same size as this vector or the size 1
	 * @return this vector for chaining
	 * */
	public IVectorN divGen(Number... values);

	
	/**
	 * Calculates the dot product between this vector and the given vector with the same size.
	 * @param vec the vector the same size as this vector.
	 * @return the result as a {@link java.lang.Number}
	 * */
	public Number dotGen(IVectorN vec);
	
	/**
	 * Calculates the dot product between this vector and the given vector-components.
	 * @param values the list of values. The list must have the same size as this vector.
	 * @return the result as a {@link java.lang.Number}
	 * */
	public Number dotGen(Number... values);
	
	
	/**
	 * Calculates the squared distance between this vector and the given vector.
	 * @param vec the vector with the same size as this vector
	 * @return the result as a {@link java.lang.Number}
	 * */
	public Number dist2Gen(IVectorN vec);
	
	/**
	 * Calculates the squared distance between this vector and the given position.
	 * @param pos the list of values for the position. The list must have the same size as this vector.
	 * @return the result as a {@link java.lang.Number}
	 * */
	public Number dist2Gen(Number... pos);
	

	/**
	 * Calculates the distance between this vector and the given vector.
	 * @param vec the vector with the same size as this vector
	 * @return the result as a {@link java.lang.Number}
	 * */
	public Number distGen(IVectorN vec);
	
	/**
	 * Calculates the distance between this vector and the given position.
	 * @param pos the list of values for the position. The list must have the same size as this vector.
	 * @return the result as a {@link java.lang.Number}
	 * */
	public Number distGen(Number... pos);
	
	
	
	
	/**
	 * Compares this vector with the given vector.
	 * @return true, if the two vectors are the same
	 * */
	public boolean compare(IVectorN vec);
	
	
	
}

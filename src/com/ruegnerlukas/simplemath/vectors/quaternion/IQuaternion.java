package com.ruegnerlukas.simplemath.vectors.quaternion;

import com.ruegnerlukas.simplemath.matrix.IMatrix;
import com.ruegnerlukas.simplemath.vectors.vec3.IVector3;
import com.ruegnerlukas.simplemath.vectors.vec4.IVector4;

public interface IQuaternion extends IVector4 {

	
	/**
	 * Sets this quanternion from the given quanternion.
	 * @param q the quanternion
	 * @return this quanternion for chaining
	 * */
	public IQuaternion set(IQuaternion q);
	
	
	/**
	 * Sets this quaternion to an identity
	 * @return this quaternion for chaining
	 * */
	public IQuaternion setToIdentity();
	
	
	/**
	 * Multiplies this quaternion with the gigen quanternion (this = this*other)
	 * @param q the right Quaternion
	 * @return this quaternion for chaining
	 * */
	public IQuaternion mul(IQuaternion q);
	
	
	/**
	 * Multiplies this quaternion with the given quanternion (this = other*this)
	 * @param q the left Quaternion
	 * @return this quaternion for chaining
	 * */
	public IQuaternion mulLeft(IQuaternion q);
	
	
	/**
	 * Sets this value of this quaternion to the to the equivalent rotation of the Axis-Angle argument.
	 * @param vec the axis-angle. x,y,z as the axis and w as the angle in degrees
	 * @return this quaternion for chaining
	 * */
	public IQuaternion setFromAxisAngleDeg(IVector4 vec);
	
	
	/**
	 * Sets this value of this quaternion to the to the equivalent rotation of the Axis-Angle argument.
	 * @param vec the axis-angle. x,y,z as the axis and w as the angle in radians
	 * @return this quaternion for chaining
	 * */
	public IQuaternion setFromAxisAngleRad(IVector4 vec);
	
	
	/**
	 * Sets the component of this quaternion from the given matrix
	 * @param mat the (rotation) matrix. Must be at least 3x3
	 * @return this quaternion for chaining
	 * */
	public IQuaternion setFromMatrix(IMatrix mat);
	
	
	/**
	 * Sets this quaternion from the given euler angles
	 * @param angles the euler angles (yaw, pitch, roll) in degrees
	 * @return this quaternion for chaining
	 * */
	public IQuaternion setFromEulerDeg(IVector3 angles);
	
	
	/**
	 * Sets this quaternion from the given euler angles
	 * @param angles the euler angles (yaw, pitch, roll) in radians
	 * @return this quaternion for chaining
	 * */
	public IQuaternion setFromEulerRad(IVector3 angles);

	
	/**
	 * Creates a vector3f which represents the x axis of this quaternion
	 * @return the x axis as the created vector
	 * */
	public IVector3 getXAxis();
	
	
	/**
	 * Sets the distination vector to the x axis of this quaternion
	 * @param dest the destination vector or null
	 * @return the x axis as the given vector
	 * */
	public IVector3 getXAxis(IVector3 dest);
	
	
	/**
	 * Creates a vector3f which represents the y axis of this quaternion
	 * @return the y axis as the created vector
	 * */
	public IVector3 getYAxis();
	
	
	/**
	 * Sets the distination vector to the y axis of this quaternion
	 * @param dest the destination vector or null
	 * @return the y axis as the given vector
	 * */
	public IVector3 getYAxis(IVector3 dest);
	
	
	
	/**
	 * Creates a vector3f which represents the z axis of this quaternion
	 * @return the z axis as the created vector
	 * */
	public IVector3 getZAxis();
	
	
	/**
	 * Sets the destination vector to the z axis of this quaternion
	 * @param dest the destination vector or null
	 * @return the z axis as the given vector
	 * */
	public IVector3 getZAxis(IVector3 dest);

	
	/**
	 * Get the pole of the gimbal lock. This quaternion must be normalized.
	 * @return +1 for north pole, -1 for south pole, 0 for no gimbal lock
	 * */
	public int getGimbalPole();
	
	
	/**
	 * Gets the yaw, pitch and roll angle in degrees as a vector. This quaternion must be normalized.
	 * @return the vector representing the rotation in degrees of this quaternion
	 * */
	public IVector3 getRotationDeg();
	
	
	/**
	 * Gets the yaw, pitch and roll angle in radians as a vector. This quaternion must be normalized.
	 * @return the vector representing the rotation in radians of this quaternion
	 * */
	public IVector3 getRotationRad();

	
	/**
	 * Creates a new matrix representing this quaternion. This quaternion must be normalized.
	 * @return the created matrix representing this quaternion.
	 * */
	public IMatrix toRotationMatrix();
	
}

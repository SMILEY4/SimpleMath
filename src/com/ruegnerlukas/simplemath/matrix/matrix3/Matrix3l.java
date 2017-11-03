package com.ruegnerlukas.simplemath.matrix.matrix3;

import com.ruegnerlukas.simplemath.matrix.IMatrix;
import com.ruegnerlukas.simplemath.matrix.matrixN.Matrixl;
import com.ruegnerlukas.simplemath.vectors.vec2.IVector2;
import com.ruegnerlukas.simplemath.vectors.vec2.Vector2l;
import com.ruegnerlukas.simplemath.vectors.vec3.IVector3;

public class Matrix3l extends Matrixl {

	
	/**
	 * Creates a 3x3 matrix with the given values
	 * */
	public Matrix3l(	long m00, long m10, long m20,
						long m01, long m11, long m21,
						long m02, long m12, long m22) {
		super(3, 3);
		this.setUnsafe(true);
		this.set(0, 0, m00).set(1, 0, m10).set(2, 0, m20);
		this.set(0, 1, m01).set(1, 1, m11).set(2, 1, m21);
		this.set(0, 2, m02).set(1, 2, m12).set(2, 2, m22);
		this.setUnsafe(false);
	}
	
	
	/**
	 * Creates a 3x3 matrix with the given values
	 * */
	public Matrix3l(long[][] data) {
		super(3, 3);
		if(data.length != 3 && data[0].length != 3) {
			throw new IllegalArgumentException("Invalid input array size: " + data.length + "," +data[0].length + ".");
		}
		super.set(data);
	}
	
	
	public Matrix3l() {
		super(3, 3);
	}
	
	
	
	
	
	
	@Override
	public Matrix3l add(IMatrix mat) {
		if(!isUnsafe() && !compareSize(mat)) {
			throw new IllegalArgumentException("Input matrix size invalid: " + mat.getNumberColumns() + "," + mat.getNumberRows()
			+ ". Should be " + this.getNumberColumns() + "," + this.getNumberRows());
		}
		this.getData()[0][0] += mat.getLong(0, 0);
		this.getData()[0][1] += mat.getLong(0, 1);
		this.getData()[0][2] += mat.getLong(0, 2);
		this.getData()[1][0] += mat.getLong(1, 0);
		this.getData()[1][1] += mat.getLong(1, 1);
		this.getData()[1][2] += mat.getLong(1, 2);
		this.getData()[2][0] += mat.getLong(2, 0);
		this.getData()[2][1] += mat.getLong(2, 1);
		this.getData()[2][2] += mat.getLong(2, 2);
		return this;
	}
	
	
	
	
	@Override
	public Matrix3l sub(IMatrix mat) {
		if(!isUnsafe() && !compareSize(mat)) {
			throw new IllegalArgumentException("Input matrix size invalid: " + mat.getNumberColumns() + "," + mat.getNumberRows()
			+ ". Should be " + this.getNumberColumns() + "," + this.getNumberRows());
		}
		this.getData()[0][0] -= mat.getLong(0, 0);
		this.getData()[0][1] -= mat.getLong(0, 1);
		this.getData()[0][2] -= mat.getLong(0, 2);
		this.getData()[1][0] -= mat.getLong(1, 0);
		this.getData()[1][1] -= mat.getLong(1, 1);
		this.getData()[1][2] -= mat.getLong(1, 2);
		this.getData()[2][0] -= mat.getLong(2, 0);
		this.getData()[2][1] -= mat.getLong(2, 1);
		this.getData()[2][2] -= mat.getLong(2, 2);
		return this;
	}
	
	
	
	
	@Override
	public Matrix3l mul(double scalar) {
		this.getData()[0][0] *= scalar;
		this.getData()[0][1] *= scalar;
		this.getData()[0][2] *= scalar;
		this.getData()[1][0] *= scalar;
		this.getData()[1][1] *= scalar;
		this.getData()[1][2] *= scalar;
		this.getData()[2][0] *= scalar;
		this.getData()[2][1] *= scalar;
		this.getData()[2][2] *= scalar;
		return this;
	}
	
	
	
	
	@Override
	public boolean isSquare() {
		return true;
	}
	
	
	
	/**
	 * Applies the given (counter-clockwise) rotation to this matrix
	 * @param angleDeg the angle in degrees
	 * @return this matrix for chaining
	 * */
	public Matrix3l rotateDeg(double angleDeg) {
		return this.rotateRad(Math.toRadians(angleDeg));
	}
	
	
	/**
	 * Applies the given (counter-clockwise) rotation to this matrix
	 * @param angleRad the angle in radians
	 * @return this matrix for chaining
	 * */
	public Matrix3l rotateRad(double angleRad) {

		final double cos = Math.cos(angleRad);
		final double sin = Math.sin(angleRad);
		final double invCos = 1.0 - cos;
		
		final double zsin = sin;

		final double f00 = cos;
		final double f01 = zsin;
		
		final double f10 = -zsin;
		final double f11 = cos;
		
		final double f22 = invCos + cos;
		
		final double t00 = getData()[0][0] * f00 + getData()[1][0] * f01;
		final double t01 = getData()[0][1] * f00 + getData()[1][1] * f01;
		final double t02 = getData()[0][2] * f00 + getData()[1][2] * f01;
		
		final double t10 = getData()[0][0] * f10 + getData()[1][0] * f11;
		final double t11 = getData()[0][1] * f10 + getData()[1][1] * f11;
		final double t12 = getData()[0][2] * f10 + getData()[1][2] * f11;
		
		final double t20 = getData()[2][0] * f22;
		final double t21 = getData()[2][1] * f22;
		final double t22 = getData()[2][2] * f22;
		
		getData()[0][0] = (long) t00;
		getData()[0][1] = (long) t01;
		getData()[0][2] = (long) t02;

		getData()[1][0] = (long) t10;
		getData()[1][1] = (long) t11;
		getData()[1][2] = (long) t12;
		
		getData()[2][0] = (long) t20;
		getData()[2][1] = (long) t21;
		getData()[2][2] = (long) t22;
		
		return this;
	}
	
	
	
	
	/**
	 * Adds a translational component to this matrix in the third column. Other columns are untuched.
	 * @param vec the translation vector
	 * @return this matrix for chaining
	 * */
	public Matrix3l translate(IVector2 vec) {
		return this.translate(vec.getLongX(), vec.getLongY());
	}
	
	
	/**
	 * Translate this matrix.
	 * @param x the x component to translate by
	 * @param y the y component to translate by
	 * @return this matrix for chaining
	 * */
	public Matrix3l translate(long x, long y) {
		getData()[2][0] += getData()[0][0]*x + getData()[1][0]*y;
		getData()[2][1] += getData()[0][1]*x + getData()[1][1]*y;
		getData()[2][2] += getData()[0][2]*x + getData()[1][2]*y;
		return this;
	}
	
	
	
	
	/**
	 * Scales this matrix.
	 * @param vec the vector to scale by
	 * @return this matrix for chaining
	 * */
	public Matrix3l scale(IVector2 vec) {
		return this.scale(vec.getDoubleX(), vec.getDoubleY());
	}
	
	
	/**
	 * Scales this matrix.
	 * @param x the x component to scale by
	 * @param y the y component to scale by
	 * @return this matrix for chaining
	 * */
	public Matrix3l scale(double x, double y) {
		for(int i=0; i<3; i++) {
			getData()[i][0] *= x;
			getData()[i][1] *= y;
		}
		return this;
	}
	
	
	
	
	@Override
	public Matrix3l setToIdentity() {
		return (Matrix3l) super.setToIdentity();
	}
	
	
	
	
	/**
	 * Sets this matrix to a rotation matrix (rotates counter-clockwise around z-axis)
	 * @param angleDeg the angle in degrees
	 * @return this matrix for chaining
	 * */
	public Matrix3l setToRotationDeg(double angleDeg) {
		return this.setToRotationRad(Math.toRadians(angleDeg));
	}
	
	
	/**
	 * Sets this matrix to a rotation matrix (rotates counter-clockwise around z-axis)
	 * @param angleRad the angle in radians
	 * @return this matrix for chaining
	 * */
	public Matrix3l setToRotationRad(double angleRad) {
		
		final long cos = (long) Math.cos(angleRad);
		final long sin = (long) Math.sin(angleRad);
		
		this.getData()[0][0] = cos;
		this.getData()[0][1] = sin;
		this.getData()[0][2] = 0;

		this.getData()[1][0] = -sin;
		this.getData()[1][1] = cos;
		this.getData()[1][2] = 0;
		
		this.getData()[2][0] = 0;
		this.getData()[2][1] = 0;
		this.getData()[2][2] = 1;
		
		return this;
	}
	
	
	
	
	/**
	 * Sets this matrix to a rotation matrix (rotates counter-clockwise around the given axis)
	 * @param axis the vector representing the axis of rotation
	 * @param angleDeg the angle in degrees
	 * @return this matrix for chaining
	 * */
	public Matrix3l setToRotationDeg(IVector3 axis, double angleDeg) {
		return this.setToRotationRad(axis.getDoubleX(), axis.getDoubleY(), axis.getDoubleZ(), Math.toRadians(angleDeg));
	}
	
	
	/**
	 * Sets this matrix to a rotation matrix (rotates counter-clockwise around the given axis)
	 * @param axisX the x-component of the vector representing the axis of rotation
	 * @param axisY the y-component of the vector representing the axis of rotation
	 * @param axisZ the z-component of the vector representing the axis of rotation
	 * @param angleDeg the angle in degrees
	 * @return this matrix for chaining
	 * */
	public Matrix3l setToRotationDeg(double axisX, double axisY, double axisZ, double angleDeg) {
		return this.setToRotationRad(axisX, axisY, axisZ, Math.toRadians(angleDeg));
	}
	
	
	/**
	 * Sets this matrix to a rotation matrix (rotates counter-clockwise around the given axis)
	 * @param axis the vector representing the axis of rotation
	 * @param angleRad the angle in radians
	 * @return this matrix for chaining
	 * */
	public Matrix3l setToRotationRad(IVector3 axis, double angleRad) {
		return this.setToRotationRad(axis.getDoubleX(), axis.getDoubleY(), axis.getDoubleZ(), angleRad);

	}
	
	
	/**
	 * Sets this matrix to a rotation matrix (rotates counter-clockwise around the given axis)
	 * @param axisX the x-component of the vector representing the axis of rotation
	 * @param axisY the y-component of the vector representing the axis of rotation
	 * @param axisZ the z-component of the vector representing the axis of rotation
	 * @param angleRad the angle in radians
	 * @return this matrix for chaining
	 * */
	public Matrix3l setToRotationRad(double axisX, double axisY, double axisZ, double angleRad) {
		
		final double cos = Math.cos(angleRad);
		final double sin = Math.sin(angleRad);
		final double invCos = 1.0 - cos;
		
		this.getData()[0][0] = (long) (invCos * axisX*axisX + cos);
		this.getData()[0][1] = (long) (invCos * axisX*axisY - axisZ*sin);
		this.getData()[0][2] = (long) (invCos * axisZ*axisX + axisY*sin);

		this.getData()[1][0] = (long) (invCos * axisX*axisY + axisZ*sin);
		this.getData()[1][1] = (long) (invCos * axisY*axisY + cos);
		this.getData()[1][2] = (long) (invCos * axisY*axisZ + - axisX*sin);
		
		this.getData()[2][0] = (long) (invCos * axisZ*axisX - axisY*sin);
		this.getData()[2][1] = (long) (invCos * axisY*axisZ + axisX*sin);
		this.getData()[2][2] = (long) (invCos * axisZ*axisZ + cos);
		
		return this;
	}
	
	
	
	
	/**
	 * Sets this matrix to a translation matrix
	 * @param translation the vector repesenting the translation
	 * @return this matrix for chaining
	 * */
	public Matrix3l setToTranslation(IVector2 translation) {
		return this.setToTranslation(translation.getLongX(), translation.getLongY());
	}
	
	
	/**
	 * Sets this matrix to a translation matrix
	 * @param x the x-component of the translation
	 * @param y the y-component of the translation
	 * @return this matrix for chaining
	 * */
	public Matrix3l setToTranslation(long x, long y) {
		this.setToIdentity();
		this.getData()[2][0] = x;
		this.getData()[2][1] = y;
		return this;
	}
	
	
	
	
	/**
	 * Sets this matrix to a scaling matrix
	 * @param scale the vector repesenting the scaling
	 * @return this matrix for chaining
	 * */
	public Matrix3l setToScaling(IVector2 scale) {
		return this.setToScaling(scale.getLongX(), scale.getLongY());
	}
	
	
	/**
	 * Sets this matrix to a scaling matrix
	 * @param x the x-component of the scaling
	 * @param y the y-component of the scaling
	 * @return this matrix for chaining
	 * */
	public Matrix3l setToScaling(long x, long y) {
		this.setToIdentity();
		this.getData()[0][0] = x;
		this.getData()[1][1] = y;
		return this;
	}
	
	
	/**
	 * Sets this matrix to a translation and scale matrix
	 * @param translation the vector with the translation components
	 * @param scaling the vector with the scaling components
	 * @return this matrix for chaining
	 * */
	public Matrix3l setToTranslationAndScale(IVector2 translation, IVector2 scaling) {
		return this.setToTranslationAndScale(translation.getLongX(), translation.getLongY(), scaling.getLongX(), scaling.getLongY());
	}

	
	
	/**
	 * Sets this matrix to a translation and scale matrix
	 * @param tx	the x component of the translation
	 * @param ty	the y component of the translation
	 * @param sx	the x component of the scaling
	 * @param sy	the y component of the scaling
	 * @return this matrix for chaining
	 * */
	public Matrix3l setToTranslationAndScale(long tx, long ty, long sx, long sy) {
		this.setToIdentity();
		this.getData()[2][0] = tx;
		this.getData()[2][1] = ty;
		this.getData()[0][0] = sx;
		this.getData()[1][1] = sy;
		return this;
	}
	
	
	
	
	/**
	 * @return the x component of the translation of this matrix
	 * */
	public long getTranslationX() {
		return this.getData()[2][0];
	}
	
	
	/**
	 * @return the y component of the translation of this matrix
	 * */
	public long getTranslationY() {
		return this.getData()[2][1];
	}
	
	
	/**
	 * @return a vector representing the translation of this matrix
	 * */
	public Vector2l getTranslation() {
		return new Vector2l(this.getTranslationX(), this.getTranslationY());
	}
	
	
	/**
	 * @return the x component of the scaling of this matrix
	 * */
	public long getScalingX() {
		return (long) Math.sqrt(getData()[0][0]*getData()[0][0] + getData()[0][1]*getData()[0][1]);
	}
	
	
	
	
	/**
	 * @return the y component of the scaling of this matrix
	 * */
	public long getScalingY() {
		return (long) Math.sqrt(getData()[1][0]*getData()[1][0] + getData()[1][1]*getData()[1][1]);
	}
	
	
	
	
	/**
	 * @return a vector representing the scaling of this matrix
	 * */
	public Vector2l getScaling() {
		return new Vector2l(this.getScalingX(), this.getScalingY());
	}
	
	
	
	/**
	 * @return the rotation of this matrix in degrees
	 * */
	public double getRotationDeg() {
		return Math.toDegrees(getRotationRad());
	}
	
	
	/**
	 * @return the rotation of this matrix in radians
	 * */
	public double getRotationRad() {
		return Math.atan2(getData()[0][1], getData()[0][0]);
	}
	
	
	
	
	@Override
	public Matrix3l copy() {
		return (Matrix3l) new Matrix3l().copyData(this.getData());
	}
	

}

package com.ruegnerlukas.simplemath.matrix.matrix3;

import com.ruegnerlukas.simplemath.matrix.IMatrix;
import com.ruegnerlukas.simplemath.matrix.matrixN.Matrixi;
import com.ruegnerlukas.simplemath.vectors.vec2.IVector2;
import com.ruegnerlukas.simplemath.vectors.vec2.Vector2i;
import com.ruegnerlukas.simplemath.vectors.vec3.IVector3;

public class Matrix3i extends Matrixi {

	
	/**
	 * Creates a 3x3 matrix with the given values
	 * */
	public Matrix3i(	int m00, int m10, int m20,
						int m01, int m11, int m21,
						int m02, int m12, int m22) {
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
	public Matrix3i(int[][] data) {
		super(3, 3);
		if(data.length != 3 && data[0].length != 3) {
			throw new IllegalArgumentException("Invalid input array size: " + data.length + "," +data[0].length + ".");
		}
		super.set(data);
	}
	
	
	public Matrix3i() {
		super(3, 3);
	}
	
	
	
	
	
	
	@Override
	public Matrix3i add(IMatrix mat) {
		if(!isUnsafe() && !compareSize(mat)) {
			throw new IllegalArgumentException("Input matrix size invalid: " + mat.getNumberColumns() + "," + mat.getNumberRows()
			+ ". Should be " + this.getNumberColumns() + "," + this.getNumberRows());
		}
		this.getData()[0][0] += mat.getInt(0, 0);
		this.getData()[0][1] += mat.getInt(0, 1);
		this.getData()[0][2] += mat.getInt(0, 2);
		this.getData()[1][0] += mat.getInt(1, 0);
		this.getData()[1][1] += mat.getInt(1, 1);
		this.getData()[1][2] += mat.getInt(1, 2);
		this.getData()[2][0] += mat.getInt(2, 0);
		this.getData()[2][1] += mat.getInt(2, 1);
		this.getData()[2][2] += mat.getInt(2, 2);
		return this;
	}
	
	
	
	
	@Override
	public Matrix3i sub(IMatrix mat) {
		if(!isUnsafe() && !compareSize(mat)) {
			throw new IllegalArgumentException("Input matrix size invalid: " + mat.getNumberColumns() + "," + mat.getNumberRows()
			+ ". Should be " + this.getNumberColumns() + "," + this.getNumberRows());
		}
		this.getData()[0][0] -= mat.getInt(0, 0);
		this.getData()[0][1] -= mat.getInt(0, 1);
		this.getData()[0][2] -= mat.getInt(0, 2);
		this.getData()[1][0] -= mat.getInt(1, 0);
		this.getData()[1][1] -= mat.getInt(1, 1);
		this.getData()[1][2] -= mat.getInt(1, 2);
		this.getData()[2][0] -= mat.getInt(2, 0);
		this.getData()[2][1] -= mat.getInt(2, 1);
		this.getData()[2][2] -= mat.getInt(2, 2);
		return this;
	}
	
	
	
	
	@Override
	public Matrix3i mul(float scalar) {
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
	public Matrix3i rotateDeg(float angleDeg) {
		return this.rotateRad((float)Math.toRadians(angleDeg));
	}
	
	
	/**
	 * Applies the given (counter-clockwise) rotation to this matrix
	 * @param angleRad the angle in radians
	 * @return this matrix for chaining
	 * */
	public Matrix3i rotateRad(float angleRad) {

		final float cos = (float) Math.cos(angleRad);
		final float sin = (float) Math.sin(angleRad);
		final float invCos = 1f - cos;
		
		final float zsin = sin;

		final float f00 = cos;
		final float f01 = zsin;
		
		final float f10 = -zsin;
		final float f11 = cos;
		
		final float f22 = invCos + cos;
		
		final float t00 = getData()[0][0] * f00 + getData()[1][0] * f01;
		final float t01 = getData()[0][1] * f00 + getData()[1][1] * f01;
		final float t02 = getData()[0][2] * f00 + getData()[1][2] * f01;
		
		final float t10 = getData()[0][0] * f10 + getData()[1][0] * f11;
		final float t11 = getData()[0][1] * f10 + getData()[1][1] * f11;
		final float t12 = getData()[0][2] * f10 + getData()[1][2] * f11;
		
		final float t20 = getData()[2][0] * f22;
		final float t21 = getData()[2][1] * f22;
		final float t22 = getData()[2][2] * f22;
		
		getData()[0][0] = (int) t00;
		getData()[0][1] = (int) t01;
		getData()[0][2] = (int) t02;

		getData()[1][0] = (int) t10;
		getData()[1][1] = (int) t11;
		getData()[1][2] = (int) t12;
		
		getData()[2][0] = (int) t20;
		getData()[2][1] = (int) t21;
		getData()[2][2] = (int) t22;
		
		return this;
	}
	
	
	
	
	/**
	 * Adds a translational component to this matrix in the third column. Other columns are untuched.
	 * @param vec the translation vector
	 * @return this matrix for chaining
	 * */
	public Matrix3i translate(IVector2 vec) {
		return this.translate(vec.getIntX(), vec.getIntY());
	}
	
	
	/**
	 * Translate this matrix.
	 * @param x the x component to translate by
	 * @param y the y component to translate by
	 * @return this matrix for chaining
	 * */
	public Matrix3i translate(int x, int y) {
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
	public Matrix3i scale(IVector2 vec) {
		return this.scale(vec.getFloatX(), vec.getFloatY());
	}
	
	
	/**
	 * Scales this matrix.
	 * @param x the x component to scale by
	 * @param y the y component to scale by
	 * @return this matrix for chaining
	 * */
	public Matrix3i scale(float x, float y) {
		for(int i=0; i<3; i++) {
			getData()[i][0] *= x;
			getData()[i][1] *= y;
		}
		return this;
	}
	
	
	
	
	@Override
	public Matrix3i setToIdentity() {
		return (Matrix3i) super.setToIdentity();
	}
	
	
	
	
	/**
	 * Sets this matrix to a rotation matrix (rotates counter-clockwise around z-axis)
	 * @param angleDeg the angle in degrees
	 * @return this matrix for chaining
	 * */
	public Matrix3i setToRotationDeg(float angleDeg) {
		return this.setToRotationRad((float)Math.toRadians(angleDeg));
	}
	
	
	/**
	 * Sets this matrix to a rotation matrix (rotates counter-clockwise around z-axis)
	 * @param angleRad the angle in radians
	 * @return this matrix for chaining
	 * */
	public Matrix3i setToRotationRad(float angleRad) {
		
		final int cos = (int) Math.cos(angleRad);
		final int sin = (int) Math.sin(angleRad);
		
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
	public Matrix3i setToRotationDeg(IVector3 axis, float angleDeg) {
		return this.setToRotationRad(axis.getFloatX(), axis.getFloatY(), axis.getFloatZ(), (float)Math.toRadians(angleDeg));
	}
	
	
	/**
	 * Sets this matrix to a rotation matrix (rotates counter-clockwise around the given axis)
	 * @param axisX the x-component of the vector representing the axis of rotation
	 * @param axisY the y-component of the vector representing the axis of rotation
	 * @param axisZ the z-component of the vector representing the axis of rotation
	 * @param angleDeg the angle in degrees
	 * @return this matrix for chaining
	 * */
	public Matrix3i setToRotationDeg(float axisX, float axisY, float axisZ, float angleDeg) {
		return this.setToRotationRad(axisX, axisY, axisZ, (float)Math.toRadians(angleDeg));
	}
	
	
	/**
	 * Sets this matrix to a rotation matrix (rotates counter-clockwise around the given axis)
	 * @param axis the vector representing the axis of rotation
	 * @param angleRad the angle in radians
	 * @return this matrix for chaining
	 * */
	public Matrix3i setToRotationRad(IVector3 axis, float angleRad) {
		return this.setToRotationRad(axis.getFloatX(), axis.getFloatY(), axis.getFloatZ(), angleRad);

	}
	
	
	/**
	 * Sets this matrix to a rotation matrix (rotates counter-clockwise around the given axis)
	 * @param axisX the x-component of the vector representing the axis of rotation
	 * @param axisY the y-component of the vector representing the axis of rotation
	 * @param axisZ the z-component of the vector representing the axis of rotation
	 * @param angleRad the angle in radians
	 * @return this matrix for chaining
	 * */
	public Matrix3i setToRotationRad(float axisX, float axisY, float axisZ, float angleRad) {
		
		final float cos = (float) Math.cos(angleRad);
		final float sin = (float) Math.sin(angleRad);
		final float invCos = 1f - cos;
		
		this.getData()[0][0] = (int) (invCos * axisX*axisX + cos);
		this.getData()[0][1] = (int) (invCos * axisX*axisY - axisZ*sin);
		this.getData()[0][2] = (int) (invCos * axisZ*axisX + axisY*sin);

		this.getData()[1][0] = (int) (invCos * axisX*axisY + axisZ*sin);
		this.getData()[1][1] = (int) (invCos * axisY*axisY + cos);
		this.getData()[1][2] = (int) (invCos * axisY*axisZ + - axisX*sin);
		
		this.getData()[2][0] = (int) (invCos * axisZ*axisX - axisY*sin);
		this.getData()[2][1] = (int) (invCos * axisY*axisZ + axisX*sin);
		this.getData()[2][2] = (int) (invCos * axisZ*axisZ + cos);
		
		return this;
	}
	
	
	
	
	/**
	 * Sets this matrix to a translation matrix
	 * @param translation the vector repesenting the translation
	 * @return this matrix for chaining
	 * */
	public Matrix3i setToTranslation(IVector2 translation) {
		return this.setToTranslation(translation.getIntX(), translation.getIntY());
	}
	
	
	/**
	 * Sets this matrix to a translation matrix
	 * @param x the x-component of the translation
	 * @param y the y-component of the translation
	 * @return this matrix for chaining
	 * */
	public Matrix3i setToTranslation(int x, int y) {
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
	public Matrix3i setToScaling(IVector2 scale) {
		return this.setToScaling(scale.getIntX(), scale.getIntY());
	}
	
	
	/**
	 * Sets this matrix to a scaling matrix
	 * @param x the x-component of the scaling
	 * @param y the y-component of the scaling
	 * @return this matrix for chaining
	 * */
	public Matrix3i setToScaling(int x, int y) {
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
	public Matrix3i setToTranslationAndScale(IVector2 translation, IVector2 scaling) {
		return this.setToTranslationAndScale(translation.getIntX(), translation.getIntY(), scaling.getIntX(), scaling.getIntY());
	}

	
	
	/**
	 * Sets this matrix to a translation and scale matrix
	 * @param tx	the x component of the translation
	 * @param ty	the y component of the translation
	 * @param sx	the x component of the scaling
	 * @param sy	the y component of the scaling
	 * @return this matrix for chaining
	 * */
	public Matrix3i setToTranslationAndScale(int tx, int ty, int sx, int sy) {
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
	public int getTranslationX() {
		return this.getData()[2][0];
	}
	
	
	/**
	 * @return the y component of the translation of this matrix
	 * */
	public int getTranslationY() {
		return this.getData()[2][1];
	}
	
	
	/**
	 * @return a vector representing the translation of this matrix
	 * */
	public Vector2i getTranslation() {
		return new Vector2i(this.getTranslationX(), this.getTranslationY());
	}
	
	
	/**
	 * @return the x component of the scaling of this matrix
	 * */
	public int getScalingX() {
		return (int) Math.sqrt(getData()[0][0]*getData()[0][0] + getData()[0][1]*getData()[0][1]);
	}
	
	
	
	
	/**
	 * @return the y component of the scaling of this matrix
	 * */
	public int getScalingY() {
		return (int) Math.sqrt(getData()[1][0]*getData()[1][0] + getData()[1][1]*getData()[1][1]);
	}
	
	
	
	
	/**
	 * @return a vector representing the scaling of this matrix
	 * */
	public Vector2i getScaling() {
		return new Vector2i(this.getScalingX(), this.getScalingY());
	}
	
	
	
	/**
	 * @return the rotation of this matrix in degrees
	 * */
	public float getRotationDeg() {
		return (float) Math.toDegrees(getRotationRad());
	}
	
	
	/**
	 * @return the rotation of this matrix in radians
	 * */
	public float getRotationRad() {
		return (float) Math.atan2(getData()[0][1], getData()[0][0]);
	}
	
	
	
	
	@Override
	public Matrix3i copy() {
		return (Matrix3i) new Matrix3i().copyData(this.getData());
	}
	

}

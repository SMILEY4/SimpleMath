package com.ruegnerlukas.simplemath.matrix.matrix4;

import com.ruegnerlukas.simplemath.matrix.IMatrix;
import com.ruegnerlukas.simplemath.matrix.matrixN.Matrixd;
import com.ruegnerlukas.simplemath.vectors.vec2.IVector2;
import com.ruegnerlukas.simplemath.vectors.vec3.IVector3;
import com.ruegnerlukas.simplemath.vectors.vec3.Vector3d;
import com.ruegnerlukas.simplemath.vectors.vec4.IVector4;




public class Matrix4d extends Matrixd {

	
	/**
	 * Creates a 4x4 matrix with the given values
	 * */
	public Matrix4d(	double m00, double m10, double m20, double m30,
						double m01, double m11, double m21, double m31,
						double m02, double m12, double m22, double m32,
						double m03, double m13, double m23, double m33) {
		super(4, 4);
		this.setUnsafe(true);
		this.set(0, 0, m00).set(1, 0, m10).set(2, 0, m20).set(3, 0, m30);
		this.set(0, 1, m01).set(1, 1, m11).set(2, 1, m21).set(3, 1, m31);
		this.set(0, 2, m02).set(1, 2, m12).set(2, 2, m22).set(3, 2, m32);
		this.set(0, 3, m03).set(1, 3, m13).set(2, 3, m23).set(3, 3, m33);
		this.setUnsafe(false);
	}
	
	
	
	/**
	 * Creates a 4x4 matrix with the given values
	 * */
	public Matrix4d(double[][] data) {
		super(4, 4);
		if(data.length != 4 && data[0].length != 4) {
			throw new IllegalArgumentException("Invalid input array size: " + data.length + "," +data[0].length + ".");
		}
		super.set(data);
	}
	
	
	public Matrix4d() {
		super(4, 4);
	}
	
	
	
	
	
	
	
	@Override
	public Matrix4d add(IMatrix mat) {
		if(!isUnsafe() && !compareSize(mat)) {
			throw new IllegalArgumentException("Input matrix size invalid: " + mat.getNumberColumns() + "," + mat.getNumberRows()
			+ ". Should be " + this.getNumberColumns() + "," + this.getNumberRows());
		}
		this.getData()[0][0] += mat.getDouble(0, 0);
		this.getData()[0][1] += mat.getDouble(0, 1);
		this.getData()[0][2] += mat.getDouble(0, 2);
		this.getData()[0][3] += mat.getDouble(0, 3);
		this.getData()[1][0] += mat.getDouble(1, 0);
		this.getData()[1][1] += mat.getDouble(1, 1);
		this.getData()[1][2] += mat.getDouble(1, 2);
		this.getData()[1][3] += mat.getDouble(1, 3);
		this.getData()[2][0] += mat.getDouble(2, 0);
		this.getData()[2][1] += mat.getDouble(2, 1);
		this.getData()[2][2] += mat.getDouble(2, 2);
		this.getData()[2][3] += mat.getDouble(2, 3);
		this.getData()[3][0] += mat.getDouble(3, 0);
		this.getData()[3][1] += mat.getDouble(3, 1);
		this.getData()[3][2] += mat.getDouble(3, 2);
		this.getData()[3][3] += mat.getDouble(3, 3);
		return this;
	}
	
	
	
	
	@Override
	public Matrix4d sub(IMatrix mat) {
		if(!isUnsafe() && !compareSize(mat)) {
			throw new IllegalArgumentException("Input matrix size invalid: " + mat.getNumberColumns() + "," + mat.getNumberRows()
			+ ". Should be " + this.getNumberColumns() + "," + this.getNumberRows());
		}
		this.getData()[0][0] -= mat.getDouble(0, 0);
		this.getData()[0][1] -= mat.getDouble(0, 1);
		this.getData()[0][2] -= mat.getDouble(0, 2);
		this.getData()[0][3] -= mat.getDouble(0, 3);
		this.getData()[1][0] -= mat.getDouble(1, 0);
		this.getData()[1][1] -= mat.getDouble(1, 1);
		this.getData()[1][2] -= mat.getDouble(1, 2);
		this.getData()[1][3] -= mat.getDouble(1, 3);
		this.getData()[2][0] -= mat.getDouble(2, 0);
		this.getData()[2][1] -= mat.getDouble(2, 1);
		this.getData()[2][2] -= mat.getDouble(2, 2);
		this.getData()[2][3] -= mat.getDouble(2, 3);
		this.getData()[3][0] -= mat.getDouble(3, 0);
		this.getData()[3][1] -= mat.getDouble(3, 1);
		this.getData()[3][2] -= mat.getDouble(3, 2);
		this.getData()[3][3] -= mat.getDouble(3, 3);
		return this;
	}
	
	
	
	
	@Override
	public Matrix4d scale(double scalar) {
		this.getData()[0][0] *= scalar;
		this.getData()[0][1] *= scalar;
		this.getData()[0][2] *= scalar;
		this.getData()[0][3] *= scalar;
		this.getData()[1][0] *= scalar;
		this.getData()[1][1] *= scalar;
		this.getData()[1][2] *= scalar;
		this.getData()[1][3] *= scalar;
		this.getData()[2][0] *= scalar;
		this.getData()[2][1] *= scalar;
		this.getData()[2][2] *= scalar;
		this.getData()[2][3] *= scalar;
		this.getData()[3][0] *= scalar;
		this.getData()[3][1] *= scalar;
		this.getData()[3][2] *= scalar;
		this.getData()[3][3] *= scalar;
		return this;
	}
	
	
	
	
	@Override
	public boolean isSquare() {
		return true;
	}

	
	
	
	/**
	 * Multiplies this matrix with the rotation specified by the given axis and angle
	 * @param axis		the axis of rotation
	 * @param angleDeg	the angle of rotation in degrees
	 * @return this matrix for chaining
	 * */
	public IMatrix rotateDeg(IVector3 axis, double angleDeg) {
		return this.rotateRad(axis, Math.toRadians(angleDeg));
	}
	
	
	/**
	 * Multiplies this matrix with the rotation specified by the given axis and angle
	 * @param axisX		the x compontnt of the axis of rotation
	 * @param axisY		the y compontnt of the axis of rotation
	 * @param axisZ		the z compontnt of the axis of rotation
	 * @param angleDeg	the angle of rotation in degrees
	 * @return this matrix for chaining
	 * */
	public IMatrix rotateDeg(double axisX, double axisY, double axisZ, double angleDeg) {
		return this.rotateRad(axisX, axisY, axisZ, Math.toRadians(angleDeg));
	}
	
	
	/**
	 * Multiplies this matrix with the rotation specified by the given axis and angle
	 * @param axis		the axis of rotation
	 * @param angleRad	the angle of rotation in radians
	 * @return this matrix for chaining
	 * */
	public IMatrix rotateRad(IVector3 axis, double angleRad) {
		return rotateRad(axis.getFloatX(), axis.getFloatY(), axis.getFloatZ(), angleRad);
	}
	
	
	/**
	 * Multiplies this matrix with the rotation specified by the given axis and angle
	 * @param axisX		the x compontnt of the axis of rotation
	 * @param axisY		the y compontnt of the axis of rotation
	 * @param axisZ		the z compontnt of the axis of rotation
	 * @param angleRad	the angle of rotation in radians
	 * @return this matrix for chaining
	 * */
	public IMatrix rotateRad(double axisX, double axisY, double axisZ, double angleRad) {
		
		final double cos = Math.cos(angleRad);
		final double sin = Math.sin(angleRad);
		final double invCos = 1f - cos;
		
		final double xy = axisX * axisY;
		final double yz = axisY * axisZ;
		final double xz = axisX * axisZ;

		final double xsin = axisX * sin;
		final double ysin = axisY * sin;
		final double zsin = axisZ * sin;

		final double f00 = axisX*axisX * invCos + cos;
		final double f01 = xy * invCos + zsin;
		final double f02 = xz * invCos - ysin;
		
		final double f10 = xy * invCos - zsin;
		final double f11 = axisY*axisY * invCos + cos;
		final double f12 = yz * invCos + xsin;
		
		final double f20 = xz * invCos + ysin;
		final double f21 = yz * invCos - xsin;
		final double f22 = axisZ*axisZ * invCos + cos;
		
		final double t00 = getData()[0][0] * f00 + getData()[1][0] * f01 + getData()[2][0] * f02;
		final double t01 = getData()[0][1] * f00 + getData()[1][1] * f01 + getData()[2][1] * f02;
		final double t02 = getData()[0][2] * f00 + getData()[1][2] * f01 + getData()[2][2] * f02;
		final double t03 = getData()[0][3] * f00 + getData()[1][3] * f01 + getData()[2][3] * f02;
		
		final double t10 = getData()[0][0] * f10 + getData()[1][0] * f11 + getData()[2][0] * f12;
		final double t11 = getData()[0][1] * f10 + getData()[1][1] * f11 + getData()[2][1] * f12;
		final double t12 = getData()[0][2] * f10 + getData()[1][2] * f11 + getData()[2][2] * f12;
		final double t13 = getData()[0][3] * f10 + getData()[1][3] * f11 + getData()[2][3] * f12;
		
		final double t20 = getData()[0][0] * f20 + getData()[1][0] * f21 + getData()[2][0] * f22;
		final double t21 = getData()[0][1] * f20 + getData()[1][1] * f21 + getData()[2][1] * f22;
		final double t22 = getData()[0][2] * f20 + getData()[1][2] * f21 + getData()[2][2] * f22;
		final double t23 = getData()[0][3] * f20 + getData()[1][3] * f21 + getData()[2][3] * f22;
		
		getData()[0][0] = t00;
		getData()[0][1] = t01;
		getData()[0][2] = t02;
		getData()[0][3] = t03;

		getData()[1][0] = t10;
		getData()[1][1] = t11;
		getData()[1][2] = t12;
		getData()[1][3] = t13;
		
		getData()[2][0] = t20;
		getData()[2][1] = t21;
		getData()[2][2] = t22;
		getData()[2][3] = t23;
		
		return this;
	}
	
	
	
	
	/**
	 * Adds a transation to this matrix based on the given vector.
	 * @param vec the vector with the translation components
	 * @return this matrix for chaining
	 * */
	public Matrix4d translate(IVector3 vec) {
		return translate(vec.getFloatX(), vec.getFloatY(), vec.getFloatZ());
	}
	
	
	/**
	 * Adds a transation to this matrix based on the given vector.
	 * @param x the x component of the translation
	 * @param y the y component of the translation
	 * @param z the z component of the translation
	 * @return this matrix for chaining
	 * */
	public Matrix4d translate(double x, double y, double z) {
		getData()[3][0] += getData()[0][0]*x + getData()[1][0]*y + getData()[2][0]*z;
		getData()[3][1] += getData()[0][1]*x + getData()[1][1]*y + getData()[2][1]*z;
		getData()[3][2] += getData()[0][2]*x + getData()[1][2]*y + getData()[2][2]*z;
		getData()[3][3] += getData()[0][3]*x + getData()[1][3]*y + getData()[2][3]*z;
		return this;
	}
	
	
	/**
	 * Translate this matrix.
	 * @param vec the vector to translate by
	 * @return this matrix for chaining
	 * */
	public Matrix4d translate(IVector2 vec) {
		return translate(vec.getDoubleX(), vec.getDoubleY());
	}
	
	
	/**
	 * Translate this matrix.
	 * @param x the x component to translate by
	 * @param y the y component to translate by
	 * @return this matrix for chaining
	 * */
	public Matrix4d translate(double x, double y) {
		getData()[3][0] += getData()[0][0]*x + getData()[1][0]*y;
		getData()[3][1] += getData()[0][1]*x + getData()[1][1]*y;
		getData()[3][2] += getData()[0][2]*x + getData()[1][2]*y;
		getData()[3][3] += getData()[0][3]*x + getData()[1][3]*y;
		return this;
	}
	
	
	
	
	/**
	 * Scales this matrix.
	 * @param vec the vector to scale by
	 * @return this matrix for chaining
	 * */
	public Matrixd scale(IVector3 vec) {
		return scale(vec.getDoubleX(), vec.getDoubleY(), vec.getDoubleZ());
	}
	
	
	/**
	 * Scales this matrix.
	 * @param x the x component to scale by
	 * @param y the y component to scale by
	 * @param z the z component to scale by
	 * @return this matrix for chaining
	 * */
	public Matrixd scale(double x, double y, double z) {
		for(int i=0; i<4; i++) {
			getData()[i][0] *= x;
			getData()[i][1] *= y;
			getData()[i][2] *= z;
		}
		return this;
	}
	
	
	
	
	/**
	 * Sets the homogneous scale of this matrix.
	 * @param zoom the zoom value (1 = no zoom)
	 * */
	public Matrixd setCoordinateZoom(double zoom) {
		getData()[3][3] = zoom;
		return this;
	}
	
	
	
	
	/**
	 * Transforms the given vector by this matrix.
	 * @param vec the vector to transform
	 * @return the transformed vector
	 * */
	public IVector4 transformVector(IVector4 vec) {
		double x = getData()[0][0]*vec.getDoubleX()  +  getData()[1][0]*vec.getDoubleY()  +  getData()[2][0]*vec.getDoubleZ()  +  getData()[3][0]*vec.getDoubleW();
		double y = getData()[0][1]*vec.getDoubleX()  +  getData()[1][1]*vec.getDoubleY()  +  getData()[2][1]*vec.getDoubleZ()  +  getData()[3][1]*vec.getDoubleW();
		double z = getData()[0][2]*vec.getDoubleX()  +  getData()[1][2]*vec.getDoubleY()  +  getData()[2][2]*vec.getDoubleZ()  +  getData()[3][2]*vec.getDoubleW();
		double w = getData()[0][3]*vec.getDoubleX()  +  getData()[1][3]*vec.getDoubleY()  +  getData()[2][3]*vec.getDoubleZ()  +  getData()[3][3]*vec.getDoubleW();
		vec.set(x, y, z, w);
		return vec;
	}
	
	
	
	
	/**
	 * Sets this matrix to a perspective projection matrix.
	 * @param near the near plane
	 * @param far the far plane
	 * @param fov the field of view in degrees
	 * @param aspectRatio the aspect ratio. Defined as width/height
	 * @return this matrix for chaining
	 * */
	public Matrix4d setToPerspective(double near, double far, double  fov, double aspectRatio) {
		
		final double fd = (1.0 / Math.tan( (fov*(Math.PI/180.0)) / 2.0 ));
		final double a1 = (far + near) / (far - near);
		final double a2 = (2.0 * far * near) / (near - far);
		
		this.setToIdentity();

		getData()[0][0] = fd / aspectRatio;
		getData()[1][0] = 0f;
		getData()[2][0] = 0f;
		getData()[3][0] = 0f;
		
		getData()[0][1] = 0f;
		getData()[1][1] = fd;
		getData()[2][1] = 0f;
		getData()[3][1] = 0f;
	
		getData()[0][2] = 0f;
		getData()[1][2] = 0f;
		getData()[2][2] = a1;
		getData()[3][2] = -1f;
		
		getData()[0][3] = 0f;
		getData()[1][3] = 0f;
		getData()[2][3] = a2;
		getData()[3][3] = 0f;
		
		return this;
	}
	
	
	
	
	/**
	 * Sets this matrix to an orthographics projection matrix with the origin at (x,y)
	 * @param x			the x coordinate of the origin
	 * @param y			the y coordinate of the origin
	 * @param width		the width
	 * @param height	the height
	 * @return this matrix for chaining
	 * */
	public Matrix4d setToOrthographic2D(double x, double y, double width, double height) {
		return setToOrthographic(x, x+width, y, y+height, 0f, 1f);
	}
	
	
	/**
	 * Sets this matrix to an orthographics projection matrix with the origin at (x,y)
	 * @param x			the x coordinate of the origin
	 * @param y			the y coordinate of the origin
	 * @param width		the width
	 * @param height	the height
	 * @param near the near plane
	 * @param far the far plane
	 * @return this matrix for chaining
	 * */
	public Matrix4d setToOrthographic2D(double x, double y, double width, double height, double near, double far) {
		return setToOrthographic(x, x+width, y, y+height, near, far);
	}
	
	
	/**
	 * Sets this matrix to an orthographics projection matrix with the origin at (x,y)
	 * @param left	the left plane
	 * @param right	the right plane
	 * @param bottom	the bottom plane
	 * @param top		the top plane
	 * @param near the near plane
	 * @param far the far plane
	 * @return this matrix for chaining
	 * */
	public Matrix4d setToOrthographic(double left, double right, double bottom, double top, double near, double far) {
		
		final double xOrth = 2.0 / (right - left);
		final double yOrth = 2.0 / (top - bottom);
		final double zOrth = 2.0 / (far - near);
		
		final double tx = -(right + left) / (right - left);
		final double ty = -(top + bottom) / (top - bottom);
		final double tz = -(far + near) / (far - near);

		this.setToIdentity();

		getData()[0][0] = xOrth;
		getData()[1][0] = 0f;
		getData()[2][0] = 0f;
		getData()[3][0] = 0f;
		
		getData()[0][1] = 0f;
		getData()[1][1] = yOrth;
		getData()[2][1] = 0f;
		getData()[3][1] = 0f;
	
		getData()[0][2] = 0f;
		getData()[1][2] = 0f;
		getData()[2][2] = zOrth;
		getData()[3][2] = -1f;
		
		getData()[0][3] = tx;
		getData()[1][3] = ty;
		getData()[2][3] = tz;
		getData()[3][3] = 1f;
		
		return this;
	}


	
	
	/**
	 * Sets this matrix to a translation matrix
	 * @param vec the vector with the translation components
	 * @return this matrix for chaining
	 * */
	public Matrix4d setToTranslation(IVector3 vec) {
		return setToTranslation(vec.getDoubleX(), vec.getDoubleY(), vec.getDoubleZ());
	}
	
	
	/**
	 * Sets this matrix to a translation matrix
	 * @param x	the x component of the translation
	 * @param y	the y component of the translation
	 * @param z	the z component of the translation
	 * @return this matrix for chaining
	 * */
	public Matrix4d setToTranslation(double x, double y, double z) {
		this.setToIdentity();
		getData()[0][3] = x;
		getData()[1][3] = y;
		getData()[2][3] = z;
		return this;
	}
	
	
	/**
	 * Sets this matrix to a translation matrix
	 * @param vec the vector with the scaling components
	 * @return this matrix for chaining
	 * */
	public Matrix4d setToScale(IVector3 vec) {
		return this.setToScale(vec.getDoubleX(), vec.getDoubleY(), vec.getDoubleZ());
	}

	
	/**
	 * Sets this matrix to a scale matrix
	 * @param x	the x component of the scaling
	 * @param y	the y component of the scaling
	 * @param z	the z component of the scaling
	 * @return this matrix for chaining
	 * */
	public Matrix4d setToScale(double x, double y, double z) {
		this.setToIdentity();
		getData()[0][0] = x;
		getData()[1][1] = y;
		getData()[2][2] = z;
		return this;
	}
	
	
	
	
	/**
	 * Sets this matrix to a translation and scale matrix
	 * @param translation the vector with the translation components
	 * @param scaling the vector with the scaling components
	 * @return this matrix for chaining
	 * */
	public Matrix4d setToTranslationAndScale(IVector3 translation, IVector3 scaling) {
		return this.setToTranslationAndScale(
				translation.getDoubleX(), translation.getDoubleY(), translation.getDoubleZ(),
				scaling.getDoubleX(), scaling.getDoubleY(), scaling.getDoubleZ());
	}

	
	
	/**
	 * Sets this matrix to a translation and scale matrix
	 * @param tx	the x component of the translation
	 * @param ty	the y component of the translation
	 * @param tz	the z component of the translation
	 * @param sx	the x component of the scaling
	 * @param sy	the y component of the scaling
	 * @param sz	the z component of the scaling
	 * @return this matrix for chaining
	 * */
	public Matrix4d setToTranslationAndScale(double tx, double ty, double tz, double sx, double sy, double sz) {
		this.setToIdentity();
		getData()[0][3] = tx;
		getData()[1][3] = ty;
		getData()[2][3] = tz;
		getData()[0][0] = sx;
		getData()[1][1] = sy;
		getData()[2][2] = sz;
		return this;
	}
	
	
	
//	public Matrix4f setToRotation(float axisX, float axisY, float axisZ, float angleRad) {
//		return this;
//	}
//	
//	
//	public Matrix4f setToRotation(float yaw, float pitch, float roll) {
//		return this;
//	}
//	
//	
//	public Matrix4f setToLookAt(float dirX, float dirY, float dirZ, float upX, float upY, float upZ) {
//		return this;
//	}
//	
//	
//	public Matrix4f setToLookAt(float posX, float posY, float posZ, float targetX, float targetY, float targetZ, float upX, float upY, float upZ) {
//		return this;
//	}
	
	
	
	
	/**
	 * @return the x component of the translation of this matrix
	 * */
	public double getTranslationX() {
		return getData()[0][3];
	}
	
	
	
	
	/**
	 * @return the y component of the translation of this matrix
	 * */
	public double getTranslationY() {
		return getData()[1][3];
	}
	
	
	
	
	/**
	 * @return the z component of the translation of this matrix
	 * */
	public double getTranslationZ() {
		return getData()[2][3];
	}
	
	
	
	
	/**
	 * @return a vector representing the translation of this matrix
	 * */
	public Vector3d getTranslation() {
		return new Vector3d(getTranslationX(), getTranslationY(), getTranslationZ());
	}

	
	
	
	/**
	 * @return the x component of the scaling of this matrix
	 * */
	public double getScalingX() {
		return Math.sqrt(getData()[0][0]*getData()[0][0] + getData()[0][1]*getData()[0][1] + getData()[0][2]*getData()[0][2]);
	}
	
	
	
	
	/**
	 * @return the y component of the scaling of this matrix
	 * */
	public double getScalingY() {
		return Math.sqrt(getData()[1][0]*getData()[1][0] + getData()[1][1]*getData()[1][1] + getData()[1][2]*getData()[1][2]);
	}
	
	
	
	
	/**
	 * @return the z component of the scaling of this matrix
	 * */
	public double getScalingZ() {
		return Math.sqrt(getData()[2][0]*getData()[2][0] + getData()[2][1]*getData()[2][1] + getData()[2][2]*getData()[2][2]);
	}
	
	
	
	
	/**
	 * @return a vector representing the scaling of this matrix
	 * */
	public Vector3d getScaling() {
		return new Vector3d(getScalingX(), getScalingY(), getScalingZ());
	}
	
	
	
	
	@Override
	public Matrix4d copy() {
		return (Matrix4d) new Matrix4d().copyData(this.getData());
	}
	
	
	
}

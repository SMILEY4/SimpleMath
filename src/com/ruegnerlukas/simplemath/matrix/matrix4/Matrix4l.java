package com.ruegnerlukas.simplemath.matrix.matrix4;

import com.ruegnerlukas.simplemath.matrix.IMatrix;
import com.ruegnerlukas.simplemath.matrix.matrixN.Matrixl;
import com.ruegnerlukas.simplemath.vectors.vec2.IVector2;
import com.ruegnerlukas.simplemath.vectors.vec3.IVector3;
import com.ruegnerlukas.simplemath.vectors.vec3.Vector3d;
import com.ruegnerlukas.simplemath.vectors.vec3.Vector3l;
import com.ruegnerlukas.simplemath.vectors.vec4.IVector4;




public class Matrix4l extends Matrixl {

	
	/**
	 * Creates a 4x4 matrix with the given values
	 * */
	public Matrix4l(	long m00, long m10, long m20, long m30,
						long m01, long m11, long m21, long m31,
						long m02, long m12, long m22, long m32,
						long m03, long m13, long m23, long m33) {
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
	public Matrix4l(long[][] data) {
		super(4, 4);
		if(data.length != 4 && data[0].length != 4) {
			throw new IllegalArgumentException("Invalid input array size: " + data.length + "," +data[0].length + ".");
		}
		super.set(data);
	}
	
	
	public Matrix4l() {
		super(4, 4);
	}
	
	
	
	
	
	
	
	@Override
	public Matrix4l add(IMatrix mat) {
		if(!isUnsafe() && !compareSize(mat)) {
			throw new IllegalArgumentException("Input matrix size invalid: " + mat.getNumberColumns() + "," + mat.getNumberRows()
			+ ". Should be " + this.getNumberColumns() + "," + this.getNumberRows());
		}
		this.getData()[0][0] += mat.getLong(0, 0);
		this.getData()[0][1] += mat.getLong(0, 1);
		this.getData()[0][2] += mat.getLong(0, 2);
		this.getData()[0][3] += mat.getLong(0, 3);
		this.getData()[1][0] += mat.getLong(1, 0);
		this.getData()[1][1] += mat.getLong(1, 1);
		this.getData()[1][2] += mat.getLong(1, 2);
		this.getData()[1][3] += mat.getLong(1, 3);
		this.getData()[2][0] += mat.getLong(2, 0);
		this.getData()[2][1] += mat.getLong(2, 1);
		this.getData()[2][2] += mat.getLong(2, 2);
		this.getData()[2][3] += mat.getLong(2, 3);
		this.getData()[3][0] += mat.getLong(3, 0);
		this.getData()[3][1] += mat.getLong(3, 1);
		this.getData()[3][2] += mat.getLong(3, 2);
		this.getData()[3][3] += mat.getLong(3, 3);
		return this;
	}
	
	
	
	
	@Override
	public Matrix4l sub(IMatrix mat) {
		if(!isUnsafe() && !compareSize(mat)) {
			throw new IllegalArgumentException("Input matrix size invalid: " + mat.getNumberColumns() + "," + mat.getNumberRows()
			+ ". Should be " + this.getNumberColumns() + "," + this.getNumberRows());
		}
		this.getData()[0][0] -= mat.getLong(0, 0);
		this.getData()[0][1] -= mat.getLong(0, 1);
		this.getData()[0][2] -= mat.getLong(0, 2);
		this.getData()[0][3] -= mat.getLong(0, 3);
		this.getData()[1][0] -= mat.getLong(1, 0);
		this.getData()[1][1] -= mat.getLong(1, 1);
		this.getData()[1][2] -= mat.getLong(1, 2);
		this.getData()[1][3] -= mat.getLong(1, 3);
		this.getData()[2][0] -= mat.getLong(2, 0);
		this.getData()[2][1] -= mat.getLong(2, 1);
		this.getData()[2][2] -= mat.getLong(2, 2);
		this.getData()[2][3] -= mat.getLong(2, 3);
		this.getData()[3][0] -= mat.getLong(3, 0);
		this.getData()[3][1] -= mat.getLong(3, 1);
		this.getData()[3][2] -= mat.getLong(3, 2);
		this.getData()[3][3] -= mat.getLong(3, 3);
		return this;
	}
	
	
	
	
	@Override
	public Matrix4l scale(double scalar) {
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
	public IMatrix rotateDeg(long axisX, long axisY, long axisZ, double angleDeg) {
		return this.rotateRad(axisX, axisY, axisZ, Math.toRadians(angleDeg));
	}
	
	
	/**
	 * Multiplies this matrix with the rotation specified by the given axis and angle
	 * @param axis		the axis of rotation
	 * @param angleDeg	the angle of rotation in radians
	 * @return this matrix for chaining
	 * */
	public IMatrix rotateRad(IVector3 axis, double angleRad) {
		return rotateRad(axis.getIntX(), axis.getIntY(), axis.getIntZ(), angleRad);
	}
	
	
	/**
	 * Multiplies this matrix with the rotation specified by the given axis and angle
	 * @param axisX		the x compontnt of the axis of rotation
	 * @param axisY		the y compontnt of the axis of rotation
	 * @param axisZ		the z compontnt of the axis of rotation
	 * @param angleDeg	the angle of rotation in radians
	 * @return this matrix for chaining
	 * */
	public IMatrix rotateRad(long axisX, long axisY, long axisZ, double angleRad) {
		
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
		
		final long t00 = (long) (getData()[0][0] * f00 + getData()[1][0] * f01 + getData()[2][0] * f02);
		final long t01 = (long) (getData()[0][1] * f00 + getData()[1][1] * f01 + getData()[2][1] * f02);
		final long t02 = (long) (getData()[0][2] * f00 + getData()[1][2] * f01 + getData()[2][2] * f02);
		final long t03 = (long) (getData()[0][3] * f00 + getData()[1][3] * f01 + getData()[2][3] * f02);
		
		final long t10 = (long) (getData()[0][0] * f10 + getData()[1][0] * f11 + getData()[2][0] * f12);
		final long t11 = (long) (getData()[0][1] * f10 + getData()[1][1] * f11 + getData()[2][1] * f12);
		final long t12 = (long) (getData()[0][2] * f10 + getData()[1][2] * f11 + getData()[2][2] * f12);
		final long t13 = (long) (getData()[0][3] * f10 + getData()[1][3] * f11 + getData()[2][3] * f12);
		
		final long t20 = (long) (getData()[0][0] * f20 + getData()[1][0] * f21 + getData()[2][0] * f22);
		final long t21 = (long) (getData()[0][1] * f20 + getData()[1][1] * f21 + getData()[2][1] * f22);
		final long t22 = (long) (getData()[0][2] * f20 + getData()[1][2] * f21 + getData()[2][2] * f22);
		final long t23 = (long) (getData()[0][3] * f20 + getData()[1][3] * f21 + getData()[2][3] * f22);
		
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
	public Matrix4l translate(IVector3 vec) {
		return translate(vec.getLongX(), vec.getLongY(), vec.getLongZ());
	}
	
	
	/**
	 * Adds a transation to this matrix based on the given vector.
	 * @param x the x component of the translation
	 * @param y the y component of the translation
	 * @param z the z component of the translation
	 * @return this matrix for chaining
	 * */
	public Matrix4l translate(long x, long y, long z) {
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
	public Matrix4l translate(IVector2 vec) {
		return translate(vec.getLongX(), vec.getLongY());
	}
	
	
	/**
	 * Translate this matrix.
	 * @param x the x component to translate by
	 * @param y the y component to translate by
	 * @return this matrix for chaining
	 * */
	public Matrix4l translate(long x, long y) {
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
	public Matrixl scale(IVector3 vec) {
		return scale(vec.getDoubleX(), vec.getDoubleY(), vec.getDoubleZ());
	}
	
	
	/**
	 * Scales this matrix.
	 * @param x the x component to scale by
	 * @param y the y component to scale by
	 * @param z the z component to scale by
	 * @return this matrix for chaining
	 * */
	public Matrixl scale(double x, double y, double z) {
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
	public Matrixl setCoordinateZoom(long zoom) {
		getData()[3][3] = zoom;
		return this;
	}
	
	
	
	
	/**
	 * Transforms the given vector by this matrix.
	 * @param vec the vector to transform
	 * @return the transformed vector
	 * */
	public IVector4 transformVector(IVector4 vec) {
		long x = getData()[0][0]*vec.getLongX()  +  getData()[1][0]*vec.getLongY()  +  getData()[2][0]*vec.getLongZ()  +  getData()[3][0]*vec.getLongW();
		long y = getData()[0][1]*vec.getLongX()  +  getData()[1][1]*vec.getLongY()  +  getData()[2][1]*vec.getLongZ()  +  getData()[3][1]*vec.getLongW();
		long z = getData()[0][2]*vec.getLongX()  +  getData()[1][2]*vec.getLongY()  +  getData()[2][2]*vec.getLongZ()  +  getData()[3][2]*vec.getLongW();
		long w = getData()[0][3]*vec.getLongX()  +  getData()[1][3]*vec.getLongY()  +  getData()[2][3]*vec.getLongZ()  +  getData()[3][3]*vec.getLongW();
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
	public Matrix4l setToPerspective(double near, double far, double  fov, double aspectRatio) {
		
		final double fd = (1.0 / Math.tan( (fov*(Math.PI/180.0)) / 2.0 ));
		final double a1 = (far + near) / (far - near);
		final double a2 = (2.0 * far * near) / (near - far);
		
		this.setToIdentity();

		getData()[0][0] = (long) (fd / aspectRatio);
		getData()[1][0] = 0;
		getData()[2][0] = 0;
		getData()[3][0] = 0;
		
		getData()[0][1] = 0;
		getData()[1][1] = (long) (fd);
		getData()[2][1] = 0;
		getData()[3][1] = 0;
	
		getData()[0][2] = 0;
		getData()[1][2] = 0;
		getData()[2][2] = (long) (a1);
		getData()[3][2] = -1;
		
		getData()[0][3] = 0;
		getData()[1][3] = 0;
		getData()[2][3] = (long) (a2);
		getData()[3][3] = 0;
		
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
	public Matrix4l setToOrthographic2D(long x, long y, long width, long height) {
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
	public Matrix4l setToOrthographic2D(long x, long y, long width, long height, double near, double far) {
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
	public Matrix4l setToOrthographic(long left, long right, long bottom, long top, double near, double far) {
		
		final double xOrth = 2.0 / (right - left);
		final double yOrth = 2.0 / (top - bottom);
		final double zOrth = 2.0 / (far - near);
		
		final double tx = -(right + left) / (right - left);
		final double ty = -(top + bottom) / (top - bottom);
		final double tz = -(far + near) / (far - near);

		this.setToIdentity();

		getData()[0][0] = (long) xOrth;
		getData()[1][0] = 0;
		getData()[2][0] = 0;
		getData()[3][0] = 0;
		
		getData()[0][1] = 0;
		getData()[1][1] = (long) yOrth;
		getData()[2][1] = 0;
		getData()[3][1] = 0;
	
		getData()[0][2] = 0;
		getData()[1][2] = 0;
		getData()[2][2] = (long) zOrth;
		getData()[3][2] = -1;
		
		getData()[0][3] = (long) tx;
		getData()[1][3] = (long) ty;
		getData()[2][3] = (long) tz;
		getData()[3][3] = 1;
		
		return this;
	}


	
	
	/**
	 * Sets this matrix to a translation matrix
	 * @param vec the vector with the translation components
	 * @return this matrix for chaining
	 * */
	public Matrix4l setToTranslation(IVector3 vec) {
		return setToTranslation(vec.getLongX(), vec.getLongY(), vec.getLongZ());
	}
	
	
	/**
	 * Sets this matrix to a translation matrix
	 * @param x	the x component of the translation
	 * @param y	the y component of the translation
	 * @param z	the z component of the translation
	 * @return this matrix for chaining
	 * */
	public Matrix4l setToTranslation(long x, long y, long z) {
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
	public Matrix4l setToScale(IVector3 vec) {
		return this.setToScale(vec.getLongX(), vec.getLongY(), vec.getLongZ());
	}

	
	/**
	 * Sets this matrix to a scale matrix
	 * @param x	the x component of the scaling
	 * @param y	the y component of the scaling
	 * @param z	the z component of the scaling
	 * @return this matrix for chaining
	 * */
	public Matrix4l setToScale(long x, long y, long z) {
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
	public Matrix4l setToTranslationAndScale(IVector3 translation, IVector3 scaling) {
		return this.setToTranslationAndScale(
				translation.getLongX(), translation.getLongY(), translation.getLongZ(),
				scaling.getLongX(), scaling.getLongY(), scaling.getLongZ());
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
	public Matrix4l setToTranslationAndScale(long tx, long ty, long tz, long sx, long sy, long sz) {
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
	public long getTranslationX() {
		return getData()[0][3];
	}
	
	
	
	
	/**
	 * @return the y component of the translation of this matrix
	 * */
	public long getTranslationY() {
		return getData()[1][3];
	}
	
	
	
	
	/**
	 * @return the z component of the translation of this matrix
	 * */
	public long getTranslationZ() {
		return getData()[2][3];
	}
	
	
	
	
	/**
	 * @return a vector representing the translation of this matrix
	 * */
	public Vector3l getTranslation() {
		return new Vector3l(getTranslationX(), getTranslationY(), getTranslationZ());
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
	public Matrix4l copy() {
		return (Matrix4l) new Matrix4l().copyData(this.getData());
	}
	
	
	
}

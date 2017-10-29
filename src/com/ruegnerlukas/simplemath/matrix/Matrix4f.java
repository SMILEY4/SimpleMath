package com.ruegnerlukas.simplemath.matrix;

import com.ruegnerlukas.simplemath.vectors.vec2.IVector2;
import com.ruegnerlukas.simplemath.vectors.vec3.IVector3;
import com.ruegnerlukas.simplemath.vectors.vec3.Vector3f;
import com.ruegnerlukas.simplemath.vectors.vec4.IVector4;




public class Matrix4f extends Matrixf {

	
	/**
	 * Creates a 4x4 matrix with the given values
	 * */
	public Matrix4f(	float m00, float m10, float m20, float m30,
						float m01, float m11, float m21, float m31,
						float m02, float m12, float m22, float m32,
						float m03, float m13, float m23, float m33) {
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
	public Matrix4f(float[][] data) {
		super(4, 4);
		if(data.length != 4 && data[0].length != 4) {
			throw new IllegalArgumentException("Invalid input array size: " + data.length + "," +data[0].length + ".");
		}
		super.set(data);
	}
	
	
	public Matrix4f() {
		super(4, 4);
	}
	
	
	
	
	
	
	
	@Override
	public Matrix4f add(IMatrix mat) {
		if(!isUnsafe() && !compareSize(mat)) {
			throw new IllegalArgumentException("Input matrix size invalid: " + mat.getNumberColumns() + "," + mat.getNumberRows()
			+ ". Should be " + this.getNumberColumns() + "," + this.getNumberRows());
		}
		if(mat instanceof IMatrixf) {
			IMatrixf matf = (IMatrixf)mat;
			this.getData()[0][0] += matf.getData()[0][0];
			this.getData()[0][1] += matf.getData()[0][1];
			this.getData()[0][2] += matf.getData()[0][2];
			this.getData()[0][3] += matf.getData()[0][3];
			this.getData()[1][0] += matf.getData()[1][0];
			this.getData()[1][1] += matf.getData()[1][1];
			this.getData()[1][2] += matf.getData()[1][2];
			this.getData()[1][3] += matf.getData()[1][3];
			this.getData()[2][0] += matf.getData()[2][0];
			this.getData()[2][1] += matf.getData()[2][1];
			this.getData()[2][2] += matf.getData()[2][2];
			this.getData()[2][3] += matf.getData()[2][3];
			this.getData()[3][0] += matf.getData()[3][0];
			this.getData()[3][1] += matf.getData()[3][1];
			this.getData()[3][2] += matf.getData()[3][2];
			this.getData()[3][3] += matf.getData()[3][3];
		} else {
			// TODO: other matrix-types
		}
		return this;
	}
	
	
	
	
	@Override
	public Matrix4f sub(IMatrix mat) {
		if(!isUnsafe() && !compareSize(mat)) {
			throw new IllegalArgumentException("Input matrix size invalid: " + mat.getNumberColumns() + "," + mat.getNumberRows()
			+ ". Should be " + this.getNumberColumns() + "," + this.getNumberRows());
		}
		if(mat instanceof IMatrixf) {
			IMatrixf matf = (IMatrixf)mat;
			this.getData()[0][0] -= matf.getData()[0][0];
			this.getData()[0][1] -= matf.getData()[0][1];
			this.getData()[0][2] -= matf.getData()[0][2];
			this.getData()[0][3] -= matf.getData()[0][3];
			this.getData()[1][0] -= matf.getData()[1][0];
			this.getData()[1][1] -= matf.getData()[1][1];
			this.getData()[1][2] -= matf.getData()[1][2];
			this.getData()[1][3] -= matf.getData()[1][3];
			this.getData()[2][0] -= matf.getData()[2][0];
			this.getData()[2][1] -= matf.getData()[2][1];
			this.getData()[2][2] -= matf.getData()[2][2];
			this.getData()[2][3] -= matf.getData()[2][3];
			this.getData()[3][0] -= matf.getData()[3][0];
			this.getData()[3][1] -= matf.getData()[3][1];
			this.getData()[3][2] -= matf.getData()[3][2];
			this.getData()[3][3] -= matf.getData()[3][3];
		} else {
			// TODO: other matrix-types
		}
		return this;
	}
	
	
	
	
	@Override
	public Matrix4f scale(float scalar) {
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
	public IMatrix rotateDeg(IVector3 axis, float angleDeg) {
		return this.rotateRad(axis, (float)Math.toRadians(angleDeg));
	}
	
	
	/**
	 * Multiplies this matrix with the rotation specified by the given axis and angle
	 * @param axisX		the x compontnt of the axis of rotation
	 * @param axisY		the y compontnt of the axis of rotation
	 * @param axisZ		the z compontnt of the axis of rotation
	 * @param angleDeg	the angle of rotation in degrees
	 * @return this matrix for chaining
	 * */
	public IMatrix rotateDeg(float axisX, float axisY, float axisZ, float angleDeg) {
		return this.rotateRad(axisX, axisY, axisZ, (float)Math.toRadians(angleDeg));
	}
	
	
	/**
	 * Multiplies this matrix with the rotation specified by the given axis and angle
	 * @param axis		the axis of rotation
	 * @param angleDeg	the angle of rotation in radians
	 * @return this matrix for chaining
	 * */
	public IMatrix rotateRad(IVector3 axis, float angleRad) {
		return rotateRad(axis.getFloatX(), axis.getFloatY(), axis.getFloatZ(), angleRad);
	}
	
	
	/**
	 * Multiplies this matrix with the rotation specified by the given axis and angle
	 * @param axisX		the x compontnt of the axis of rotation
	 * @param axisY		the y compontnt of the axis of rotation
	 * @param axisZ		the z compontnt of the axis of rotation
	 * @param angleDeg	the angle of rotation in radians
	 * @return this matrix for chaining
	 * */
	public IMatrix rotateRad(float axisX, float axisY, float axisZ, float angleRad) {
		
		final float cos = (float)Math.cos(angleRad);
		final float sin = (float)Math.sin(angleRad);
		final float invCos = 1f - cos;
		
		final float xy = axisX * axisY;
		final float yz = axisY * axisZ;
		final float xz = axisX * axisZ;

		final float xsin = axisX * sin;
		final float ysin = axisY * sin;
		final float zsin = axisZ * sin;

		final float f00 = axisX*axisX * invCos + cos;
		final float f01 = xy * invCos + zsin;
		final float f02 = xz * invCos - ysin;
		
		final float f10 = xy * invCos - zsin;
		final float f11 = axisY*axisY * invCos + cos;
		final float f12 = yz * invCos + xsin;
		
		final float f20 = xz * invCos + ysin;
		final float f21 = yz * invCos - xsin;
		final float f22 = axisZ*axisZ * invCos + cos;
		
		final float t00 = getData()[0][0] * f00 + getData()[1][0] * f01 + getData()[2][0] * f02;
		final float t01 = getData()[0][1] * f00 + getData()[1][1] * f01 + getData()[2][1] * f02;
		final float t02 = getData()[0][2] * f00 + getData()[1][2] * f01 + getData()[2][2] * f02;
		final float t03 = getData()[0][3] * f00 + getData()[1][3] * f01 + getData()[2][3] * f02;
		
		final float t10 = getData()[0][0] * f10 + getData()[1][0] * f11 + getData()[2][0] * f12;
		final float t11 = getData()[0][1] * f10 + getData()[1][1] * f11 + getData()[2][1] * f12;
		final float t12 = getData()[0][2] * f10 + getData()[1][2] * f11 + getData()[2][2] * f12;
		final float t13 = getData()[0][3] * f10 + getData()[1][3] * f11 + getData()[2][3] * f12;
		
		final float t20 = getData()[0][0] * f20 + getData()[1][0] * f21 + getData()[2][0] * f22;
		final float t21 = getData()[0][1] * f20 + getData()[1][1] * f21 + getData()[2][1] * f22;
		final float t22 = getData()[0][2] * f20 + getData()[1][2] * f21 + getData()[2][2] * f22;
		final float t23 = getData()[0][3] * f20 + getData()[1][3] * f21 + getData()[2][3] * f22;
		
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
	public Matrix4f translate(IVector3 vec) {
		return translate(vec.getFloatX(), vec.getFloatY(), vec.getFloatZ());
	}
	
	
	/**
	 * Adds a transation to this matrix based on the given vector.
	 * @param x the x component of the translation
	 * @param y the y component of the translation
	 * @param z the z component of the translation
	 * @return this matrix for chaining
	 * */
	public Matrix4f translate(float x, float y, float z) {
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
	public Matrix4f translate(IVector2 vec) {
		return translate(vec.getFloatX(), vec.getFloatY());
	}
	
	
	/**
	 * Translate this matrix.
	 * @param x the x component to translate by
	 * @param y the y component to translate by
	 * @return this matrix for chaining
	 * */
	public Matrix4f translate(float x, float y) {
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
	public Matrixf scale(IVector3 vec) {
		return scale(vec.getFloatX(), vec.getFloatY(), vec.getFloatZ());
	}
	
	
	/**
	 * Scales this matrix.
	 * @param x the x component to scale by
	 * @param y the y component to scale by
	 * @param z the z component to scale by
	 * @return this matrix for chaining
	 * */
	public Matrixf scale(float x, float y, float z) {
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
	public Matrixf setCoordinateZoom(float zoom) {
		getData()[3][3] = zoom;
		return this;
	}
	
	
	
	
	/**
	 * Transforms the given vector by this matrix.
	 * @param vec the vector to transform
	 * @return the transformed vector
	 * */
	public IVector4 transformVector(IVector4 vec) {
		float x = getData()[0][0]*vec.getFloatX()  +  getData()[1][0]*vec.getFloatY()  +  getData()[2][0]*vec.getFloatZ()  +  getData()[3][0]*vec.getFloatW();
		float y = getData()[0][1]*vec.getFloatX()  +  getData()[1][1]*vec.getFloatY()  +  getData()[2][1]*vec.getFloatZ()  +  getData()[3][1]*vec.getFloatW();
		float z = getData()[0][2]*vec.getFloatX()  +  getData()[1][2]*vec.getFloatY()  +  getData()[2][2]*vec.getFloatZ()  +  getData()[3][2]*vec.getFloatW();
		float w = getData()[0][3]*vec.getFloatX()  +  getData()[1][3]*vec.getFloatY()  +  getData()[2][3]*vec.getFloatZ()  +  getData()[3][3]*vec.getFloatW();
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
	public Matrix4f setToPerspective(float near, float far, float  fov, float aspectRatio) {
		
		final float fd = (float) (1f / Math.tan( (fov*(Math.PI/180f)) / 2f ));
		final float a1 = (far + near) / (far - near);
		final float a2 = (2f * far * near) / (near - far);
		
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
	public Matrix4f setToOrthographic2D(float x, float y, float width, float height) {
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
	public Matrix4f setToOrthographic2D(float x, float y, float width, float height, float near, float far) {
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
	public Matrix4f setToOrthographic(float left, float right, float bottom, float top, float near, float far) {
		
		final float xOrth = 2f / (right - left);
		final float yOrth = 2f / (top - bottom);
		final float zOrth = 2f / (far - near);
		
		final float tx = -(right + left) / (right - left);
		final float ty = -(top + bottom) / (top - bottom);
		final float tz = -(far + near) / (far - near);

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
	public Matrix4f setToTranslation(IVector3 vec) {
		return setToTranslation(vec.getFloatX(), vec.getFloatY(), vec.getFloatZ());
	}
	
	
	/**
	 * Sets this matrix to a translation matrix
	 * @param x	the x component of the translation
	 * @param y	the y component of the translation
	 * @param z	the z component of the translation
	 * @return this matrix for chaining
	 * */
	public Matrix4f setToTranslation(float x, float y, float z) {
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
	public Matrix4f setToScale(IVector3 vec) {
		return this.setToScale(vec.getFloatX(), vec.getFloatY(), vec.getFloatZ());
	}

	
	/**
	 * Sets this matrix to a scale matrix
	 * @param x	the x component of the scaling
	 * @param y	the y component of the scaling
	 * @param z	the z component of the scaling
	 * @return this matrix for chaining
	 * */
	public Matrix4f setToScale(float x, float y, float z) {
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
	public Matrix4f setToTranslationAndScale(IVector3 translation, IVector3 scaling) {
		return this.setToTranslationAndScale(
				translation.getFloatX(), translation.getFloatY(), translation.getFloatZ(),
				scaling.getFloatX(), scaling.getFloatY(), scaling.getFloatZ());
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
	public Matrix4f setToTranslationAndScale(float tx, float ty, float tz, float sx, float sy, float sz) {
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
	public float getTranslationX() {
		return getData()[0][3];
	}
	
	
	
	
	/**
	 * @return the y component of the translation of this matrix
	 * */
	public float getTranslationY() {
		return getData()[1][3];
	}
	
	
	
	
	/**
	 * @return the z component of the translation of this matrix
	 * */
	public float getTranslationZ() {
		return getData()[2][3];
	}
	
	
	
	
	/**
	 * @return a vector representing the translation of this matrix
	 * */
	public Vector3f getTranslation() {
		return new Vector3f(getTranslationX(), getTranslationY(), getTranslationZ());
	}

	
	
	
	/**
	 * @return the x component of the scaling of this matrix
	 * */
	public float getScalingX() {
		return (float) Math.sqrt(getData()[0][0]*getData()[0][0] + getData()[0][1]*getData()[0][1] + getData()[0][2]*getData()[0][2]);
	}
	
	
	
	
	/**
	 * @return the y component of the scaling of this matrix
	 * */
	public float getScalingY() {
		return (float) Math.sqrt(getData()[1][0]*getData()[1][0] + getData()[1][1]*getData()[1][1] + getData()[1][2]*getData()[1][2]);
	}
	
	
	
	
	/**
	 * @return the z component of the scaling of this matrix
	 * */
	public float getScalingZ() {
		return (float) Math.sqrt(getData()[2][0]*getData()[2][0] + getData()[2][1]*getData()[2][1] + getData()[2][2]*getData()[2][2]);
	}
	
	
	
	
	/**
	 * @return a vector representing the scaling of this matrix
	 * */
	public Vector3f getScaling() {
		return new Vector3f(getScalingX(), getScalingY(), getScalingZ());
	}
	
	
}

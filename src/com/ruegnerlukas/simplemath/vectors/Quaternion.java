package com.ruegnerlukas.simplemath.vectors;

import com.ruegnerlukas.simplemath.MathUtils;
import com.ruegnerlukas.simplemath.matrix.IMatrix;
import com.ruegnerlukas.simplemath.matrix.Matrix4f;
import com.ruegnerlukas.simplemath.vectors.vec3.IVector3;
import com.ruegnerlukas.simplemath.vectors.vec3.Vector3f;
import com.ruegnerlukas.simplemath.vectors.vec4.IVector4;
import com.ruegnerlukas.simplemath.vectors.vec4.Vector4f;

public class Quaternion extends Vector4f {

	
	
	
	public Quaternion() {
		super();
	}
	
	
	public Quaternion(IVector4 vec) {
		super(vec);
	}
	
	
	public Quaternion(Quaternion q) {
		super(q.x, q.y, q.z, q.w);
	}
	
	
	public Quaternion(float x, float y, float z, float w) {
		super(x, y, z, w);
	}
	
	
	
	
	@Override
	public Quaternion set(int index, Number value) {
		return (Quaternion) super.set(index, value);
	}
	
	
	
	
	@Override
	public Quaternion negate() {
		return (Quaternion) super.negate();
	}
	
	
	
	
	@Override
	public Quaternion normalize() {
		return (Quaternion) super.normalize();
	}
	
	
	
	
	@Override
	public Quaternion copy() {
		return (Quaternion) super.copy();
	}
	
	
	
	
	@Override
	public Quaternion set(IVector4 v) {
		return (Quaternion) super.set(v);
	}
	
	
	
	
	@Override
	public Quaternion set(Number x, Number y, Number z, Number w) {
		return (Quaternion) super.set(x, y, z, w);
	}
	
	
	
	
	@Override
	public Quaternion set(Number xyzw) {
		return (Quaternion) super.set(xyzw);
	}
	
	
	
	
	@Override
	public Quaternion set(float xyzw) {
		return (Quaternion) super.set(xyzw);
	}
	
	
	
	
	@Override
	public Quaternion set(float x, float y, float z, float w) {
		return (Quaternion) super.set(x, y, z, w);
	}
	
	
	
	
	@Override
	public Quaternion add(IVector4 vec) {
		return (Quaternion) super.add(vec);
	}
	
	
	
	
	@Override
	public Quaternion add(Number x, Number y, Number z, Number w) {
		return (Quaternion) super.add(x, y, z, w);
	}
	
	
	
	
	@Override
	public Quaternion add(Number xyzw) {
		return (Quaternion) super.add(xyzw);
	}
	
	
	
	
	@Override
	public Quaternion add(float xyzw) {
		return (Quaternion) super.add(xyzw);
	}
	
	

	
	@Override
	public Quaternion add(float x, float y, float z, float w) {
		return (Quaternion) super.add(x, y, z, w);
	}
	
	
	
	
	@Override
	public Quaternion sub(IVector4 vec) {
		return (Quaternion) super.sub(vec);
	}
	
	

	
	@Override
	public Quaternion sub(Number x, Number y, Number z, Number w) {
		return (Quaternion) super.sub(x, y, z, w);
	}

	
	
	
	@Override
	public Quaternion sub(Number xyzw) {
		return (Quaternion) super.sub(xyzw);
	}
	
	
	
	
	@Override
	public Quaternion sub(float xyzw) {
		return (Quaternion) super.sub(xyzw);
	}
	
	
	
	
	@Override
	public Quaternion sub(float x, float y, float z, float w) {
		return (Quaternion) super.sub(x, y, z, w);
	}
	
	
	
	
	@Override
	public Quaternion mul(IVector4 vec) {
		return (Quaternion) super.mul(vec);
	}

	
	
	
	@Override
	public Quaternion mul(Number x, Number y, Number z, Number w) {
		return (Quaternion) super.mul(x, y, z, w);
	}

	
	
	
	@Override
	public Quaternion scale(Number xyzw) {
		return (Quaternion) super.scale(xyzw);
	}
	
	
	
	
	@Override
	public Quaternion scale(float xyzw) {
		return (Quaternion) super.scale(xyzw);
	}
	
	
	

	@Override
	public Quaternion mul(float x, float y, float z, float w) {
		return (Quaternion) super.mul(x, y, z, w);
	}
	
	
	

	@Override
	public Quaternion div(IVector4 vec) {
		return (Quaternion) super.div(vec);
	}

	
	
	
	@Override
	public Quaternion div(Number x, Number y, Number z, Number w) {
		return (Quaternion) super.div(x, y, z, w);
	}

	
	
	
	@Override
	public Quaternion div(Number xyzw) {
		return (Quaternion) super.div(xyzw);
	}

	
	

	@Override
	public Quaternion div(float xyzw) {
		return (Quaternion) super.div(xyzw);
	}
	
	
	
	
	@Override
	public Quaternion div(float x, float y, float z, float w) {
		return (Quaternion) super.div(x, y, z, w);
	}
	
	
	
	
	@Override
	public String toString() {
		return "Quaternion." + this.hashCode() + " (" + this.x + ", " + this.y + ", " + this.z + ", " + this.w + ")";
	}
	
	
	
	
	/**
	 * Sets this quaternion to an identity
	 * @return this quaternion for chaining
	 * */
	public Quaternion setToIdentity() {
		this.set(0, 0, 0, 1);
		return this;
	}
	
	
	
	
	/**
	 * Sets this quaternion to the quaternion product
	 * @param q the right Quaternion
	 * @return this quaternion for chaining
	 * */
	public Quaternion mul(Quaternion q) {
		final float x = this.x * q.w  +  this.w * q.x  +  this.y * q.z  -  this.z * q.y;
		final float y = this.y * q.w  +  this.w * q.y  +  this.z * q.x  -  this.x * q.z;
		final float z = this.z * q.w  +  this.w * q.z  +  this.x * q.y  -  this.y * q.x;
		final float w = this.w * q.w  -  this.x * q.w  -  this.y * q.y  -  this.z * q.z;
		return (Quaternion) this.set(x, y, z, w);
	}
	
	
	
	
	/**
	 * Sets this value of this quaternion to the to the equivalent rotation of the Axis-Angle argument.
	 * @param vec the axis-angle. x,y,z as the axis and w as the angle in degrees
	 * @return this quaternion for chaining
	 * */
	public Quaternion setFromAxisAngleDeg(IVector4 vec) {
		return this.setFromAxisAngleRad(vec.getFloatX(), vec.getFloatY(), vec.getFloatZ(), (float)Math.toRadians(vec.getFloatW()));
	}
	
	
	
	/**
	 * Sets this value of this quaternion to the to the equivalent rotation of the Axis-Angle argument.
	 * @param ax	the x-component of the axis
	 * @param ay	the y-component of the axis
	 * @param az	the z-component of the axis
	 * @param angle	the angle in degrees
	 * @return this quaternion for chaining
	 * */
	public Quaternion setFromAxisAngleDeg(float ax, float ay, float az, float angle) {
		return this.setFromAxisAngleRad(ax, ay, az, (float)Math.toRadians(angle));
	}
	
	
	/**
	 * Sets this value of this quaternion to the to the equivalent rotation of the Axis-Angle argument.
	 * @param vec the axis-angle. x,y,z as the axis and w as the angle in radians
	 * @return this quaternion for chaining
	 * */
	public Quaternion setFromAxisAngleRad(IVector4 vec) {
		return this.setFromAxisAngleRad(vec.getFloatX(), vec.getFloatY(), vec.getFloatZ(), vec.getFloatW());
	}
	
	
	
	/**
	 * Sets this value of this quaternion to the to the equivalent rotation of the Axis-Angle argument.
	 * @param ax	the x-component of the axis
	 * @param ay	the y-component of the axis
	 * @param az	the z-component of the axis
	 * @param angle	the angle in radians
	 * @return this quaternion for chaining
	 * */
	public Quaternion setFromAxisAngleRad(float ax, float ay, float az, float angle) {
		
		float d = (float) Math.sqrt(ax * ax + ay * ay + az * az);
		
		if (d == 0f)
			return this.setToIdentity();
		d = 1f / d;

		double PI2 = (Math.PI*2);
		double l_ang = angle < 0 ? PI2 - (-angle % PI2) : angle % PI2;
		float l_sin = (float) Math.sin(l_ang / 2);
		float l_cos = (float) Math.cos(l_ang / 2);
		
		return this.set(d * ax * l_sin, d * ay * l_sin, d * az * l_sin, l_cos).normalize();
	}
	
	
	
	
	/**
	 * Sets the component of this quaternion from the given matrix
	 * @param mat the (rotation) matrix. Must be at least 3x3
	 * @return this quaternion for chaining
	 * */
	public Quaternion setFromMatrix(IMatrix mat) {
		if(mat.getNumberColumns() >= 3 && mat.getNumberRows() >= 3) {
		
			mat.setUnsafe(true);
			setFromMatrix(	mat.getFloat(0, 0), mat.getFloat(0, 1), mat.getFloat(0, 2),
							mat.getFloat(1, 0), mat.getFloat(1, 1), mat.getFloat(1, 2),
							mat.getFloat(2, 0), mat.getFloat(2, 1), mat.getFloat(2, 2) );
			mat.setUnsafe(false);
			return this;
		} else {
			throw new IllegalArgumentException("matrix must be at least 3x3.");
		}
	}
	
	
	
	
	/**
	 * Sets the component of this quaternion from the given matrix
	 * @param mat the (rotation) matrix
	 * @return this quaternion for chaining
	 * */
	public Quaternion setFromMatrix(Matrix4f mat) {
		return setFromMatrix(mat.getData()[0][0], mat.getData()[0][1], mat.getData()[0][2],
							 mat.getData()[1][0], mat.getData()[1][1], mat.getData()[1][2],
							 mat.getData()[2][0], mat.getData()[2][1], mat.getData()[2][2] );
	}
	
	
	
	
	/**
	 * Sets the component of this quaternion from the given matrix
	 * @return this quaternion for chaining
	 * */
	public Quaternion setFromMatrix(float m00, float m01, float m02,
									 float m10, float m11, float m12,
									 float m20, float m21, float m22) {
		
		float trace = m00 + m11 + m22;
	
		if(trace >= 0.0) {
			float s = (float) Math.sqrt(trace + 1f);
			this.w = s * 0.5f;
			s = 0.5f / s;
			this.x = (m21 - m12) * s;
			this.y = (m02 - m20) * s;
			this.z = (m10 - m01) * s;
			
		} else {
			
			float max = Math.max(Math.max(m00, m11), m22);
			
			if(max == m00) {
				float s = (float) Math.sqrt(m00 - (m11+m22) + 1f);
				this.x = s * 0.5f;
				s = 0.5f / s;
				this.y = (m01 + m10) * s;
				this.z = (m20 + m02) * s;
				this.w = (m21 - m12) * s;
				
			} else if(max == m11) {
				float s = (float) Math.sqrt(m11 - (m22+m00) + 1f);
				this.y = s * 0.5f;
				s = 0.5f / s;
				this.z = (m12 + m21) * s;
				this.x = (m01 + m10) * s;
				this.w = (m02 - m20) * s;
				
			} else if(max == m22) {
				float s = (float) Math.sqrt(m22 - (m00+m11) + 1f);
				this.z = s * 0.5f;
				s = 0.5f / s;
				this.x = (m20 + m02) * s;
				this.y = (m12 + m21) * s;
				this.w = (m10 - m01) * s;
			}
			
		}
		
		return this;
	} 
	
	
	
	
	/**
	 * Sets this quaternion from the given euler angles
	 * @param yaw	the yaw angle in degrees
	 * @param pitch	the pitch angle in degrees
	 * @param roll	the roll angle in degrees
	 * @return this quaternion for chaining
	 * */
	public Quaternion setFromEulerDeg(float yaw, float pitch , float roll) {
		return this.setFromEulerRad((float)Math.toRadians(yaw), (float)Math.toRadians(pitch), (float)Math.toRadians(roll));
	}

	
	/**
	 * Sets this quaternion from the given euler angles
	 * @param yaw	the yaw angle in radians
	 * @param pitch	the pitch angle in radians
	 * @param roll	the roll angle in radians
	 * @return this quaternion for chaining
	 * */
	public Quaternion setFromEulerRad(float yaw, float pitch , float roll) {
		
		final float hr = roll * 0.5f;
		final float shr = (float) Math.sin(hr);
		final float chr = (float) Math.cos(hr);

		final float hp = pitch * 0.5f;
		final float shp = (float) Math.sin(hp);
		final float chp = (float) Math.cos(hp);
		
		final float hy = yaw * 0.5f;
		final float shy = (float) Math.sin(hy);
		final float chy = (float) Math.cos(hy);
		
		final float chy_shp = chy * shp;
		final float shy_chp = shy * chp;
		final float chy_chp = chy * chp;
		final float shy_shp = shy * shp;

		this.x = (chy_shp * chr) + (shy_chp * shr);
		this.y = (shy_chp * chr) - (chy_shp * shr);
		this.z = (chy_chp * shr) - (shy_shp * chr);
		this.w = (chy_chp * chr) + (shy_shp * shr);
		
		return this;
	}
	
	
	
	
	/**
	 * Creates a vector3f which represents the x axis of this quaternion
	 * @return the x axis as the created vector
	 * */
	public Vector3f getXAxis() {
		return (Vector3f) getXAxis(null);
	}
	
	
	/**
	 * Sets the distination vector to the x axis of this quaternion
	 * @param dest the destination vector or null
	 * @return the x axis as the given vector
	 * */
	public IVector3 getXAxis(IVector3 dest) {
		if(dest == null) {
			dest = new Vector3f();
		}
		
		final float ty = 2f * y;
		final float tz = 2f * z;
		
		final float twy = ty * w;
		final float twz = tz * w;
		
		final float txy = ty * x;
		final float txz = tz * x;
		final float tyy = ty * y;
		final float tzz = tz * z;
	
		final float ax = 1f - (tyy+tzz);
		final float ay = txy + twz;
		final float az = txz - twy;
		
		dest.set(ax, ay, az);
		return dest;
	}
	
	
	
	
	/**
	 * Creates a vector3f which represents the y axis of this quaternion
	 * @return the y axis as the created vector
	 * */
	public Vector3f getYAxis() {
		return (Vector3f) getYAxis(null);
	}
	
	
	/**
	 * Sets the distination vector to the y axis of this quaternion
	 * @param dest the destination vector or null
	 * @return the y axis as the given vector
	 * */
	public IVector3 getYAxis(IVector3 dest) {
		if(dest == null) {
			dest = new Vector3f();
		}
		
		final float tx = 2f * x;
		final float ty = 2f * y;
		final float tz = 2f * z;
		
		final float twx = tx * w;
		final float twz = tz * w;
		
		final float txx = tx * x;
		final float txy = ty * x;
		final float tyz = tz * y;
		final float tzz = tz * z;
	
		final float ax = txy - twz;
		final float ay = 1f - (txx+tzz);
		final float az = tyz + twx;
		
		dest.set(ax, ay, az);
		return dest;
	}
	
	
	
	
	/**
	 * Creates a vector3f which represents the z axis of this quaternion
	 * @return the z axis as the created vector
	 * */
	public Vector3f getZAxis() {
		return (Vector3f) getYAxis(null);
	}
	
	/**
	 * Sets the destination vector to the z axis of this quaternion
	 * @param dest the destination vector or null
	 * @return the z axis as the given vector
	 * */
	public IVector3 getZAxis(IVector3 dest) {
		if(dest == null) {
			dest = new Vector3f();
		}
		
		final float tx = 2f * x;
		final float ty = 2f * y;
		final float tz = 2f * z;
		
		final float twx = tx * w;
		final float twy = ty * w;
		
		final float txx = tx * x;
		final float txz = tz * x;
		final float tyy = ty * y;
		final float tyz = tz * y;
	
		final float ax = txz+twy;
		final float ay = tyz-twx;
		final float az = 1f - (txx+tyy);
		
		dest.set(ax, ay, az);
		return dest;
	}
	
	
	
	
	/**
	 * Get the pole of the gimbal lock. This quaternion must be normalized.
	 * @return +1 for north pole, -1 for south pole, 0 for no gimbal lock
	 * */
	public int getGimbalPole() {
		final float t = y*x + z*w;
		return t > 0.499f ? 1 : (t < -0.499f ? -1 : 0);
	}
	
	
	
	
	/**
	 * Gets the pitch angle. This quaternion must be normalized.
	 * @return the pitch angle in degreees
	 * */
	public float getRotationXDeg() {
		return (float) Math.toDegrees(this.getRotationXRad());
	}
	
	
	/**
	 * Gets the pitch angle. This quaternion must be normalized.
	 * @return the pitch angle in radians
	 * */
	public float getRotationXRad() {
		final int pole = getGimbalPole();
		if(pole == 0) {
			return (float) Math.asin(MathUtils.clamp(2f*(w*x-z*y), -1, 1));
		} else {
			return (float) (pole * Math.PI * 0.5f);
		}
	}
	
	
	
	
	/**
	 * Gets the yaw angle. This quaternion must be normalized.
	 * @return the yaw angle in degreees
	 * */
	public float getRotationYDeg() {
		return (float) Math.toDegrees(this.getRotationYRad());
	}
	
	
	/**
	 * Gets the yaw angle. This quaternion must be normalized.
	 * @return the yaw angle in radians
	 * */
	public float getRotationYRad() {
		final int pole = getGimbalPole();
		if(pole == 0) {
			return (float) Math.atan2(2f*(y*w+x*z), 1f-2.0*(x*x+y*y));
		} else {
			return 0;
		}
	}
	
	
	
	
	/**
	 * Gets the roll angle. This quaternion must be normalized.
	 * @return the roll angle in degreees
	 * */
	public float getRotationZDeg() {
		return (float) Math.toDegrees(this.getRotationZRad());
	}
	
	
	/**
	 * Gets the roll angle. This quaternion must be normalized.
	 * @return the roll angle in radians
	 * */
	public float getRotationZRad() {
		final int pole = getGimbalPole();
		if(pole == 0) {
			return (float) Math.atan2(2f*(w*z+y*x), 1f-2f*(x*x+z*z));
		} else {
			return (float) (pole * 2f * Math.atan2(y, w));
		}
	}
	
	
	
	
	/**
	 * Creates a new matrix representing this quaternion. This quaternion must be normalized.
	 * @return the created matrix representing this quaternion.
	 * */
	public Matrix4f toRotationMatrix() {
		return toRotationMatrix(null);
	}
	
	
	/**
	 * Sets the given matrix to represent this quaternion. This quaternion must be normalized.
	 * @param dest the destination matrix
	 * @return the destination matrix representing this quaternion.
	 * */
	public Matrix4f toRotationMatrix(Matrix4f dest) {
		if(dest == null) {
			dest = new Matrix4f();
		}

		final float xx = x * x;
		final float xy = x * y;
		final float xz = x * z;
		final float xw = x * w;
		final float yy = y * y;
		final float yz = y * z;
		final float yw = y * w;
		final float zz = z * z;
		final float zw = z * w;

		dest.getData()[0][0] = 1f - 2f*(yy+zz);
		dest.getData()[1][0] = 2f * (xy-zw);
		dest.getData()[2][0] = 2f * (xz + yw);
		dest.getData()[3][0] = 0;

		dest.getData()[0][1] = 2f * (xy + zw);
		dest.getData()[1][1] = 1f - 2f*(xx+zz);
		dest.getData()[2][1] = 2f * (yz - xw);
		dest.getData()[3][1] = 0;

		dest.getData()[0][2] = 2f * (xz - yw);
		dest.getData()[1][2] = 2f * (yz + zw);
		dest.getData()[2][2] = 1f - 2f*(xx+yy);
		dest.getData()[3][2] = 0;

		dest.getData()[0][3] = 0;
		dest.getData()[1][3] = 0;
		dest.getData()[2][3] = 0;
		dest.getData()[3][3] = 1;
		
		return dest;
	}
	
}


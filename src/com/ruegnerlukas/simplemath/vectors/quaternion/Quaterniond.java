package com.ruegnerlukas.simplemath.vectors.quaternion;

import com.ruegnerlukas.simplemath.MathUtils;
import com.ruegnerlukas.simplemath.matrix.IMatrix;
import com.ruegnerlukas.simplemath.matrix.matrix4.Matrix4d;
import com.ruegnerlukas.simplemath.matrix.matrix4.Matrix4f;
import com.ruegnerlukas.simplemath.vectors.vec3.IVector3;
import com.ruegnerlukas.simplemath.vectors.vec3.Vector3d;
import com.ruegnerlukas.simplemath.vectors.vec4.IVector4;
import com.ruegnerlukas.simplemath.vectors.vec4.Vector4d;

public class Quaterniond extends Vector4d implements IQuaternion {

	
	
	
	public Quaterniond() {
		super();
	}
	
	
	public Quaterniond(IVector4 vec) {
		super(vec);
	}
	
	
	public Quaterniond(IQuaternion q) {
		super(q.getDoubleX(), q.getDoubleY(), q.getDoubleZ(), q.getDoubleW());
	}
	
	
	public Quaterniond(double x, double y, double z, double w) {
		super(x, y, z, w);
	}
	
	
	
	
	@Override
	public Quaterniond set(int index, Number value) {
		return (Quaterniond) super.set(index, value);
	}
	
	
	
	
	@Override
	public Quaterniond negate() {
		return (Quaterniond) super.negate();
	}
	
	
	
	
	@Override
	public Quaterniond normalize() {
		return (Quaterniond) super.normalize();
	}
	
	
	
	
	@Override
	public Quaterniond copy() {
		return (Quaterniond) super.copy();
	}
	
	
	
	
	@Override
	public Quaterniond set(IQuaternion q) {
		return this.set(q.getDoubleX(), q.getDoubleY(), q.getDoubleZ(), q.getDoubleW());
	}
	
	
	
	
	@Override
	public Quaterniond set(IVector4 v) {
		return (Quaterniond) super.set(v);
	}
	
	
	
	
	@Override
	public Quaterniond set(Number x, Number y, Number z, Number w) {
		return (Quaterniond) super.set(x, y, z, w);
	}
	
	
	
	
	@Override
	public Quaterniond set(Number xyzw) {
		return (Quaterniond) super.set(xyzw);
	}
	
	
	
	
	@Override
	public Quaterniond set(double xyzw) {
		return (Quaterniond) super.set(xyzw);
	}
	
	
	
	
	@Override
	public Quaterniond set(double x, double y, double z, double w) {
		return (Quaterniond) super.set(x, y, z, w);
	}
	
	
	
	
	@Override
	public Quaterniond add(IVector4 vec) {
		return (Quaterniond) super.add(vec);
	}
	
	
	
	
	@Override
	public Quaterniond add(Number x, Number y, Number z, Number w) {
		return (Quaterniond) super.add(x, y, z, w);
	}
	
	
	
	
	@Override
	public Quaterniond add(Number xyzw) {
		return (Quaterniond) super.add(xyzw);
	}
	
	
	
	
	@Override
	public Quaterniond add(double xyzw) {
		return (Quaterniond) super.add(xyzw);
	}
	
	

	
	@Override
	public Quaterniond add(double x, double y, double z, double w) {
		return (Quaterniond) super.add(x, y, z, w);
	}
	
	
	
	
	@Override
	public Quaterniond sub(IVector4 vec) {
		return (Quaterniond) super.sub(vec);
	}
	
	

	
	@Override
	public Quaterniond sub(Number x, Number y, Number z, Number w) {
		return (Quaterniond) super.sub(x, y, z, w);
	}

	
	
	
	@Override
	public Quaterniond sub(Number xyzw) {
		return (Quaterniond) super.sub(xyzw);
	}
	
	
	
	
	@Override
	public Quaterniond sub(double xyzw) {
		return (Quaterniond) super.sub(xyzw);
	}
	
	
	
	
	@Override
	public Quaterniond sub(double x, double y, double z, double w) {
		return (Quaterniond) super.sub(x, y, z, w);
	}
	
	
	
	
	@Override
	public Quaterniond mul(IVector4 vec) {
		return (Quaterniond) super.mul(vec);
	}
	
	
	
	
	@Override
	public Quaterniond mul(Number x, Number y, Number z, Number w) {
		return (Quaterniond) super.mul(x, y, z, w);
	}

	
	
	
	@Override
	public Quaterniond scale(Number xyzw) {
		return (Quaterniond) super.scale(xyzw);
	}
	
	
	
	
	@Override
	public Quaterniond scale(double xyzw) {
		return (Quaterniond) super.scale(xyzw);
	}
	
	
	

	@Override
	public Quaterniond mul(double x, double y, double z, double w) {
		return (Quaterniond) super.mul(x, y, z, w);
	}
	
	
	

	@Override
	public Quaterniond div(IVector4 vec) {
		return (Quaterniond) super.div(vec);
	}

	
	
	
	@Override
	public Quaterniond div(Number x, Number y, Number z, Number w) {
		return (Quaterniond) super.div(x, y, z, w);
	}

	
	
	
	@Override
	public Quaterniond div(Number xyzw) {
		return (Quaterniond) super.div(xyzw);
	}

	
	

	@Override
	public Quaterniond div(double xyzw) {
		return (Quaterniond) super.div(xyzw);
	}
	
	
	
	
	@Override
	public Quaterniond div(double x, double y, double z, double w) {
		return (Quaterniond) super.div(x, y, z, w);
	}
	
	
	
	
	@Override
	public String toString() {
		return "Quaterniond." + this.hashCode() + " (" + this.x + ", " + this.y + ", " + this.z + ", " + this.w + ")";
	}
	
	
	
	
	@Override
	public Quaterniond setToIdentity() {
		this.set(0, 0, 0, 1);
		return this;
	}
	
	
	
	
	@Override
	public Quaterniond mul(IQuaternion q) {
		final double newX = this.w * q.getDoubleX() + this.x * q.getDoubleW() + this.y * q.getDoubleZ() - this.z * q.getDoubleY();
		final double newY = this.w * q.getDoubleY() + this.y * q.getDoubleW() + this.z * q.getDoubleX() - this.x * q.getDoubleZ();
		final double newZ = this.w * q.getDoubleZ() + this.z * q.getDoubleW() + this.x * q.getDoubleY() - this.y * q.getDoubleX();
		final double newW = this.w * q.getDoubleW() - this.x * q.getDoubleX() - this.y * q.getDoubleY() - this.z * q.getDoubleZ();
		return (Quaterniond) this.set(newX, newY, newZ, newW);
	}
	
	
	
	
	@Override
	public Quaterniond mulLeft(IQuaternion q) {
		final double newX = q.getDoubleW() * this.x + q.getDoubleX() * this.w + q.getDoubleY() * this.z - q.getDoubleZ() * this.y;
		final double newY = q.getDoubleW() * this.y + q.getDoubleY() * this.w + q.getDoubleZ() * this.x - q.getDoubleX() * this.z;
		final double newZ = q.getDoubleW() * this.z + q.getDoubleZ() * this.w + q.getDoubleX() * this.y - q.getDoubleY() * this.x;
		final double newW = q.getDoubleW() * this.w - q.getDoubleX() * this.x - q.getDoubleY() * this.y - q.getDoubleZ() * this.z;
		return (Quaterniond) this.set(newX, newY, newZ, newW);
	}
	
	
	
	
	
	@Override
	public Quaterniond setFromAxisAngleDeg(IVector4 vec) {
		return this.setFromAxisAngleRad(vec.getDoubleX(), vec.getDoubleY(), vec.getDoubleZ(), Math.toRadians(vec.getDoubleW()));
	}
	
	
	
	/**
	 * Sets this value of this quaternion to the to the equivalent rotation of the Axis-Angle argument.
	 * @param ax	the x-component of the axis
	 * @param ay	the y-component of the axis
	 * @param az	the z-component of the axis
	 * @param angle	the angle in degrees
	 * @return this quaternion for chaining
	 * */
	public Quaterniond setFromAxisAngleDeg(double ax, double ay, double az, double angle) {
		return this.setFromAxisAngleRad(ax, ay, az, Math.toRadians(angle));
	}
	
	
	@Override
	public Quaterniond setFromAxisAngleRad(IVector4 vec) {
		return this.setFromAxisAngleRad(vec.getDoubleX(), vec.getDoubleY(), vec.getDoubleZ(), vec.getDoubleW());
	}
	
	
	
	/**
	 * Sets this value of this quaternion to the to the equivalent rotation of the Axis-Angle argument.
	 * @param ax	the x-component of the axis
	 * @param ay	the y-component of the axis
	 * @param az	the z-component of the axis
	 * @param angle	the angle in radians
	 * @return this quaternion for chaining
	 * */
	public Quaterniond setFromAxisAngleRad(double ax, double ay, double az, double angle) {
		
		double d = Math.sqrt(ax * ax + ay * ay + az * az);
		
		if (d == 0)
			return this.setToIdentity();
		d = 1.0 / d;

		double PI2 = (Math.PI*2);
		double l_ang = angle < 0 ? PI2 - (-angle % PI2) : angle % PI2;
		double l_sin = Math.sin(l_ang / 2);
		double l_cos = Math.cos(l_ang / 2);
		
		return this.set(d * ax * l_sin, d * ay * l_sin, d * az * l_sin, l_cos).normalize();
	}
	
	
	
	
	@Override
	public Quaterniond setFromMatrix(IMatrix mat) {
		if(mat.getNumberColumns() >= 3 && mat.getNumberRows() >= 3) {
		
			boolean wasUnsafe = mat.isUnsafe();
			mat.setUnsafe(true);
			setFromMatrix(	mat.getDouble(0, 0), mat.getDouble(0, 1), mat.getDouble(0, 2),
							mat.getDouble(1, 0), mat.getDouble(1, 1), mat.getDouble(1, 2),
							mat.getDouble(2, 0), mat.getDouble(2, 1), mat.getDouble(2, 2) );
			mat.setUnsafe(wasUnsafe);
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
	public Quaterniond setFromMatrix(Matrix4f mat) {
		return setFromMatrix(mat.getData()[0][0], mat.getData()[0][1], mat.getData()[0][2],
							 mat.getData()[1][0], mat.getData()[1][1], mat.getData()[1][2],
							 mat.getData()[2][0], mat.getData()[2][1], mat.getData()[2][2] );
	}
	
	
	
	
	/**
	 * Sets the component of this quaternion from the given matrix
	 * @return this quaternion for chaining
	 * */
	public Quaterniond setFromMatrix(double m00, double m01, double m02,
									 double m10, double m11, double m12,
									 double m20, double m21, double m22) {
		
		double trace = m00 + m11 + m22;
	
		if(trace >= 0.0) {
			double s = Math.sqrt(trace + 1f);
			this.w = s * 0.5;
			s = 0.5 / s;
			this.x = (m21 - m12) * s;
			this.y = (m02 - m20) * s;
			this.z = (m10 - m01) * s;
			
		} else {
			
			double max = Math.max(Math.max(m00, m11), m22);
			
			if(max == m00) {
				double s = Math.sqrt(m00 - (m11+m22) + 1f);
				this.x = s * 0.5;
				s = 0.5 / s;
				this.y = (m01 + m10) * s;
				this.z = (m20 + m02) * s;
				this.w = (m21 - m12) * s;
				
			} else if(max == m11) {
				double s = Math.sqrt(m11 - (m22+m00) + 1f);
				this.y = s * 0.5;
				s = 0.5 / s;
				this.z = (m12 + m21) * s;
				this.x = (m01 + m10) * s;
				this.w = (m02 - m20) * s;
				
			} else if(max == m22) {
				double s = Math.sqrt(m22 - (m00+m11) + 1f);
				this.z = s * 0.5;
				s = 0.5 / s;
				this.x = (m20 + m02) * s;
				this.y = (m12 + m21) * s;
				this.w = (m10 - m01) * s;
			}
			
		}
		
		return this;
	} 
	
	
	
	
	@Override
	public Quaterniond setFromEulerDeg(IVector3 angles) {
		return this.setFromEulerDeg(angles.getDoubleX(), angles.getDoubleY(), angles.getDoubleZ());
	}
	
	
	@Override
	public Quaterniond setFromEulerRad(IVector3 angles) {
		return this.setFromEulerRad(angles.getDoubleX(), angles.getDoubleY(), angles.getDoubleZ());
	}
	
	
	/**
	 * Sets this quaternion from the given euler angles
	 * @param yaw	the yaw angle in degrees
	 * @param pitch	the pitch angle in degrees
	 * @param roll	the roll angle in degrees
	 * @return this quaternion for chaining
	 * */
	public Quaterniond setFromEulerDeg(double yaw, double pitch , double roll) {
		return this.setFromEulerRad(Math.toRadians(yaw), Math.toRadians(pitch), Math.toRadians(roll));
	}

	
	/**
	 * Sets this quaternion from the given euler angles
	 * @param yaw	the yaw angle in radians
	 * @param pitch	the pitch angle in radians
	 * @param roll	the roll angle in radians
	 * @return this quaternion for chaining
	 * */
	public Quaterniond setFromEulerRad(double yaw, double pitch , double roll) {
		
		final double hr = roll * 0.5f;
		final double shr = Math.sin(hr);
		final double chr = Math.cos(hr);

		final double hp = pitch * 0.5f;
		final double shp = Math.sin(hp);
		final double chp = Math.cos(hp);
		
		final double hy = yaw * 0.5f;
		final double shy = Math.sin(hy);
		final double chy = Math.cos(hy);
		
		final double chy_shp = chy * shp;
		final double shy_chp = shy * chp;
		final double chy_chp = chy * chp;
		final double shy_shp = shy * shp;

		this.x = (chy_shp * chr) + (shy_chp * shr);
		this.y = (shy_chp * chr) - (chy_shp * shr);
		this.z = (chy_chp * shr) - (shy_shp * chr);
		this.w = (chy_chp * chr) + (shy_shp * shr);
		
		return this;
	}
	
	
	
	
	@Override
	public Vector3d getXAxis() {
		return (Vector3d) getXAxis(null);
	}
	
	
	@Override
	public IVector3 getXAxis(IVector3 dest) {
		if(dest == null) {
			dest = new Vector3d();
		}
		
		final double ty = 2f * y;
		final double tz = 2f * z;
		
		final double twy = ty * w;
		final double twz = tz * w;
		
		final double txy = ty * x;
		final double txz = tz * x;
		final double tyy = ty * y;
		final double tzz = tz * z;
	
		final double ax = 1f - (tyy+tzz);
		final double ay = txy + twz;
		final double az = txz - twy;
		
		dest.set(ax, ay, az);
		return dest;
	}
	
	
	
	
	@Override
	public Vector3d getYAxis() {
		return (Vector3d) getYAxis(null);
	}
	
	
	@Override
	public IVector3 getYAxis(IVector3 dest) {
		if(dest == null) {
			dest = new Vector3d();
		}
		
		final double tx = 2f * x;
		final double ty = 2f * y;
		final double tz = 2f * z;
		
		final double twx = tx * w;
		final double twz = tz * w;
		
		final double txx = tx * x;
		final double txy = ty * x;
		final double tyz = tz * y;
		final double tzz = tz * z;
	
		final double ax = txy - twz;
		final double ay = 1f - (txx+tzz);
		final double az = tyz + twx;
		
		dest.set(ax, ay, az);
		return dest;
	}
	
	
	
	
	@Override
	public Vector3d getZAxis() {
		return (Vector3d) getYAxis(null);
	}
	
	@Override
	public IVector3 getZAxis(IVector3 dest) {
		if(dest == null) {
			dest = new Vector3d();
		}
		
		final double tx = 2f * x;
		final double ty = 2f * y;
		final double tz = 2f * z;
		
		final double twx = tx * w;
		final double twy = ty * w;
		
		final double txx = tx * x;
		final double txz = tz * x;
		final double tyy = ty * y;
		final double tyz = tz * y;
	
		final double ax = txz+twy;
		final double ay = tyz-twx;
		final double az = 1f - (txx+tyy);
		
		dest.set(ax, ay, az);
		return dest;
	}
	
	
	
	
	@Override
	public int getGimbalPole() {
		final double t = y*x + z*w;
		return t > 0.499 ? 1 : (t < -0.499 ? -1 : 0);
	}
	
	
	
	
	/**
	 * Gets the pitch angle. This quaternion must be normalized.
	 * @return the pitch angle in degreees
	 * */
	public double getRotationXDeg() {
		return Math.toDegrees(this.getRotationXRad());
	}
	
	
	/**
	 * Gets the pitch angle. This quaternion must be normalized.
	 * @return the pitch angle in radians
	 * */
	public double getRotationXRad() {
		final int pole = getGimbalPole();
		if(pole == 0) {
			return Math.asin(MathUtils.clamp(2f*(w*x-z*y), -1, 1));
		} else {
			return (pole * Math.PI * 0.5f);
		}
	}
	
	
	
	
	/**
	 * Gets the yaw angle. This quaternion must be normalized.
	 * @return the yaw angle in degreees
	 * */
	public double getRotationYDeg() {
		return Math.toDegrees(this.getRotationYRad());
	}
	
	
	/**
	 * Gets the yaw angle. This quaternion must be normalized.
	 * @return the yaw angle in radians
	 * */
	public double getRotationYRad() {
		final int pole = getGimbalPole();
		if(pole == 0) {
			return Math.atan2(2f*(y*w+x*z), 1f-2.0*(x*x+y*y));
		} else {
			return 0;
		}
	}
	
	
	
	
	/**
	 * Gets the roll angle. This quaternion must be normalized.
	 * @return the roll angle in degreees
	 * */
	public double getRotationZDeg() {
		return Math.toDegrees(this.getRotationZRad());
	}
	
	
	/**
	 * Gets the roll angle. This quaternion must be normalized.
	 * @return the roll angle in radians
	 * */
	public double getRotationZRad() {
		final int pole = getGimbalPole();
		if(pole == 0) {
			return Math.atan2(2f*(w*z+y*x), 1f-2f*(x*x+z*z));
		} else {
			return (pole * 2f * Math.atan2(y, w));
		}
	}
	
	
	@Override
	public Vector3d getRotationDeg() {
		return new Vector3d(this.getRotationXDeg(), this.getRotationYDeg(), this.getRotationZDeg());
	}
	
	
	@Override
	public Vector3d getRotationRad() {
		return new Vector3d(this.getRotationXRad(), this.getRotationYRad(), this.getRotationZRad());
	}
	
	
	
	
	@Override
	public Matrix4d toRotationMatrix() {
		return toRotationMatrix(null);
	}
	
	
	/**
	 * Sets the given matrix to represent this quaternion. This quaternion must be normalized.
	 * @param dest the destination matrix
	 * @return the destination matrix representing this quaternion.
	 * */
	public Matrix4d toRotationMatrix(Matrix4d dest) {
		if(dest == null) {
			dest = new Matrix4d();
		}

		final double xx = x * x;
		final double xy = x * y;
		final double xz = x * z;
		final double xw = x * w;
		final double yy = y * y;
		final double yz = y * z;
		final double yw = y * w;
		final double zz = z * z;
		final double zw = z * w;

		dest.getData()[0][0] = 1.0 - 2.0*(yy+zz);
		dest.getData()[1][0] = 2.0 * (xy-zw);
		dest.getData()[2][0] = 2.0 * (xz + yw);
		dest.getData()[3][0] = 0;

		dest.getData()[0][1] = 2.0 * (xy + zw);
		dest.getData()[1][1] = 1.0 - 2.0*(xx+zz);
		dest.getData()[2][1] = 2.0 * (yz - xw);
		dest.getData()[3][1] = 0;

		dest.getData()[0][2] = 2.0 * (xz - yw);
		dest.getData()[1][2] = 2.0 * (yz + zw);
		dest.getData()[2][2] = 1.0 - 2.0*(xx+yy);
		dest.getData()[3][2] = 0;

		dest.getData()[0][3] = 0;
		dest.getData()[1][3] = 0;
		dest.getData()[2][3] = 0;
		dest.getData()[3][3] = 1;
		
		return dest;
	}
	
}


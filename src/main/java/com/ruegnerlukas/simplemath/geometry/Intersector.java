package com.ruegnerlukas.simplemath.geometry;

import java.util.List;

import com.ruegnerlukas.simplemath.MathUtils;
import com.ruegnerlukas.simplemath.vectors.vec2.Vector2f;
import com.ruegnerlukas.simplemath.vectors.vec3.Vector3f;

public class Intersector {

	
	
	
	private Intersector() {
	}
	
	
	
	
	
	
	/**
	 * checks whether two rectangles intersect
	 * @param r1x		the x-position of the first rectangle
	 * @param r1y		the y-position of the first rectangle
	 * @param r1width	the width of the first rectangle (must be positive)
	 * @param r1height	the height of the first rectangle (must be positive)
	 * @param r2x		the x-position of the second rectangle
	 * @param r2y		the y-position of the second rectangle
	 * @param r2width	the width of the second rectangle (must be positive)
	 * @param r2height	the height of the second rectangle (must be positive)
	 * @return true, if the rectangles intersect
	 * */
	public static boolean intersectsRectangleRectangle(float r1x, float r1y, float r1width, float r1height, float r2x, float r2y, float r2width, float r2height) {
		
		if(r1width == 0 || r1height == 0) { return false; }
		if(r2width == 0 || r2height == 0) { return false; }
		
		float r1MinX = r1x;
		float r1MinY = r1y;
		float r1MaxX = r1x+r1width;
		float r1MaxY = r1y+r1height;
		float r2MinX = r2x;
		float r2MinY = r2y;
		float r2MaxX = r2x+r2width;
		float r2MaxY = r2y+r2height;
		
		boolean intersects =	r1MaxX > r2MinX &&
								r1MinX < r2MaxX &&
								r1MaxY > r2MinY &&
								r1MinY < r2MaxY;
		return intersects;
	}
	
	
	
	
	/**
	 * checks whether a rectangle and a circle intersect
	 * @param rx		the x-position of the rectangle
	 * @param ry		the y-position of the rectangle
	 * @param rWidth	the width of the rectangle (must be positive)
	 * @param rHeight	the height of the rectangle (must be positive)
	 * @param cx		the x-position (center) of the circle
	 * @param cy		the y-position (center) of the circle
	 * @param cRadius	the radius of the circle
	 * @return true, if the rectangles and the circle intersect
	 * */
	public static boolean intersectsRectangleCircle(float rx, float ry, float rWidth, float rHeight, float cx, float cy, float cRadius) {
		float radius = cRadius;
		
		float rcx = rx + (rWidth/2f);
		float rcy = ry + (rHeight/2f);
		float hw = rWidth/ 2f;
		float hh = rHeight / 2f;
		
		float dx = Math.abs(cx - rcx);
		float dy = Math.abs(cy - rcy);
		
		if(dx > (radius+hw) || dy > (radius+hh)) { return false; }
		
		float cDistX = Math.abs(cx - rx - hw);
		float cDistY = Math.abs(cy - ry - hh);

		if(cDistX <= hw) { return true; }
		if(cDistY <= hh) { return true; }
		
		float cornerDistSq = ( (cDistX-hw)*(cDistX-hw) ) + ( (cDistY-hh)*(cDistY-hh) );
		
		return cornerDistSq <= radius*radius;
		
	}
	
	
	
	
	/**
	 * checks whether a rectangle and a line segment intersect and returns them in intersections
	 * @param rx		the x-position of the rectangle
	 * @param ry		the y-position of the rectangle
	 * @param rWidth	the width of the rectangle (must be positive)
	 * @param rHeight	the height of the rectangle (must be positive)
	 * @param lx1		the x-position of the first point of the line segment
	 * @param ly1		the y-position of the first point of the line segment
	 * @param lx2		the x-position of the second point of the line segment
	 * @param ly2		the y-position of the second point of the line segment
	 * @param intersections the intersection points or null
	 * @return true, if the rectangles and the line segment intersect
	 * */
	public static boolean intersectsRectangleLine(float rx, float ry, float rWidth, float rHeight, float lx1, float ly1, float lx2, float ly2, List<Vector2f> intersections) {
		
		float minX = rx;
		float minY = ry;
		float maxX = rx + rWidth;
		float maxY = ry + rHeight;
		
		//both points of one side of rectangle
		if(minX > lx1 && minX > lx2) { return false; }
		if(minY > ly1 && minY > ly2) { return false; }
		if(maxX < lx1 && maxX < lx2) { return false; }
		if(maxY < ly1 && maxY < ly2) { return false; }

		//both points of line inside rectangle
		if(	lx1 > minX && lx1 < maxX &&
			lx2 > minX && lx2 < maxX &&
			ly1 > minY && ly1 < maxY &&
			ly2 > minY && ly2 < maxY	) { return true; }
		
		//check line-line
		if(intersections != null) {
			int numIntersections = 0;
			Vector2f v1 = new Vector2f();
			if(intersectsLineLine(lx1, ly1, lx2, ly2, minX, minY, maxX, minY, v1)) { numIntersections++; if(intersections!=null) intersections.add(v1); };
			Vector2f v2 = new Vector2f();
			if(intersectsLineLine(lx1, ly1, lx2, ly2, maxX, minY, maxX, maxY, v2)) { numIntersections++; if(intersections!=null) intersections.add(v2); };
			Vector2f v3 = new Vector2f();
			if(intersectsLineLine(lx1, ly1, lx2, ly2, minX, maxY, maxX, maxY, v3)) { numIntersections++; if(intersections!=null) intersections.add(v3); };
			Vector2f v4 = new Vector2f();
			if(intersectsLineLine(lx1, ly1, lx2, ly2, minX, maxY, minX, minY, v4)) { numIntersections++; if(intersections!=null) intersections.add(v4); };
			if(numIntersections > 0) { return true; }
		} else {
			if(intersectsLineLine(lx1, ly1, lx2, ly2, minX, minY, maxX, minY, null)) { return true; };
			if(intersectsLineLine(lx1, ly1, lx2, ly2, maxX, minY, maxX, maxY, null)) { return true; };
			if(intersectsLineLine(lx1, ly1, lx2, ly2, minX, maxY, maxX, maxY, null)) { return true; };
			if(intersectsLineLine(lx1, ly1, lx2, ly2, minX, maxY, minX, minY, null)) { return true; };
		}
		
		return false;
	}
	
	
	
	
	/**
	 * checks whether a rectangle and a polygon intersect and returns them in intersections
	 * @param rx		the x-position of the rectangle
	 * @param ry		the y-position of the rectangle
	 * @param rWidth	the width of the rectangle (must be positive)
	 * @param rHeight	the height of the rectangle (must be positive)
	 * @param polygon	the points of the polygon
	 * @param intersections the intersection points or null
	 * @return true, if the rectangles and the polygon intersect
	 * */	
	public static boolean intersectsRectanglePolygon(float rx, float ry, float rWidth, float rHeight, Vector2f[] polygon, List<Vector2f> intersections) {

		float minX = rx;
		float minY = ry;
		float maxX = rx + rWidth;
		float maxY = ry + rHeight;
		
		int numPointsInRect = 0;
		for(Vector2f v : polygon) {
			if(pointInRectangle(minX, minY, maxX, maxY, v.x, v.y)) { numPointsInRect++; }
		}
		if(numPointsInRect > 0) { return true; }
		
		int numPointsInPolygon = 0;
		if(pointInPolygon(polygon, minX, minY)) { numPointsInPolygon++; }
		if(pointInPolygon(polygon, maxX, minY)) { numPointsInPolygon++; }
		if(pointInPolygon(polygon, maxX, maxY)) { numPointsInPolygon++; }
		if(pointInPolygon(polygon, minX, maxY)) { numPointsInPolygon++; }
		if(numPointsInPolygon > 0) { return true; }

		if(intersections != null) {
			int numIntersections = 0;
			for(int i=0; i<polygon.length; i++) {
				float x1 = polygon[i].x;
				float y1 = polygon[i].y;
				float x2 = polygon[(i+1) % polygon.length].x;
				float y2 = polygon[(i+1) % polygon.length].y;
				Vector2f v1 = new Vector2f();
				if(intersectsLineLine(x1, y1, x2, y2, minX, minY, maxX, minY, v1)) { numIntersections++; intersections.add(v1); }
				Vector2f v2 = new Vector2f();
				if(intersectsLineLine(x1, y1, x2, y2, maxX, minY, maxX, maxY, v2)) { numIntersections++; intersections.add(v2); }
				Vector2f v3 = new Vector2f();
				if(intersectsLineLine(x1, y1, x2, y2, maxX, maxY, minX, maxY, v3)) { numIntersections++; intersections.add(v3); }
				Vector2f v4 = new Vector2f();
				if(intersectsLineLine(x1, y1, x2, y2, minX, maxY, maxX, minY, v4)) { numIntersections++; intersections.add(v4); }
			}
			if(numIntersections > 0) { return true;}
			
		} else {
			for(int i=0; i<polygon.length; i++) {
				float x1 = polygon[i].x;
				float y1 = polygon[i].y;
				float x2 = polygon[(i+1) % polygon.length].x;
				float y2 = polygon[(i+1) % polygon.length].y;
				if(intersectsLineLine(x1, y1, x2, y2, minX, minY, maxX, minY, null)) { return true; }
				if(intersectsLineLine(x1, y1, x2, y2, maxX, minY, maxX, maxY, null)) { return true; }
				if(intersectsLineLine(x1, y1, x2, y2, maxX, maxY, minX, maxY, null)) { return true; }
				if(intersectsLineLine(x1, y1, x2, y2, minX, maxY, maxX, minY, null)) { return true; }
			}
		}
		
		return false;
	}
	
	
	/**
	 * checks whether a rectangle and a polygon intersect and returns them in intersections
	 * @param rx		the x-position of the rectangle
	 * @param ry		the y-position of the rectangle
	 * @param rWidth	the width of the rectangle (must be positive)
	 * @param rHeight	the height of the rectangle (must be positive)
	 * @param polygon	the points of the polygon as array {x0,y0,x1,y1,...,xn,yn}
	 * @param intersections the intersection points or null
	 * @return true, if the rectangles and the polygon intersect
	 * */	
	public static boolean intersectsRectanglePolygon(float rx, float ry, float rWidth, float rHeight, float[] polygon, List<Vector2f> intersections) {

		if(polygon.length % 2 != 0) {
			throw new IllegalArgumentException("Invalid polygon data size: " + polygon.length);
		}
		
		float minX = rx;
		float minY = ry;
		float maxX = rx + rWidth;
		float maxY = ry + rHeight;
		
		int numPointsInRect = 0;
		for(int i=0,n=polygon.length; i<n; ) {
			final float x = polygon[i++];
			final float y = polygon[i++];
			if(pointInRectangle(minX, minY, maxX, maxY, x, y)) { numPointsInRect++; }
		}
		if(numPointsInRect > 0) { return true; }
		
		int numPointsInPolygon = 0;
		if(pointInPolygon(polygon, minX, minY)) { numPointsInPolygon++; }
		if(pointInPolygon(polygon, maxX, minY)) { numPointsInPolygon++; }
		if(pointInPolygon(polygon, maxX, maxY)) { numPointsInPolygon++; }
		if(pointInPolygon(polygon, minX, maxY)) { numPointsInPolygon++; }
		if(numPointsInPolygon > 0) { return true; }

		if(intersections != null) {
			int numIntersections = 0;
			for(int i=0; i<polygon.length; i+=2) {
				int ix = i;
				int iy = i+1;
				float x1 = polygon[ix];
				float y1 = polygon[iy];
				float x2 = polygon[(ix+1) % (polygon.length/2)];
				float y2 = polygon[(iy+1) % (polygon.length/2)];
				Vector2f v1 = new Vector2f();
				if(intersectsLineLine(x1, y1, x2, y2, minX, minY, maxX, minY, v1)) { numIntersections++; intersections.add(v1); }
				Vector2f v2 = new Vector2f();
				if(intersectsLineLine(x1, y1, x2, y2, maxX, minY, maxX, maxY, v2)) { numIntersections++; intersections.add(v2); }
				Vector2f v3 = new Vector2f();
				if(intersectsLineLine(x1, y1, x2, y2, maxX, maxY, minX, maxY, v3)) { numIntersections++; intersections.add(v3); }
				Vector2f v4 = new Vector2f();
				if(intersectsLineLine(x1, y1, x2, y2, minX, maxY, maxX, minY, v4)) { numIntersections++; intersections.add(v4); }
			}
			if(numIntersections > 0) { return true;}
			
		} else {
			for(int i=0; i<polygon.length; i+=2) {
				int ix = i;
				int iy = i+1;
				float x1 = polygon[ix];
				float y1 = polygon[iy];
				float x2 = polygon[(ix+1) % (polygon.length/2)];
				float y2 = polygon[(iy+1) % (polygon.length/2)];
				if(intersectsLineLine(x1, y1, x2, y2, minX, minY, maxX, minY, null)) { return true; }
				if(intersectsLineLine(x1, y1, x2, y2, maxX, minY, maxX, maxY, null)) { return true; }
				if(intersectsLineLine(x1, y1, x2, y2, maxX, maxY, minX, maxY, null)) { return true; }
				if(intersectsLineLine(x1, y1, x2, y2, minX, maxY, maxX, minY, null)) { return true; }
			}
		}
		
		return false;
	}
	
	
	
	
	/**
	 * checks whether two circles intersect
	 * @param c1x		the x-position (center) of the first circle
	 * @param c1y		the y-position (center) of the first circle
	 * @param c1Radius	the radius of the first circle
	 * @param c2x		the x-position (center) of the second circle
	 * @param c2y		the y-position (center) of the second circle
	 * @param c2Radius	the radius of the second circle
	 * @return true, if the circles intersect
	 * */	
	public static boolean intersectsCircleCircle(float c1x, float c1y, float c1Radius, float c2x, float c2y, float c2Radius) {
		if(c1Radius == 0 || c2Radius == 0) { return false; }
		float distCX = c2x - c1x;
		float distCY = c2y - c1y;
		float dist2 = (distCX*distCX)  + (distCY*distCY);
		float sumR = c1Radius + c2Radius;
		return (sumR*sumR) > dist2;
	}
	
	
	
	
	/**
	 * checks whether a circle and a line segment intersect
	 * @param cx		the x-position (center) of the circle
	 * @param cy		the y-position (center) of the circle
	 * @param cRadius	the radius of the circle
	 * @param lx1		the x-position of the first point of the line segment
	 * @param ly1		the y-position of the first point of the line segment
	 * @param lx2		the x-position of the second point of the line segment
	 * @param ly2		the y-position of the second point of the line segment
	 * @return true, if the circle and the line segment intersect
	 * */
	public static boolean intersectsCircleLine(float cx, float cy, float cRadius, float lx1, float ly1, float lx2, float ly2) {
		
		// line start-end
		float dx = lx2 - lx1;
		float dy = ly2 - ly1;
		
		// center-lineStart
		float fx = lx1 - cx;
		float fy = ly1 - cy;

		float a = dot(dx, dy, dx, dy);
		float b = (2f * dot(fx, fy, dx, dy));
		float c = dot(fx, fy, fx, fy) - cRadius*cRadius;
		
		float discriminant = b*b-4*a*c;
		if(discriminant < 0) { return false; }
		
		discriminant = (float)Math.sqrt(discriminant);
		
		float t1 = (-b - discriminant) / (2*a);
		float t2 = (-b + discriminant) / (2*a);
		
		if(t1 >= 0 && t1 <= 1) {
			return true;
		}
		
		if(t2 >= 0 && t2 <= 1) {
			return true;
		}
		
		return false;
	}
	
	
	
	
	/**
	 * checks whether a circle and a polygon intersect
	 * @param cx		the x-position (center) of the circle
	 * @param cy		the y-position (center) of the circle
	 * @param cRadius	the radius of the circle
	 * @param polygon	the points of the polygon
	 * @return true, if the circle and the polygon intersect
	 * */	
	public static boolean intersectsCirclePolygon(float cx, float cy, float cRadius, Vector2f[] polygon) {
		int numPointsInCircle = 0;
		for(Vector2f v : polygon) {
			if(pointInCircle(cx, cy, cRadius, v.x, v.y)) { numPointsInCircle++; }
		}
		if(numPointsInCircle > 0) { return true; }
		
		for(int i=0; i<polygon.length; i++) {
			float x1 = polygon[i].x;
			float y1 = polygon[i].y;
			float x2 = polygon[(i+1) % polygon.length].x;
			float y2 = polygon[(i+1) % polygon.length].y;
			if(intersectsCircleLine(cx, cy, cRadius, x1, y1, x2, y2)) { return true; }
		}
		
		return false;
	}
	
	
	/**
	 * checks whether a circle and a polygon intersect
	 * @param cx		the x-position (center) of the circle
	 * @param cy		the y-position (center) of the circle
	 * @param cRadius	the radius of the circle
	 * @param polygon	the points of the polygon as an array {x0,y0,x1,y1,...,xn,yn}
	 * @return true, if the circle and the polygon intersect
	 * */	
	public static boolean intersectsCirclePolygon(float cx, float cy, float cRadius, float[] polygon) {
		if(polygon.length % 2 != 0) {
			throw new IllegalArgumentException("Invalid polygon data size: " + polygon.length);
		}
		int numPointsInCircle = 0;
		for(int i=0; i<polygon.length; ) {
			final float x = polygon[i++];
			final float y = polygon[i++];
			if(pointInCircle(cx, cy, cRadius, x, y)) { numPointsInCircle++; }
		}
		if(numPointsInCircle > 0) { return true; }
		
		for(int i=0; i<polygon.length; i+=2) {
			int ix = i;
			int iy = i+1;
			float x1 = polygon[ix];
			float y1 = polygon[iy];
			float x2 = polygon[(ix+1) % (polygon.length/2)];
			float y2 = polygon[(iy+1) % (polygon.length/2)];
			if(intersectsCircleLine(cx, cy, cRadius, x1, y1, x2, y2)) { return true; }
		}
		
		return false;
	}
	
	
	
	
	/**
	 * checks whether two line segments intersect and returns the intersection point in intersection
	 * @param x1		the x-position of the first point of the first line segment
	 * @param y1		the y-position of the first point of the first line segment
	 * @param x2		the x-position of the second point of the first line segment
	 * @param y2		the y-position of the second point of the first line segment
	 * @param x3		the x-position of the first point of the second line segment
	 * @param y3		the y-position of the first point of the second line segment
	 * @param x4		the x-position of the second point of the second line segment
	 * @param y4		the y-position of the second point of the second line segment
	 * @param intersection the intersection or null
	 * @return true, if the line segments intersect
	 * */		
	public static boolean intersectsLineLine(float x1, float y1, float x2, float y2, float x3, float y3, float x4, float y4, Vector2f intersection) {
		
		float d = (y4 - y3) * (x2 - x1) - (x4 - x3) * (y2 - y1);
		if (d == 0) return false;
		
		float yd = y1 - y3;
		float xd = x1 - x3;
		float ua = ((x4 - x3) * yd - (y4 - y3) * xd) / d;
		if (ua < 0 || ua > 1) return false;
		
		float ub = ((x2 - x1) * yd - (y2 - y1) * xd) / d;
		if (ub < 0 || ub > 1) return false;
		
		if (intersection != null) intersection.set(x1 + (x2 - x1) * ua, y1 + (y2 - y1) * ua);
		
		return true;
	}
	
	
	
	
	/**
	 * checks whether a line segment and a polygon intersect
	 * @param x1		the x-position of the first point of the line segment
	 * @param y1		the y-position of the first point of the line segment
	 * @param x2		the x-position of the second point of the line segment
	 * @param y2		the y-position of the second point of the line segment
	 * @param polygon	the points of the polygon
	 * @return true, if the circle and the line segment intersect
	 * */
	public static boolean intersectsLinePolygon(float x1, float y1, float x2, float y2, Vector2f[] polygon) {

		int n = polygon.length;
		
		float x3 = polygon[n-1].x;
		float y3 = polygon[n-1].y;

		for(int i=0; i<n; i+=2) {
			float x4 = polygon[i].x;
			float y4 = polygon[i].y;
			
			float d = (y4 - y3) * (x2 - x1) - (x4 - x3) * (y2 - y1);
			if (d != 0) {
				float yd = y1 - y3;
				float xd = x1 - x3;
				float ua = ((x4 - x3) * yd - (y4 - y3) * xd) / d;
				if (ua >= 0 && ua <= 1) {
					float ub = ((x2 - x1) * yd - (y2 - y1) * xd) / d;
					if (ub >= 0 && ub <= 1) {
						return true;
					}
				}
			}
			
			x3 = x4;
			y3 = x4;

		}
		
		return false;
	}
	
	
	
	
	/**
	 * checks whether a line segment and a polygon intersect
	 * @param x1		the x-position of the first point of the line segment
	 * @param y1		the y-position of the first point of the line segment
	 * @param x2		the x-position of the second point of the line segment
	 * @param y2		the y-position of the second point of the line segment
	 * @param polygon	the points of the polygon as an array {x0,y0,x1,y1,...,xn,yn}
	 * @return true, if the circle and the line segment intersect
	 * */
	public static boolean intersectsLinePolygon(float x1, float y1, float x2, float y2, float[] polygon) {

		if(polygon.length % 2 != 0) {
			throw new IllegalArgumentException("Invalid polygon data size: " + polygon.length);
		}
		
		int n = polygon.length/2;
		
		float x3 = polygon[n*2-2];
		float y3 = polygon[n*2-1];

		for(int i=0; i<n; i+=2) {
			float x4 = polygon[i];
			float y4 = polygon[i+1];
			
			float d = (y4 - y3) * (x2 - x1) - (x4 - x3) * (y2 - y1);
			if (d != 0) {
				float yd = y1 - y3;
				float xd = x1 - x3;
				float ua = ((x4 - x3) * yd - (y4 - y3) * xd) / d;
				if (ua >= 0 && ua <= 1) {
					float ub = ((x2 - x1) * yd - (y2 - y1) * xd) / d;
					if (ub >= 0 && ub <= 1) {
						return true;
					}
				}
			}
			
			x3 = x4;
			y3 = x4;

		}
		
		return false;
	}
	
	
	
	
	/**
	 * checks whether two polygons intersect
	 * @param polygon1	the points of the first polygon
	 * @param polygon2	the points of the second polygon
	 * @return true, if the polygons intersect
	 * */
	public static boolean intersectsPolygonPolygon(Vector2f[] polygon1, Vector2f[] polygon2) {
		int numPointsInPoly1 = 0;
		for(Vector2f v1 : polygon1) {
			if(pointInPolygon(polygon1, v1.x, v1.y)) { numPointsInPoly1++; }
		}
		if(numPointsInPoly1 > 0) { return true; }
		
		int numPointsInPoly2 = 0;
		for(Vector2f v2 : polygon2) {
			if(pointInPolygon(polygon2, v2.x, v2.y)) { numPointsInPoly2++; }
		}
		if(numPointsInPoly2 > 0) { return true; }
		
		for(int i=0; i<polygon1.length; i++) {
			float x1 = polygon1[i].x;
			float y1 = polygon1[i].y;
			float x2 = polygon1[(i+1) % polygon1.length].x;
			float y2 = polygon1[(i+1) % polygon1.length].y;
			for(int j=0; j<polygon2.length; j++) {
				float x3 = polygon1[j].x;
				float y3 = polygon1[j].y;
				float x4 = polygon1[(j+1) % polygon2.length].x;
				float y4 = polygon1[(j+1) % polygon2.length].y;
				if(intersectsLineLine(x1, y1, x2, y2, x3, y3, x4, y4, null)) { return true; }
			}
		}
		
		return false;
	}
	
	
	
	
	/**
	 * checks whether two polygons intersect
	 * @param polygon1	the points of the first polygon as an array {x0,y0,x1,y1,...,xn,yn}
	 * @param polygon2	the points of the second polygon as an array {x0,y0,x1,y1,...,xn,yn}
	 * @return true, if the polygons intersect
	 * */
	public static boolean intersectsPolygonPolygon(float[] polygon1, float[] polygon2) {
		
		if(polygon1.length % 2 != 0) {
			throw new IllegalArgumentException("Invalid polygon data size: " + polygon1.length);
		}
		if(polygon2.length % 2 != 0) {
			throw new IllegalArgumentException("Invalid polygon data size: " + polygon2.length);
		}
		
		
		int numPointsInPoly1 = 0;
		for(int i=0; i<polygon1.length; ) {
			if(pointInPolygon(polygon1, polygon1[i++], polygon1[i++])) { numPointsInPoly1++; }
		}
		if(numPointsInPoly1 > 0) { return true; }
		
		int numPointsInPoly2 = 0;
		for(int i=0; i<polygon2.length; ) {
			if(pointInPolygon(polygon2, polygon2[i++], polygon2[i++])) { numPointsInPoly2++; }
		}
		if(numPointsInPoly2 > 0) { return true; }
		
		for(int i=0; i<polygon1.length; i+=2) {
			int ix = i;
			int iy = i+1;
			float x1 = polygon1[ix];
			float y1 = polygon1[iy];
			float x2 = polygon1[(ix+1) % (polygon1.length/2)];
			float y2 = polygon1[(iy+1) % (polygon1.length/2)];
			for(int j=0; j<polygon2.length; j+=2) {
				int jx = j;
				int jy = j+1;
				float x3 = polygon1[jx];
				float y3 = polygon1[jy];
				float x4 = polygon1[(jx+1) % (polygon2.length/2)];
				float y4 = polygon1[(jy+1) % (polygon2.length/2)];
				if(intersectsLineLine(x1, y1, x2, y2, x3, y3, x4, y4, null)) { return true; }
			}
		}
		
		return false;
	}
	
	
	
	
	
	
	/**
	 * Calculates the point on the line segment nearest to the given point
	 * @param x1	the x-position of the first point of the line segment
	 * @param y1	the y-position of the first point of the line segment
	 * @param x2	the x-position of the second point of the line segment
	 * @param y2	the y-position of the second point of the line segment
	 * @param px	the x-position of the point
	 * @param py	the y-position of the point
	 * @return the point on the line segment nearest the the point
	 * */
	public static Vector2f getClosestPointOnLine(float x1, float y1, float x2, float y2, float px, float py) {
	
		double xDelta = x2 - x1;
		double yDelta = y2 - y1;
		
		// line segment with length = 0
		if( (xDelta==0) && (yDelta==0) ) {
			return new Vector2f(px, py);
		}
		
		double u = ((px - x1) * xDelta + (py - y1) * yDelta) / (xDelta * xDelta + yDelta * yDelta);
		
		Vector2f closestPoint;
		if(u < 0) {
			closestPoint = new Vector2f(x1, y1);
			
		} else if( u > 1) {
			closestPoint = new Vector2f(x2, y2);
			
		} else {
			closestPoint = new Vector2f((float)(x1+u*xDelta), (float)(y1+u*yDelta));
			
		}
		
		return closestPoint;
	}
	
	
	
	
	/** checks whether the given point is on the line segment
	 * @param x1	the x-position of the first point of the line segment
	 * @param y1	the y-position of the first point of the line segment
	 * @param x2	the x-position of the second point of the line segment
	 * @param y2	the y-position of the second point of the line segment
	 * @param px	the x-position of the point
	 * @param py	the y-position of the point
	 * @param EPSILON the precision. Smaller value = higher precision. default = 0.1
	 * */
	public static boolean pointOnLine(float x1, float y1, float x2, float y2, float px, float py, float EPSILON) {
		//         ..a..  ..b..
		//  start |------P-----| end	=> a+b = len
		//			...len...
		float a = dist(x1, y1, px, py);
		float b = dist(x2, y2, px, py);
		float l = dist(x1, y1, x2, y2);
		
		float ab = a + b;
		float diff = Math.abs(l-ab);
		
		return diff <= (EPSILON*EPSILON);
	}
	
	
	
	
	/**
	 * checks whether the given point is inside the polygon
	 * @param polygon 	the points of the polygon
	 * @param x 		the x-position of the point
	 * @param y 		the y-position of the point
	 * @return true, if the point is inside the polygon
	 * */
	public static boolean pointInPolygon(Vector2f[] polygon, float x, float y) {
		int intersects = 0;
		for(int i=0; i<polygon.length; i++) {
			float x1 = polygon[i].x;
			float y1 = polygon[i].y;
			float x2 = polygon[(i+1) % polygon.length].x;
			float y2 = polygon[(i+1) % polygon.length].y;
			if (((y1 <= y && y < y2) || (y2 <= y && y < y1)) && x < ((x2 - x1) / (y2 - y1) * (y - y1) + x1)) intersects++;
		}
		return (intersects & 1) == 1;
	}
	
	
	/**
	 * checks whether the given point is inside the polygon
	 * @param polygon 	the points of the polygon as an array {x0,y0,x1,y1,...,xn,yn} 
	 * @param x 		the x-position of the point
	 * @param y 		the y-position of the point
	 * @return true, if the point is inside the polygon
	 * */
	public static boolean pointInPolygon(float[] polygon, float x, float y) {
		if(polygon.length % 2 != 0) {
			throw new IllegalArgumentException("Invalid polygon data size: " + polygon.length);
		}
		int intersects = 0;
		for(int i=0; i<polygon.length/2; i+=2) {
			int ix = i;
			int iy = i+1;
			float x1 = polygon[ix];
			float y1 = polygon[iy];
			float x2 = polygon[(ix+1) % (polygon.length/2)];
			float y2 = polygon[(iy+1) % (polygon.length/2)];
			if (((y1 <= y && y < y2) || (y2 <= y && y < y1)) && x < ((x2 - x1) / (y2 - y1) * (y - y1) + x1)) intersects++;
	
		}
		return (intersects & 1) == 1;
	}
	
	
	
	
	/**
	 * checks whether the given point is inside the rectangle
	 * @param minX	x-position of the bottom left corner
	 * @param minY	y-position of the bottom left corner
	 * @param maxX	x-position of the top right corner
	 * @param maxY	y-position of the top right corner
	 * @param x 	the x-position of the point
	 * @param y 	the y-position of the point
	 * @return true, if the point is inside the rectangle
	 * */
	public static boolean pointInRectangle(float minX, float minY, float maxX, float maxY, float x, float y) {
		return minX < x && maxX > x && minY < y && maxY > y;
	}
	
	
	
	
	/**
	 * checks whether the given point is inside the circle
	 * @param cx		the x-position (center) of the circle
	 * @param cy		the y-position (center) of the circle
	 * @param cRadius	the radius of the circle
	 * @param x 		the x-position of the point
	 * @param y 		the y-position of the point
	 * @return true, if the point is inside the circle
	 * */
	public static boolean pointInCircle(float cx, float cy, float cRadius, float x, float y) {
		float dx = Math.abs(cx - x);
		float dy = Math.abs(cy - y);
		float d = (dx*dx) + (dy*dy);
		return d < (cRadius*cRadius);
	}
	
	
	
	
	/**
	 * checks whether the given point is inside the triangle
	 * @param x1	the x-position of the first point of the triangle
	 * @param y1	the y-position of the first point of the triangle
	 * @param x2	the x-position of the second point of the triangle
	 * @param y2	the y-position of the second point of the triangle
	 * @param x3	the x-position of the third point of the triangle
	 * @param y3	the y-position of the third point of the triangle
	 * @param px 	the x-position of the point
	 * @param py 	the y-position of the point
	 * @return true, if the point is inside the triangle
	 * */
	public static boolean pointInTriangle(float x1, float y1, float x2, float y2, float x3, float y3, float px, float py) {
		
		Vector2f a = new Vector2f(x1, y1);
		Vector2f b = new Vector2f(x2, y2);
		Vector2f c = new Vector2f(x3, y3);
		Vector2f p = new Vector2f(px, py);
		
		Vector3f bary = MathUtils.barycentric(a, b, c, p);
		
		if(bary.x < 0 || bary.y < 0 || bary.z < 0) {
			return false;
		} else {
			return true;
		}
		
	}
	
	
	
	
	/**
	 * calculates the dot product of the two vectors  (x1,y1) and (x2,y2)
	 * */
	private static float dot(float x1, float y1, float x2, float y2) {
		return (x1 * x2) + (y1 * y2);	
	}
	
	
	
	
	/**
	 * calculates the cross product of the two vectors  (x1,y1) and (x2,y2)
	 * */
	private static float dist(float x1, float y1, float x2, float y2) {
		return (float) Math.sqrt(Math.abs(((x2-x1) * (x2-x1)) + ((y2-y1) * (y2-y1))));
	}
	
	
}

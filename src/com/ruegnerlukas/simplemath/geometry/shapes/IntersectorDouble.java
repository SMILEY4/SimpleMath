package com.ruegnerlukas.simplemath.geometry.shapes;

import java.util.List;

import com.ruegnerlukas.simplemath.vectors.vec2.Vector2d;

public class IntersectorDouble {

	
	
	
	private IntersectorDouble() {
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
	public static boolean intersectsRectangleRectangle(double r1x, double r1y, double r1width, double r1height, double r2x, double r2y, double r2width, double r2height) {
		
		if(r1width == 0 || r1height == 0) { return false; }
		if(r2width == 0 || r2height == 0) { return false; }
		
		double r1MinX = r1x;
		double r1MinY = r1y;
		double r1MaxX = r1x+r1width;
		double r1MaxY = r1y+r1height;
		double r2MinX = r2x;
		double r2MinY = r2y;
		double r2MaxX = r2x+r2width;
		double r2MaxY = r2y+r2height;
		
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
	public static boolean intersectsRectangleCircle(double rx, double ry, double rWidth, double rHeight, double cx, double cy, double cRadius) {
		double radius = cRadius;
		
		double rcx = rx + (rWidth/2f);
		double rcy = ry + (rHeight/2f);
		double hw = rWidth/ 2f;
		double hh = rHeight / 2f;
		
		double dx = Math.abs(cx - rcx);
		double dy = Math.abs(cy - rcy);
		
		if(dx > (radius+hw) || dy > (radius+hh)) { return false; }
		
		double cDistX = Math.abs(cx - rx - hw);
		double cDistY = Math.abs(cy - ry - hh);

		if(cDistX <= hw) { return true; }
		if(cDistY <= hh) { return true; }
		
		double cornerDistSq = ( (cDistX-hw)*(cDistX-hw) ) + ( (cDistY-hh)*(cDistY-hh) );
		
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
	public static boolean intersectsRectangleLine(double rx, double ry, double rWidth, double rHeight, double lx1, double ly1, double lx2, double ly2, List<Vector2d> intersections) {
		
		double minX = rx;
		double minY = ry;
		double maxX = rx + rWidth;
		double maxY = ry + rHeight;
		
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
			Vector2d v1 = new Vector2d();
			if(intersectsLineLine(lx1, ly1, lx2, ly2, minX, minY, maxX, minY, v1)) { numIntersections++; if(intersections!=null) intersections.add(v1); };
			Vector2d v2 = new Vector2d();
			if(intersectsLineLine(lx1, ly1, lx2, ly2, maxX, minY, maxX, maxY, v2)) { numIntersections++; if(intersections!=null) intersections.add(v2); };
			Vector2d v3 = new Vector2d();
			if(intersectsLineLine(lx1, ly1, lx2, ly2, minX, maxY, maxX, maxY, v3)) { numIntersections++; if(intersections!=null) intersections.add(v3); };
			Vector2d v4 = new Vector2d();
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
	public static boolean intersectsRectanglePolygon(double rx, double ry, double rWidth, double rHeight, Vector2d[] polygon, List<Vector2d> intersections) {

		double minX = rx;
		double minY = ry;
		double maxX = rx + rWidth;
		double maxY = ry + rHeight;
		
		int numPointsInRect = 0;
		for(Vector2d v : polygon) {
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
				double x1 = polygon[i].x;
				double y1 = polygon[i].y;
				double x2 = polygon[(i+1) % polygon.length].x;
				double y2 = polygon[(i+1) % polygon.length].y;
				Vector2d v1 = new Vector2d();
				if(intersectsLineLine(x1, y1, x2, y2, minX, minY, maxX, minY, v1)) { numIntersections++; intersections.add(v1); }
				Vector2d v2 = new Vector2d();
				if(intersectsLineLine(x1, y1, x2, y2, maxX, minY, maxX, maxY, v2)) { numIntersections++; intersections.add(v2); }
				Vector2d v3 = new Vector2d();
				if(intersectsLineLine(x1, y1, x2, y2, maxX, maxY, minX, maxY, v3)) { numIntersections++; intersections.add(v3); }
				Vector2d v4 = new Vector2d();
				if(intersectsLineLine(x1, y1, x2, y2, minX, maxY, maxX, minY, v4)) { numIntersections++; intersections.add(v4); }
			}
			if(numIntersections > 0) { return true;}
			
		} else {
			for(int i=0; i<polygon.length; i++) {
				double x1 = polygon[i].x;
				double y1 = polygon[i].y;
				double x2 = polygon[(i+1) % polygon.length].x;
				double y2 = polygon[(i+1) % polygon.length].y;
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
	public static boolean intersectsCircleCircle(double c1x, double c1y, double c1Radius, double c2x, double c2y, double c2Radius) {
		if(c1Radius == 0 || c2Radius == 0) { return false; }
		double distCX = c2x - c1x;
		double distCY = c2y - c1y;
		double dist2 = (distCX*distCX)  + (distCY*distCY);
		double sumR = c1Radius + c2Radius;
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
	public static boolean intersectsCircleLine(double cx, double cy, double cRadius, double lx1, double ly1, double lx2, double ly2) {
		
		// line start-end
		double dx = lx2 - lx1;
		double dy = ly2 - ly1;
		
		// center-lineStart
		double fx = lx1 - cx;
		double fy = ly1 - cy;

		double a = dot(dx, dy, dx, dy);
		double b = (2f * dot(fx, fy, dx, dy));
		double c = dot(fx, fy, fx, fy) - cRadius*cRadius;
		
		double discriminant = b*b-4*a*c;
		if(discriminant < 0) { return false; }
		
		discriminant = Math.sqrt(discriminant);
		
		double t1 = (-b - discriminant) / (2*a);
		double t2 = (-b + discriminant) / (2*a);
		
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
	public static boolean intersectsCirclePolygon(double cx, double cy, double cRadius, Vector2d[] polygon) {
		int numPointsInCircle = 0;
		for(Vector2d v : polygon) {
			if(pointInCircle(cx, cy, cRadius, v.x, v.y)) { numPointsInCircle++; }
		}
		if(numPointsInCircle > 0) { return true; }
		
		for(int i=0; i<polygon.length; i++) {
			double x1 = polygon[i].x;
			double y1 = polygon[i].y;
			double x2 = polygon[(i+1) % polygon.length].x;
			double y2 = polygon[(i+1) % polygon.length].y;
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
	public static boolean intersectsLineLine(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4, Vector2d intersection) {
		
		double d = (y4 - y3) * (x2 - x1) - (x4 - x3) * (y2 - y1);
		if (d == 0) return false;
		
		double yd = y1 - y3;
		double xd = x1 - x3;
		double ua = ((x4 - x3) * yd - (y4 - y3) * xd) / d;
		if (ua < 0 || ua > 1) return false;
		
		double ub = ((x2 - x1) * yd - (y2 - y1) * xd) / d;
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
	public static boolean intersectsLinePolygon(double x1, double y1, double x2, double y2, Vector2d[] polygon) {

		int n = polygon.length;
		
		double x3 = polygon[n-1].x;
		double y3 = polygon[n-1].y;

		for(int i=0; i<n; i+=2) {
			double x4 = polygon[i].x;
			double y4 = polygon[i].y;
			
			double d = (y4 - y3) * (x2 - x1) - (x4 - x3) * (y2 - y1);
			if (d != 0) {
				double yd = y1 - y3;
				double xd = x1 - x3;
				double ua = ((x4 - x3) * yd - (y4 - y3) * xd) / d;
				if (ua >= 0 && ua <= 1) {
					double ub = ((x2 - x1) * yd - (y2 - y1) * xd) / d;
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
	public static boolean intersectsPolygonPolygon(Vector2d[] polygon1, Vector2d[] polygon2) {
		int numPointsInPoly1 = 0;
		for(Vector2d v1 : polygon1) {
			if(pointInPolygon(polygon1, v1.x, v1.y)) { numPointsInPoly1++; }
		}
		if(numPointsInPoly1 > 0) { return true; }
		
		int numPointsInPoly2 = 0;
		for(Vector2d v2 : polygon2) {
			if(pointInPolygon(polygon2, v2.x, v2.y)) { numPointsInPoly2++; }
		}
		if(numPointsInPoly2 > 0) { return true; }
		
		for(int i=0; i<polygon1.length; i++) {
			double x1 = polygon1[i].x;
			double y1 = polygon1[i].y;
			double x2 = polygon1[(i+1) % polygon1.length].x;
			double y2 = polygon1[(i+1) % polygon1.length].y;
			for(int j=0; j<polygon2.length; j++) {
				double x3 = polygon1[j].x;
				double y3 = polygon1[j].y;
				double x4 = polygon1[(j+1) % polygon2.length].x;
				double y4 = polygon1[(j+1) % polygon2.length].y;
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
	public static Vector2d getClosestPointOnLine(double x1, double y1, double x2, double y2, double px, double py) {
	
		double xDelta = x2 - x1;
		double yDelta = y2 - y1;
		
		// line segment with length = 0
		if( (xDelta==0) && (yDelta==0) ) {
			return new Vector2d(px, py);
		}
		
		double u = ((px - x1) * xDelta + (py - y1) * yDelta) / (xDelta * xDelta + yDelta * yDelta);
		
		Vector2d closestPoint;
		if(u < 0) {
			closestPoint = new Vector2d(x1, y1);
			
		} else if( u > 1) {
			closestPoint = new Vector2d(x2, y2);
			
		} else {
			closestPoint = new Vector2d((x1+u*xDelta), (y1+u*yDelta));
			
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
	public static boolean pointOnLine(double x1, double y1, double x2, double y2, double px, double py, double EPSILON) {
		//         ..a..  ..b..
		//  start |------P-----| end	=> a+b = len
		//			...len...
		double a = dist(x1, y1, px, py);
		double b = dist(x2, y2, px, py);
		double l = dist(x1, y1, x2, y2);
		
		double ab = a + b;
		double diff = Math.abs(l-ab);
		
		return diff <= (EPSILON*EPSILON);
	}
	
	
	
	
	/**
	 * checks whether the given point is inside the polygon
	 * @param polygon 	the points of the polygon
	 * @param x 		the x-position of the point
	 * @param y 		the y-position of the point
	 * @return true, if the point is inside the polygon
	 * */
	public static boolean pointInPolygon(Vector2d[] polygon, double x, double y) {
		int intersects = 0;
		for(int i=0; i<polygon.length; i++) {
			double x1 = polygon[i].x;
			double y1 = polygon[i].y;
			double x2 = polygon[(i+1) % polygon.length].x;
			double y2 = polygon[(i+1) % polygon.length].y;
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
	public static boolean pointInRectangle(double minX, double minY, double maxX, double maxY, double x, double y) {
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
	public static boolean pointInCircle(double cx, double cy, double cRadius, double x, double y) {
		double dx = Math.abs(cx - x);
		double dy = Math.abs(cy - y);
		double d = (dx*dx) + (dy*dy);
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
	public static boolean pointInTriangle(double x1, double y1, double x2, double y2, double x3, double y3, double px, double py) {
		double px1 = px - x1;
		double py1 = py - y1;
		boolean side12 = (x2 - x1) * py1 - (y2 - y1) * px1 > 0;
		if ((x3 - x1) * py1 - (y2 - y1) * px1 > 0 == side12) return false;
		if ((x3 - x2) * (py - y2) - (y3 - y2) * (px - x2) > 0 != side12) return false;
		return true;
	}
	
	
	
	
	/**
	 * calculates the dot product of the two vectors  (x1,y1) and (x2,y2)
	 * */
	private static double dot(double x1, double y1, double x2, double y2) {
		return (x1 * x2) + (y1 * y2);	
	}
	
	
	
	
	/**
	 * calculates the cross product of the two vectors  (x1,y1) and (x2,y2)
	 * */
	private static double dist(double x1, double y1, double x2, double y2) {
		return  Math.sqrt(Math.abs(((x2-x1) * (x2-x1)) + ((y2-y1) * (y2-y1))));
	}
	
	
}

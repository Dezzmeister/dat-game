package guiapi;

import guiapi.Global;
import processing.core.PApplet;
import processing.core.PGraphics;

public class Clickable extends Element{
	PApplet parent;
	
	public Clickable(PApplet parent) {
		super(parent);
		this.parent = parent;
	}
	
	public boolean isClicked(int x1, int y1, int x2, int y2) {
		int xMin = Math.min(x1, x2);
		int xMax = Math.max(x1, x2);
		int yMin = Math.min(y1, y2);
		int yMax = Math.max(y1, y2);
		
		return (parent.mousePressed && parent.mouseX > xMin && parent.mouseX < xMax && parent.mouseY > yMin && parent.mouseY < yMax);
	}
	
	public boolean isClicked(int x, int y, PGraphics p) {
		
		return (parent.mousePressed && isHovering(x,y,p));
	}
	
	public boolean isHovering(int x, int y, PGraphics p) {
		int xMin = x;
		int xMax = x + p.width;
		int yMin = y;
		int yMax = y + p.height;
		
		if (parent.mouseX > xMin && parent.mouseX < xMax && parent.mouseY > yMin && parent.mouseY < yMax) {
			if (focusOnClick) getFocus();
			return true;
		}
		return false;
	}
	
	public boolean isClicked() {
		return parent.mousePressed;
	}
	
	public boolean wasClicked() {
		if (Global.clicked) {
			Global.clicked = false;
			return true;
		}
		return false;
	}
	
	public boolean wasClicked(int x, int y, PGraphics p) {
		int xMin = x;
		int xMax = x + p.width;
		int yMin = y;
		int yMax = y + p.height;
		
		if (Global.clicked && parent.mousePressed && parent.mouseX > xMin && parent.mouseX < xMax && parent.mouseY > yMin && parent.mouseY < yMax) {
			Global.clicked = false;
			if (focusOnClick) getFocus();
			return true;
		}
		return false;
	}
	
	public boolean wasClicked(int x1, int y1, int x2, int y2) {
		int xMin = Math.min(x1, x2);
		int xMax = Math.max(x1, x2);
		int yMin = Math.min(y1, y2);
		int yMax = Math.max(y1, y2);
		
		if (Global.clicked && parent.mousePressed && parent.mouseX > xMin && parent.mouseX < xMax && parent.mouseY > yMin && parent.mouseY < yMax) {
			Global.clicked = false;
			return true;
		}
		return false;
	}
}

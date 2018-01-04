package guiapi;

import guiapi.Global;
import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PGraphics;

public class Placeable {
	PApplet parent;
	PGraphics img;
	
	protected int x;
	protected int y;
	protected int width;
	protected int height;
	
	protected boolean focusOnClick = false;
	
	public Placeable(PApplet parent) {
		this.parent = parent;
	}
	
	public Placeable() {
		
	}
	
	public Placeable placeAt(int x, int y) {
		this.x = x;
		this.y = y;
		return this;
	}
	
	public Placeable placeAtCenter(int x, int y) {
		this.x = x - (width/2);
		this.y = y - (height/2);
		return this;
	}
	
	public void draw() {	//Override this method
		
	}
	
	public void defaultDraw() {
		parent.imageMode(PConstants.CORNER);
		parent.image(img, x, y);
	}
	
	public int getHeight() {
		return height;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	
	public int getWidth() {
		return width;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}
	
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	//Simple focus system: Global.focused is an Object, and it will point to whatever has focus
	public void getFocus() {
		Global.focused = this;
	}
	
	public boolean hasFocus() {
		return Global.focused==this;
	}
	
	public Placeable setFocus(boolean focus) {
		focusOnClick = focus;
		return this;
	}
}

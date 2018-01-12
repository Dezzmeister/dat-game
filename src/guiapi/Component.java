package guiapi;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PGraphics;

//Not to be confused with the Swing Component.
@SuppressWarnings("unused")
public class Component extends Clickable {
	public static final int GRID = 0;
	public static final int CUSTOM = 1;
	public static final int GRAPHICS = 2;
	private int type = CUSTOM;
	
	private PGraphics grid;
	
	private int bgCol;
	private int lineCol;
	
	DrawnImage drawn = null;
	public int gHeight;
	public int gWidth;
	
	private int xLoc;
	private int yLoc;
	
	private int scrollSpeed = 1;
	
	private ClickInterface clickAction;
	private DrawnImage custom;
	
	public Component(PApplet parent, int type) {
		super(parent);
		this.type = type;
		bgCol = parent.color(0);
		lineCol = parent.color(255,255,255);
	}
	
	public Component setSize(int width, int height) {
		this.width = width;
		this.height = height;
		img = parent.createGraphics(width, height);
		return this;
	}
	
	public Component setGridSize(int gWidth, int gHeight) {
		this.gWidth = gWidth;
		this.gHeight = gHeight;
		grid = parent.createGraphics(gWidth, gHeight);
		return this;
	}
	
	public Component setClickAction(ClickInterface clickAction) {
		this.clickAction = clickAction;
		return this;
	}
	
	public void setCustomImage(DrawnImage custom) {
		this.custom = custom;
	}
	
	public void setImage(PGraphics img) {
		this.img = img;
	}
	
	public void setImage(DrawnImage drawn) {
		this.drawn = drawn;
	}
	
	@Override
	public void draw() {
		if (wasClicked(x,y,img)) {
			getFocus();
			if (clickAction != null) {
				clickAction.onClick();
			}
		}
		switch (type) {
		case CUSTOM:
			drawn.drawImage();
			break;
		case GRID:
			drawGrid();
			handleKeys();
			defaultDraw();
			break;
		default:
			defaultDraw();
		}
		if (custom != null) {
			custom.drawImage();
		}
	}
	
	public Component setScrollSpeed(int speed) {
		scrollSpeed = speed;
		return this;
	}
	
	public int getScrollSpeed() {
		return scrollSpeed;
	}
	
	private void handleKeys() {
		if (hasFocus() || !focusOnClick) {
			if (xLoc > width-gWidth && (Global.keys[PConstants.LEFT] || Global.keys['A'])) {
				xLoc -= scrollSpeed;
			}
			if (xLoc < 0 && (Global.keys[PConstants.RIGHT] || Global.keys['D'])) {
				xLoc += scrollSpeed;
			}
			
			if (yLoc > height-gHeight && (Global.keys[PConstants.UP] || Global.keys['W'])) {
				yLoc -= scrollSpeed;
			}
			if (yLoc < 0 && (Global.keys[PConstants.DOWN] || Global.keys['S'])) {
				yLoc += scrollSpeed;
			}
		}
	}
	
	public Component defineGrid(int rows, int cols) {
		grid.beginDraw();
		grid.background(bgCol);
		grid.stroke(lineCol);
		for (int row = 0; row <= rows; row++) {
			grid.line(0, grid.height*(row/(float)rows), grid.width, grid.height*(row/(float)rows));
		}
		for (int col = 0; col <= cols; col++) {
			grid.line(grid.width*(col/(float)cols), 0, grid.width*(col/(float)cols), grid.height);
		}
		grid.endDraw();
		drawGrid();
		
		return this;
	}
	
	private void drawGrid() {
		img.beginDraw();
		img.imageMode(PConstants.CORNER);
		img.image(grid,xLoc,yLoc);
		img.endDraw();
	}
	
	public int getType() {
		return type;
	}
}

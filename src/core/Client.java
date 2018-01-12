package core;

import guiapi.Component;
import guiapi.Cursor;
import guiapi.Element;
import guiapi.GUIAPP;
import guiapi.Global;
import guiapi.IconButton;
import guiapi.Placeable;
import guiapi.Toolbar;
import processing.core.PApplet;

@SuppressWarnings("unused")
public class Client extends PApplet implements GUIAPP {
	
	
	Cursor cursor;
	Placeable p;
	
	public static void main(String[] args) {
		PApplet.main("core.Client");
	}
	
	public void settings() {
		size(700,700);
	}
	
	public void setup() {
		p = new Placeable();
		Global.focused = this;
		surface.setTitle("Linegame Level Editor");
		noCursor();
		cursor = new Cursor(this).loadImage("src/assets/png/cursor.png");
		Global.components.add((Component) new Component(this, Component.GRID).setSize(500, 500).setGridSize(1000, 1000).defineGrid(20, 20).setScrollSpeed(3).setFocus(true));
	}
	
	public void draw() {
		beginDraw();
		
		endDraw();
	}
	
	public void mousePressed() {
		Global.clicked = true;
	}
	
	public void mouseReleased() {
		Global.clicked = false;
	}
	
	public void keyPressed() {
		if (key > 0 && key < 256) {
			Global.keys[keyCode] = true;
		}
	}
	
	public void keyReleased() {
		if (key > 0 && key < 256) {
			Global.keys[keyCode] = false;
		}
	}
	
	public void drawToolbars() {

	}
	
	public void drawComponents() {

	}
	
	public void drawIconButtons() {

	}

	public void drawTextButtons() {
		
	}

	public void beginDraw() {
		background(160);
		Global.drawAll();
	}
	
	public void endDraw() {
		cursor.draw();
	}
}

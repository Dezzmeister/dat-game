package guiapi;

import java.lang.reflect.Method;
import java.util.ArrayList;

import guiapi.Element;
import guiapi.IconButton;
import guiapi.Toolbar;
import processing.core.PApplet;
import processing.core.PFont;

@SuppressWarnings("unused")
public class Global {
	public static boolean clicked = false;
	public static boolean[] keys = new boolean[256];
	
	public static ArrayList<Toolbar> toolbars = new ArrayList<>();
	public static ArrayList<IconButton> iconbuttons = new ArrayList<>();
	public static ArrayList<Component> components = new ArrayList<>();
	
	public static Object focused;
	
	public static void drawAllToolbars() {
		for (Toolbar t : toolbars) {
			t.draw();
		}
	}
	
	public static void drawAllIconButtons() {
		for (IconButton i : iconbuttons) {
			i.draw();
		}
	}
	
	public static void drawAllComponents() {
		for (Component c : components) {
			c.draw();
		}
	}
	
	public static void drawAll() {
		drawAllToolbars();
		drawAllIconButtons();
		drawAllComponents();
	}
}

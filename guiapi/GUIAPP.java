package guiapi;

public interface GUIAPP {
	
	public void settings();
	
	public void setup();
	
	public void draw();
	
	public void beginDraw();
	
	public void mousePressed();
	
	public void mouseReleased();
	
	public void keyPressed();
	
	public void keyReleased();
	
	public void drawToolbars();
	
	public void drawComponents();
	
	public void drawIconButtons();
	
	public void drawTextButtons();
	
	public void endDraw();
}

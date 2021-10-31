package Listeners;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWWindowPosCallback;

public class MouseListener 
{
	private static MouseListener instance;
	
	private double scrollX, scrollY;
	private double xPos, yPos, lastY, lastX;
	private boolean mouseButtonPressed[] = new boolean[3];
	
	private MouseListener()
	{
		this.scrollX = 0.0;
		this.scrollY = 0.0;
		this.xPos = 0.0;
		this.yPos = 0.0;
		this.lastX = 0.0;
		this.lastY = 0.0;
	}
	
	
	public static MouseListener get()
	{
		if (MouseListener.instance == null)
		{
			instance = new MouseListener();
		}
		
		return instance;
	}
	
	
	public static void mousePositionCallback(double xPosition, double yPosition)
	{
		get().lastX = get().xPos;
		get().lastY = get().yPos;
		get().xPos = get().xPos;
		get().yPos = get().yPos;
	}
	
	
	public static void mouseButtonCallback(long window, int button, int action, int mods)
	{
		if(action == GLFW.GLFW_PRESS)
		{
			if(button < get().mouseButtonPressed.length)
			{
				get().mouseButtonPressed[button] = true;
			}
		}
		else if (action == GLFW.GLFW_RELEASE)
		{
			if(button < get().mouseButtonPressed.length)
			{
				get().mouseButtonPressed[button] = false;
			}
		}
	}
	
	
	public static void endFrame()
	{
		get().scrollX = 0;
		get().scrollY = 0;
		get().lastX = get().xPos;
		get().lastY = get().yPos;
	}

	
	public static float getX()
	{
		return (float)get().xPos;
	}
	
	public static float getY()
	{
		return (float)get().yPos;
	}
	
	public static float getDx()
	{
		return (float)(get().lastX - get().xPos);
	}
	
	public static float getDy()
	{
		return (float)(get().lastY - get().yPos);
	}
}

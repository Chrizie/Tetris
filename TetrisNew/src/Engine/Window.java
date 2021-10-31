package Engine;

import static org.lwjgl.opengl.GL40.*;
import static org.lwjgl.glfw.GLFW.*;
import org.lwjgl.opengl.GL;



public class Window 
{
	private static Window instance = null;
	private long windowID;
	
	private Window() {};
	
	
	public static Window get()
	{
		if (instance == null)
		{
			instance = new Window();
		}
		return instance;
	}
	
	
	public void run()
	{
		init();
		loop();
	}

	
	private void init()
	{
		glfwInit();
		
		glfwWindowHint(GLFW_RESIZABLE, GLFW_FALSE);
		glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);
		glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, 3);
		glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, 3);
		
		windowID = glfwCreateWindow(800, 600, "Tetris", 0, 0);
		glfwMakeContextCurrent(windowID);
		GL.createCapabilities();
		
		glfwShowWindow(windowID);
	}
	
	
	private void loop()
	{
		while(!glfwWindowShouldClose(windowID))
		{
			glClearColor(1,1,1,1);
			glClear(GL_COLOR_BUFFER_BIT);
			
			glfwSwapBuffers(windowID);
			glfwPollEvents();
		}
	}
}

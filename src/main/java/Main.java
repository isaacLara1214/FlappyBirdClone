import org.lwjgl.glfw.GLFWVidMode;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;

public class Main implements Runnable {
    private int width = 1280;
    private int height = 720;
    private boolean running = true;
    private long window;

    private Thread thread;


    public void start() {
        running = true;
        thread = new Thread(this, "Game");
        thread.start();
    }

    private void init() {
        if (!glfwInit()) {
            throw new IllegalStateException("Unable to initialize GLFW");
        }

        glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE);
        window = glfwCreateWindow(width, height, "FLappy clone", 0,0);
        if (window == 0) {
            // TODO: throw exception or handle
            throw new IllegalStateException("Unable to create the GLFW window");
        }

        GLFWVidMode vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());
        glfwSetWindowPos(window, (vidmode.width() - width) / 2, (vidmode.height() - height) / 2);

        glfwSetKeyCallback(window, new Input());

        glfwMakeContextCurrent(window);
        glfwShowWindow(window);



        //glEnable(GL_DEPTH_TEST);
        //glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
        //System.out.println("OpenGL version: " + glGetString(GL_VERSION));

    }

    public void run() {
        init();
        while(running) {
            update();
            render();

            if (glfwWindowShouldClose(window)) {
                running = false;
            }
        }
    }

    private void update() {
        glfwPollEvents();
    }

    private void render() {
        //glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
        glfwSwapBuffers(window);

    }
    public static void main(String[] args) {
        new Main().start();
    }
}

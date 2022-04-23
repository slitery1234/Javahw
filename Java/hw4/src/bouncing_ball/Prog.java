package bouncing_ball;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;


public class Prog {

	public static void main(String[] args) {
	    Prog program = new Prog();
	    program.run();
	}
	
    private JFrame frame;
    private DrawPanel drawPanel;
    private java.util.List<Ball> balls;

    private int windowWidth = 800;
    private int windowHeight = 600;
    private String windowLabel = "Bounce Program";

    void run() {

        balls = new ArrayList<>();


        /* Initialize program */
        frame = new JFrame();
        drawPanel = new DrawPanel();

        frame.setSize(windowWidth, windowHeight);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().add(drawPanel);
        frame.setTitle(windowLabel);
        frame.setVisible(true);
        frame.setFocusable(true);
        
        frame.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Ball ball = new Ball(
                        e.getX()-25,e.getY()-25,50,
                        /* Random colors*/
                        new Color(
                                (int) Math.floor((Math.random() * 256)),
                                (int) Math.floor((Math.random() * 256)),
                                (int) Math.floor((Math.random() * 256))
                        ),
                        /* Random velocities from -5 to 5 */
                        (int) Math.floor((Math.random() * 10) - 5),
                        (int) Math.floor((Math.random() * 10) - 5)
                );
                balls.add(ball);
    	    }
        });

        while (true) {
            for (Ball b: balls) {
                b.update();
            }

            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            frame.repaint();
        }
    }

    class DrawPanel extends JPanel {
        @Override
        public void paintComponent(Graphics graphics) {
            super.paintComponent(graphics);

            for (Ball b: balls) {
                b.draw(graphics);
            }

        }
    }

    class Ball {
        private int X, Y, size;
        private Color color;

        private int vx = 2;
        private int vy = 2;

        public Ball(int initX, int initY, int size, Color color, int vx, int vy) {
            this.X = initX;
            this.Y = initY;
            this.size = size;
            this.color = color;
            this.vx = vx;
            this.vy = vy;
        }
        // update when function is called
        void update() {

            if (X > frame.getWidth()-40 || X < 0) {
                vx *= -1;
            }

            if (Y > frame.getHeight()-80 || Y < 0) {
                vy *= -1;
            }

            if (X > frame.getWidth()-40) 
                X = frame.getWidth()-40;
            else if (X < 0) 
                X = 0;

            if (Y > frame.getHeight()-80) 
                Y = frame.getHeight()-80;
            else if (Y < 0) 
                Y = 0;
            
            this.X += vx;
            this.Y += vy;

        }

        void draw(Graphics g) {
            g.setColor(color);
            g.fillOval(X, Y, size, size);
        }

    }
	    
}



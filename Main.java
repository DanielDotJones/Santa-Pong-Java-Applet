import javax.imageio.ImageIO;
import javax.swing.*;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class Main extends Applet implements KeyListener, ActionListener {

	private Timer time;
    private ball Ball;
    private leftPaddle lPad;
    private  rightPaddle rPad;

    private char recentKey;
    private char recentLeft;
    private char recentRight;

	public void init() {
		time = new Timer(15, e -> repaint());

		Ball = new ball();
		lPad = new leftPaddle();
		rPad = new rightPaddle();

		addKeyListener( this );
		start();

	}

	@Override
	public void start() {
		time.start();
		repaint();
	}

	@Override
	public void stop() {
		time.stop();
	}

    private boolean MoveBall = false;
	int Random100;
	int Random50;

	public boolean EnterChristmas = false;

	int LPlayerPoints = 0;
	int RPlayerPoints = -1;

	public void paint(Graphics g) {
		Random50 = Expo.random(0, 250);
		Random100 = Expo.random(0, 700);

		if (EnterChristmas) {
			Expo.setBackground(g, Expo.darkRed);
		}
		if (!EnterChristmas) {
			Expo.setBackground(g, Expo.black);
		}
		if (Random100 == 1) {
			EnterChristmas = true;
		}
		if (Random50 == 1) {
			EnterChristmas = false;
		}

        if(recentKey=='r' && MoveBall)
			MoveBall = false;
		if (recentKey=='r' && !MoveBall)
			MoveBall = true;

		/*
		if(recentKey=='t')
			Ball = new ball();
		*/

		if(Ball.posX <= 10) {
			MoveBall = false;
			RPlayerPoints++;
			Ball = new ball();
		}

		if(Ball.posX >= 990) {
			MoveBall = false;
			LPlayerPoints++;
			Ball = new ball();
		}

        if(MoveBall)
        	if(lPad.hitPaddleL(Ball)) {
        		Ball.moveWithSpeed(Ball, lPad.getDirection());
	        } else
                Ball.move(Ball);


		if(EnterChristmas)
			PaintPicture(g, "AngrySanta.png", 287, 200, 20);
		else
			PaintPicture(g, "Santa.png", 395, 400, 10);


		Ball.render(g);
        Ball.BallPhysicsCheck(Ball, lPad, rPad, EnterChristmas);

        lPad.render(g, recentLeft);
        rPad.render(g, recentRight);


		g.setFont(new Font("Arial", Font.PLAIN, 50));

		g.setColor(Color.white);

		g.drawString(String.valueOf(LPlayerPoints), 400-25, 100);
		g.drawString(String.valueOf(RPlayerPoints), 600-25, 100);

		Toolkit.getDefaultToolkit().sync();
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		recentKey = e.getKeyChar();
		if(recentKey == 'q' || recentKey == 'z')
			recentLeft = recentKey;
		if(recentKey == 'p' || recentKey == ',')
			recentRight = recentKey;
		showStatus(String.valueOf(recentKey));
		e.consume();
		repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		recentKey = ' ';
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

	void PaintPicture(Graphics g, String url, int x, int y, int scaleFactor) {
		int width = 18*scaleFactor;
		int height = 23*scaleFactor;
		BufferedImage photo = null;
		try
		{
			URL u = new URL(getCodeBase(),url);
			photo = ImageIO.read(u);
		}
		catch (IOException e)
		{
			g.drawString("Problem reading the file", 100, 100);
		}
		g.drawImage(photo,x, y, width, height,null);
	}
}

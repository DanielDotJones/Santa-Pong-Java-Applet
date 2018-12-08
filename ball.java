import java.awt.*;

class ball {

    ball() {

    }

    private int DifferenceX = 0;
    private int DifferenceY = 0;

    int posX;
    int posY;

    void render(Graphics g) {
        Expo.setColor(g, Expo.white);

        posX = 1000/2 + DifferenceX;
        posY = 650/2 + DifferenceY;
        Expo.fillCircle(g,posX,posY,10);
    }

    private void setVelocity(int speedX, int speedY) {
        DifferenceX += speedX/2;
        DifferenceY += speedY/2;
    }
    int dx = -15;
    int dy = -10;



    void BallPhysicsCheck(ball Ball, leftPaddle paddleL, rightPaddle paddleR, boolean EnterChristmas) {
	    if (EnterChristmas) {
	    	if(Expo.random(0,1) == 1)
			    dx = Expo.random(0, 18);
			else
				dy = Expo.random(0, 18);
	    }
        if(paddleL.hitPaddleL(Ball)) {
            dx = (dx * -1);
        }
        if(paddleR.hitPaddleR(Ball)) {
            dx = (dx * -1);
        }
        if(Ball.posY <= 0) {
            dy = (dy * -1);
        }
        if(Ball.posY >= 650) {
            dy = (dy * -1);
        }
    }


    void move(ball Ball) {
        Ball.setVelocity(dx,dy);
    }

    void moveWithSpeed(ball Ball, int direction) {
        Ball.setVelocity(dx,dy + (direction * 20));
    }



}

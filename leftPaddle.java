import java.awt.*;

class leftPaddle {
    private int x1L;
    private int x2L;
    private int y1L;
    private int y2L;

    private int distanceYLeft;

    private int Direction;

	void render(Graphics g, char recentLeft) {
        g.setColor(Expo.gray);

		char recentL = recentLeft;
		if (recentLeft == 'q' && y1L == 0)
			recentL = 'z';
		else if (recentLeft == 'z' && y2L == 650)
			recentL = 'q';
		else
			recentL = recentLeft;

        y1L = 125 + distanceYLeft;
        y2L = 350 + distanceYLeft;
        x1L = 75;
        x2L = 100;

        if(recentL == 'q') {
	        distanceYLeft -= 5;
	        Direction = 1;
        }
        if(recentL == 'z') {
	        distanceYLeft += 5;
	        Direction = -1;
        }

        Expo.fillRectangle(g, x1L, y1L, x2L, y2L);
    }

    leftPaddle(){

    }

    boolean hitPaddleL(ball Ball) {
        return Ball.posX < x2L && (Ball.posY > y1L && Ball.posY < y2L);
    }

    int getDirection() {
		return Direction;
    }


}

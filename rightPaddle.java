import java.awt.*;

class rightPaddle{
    private int x1R;
    private int x2R;
    private int y1R;
    private int y2R;

    private int distanceYRight;

	void render(Graphics g, char recentRight) {
        g.setColor(Expo.gray);

		char recentR;
		if (recentRight == 'p' && y1R == 0)
			recentR = ',';
		else if (recentRight == ',' && y2R == 650)
			recentR = 'p';
		else
			recentR = recentRight;

        y1R = 300 + distanceYRight;
        y2R = 525 + distanceYRight;
        x1R = 900;
        x2R = 925;

        if (recentR == 'p')
	        distanceYRight -= 5;
        if (recentR == ',')
	        distanceYRight += 5;

        Expo.fillRectangle(g, x1R, y1R, x2R, y2R);
    }

	rightPaddle() {

    }

	boolean hitPaddleR(ball Ball) {
        return Ball.posX > x1R && (Ball.posY > y1R && Ball.posY < y2R);
    }
}

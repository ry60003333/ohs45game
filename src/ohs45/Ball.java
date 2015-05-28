/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohs45;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * The ball.
 * @author 
 */
public class Ball extends Rectangle
{
    /**
     * The starting X position.
     */
    private static final int START_X = (Main.getWidth() / 2) - (40 / 2);
    
    /**
     * The starting Y position.
     */
    private static final int START_Y = 218;
    
    /**
     * The velocity of the ball in the X direction.
     */
    private int velocityX = -1;
    
    /**
     * The velocity of the ball in the Y direction.
     */
    private int velocityY = -1;
    
    /**
     * Creates a new Ball.
     */
    public Ball()
    {
        super(START_X, START_Y, 5, 5);
    }
    
    /**
     * Handle collision between the ball and the paddle.
     * @param paddle The paddle.
     */
    public void handlePaddleCollision(Paddle paddle)
    {
        if (this.intersects(paddle))
        {
            velocityY = -velocityY;
        }
    }
    
    public int handleBrickCollision(Brick[] bricks)
    {
        int count = 0;
        
        for (int i = 0; i < bricks.length; i++)
        {
            if (bricks[i] != null)
            {
                if (bricks[i].intersects(this))
                {
                    bricks[i] = null;
                    count++;
                    velocityY = -velocityY;
                }
            }
        }
        
        return count;
    }
    
    /**
     * Move the ball.
     */
    public void move()
    {
        x += velocityX;
        y += velocityY;
        
        if (x <= 0 || x + width >= 343)
        {
            velocityX = -velocityX;
        }
        
        if (y <= 0)
        {
            velocityY = -velocityY;
        }
    }
    
    /**
     * Draw the ball.
     * @param g The graphics.
     */
    public void draw(Graphics g)
    {
        g.setColor(Color.BLUE);
        g.fillOval(x, y, width, height);
    }

    public void reset()
    {
        x = START_X;
        y = START_Y;
        velocityX = -1;
        velocityY = -1;
    }
}

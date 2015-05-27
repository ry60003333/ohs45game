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
    
    private static final int START_Y = 218;
    
    private int velocityX = -1;
    
    private int velocityY = -1;
    
    public Ball()
    {
        super(START_X, START_Y, 5, 5);
    }
    
    public void handlePaddleCollision(Paddle paddle)
    {
        if (this.intersects(paddle))
        {
            velocityY = -velocityY;
        }
    }
    
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
}

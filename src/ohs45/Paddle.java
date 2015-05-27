/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohs45;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * The paddle of the game.
 * @author OHS AP Computer Science 4/5
 */
public class Paddle extends Rectangle implements KeyListener
{
    
    private static final int DIRECTION_NONE = 0;
    
    private static final int DIRECTION_LEFT = 1;
    
    private static final int DIRECTION_RIGHT = 2;
    
    /**
     * The width of the paddle.
     */
    private static final int PADDLE_WIDTH = 40;
    
    /**
     * The starting X position.
     */
    private static final int START_X = (Main.getWidth() / 2) - (PADDLE_WIDTH / 2);
    
    /**
     * The starting Y position.
     */
    private static final int START_Y = 245;
    
    /**
     * The direction that the paddle is currently moving.
     */
    private int direction;
    
    /**
     * Creates a new Paddle.
     */
    public Paddle()
    {
        super(START_X, START_Y, PADDLE_WIDTH, 5);
    }
    
    /**
     * Draw the paddle.
     * @param g The graphics.
     */
    public void draw(Graphics g)
    {
        g.setColor(Color.GREEN);
        g.fill3DRect(x, y, width, height, true);
    }
    
    public void move()
    {
        if (direction == DIRECTION_LEFT)
        {
            x -= 5;
        }
        else if (direction == DIRECTION_RIGHT)
        {
            x += 5;
        }
        
        if (x <= 4)
        {
            x = 4;
        }
        if (x >= 298)
        {
            x = 298;
        }
    }

    @Override
    public void keyTyped(KeyEvent e)
    {
        
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_LEFT)
        {
            direction = DIRECTION_LEFT;
        }
        else if (keyCode == KeyEvent.VK_RIGHT)
        {
            direction = DIRECTION_RIGHT;
        }
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_LEFT)
        {
            if (direction == DIRECTION_LEFT)
            {
                direction = DIRECTION_NONE;
            }
        }
        else if (keyCode == KeyEvent.VK_RIGHT)
        {
            if (direction == DIRECTION_RIGHT)
            {
                direction = DIRECTION_NONE;
            }
        }
    }
    
}

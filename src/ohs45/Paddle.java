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
 *
 * @author Ryan Rule-Hoffman <ryan.rulehoffman@icloud.com>
 */
public class Paddle extends Rectangle
{
    
    /**
     * The starting X position.
     */
    private static final int START_X = 160;
    
    /**
     * The starting Y position.
     */
    private static final int START_Y = 245;
    
    /**
     * Creates a new Paddle.
     */
    public Paddle()
    {
        super(START_X, START_Y, 40, 5);
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
    
}

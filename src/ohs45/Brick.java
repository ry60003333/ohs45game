/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohs45;

import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * A brick in the game.
 * @author OHS AP Computer Science 4/5
 */
public class Brick extends Rectangle
{
    
    /**
     * The starting X coordinates to spawn bricks at.
     */
    public static final int START_X = 70;
    
    /**
     * The starting Y coordinate to spawn bricks at.
     */
    public static final int START_Y = 50;
    
    /**
     * The amount of bricks to spawn.
     */
    public static final int BRICK_COUNT = 12;
    
    /**
     * Creates a new Brick.
     * @param x The X coordinate of the brick.
     * @param y The Y coordinate of the brick.
     */
    public Brick(int x, int y)
    {
        super(x, y, 30, 10);
    }
    
    /**
     * Create an array of bricks.
     * @return The array of bricks.
     */
    public static Brick[] makeBricks()
    {
        Brick[] bricks = new Brick[BRICK_COUNT];
        
        int x = START_X;
        int y = START_Y;
        for (int i = 0; i < bricks.length; i++)
        {
            bricks[i] = new Brick(x, y);
            if (i == 5)
            {
                x = 70;
                y = 62;
            }
            if (i == 9)
            {
                x = 100;
                y = 74;
            }
            x += 31;
        }
        
        return bricks;
    }

    public void draw(Graphics g)
    {
        g.fill3DRect(x, y, width, height, true);
    }
}

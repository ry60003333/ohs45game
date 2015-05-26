/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohs45;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Ryan Rule-Hoffman <ryan.rulehoffman@icloud.com>
 */
public class Game extends JPanel
{
    
    /**
     * The paddle.
     */
    private Paddle paddle;
    
    public Game()
    {
        paddle = new Paddle();
    }
    
    @Override
    public void paint(Graphics g)
    {
        // Draw the background
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0, 0, 350, 450);
        
        // Draw the bottom background
        g.setColor(Color.GRAY);
        g.fillRect(0, 251, 450, 200);
        
        // Draw the paddle
        paddle.draw(g);
        
        // Draw the border
        g.setColor(Color.red);
        g.drawRect(0, 0, 343, 250);
    }
    
}

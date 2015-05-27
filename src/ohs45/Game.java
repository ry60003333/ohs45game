/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohs45;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * The main class of the game.
 * @author OHS AP Computer Science 4/5
 */
public class Game extends JPanel implements ActionListener
{
    
    /**
     * The paddle.
     */
    private final Paddle paddle;
    
    private final Ball ball;
    
    /**
     * Creates a new Game.
     */
    public Game()
    {
        paddle = new Paddle();
        ball = new Ball();
        
        addKeyListener(paddle);
        setFocusable(true);
        
        Timer timer = new Timer(1000/60, this);
        timer.start();
    }
    
    /**
     * Draw the game.
     * @param g The graphics context.
     */
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
        paddle.move();
        paddle.draw(g);
        
        // Draw the ball
        ball.move();
        ball.handlePaddleCollision(paddle);
        ball.draw(g);
        
        // Draw the border
        g.setColor(Color.red);
        g.drawRect(0, 0, 349, 250);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        repaint();
    }
    
}

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
    
    /**
     * The ball.
     */
    private final Ball ball;
    
    /**
     * The current message to display on the screen.
     */
    private String message = "";
    
    /**
     * The array of bricks.
     */
    private Brick[] bricks;
    
    /**
     * Should the ball be displayed on the screen.
     */
    private boolean displayBall = true;
    
    /**
     * The count of how many bricks the player has broken.
     */
    private int bricksBroken = 0;
    
    /**
     * Creates a new Game.
     */
    public Game()
    {
        paddle = new Paddle();
        ball = new Ball();
        bricks = Brick.makeBricks();
        
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
        g.setColor(Color.orange);
        g.fillRect(0, 0, 350, 450);
        
        // Draw the bottom background
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0, 251, 450, 200);
        
        // Draw the paddle
        paddle.move();
        paddle.draw(g);
        
        for (Brick next : bricks)
        {
            if (next != null)
            {
                next.draw(g);
            }
        }
        
        bricksBroken += ball.handleBrickCollision(bricks);
        if (bricksBroken == Brick.BRICK_COUNT)
        {
            message = "You won!";
            displayBall = false;
        }
        
        // Draw the ball
        if (displayBall)
        {
            ball.move();
            ball.handlePaddleCollision(paddle);
            ball.draw(g);
            
            if (ball.y >= 250)
            {
                message = "You lose the game!";
                displayBall = false;
            }
        }
        
        // Draw the border
        g.setColor(Color.WHITE);
        g.drawRect(0, 0, 349, 250);
        
        // Draw the message
        g.drawString(message, 70, 120);
    }

    /**
     * Called when the timer fires.
     * @param e The event.
     */
    @Override
    public void actionPerformed(ActionEvent e)
    {
        repaint();
    }

    /**
     * Restart the game.
     */
    public void restart()
    {
        this.requestFocus();
        message = "";
        ball.reset();
        paddle.reset();
        bricks = Brick.makeBricks();
        bricksBroken = 0;
        displayBall = true;
    }
    
}

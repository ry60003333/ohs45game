/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohs45;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * The main class of the game.
 * @author Ryan Rule-Hoffman <ryan.rulehoffman@icloud.com>
 * @author Simon Wieder <16rwieder@orangecsd.org>
 * @author Michael Litt <17mlitt@orangecsd.org>
 * @author Mr. McMonigle <rmcmonigle@orangecsd.org>
 * @author Mrs. Cingel
 */
public class Main implements ActionListener
{
    
    /**
     * The width of the game.
     */
    private static final int WIDTH = 350;
    
    /**
     * The height of the game.
     */
    private static final int HEIGHT = 450;
    
    /**
     * The instance of the game.
     */
    private final Game game;
    
    /**
     * Creates a new instance of the class Main.
     */
    public Main()
    {
        // Create a window
        JFrame frame = new JFrame();
        
        frame.setTitle("Pixel Smasher");
        frame.setSize(WIDTH, HEIGHT);
        
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Center the window
        frame.setLocationRelativeTo(null);
        
        // Add the restart button
        JButton restartButton = new JButton("Restart");
        restartButton.addActionListener(this);
        frame.add(restartButton, BorderLayout.SOUTH);
        
        // Add the game
        game = new Game();
        frame.add(game);
        
        // Make the window visible
        frame.setVisible(true);
        
        // Start the background music
        Thread thread = new Thread(new MusicPlayer());
        thread.start();
        
    }

    /**
     * The main method.
     * @param args The command line arguments.
     */
    public static void main(String[] args)
    {
        Main game = new Main();
    }
    
    /**
     * Get the width of the frame.
     * @return The width.
     */
    public static int getWidth()
    {
        return WIDTH;
    }

    /**
     * Called when the restart button is pressed.
     * @param e The event.
     */
    @Override
    public void actionPerformed(ActionEvent e)
    {
        game.restart();
    }
    
}

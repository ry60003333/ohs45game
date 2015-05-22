/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohs45;

import javax.swing.JFrame;

/**
 * The main class of the game.
 * @author Ryan Rule-Hoffman <ryan.rulehoffman@icloud.com>
 * @author Simon Wieder <16rwieder@orangecsd.org>
 * @author Michael Litt <17mlitt@orangecsd.org>
 * @author Mr. McMonigle <rmcmonigle@orangecsd.org>
 * @author Mrs. Cingel
 */
public class Main
{
    
    /**
     * The width of the game.
     */
    private static final int WIDTH = 300;
    
    /**
     * The height of the game.
     */
    private static final int HEIGHT = 450;
    
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
        
        // Make the window visible
        frame.setVisible(true);
    }

    /**
     * The main method.
     * @param args The command line arguments.
     */
    public static void main(String[] args)
    {
        Main game = new Main();
    }
    
}

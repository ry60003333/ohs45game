/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohs45;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Ryan Rule-Hoffman <ryan.rulehoffman@icloud.com>
 */
public class TitleScreen extends JPanel implements ActionListener
{
    /**
     * The width of a button.
     */
    private static final int BUTTON_WIDTH = 100;
    
    private final Image logo;
    
    private final JButton startButton;
    
    private final Main main;
    
    public TitleScreen(Main main)
    {
        this.main = main;
        logo = new ImageIcon(getClass().getResource("/ohs45/graphics/logo.png")).getImage();
        
        setLayout(null);
        
        startButton = new JButton("Start");
        startButton.setLocation(Main.WIDTH / 2 - (BUTTON_WIDTH / 2), 280);
        startButton.setSize(BUTTON_WIDTH, 100);
        add(startButton);
        startButton.addActionListener(this);
        
    }
    
    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        
        g.drawImage(logo, (getWidth() / 2) - (logo.getWidth(this) / 2), 0, null);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        setVisible(false);
        main.startGame();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohs45;

import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

/**
 * The music player.
 * @author Simon
 */
public class MusicPlayer implements Runnable
{
    
    /**
     * Play the music.
     */
    @Override
    public void run()
    {
        try
        {
            InputStream resourceAsStream = getClass().getResourceAsStream("/ohs45/music/1990.mp3");
            final Player player = new Player(resourceAsStream);
            while (true)
            {
                player.play();
            }
        } catch (JavaLayerException ex)
        {
            Logger.getLogger(MusicPlayer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

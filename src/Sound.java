
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
import javax.sound.sampled.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

@SuppressWarnings("unused")
public class Sound {
    Clip clip;
    URL so;
    long clippause;
    int count = 0;
    public void Setmusic(URL so) {

	try {
	    AudioInputStream inputStream = AudioSystem.getAudioInputStream(so);
	    clip = AudioSystem.getClip();
	    clip.open(inputStream); 
	} catch (IOException | UnsupportedAudioFileException | LineUnavailableException e) {
	    e.printStackTrace();

	}
    }
    public void play() {
	if(count == 0) {
	    clip.setFramePosition(0);
	    clip.start();
	}
    }
    public void loop() {
	clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void stop() {
		
	    clippause = clip.getMicrosecondPosition();
	    clip.stop();
	    clip.close();
    }
    public void pause() {

    }
}

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class BackgroundMusic {

    private static Clip backgroundClip;

    /**
     * Plays music
     *
     * @param filepath
     */
    public static void play(String filepath) {
        try {
            if (backgroundClip == null || !backgroundClip.isRunning()) {
                File audioFile = new File(filepath);
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
                backgroundClip = AudioSystem.getClip();
                backgroundClip.open(audioStream);
                backgroundClip.loop(Clip.LOOP_CONTINUOUSLY);
            }
        } catch (IOException | LineUnavailableException | UnsupportedAudioFileException e) {
        }
    }

    /**
     * Stops music
     */
    public static void stop() {
        if (backgroundClip != null && backgroundClip.isRunning()) {
            backgroundClip.stop();
        }
    }

    /**
     * Resumes music
     */
    public static void resume() {
        if (backgroundClip != null && !backgroundClip.isRunning()) {
            backgroundClip.start();
        }
    }
}

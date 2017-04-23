package by.ld38.game.sound;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;

public class MusicPlayer {
    private static MusicPlayer ourInstance = new MusicPlayer();

    private Music currentPlaying;

    public static MusicPlayer getInstance() {
        return ourInstance;
    }

    private MusicPlayer() {
    }

    public void startPlay(MusicFiles file, boolean loop) {
        if (currentPlaying != null) {
            stopPlayAndDispose();
        }
        currentPlaying = Gdx.audio.newMusic(file.getFileHandle());
        currentPlaying.setOnCompletionListener(music -> {
            currentPlaying.dispose();
            System.out.println("music complete and disposed");
        });
        currentPlaying.setLooping(loop);
        currentPlaying.play();
    }

    public boolean isPlaying() {
        return currentPlaying != null && currentPlaying.isPlaying();
    }

    public void stopPlayAndDispose() {
        currentPlaying.stop();
        currentPlaying.dispose();
    }
}

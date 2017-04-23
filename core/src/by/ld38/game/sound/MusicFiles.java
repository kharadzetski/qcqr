package by.ld38.game.sound;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

public enum MusicFiles {
    DIGITAL_MK2(Gdx.files.internal("music/digital_mk2.mp3")),
    HUNDRED_YEARS_IN_HELHEIM(Gdx.files.internal("music/hundred_years_in_helheim.mp3")),
    LEFT_ON_DEMIOS(Gdx.files.internal("music/left_on_deimos.mp3")),
    SPELLBRAKER(Gdx.files.internal("music/spellbraker.mp3"));

    private FileHandle fileHandle;

    MusicFiles(FileHandle fileHandle) {
        this.fileHandle = fileHandle;
    }

    public FileHandle getFileHandle() {
        return fileHandle;
    }
}

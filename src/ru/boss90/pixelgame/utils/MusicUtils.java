package ru.boss90.pixelgame.utils;

import java.io.*;
import javax.sound.sampled.*;

public class MusicUtils implements AutoCloseable{
	
		private boolean released = false;
		private AudioInputStream stream = null;
		public static Clip clip = null;
		private FloatControl volumeControl = null;
		public static boolean playing = false;
		
		public MusicUtils(File f) {
			try {
				stream = AudioSystem.getAudioInputStream(f);
				clip = AudioSystem.getClip();
				clip.open(stream);
				clip.addLineListener(new Listener());
				volumeControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
				released = true;
			} catch (IOException | UnsupportedAudioFileException | LineUnavailableException exc) {
				exc.printStackTrace();
				released = false;
				
				close();
			}
		}

		// true если звук успешно загружен, false если произошла ошибка
		public boolean isReleased() {
			return released;
		}
		
		// проигрываетс€ ли звук в данный момент
		public boolean isPlaying() {
			return playing;
		}

		// «апуск
		 
		public void play() {
			if (released) {
					clip.stop();
					clip.setFramePosition(0);
					clip.start();
					playing = true;
				}else if (isPlaying() == true) {
					clip.stop();
					clip.close();
					playing = false;
				}
			}
		
		public void close() {
			if (clip != null)
				clip.close();
			
			if (stream != null)
				try {
					stream.close();
				} catch (IOException exc) {
					exc.printStackTrace();
				}
		}
		public synchronized static MusicUtils playSound(String path) {
			File f = new File(path);
			MusicUtils snd = new MusicUtils(f);
			snd.play();
			return snd;
		}

		private class Listener implements LineListener {
			public void update(LineEvent ev) {
				if (ev.getType() == LineEvent.Type.STOP) {
					playing = false;
					synchronized(clip) {
						clip.notify();
						
					}
				}
			}
		}
}
import java.io.File;

import java.io.IOException;

import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Arrays;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * {@code AudioControl} 음원 병합 및 재생을 담당하는 클래스
 * 
 * @author JongKyeong Park
 */
public class AudioControl {
	AudioInputStream chord1; // 음원 병합을 위한 변수
	AudioInputStream chord2; // 음원 병합을 위한 변수
	AudioInputStream listenChord; // 일시적인 재생을 위한 변수
	AudioInputStream appendedFile;// 음원 병합을 위한 변수

	private int genre = 1; // 최초의 음악 장르는 natural order로 설정한다.
	WaveControl inst;// 악기 설정을 위한 변수

	public void setInstrument(int instrument) { // 악기를 설정한다.
		if (instrument == 1)
			inst = new Lo_fiPiano();
		else if (instrument == 2)
			inst = new ElecPiano();
	}

	public void changeGenreInAudio(int genre) {// 음악의 분위기(코드봇) 변경한다.
		this.genre = genre;
	}

	public void addWavFirst(String chordString1, String chordString2) { // 첫 번째 음원 병합. 최초의 코드 C와 새로 들어오는 코드가 합쳐진다.
		try {
			wavSetFirst(chordString1);
			wavSetSecond(chordString2);
			appendedFile = new AudioInputStream(new SequenceInputStream(chord1, chord2), chord1.getFormat(),
					chord1.getFrameLength() + chord2.getFrameLength());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void addWav(String chordString) { // 첫 번째 이후의 음원병합. 이전까지 병합된 음원과 새로 들어오는 코드가 합쳐진다. 모든 코드 병합은 두개씩 이루어진다.

		try {
			wavSetFirst(chordString);
			appendedFile = new AudioInputStream(new SequenceInputStream(appendedFile, chord1), chord1.getFormat(),
					appendedFile.getFrameLength() + chord1.getFrameLength());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void wavSetFirst(String chordString) { // chord1 변수에 대해 실질적인 음원 파일을 적용시킨다. 음원파일은 악기, 분위기에 따라 결정된다.
		try {
			switch (chordString) {
			case "C":
				if (genre == 1)// natural
					this.chord1 = AudioSystem.getAudioInputStream(new File(inst.getAddr("wavC_natural")));
				else if (genre == 2)
					this.chord1 = AudioSystem.getAudioInputStream(new File(inst.getAddr("wavC_happy")));
				else if (genre == 3)
					this.chord1 = AudioSystem.getAudioInputStream(new File(inst.getAddr("wavC_emo")));
				break;
			case "Dm":
				if (genre == 1)// natural
					this.chord1 = AudioSystem.getAudioInputStream(new File(inst.getAddr("wavDm_natural")));
				else if (genre == 2)
					this.chord1 = AudioSystem.getAudioInputStream(new File(inst.getAddr("wavDm_happy")));
				else if (genre == 3)
					this.chord1 = AudioSystem.getAudioInputStream(new File(inst.getAddr("wavDm_emo")));
				break;
			case "Em":
				if (genre == 1)// natural
					this.chord1 = AudioSystem.getAudioInputStream(new File(inst.getAddr("wavEm_natural")));
				else if (genre == 2)
					this.chord1 = AudioSystem.getAudioInputStream(new File(inst.getAddr("wavEm_happy")));
				else if (genre == 3)
					this.chord1 = AudioSystem.getAudioInputStream(new File(inst.getAddr("wavEm_emo")));
				break;
			case "F":
				if (genre == 1)// natural
					this.chord1 = AudioSystem.getAudioInputStream(new File(inst.getAddr("wavF_natural")));
				else if (genre == 2)
					this.chord1 = AudioSystem.getAudioInputStream(new File(inst.getAddr("wavF_happy")));
				else if (genre == 3)
					this.chord1 = AudioSystem.getAudioInputStream(new File(inst.getAddr("wavF_emo")));
				break;
			case "G":
				if (genre == 1)// natural
					this.chord1 = AudioSystem.getAudioInputStream(new File(inst.getAddr("wavG_natural")));
				else if (genre == 2)
					this.chord1 = AudioSystem.getAudioInputStream(new File(inst.getAddr("wavG_happy")));
				else if (genre == 3)
					this.chord1 = AudioSystem.getAudioInputStream(new File(inst.getAddr("wavG_emo")));
				break;
			case "Am":
				if (genre == 1)// natural
					this.chord1 = AudioSystem.getAudioInputStream(new File(inst.getAddr("wavAm_natural")));
				else if (genre == 2)
					this.chord1 = AudioSystem.getAudioInputStream(new File(inst.getAddr("wavAm_happy")));
				else if (genre == 3)
					this.chord1 = AudioSystem.getAudioInputStream(new File(inst.getAddr("wavAm_emo")));
				break;
			case "E":
				if (genre == 1)// natural
					this.chord1 = AudioSystem.getAudioInputStream(new File(inst.getAddr("wavE_natural")));
				else if (genre == 2)
					this.chord1 = AudioSystem.getAudioInputStream(new File(inst.getAddr("wavE_happy")));
				else if (genre == 3)
					this.chord1 = AudioSystem.getAudioInputStream(new File(inst.getAddr("wavE_emo")));
				break;
			case "A":
				if (genre == 1)// natural
					this.chord1 = AudioSystem.getAudioInputStream(new File(inst.getAddr("wavA_natural")));
				else if (genre == 2)
					this.chord1 = AudioSystem.getAudioInputStream(new File(inst.getAddr("wavA_happy")));
				else if (genre == 3)
					this.chord1 = AudioSystem.getAudioInputStream(new File(inst.getAddr("wavA_emo")));
				break;
			default:
				System.out.println("Wrong Input");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void wavSetSecond(String chordString) {// chord2 변수에 대해 실질적인 음원 파일을 적용시킨다. 음원파일은 악기, 분위기에 따라 결정된다.
		try {
			switch (chordString) {
			case "C":
				if (genre == 1)// natural
					this.chord2 = AudioSystem.getAudioInputStream(new File(inst.getAddr("wavC_natural")));
				else if (genre == 2)// happy
					this.chord2 = AudioSystem.getAudioInputStream(new File(inst.getAddr("wavC_happy")));
				else if (genre == 3)// emotional
					this.chord2 = AudioSystem.getAudioInputStream(new File(inst.getAddr("wavC_emo")));
				break;
			case "Dm":
				if (genre == 1)// natural
					this.chord2 = AudioSystem.getAudioInputStream(new File(inst.getAddr("wavDm_natural")));
				else if (genre == 2)
					this.chord2 = AudioSystem.getAudioInputStream(new File(inst.getAddr("wavDm_happy")));
				else if (genre == 3)
					this.chord2 = AudioSystem.getAudioInputStream(new File(inst.getAddr("wavDm_emo")));
				break;
			case "Em":
				if (genre == 1)// natural
					this.chord2 = AudioSystem.getAudioInputStream(new File(inst.getAddr("wavEm_natural")));
				else if (genre == 2)
					this.chord2 = AudioSystem.getAudioInputStream(new File(inst.getAddr("wavEm_happy")));
				else if (genre == 3)
					this.chord2 = AudioSystem.getAudioInputStream(new File(inst.getAddr("wavEm_emo")));
				break;
			case "F":
				if (genre == 1)// natural
					this.chord2 = AudioSystem.getAudioInputStream(new File(inst.getAddr("wavF_natural")));
				else if (genre == 2)
					this.chord2 = AudioSystem.getAudioInputStream(new File(inst.getAddr("wavF_happy")));
				else if (genre == 3)
					this.chord2 = AudioSystem.getAudioInputStream(new File(inst.getAddr("wavF_emo")));
				break;
			case "G":
				if (genre == 1)// natural
					this.chord2 = AudioSystem.getAudioInputStream(new File(inst.getAddr("wavG_natural")));
				else if (genre == 2)
					this.chord2 = AudioSystem.getAudioInputStream(new File(inst.getAddr("wavG_happy")));
				else if (genre == 3)
					this.chord2 = AudioSystem.getAudioInputStream(new File(inst.getAddr("wavG_emo")));
				break;
			case "Am":
				if (genre == 1)// natural
					this.chord2 = AudioSystem.getAudioInputStream(new File(inst.getAddr("wavAm_natural")));
				else if (genre == 2)
					this.chord2 = AudioSystem.getAudioInputStream(new File(inst.getAddr("wavAm_happy")));
				else if (genre == 3)
					this.chord2 = AudioSystem.getAudioInputStream(new File(inst.getAddr("wavAm_emo")));
				break;
			case "E":
				if (genre == 1)// natural
					this.chord2 = AudioSystem.getAudioInputStream(new File(inst.getAddr("wavE_natural")));
				else if (genre == 2)
					this.chord2 = AudioSystem.getAudioInputStream(new File(inst.getAddr("wavE_happy")));
				else if (genre == 3)
					this.chord2 = AudioSystem.getAudioInputStream(new File(inst.getAddr("wavE_emo")));
				break;
			case "A":
				if (genre == 1)// natural
					this.chord2 = AudioSystem.getAudioInputStream(new File(inst.getAddr("wavA_natural")));
				else if (genre == 2)
					this.chord2 = AudioSystem.getAudioInputStream(new File(inst.getAddr("wavA_happy")));
				else if (genre == 3)
					this.chord2 = AudioSystem.getAudioInputStream(new File(inst.getAddr("wavA_emo")));
				break;
			default:
				System.out.println("Wrong Input");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void listenOne(String chord) { // 코드를 추가하는 과정에서 개별적인 코드에 대한 음원을 ?弩? 수 있게 해주는 함수이다. listenChord 변수가 사용된다.
		try {
			switch (chord) {
			case "C":
				if (genre == 1)// natural
					this.listenChord = AudioSystem.getAudioInputStream(new File(inst.getAddr("wavC_natural")));
				else if (genre == 2)
					this.listenChord = AudioSystem.getAudioInputStream(new File(inst.getAddr("wavC_happy")));
				else if (genre == 3)
					this.listenChord = AudioSystem.getAudioInputStream(new File(inst.getAddr("wavC_emo")));
				break;
			case "Dm":
				if (genre == 1)// natural
					this.listenChord = AudioSystem.getAudioInputStream(new File(inst.getAddr("wavDm_natural")));
				else if (genre == 2)
					this.listenChord = AudioSystem.getAudioInputStream(new File(inst.getAddr("wavDm_happy")));
				else if (genre == 3)
					this.listenChord = AudioSystem.getAudioInputStream(new File(inst.getAddr("wavDm_emo")));
				break;
			case "Em":
				if (genre == 1)// natural
					this.listenChord = AudioSystem.getAudioInputStream(new File(inst.getAddr("wavEm_natural")));
				else if (genre == 2)
					this.listenChord = AudioSystem.getAudioInputStream(new File(inst.getAddr("wavEm_happy")));
				else if (genre == 3)
					this.listenChord = AudioSystem.getAudioInputStream(new File(inst.getAddr("wavEm_emo")));
				break;
			case "F":
				if (genre == 1)// natural
					this.listenChord = AudioSystem.getAudioInputStream(new File(inst.getAddr("wavF_natural")));
				else if (genre == 2)
					this.listenChord = AudioSystem.getAudioInputStream(new File(inst.getAddr("wavF_happy")));
				else if (genre == 3)
					this.listenChord = AudioSystem.getAudioInputStream(new File(inst.getAddr("wavF_emo")));
				break;
			case "G":
				if (genre == 1)// natural
					this.listenChord = AudioSystem.getAudioInputStream(new File(inst.getAddr("wavG_natural")));
				else if (genre == 2)
					this.listenChord = AudioSystem.getAudioInputStream(new File(inst.getAddr("wavG_happy")));
				else if (genre == 3)
					this.listenChord = AudioSystem.getAudioInputStream(new File(inst.getAddr("wavG_emo")));
				break;
			case "Am":
				if (genre == 1)// natural
					this.listenChord = AudioSystem.getAudioInputStream(new File(inst.getAddr("wavAm_natural")));
				else if (genre == 2)
					this.listenChord = AudioSystem.getAudioInputStream(new File(inst.getAddr("wavAm_happy")));
				else if (genre == 3)
					this.listenChord = AudioSystem.getAudioInputStream(new File(inst.getAddr("wavAm_emo")));
				break;
			case "E":
				if (genre == 1)// natural
					this.listenChord = AudioSystem.getAudioInputStream(new File(inst.getAddr("wavE_natural")));
				else if (genre == 2)
					this.listenChord = AudioSystem.getAudioInputStream(new File(inst.getAddr("wavE_happy")));
				else if (genre == 3)
					this.listenChord = AudioSystem.getAudioInputStream(new File(inst.getAddr("wavE_emo")));
				break;
			case "A":
				if (genre == 1)// natural
					this.listenChord = AudioSystem.getAudioInputStream(new File(inst.getAddr("wavA_natural")));
				else if (genre == 2)
					this.listenChord = AudioSystem.getAudioInputStream(new File(inst.getAddr("wavA_happy")));
				else if (genre == 3)
					this.listenChord = AudioSystem.getAudioInputStream(new File(inst.getAddr("wavA_emo")));
				break;
			}
			AudioInputStream audioInputStream = listenChord;
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void makeItMusic(ArrayList<String> chordList) { // ChordControl에서 만든 코드 array를 음원으로 바꾼다. 중간에 코드가 변경되는 경우에
															// update용으로 사용.
		try {
			for (int i = 1; i < chordList.size(); i++) {
				if (i == 1)
					addWavFirst("C", chordList.get(1));
				else
					addWav(chordList.get(i));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void listenCurrent() { // 현재까지 만들어진 음악에 대해 들어볼 수 있게 해주는 함수이다.
		try {
			AudioInputStream audioInputStream = appendedFile;
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void makeMusic(String name) { // 최종적으로 음악을 프로젝트 폴더의 music 폴더에 저장한다. 최초에 사용자가 입력한 제목이 적용된다.
		try {
			AudioSystem.write(appendedFile, AudioFileFormat.Type.WAVE, new File("music/" + name + ".wav"));

		} catch (NullPointerException e) {
			System.out.println("아직 만들어진 음악이 없습니다! 메인 화면으로 돌아갑니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
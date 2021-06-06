import java.io.IOException;
import java.util.ArrayList;

import javax.sound.sampled.UnsupportedAudioFileException;
/**
 * {@code ChordControl} 코드의 실질적인 제어를 담당하는 클래스이다. 
 * @author JongKyeong Park
 */
public class ChordControl { 
	private String name, instrument;
	private int genre;
	private ArrayList<String> chordArray = new ArrayList<String>();
	AudioControl ac = new AudioControl();
	HappyChord happy = new HappyChord();
	NaturalOrderChord naturalOrder = new NaturalOrderChord();
	EmotionalChord emotional = new EmotionalChord();
	public ChordControl(String name, int instrument) { //메인 화면에서 입력된 값들로 ChordControl 클래스를 시작한다. 
		this.name = name;
		this.genre = 1;
		if(instrument == 1) {
			this.instrument = "lo-fi piano";
			ac.setInstrument(1);
		}		
		else {
			this.instrument = "elec piano";
			ac.setInstrument(2);
		}
			
		
		System.out.printf("%s로 연주하는 음악 %s를 시작합니다..\n",this.instrument, this.name);
		chordArray.add("C");
	}
	
	public void changeGenre(int genre) { //장르(봇)를 변경한다.
		this.genre = genre;
		ac.changeGenreInAudio(genre);
	}
	public String getChord() {
		return chordArray.get(chordArray.size()-1);
	};
	
	public void addChord(String chord) { //코드를 추가
		 chordArray.add(chord);
		 if(chordArray.size()==2)
			 ac.addWavFirst(chordArray.get(0), chordArray.get(1));
		 else 
			 ac.addWav(chordArray.get(chordArray.size()-1));
	}
	public int deleteChord() { //마지막 코드 삭제
		if(chordArray.size()==1) {
			System.out.println("첫 번째 코드 C는 변경할 수 없습니다!");
			return -1;
		}
		chordArray.remove(chordArray.size()-1);
		ac.makeItMusic(chordArray);
		return 1;
	}
	public void replaceChord(int index, String chord) { //해당 인덱스의 코드 변경
		chordArray.set(index-1, chord);
	}
	
	public void printChord() { //코드 프린트
		System.out.println("현재 코드: ");
		for(int i=0;i<chordArray.size();i++) {
			System.out.printf("(%d)%s",i+1,chordArray.get(i));
			if(i==0||i!=chordArray.size()-1)
				System.out.print(" -> ");
				
			System.out.print(" ");	
		}
		System.out.println();
	}
	public void listenChord(String chord) {//단일 코드 재생
		System.out.println(chord+"재생");
		ac.listenOne(chord);
	}
	public void recommendChord() {//코드를 추천해주는 함수
		if(genre == 1)
			naturalOrder.printRecommend(chordArray.get(chordArray.size()-1));
		else if(genre == 2)
			happy.printRecommend(chordArray.get(chordArray.size()-1));
		else if(genre == 3)
			emotional.printRecommend(chordArray.get(chordArray.size()-1));
}
	public void listenOverall() {//지금까지의 음악 듣게 해주는 코드
		ac.listenCurrent();
	}
	public void finishMusic() { //지금까지 만들어진 음악을 음원으로 만드는 과정
		ac.makeMusic(name);
	}
	
	public int chordInputCheck(String chord) { //chord인풋에 문제가 없는지를 확인하는 함수. 
		if(chord.equals("C")||chord.equals("Dm")||chord.equals("Em")||chord.equals("F")||chord.equals("G")||chord.equals("Am")||chord.equals("A")||chord.equals("E")) 
			return 1;
		else 
			return -1 ;
		
	}
}

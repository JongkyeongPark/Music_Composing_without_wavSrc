import java.io.IOException;
import java.util.*;

import javax.sound.sampled.UnsupportedAudioFileException;
/**
 * {@code Control} 프로그램의 전반적인 흐름을 관리하는 클래스이다. 
 * @author JongKyeong Park
 */
public class Control { 
	Scanner in = new Scanner(System.in);
	ChordControl cc;
	MyMusic mm = new MyMusic();
	public void start() { //프로그램의 메인 화면이다. 음악 만들기, 듣기, 나가기의 기능을 제공한다.  
		int listResult = 0;
		boolean forLoop=true;
		while(true) {
			System.out.println("반갑습니다 이 프로그램은 당신이 음악을 만들 수 있도록 보조합니다.\n프로그램의 추천에 따라 원하는 음악을 만들어보세요!");
			System.out.println("원하는 기능을 선택하세요!\n1. 음악 만들기\n2. 내 음악 듣기\n3. 나가기");
			int option = Integer.parseInt(in.nextLine());
			if(option!=1&&option!=2&&option!=3) {
				System.out.println("잘못된 입력입니다!");
				continue;
			}
			String name;
			switch(option) {
			case 1:
				init();
				making();
				break;
			case 2:
				while(forLoop) {
					listResult = mm.listMyMusic();
					if(listResult == -1)
						break;
					System.out.println("듣고싶은 음악의 제목을 입력하세요(메뉴로 돌아가기 q):)");
					name = in.nextLine();
					if(name.equals("q")) forLoop = false;
					listResult = mm.listenMusic(name);
					if(listResult == -1)
						continue;
				}break;
			case 3: 
				System.exit(0);
			}
		}
		
	}
	
	public void init() { //start함수에서 음악 만들기를 선택한 경우 만들어질 음악에 대한 초기 설정을 하는 함수이다. 
		boolean forLoop = true;
		System.out.println("당신의 음악을 시작합니다.");
		System.out.println("제목을 입력하세요: ");
		String name = in.nextLine();
		while(forLoop) {
			System.out.println("악기를 선택하세요");
			System.out.println("1. lo-fi piano\n2. elec piano");
			int instrument = Integer.parseInt(in.nextLine());
			if(instrument !=1 && instrument !=2) {
				System.out.println("악기 입력이 잘못됐습니다. 다시 입력하세요");
				continue;
			}
			cc = new ChordControl(name, instrument);
			forLoop = false;
		}
		
	}
	public void making() { //음악을 만드는 과정에서 사용되는 여러 기능들을 관리하는 함수이다. 코드의 추가, 변경, 삭제, 코드 추천봇 변경, 음악 듣기, 음악 마무리 등의 기능이 적용된다. 
		boolean forLoop = true;
		while(forLoop) {
			System.out.println("원하는 기능을 선택하세요 \n1. 코드 추가\n2. 코드 추천봇 변경 3. 코드 삭제\n4. 현재까지의 곡 듣기 5. 음악 마무리");
			int option = Integer.parseInt(in.nextLine());
			if(1>option||option>6) {
				System.out.println("잘못된 입력입니다. 다시 입력해주세요!");
				continue;
			}
			switch(option) {
			case 1: 
				composing();
				break;
			case 2:
				System.out.println("원하는 추천봇을 선택하세요(1. 기본봇, 2. 행복한봇, 3. 감성봇): ");
				int genre = Integer.parseInt(in.nextLine());
				cc.changeGenre(genre);
				if(genre == 1)
					System.out.println("지금부터 일상봇이 당신의 음악을 안내합니다!\n일반적으로 사용되는 코드들이 당신의 음악을 채웁니다.\n");
				else if(genre == 2)
					System.out.println("지금부터 행복한봇이 당신의 음악을 안내합니다!\n행복한 느낌을 주는 코드들이 당신의 음악을 채웁니다.\n");
				else if(genre == 3)
					System.out.println("지금부터 감성봇이 당신의 음악을 안내합니다!\n감성적인 느낌을 주는 코드들이 당신의 음악을 채웁니다.\n");
				break;
			case 3:
				System.out.println("최근 입력한 코드를 삭제합니다..");
				if(cc.deleteChord()==-1)
					break;
				System.out.println("삭제가 완료됐습니다!");
				cc.printChord();
				break;
			case 4:
				cc.listenOverall();
				break;
			case 5:
				System.out.println("현재까지 만든 음악이 폴더에 저장됩니다. 진행하시겠습니까?(1. yes 2. no): ");
				if(Integer.parseInt(in.nextLine())==2)
					break;
				cc.finishMusic();
				forLoop = false;
				break;
			default: 
				System.out.println("잘못된 입력입니다. ");
				break;
			}
		}
		
		
	}
	public void composing() {// 코드를 추가하고 듣는 과정을 관리하는 함수이다. 
		boolean forLoop = true;
		while(forLoop) {
			cc.printChord();
			cc.recommendChord();
			System.out.println("원하는 코드를 입력하세요(작곡 옵션 o, 들어보기 l): ");
			String newChord = in.nextLine();
			if(newChord.equals("o"))
				break;
			else if(newChord.equals("l")) {
				cc.recommendChord();
				tryListen();
			}
			if(cc.chordInputCheck(newChord) == -1) {
				System.out.println("잘못된 입력입니다. 입력 코드를 확인해주세요!");
				continue;
			}
			cc.addChord(newChord);
		}
		
	}
	
	 private void tryListen() { // 추가할 단이 코드에 대해 들어볼 수 있는 함수이다. 
		 System.out.println("코드를 추가하기 전에 먼저 들어봅니다..");
		 while(true) {
			 System.out.println("들어볼 코드를 입력하세요(입력 창으로 돌아가기 q): ");
			 String listenChord = in.nextLine();
			 if(listenChord.equals("q"))
				 return;
			 if(cc.chordInputCheck(listenChord) == -1) {
					System.out.println("잘못된 입력입니다. 입력 코드를 확인해주세요!");
					continue;
				}
			 cc.listenChord(listenChord);
		 }
	 }
	
}

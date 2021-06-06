import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.UnsupportedAudioFileException;
/**
 * {@code MyMusic} 사용자가 만든 음악을 리스트 형태로 확인하고, 재생할 수 있게 해주는 클래스이다. 
 * @author JongKyeong Park
 */
public class MyMusic {
	private String path = "music";
	AudioInputStream myMusic;
	public int listMyMusic() {
		try {
			File dir = new File(path);
			String musicList[] = dir.list();
			if(musicList == null) {
				System.out.println("아직 음악이 존재하지 않습니다. 메뉴로 돌아갑니다..");
				return -1;
			}
			System.out.println("당신의 음악 리스트입니다");
			for(int i=0;i<musicList.length;i++) {
				System.out.println("--------------");
				musicList[i]=musicList[i].substring(0, musicList[i].length()-4); // 확장자 파트 제거
				System.out.println(i+1+": "+musicList[i]);
				System.out.println("--------------");
			}	
		}catch(Exception e) { 
			e.printStackTrace();
        }
		return 0;
	}
	 public int listenMusic(String name) {
	    	try {
	    		if(name.equals("q"))
	    			return -3;
	    		myMusic = AudioSystem.getAudioInputStream(new File("music/"+name+".wav"));
	            Clip clip = AudioSystem.getClip();
	            clip.open(myMusic);
	            clip.start();
	    	}catch(Exception e) { 
	            System.out.println("해당 음악이 존재하지 않습니다. 다시 입력해주세요");
	            return -1;
	    	}
			return 0;
	    }

}
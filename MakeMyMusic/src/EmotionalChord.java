import java.util.Arrays;
/**
 * {@code EmotionalChord} ChordRecommend인터페이스를 implement한다. 감성봇의 코드 추천 과정의 실질적인 데이터를 지니는 클래스이다. 
 * @author JongKyeong Park
 */
public class EmotionalChord implements ChordRecommend{
	private String[] CArray  = {"G", "F"};
	private String[] DmArray = {"C"};
	private String[] EArray = {"C"};
	private String[] FArray = {"C", "G"};	
	private String[] GArray = {"A", "Dm"};
	private String[] AArray = {"F", "E"};
	@Override
	public void printRecommend(String chord) {
		System.out.print("다음으로 추천하는 코드입니다!");
		switch(chord) {
		case "C":
			System.out.println(Arrays.toString(CArray));
			break;
		case "Dm":
			System.out.println(Arrays.toString(DmArray));
			break;
		case "E":
			System.out.println(Arrays.toString(EArray));
			break;
		case "F":
			System.out.println(Arrays.toString(FArray));
			break;
		case "G":
			System.out.println(Arrays.toString(GArray));
			break;
		case "A":
			System.out.println(Arrays.toString(AArray));
			break;
		case "Am":
			System.out.println(Arrays.toString(AArray));
			break;
		case "Em":
			System.out.println(Arrays.toString(EArray));
			
		}
	}
	
}

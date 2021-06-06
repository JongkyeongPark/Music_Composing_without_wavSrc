import java.util.Arrays;
/**
 * {@code NaturalOrderChord} ChordRecommend인터페이스를 implement한다. 일반봇의 코드 추천 과정의 실질적인 데이터를 지니는 클래스이다. 
 * @author JongKyeong Park
 */
public class NaturalOrderChord implements ChordRecommend{ 
	private String[] CArray  = {"Dm", "Em", "F", "G", "Am"};
	private String[] DmArray = {"G", "Em"};
	private String[] EmArray = {"Am", "F"};
	private String[] FArray = {"Dm","G"};	
	private String[] GArray = {"Em", "Am", "C"};
	private String[] AmArray = {"Dm", "F"};
	
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
		case "Em":
			System.out.println(Arrays.toString(EmArray));
			break;
		case "F":
			System.out.println(Arrays.toString(FArray));
			break;
		case "G":
			System.out.println(Arrays.toString(GArray));
			break;
		case "Am":
			System.out.println(Arrays.toString(AmArray));
			break;
		case "A":
			System.out.println(Arrays.toString(AmArray));
			break;
		case "E":
			System.out.println(Arrays.toString(EmArray));
			break;
		}
		
	}
}

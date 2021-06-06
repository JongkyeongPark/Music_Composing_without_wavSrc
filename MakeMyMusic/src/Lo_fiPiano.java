import java.util.HashMap;
/**
 * {@code Lo_fiPiano} WaveControl interface를 implement한다.  lo-fi piano 악기를 이용한 코드 조각 음원들이 이 클래스에서 관리된다.
 * @author JongKyeong Park
 */
public class Lo_fiPiano implements WaveControl{ 
private HashMap<String, String> addrMap = new HashMap<String, String>();
    public Lo_fiPiano(){
    	addrMap.put("wavC_natural","wavSrc/lo-fi/natural/C.wav");
    	addrMap.put("wavDm_natural","wavSrc/lo-fi/natural/Dm.wav");
    	addrMap.put("wavEm_natural","wavSrc/lo-fi/natural/Em.wav");
    	addrMap.put("wavF_natural","wavSrc/lo-fi/natural/F.wav");
    	addrMap.put("wavG_natural","wavSrc/lo-fi/natural/G.wav");
    	addrMap.put("wavAm_natural","wavSrc/lo-fi/natural/Am.wav");
    	addrMap.put("wavA_natural","wavSrc/lo-fi/natural/A.wav");
    	addrMap.put("wavE_natural","wavSrc/lo-fi/natural/E.wav");
    	addrMap.put("wavC_happy","wavSrc/lo-fi/happy/C.wav");
    	addrMap.put("wavDm_happy","wavSrc/lo-fi/happy/Dm.wav");
    	addrMap.put("wavEm_happy","wavSrc/lo-fi/happy/Em.wav");
    	addrMap.put("wavF_happy","wavSrc/lo-fi/happy/F.wav");
    	addrMap.put("wavG_happy","wavSrc/lo-fi/happy/G.wav");
    	addrMap.put("wavAm_happy","wavSrc/lo-fi/happy/Am.wav");
    	addrMap.put("wavC_emo","wavSrc/lo-fi/emotional/C.wav");
    	addrMap.put("wavDm_emo","wavSrc/lo-fi/emotional/Dm.wav");
    	addrMap.put("wavEm_emo","wavSrc/lo-fi/emotional/Em.wav");
    	addrMap.put("wavF_emo","wavSrc/lo-fi/emotional/F.wav");
    	addrMap.put("wavG_emo","wavSrc/lo-fi/emotional/G.wav");
    	addrMap.put("wavAm_emo","wavSrc/lo-fi/emotional/Am.wav");
    }
    
	@Override
	public String getAddr(String wavKey) {
		return addrMap.get(wavKey);
	}

}

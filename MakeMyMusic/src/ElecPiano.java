import java.util.HashMap;
/**
 * {@code ElecPiano} WaveControl interface를 implement한다. elec piano 악기를 이용한 코드 조각 음원들이 이 클래스에서 관리된다.
 * @author JongKyeong Park
 */
public class ElecPiano implements WaveControl{
	private HashMap<String, String> addrMap = new HashMap<String, String>();
    
    public ElecPiano(){
    	addrMap.put("wavC_natural","wavSrc/elec/natural/C.wav");
    	addrMap.put("wavDm_natural","wavSrc/elec/natural/Dm.wav");
    	addrMap.put("wavEm_natural","wavSrc/elec/natural/Em.wav");
    	addrMap.put("wavF_natural","wavSrc/elec/natural/F.wav");
    	addrMap.put("wavG_natural","wavSrc/elec/natural/G.wav");
    	addrMap.put("wavAm_natural","wavSrc/elec/natural/Am.wav");
    	addrMap.put("wavA_natural","wavSrc/elec/natural/A.wav");
    	addrMap.put("wavE_natural","wavSrc/elec/natural/E.wav");
    	addrMap.put("wavC_happy","wavSrc/elec/happy/C.wav");
    	addrMap.put("wavDm_happy","wavSrc/elec/happy/Dm.wav");
    	addrMap.put("wavEm_happy","wavSrc/elec/happy/Em.wav");
    	addrMap.put("wavF_happy","wavSrc/elec/happy/F.wav");
    	addrMap.put("wavG_happy","wavSrc/elec/happy/G.wav");
    	addrMap.put("wavAm_happy","wavSrc/elec/happy/Am.wav");
    	addrMap.put("wavA_happy","wavSrc/elec/happy/A.wav");
    	addrMap.put("wavE_happy","wavSrc/elec/happy/E.wav");
    	addrMap.put("wavC_emo","wavSrc/elec/emotional/C.wav");
    	addrMap.put("wavDm_emo","wavSrc/elec/emotional/Dm.wav");
    	addrMap.put("wavEm_emo","wavSrc/elec/emotional/Em.wav");
    	addrMap.put("wavF_emo","wavSrc/elec/emotional/F.wav");
    	addrMap.put("wavG_emo","wavSrc/elec/emotional/G.wav");
    	addrMap.put("wavAm_emo","wavSrc/elec/emotional/Am.wav");
    	addrMap.put("wavA_emo","wavSrc/elec/emotional/A.wav");
    	addrMap.put("wavE_emo","wavSrc/elec/emotional/E.wav");
    }
    
	@Override
	public String getAddr(String wavKey) {
		return addrMap.get(wavKey);
	}

}

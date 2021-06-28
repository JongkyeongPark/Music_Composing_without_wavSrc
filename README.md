# Music_Composing_without_wavSrc

프로그램의 코드 추천 기능을 따라 자신의 음악을 만드는 프로그램이다. 현재 음원파일은 제외했으나, 원하는 4마디 단위의 코드벼 음원을 폴더에 저장하여 프로그램에 적용시킬 수 있다. 
이 프로그램의 알고리즘은 Control, ChordControl, AudioControl의 3-layer로 동작한다. 
Control에서 명령을 하면 ChordControl은 ArrayList를 통해 코드 배열을 관리하고, ChordControl에서 관리되는 배열은 AudioControl에서 음원화 된다. 

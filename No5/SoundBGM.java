import BGMclass.* ;
import BGMclass.ABC1 ;

public class SoundBGM {
	BGM1 bgm1 = new BGM1();
	BGM2 bgm2 = new BGM2();
	BGM3 bgm3 = new BGM3();
	BGM4 bgm4 = new BGM4();
	
	ABC abc = new ABC();
	ABC1 abc1 = new ABC1();
	ABC2 abc2 = new ABC2();
	ABC3 abc3 = new ABC3();
	
	
	public synchronized void bgm1Start(){
		bgm1.start();//BGM1を流す
	}
	public void bgm1Stop(){
		abc.test(bgm1);//BGM1が止まる
	}
	
	public synchronized void bgm2Start(){
		bgm2.start();//BGM2を流す
	}
	public void bgm2Stop(){
		abc1.test1(bgm2);//BGM2が止まる
	}
	
	public synchronized void bgm3Start(){
		bgm3.start();//BGM3を流す
	}
	public void bgm3Stop(){
		abc2.test2(bgm3);//BGM3が止まる
	}
	
	public void bgm4Start(){
		bgm4.start();//BGM4を流す
	}
	public void bgm4Stop(){
		abc3.test3(bgm4);//BGM4が止まる
	}

}

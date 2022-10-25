import SEclass.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SoundSE {
	
	SE1 se1 = new SE1();
	SE2 se2 = new SE2();
	SE3 se3 = new SE3();
	SE4 se4 = new SE4();
	
	DEF def = new DEF();
	DEF1 def1 = new DEF1();
	DEF2 def2 = new DEF2();
	DEF3 def3 = new DEF3();
	DEF4 def4 = new DEF4();
	
	void se1Start(){
		se1.start();//SE1‚ğ—¬‚·
	}
	void se1Stop(){
		def.test(se1);//SE1‚ğ’â~
	}
	void se2Start(){
		se2.start();//SE2‚ğ—¬‚·
	}
	void se2Stop(){
		def2.test2(se2);//SE2‚ğ’â~
	}
	void se3Start(){
		try {
			Thread.sleep(500); // 10•b(1–œƒ~ƒŠ•b)ŠÔ‚¾‚¯ˆ—‚ğ~‚ß‚é
			se3.start();//SE3‚ğ—¬‚·
		} catch (InterruptedException e) {
		}
	}
	void se3Stop(){
		def3.test3(se3);//SE3‚ğ’â~
	}
	void se4Start(){
		se4.start();//SE4‚ğ—¬‚·
	}
}

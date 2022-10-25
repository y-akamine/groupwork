package BGMclass ;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.Line;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/******
 * 
 * @author isa
 * �T�E���h���Đ�����T���v���v���O����
 * Chip�i�v�����[�h�j�`���ōĐ�����
 * BGM���Đ����邽�߂̃N���X
 */

public class BGM3 extends Thread{
	
	private boolean isStop;
			
	public void run() {
		
		BufferedReader bf = null;
		File file = null;
		AudioInputStream ais = null;
		Clip c = null;
		
		try{

			//readLine�ň�s�ǂݍ��� ()���Ƀt�H���_�������
			file = new File("\\\\192.168.0.3\\student_b\\2022_Web�v���O���}�[\\teamC\\workspace(����)\\work\\sound\\13.Wav");
			//System.out.println(file.isFile());			
			//AudioInputStream�ŃX�g���[������
			ais = AudioSystem.getAudioInputStream(file);
			
			//Clip�ł̍Đ�����
			//Clip���v�����[�h�����Ȃ��Đ�����`��
			//SourceDataLine���X�g���[�~���O�ŋȂ��Đ�����`��
			c = (Clip)AudioSystem.getLine(new Line.Info(Clip.class));
			
			//Clip�`���ł�AudioStream���I�[�v��
			c.open(ais);
			//clip���Đ�������(�����ōĐ��J��Ԃ��񐔂�ݒ�j
			c.loop(10);
			//Thread���ꎞ��~���ċȏ���
			Thread.sleep(1000); //1000��1�b
			int i = 0;
			while(c.isRunning()){
				if(isStop){
				System.out.println(isStop);
				break;
				}
				Thread.sleep(100);
			}
			//System.out.println(c.getFrameLength());
		//��O����
		}catch (IOException e) {
			//System.out.println("�L�[�{�[�h���o�͗�O");
			e.printStackTrace();
		}catch(UnsupportedAudioFileException ue){
			//System.out.println("Audio�̍Đ��t�@�C����O");
			ue.printStackTrace();
		}catch (LineUnavailableException le) {
			//System.out.println("Line�֌W��O");
			le.printStackTrace();
		}catch(InterruptedException ie){
			//System.out.println("Tread�̗�O");
			ie.printStackTrace();
		}finally{
			try{
			   if(c != null){
				   c.close();
			   }
			}catch (Exception e) {
			//System.out.println("�L�[�{�[�h���o�͗�O");
			e.printStackTrace();
			}
		}
	}
		void stopbgm(){
		isStop = true;
		}
	
		/*static void method(boolean flag , ABC1 abc1 , BGM2 bgm2 , BGM3 bgm3){
			if(flag == false){
				abc1.test1(bgm2);
				bgm3.start();
			}
		}*/
}
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
 * サウンドを再生するサンプルプログラム
 * Chip（プリロード）形式で再生する
 * BGMを再生するためのクラス
 */

public class BGM4 extends Thread{

	public void run() {
		
		BufferedReader bf = null;
		File file = null;
		AudioInputStream ais = null;
		Clip c = null;
		
		try{

			//readLineで一行読み込み ()内にフォルダ名を入力
			file = new File("\\\\192.168.0.3\\student_b\\2022_Webプログラマー\\teamC\\workspace(島袋)\\work\\sound\\Led.Wav");
			//System.out.println(file.isFile());			
			//AudioInputStreamでストリーム生成
			ais = AudioSystem.getAudioInputStream(file);
			
			//Clipでの再生処理
			//Clipがプリロードした曲を再生する形式
			//SourceDataLineがストリーミングで曲を再生する形式
			c = (Clip)AudioSystem.getLine(new Line.Info(Clip.class));
			
			//Clip形式ででAudioStreamをオープン
			c.open(ais);
			//clipを再生させる(引数で再生繰り返し回数を設定）
			c.loop(10);
			//Threadを一時停止して曲準備
			Thread.sleep(1000); //1000で1秒
			while(c.isRunning()){
				Thread.sleep(100);
			}
			//System.out.println(c.getFrameLength());
		//例外処理
		}catch (IOException e) {
			//System.out.println("キーボード入出力例外");
			e.printStackTrace();
		}catch(UnsupportedAudioFileException ue){
			//System.out.println("Audioの再生ファイル例外");
			ue.printStackTrace();
		}catch (LineUnavailableException le) {
			//System.out.println("Line関係例外");
			le.printStackTrace();
		}catch(InterruptedException ie){
			//System.out.println("Treadの例外");
			ie.printStackTrace();
		}finally{
			try{
			   if(c != null){
				   c.close();
			   }
			}catch (Exception e) {
			//System.out.println("キーボード入出力例外");
			e.printStackTrace();
			}
		}
	}
}
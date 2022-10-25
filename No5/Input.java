import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.Console;

public class Input{
		
	String name ;
	int setCardNum ;
	boolean rematch = false ;
	
	//名前メソッド
	void nameSet(){

		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		//Scanner scan = new Scanner(System.in);
		System.out.print("　10文字以内で入力しEnterキーを押してください=> ");
		String setName = null;
		//String setName = scan.next();
			try {
				setName = br.readLine();
			}catch (IOException e) {
				e.printStackTrace();
			}
		name = setName;
			if(name.length()==0 || name.length()>10){
				System.out.println("　!!名前は10文字以内です。再入力を!!");
				System.out.println();
				nameSet();
			}else if(name.length()>=1 && name.length()<=10){
				System.out.println("　お名前は「" + setName + "」さんですね");
				System.out.println();
				
			}
	}
	
	//数字メソッド
	void number(int i,Status[] ps){//プレイヤーの引数 A=0 B=1 をiに代入
		Console cons = System.console();
		//先攻の数字、非表示で
		char[] keynum = cons.readPassword("　(BackSpaceキーで消せます)=>");
		String stringNum = new String(keynum);
		
		//確認処理
		//System.out.println("stringNumは" + stringNum);

		//入力が無い時
		if(stringNum.equals("")){
			System.out.println("　!!未入力です！再入力を!!");
	    	System.out.println();
			number(i,ps);
		//数字以外が入力された時
		}else if(!Character.isDigit(keynum[0])){
			System.out.println("　!!数字以外の文字です！再入力を!!");
	    	System.out.println();
			number(i,ps);
		}else{
			//半角スペースを消す処理
			stringNum = stringNum.strip();
			stringNum = stringNum.replace(".","");
			int cardNum = Integer.parseInt(stringNum);
			
			//カード枚数をチェック処理
			//for(int j = 0 ; j < 5 ; j++){
			//	System.out.print(ps[i].leftoverCard[j] + ",");
			//}
			
			if(cardNum<=0 || cardNum>5){
				System.out.println("　!!入力できる数字は1～5です。再入力を!!");
		    	System.out.println();
				number(i,ps);
			}else if(ps[i].leftoverCard[ cardNum - 1 ] <= 0 ){
				//カード枚数が０の時は再入力
				//leftoverCard[2,2,2,2,2]
				System.out.println("　そのカードはもう枚数がありません\n");
				number(i,ps);
			} else {
				//System.out.println("入力された文字は「" + cardNum + "」ですね");
				//System.out.println("入力された文字は「★」ですね");
		    	System.out.println();
				setCardNum = cardNum;
			}
		}
	}

	//挑戦の確認
	void playAgain(Status[] ps,SoundBGM bgmend){
		InputStreamReader pa = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(pa);
		
		//System.out.println("ゲームを再挑戦しますか⇒（はい：Y/y　いいえN/n)");
		String playAgain = null;
		try {
			playAgain = br.readLine();
			if(playAgain.equals("Ｙ")||playAgain.equals("ｙ")||playAgain.equals("Y")||playAgain.equals("y")){
				//再戦の場合は名前はそのままでバトルが開始される
				ps[0].rematch();
				ps[1].rematch();
				rematch = true ;
				bgmend.bgm4Stop();
			}else{
				System.out.println("　*********また遊んでね！！*********");
				System.out.println("　************Thankyou！************");
				System.out.println("");
				bgmend.bgm4Stop();
				String[] a = {"a"};
				No5Main.main(a);
			}
		} catch (IOException e) {
			e.printStackTrace();
			}
		
	}
}


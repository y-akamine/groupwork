import java.util.Iterator;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;


public class Display {

	//勝者の名前を入れる変数
	String winName ;

	//ロゴ表示
	void logo(){
		StringBuilder sb = new StringBuilder();
		BufferedReader in = null ;
		FileReader fr = null ;

		try{
			fr = new FileReader("No.5.txt");
			in = new BufferedReader(fr);
			String text ;
			while((text = in.readLine()) != null){
				System.out.println(text);
			}
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			try{
				in.close();
			}catch(IOException ie){
				System.out.println("クローズ処理の例外");
				ie.printStackTrace();
			}
		}
		System.out.println(sb);
	}
	
	//最初のルール説明（テキストファイルでかっこよく表示するのもあり？）
	void explanation() {
		System.out.println(
			"\n\n┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\n" +
			"┃　・このゲームは２人で遊ぶゲームです　　　　　　　　　　　　　　　　　┃\n" + 
			"┃　・それぞれ HP が 10 、1～5のカードを２枚ずつ所持しています　　　　　┃\n" + 
			"┃　・カードを１枚ずつ出し合い、基本的には数字が大きい方が勝ちです　　　┃\n" + 
			"┃　ただし　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　┃\n" +
			"┃　　①負けた側は『自分が出したカードの数字』分のHPが減ります　　　　　┃\n" + 
			"┃　　②出したカードが相手と同じ場合は両者ともHPが１減ります　　　　　　┃\n" + 
			"┃　　③１と２のカードだけ特殊効果があります　　　　　　　　　　　　　　┃\n" +
			"┃　　④１は５のカードにだけ勝てます　　　　　　　　　　　　　　　　　　┃\n" +
			"┃　　⑤２は１のカードにしか勝てませんが、勝つと自身のHPが２回復します　┃\n" +
			"┃　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　┃\n" +
			"┃　・どちらかのHPが０になるか、全てのカードを使い切ると試合終了です　　┃\n" +
			"┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n"
		);
	}
	
	//名前を入力してくださいの処理
	void nameInput(int number) {
		System.out.println("　プレイヤー" + number + "の名前を入力してください");
	}
	
	//カードAA表示
	void trump(){
		StringBuilder sb = new StringBuilder();
		BufferedReader in = null ;
		FileReader fr = null ;

		try{
			fr = new FileReader("Trump05.txt");
			in = new BufferedReader(fr);
			String text ;
			while((text = in.readLine()) != null){
				System.out.println(text);
			}
		}catch(IOException e){
			//System.out.println("No.5が始まるよ！");
			e.printStackTrace();
		}finally{
			try{
				in.close();
			}catch(IOException ie){
				System.out.println("クローズ処理の例外");
				ie.printStackTrace();
			}
		}
		System.out.println(sb);
	}

	//バトル開始の表示
	void battlestart() {
		System.out.println("　それではバトルの始まりです！\n");
	}
	
	//引数で受け取ったプレイヤー名で数字入力を促す処理
	void numberInput(String name , int[] leftoverCard) {
		//残ってるカードだけ入力を促す処理
		String inputNum = "" ;
		for(int i = 0 ; i < 5 ; i++){
			//カード枚数が０じゃなかったら入力できる数字
			if(leftoverCard[i] > 0){
				inputNum += ((i+1) + " ");
			}
		}

		System.out.println("\n　" + name + "さんは " + inputNum + "の数字を入力をしてEnterキーを押してください");
	}
	
	//出されたカードで勝敗の表示
	void battleResultDisplay(int aNumber , int bNumber , Status[] ps , Battle battle , SoundSE se3) {

		//Statusクラスからカードの種類を並べる
		//card = {"奴隷(1)","僧侶(2)","兵士(3)","貴族(4)","皇帝(5)"}
		String Acard = ps[0].card[aNumber-1];
		String Bcard = ps[1].card[bNumber-1];

		//Battleクラスから勝ったカードを代入
		String winCard = battle.winCard ;

		//Battleクラスからお互いのダメージ量を代入
		int battleDamage[] = battle.damage ;
		
		//どっちが勝ったか比べる
		//バトル区切り
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		if(battle.drawDecision) {//引き分けかどうか　drawDecisionがtrueの時は引き分け
			System.out.println("　" + Acard + "と" + Bcard + "で引き分けです\n");
			System.out.println("　両者のHPが１減りました\n");
		} else {//引き分けじゃなかったら普通の勝負結果
			System.out.println("　" + Acard + "と" + Bcard + "で" + winCard + "が勝ちました\n");
			//結果の後にどっちのHPが減ったか
			if(battleDamage[0] < battleDamage[1]) { //プレイヤーAが負けてる場合
				System.out.println("　" + ps[0].name + "さんのHPが " + -(battleDamage[0]) + " 減りました");
				//回復する場合
				if(battleDamage[1] == 2) {
					se3.se3Start();
					System.out.println("　" + ps[1].name + "さんのHPが " + battleDamage[1] + " 回復しました");
				}
			}else { //プレイヤーBが負けてる場合
				System.out.println("　" + ps[1].name + "さんのHPが " + -(battleDamage[1]) + " 減りました");
				//回復する場合
				if(battleDamage[0] == 2) {
					se3.se3Start();
					System.out.println("　" + ps[0].name + "さんのHPが " + battleDamage[0] + " 回復しました");
				}
			}
		}
	}
	
	void playerStatus( Status[] ps ){
		/////////ステータス２人分のループ///////////
		for(int i = 0 ; i < 2 ; i++){
			
			//HPがマイナスの時は０にする
			if( ps[i].HP < 0 ){
				ps[i].HP = 0 ;
			}
			
			//Sutatus経由の引数で名前と残りHPを表示
			System.out.println("\n　" + ps[i].name + "　　HP " + ps[i].HP);
				
			//残りHPを■の数で表示
			System.out.print("　");
			for(int j = 0 ; j < ps[i].HP ; j++) {
				System.out.print("■");
			}
			System.out.println();
			
			//カードの種類を並べて表示
			for(int j = 0 ; j < 5 ; j++) {
				System.out.print("　" + ps[i].card[j]);
			}
			System.out.println();
			
			//カードの残り枚数を〇×で表示
			for(int j = 0 ; j < 10 ; j++) {
				//残り枚数が２の時だけは１列目は〇
				if(j < 5) {
					if(ps[i].leftoverCard[j] == 2) {
						//残り枚数が２の時だけ〇＆ズレ直しでスペースの数を分岐
						System.out.print( j == 0 ? "　　〇" : j == 1 || j == 4 ? "　　　〇" : "　　　　〇");
					} else { //残り枚数が１または０の時は×
						System.out.print( j == 0 ? "　　×" : j == 1 || j == 4 ? "　　　×" : "　　　　×");
					}
				}else {
					//2列目なので配列を-5にしてまたleftoverCard[0]から枚数チェック
					if(ps[i].leftoverCard[j-5] > 0) {
						//残り枚数が１か２の時は〇
						System.out.print( j == 5 ? "　　〇" :  j == 6 || j == 9 ? "　　　〇" : "　　　　〇");
					} else { //残り枚数が０の時は×
						System.out.print( j == 5 ? "　　×" :  j == 6 || j == 9 ? "　　　×" : "　　　　×");
					}
				}
				if(j == 4 || j == 9) {
					//１行目の表示が終わったら&２行目も表示したら改行
					System.out.println();
				}
			}
		}
		/////////ステータス２人分のループ終わり///////////
	}
	
	//最終的な勝敗の結果の表示/////////////////////////////
	void winsAndLosses(Status[] ps) {
		
		//HPがマイナスの時は０にする
		if( ps[0].HP < 0 ){
			ps[0].HP = 0 ;
		} else if( ps[1].HP < 0 ){
			ps[1].HP = 0 ;
		}
		
		//まずは引き分けパターン
		if( ps[0].HP == ps[1].HP ) {
			System.out.println("\n　" + ps[0].name + "さんのHPが " + ps[0].HP + " と" + ps[1].name + "さんのHPが " + ps[1].HP + " で引き分けです！\n");
		}else if( ps[0].HP <= 0 || ps[1].HP <= 0 ){//どちらかの体力が0になった時
			//Aが負けたかどうか調べる
			if( ps[0].HP <= 0 ) {
				//勝者にBの名前が入る
				winName = ps[1].name ;
			} else {//Bが負けた場合
				//勝者にAの名前が入る
				winName = ps[0].name ;
			}
			//結果表示
			System.out.println("\n　" + ps[0].name + "さんのHPが " + ps[0].HP + " と" + ps[1].name + "さんのHPが " + ps[1].HP + " で" + winName + "さんの勝利です！\n");
		} else {//HPがどちらも０にならずカード枚数が全部無くなった場合
			//どっちの体力が多いか
			//AのHPが低い場合
			if( ps[0].HP < ps[1].HP ) {
				//勝者にBの名前が入る
				winName = ps[1].name ;
			} else {//BのHPが低い場合
				//勝者にAの名前が入る
				winName = ps[0].name ;
			}
			//結果表示
			System.out.println("\n　" + ps[0].name + "さんのHPが " + ps[0].HP + " と" + ps[1].name + "さんのHPが " + ps[1].HP + " で" + winName + "さんの勝利です！\n");
		}

	}
	
	//再戦するか終了するかの表示////////////////////////
	void rematchDisplay() {
		System.out.println("　再戦する場合は「y」を、違う相手と対戦する場合は「y以外のキー」を入力してください");
	}
}

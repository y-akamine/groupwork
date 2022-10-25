public class No5Main {

	public static void main(String[] args) {
		
		//最終更新時間
		System.out.println("最終更新日　9/12 13:55");
		
		//プレイヤーごとのStatusオブジェクトを配列で作る
		Status[] ps = new Status[2];
		ps[0] = new Status(); //プレイヤーAステータス
		ps[1] = new Status(); //プレイヤーBステータス


		
		//SEのインスタンス化
		SoundSE se4 = new SoundSE();

		
		//キーボード系のInputクラスのインスタンス化
		Input input = new Input();
		//Displayクラスの生成
		Display display = new Display();
		
		//ゲームをやり直すためループ
		for(;;) {
			//BGMのインスタンス化
			SoundBGM bgmend = new SoundBGM();
			
			//効果音クラスのインスタンス化(初期化)
			SoundSE se = new SoundSE();
			
			//BGMのインスタンス化(初期化)
			SoundBGM bgm = new SoundBGM();
			bgm.bgm1Start();//BGM1を流す
			
			//ロゴ表示
			display.logo();

			//再戦の時(true)は説明と名前入力を飛ばす
			if(!(input.rematch)) {
				//説明文を表示する処理
				display.explanation();
				
				//プレイヤーの名前入力
				for(int i = 0 ; i < 2 ; i++){
					//プレイヤーAの名前を入力してくださいのDisplay処理
					display.nameInput(i+1);
					
					//ここにキーボード処理
					input.nameSet();
						
					ps[i].nameSet(input.name);//引数を入力した文字にしてステータスに名前をセット
				}
			}
			
			///////////ここからバトルのループ/////////////////
			//まずはBattleのインスタンス化（初期化）
			Battle battle = new Battle();
			
			bgm.bgm1Stop();//BGM1が止まる
			bgm.bgm2Start();//BGM2が流れる
			se.se1Start();//SE1を流す

			//トランプ表示
			display.trump();
			
			//バトル開始の表示
			display.battlestart();
			
			//最初だけステータス表示
			display.playerStatus(ps);
			
			//ピンチBGMを1回だけ流すflag
			boolean flag = false ;
			
			//とりあえず10ターンで終わるので１０回繰り返す
			for(int i = 0 ; i < 10 ; i++) {
				
				//SE2のインスタンス化(初期化)
				SoundSE seb = new SoundSE();
				
				//SE3のインスタンス化(初期化)
				SoundSE se3 = new SoundSE();
				
				
				
				//プレイヤーAに数字入力(出せる数字)を促すDisplay処理
				display.numberInput(ps[0].name , ps[0].leftoverCard);
				
				//プレイヤーAが打った数字(x)を＊で表示する処理//////////////////////////
				input.number(0,ps);
				
				//エンターでプレイヤーAが打った数字をpaNumberに代入する処理//////////
				int paNumber = input.setCardNum;
				
				//System.out.println("inputで入力されたpaNumberは" + paNumber + "です");
				
				//プレイヤーBに数字入力(出せる数字)を促すDisplay処理
				display.numberInput(ps[1].name , ps[1].leftoverCard);
				
				
				//プレイヤーBが打った文字を＊で表示する処理///////////////////////
				input.number(1,ps);
				
				//エンターでプレイヤーBが打った数字をpbNumberに代入する処理/////////
				int pbNumber = input.setCardNum;;
				//System.out.println("inputで入力されたpbNumberは" + pbNumber + "です");
				
				seb.se2Start();//SE2を流す
				
				//paNumberとpbNumberをBattleクラスに渡して返ってきた二次元配列を代入///////
				int[] battleResult = battle.returnDamage( paNumber , pbNumber );
				
				//返ってきた値をStatusクラス(Pa,Pb)に渡す
				ps[0].hpDamage( battleResult[0] );
				ps[1].hpDamage( battleResult[1] );
				
				
				//使用したカードをStatusクラス(Pa,Pb)に渡して枚数を減らす
				ps[0].cardLeftover( paNumber );
				ps[1].cardLeftover( pbNumber );
				
				//カードの勝敗結果の表示と
				//statusクラスから返ってきた値をDisplayクラスに渡して
				//名前、残りHP、残りカード枚数を表示させる
				display.battleResultDisplay(paNumber , pbNumber , ps , battle ,se3);
				display.playerStatus(ps);
				
				se.se1Stop();//SE1を止める
				//se3.se3Stop();//SE3を止める
				
				//回復の処理
				//System.out.println(battle.winCard);
				//if(battle.winCard.equals("僧侶(2)")){
				//		se3.se3Start();//SE2を流す
				//}

				//BGM3への切り替え（ピンチ時）
				if(flag == false && ps[0].HP <= 3 || flag == false && ps[1].HP <= 3){
					bgm.bgm2Stop();
					bgm.bgm3Start();
					flag = true;
				}
				
				//残りHP,残りカード枚数によってBMGを変える処理があるかも
				//どちらかのHPが０になったら強制ループ終了
				if(ps[0].HP <= 0 || ps[1].HP <= 0) {
					break ;
				}
			}
			////////////////バトルのループ終わり////////////
			
			
			//勝敗の結果を表示するDisplayクラスメソッド
			display.winsAndLosses(ps);
			
			//流れている曲を止める
			bgm.bgm2Stop();
			bgm.bgm3Stop();
			
			bgmend.bgm4Start();//BGM4が流れる
			
			//再戦するか終了するかのDisplayクラスメソッド
			display.rematchDisplay();
			
			se.se4Start();//SE4を流す
			
			//再戦するかどうかのキーボード処理
			//終了の場合は最初の処理に戻る
			input.playAgain(ps,bgmend);
		}
	}

}

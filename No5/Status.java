
public class Status {
	
	//プレイヤーの名前
	String name ;
	//プレイヤーのHP
	int HP = 10 ;
	//カードの種類と枚数の配列
	String[] card = {"奴隷(1)","僧侶(2)","兵士(3)","貴族(4)","皇帝(5)"};

	//カードの残り枚数（計算するので分けている）
	int[] leftoverCard = {2,2,2,2,2} ;	
	
	//メインから名前データを受け取ってnameに代入
	void nameSet( String n ) {
		name = n ;
	}
	
	//メインからのbattleResultでHPの増減処理して返す
	int hpDamage( int hpDamage ) {
		HP += hpDamage ;
		return HP ;
	}
	
	//メインから使用したカードを受け取ってカードの枚数を減らして代入
	void cardLeftover( int n ) {
		leftoverCard[n-1] -= 1 ;
	}
	
	//再戦メソッド　名前以外のHPとcardを初期値に戻す
	void rematch() {
		//HPを初期化
		HP = 10 ;
		//カードの枚数を初期化する処理
		for(int i = 0 ; i < 5 ; i++){
			leftoverCard[i] = 2 ;
		}
	}

}

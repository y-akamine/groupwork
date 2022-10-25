public class Battle {
	//AとBのダメージ量配列　{Aのダメージ , Bのダメージ}
	int[] damage = { 0 , 0 };
	
	//勝ったカードの種類を代入する
	String winCard ;
	
	//引き分けかどうかの判定
	boolean drawDecision = false ;
	//先攻の数字：paNumber、後攻の数字：pbNumber
	
	//カードの種類を取得するためのStatusインスタンス化
	Status status = new Status();
	String[] cardType = status.card ;
	/*No5_nameA nA = new No5_nameA();
	No5_nameB nB = new No5_nameB();
	nA.playerA();
	nB.playerB();
	
	No5_num numAB = new No5_num();
	numAB.numberAB();*/
	
	int[] returnDamage(int paNumber , int pbNumber){
	drawDecision = false ;
		if( paNumber == pbNumber ){ //AとBが同じ
			damage[0] = -1 ;
			damage[1] = -1 ;
			drawDecision = true ;//引き分け処理
			winCard = "";
		}else if( paNumber == 1 || pbNumber == 1 ){ //AとBがどちらが1
			if( paNumber == 5 || pbNumber == 5 ){ //AとBがごちらが1＆AとBがどちら５）
				//奴隷(1)が勝ちなのは確定なのでwinCardに代入
				winCard = cardType[0];

				if( paNumber == 1 ){
					damage[0] = 0 ;
					damage[1] = -5 ;
				}else {
					damage[0] = -5 ;
					damage[1] = 0 ;
				}
	
			}else if( paNumber == 2 || pbNumber == 2 ){ //AとBがごちらが1＆AとBがどちら2
				//僧侶(2)が勝ちなのは確定なのでwinCardに代入
				winCard = cardType[1];
	
				if( paNumber == 2 ){
					damage[0] = 2 ;
					damage[1] = -1 ;
				 }else {
					damage[0] = -1 ;
					damage[1] = 2 ;
				}
			}else if( paNumber < pbNumber ) {
			 //兵士(3)か貴族(4)か皇帝(5)をwinCardに代入
			 winCard = cardType[pbNumber-1];

			 damage[0] = -(paNumber) ;
			 damage[1] = 0 ;
			}else {
			 //兵士(3)か貴族(4)か皇帝(5)をwinCardに代入
			 winCard = cardType[paNumber-1];

			 damage[0] = 0 ;
			 damage[1] = -(pbNumber) ;
			}
		}else if( paNumber < pbNumber ) {
			 //兵士(3)か貴族(4)か皇帝(5)をwinCardに代入
			 winCard = cardType[pbNumber-1];

			 damage[0] = -(paNumber) ;
			 damage[1] = 0 ;
		}else {
			 //兵士(3)か貴族(4)か皇帝(5)をwinCardに代入
			 winCard = cardType[paNumber-1];

			 damage[0] = 0 ;
			 damage[1] = -(pbNumber) ;
		}
		
		//まとめて送ればええか
		return damage ;

	}
}

public class BattleTest {
	public static void main(String[] args){
		int[] damage = { 0 , 0 };
		//��U�̐����FnumAAA�A��U�̐����FnumBBB
		
		No5_nameA nA = new No5_nameA();
		No5_nameB nB = new No5_nameB();
		nA.playerA();
		nB.playerB();
		
		No5_num numAB = new No5_num();
		numAB.numberAB();
		
		int[] damageTest(){
		
		if( numAAA == numBBB ){ //A��B������
			damage[0] = -1 ;
			damage[1] = -1 ;
			return damage ;
		}else if( numAAA == 1 || numBBB == 1 ){ //A��B���ǂ��炪1
			if( numAAA == 5 || numBBB == 5 ){ //A��B�������炪1��A��B���ǂ���T�j
	
				if( numAAA == 1 ){
					damage[0] = 0 ;
					damage[1] = -5 ;
					return damage ;
				}else {
					damage[0] = -5 ;
					damage[1] = 0 ;
					return damage ;
				}
	
			}else if( numAAA == 2 || numBBB == 2 ){ //A��B�������炪1��A��B���ǂ���2
	
				if( numAAA == 2 ){
					damage[0] = 2 ;
					damage[1] = -1 ;
					return damage ;
				 }else {
					damage[0] = -1 ;
					damage[1] = 2 ;
					return damage ;
				}
			}
		}else if( numAAA < numBBB ) {
			 damage[0] = -(numAAA) ;
			 damage[1] = 0 ;
			 return damage ;
		}else {
			 damage[0] = 0 ;
			 damage[1] = -(numBBB) ;
			 return damage ;
		}
		}
	}
}

public class Battle {
	//A��B�̃_���[�W�ʔz��@{A�̃_���[�W , B�̃_���[�W}
	int[] damage = { 0 , 0 };
	
	//�������J�[�h�̎�ނ�������
	String winCard ;
	
	//�����������ǂ����̔���
	boolean drawDecision = false ;
	//��U�̐����FpaNumber�A��U�̐����FpbNumber
	
	//�J�[�h�̎�ނ��擾���邽�߂�Status�C���X�^���X��
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
		if( paNumber == pbNumber ){ //A��B������
			damage[0] = -1 ;
			damage[1] = -1 ;
			drawDecision = true ;//������������
			winCard = "";
		}else if( paNumber == 1 || pbNumber == 1 ){ //A��B���ǂ��炪1
			if( paNumber == 5 || pbNumber == 5 ){ //A��B�������炪1��A��B���ǂ���T�j
				//�z��(1)�������Ȃ̂͊m��Ȃ̂�winCard�ɑ��
				winCard = cardType[0];

				if( paNumber == 1 ){
					damage[0] = 0 ;
					damage[1] = -5 ;
				}else {
					damage[0] = -5 ;
					damage[1] = 0 ;
				}
	
			}else if( paNumber == 2 || pbNumber == 2 ){ //A��B�������炪1��A��B���ǂ���2
				//�m��(2)�������Ȃ̂͊m��Ȃ̂�winCard�ɑ��
				winCard = cardType[1];
	
				if( paNumber == 2 ){
					damage[0] = 2 ;
					damage[1] = -1 ;
				 }else {
					damage[0] = -1 ;
					damage[1] = 2 ;
				}
			}else if( paNumber < pbNumber ) {
			 //���m(3)���M��(4)���c��(5)��winCard�ɑ��
			 winCard = cardType[pbNumber-1];

			 damage[0] = -(paNumber) ;
			 damage[1] = 0 ;
			}else {
			 //���m(3)���M��(4)���c��(5)��winCard�ɑ��
			 winCard = cardType[paNumber-1];

			 damage[0] = 0 ;
			 damage[1] = -(pbNumber) ;
			}
		}else if( paNumber < pbNumber ) {
			 //���m(3)���M��(4)���c��(5)��winCard�ɑ��
			 winCard = cardType[pbNumber-1];

			 damage[0] = -(paNumber) ;
			 damage[1] = 0 ;
		}else {
			 //���m(3)���M��(4)���c��(5)��winCard�ɑ��
			 winCard = cardType[paNumber-1];

			 damage[0] = 0 ;
			 damage[1] = -(pbNumber) ;
		}
		
		//�܂Ƃ߂đ���΂�����
		return damage ;

	}
}


public class Status {
	
	//�v���C���[�̖��O
	String name ;
	//�v���C���[��HP
	int HP = 10 ;
	//�J�[�h�̎�ނƖ����̔z��
	String[] card = {"�z��(1)","�m��(2)","���m(3)","�M��(4)","�c��(5)"};

	//�J�[�h�̎c�薇���i�v�Z����̂ŕ����Ă���j
	int[] leftoverCard = {2,2,2,2,2} ;	
	
	//���C�����疼�O�f�[�^���󂯎����name�ɑ��
	void nameSet( String n ) {
		name = n ;
	}
	
	//���C�������battleResult��HP�̑����������ĕԂ�
	int hpDamage( int hpDamage ) {
		HP += hpDamage ;
		return HP ;
	}
	
	//���C������g�p�����J�[�h���󂯎���ăJ�[�h�̖��������炵�đ��
	void cardLeftover( int n ) {
		leftoverCard[n-1] -= 1 ;
	}
	
	//�Đ탁�\�b�h�@���O�ȊO��HP��card�������l�ɖ߂�
	void rematch() {
		//HP��������
		HP = 10 ;
		//�J�[�h�̖��������������鏈��
		for(int i = 0 ; i < 5 ; i++){
			leftoverCard[i] = 2 ;
		}
	}

}

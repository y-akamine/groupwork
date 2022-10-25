import java.util.Iterator;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;


public class Display {

	//���҂̖��O������ϐ�
	String winName ;

	//���S�\��
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
				System.out.println("�N���[�Y�����̗�O");
				ie.printStackTrace();
			}
		}
		System.out.println(sb);
	}
	
	//�ŏ��̃��[�������i�e�L�X�g�t�@�C���ł������悭�\������̂�����H�j
	void explanation() {
		System.out.println(
			"\n\n������������������������������������������������������������������������������������������������������������������������������������������������\n" +
			"���@�E���̃Q�[���͂Q�l�ŗV�ԃQ�[���ł��@�@�@�@�@�@�@�@�@�@�@�@�@�@�@�@�@��\n" + 
			"���@�E���ꂼ�� HP �� 10 �A1�`5�̃J�[�h���Q�����������Ă��܂��@�@�@�@�@��\n" + 
			"���@�E�J�[�h���P�����o�������A��{�I�ɂ͐������傫�����������ł��@�@�@��\n" + 
			"���@�������@�@�@�@�@�@�@�@�@�@�@�@�@�@�@�@�@�@�@�@�@�@�@�@�@�@�@�@�@�@�@��\n" +
			"���@�@�@���������́w�������o�����J�[�h�̐����x����HP������܂��@�@�@�@�@��\n" + 
			"���@�@�A�o�����J�[�h������Ɠ����ꍇ�͗��҂Ƃ�HP���P����܂��@�@�@�@�@�@��\n" + 
			"���@�@�B�P�ƂQ�̃J�[�h����������ʂ�����܂��@�@�@�@�@�@�@�@�@�@�@�@�@�@��\n" +
			"���@�@�C�P�͂T�̃J�[�h�ɂ������Ă܂��@�@�@�@�@�@�@�@�@�@�@�@�@�@�@�@�@�@��\n" +
			"���@�@�D�Q�͂P�̃J�[�h�ɂ������Ă܂��񂪁A���Ǝ��g��HP���Q�񕜂��܂��@��\n" +
			"���@�@�@�@�@�@�@�@�@�@�@�@�@�@�@�@�@�@�@�@�@�@�@�@�@�@�@�@�@�@�@�@�@�@�@��\n" +
			"���@�E�ǂ��炩��HP���O�ɂȂ邩�A�S�ẴJ�[�h���g���؂�Ǝ����I���ł��@�@��\n" +
			"������������������������������������������������������������������������������������������������������������������������������������������������\n"
		);
	}
	
	//���O����͂��Ă��������̏���
	void nameInput(int number) {
		System.out.println("�@�v���C���[" + number + "�̖��O����͂��Ă�������");
	}
	
	//�J�[�hAA�\��
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
			//System.out.println("No.5���n�܂��I");
			e.printStackTrace();
		}finally{
			try{
				in.close();
			}catch(IOException ie){
				System.out.println("�N���[�Y�����̗�O");
				ie.printStackTrace();
			}
		}
		System.out.println(sb);
	}

	//�o�g���J�n�̕\��
	void battlestart() {
		System.out.println("�@����ł̓o�g���̎n�܂�ł��I\n");
	}
	
	//�����Ŏ󂯎�����v���C���[���Ő������͂𑣂�����
	void numberInput(String name , int[] leftoverCard) {
		//�c���Ă�J�[�h�������͂𑣂�����
		String inputNum = "" ;
		for(int i = 0 ; i < 5 ; i++){
			//�J�[�h�������O����Ȃ���������͂ł��鐔��
			if(leftoverCard[i] > 0){
				inputNum += ((i+1) + " ");
			}
		}

		System.out.println("\n�@" + name + "����� " + inputNum + "�̐�������͂�����Enter�L�[�������Ă�������");
	}
	
	//�o���ꂽ�J�[�h�ŏ��s�̕\��
	void battleResultDisplay(int aNumber , int bNumber , Status[] ps , Battle battle , SoundSE se3) {

		//Status�N���X����J�[�h�̎�ނ���ׂ�
		//card = {"�z��(1)","�m��(2)","���m(3)","�M��(4)","�c��(5)"}
		String Acard = ps[0].card[aNumber-1];
		String Bcard = ps[1].card[bNumber-1];

		//Battle�N���X���珟�����J�[�h����
		String winCard = battle.winCard ;

		//Battle�N���X���炨�݂��̃_���[�W�ʂ���
		int battleDamage[] = battle.damage ;
		
		//�ǂ���������������ׂ�
		//�o�g����؂�
		System.out.println("��������������������������������������������������������������������������������������������������������������������������������������������");
		if(battle.drawDecision) {//�����������ǂ����@drawDecision��true�̎��͈�������
			System.out.println("�@" + Acard + "��" + Bcard + "�ň��������ł�\n");
			System.out.println("�@���҂�HP���P����܂���\n");
		} else {//������������Ȃ������畁�ʂ̏�������
			System.out.println("�@" + Acard + "��" + Bcard + "��" + winCard + "�������܂���\n");
			//���ʂ̌�ɂǂ�����HP����������
			if(battleDamage[0] < battleDamage[1]) { //�v���C���[A�������Ă�ꍇ
				System.out.println("�@" + ps[0].name + "�����HP�� " + -(battleDamage[0]) + " ����܂���");
				//�񕜂���ꍇ
				if(battleDamage[1] == 2) {
					se3.se3Start();
					System.out.println("�@" + ps[1].name + "�����HP�� " + battleDamage[1] + " �񕜂��܂���");
				}
			}else { //�v���C���[B�������Ă�ꍇ
				System.out.println("�@" + ps[1].name + "�����HP�� " + -(battleDamage[1]) + " ����܂���");
				//�񕜂���ꍇ
				if(battleDamage[0] == 2) {
					se3.se3Start();
					System.out.println("�@" + ps[0].name + "�����HP�� " + battleDamage[0] + " �񕜂��܂���");
				}
			}
		}
	}
	
	void playerStatus( Status[] ps ){
		/////////�X�e�[�^�X�Q�l���̃��[�v///////////
		for(int i = 0 ; i < 2 ; i++){
			
			//HP���}�C�i�X�̎��͂O�ɂ���
			if( ps[i].HP < 0 ){
				ps[i].HP = 0 ;
			}
			
			//Sutatus�o�R�̈����Ŗ��O�Ǝc��HP��\��
			System.out.println("\n�@" + ps[i].name + "�@�@HP " + ps[i].HP);
				
			//�c��HP�����̐��ŕ\��
			System.out.print("�@");
			for(int j = 0 ; j < ps[i].HP ; j++) {
				System.out.print("��");
			}
			System.out.println();
			
			//�J�[�h�̎�ނ���ׂĕ\��
			for(int j = 0 ; j < 5 ; j++) {
				System.out.print("�@" + ps[i].card[j]);
			}
			System.out.println();
			
			//�J�[�h�̎c�薇�����Z�~�ŕ\��
			for(int j = 0 ; j < 10 ; j++) {
				//�c�薇�����Q�̎������͂P��ڂ́Z
				if(j < 5) {
					if(ps[i].leftoverCard[j] == 2) {
						//�c�薇�����Q�̎������Z���Y�������ŃX�y�[�X�̐��𕪊�
						System.out.print( j == 0 ? "�@�@�Z" : j == 1 || j == 4 ? "�@�@�@�Z" : "�@�@�@�@�Z");
					} else { //�c�薇�����P�܂��͂O�̎��́~
						System.out.print( j == 0 ? "�@�@�~" : j == 1 || j == 4 ? "�@�@�@�~" : "�@�@�@�@�~");
					}
				}else {
					//2��ڂȂ̂Ŕz���-5�ɂ��Ă܂�leftoverCard[0]���疇���`�F�b�N
					if(ps[i].leftoverCard[j-5] > 0) {
						//�c�薇�����P���Q�̎��́Z
						System.out.print( j == 5 ? "�@�@�Z" :  j == 6 || j == 9 ? "�@�@�@�Z" : "�@�@�@�@�Z");
					} else { //�c�薇�����O�̎��́~
						System.out.print( j == 5 ? "�@�@�~" :  j == 6 || j == 9 ? "�@�@�@�~" : "�@�@�@�@�~");
					}
				}
				if(j == 4 || j == 9) {
					//�P�s�ڂ̕\�����I�������&�Q�s�ڂ��\����������s
					System.out.println();
				}
			}
		}
		/////////�X�e�[�^�X�Q�l���̃��[�v�I���///////////
	}
	
	//�ŏI�I�ȏ��s�̌��ʂ̕\��/////////////////////////////
	void winsAndLosses(Status[] ps) {
		
		//HP���}�C�i�X�̎��͂O�ɂ���
		if( ps[0].HP < 0 ){
			ps[0].HP = 0 ;
		} else if( ps[1].HP < 0 ){
			ps[1].HP = 0 ;
		}
		
		//�܂��͈��������p�^�[��
		if( ps[0].HP == ps[1].HP ) {
			System.out.println("\n�@" + ps[0].name + "�����HP�� " + ps[0].HP + " ��" + ps[1].name + "�����HP�� " + ps[1].HP + " �ň��������ł��I\n");
		}else if( ps[0].HP <= 0 || ps[1].HP <= 0 ){//�ǂ��炩�̗̑͂�0�ɂȂ�����
			//A�����������ǂ������ׂ�
			if( ps[0].HP <= 0 ) {
				//���҂�B�̖��O������
				winName = ps[1].name ;
			} else {//B���������ꍇ
				//���҂�A�̖��O������
				winName = ps[0].name ;
			}
			//���ʕ\��
			System.out.println("\n�@" + ps[0].name + "�����HP�� " + ps[0].HP + " ��" + ps[1].name + "�����HP�� " + ps[1].HP + " ��" + winName + "����̏����ł��I\n");
		} else {//HP���ǂ�����O�ɂȂ炸�J�[�h�������S�������Ȃ����ꍇ
			//�ǂ����̗̑͂�������
			//A��HP���Ⴂ�ꍇ
			if( ps[0].HP < ps[1].HP ) {
				//���҂�B�̖��O������
				winName = ps[1].name ;
			} else {//B��HP���Ⴂ�ꍇ
				//���҂�A�̖��O������
				winName = ps[0].name ;
			}
			//���ʕ\��
			System.out.println("\n�@" + ps[0].name + "�����HP�� " + ps[0].HP + " ��" + ps[1].name + "�����HP�� " + ps[1].HP + " ��" + winName + "����̏����ł��I\n");
		}

	}
	
	//�Đ킷�邩�I�����邩�̕\��////////////////////////
	void rematchDisplay() {
		System.out.println("�@�Đ킷��ꍇ�́uy�v���A�Ⴄ����Ƒΐ킷��ꍇ�́uy�ȊO�̃L�[�v����͂��Ă�������");
	}
}

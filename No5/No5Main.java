public class No5Main {

	public static void main(String[] args) {
		
		//�ŏI�X�V����
		System.out.println("�ŏI�X�V���@9/12 13:55");
		
		//�v���C���[���Ƃ�Status�I�u�W�F�N�g��z��ō��
		Status[] ps = new Status[2];
		ps[0] = new Status(); //�v���C���[A�X�e�[�^�X
		ps[1] = new Status(); //�v���C���[B�X�e�[�^�X


		
		//SE�̃C���X�^���X��
		SoundSE se4 = new SoundSE();

		
		//�L�[�{�[�h�n��Input�N���X�̃C���X�^���X��
		Input input = new Input();
		//Display�N���X�̐���
		Display display = new Display();
		
		//�Q�[������蒼�����߃��[�v
		for(;;) {
			//BGM�̃C���X�^���X��
			SoundBGM bgmend = new SoundBGM();
			
			//���ʉ��N���X�̃C���X�^���X��(������)
			SoundSE se = new SoundSE();
			
			//BGM�̃C���X�^���X��(������)
			SoundBGM bgm = new SoundBGM();
			bgm.bgm1Start();//BGM1�𗬂�
			
			//���S�\��
			display.logo();

			//�Đ�̎�(true)�͐����Ɩ��O���͂��΂�
			if(!(input.rematch)) {
				//��������\�����鏈��
				display.explanation();
				
				//�v���C���[�̖��O����
				for(int i = 0 ; i < 2 ; i++){
					//�v���C���[A�̖��O����͂��Ă���������Display����
					display.nameInput(i+1);
					
					//�����ɃL�[�{�[�h����
					input.nameSet();
						
					ps[i].nameSet(input.name);//��������͂��������ɂ��ăX�e�[�^�X�ɖ��O���Z�b�g
				}
			}
			
			///////////��������o�g���̃��[�v/////////////////
			//�܂���Battle�̃C���X�^���X���i�������j
			Battle battle = new Battle();
			
			bgm.bgm1Stop();//BGM1���~�܂�
			bgm.bgm2Start();//BGM2�������
			se.se1Start();//SE1�𗬂�

			//�g�����v�\��
			display.trump();
			
			//�o�g���J�n�̕\��
			display.battlestart();
			
			//�ŏ������X�e�[�^�X�\��
			display.playerStatus(ps);
			
			//�s���`BGM��1�񂾂�����flag
			boolean flag = false ;
			
			//�Ƃ肠����10�^�[���ŏI���̂łP�O��J��Ԃ�
			for(int i = 0 ; i < 10 ; i++) {
				
				//SE2�̃C���X�^���X��(������)
				SoundSE seb = new SoundSE();
				
				//SE3�̃C���X�^���X��(������)
				SoundSE se3 = new SoundSE();
				
				
				
				//�v���C���[A�ɐ�������(�o���鐔��)�𑣂�Display����
				display.numberInput(ps[0].name , ps[0].leftoverCard);
				
				//�v���C���[A���ł�������(x)�����ŕ\�����鏈��//////////////////////////
				input.number(0,ps);
				
				//�G���^�[�Ńv���C���[A���ł���������paNumber�ɑ�����鏈��//////////
				int paNumber = input.setCardNum;
				
				//System.out.println("input�œ��͂��ꂽpaNumber��" + paNumber + "�ł�");
				
				//�v���C���[B�ɐ�������(�o���鐔��)�𑣂�Display����
				display.numberInput(ps[1].name , ps[1].leftoverCard);
				
				
				//�v���C���[B���ł������������ŕ\�����鏈��///////////////////////
				input.number(1,ps);
				
				//�G���^�[�Ńv���C���[B���ł���������pbNumber�ɑ�����鏈��/////////
				int pbNumber = input.setCardNum;;
				//System.out.println("input�œ��͂��ꂽpbNumber��" + pbNumber + "�ł�");
				
				seb.se2Start();//SE2�𗬂�
				
				//paNumber��pbNumber��Battle�N���X�ɓn���ĕԂ��Ă����񎟌��z�����///////
				int[] battleResult = battle.returnDamage( paNumber , pbNumber );
				
				//�Ԃ��Ă����l��Status�N���X(Pa,Pb)�ɓn��
				ps[0].hpDamage( battleResult[0] );
				ps[1].hpDamage( battleResult[1] );
				
				
				//�g�p�����J�[�h��Status�N���X(Pa,Pb)�ɓn���Ė��������炷
				ps[0].cardLeftover( paNumber );
				ps[1].cardLeftover( pbNumber );
				
				//�J�[�h�̏��s���ʂ̕\����
				//status�N���X����Ԃ��Ă����l��Display�N���X�ɓn����
				//���O�A�c��HP�A�c��J�[�h������\��������
				display.battleResultDisplay(paNumber , pbNumber , ps , battle ,se3);
				display.playerStatus(ps);
				
				se.se1Stop();//SE1���~�߂�
				//se3.se3Stop();//SE3���~�߂�
				
				//�񕜂̏���
				//System.out.println(battle.winCard);
				//if(battle.winCard.equals("�m��(2)")){
				//		se3.se3Start();//SE2�𗬂�
				//}

				//BGM3�ւ̐؂�ւ��i�s���`���j
				if(flag == false && ps[0].HP <= 3 || flag == false && ps[1].HP <= 3){
					bgm.bgm2Stop();
					bgm.bgm3Start();
					flag = true;
				}
				
				//�c��HP,�c��J�[�h�����ɂ����BMG��ς��鏈�������邩��
				//�ǂ��炩��HP���O�ɂȂ����狭�����[�v�I��
				if(ps[0].HP <= 0 || ps[1].HP <= 0) {
					break ;
				}
			}
			////////////////�o�g���̃��[�v�I���////////////
			
			
			//���s�̌��ʂ�\������Display�N���X���\�b�h
			display.winsAndLosses(ps);
			
			//����Ă���Ȃ��~�߂�
			bgm.bgm2Stop();
			bgm.bgm3Stop();
			
			bgmend.bgm4Start();//BGM4�������
			
			//�Đ킷�邩�I�����邩��Display�N���X���\�b�h
			display.rematchDisplay();
			
			se.se4Start();//SE4�𗬂�
			
			//�Đ킷�邩�ǂ����̃L�[�{�[�h����
			//�I���̏ꍇ�͍ŏ��̏����ɖ߂�
			input.playAgain(ps,bgmend);
		}
	}

}

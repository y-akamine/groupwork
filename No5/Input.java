import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.Console;

public class Input{
		
	String name ;
	int setCardNum ;
	boolean rematch = false ;
	
	//���O���\�b�h
	void nameSet(){

		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		//Scanner scan = new Scanner(System.in);
		System.out.print("�@10�����ȓ��œ��͂�Enter�L�[�������Ă�������=> ");
		String setName = null;
		//String setName = scan.next();
			try {
				setName = br.readLine();
			}catch (IOException e) {
				e.printStackTrace();
			}
		name = setName;
			if(name.length()==0 || name.length()>10){
				System.out.println("�@!!���O��10�����ȓ��ł��B�ē��͂�!!");
				System.out.println();
				nameSet();
			}else if(name.length()>=1 && name.length()<=10){
				System.out.println("�@�����O�́u" + setName + "�v����ł���");
				System.out.println();
				
			}
	}
	
	//�������\�b�h
	void number(int i,Status[] ps){//�v���C���[�̈��� A=0 B=1 ��i�ɑ��
		Console cons = System.console();
		//��U�̐����A��\����
		char[] keynum = cons.readPassword("�@(BackSpace�L�[�ŏ����܂�)=>");
		String stringNum = new String(keynum);
		
		//�m�F����
		//System.out.println("stringNum��" + stringNum);

		//���͂�������
		if(stringNum.equals("")){
			System.out.println("�@!!�����͂ł��I�ē��͂�!!");
	    	System.out.println();
			number(i,ps);
		//�����ȊO�����͂��ꂽ��
		}else if(!Character.isDigit(keynum[0])){
			System.out.println("�@!!�����ȊO�̕����ł��I�ē��͂�!!");
	    	System.out.println();
			number(i,ps);
		}else{
			//���p�X�y�[�X����������
			stringNum = stringNum.strip();
			stringNum = stringNum.replace(".","");
			int cardNum = Integer.parseInt(stringNum);
			
			//�J�[�h�������`�F�b�N����
			//for(int j = 0 ; j < 5 ; j++){
			//	System.out.print(ps[i].leftoverCard[j] + ",");
			//}
			
			if(cardNum<=0 || cardNum>5){
				System.out.println("�@!!���͂ł��鐔����1�`5�ł��B�ē��͂�!!");
		    	System.out.println();
				number(i,ps);
			}else if(ps[i].leftoverCard[ cardNum - 1 ] <= 0 ){
				//�J�[�h�������O�̎��͍ē���
				//leftoverCard[2,2,2,2,2]
				System.out.println("�@���̃J�[�h�͂�������������܂���\n");
				number(i,ps);
			} else {
				//System.out.println("���͂��ꂽ�����́u" + cardNum + "�v�ł���");
				//System.out.println("���͂��ꂽ�����́u���v�ł���");
		    	System.out.println();
				setCardNum = cardNum;
			}
		}
	}

	//����̊m�F
	void playAgain(Status[] ps,SoundBGM bgmend){
		InputStreamReader pa = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(pa);
		
		//System.out.println("�Q�[�����Ē��킵�܂����ˁi�͂��FY/y�@������N/n)");
		String playAgain = null;
		try {
			playAgain = br.readLine();
			if(playAgain.equals("�x")||playAgain.equals("��")||playAgain.equals("Y")||playAgain.equals("y")){
				//�Đ�̏ꍇ�͖��O�͂��̂܂܂Ńo�g�����J�n�����
				ps[0].rematch();
				ps[1].rematch();
				rematch = true ;
				bgmend.bgm4Stop();
			}else{
				System.out.println("�@*********�܂��V��łˁI�I*********");
				System.out.println("�@************Thankyou�I************");
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


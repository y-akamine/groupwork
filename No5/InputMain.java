class InputMain{
	public static void main(String[] args){
		Input input = new Input();

		input.nameSet();
		System.out.println("test:�A���Ă������O��" + input.name + "�ł�");
		System.out.println();
		
	for(;;){
		input.number();
		System.out.println("test:�A���Ă������l��" + input.number + "�ł�");
		System.out.println();
		
		
		input.playAgain();
		System.out.println("");
		}
		
	}
}


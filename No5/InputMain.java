class InputMain{
	public static void main(String[] args){
		Input input = new Input();

		input.nameSet();
		System.out.println("test:帰ってきた名前は" + input.name + "です");
		System.out.println();
		
	for(;;){
		input.number();
		System.out.println("test:帰ってきた数値は" + input.number + "です");
		System.out.println();
		
		
		input.playAgain();
		System.out.println("");
		}
		
	}
}


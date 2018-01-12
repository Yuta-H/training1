package main;

class Dog extends Animal{


	Dog(String name, String type, int appetite, int distance){
		super(name, type, appetite, distance);
	}

	public void printData() {
		super.printData();
		switch(this.getAppetite()) {
		case 0:
			System.out.println("餌を与えて下さい");
			break;
		case 50:
			System.out.println("状態は通常です");
			break;
		case 100:
			System.out.println("食べ過ぎです");
			break;
		}
	}
	
	public void run(int appetite) {
		System.out.println("走ります");
		if (this.getAppetite() == 100) {
			this.setAppetite(this.getAppetite() - getDistance());
			System.out.println("状態は通常です");
		} else {
			System.out.println("餌を与えて下さい");
		}
	}

	public void eating(int appetite) {
		System.out.println("餌を与えます");
		if(this.getAppetite() == 100) {
			System.out.println("これ以上食べられません");
		}else if(this.getAppetite() == 50) {
			System.out.println("満腹になりました");
			this.setAppetite(this.getAppetite() + 50);
		}else{
			System.out.println("通常です");
			this.setAppetite(this.getAppetite() + 50);
		}
	}
}

package main;

class Mouse extends Animal{


Mouse(String name, String type, int apptite, int distance) {
		super(name, type, apptite, distance);
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

public void run(int distance) {
    System.out.println("走ります");
    if (this.getAppetite() <= 50) {
      this.setAppetite(this.getAppetite() - distance);
      System.out.println("満腹度；"+getAppetite()+"％");
    } else {
    	System.out.println("餌を与えて下さい");
    }
    System.out.println("満腹度；"+getAppetite()+"％");
}


}
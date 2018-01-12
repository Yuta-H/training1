package main;

public class Main {

	public static void main(String[] args) {
		
		Person person1 = new Person("堀", "男", 23, "プログラマ");
		Person person2 = new Person("山田", "女", 30, "料理人");
		
		
		//name type appetite distance の順
		Dog dog = new Dog("ポチ","芝犬", 50, 50);
		Mouse mouse = new Mouse("ハム子","ゴールデンハムスター", 100, 50);
		
		person1.buy(dog);
		person2.buy(mouse);
		
		//dog、その飼い主の情報
		System.out.println("【ペットの情報】");
	    dog.printData();
	    System.out.println("-----------------");
	    System.out.println("【飼い主の情報】");
	    dog.getOwner().printData();

	    //mouse、その飼い主の情報
	    System.out.println("=================");
	    System.out.println("【ペットの情報】");
	    mouse.printData();
	    System.out.println("-----------------");
	    System.out.println("【飼い主の情報】");
	    mouse.getOwner().printData();
	  }
	}

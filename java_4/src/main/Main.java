package main;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person person1 = new Person("堀","裕太","男",23,"料理人");
			person1.printData();
			
		Person person2 = new Person("山田","エイミー","花子","女",23,"デザイナー");
			person2.printData();
			
			System.out.println("-------------------");
			
			person1.setJob("プログラマ");
			System.out.println("person1の仕事を"+person1.getJob()+"に変更しました");
		
			person1.printData();
	}

}

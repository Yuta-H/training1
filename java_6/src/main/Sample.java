package main;

public class Sample {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		String className = args[0];

		try {
			System.out.println(Class.forName(className)+"は存在しています。");
			System.out.println("例外は発生しませんでした");
		}catch(ClassNotFoundException e){
		System.out.println("例外が発生しました。");
		e.printStackTrace();
		}
	}

}

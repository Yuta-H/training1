package main;

import java.util.Scanner;

public class Sample {
	
	
	public static void main (String[] args) {
		Scanner scanner = new Scanner(System.in);

		
		String name = null;
		System.out.println("名前:");
		//文字列の入力
		if(scanner.hasNext()) {
			name = scanner.next();
			System.out.println("入力が完了しました");
		}else{
			System.out.println("文字列を入力して下さい");
		}

		int number = 0;
		System.out.println("出席番号:");
		//整数の入力
		if(scanner.hasNextInt()) {
			number = scanner.nextInt();
			System.out.println(number);
			System.out.println("入力が完了しました");
		}else{
			System.out.println("半角数字を入力して下さい");
		}

		int kokugo = 0;
		System.out.println("国語:");
		//整数の入力
		if(scanner.hasNextInt()) {
			kokugo = scanner.nextInt();
			System.out.println("入力が完了しました");
		}else{
			System.out.println(scanner.next());
			System.out.println("半角数字を入力して下さい");
		}


		int sugaku = 0;
		System.out.println("数学:");
		//整数の入力
		if(scanner.hasNextInt()) {
			sugaku = scanner.nextInt();
			System.out.println("入力が完了しました");
		}else{
			System.out.println("半角数字を入力して下さい");
		}

		int rika = 0;
		System.out.println("理科:");
		//整数の入力
		if(scanner.hasNextInt()) {
			rika = scanner.nextInt();
			System.out.println("入力が完了しました");
		}else{
			System.out.println("半角数字を入力して下さい");
		}

		int syakai = 0;
		System.out.println("社会:");
		//整数の入力
		if(scanner.hasNextInt()) {
			syakai = scanner.nextInt();
			System.out.println("入力が完了しました");
		}else{
			System.out.println("半角数字を入力して下さい");
		}

		int english = 0;
		System.out.println("英語:");
		//整数の入力
		if(scanner.hasNextInt()) {
			english = scanner.nextInt();
			System.out.println("入力が完了しました");
		}else{
			System.out.println("半角数字を入力して下さい");
		}
		Sample2.printData(name, number, kokugo, sugaku, rika, syakai, english);
	}
}

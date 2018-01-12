package main;

public class Sample2 {
 public static void printData(String name, int number, int kokugo, int sugaku, int rika, int syakai, int english) {
	 System.out.println("名前：" + name +"様");
	 System.out.println("出席番号：" + number + "番");
	 System.out.println("国語：" + kokugo +"点");
	 System.out.println("数学：" + sugaku +"点");
	 System.out.println("理科：" + rika +"点");
	 System.out.println("社会：" + syakai +"点");
	 System.out.println("英語：" + english +"点");
	 
	 int total = total(kokugo, sugaku, rika, syakai, english);
	 System.out.println("合計点数:"+total+"点");
	 
	 double average = average(kokugo, sugaku, rika, syakai, english);
	 System.out.println("平均点:"+average+"点");
	 
	
	 }
 public static int total(int kokugo, int sugaku, int rika, int syakai, int english ){
	 return kokugo + sugaku + rika + syakai + english;
 }
 public static double average(int kokugo, int sugaku, int rika, int syakai, int english ) {
	 return (kokugo + sugaku + rika + syakai + english) / 5;
 }
 }



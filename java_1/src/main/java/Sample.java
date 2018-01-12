package main.java;

public class Sample {
  public static void main(String[] args) {
	  
	  //変数nameに、名前を代入してください
	  String name = "yuta";
	  
	  //変数ageに、年齢を代入して下さい
	  int age = 23;
	  
	  //変数heightに、身長を代入して下さい
	  double height = 1.7;
	  
	  //変数weightに、平常時の体重を代入して下さい
	  double weight = 70.5;
	  
	  //変数easurementWeightに、測定時の体重を代入して下さい
	  double easurementWeight = 72.5;
	  
	  //変数ubmに平常時の体重に対する体重比を計算して代入して下さい
	  double ubm = (easurementWeight/weight)*100;
	  
	  //変数bmiに、BMIを計算して代入して下さい
      double bmi = weight/height/height;
      
      //変数standardWeightに標準体重を計算し代入します
      double standardWeight = (height*100)-110;
      
      //名前、年齢、身長、平常時の体重、ubm、bmi、標準体重に関する情報を出力して下さい。
      System.out.println("名前は"+name+"です");
      System.out.println("年齢は"+age+"歳です");
      System.out.println("身長は"+height+"mです");
      System.out.println("体重は"+weight+"kgです");
      System.out.println("標準体重は"+standardWeight+"kgです");
      System.out.println("BMIは"+bmi+"です");
      System.out.println("UBMは"+ubm+"%です");
      
  }
}

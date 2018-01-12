package main;

class Sample2 {
	public static void main(String[] args) {
      int[] numbers = {1,4,6,9,13,16,20,12,33,51,46,30,60,};
	
      int oddSum = 0;
      int evenSum = 0; 
      
      //for文を用いて、配列numbersの２の倍数３の倍数４の倍数を求める
      for(int number: numbers){
          if(number%2==0){
            evenSum = evenSum += number ;
          }else{
            oddSum = oddSum += number ;
          }
      }
    	    	
          System.out.println("奇数の和は" + oddSum + "です");
          System.out.println("偶数の和は" + evenSum + "です");
	}
}
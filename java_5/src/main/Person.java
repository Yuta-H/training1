package main;

public class Person {
  private String name;
  private String sex;
  private int age;
  private String job;
  
  Person(String name, String sex, int age, String job){
	  this.name = name;
	  this.sex = sex;
	  this.age = age;
	  this.job = job;
  }
  public void printData() {
	  System.out.println("名前；" + this.name + "　" + "性別；" + this.sex );
	  System.out.println("年齢；" + this.age );
	  System.out.println("職業；" + this.job);
  }
  public void buy(Animal animal) {
	  animal.setOwner(this);
  }
}

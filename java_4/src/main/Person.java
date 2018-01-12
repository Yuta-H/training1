package main;

public class Person {
 private static int count = 0;
 private String firstName;
 private String middleName;
 private String lastName;
 private String sex;
 private int age;
 private String job;
 
Person(String firstName, String lastName, String sex, int age, String job){
	
	Person.count++;
	
	this.firstName = firstName;
	this.middleName = middleName;
	this.lastName = lastName;
	this.sex = sex;
	this.age = age;
	this.job = job;
}

Person(String firstName, String middleName, String lastName, String sex, int age, String job) {
    this(firstName, lastName, sex, age, job);
    this.middleName = middleName;
  }

public String fullName() {
	if(this.middleName == null) {
		return this.firstName+" "+this.lastName;
}else{
	return this.firstName+" "+this.middleName+" "+this.lastName;
}
}
public void printData() {
	System.out.println("私の名前は"+this.fullName()+"です");
	System.out.println("年齢は"+this.age+"です");
	System.out.println("性別は"+this.sex+"です");
	System.out.println("仕事は"+this.job+"です");
}
public static void printCount() {
	System.out.println("合計"+Person.count+"人です");
}

public void setJob(String job) {
	// TODO Auto-generated method stub
	this.job = job;
}

public String getJob() {
	// TODO Auto-generated method stub
	return this.job;
}
public void setMiddleName(String middleName) {
	this.middleName = middleName;
}
}

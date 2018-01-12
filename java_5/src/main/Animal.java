package main;

abstract class Animal {
	private String name;
	private String type;
	private int appetite; // ０,　５０,　１００, で始める。
	private int distance; 
	private Person Owner;
	
	 Animal(String name, String type, int appetite, int distance){
		this.setName(name);
		this.setType(type);
		this.setAppetite(appetite);
		this.setDistance(distance);
	}

	 
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Person getOwner() {
		return Owner;
	}

	public void setOwner(Person owner) {
		Owner = owner;
	}
	public void printData() {
		System.out.println("名前；"+ this.name);
		System.out.println("種類；"+ this.type);
	}

	abstract public void run(int distance);

	public int getAppetite() {
		return appetite;
	}

	public void setAppetite(int appetite) {
		this.appetite = appetite;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}

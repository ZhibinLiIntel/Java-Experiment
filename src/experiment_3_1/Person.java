package experiment_3_1;

class Person{
	String name;
	char sex;
	int age;
	Person(String name,char sex,int age){
		this.name=name;
		this.sex=sex;
		this.age=age;
	}
	void setData(String name,char sex,int age){
		this.name=name;
		this.sex=sex;
		this.age=age;
	}
	String getData(){
		return "name:"+name+"\tsex:"+sex+"\tage:"+age;
	}
}
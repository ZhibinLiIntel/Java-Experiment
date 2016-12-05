package experiment_3_1;

class Student extends Person{
	int sID;
	int classNo;
	Student(String name,char sex,int age,int sID,int classNo){
		super(name,sex,age);
		this.sID=sID;
		this.classNo=classNo;
	}
	void setData(String name,char sex,int age,int sID,int classNo){
		setData(name,sex,age);
		this.sID=sID;
		this.classNo=classNo;
	}
	String getData(){
		return super.getData()+"\tsID:"+sID+"\tclassNo:"+classNo;
	}
}

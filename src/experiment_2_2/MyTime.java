package experiment_2_2;

public class MyTime {
	private int hour;
	private int minute;
	private int second;
	MyTime(int hour,int minute,int second){
		this.hour=hour;
		this.minute=minute;
		this.second=second;
	}
	void display(){
		System.out.printf("%02d"+":"+"%02d"+":"+"%02d",hour,minute,second);
	}
	void addHour(int hou){
		this.hour+=hou;
	}
	void addMinute(int min){
		this.minute+=min;
	}
	void addSecond(int sec){
		this.second+=sec;
	}
	void subHour(int hou){
		this.hour-=hou;
	}
	void subMinute(int min){
		this.minute-=min;
	}
	void subSecond(int sec){
		this.second-=sec;
	}
}

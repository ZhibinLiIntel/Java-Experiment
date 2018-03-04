class Point {
	int x,y;
	void setX(int i){
		x=i;
	}
	void setY(int j){
		y=j;
	}
	void getPoint(){
		 System.out.println("Point:("+x+","+y+")");
	}
	void movePoint(int i,int j){
		x=i;
		y=j;
	}
	Point(){
		x=0;
		y=0;
	}
}
public class TestPoint{
	public static void main(String args[]){
			Point point=new Point();
			System.out.println("Point:("+point.x+","+point.y+")");
			point.setX(3);
			point.setY(4);
			point.getPoint();
			point.movePoint(10,20);
			point.getPoint();
		}
}

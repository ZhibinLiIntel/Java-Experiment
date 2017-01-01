package experiment_2_3;

public class Triangle {
	int edge;
	Triangle(){
		
	}
	Triangle(int edge){
		this.edge=edge;
	}
	void setProperties(int edge){
		this.edge=edge;
	}
	void getProperties(){
		System.out.println("edge:"+edge);
	}
	void printGraphic(){
		for(int i=0;i<edge;i++){
			for(int j=0;j<=i;j++){
				System.out.print("*");
			}
			System.out.println("");
		}
	}
}

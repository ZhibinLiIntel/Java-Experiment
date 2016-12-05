package experiment_2_3;

public class Rectangle {
	int length;
	int width;
	boolean hollow;
	Rectangle(){
		
	}
	Rectangle(int length,int width,boolean hollow){
		this.length=length;
		this.width=width;
		this.hollow=hollow;
	}
	void setProperties(int length,int width,boolean hollow){
		this.length=length;
		this.width=width;
		this.hollow=hollow;
	}
	void getProperties(){
		System.out.println("length: "+length+" width: "+width+" hollow or not: "+hollow);
	}
	void printGraphic(){
		if(hollow==false){
			for(int i=0;i<width;i++){
				for(int j=0;j<length;j++){
					System.out.print("*");
				}
				System.out.println("");
			}
		}
		else
			for(int k=0;k<width;k++){
				for(int l=0;l<length;l++)
				{
					if(k==0||k==width-1)
						System.out.print("*");
					else{
						if(l==0||l==length-1)
							System.out.print("*");
						else
							System.out.print(" ");
					}	
				}
				System.out.println("");
			}		
	}
}


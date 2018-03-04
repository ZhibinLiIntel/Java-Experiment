
public class TestArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			int[] sim={4,2,5,7,1,9};
			int i,j;
			int tmp;
			for(i=1;i<sim.length;i++)
			{
				for(j=0;j<sim.length-i;j++)
				{
					if(sim[j]>sim[j+1])
					{
						tmp=sim[j];
						sim[j]=sim[j+1];
						sim[j+1]=tmp;
					}
				}
			}
			for(int k=0;k<sim.length;k++)
			{
				System.out.print("   "+sim[k]);
			}
	}

}

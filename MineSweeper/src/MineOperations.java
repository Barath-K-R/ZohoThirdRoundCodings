import java.util.ArrayList;
import java.util.Scanner;

public class MineOperations {
	
	Scanner sc=new Scanner(System.in);
	static int minesize;
	
	static Mine[][]mines;
	 ArrayList<Mine>mineslist=new ArrayList<Mine>();
	 static int visitedcount=0;
	 int noofmines;
	public void initialisemines() {
		String ralphabeth="A",calphabeth="A";
		System.out.println("choose the grid size");
		minesize=sc.nextInt();
		mines=new Mine[minesize][minesize];
		for(int i=0;i<minesize;++i)
		{
			for(int j=0;j<minesize;++j)
			{
				
				if(i==0 && j==0)
				{
					
					mines[i][j]=new Mine(i,j,false," ");
				}
				else if(i==0 || j==0) {
					if(i==0)
					{
						
					mines[i][j]=new Mine(i,j,false,ralphabeth);
					
					ralphabeth=String.valueOf((char)(ralphabeth.charAt(0)+1));
					}
					else if(j==0)
					{
						
						mines[i][j]=new Mine(i,j,false,calphabeth);
						calphabeth=String.valueOf((char)(calphabeth.charAt(0)+1));	
					}
				}
				else{
					
					mines[i][j]=new Mine(i,j,false,"");
				}
				
			}
			
		}
	}
	public void setmines() {
		System.out.println("enter the no of mines");
		noofmines=sc.nextInt();
		
		for(int i=0;i<noofmines;++i)
		{
			System.out.println("enter the places for implanting mines");
			int r=sc.nextInt(),c=sc.nextInt();
			mineslist.add(mines[r][c]);
			
			
		}
	}
	
	public void revealmines() {
		
		for(int i=0;i<minesize;++i)
		{
			for(int j=0;j<minesize;++j)
			{
				if(mineslist.contains(mines[i][j])) {
					System.out.print("X ");
				}
			    else if(i==0 && j==0)
					System.out.print("  ");
				else if(mines[i][j].enabled==false && mines[i][j].s=="")
					System.out.print("O ");
				else if(mines[i][j].enabled==true && mines[i][j].s==" ")
				{
					System.out.print("  ");
				}
				else
					System.out.print(mines[i][j].s+" ");
			}
			System.out.println();
		}
		
	}
	
	public int checkmine(int r,int c) {
		
		if(r<1 || c<1 || r>minesize-1 || c>minesize-1)
		{
			return 1;
		}
		if(mines[r][c].enabled==true) 
			return 1;
		
		int total=0;
		if(mineslist.contains(mines[r][c]))
		{
			System.out.println("reveal mines");
			this.revealmines();
			return 0;
		}
		else if(visitedcount==((minesize-1)*(minesize-1))-(noofmines+1))
		{
			System.out.println((minesize-1)*(minesize-1)-(noofmines+1));
			System.out.println("Your chance gets over");
			this.revealmines();
			return 0;
		}
		System.out.println("checking starts");
		System.out.println("r and c="+r+" "+c);
		
		total=total+countmine(r-1,c-1);
		total=total+countmine(r-1,c);
		total=total+countmine(r-1,c+1);
		total=total+countmine(r,c+1);
		total=total+countmine(r+1,c+1);
		total=total+countmine(r+1,c);
		total=total+countmine(r+1,c-1);
		total=total+countmine(r,c-1);
		
		System.out.println("total="+total);
		if(total>0 )
		{
		      mines[r][c].s=Integer.toString(total);
		      mines[r][c].enabled=true;
		      visitedcount++;
		}
		else if(total==0)
		{
			mines[r][c].s=" ";
			mines[r][c].enabled=true;
			visitedcount++;
			checkmine(r-1,c-1);
			checkmine(r-1,c);
			checkmine(r-1,c+1);
			checkmine(r,c+1);
			checkmine(r+1,c+1);
			checkmine(r+1,c);
			checkmine(r+1,c-1);
			checkmine(r,c-1);
			
		}
		
		return 1;
		
	}
	
	public int countmine(int r,int c) {
		System.out.println("counting starts");
		if(r<1 || c<1 || r>minesize-1 || c>minesize-1)
			return 0;
		if(mineslist.contains(mines[r][c]))
			return 1;
		else
			return 0;
	}
	
	public void displaymines() {
		for(int i=0;i<minesize;++i)
		{
			for(int j=0;j<minesize;++j)
			{
				
				if(i==0 && j==0)
					System.out.print("  ");
				else if(mines[i][j].enabled==false && mines[i][j].s=="")
					System.out.print("O ");
				else if(mines[i][j].enabled==true && mines[i][j].s==" ")
				{
					System.out.print("  ");
				}
				else
					System.out.print(mines[i][j].s+" ");
			}
			System.out.println();
		}
	}
	

}

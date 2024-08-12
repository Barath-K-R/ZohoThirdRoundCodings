import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the expression");
		String expression=sc.nextLine();
		String[]s=expression.split("\\*",2);
		AlgebraicExpressions.stringoperation(s);
		
	}

	

}

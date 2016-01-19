import java.util.*;

public class CodeBreaker{
	public static int score = 0;
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();
		boolean winning = false;
		int maxTries = 12;
		int numRange = 9;
		String input = "";
		int countx = 0;
		int counto = 0;
		
		//FOUR random numbers range from 1-numRange.
		int n1 = rand.nextInt(numRange)+1;
		int n2 = rand.nextInt(numRange)+1;
		int n3 = rand.nextInt(numRange)+1;
		int n4 = rand.nextInt(numRange)+1;
		int[] master = {n1,n2,n3,n4};
		boolean x1=false,x2=false,x3=false,x4=false;
		
		System.out.println("\nWelcome to CodeBreaker!!\n\nEnter the 4-digit code now:\n");
		for(int i=0;i<maxTries;i++){
			//Keep asking until input length is 4.
			input = "";
			while(input.length() != master.length){
				System.out.print("\r            \r");
				input = sc.nextLine();
			}
			//Create strguesses[], fill with 4-digit input.
			String[] strguesses = new String[input.length()];
			for(int j=0;j<strguesses.length;j++){
				strguesses[j] = input.substring(j,j+1);
			}
			int[] guesses = new int[input.length()];
			for(int j=0;j<guesses.length;j++){
				guesses[j] = Integer.parseInt(strguesses[j]);
			}
			
			//Count up your X's and O's.
			//This code needs to be modified to follow original game rules.
			if(guesses[0]==n1){countx++;x1=true;}
			if(guesses[1]==n2){countx++;x2=true;}
			if(guesses[2]==n3){countx++;x3=true;}
			if(guesses[3]==n4){countx++;x4=true;}
			
			for(int j=0;j<guesses.length;j++){
				for(int k=0;k<master.length;k++){
					if(guesses[j]==master[k] && j!=k){
						if(k==0 && x1==false){counto++;x1=true;}
						if(k==1 && x2==false){counto++;x2=true;}
						if(k==2 && x3==false){counto++;x3=true;}
						if(k==3 && x4==false){counto++;x4=true;}
					}
				}
			}
			
			x1=false;x2=false;x3=false;x4=false;
			
			//Winning Condition.
			if(countx==4){winning=true;score=i+1;}
			if(winning){WinningAnimation(master);}
			
			for(int x=0;x<countx;x++){
				System.out.print("+");
			}
			for(int o=0;o<counto;o++){
				System.out.print("-");
			}
			int hintlen = countx+counto;
			for(int j=0;j<6-hintlen;j++){
				System.out.print(" ");
			}
			if(i!=maxTries-2){System.out.println((maxTries-i-1)+" tries left.");}
			else{System.out.println("Last try!");}
			countx=0; counto=0;
		}
		
		System.out.println("You lose. The code was "+n1+" "+n2+" "+n3+" "+n4);
		sc.nextLine();
		System.exit(0);
	}
	public static void WinningAnimation(int[] arr){
		if(score==1){System.out.println("WOW lucky! You cracked the code on your first try!!!");}
		else{
			System.out.println("\nCongratulations!\n");
			System.out.println(arr[0]+" "+arr[1]+" "+arr[2]+" "+arr[3]);
			System.out.println("\nYou cracked the code in "+score+" tries!!!");
		}
		System.exit(0);
	}

}









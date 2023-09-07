import java.util.Scanner;
public class Grade 
{
	

//public static void main(String[] args) {
	
//	Scanner s= new Scanner(System.in);
// 	System.out.println("Enter no. of sub");
//	
//	float n, sum=0,percentage, average;
//	n=s.nextInt();
//	
//	float marks[]= new float [8];
//	System.out.println("Enter marks out of 100");
//	for(int i=0;i<n;i++) {
//	
//		marks[i]=s.nextFloat();
//		sum=sum+marks[i];
//		average=sum/8;
//		percentage=(sum / (n*100))*100;
//		
//		//System.out.println("Grade =");
//		//percentage=total/n;
////		if(average>=94) {
////			System.out.println("Grade A");
////		}
////		else if(average>=87 && average<90) {
////			System.out.println( " Grade B");
////		}
////	}
//	//percentage=total/n;
//	}
//	System.out.println("Total marks "+sum);
//	System.out.println("percentage "+percentage);
//}
	
	
	 public static void main(String[] args)
	 {
		 Scanner s = new Scanner(System.in);
		 System.out.println("Enter the subjects marks:");
		 int m1 = s.nextInt();
		 int m2 = s.nextInt();
		 int m3 = s.nextInt();
		 
		 
		 int tot = m1+m2+m3;
		 float per = tot/2;
		 
		 System.out.println("Total :"+tot);
		 System.out.println("Percentage :"+per);
		 
		 
		 if(per>=90)
			 System.out.println("Grade A");
		 else if(per>=80 && per<=90)
			 System.out.println("Grade B");
		 else if(per>=70 && per<=80)
             System.out.println("Grade c");
		 else if(per>=60 && per<=70)
			 System.out.println("Grade D");
		 else if(per>=40)
			 System.out.println("Grade E");
		 else
			 System.out.println("Grade F");
		 
	}
}
	
		





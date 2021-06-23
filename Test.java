package time;
import time.TimeToSeconds;
import java.util.Scanner;
class Test{
  public static void main(String []abc){
    Scanner S= new Scanner (System.in);
    int n= S.nextInt();
    String [] A= new String[n];
    for(int i=0;i<n;i++) A[i]= S.next();
    new TimeToSeconds().mintime(n,A);
  }
}
package time;
class TimeToSeconds{
  void mintime(int n, String [] A){
    TimeToSeconds [] tts =new TimeToSeconds[n];
    for (int i=0;i<n;i++) tts[i]= new TimeToSeconds();
    int [] sec= new int[n];
    for (int i=0;i<n;i++){
      sec[i]= tts[i].seconds(A[i]);
    }
    for (int i=0;i<n-1;i++){
      int min=sec[i], index=i;
      for (int j=i+1;j<n;j++){
        if (sec[j]<min){ 
          min=sec[j];
          index=j;
        }
      }
      sec[index]=sec[i];
      sec[i]=min;
    }
    int min=sec[n-1]-sec[n-2];
    for (int i=n-2;i-1>=0;i--){
      if (sec[i]-sec[i-1]<min) min=sec[i]-sec[i-1];
    }
    int seco= min%60;
    int minu= (min/60)%60;
    int hr=(min/3600)%60;
    System.out.println(hr+":"+minu+":"+seco);
  }
  int append(char[]A, int i,int n, int sc){
    if (i+1<A.length && A[i+1]==':') n= (((int)A[i]-48)*sc)+n;
    if (i==A.length-1) n= (((int)A[i]-48)*sc)+n;
    else if(i+1<A.length &&(A[i+1]!=':' || i+2==A.length)) n= (((int)A[i]-48)*sc*10)+n;
    return n;
  }
  int seconds(String t){
    char[]A=t.toCharArray();
    int len=A.length;
    int n=0 , sc=3600;
    for (int i=0;i<len;i++){
      if (A[i]!=':') n=append(A,i,n,sc);
      else n=append(A,++i,n,sc/=60);
    }
    return n;
  }
}
import java.util.Scanner;
class classfull{
     String ipaddress;
Scanner sc=new Scanner(System.in);
 int firstOctet,secondOctet,thirdOctet,fourthOctet;
public void takeIP(){
         
         
         System.out.println("Enter firstOctet value:");
         firstOctet=sc.nextInt();
          System.out.println("Enter secondOctet value:");
          secondOctet=sc.nextInt();
          System.out.println("Enter thirdOctet value:");
         thirdOctet=sc.nextInt();
          System.out.println("Enter fourthOctet value:");
         fourthOctet=sc.nextInt();
           System.out.println("Ip Address in dotted decimal form is :"+firstOctet+"."+secondOctet+"."+thirdOctet+"."+fourthOctet);
}
String getClass1(){
     if(firstOctet>=0 && firstOctet<=127){
        return "Class A";
     }
     else if(firstOctet>=128 && firstOctet<=191){
        return "Class B";
     }
      else if(firstOctet>=192 && firstOctet<=223){
         return "Class C";
      }
      else if(firstOctet>=224 && firstOctet<=239){
         return "Class D";
      }
      else{
           return "Invalid";
      }
}
void findNet(){
      if(firstOctet>=0 && firstOctet<=127){
        System.out.println("Default mask is:"+"255.0.0.0");
        System.out.println("Net ID is:"+firstOctet+".0.0.0");
      }
        if(firstOctet>=128 && firstOctet<=191){
        System.out.println("Default mask is:"+"255.255.0.0");
        System.out.println("Net ID is:"+firstOctet+"."+secondOctet+".0.0");
      }
       if(firstOctet>=192 && firstOctet<=223){
        System.out.println("Default mask is:"+"255.255.255.0");
        System.out.println("Net ID is:"+firstOctet+"."+secondOctet+"."+thirdOctet+".0");
      }
       if(firstOctet>=224 && firstOctet<=239){
        System.out.println("Default mask is:"+"255.255.255.255");
        System.out.println("Net ID is:"+firstOctet+"."+secondOctet+"."+thirdOctet+"."+fourthOctet);
      }
}
void findHost()
{
    if(firstOctet>=0 && firstOctet<=127){
     System.out.println("Host ID is:"+secondOctet+"."+thirdOctet+"."+fourthOctet);
    }
    if(firstOctet>=128 && firstOctet<=191){
      System.out.println("Host ID is:"+thirdOctet+"."+fourthOctet);
    }
    if(firstOctet>=192 && firstOctet<=223){
       System.out.println("Host ID is:"+fourthOctet);
    }
  }
}
class IPAD{
    public static void main(String ars[]){
classfull ob = new classfull();
    ob.takeIP();
    String s=ob.getClass1();
    System.out.println(s);
    ob.findNet();
    ob.findHost();
    }
}

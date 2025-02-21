import java.net.Socket;
import java.util.ArrayList;

public class App {
    
    public static void main(String args[]){
    List list = new List();
 
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);
    list.add(5);
    list.add(6);
    list.add(7);
    list.add(8);
    list.add(9);


    

    ArrayList<Integer> arrayList = new ArrayList<Integer>();
    arrayList.add(1);
    arrayList.add(8);
    arrayList.add(4);


    for (Object object : list) {
      System.out.println(object);
    }
    System.out.println(list.containsAll(arrayList));

    System.out.println(list.toArray());
    System.out.println(list.size());
    System.out.println(list.get(0));
    System.out.println(list.get(8));
    System.out.println(list.get(5));
    System.out.println(list.get(-1));


  }   
}
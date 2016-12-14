//Linh Ly
//CSE 142
//study final part one 

import java.util.*;

public class testing{
    public static void main(String[] args) {        
        //problem 1
        String[] res = {"to", "be", "or", "not", "to", "be", "hamlet"};
        ArrayList<String> list2 = add(res);
        swapPairs(list2);
        
        //problem 2
        String[] list = {"Did", "you", "solve", "it", "or", "what?"};
        ArrayList<String> list3 = add(list); 
        removeEvenLength(list3);
        
        //problem 3
        String[] list1 = {"how", "are", "you?"};
        ArrayList<String> list4 = add(list1); 
        doubleList(list4);
        
        //problem 4
        String[] listA = {"be", "be", "is", "not", "or", "question", "that", "the", "to", "to"};
        ArrayList<String> list5 = add(listA); 
        removeDuplicates(list5);       
    }
    
    //before:                                                                 after: 
    //{"be", "be", "is", "not", "or", "question", "that", "the", "to", "to"}  [be, is, not, or, question, that, the, to]
    public static void removeDuplicates(ArrayList<String> list){
      int size = list.size(); 
      for(int i = 0; i < size; i++){
         for(int j = size - 1; j >= 0; j--){
            if(i != j){
               if(list.get(i).equals(list.get(j))){
                  list.remove(i);
                  size--; 
               }
            }
         }
      }
      System.out.println("remove duplicates (after): " + list); 
    }
    
//before:                                          after: 
//["how", "are", "you?"]                           [how, how, are, are, you?, you?]
//["I", "am", "great,", "thanks!"]                 [I, I, am, am, great,, great,, thanks!, thanks!]
   public static void doubleList(ArrayList<String> list){
       int size = list.size(); 
       for(int i = 0; i < size; i++){
           list.add(i, list.get(i)); 
           size++;
           i += 1;
       }
       System.out.println("3. double list (after) : " + list);
       System.out.println(); 
   }
   
//before:  {"Did", "you", "solve", "it", "or", "what?"}
//after:   [Did, you, solve, what?] 
   public static void removeEvenLength(ArrayList<String> list){
       int size = list.size();
       for(int i = 0; i < size; i++){
           if(list.get(i).length() % 2 == 0){
               list.remove(i); 
               size--;
               i--;
           }
       }
       System.out.println("2. remove even length (after) : " +  list);
       System.out.println();
   } 
      
// before:      [to, be, or, not, to, be, hamlet]
// after:       [be, to, not, or, be, to, hamlet]
    public static void swapPairs(ArrayList<String> list){
        int length = list.size();
        for(int i = 0; i < length - 1; i+= 2){
            String temp = list.get(i);
            list.remove(i);
            list.add(i + 1, temp);
        }
        System.out.println("1. swap pairs (after): " + list);
        System.out.println();
    }
    
    //adding element to arraylist without going through single add method. 
    public static ArrayList<String> add(String[] s){
        ArrayList<String> s1 = new ArrayList<String>();
        for(int i = 0; i < s.length; i++){
            s1.add(s[i]);
            
        }
        System.out.println("before: " + s1);
        return s1;
    }
}

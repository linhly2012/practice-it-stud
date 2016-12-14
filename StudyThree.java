//Linh Ly
//CSE 142
//study for final part 3 - practice it

import java.util.*; 
import java.io.*; 

public class StudyThree{
   public static void main(String[] args) throws FileNotFoundException{
      //problem #1
      Scanner input = new Scanner(new File("WordStats.txt"));
      flipLines(input);
      
      //problem #2
      int[] array = {1, 3, 6, 7, 12};
      minGap(array);   
      int[] a1 = {2, 4, 6};
      minGap(a1);  
      System.out.println();
                
      //problem #3 
      int[] a4 = {3, 8, 92, 4, 2, 17, 9};
      ArrayList<Integer>a = add(a4);
      minToFront(a);
      int[] a5 = {6, 1, 4, -2};
      ArrayList<Integer>a2 = add(a5);
      minToFront(a2); 
      
      
      //problem #4
      acronym("      automatic teller machine      ");
      acronym("personal indetification number");  
      acronym("merry-go-round");
      acronym("--quite-- confusing - punctuation-");  
      acronym("    loner    ");  
  

   } 

//4. before                                                 after
//       automatic teller machine                           ATM
// personal indetification number                           PIN
// merry-go-round                                           MGR
// --quite-- confusing - punctuation-                       QCP
//      loner                                               L                                   
   public static void acronym(String s){
      String result = ""; 
      System.out.println("Acronym (before): " + s);
      String temp = "";
      for(int i = 0; i < s.length(); i++){
         if(s.charAt(i) == '-'){
            temp = temp + " "; 
         }
         else{
           temp = temp + s.charAt(i); 
         }
      }
      
      Scanner text = new Scanner(temp); 
      while(text.hasNext()){
         String search = text.next(); 
         result = result + search.charAt(0);
      }
      System.out.println("Acronym (after): " + result.toUpperCase());
      System.out.println(); 
   }
   //3. before                                        after
   //[3, 8, 92, 4, 2, 17, 9]                       [2, 3, 8, 92, 4, 17, 9]
   //[6, 1, 4, -2]                                 [6, 1, 4, -2]
   public static void minToFront(ArrayList<Integer> list){
      int min = list.get(0); 
      for(int i = 0; i < list.size(); i++){
         for(int j = list.size() - 1; j >= 0; j--){
            if(list.get(i) > list.get(j)){
               list.add(i, list.get(j));
               j++;
               list.remove(j);
               j--;
            }
         }
         break;
      }
      System.out.println("min to front : (after)" + list); 
   }
   
   //2. before                                              After
//    Twas brillig and the slithy toves                  did gyre and gimble in the wabe.
//    did gyre and gimble in the wabe.                   Twas brillig and the slithy toves 
//    All mimsey were the borogroves,                    and the mome raths outgrabe.
//    and the mome raths outgrabe.                       All mimsey were the borogroves, 
//                                                       "Beware the Jabberwock, my son,
//    "Beware the Jabberwock, my son,
//    the jaws that bite, the claws that catch,          Beware the JubJub bird and shun
//    Beware the JubJub bird and shun                    the jaws that bite, the claws that catch, 
//    the frumious bandersnatch."                        the frumious bandersnatch."  
   public static void flipLines(Scanner input){
      String first = ""; 
      String second = ""; 
      while(input.hasNextLine()){
         first = input.nextLine(); 
         if(!input.hasNextLine()){
            System.out.println(first);
            break; 
         }
         second = input.nextLine(); 
         System.out.println(second);          
         System.out.println(first);
      }
      System.out.println();
   }
   
//.    int[] array = {1, 3, 6, 7, 12};
//    The first gap is 2 (3 - 1), the second gap is 3 (6 - 3), the third gap is 1 (7 - 6) and the fourth gap is 5 (12 - 7). 
//    Thus, the call of minGap(array) should return 1 because that is the smallest gap in the array. 
//    Notice that the minimum gap could be a negative number. 
//    For example, if array stores the following sequence of values:{3, 5, 11, 4, 8}
//    The gaps would be computed as 2 (5 - 3), 6 (11 - 5), -7 (4 - 11), and 4 (8 - 4). 
//    Of these values, -7 is the smallest, so it would be returned.
//    This gap information can be helpful for determining other properties of the array. 
//    For example, if the minimum gap is greater than or equal to 0, then you know the array is in sorted (nondecreasing) order. 
//    If the gap is greater than 0, then you know the array is both sorted and unique (strictly increasing).
//    If you are passed an array with fewer than 2 elements, you should return 0.
   
   public static int minGap(int[] array){
       if(array.length < 3){
            System.out.println("testing : " + Arrays.toString(array) +  " : " + 0); 
           return 0; 
       }
       else{
           int minGap = array[0];
           for(int i = 0; i < array.length - 1; i++){
                   array[i] = array[i + 1] - array[i];
                   int temp = array[i]; 
                   minGap = Math.min(minGap, temp);
           }
           System.out.println("testing : " + Arrays.toString(array) +  " : " + minGap); 
           return minGap;
       }
    }
    
    //adding a list of number to the arrayList
    public static ArrayList<Integer> add(int[] array){
      ArrayList<Integer> list = new ArrayList<Integer>();
      for(int i = 0; i < array.length; i++){
         list.add(array[i]);
      }
      return list; 
    }
}
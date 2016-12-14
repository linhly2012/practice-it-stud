//Linh Ly
//CSE 142
// study final part two 

import java.util.*; 
import java.io.*;

public class StudyTwo{
   public static void main(String[] args) throws FileNotFoundException{
      Scanner input = new Scanner(new File("MostUnique.txt"));
      mostUnique(input);
      
      int[] a = {2, 1};
      int[] a0 = {2, 1, 2, 1, 2, 1};     
      repeatedSequence(a, a0); 
      
   }

   //file take in                                  result --- return 6   
   // 10 10 10  9 9   8    3                       Period 1: 4 unique scores
   // 3 3 8 10 9 7   7 6 6                         Period 2: 6 unique scores
   // 4  1 9  9 10  7 7                            Period 3: 5 unique scores
   // 10  10   10 10                               Period 4: 1 unique scores 
   public static int mostUnique(Scanner input){
      int max = 0; 
      int lineC = 0; 
      while(input.hasNextLine()){
         lineC++;
         System.out.print("Period " + lineC + ": "); 
         String line = input.nextLine();
         int count = 1;  
         Scanner read = new Scanner(line); 
         int temp = read.nextInt(); 
         while(read.hasNextInt()){
            int number = read.nextInt();
            if(number != temp){
               count++;
               temp = number;
            }
         }
         System.out.print(count + " unique scores");
         System.out.println();
         max = Math.max(max, count);
      }
      return max; 
   }

//    example:
//    1) int[] a1 = {2, 1}; int[] a2 = {2, 1, 2, 1, 2, 1};  
//    2) repeatedSequence({2, 7}, {2, 1, 4, 3, 5, 8, 1, 9})     
//    result: 
//    1) return true ; 2) false
   public static boolean repeatedSequence(int[] a1, int[] a2){
      boolean right = true; 
     for(int i = 0; i < a2.length; i++){
        int temp = a2[i]; 
        for(int j = 0; j < a1.length; j++){
           int temp1 = a1[j];
           if(temp != temp1){
              right = false;
           }
            else{
                right = true;
            }
        }
     } 
      return right;
   }
}

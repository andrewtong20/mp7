/*
Andrew Tong
Mr. Ritter
May 19, 2019
MP7

This program will read up to 20 integers from mp7.txt to an array. 
Then, it will call a method to find and return the index of the largest/smallest values and print them.
It will call a method to sum all of the numbers and print out the sum and average of these numbers in the main.
*/
package mp7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Mp7 
{

    public static void main(String[] args) throws FileNotFoundException
    {
       File inFile=new File("mp7.txt");
       Scanner out=new Scanner(inFile);
       
       Scanner in= new Scanner(System.in);
       System.out.println("You are entering a program that will find the index of and print the largest and smallest values in an integer array. It will also print out the sum and average of the numbers. ");
       System.out.println("Please enter up to 20 integers in mp7.txt, with each integer on a separate line to be into an array.");
       
       
       int[] ints=new int[20];//create array of size 20

       int currentSize=0;//initialize the currentSize of the array
       
       
       while(out.hasNextInt()&&currentSize<ints.length)//currentSize has to be less than the max length of the array
        {
            ints[currentSize]=out.nextInt();//reads in from the txt file scanner
            currentSize++;//adds size by 1 each time
        }
        
        System.out.println("What is your name?");
        String user=in.nextLine();
        System.out.println("Hi, "+user+"!");//user experience
        
        System.out.println("The maximum integer in the text file is: "+ ints[largestValue(ints, currentSize)]+" at index "+largestValue(ints, currentSize));//used index to print the max string as per instructions
        System.out.println("The minimum integer in the text file is: "+ ints[smallestValue(ints, currentSize)]+" at index "+smallestValue(ints, currentSize));//used index to print the max string as per instructions
        System.out.println("The sum is: "+sumValue(ints));//i did not printf because only integers in array. Integer sum will always remain an integer.
        System.out.printf("The average (rounded to 3 decimal places) is: %.3f \n",sumValue(ints)/currentSize);//averages will not be perfectly divided, so rounding for viewing pleasure
                                                                                                              //is double divided by double so will return a double, will not cut off like integer division
        
        System.out.println("Thank you, "+user+", for using this program.");
        out.close();//Need to close the scanner to stop the input of extra values from the mp7.txt
       
    }
    
    public static int largestValue(int[] ints, int currentSize)
    {
        
        int index=0;//initialize the index of each integer in array
        
        for (int i=0; i<currentSize; i++)//starts at 0 because index starts at 0 in array
        {
            if (ints[index]<ints[i])//to find maximum
            {
                index=i;
            }
            
        }
        
        return index;//need to return index, not actual value
    }
    
    public static int smallestValue(int[] ints, int currentSize)
    {
        int index=0;//initialize the index of each integer in array
        
        
        for (int i=0; i<currentSize; i++)//starts at 0 because index starts at 0 in array
        {
            if (ints[index]>ints[i])//to find minimum
            {
                index=i;
            }
            
        }
        
        return index;//need to return index, not actual value
    }
    
    public static double sumValue(int[] ints)//sum is double so the average division will work
    {
        double total=0;//initialize total needed
        for (double element: ints)//enhanced for loop to shorten the code for adding up all the integers in the array
        {
            total+=element;
        }
        
        return total;
    }
   
}


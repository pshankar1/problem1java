import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
public class Main<T extends Comparable<? super T>> {
  public static void main(String[] args)
    {

/*****

To be honest I could only inaccurately attempt the isEmpty method because I couldnt successfully
apply these array methods to a generic array.
I tried my best on this one. 

runtime and algorithmic approximation: 2*O(n)+6

*******/
        Integer[] arrayA = {6,5,3,7,2};

/*****
isEmpty lol..
The if statment below is supposed to check through and see if the array is empty
I know i didnt use isEmpty() method but i struggled using it with generic arrays
*******/
        System.out.println();


        System.out.print("Array is empty:");
        if(arrayA.length==0||arrayA==null){//1
          System.out.println("  true");
        }else{
          System.out.println("  false");
        }
  

        System.out.println();

 /*****
starts off the generic array by setting each value of the array 

into a generic array 

and prints out the Heap Sorting array
*******/       
        Main<Integer> values   = new Main<>();
        values.sortedHeap(arrayA);//1
        System.out.print("Sorted Array: ");
        System.out.println(java.util.Arrays.toString(arrayA));
    }

/*****
Beginning of heap sort method that basically is responsible
for sorting the array, i used .length but i didnt know how 
else to do this 

this will be responsible for setting each value into the "holder variable "
*******/
    
  void sortedHeap(T[] sortA)
    {
        int lenVal = sortA.length;//1





/*****
the for loop below 
 is responsible for starting off the heap sort

*******/
        for (int i = lenVal / 2 - 1; i >= 0; i--)//O(n)+1
           sortedHeap(sortA, lenVal, i);




/*****

This for loop below will take each value form the sort one at a time

*******/           

        for (int i = lenVal - 1; i >= 0; i--)//o(n)+1
        {
            // move current root to end
            T holder = sortA[0];//1
             sortA[0] = sortA[i];//1
             sortA[i] = holder;//1



/*****
this will call the sortedHeap method 
will bring values to designated spots 
that can be set in order

*******/

            sortedHeap(sortA, i, 0);
        }
    }



/*****

This method is the most important part of the heapsort really
it assigns the val variable (represents each value of arrayA), arrayLen(represents length of arrayA),
i (as a filler variable to assign the highest(biggest)
value to an integer)

*******/
    void sortedHeap(T[] val, int arrayLen, int i)
    {
        int highestVal = i; 
        int firstHalf  = 2 * i + 1;//2
        int secondHalf = 2 * i + 2;//2

/*****
The below if statment means:
if the first half value is bigger than the original first value it switches it

*******/
        if (firstHalf < arrayLen && val[firstHalf].compareTo(val[highestVal]) > 0)//1
           highestVal= firstHalf;



/*****
The below if statement means:
if the second half value is bigger than the fist half it switches it by comapring it 
t0 the highestVal 
*******/

        if (secondHalf < arrayLen && val[secondHalf].compareTo(val[highestVal]) > 0)//2
           highestVal= secondHalf;


/*****

The below if statment is responsible 
for sorting it from smallest to biggest and stores it in 'filler'value
that it is assigned to and once again compares it to the highest value
and then calls itself

*******/

        if (highestVal != i)//1
        {

            T filler = val[i];//1
            val[i] = val[highestVal];//1
            val[highestVal] = filler;//1



           sortedHeap(val, arrayLen, highestVal);//1
        }
      
        
    }

  
 

  /* ATTEMPT AT FILTER WITH GENERICS 
  <T> List<T> sortedHeap(Class<T> arrayA){
    if(filters.arrayA <=0){
      return false;
    }

    return list.stream();
    .filter(arrayA::isInstance)
    .map(arrayA::cast)
    .collect(toList());
  }
  */
    
}
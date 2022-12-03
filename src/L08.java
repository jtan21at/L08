import java.lang.reflect.Array;
import java.util.Arrays;
public class L08 {
    public static void main(String[] args) {
        // TO DO:
        // Test your radix sort implementation here
        String[] arr = generateStringArray(3, 8);
        displayStringArray(arr);
/*dta
kcn
wqg
hdk
zxu
yyx
znv
dhu
*/

        System.out.println();
//        System.out.println(Arrays.toString(radixSort(arr)));
//        radixSort(arr);
     //   displayStringArray(arr);
        String[] result_arr= radixSort(arr);
      displayStringArray(result_arr);
 /*
zxu
znv
yyx
wqg
kcn
hdk
dta
dhu*/
        System.out.println("\nSorted In Nondescending Order:");

    System.out.println(isSortedInNondescendingOrder(result_arr)?"Right, it is sorted in non-descending order":"No, it is sorted in decending order");

    }

    // TO DO:
    // Implement
    // NOTE: You can assume that all strings in the array have the same length
    public static String[] radixSort(String[] arr) {


        //ascii码的取值范围
        final int range_asc = 128;



             int maxLen = 0;
        for (String item : arr) {
            if (item.length() > maxLen) {
                maxLen = item.length();
            }
        }

            String[] sortArr = new String[arr.length];

            //for low to high
            for (int k = maxLen - 1; k >= 0; k--) {
                int[] cntArr = new int[range_asc];
                for (String value : arr) {
                    int index = getIndex(value, k);
                    cntArr[index]++;
                }
                int sum = 0;
                for (int i = 0; i < cntArr.length; i++) {

                    sum += cntArr[i];cntArr[i] = sum;



                }

                for (String s : arr) {
                    int index = getIndex(s, k);


                    sortArr[arr.length - cntArr[index]] = s;
                    cntArr[index]--;
                }

                arr = sortArr.clone();

            }
          return arr;
        }
        //get char ascii num
        private static int getIndex (String str,int k){
            //put
            if (str.length() < k + 1) {
                return 0;
            }
            return str.charAt(k);
        }


        //////* HELPER METHODS *//////
         static String[] generateStringArray ( int wordLen, int arrLen){
            String[] array = new String[arrLen];

            for (int i = 0; i < arrLen; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < wordLen; j++) {
                    sb.append((char) ('a' + Math.random() * ('z' - 'a' + 1)));
                }
                array[i] = sb.toString();
            }

            return array;
        }

         static void displayStringArray (String[] array){

        for (String s : array) {
                System.out.println(s);
            }
        }

        private static boolean isSortedInNondescendingOrder (String[]array){
            for (int i = 1; i < array.length; i++) {
                if (array[i].compareTo(array[i - 1]) < 0) {
                    return false;
                }
            }
            return true;
        }
    }

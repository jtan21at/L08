import java.util.Arrays;
public class L08 {
    public static void main(String[] args) {
        // TO DO:
        // Test your radix sort implementation here
        String[] arr = generateStringArray(3, 8);
        displayStringArray(arr);
        radixSort(arr);
        System.out.println();
        displayStringArray(arr);


    }

    // TO DO:
    // Implement
    // NOTE: You can assume that all strings in the array have the same length
    public static void radixSort(String[] arr) {


        //ascii码的取值范围
        final int range_asc = 128;



             int maxLen = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i].length() > maxLen) {
                    maxLen = arr[i].length();
                }
            }

            String[] sortArr = new String[arr.length];

            //for low to high
            for (int k = maxLen - 1; k >= 0; k--) {
                int[] cntArr = new int[range_asc];
                for (int i = 0; i < arr.length; i++) {
                    int index = getIndex(arr[i], k);
                    cntArr[index]++;
                }
                int sum = 0;
                for (int i = 0; i < cntArr.length; i++) {
                    sum += cntArr[i];
                    cntArr[i] = sum;
                }

                for (int i = arr.length - 1; i >= 0; i--) {
                    int index = getIndex(arr[i], k);
                    sortArr[cntArr[index] - 1] = arr[i];
                    cntArr[index]--;
                }

                arr = sortArr.clone();
            }
         //   return arr;
        }
        //获取字符串第k位字符所对应的ascii码序号
        private static int getIndex (String str,int k){
            //put
            if (str.length() < k + 1) {
                return 0;
            }
            return str.charAt(k);
        }


        //////* HELPER METHODS *//////
        private static String[] generateStringArray ( int wordLen, int arrLen){
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

        private static void displayStringArray (String[]array){

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

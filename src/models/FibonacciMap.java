package models;
import myExceptions.VariableEnterException;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class FibonacciMap {
        private long range []={0,1};
        private SortedMap<Integer, Long> fibMap;
        private String userEnter;

        long fib1; //F[n-2]
        long fib2; //F[n-1]
        long fibLast;// F[n]
        int n;// series Number of fib number

        public FibonacciMap(){
            fibMap = new TreeMap<>();
        }

        public void setRange(String userEnter) throws VariableEnterException {
            String userString[]=userEnter.split("-");
            if(userString.length>2){
                throw new VariableEnterException("Should enter in format <Digits> or <range start><-><range end>");
            }
            if (userString.length == 2) {
                try {
                    range[0] = Long.parseLong(userString[0]);
                    range[1] = Long.parseLong(userString[1]);
                }catch (NumberFormatException ne){
                    throw new VariableEnterException(" is not a long number!", userEnter);
                }
                    if (range[1] < range[0]) {
                        long tmp = range[1];
                        range[1] = range[0];
                        range[0] = tmp;
                    }
            }
            if (userString.length == 1) {
                long length=0;
                try {
                    length = Long.parseLong(userString[0]);
                }catch (NumberFormatException ne){
                    throw new VariableEnterException(" is not a long number!", userEnter);
                }
                if(length<=0){
                    throw new VariableEnterException(" Must be > 0!", userEnter);
                }
                range[0] = (long) Math.pow(10, length - 1);
                range[1] = (long) Math.pow(10, length) - 1;
                if (range[0] == 1) {
                    range[0] = 0;
                }
            }
        }

        public SortedMap<Integer, Long> calcFibonacci() {
            if(fibMap.containsValue(range[0]) && fibMap.containsValue(range[1])){ //in case repeated method invoke
                return fibMap;
            }
            // when calcFibonacci invoked for the first time
            if(fibMap.isEmpty()) {
                if (range[0] == 0) {
                    fibMap.put(1, 0L);
                    fibMap.put(2, 1L);
                }
                if (range[0] == 1) {
                    fibMap.put(2, 1L);
                }
                fib1 = 0; //F[n-2]
                fib2 = 1; //F[n-1]
                fibLast = 1;// F[n]
                n = 2;
            }

            // in repeated calcFibonacci invoke
            if(fibMap.isEmpty()==false && fibMap.lastKey()>2){

                    fib1 = fibMap.get(fibMap.lastKey() - 1); //F[n-2]
                    fib2 = fibMap.get(fibMap.lastKey()); //F[n-1] last in the previous cals
                    //  fibLast - F[n] - to be calculated in this calc
                    n = fibMap.lastKey(); //Start count from the previous last

            }
            //The same for the first and repeated invoke
            while (fibLast <= range[1]) {
                n++;
                fibLast = fib1 + fib2;
                fib1 = fib2;
                fib2 = fibLast;
                if(fibLast<=range[1]){
                    fibMap.put(n, fibLast);
                }


            }
            return fibMap;
        }

        //Method invoked from Main
        public void printFibonacci(String userEnter) throws VariableEnterException {
            setRange(userEnter);
            calcFibonacci();

            System.out.printf("Range %d - %d\n", range[0], range[1]);

            for(Map.Entry<Integer, Long> item : fibMap.entrySet()){
                if(item.getValue()>=range[0] && item.getValue()<=range[1]) {
                    System.out.printf("F%d %s \n", item.getKey(), item.getValue());
                }
            }
        }



}

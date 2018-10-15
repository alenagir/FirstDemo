package models;
import myExceptions.VariableEnterException;

import java.util.HashMap;
import java.util.Map;

    public class FibonacciMap {
        private long range []={0,1};
        private Map<Integer, Long> fibMap;
        private String userEnter;

        public FibonacciMap(){
            fibMap = new HashMap();
        }

        public void setRange(String userEnter) throws VariableEnterException {
            String userString[]=userEnter.split("-");
            if(userString.length>2){
                throw new VariableEnterException("Incorrect range input!");
            }
            if (userString.length == 2) {
                try {
                    range[0] = Long.parseLong(userString[0]);
                    range[1] = Long.parseLong(userString[1]);
                }catch (NumberFormatException ne){
                    throw new NumberFormatException("It is not a long number!");
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
                    throw new NumberFormatException("It is not a long number!");
                }
                if(length<0){
                    throw new VariableEnterException("Must be > 0!");
                }
                range[0] = (long) Math.pow(10, length - 1);
                range[1] = (long) Math.pow(10, length) - 1;
                if (range[0] == 1) {
                    range[0] = 0;
                }
            }
        }

        public Map calcFibonacci() {
            if (range[0] == 0) {
                fibMap.put(1, 0L);
                fibMap.put(2, 1L);
            }
            if (range[0] == 1) {
                fibMap.put(2, 1L);
            }
            long fib1 = 0; //F[n-2]
            long fib2 = 1; //F[n-1]
            long fibSum = 1;// F[n]

            int n = 2;

            while (fibSum <= range[1]) {
                n++;
                fibSum = fib1 + fib2;
                fib1 = fib2;
                fib2 = fibSum;

                if(fibSum>=range[0] && fibSum <= range[1]) {
                    fibMap.put(n, fibSum);
                }
            }
            return fibMap;
        }




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

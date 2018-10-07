package models.envelopes;

import service.Printable;
import service.Scanned;

//NOT GOOD REALIZATION

 public class Envelopes implements MyComparator, Printable {
     private double width_1;
     private double height_1;
     private double width_2;
     private  double height_2;
     private static String userAnswer;



        public Envelopes (){
            System.out.print("Enter the envelopes parameters to compare, mm : "+"\n");
        }

        private void setEnvelopesParam(){
            this.print("w1");
            this.width_1= Scanned.scanToDouble();

            this.print("h1");
            this.height_1=Scanned.scanToDouble();

            this.print("w2");
            this.width_2=Scanned.scanToDouble();

            this.print("h2");
            this.height_2=Scanned.scanToDouble();
        }


     public int compareEnvelopes(){
            if (MyComparator.compare(width_1, width_2)<-1
                && MyComparator.compare(height_1, height_2)<-1){// First is smaller
                return -1;
            }
            if (MyComparator.compare(width_1, width_2)>1
                        && MyComparator.compare(height_1, height_2)>1){// First is bigger
                return 1;
            }
            else return 0; // Equal within @param TOLERANCE
        }


        public  static void userDialog(){
            Printable.startQuestion();
            userAnswer = Scanned.scanToString();

            if (userAnswer.equals("no") || userAnswer.equals("n")) {
                Printable.userTerminated();
                return;
            }

            if (userAnswer.equals("yes") || userAnswer.equals("y") ) {
                Envelopes envelopes = new Envelopes();

                do {
                    envelopes.setEnvelopesParam();
                    int compare = envelopes.compareEnvelopes();
                    Printable.print(compare);
                    Printable.continueQuestion();
                    userAnswer=Scanned.scanToString();
                    if (userAnswer.equals("no") || userAnswer.equals("n")) return;

                }while((userAnswer.equals("y") || userAnswer.equals("yes")));
            }



        }


     @Override
     public void print(String s, int counter) {

     }
 }



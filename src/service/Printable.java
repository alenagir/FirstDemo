package service;

public interface Printable {

    public void print (int i);


//    default void print(String s){
//        if (s=="w1") System.out.println("width 1 = ");
//        if (s=="h1") System.out.println("height 1 = ");
//        if (s=="w2") System.out.println("width 2 = ");
//        if (s=="h2") System.out.println("height 2 = ");
//    }
    public void print(String s, int counter);

    static void startQuestion(){
        System.out.println("Would you like to start? yes(y)/no(n)");
    }

    static void continueQuestion(){
        System.out.println("\n\nWould you like to continue? yes(y)/no(n)");
    }

    static void userTerminated(){
        System.out.println("The program is terminated by the user.");
    }

    static void createPolygon (){
        System.out.println("Enter polygon parameters in the format: <Polygon name> <,> <length 1> <,> <length 2> <,> ...");
    }

    static void doesNotExist(){
        System.out.println("This object does not exist!");
    }
}

package hello.core.singleton;

public class StatefulService {

//    private int price;

//    public void order(String name, int price) {
//        System.out.println("name = " + name + " price " + price);
//        this.price = price; // singleton 패턴으로 공유되므로 무상태로 설계해야한다.
//    }

    public int order(String name, int price) {
        System.out.println("name = " + name + " price " + price);
        return price;
    }


//    public int getPrice() {
//        return price;
//    }
}

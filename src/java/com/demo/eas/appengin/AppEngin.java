package java.com.demo.eas.appengin;


public class AppEngin {

    private String Name;

    public AppEngin(String name) {
        this.Name = name;
    }


    public void doWork() {
        System.out.println("appEngin_"+Name+"do task");
    }

}

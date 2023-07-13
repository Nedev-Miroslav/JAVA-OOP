package W04InterfacesAndAbstraction.P03SayHello;

public interface Person {
    String getName();
    default String sayHello() {
        return "Hello";

    }


}

@FunctionalInterface
public interface IDragon {

    String sayHello(String name);

    default String sayHelloWord() {
        return "Hello word";
    }

    default String sayHelloWord2() {
        return "Hello word 2";
    }
}

class Hilo {

    public String hiloWord() {
        return "soy hilo";
    }

    public String hiloWord(String s) {
        return "soy " + s + " hilo 2 ";
    }
}
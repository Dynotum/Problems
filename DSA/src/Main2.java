public class Main2 extends AMain implements IMain {


    public Main2(int zero) {
        super(zero);
    }

    @Override
    public void mytest(String string) {
        System.out.println(caca);
        zero = 3;
    }

    @Override
    public String method() {
        return null;
    }

    @Override
    public int getInt() {
        return 0;
    }


    @Override
    public int getNum() {
        return getZero();
    }

}

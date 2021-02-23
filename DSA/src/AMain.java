public abstract class AMain {

    int zero = 0;

    public AMain(int zero) {
        //
        this.zero = zero;
    }

    public int getZero(){
        return zero;
    }

    public abstract int getNum();

    int getInt(){
        return 5;
    }
}

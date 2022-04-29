package creation_patterns.prototype;

class MonkeyKingRealize implements Cloneable{
    private String name;

    public MonkeyKingRealize() {}

    @Override
    public MonkeyKingRealize clone() {
        try {
            return (MonkeyKingRealize) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}

public class MonkeyKing {

}

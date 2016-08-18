package card;

import java.util.ArrayList;

public final class Result {
    private final int value;
    private final ArrayList<Card> array;

    public Result(int first, ArrayList<Card> second) {
        this.value = first;
        this.array = second;
    }

    public int getValue() {
        return value;
    }

    public ArrayList<Card> getArray() {
        return array;
    }
}

import java.util.*;
import java.io.*;
import java.lang.Math.*;

class DSAHashEntry {
    String key;
    Object value;
    // 0 = neverused 1= used -1= formerly used
    int state;

    public DSAHashEntry() {
        key = "";
        value = null;
        state = 0;
    }

    public DSAHashEntry(String inKey, Object inValue) {
        key = inKey;
        value = inValue;
        state = 1;
    }

    public String getKey() {
        return key;
    }

    public Object getValue() {
        return value;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {

        this.state = state;
    }

}// end of entry

public class DSAHashTable {
    private DSAHashEntry HashArray[];
    private int count;

    public DSAHashTable(int tableSize) {
        int actualsize = findNextPrime(tableSize);
        HashArray = new DSAHashEntry[actualsize];
        for (int i = 0; i < actualsize; i++) {
            HashArray[i] = new DSAHashEntry();
        }
    }

    public Object get(String inKey) {
        int hashIdx = hash(inKey);
        int stepHash = hashStep(inKey);
        int origIdx = hashIdx; // incase hash table full
        int the_index = 0;
        boolean found = false;
        boolean giveup = false;
        Object retValue;
        while ((!found) && (!giveup)) {
            the_index = hashIdx + stepHash;
            the_index = (the_index) % HashArray.length;
            if (HashArray[the_index].getState() == 0) {
                giveup = true;
            } else if (HashArray[the_index].getKey() == inKey) {
                found = true;
            } else {
                hashIdx = (the_index) % HashArray.length;
                if (hashIdx == origIdx) {
                    giveup = true;
                }
            }

            if (!found) {
                throw new NoSuchElementException();
            }

        }
        retValue = HashArray[the_index].value;
        return retValue;

    }

    private int hash(String key) {
        int hashIdx = 0;
        for (int i = 0; i < key.length(); i++) {
            hashIdx = (31 * hashIdx) + key.charAt(i);
        }
        return Math.abs(hashIdx % HashArray.length);

    }

    // see this later when using remove
    private float loadFactor() {
        return (float) count / HashArray.length;
    }

    public int findNextPrime(int startVal) {
        // even numbers are never prime so make it odd
        boolean isPrime;
        int primeVal;

        int rootVal;

        if (startVal % 2 == 0) {
            primeVal = startVal - 1;
        } else {
            primeVal = startVal;
        }

        isPrime = false;
        do {
            // test if actually prime number
            primeVal = primeVal + 2;
            int i = 3;
            isPrime = true;
            rootVal = (int) Math.sqrt(primeVal);
            do {
                if (primeVal % i == 0) {
                    isPrime = false;
                } else {
                    i = i + 2;
                }
            } while ((i <= rootVal) && (isPrime));
        } while (!isPrime);
        return primeVal;

    }

    public int hashStep(String inKey) {
        int key = hash(inKey);
        int MAX_STEP = 5;
        int hashStep = MAX_STEP - (key % MAX_STEP);
        return hashStep;
    }

    public void put(String inKey, Object inValue) {
        int thesize = HashArray.length;
        int has = hash(inKey);
        int stephash = hashStep(inKey);

        boolean find = false;
        boolean end = false;

        if (loadFactor() > 0.7) {
            resize(thesize);
        }

        while (!find && !end) {
            has = has + stephash;
            has = has % HashArray.length;
            if (HashArray[has].getState() == 0 || HashArray[has].getState() == -1) {
                DSAHashEntry entry = new DSAHashEntry(inKey, inValue);
                if (HashArray[has].getState() == 0) {
                    HashArray[has] = entry;
                    count++;
                    find = true;
                } else {
                    HashArray[has] = entry;
                    find = true;
                }
            } else {
                if (HashArray[has].getKey() == inKey) {
                    end = true;
                }
            }
        }

        // if (HashArray[has].getState() == 0) {
        // HashArray[has] = entry;

        // } else {
        // while (HashArray[has].getState() != 0) {
        // has = (has + 1) % HashArray.length;

        // }
        // HashArray[has] = entry;
        // }
        // count++;
        // System.out.println("The key is: " + inKey);
        // System.out.println("The hash index is :" + hash);
        // System.out.println("The value is: " + inValue);
    }

    public void remove(String inKey) {
        int thesize = HashArray.length;
        boolean found = false;
        int hash = hash(inKey);
        int step = hashStep(inKey);

        if (loadFactor() < 0.4) {
            resize(thesize);
        }
        while (!found) {
            hash = (hash + step) % HashArray.length;
            if (HashArray[hash].getState() == 1) {
                if (HashArray[hash].getKey() == inKey) {
                    HashArray[hash].state = -1;
                    HashArray[hash].key = "";
                    HashArray[hash].value = null;
                    count--;
                    found = true;
                }
            }
        }
    }

    public void resize(int size) {
        int doubleSize;
        DSAHashEntry old[];
        old = HashArray;

        DSAHashEntry recent[];
        if (loadFactor() > 0.7) {
            doubleSize = 2 * size;
            int newSize = findNextPrime(doubleSize);
            recent = new DSAHashEntry[newSize];

            for (int i = 0; i < recent.length; i++) {
                recent[i] = new DSAHashEntry();
            }

            HashArray = recent;
            count = 0;

            for (int i = 0; i < old.length; i++) {
                if (old[i].getState() == 1) {
                    put(old[i].getKey(), old[i].getValue());
                }
            }
        }

        else if (loadFactor() < 0.4) {
            doubleSize = (int) (0.5 * size);
            int newSize = findNextPrime(doubleSize);
            recent = new DSAHashEntry[newSize];

            for (int i = 0; i < recent.length; i++) {
                recent[i] = new DSAHashEntry();
            }

            HashArray = recent;
            count = 0;

            for (int i = 0; i < old.length; i++) {
                if (old[i].getState() == 1) {
                    put(old[i].getKey(), old[i].getValue());
                }
            }
        }
    }

    public void export() {
        for (int i = 0; i < HashArray.length; i++) {
            if (HashArray[i].getState() == 1) {
                System.out.println(HashArray[i].key);
                System.out.println(HashArray[i].value + "\n");

            }
        }
    }

    public DSAHashEntry[] printArray() {
        return HashArray;
    }
}

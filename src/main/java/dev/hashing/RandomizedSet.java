package java.dev.hashing;

import java.util.HashSet;
import java.util.Set;

public class RandomizedSet {
    private Set<Integer> set= new HashSet<>();
    public RandomizedSet() {

    }

    public boolean insert(int val) {
        if(this.set.contains(val)){
            return false;
        }
        set.add(val);
        return true;
    }

    public boolean remove(int val) {
        if(!this.set.contains(val)){
            return false;
        }
        set.remove(val);
        return true;
    }

    public int getRandom() {
        int rand = (int)(Math.random() * set.size());
        return (int)this.set.toArray()[rand];
    }
}

/**
 * Your java.dev.hashing.RandomizedSet object will be instantiated and called as such:
 * java.dev.hashing.RandomizedSet obj = new java.dev.hashing.RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
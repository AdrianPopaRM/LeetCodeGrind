package main.java.dev.arrays;

public class DynamicArray {
    private  int nrElements=0;
    private int[] array;
    public DynamicArray(int capacity) {
        this.array= new int[capacity];
    }

    public int get(int i) {
        return array[i];
    }

    public void set(int i, int n) {
        array[i]=n;
    }

    public void pushback(int n) {
        if(nrElements==array.length){
            this.resize();
        }
        array[nrElements]=n;
        nrElements++;
    }

    public int popback() {
        int last=array[nrElements-1];
        array[nrElements-1]=0;
        nrElements--;
        return last;
    }

    private void resize() {
        int[] resizedArray=new int[2*array.length];
        for(int i=0;i<nrElements;i++){
            resizedArray[i]=array[i];
        }
        array=resizedArray;
    }

    public int getSize() {
        return nrElements;
    }

    public int getCapacity() {
        return array.length;
    }
}

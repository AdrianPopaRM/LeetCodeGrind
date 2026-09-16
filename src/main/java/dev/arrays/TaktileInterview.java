package main.java.dev.arrays;

import java.util.*;

public class TaktileInterview {
//    Implement an in-memory key-value store with the following operations:
//
//            - **`put(key, value)`**
//            - **`get(key)** → value`
//            - **`delete(key)`**

    public record command(String command, String key, Integer value){
    }

//    Add transaction capabilities:
//
//            - **`begin()`**: Start new transaction
//- **`commit()`**: Apply the active transaction
//- **`rollback()`**: Discard the active transaction

    private boolean flagTransactionOn=false;
    private Queue<command> q= new ArrayDeque<>();


    private Map<String, Integer> m = new HashMap<>();

    public void begin(){
        if(flagTransactionOn){
            return;
        }
        flagTransactionOn=true;
        q.clear();
    }

    public void commit(){
        if(!flagTransactionOn){
            return;
        }
        flagTransactionOn=false;
        while(!q.isEmpty()){
            switch(q.peek().command){
                case "Put":
                    this.put(q.peek().key, q.peek().value);
                    q.poll();
                    break;
                case "Get":
                    this.get(q.peek().key);
                    q.poll();
                    break;
                case "Delete":
                    this.delete(q.peek().key);
                    q.poll();
                    break;
            }
        }
    }

    public void rollback(){
        if(!flagTransactionOn){
            return;
        }
        q.clear();
    }




    public void put(String key, Integer value){
//        m.put(key, m.getOrDefault(key, value));
        if(flagTransactionOn){
            q.offer(new command("Put",key,value));
            return;
        }
        if(m.containsKey(key)){
            m.replace(key,value);
        }
        else{
            m.put(key,value);
        }
    }

    public Integer get(String key){
        if(flagTransactionOn){
            q.offer(new command("Get",key, -1));
        }
        if(!m.containsKey(key)){
            return -1;
        }
        return m.get(key);
    }

    public void delete(String key){
        if(flagTransactionOn){
            q.offer(new command("Delete", key, -1));
            return;
        }
        if(!m.containsKey(key)){
            return;
        }
        m.remove(key);
    }

    public static void main(String args[]){
        TaktileInterview s=new TaktileInterview();
//        s.put("Test", 9);
//        System.out.println(s.get("Test"));
//        s.put("Another Value", 1);
//        System.out.println(s.get("Another Value"));
//        s.delete("Test");
//        System.out.println(s.get("Test"));
//        s.delete("Doesnt exist");
//        System.out.println(s.get("Test"));
//        System.out.println(s.get("Another Value"));

        s.begin();
        s.put("TestTransaction",9);
        System.out.println(s.get("TestTransaction"));
        s.put("TestTransaction2",1);
        s.delete("TestTransaction");
        System.out.println(s.get("TestTransaction"));
        s.commit();
        System.out.println(s.get("TestTransaction2"));
        s.delete("TestTransaction2");

        s.begin();
        s.put("TestTransaction",9);
        System.out.println(s.get("TestTransaction"));
        s.put("TestTransaction2",1);
        s.delete("TestTransaction");
        System.out.println(s.get("TestTransaction"));
        s.rollback();
        System.out.println(s.get("TestTransaction2"));

    }
}

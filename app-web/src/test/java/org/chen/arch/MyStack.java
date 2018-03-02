package org.chen.arch;

public class MyStack<T> {

    private T[] arr;
    private int count;

    public MyStack() {
        arr = (T[]) new Object[2];
    }

    public MyStack(int size) {
        arr = (T[]) new Object[size];
    }


    public void push(T t){
        if(count == arr.length){
            resize(count * 2);
        }
        arr[count++] = t;
    }

    public T peek(){
        T t = arr[count -1];
        return  t;
    }

    public T pop(){
        T t = arr[--count];
        arr[count] = null;
        if(count > 0 && count == arr.length / 4){
            resize(arr.length / 2);
        }
        return t;
    }

    private void resize(int size){
        if(size < count){
            throw new RuntimeException("");
        }
        T[] tmp = (T[]) new Object[size];
        for(int i=0;i<count;i++){
            tmp[i] = arr[i];
        }
        arr = tmp;
    }


}

import Exceptions.ArraySizeOverrunException;
import Exceptions.IndexLargerThanSizeException;
import Exceptions.ItemEqualsNullException;

import java.util.Arrays;

public class ArrayListService implements StringList{

    private int size;

    public String[] list;

    public ArrayListService(int capacity) {
        list = new String[capacity];
    }

    public void validItem(String item) {
        if(item == null || item.isEmpty()){
            throw new ItemEqualsNullException("Неверный формат");
        }
    }

    public void validIndex(int index) {
        if(index >= size || index < 0){
            throw new IndexLargerThanSizeException("Индекс выходит за пределы массива или фактической его длины");
        }
    }

    public void validSize(){
        if(size == list.length){
            throw new ArraySizeOverrunException("Выход за пределы массива");
        }
    }

    @Override
    public String add(String item){
        validSize();
        validItem(item);
        list[size++] = item;
        return item;
    }

    @Override
    public String add(int index, String item){
        validItem(item);
        validIndex(index);
        validSize();
        if(index == size){
            list[size++] = item;
            return item;
        }
        System.arraycopy(list,index,list,index + 1, size - index);
        list[index] = item;
        size++;

        return item;
    }

    @Override
    public String set(int index, String item){
        validItem(item);
        validIndex(index);
        list[index] = item;
        return item;
    }

    @Override
    public String remove(String item) {
        validItem(item);
        int index = indexOf(item);

        if(index == -1){
            throw new RuntimeException("Элемент не найден");
        }
        if(index != size){
            System.arraycopy(list,index+1,list,index, size - index);
        }
        size--;
        return item;
    }

    @Override
    public String remove(int index) {
        validIndex(index);
        String item = list[index];
        if(index != size){
            System.arraycopy(list,index+1,list,index, size - index);
        }
        size--;
        return item;
    }

    @Override
    public boolean contains(String item) {
        return indexOf(item) != -1;
    }

    @Override
    public int indexOf(String item) {
        for(int i = 0 ; i < size  ; i++){
            if(list[i].equals(item)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for(int i = size - 1 ; i > 0 ; i--){
            if(list[i].equals(item)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        validIndex(index);
        return list[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        return Arrays.equals(otherList.toArray(),this.toArray());
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public String[] toArray() {
        return Arrays.copyOf(list,size);
    }
}

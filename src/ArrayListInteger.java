import Exceptions.IndexLargerThanSizeException;
import Exceptions.ItemEqualsNullException;

import java.util.Arrays;

public class ArrayListInteger implements IntegerList{

    private int size;
    public Integer[] list;

    public ArrayListInteger(int capacity) {
        list = new Integer[capacity];
    }

    public void validItem(Integer item) {
        if(item == null){
            throw new ItemEqualsNullException("Неверный формат");
        }
    }

    public void validIndex(int index) {
        if(index > size || index < 0){
            throw new IndexLargerThanSizeException("Индекс выходит за пределы массива или фактической его длины");
        }
    }

    public void validSize(){
        if(size == list.length){
            list = Arrays.copyOf(list,size * 2);
        }
    }

    private void sortSelection(Integer[] arr){
        for (int i = 0; i < size - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < size; j++) {
                if (arr[j] < arr[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            int tmp = arr[minElementIndex];
            arr[minElementIndex] = arr[i];
            arr[i] = tmp;
        }
    }

    private boolean binarySearch(Integer item){
        int min = 0;
        int max = size - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (item == list[mid]) {
                return true;
            }

            if (item < list[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }

    @Override
    public Integer add(Integer item) {
        validSize();
        validItem(item);
        list[size++] = item;
        return item;
    }

    @Override
    public Integer add(int index, Integer item) {
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
    public Integer set(int index, Integer item) {
        validItem(item);
        validIndex(index);
        list[index] = item;
        return item;
    }

    @Override
    public Integer remove(Integer item) {
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
    public Integer remove(int index) {
        validIndex(index);
        Integer item = list[index];
        if(index != size){
            System.arraycopy(list,index+1,list,index, size - index);
        }
        size--;
        return item;
    }

    @Override
    public boolean contains(Integer item) {
        sortSelection(list);
        return binarySearch(item);
    }

    @Override
    public int indexOf(Integer item) {
        for(int i = 0 ; i < size  ; i++){
            if(list[i].equals(item)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        for(int i = size - 1 ; i > 0 ; i--){
            if(list[i].equals(item)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        validIndex(index);
        return list[index];
    }

    @Override
    public boolean equals(IntegerList otherList) {
        return Arrays.equals(otherList.toArray(), this.toArray());
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
    public Integer[] toArray() {
        return Arrays.copyOf(list,size);
    }
}

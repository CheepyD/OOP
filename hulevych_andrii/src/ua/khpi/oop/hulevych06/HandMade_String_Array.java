package ua.khpi.oop.hulevych06;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.io.Serializable;

public class HandMade_String_Array implements Iterable<String>, Serializable {
	private static final long serialVersionUID = 1L;
	private String[] elements;
    private int size;
    public HandMade_String_Array(String[] array){
        this.elements = array;
        this.size = array.length;
    }
    public HandMade_String_Array() {
        this.elements = null;
    }
    
    public String toString() {
    	String result = "[ ";
    	for (int i = 0; i < size; i++) {
    		result += ("\"" + elements[i] + "\" ");
    	}
    	result += "]";
		return result;
    }
	public void add(String string) {
		if (elements != null){
			String[] newArray = new String[elements.length + 1];
	        System.arraycopy(elements, 0, newArray, 0, size);
	        elements = newArray;
        } else {
        	String[] newArray = new String[1];
        	elements = newArray;
        }
        elements[size] = string;
        size++;
	}
	public void clear() {
		for (int i = 0; i < size; i++)
            elements[i] = null;
        size = 0;
	}
	
	public boolean remove(String string) {
		if (string == null) {
            for (int index = 0; index < size; index++)
                if (elements[index] == null) {
                    fastRemove(index);
                    return true;
                }
        } else {
            for (int index = 0; index < size; index++)
                if (string.equals(elements[index])) {
                    fastRemove(index);
                    return true;
                }
        }
        return false;
	}
	public String[] toArray() {
		return this.elements;
	}
	public int size() {
		return this.size;
	}
	public boolean contains(String string) {
		return indexOf(string) >= 0;
	}
	public boolean containsAll(Collection<String> container) {
		for(int i = 0; i < size; i++) {
			if(!container.contains(elements[i])) {
				return false;
			}
		}
		return true;
	}
	private void fastRemove(int index) {
        int numMoved = size - index - 1;
        if (numMoved > 0)
            System.arraycopy(elements, index+1, elements, index,numMoved);
        elements[--size] = null;
    }
	public int indexOf(String string) {
        if (string == null) {
            for (int i = 0; i < size; i++)
                if (elements[i]==null)
                    return i;
        } else {
            for (int i = 0; i < size; i++)
                if (string.equals(elements[i]))
                    return i;
        }
        return -1;
    }
	
	public void sortArray() {
		Arrays.sort(elements);
	}
	
	@Override
	public Iterator<String> iterator() {
		Iterator<String> it = new Iterator<String>() {
			
		   private int currentIndex = 0;

           @Override
           public boolean hasNext() {
               return currentIndex < size && elements[currentIndex] != null;
           }

           @Override
           public String next() {
               return elements[currentIndex++];
           }

           @Override
           public void remove() {
               throw new UnsupportedOperationException();
           }
	    };
	    return it;
	}
	
}

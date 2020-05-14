package ua.khpi.oop.hulevych10;

import java.util.Iterator;

class List<T extends Agency> implements Iterable<T> { 
    private Node<T> head, tail; 
    private int _size;
      
    public int getSize() {
        return _size;
    }
    

    public void add(T data) 
    { 
        Node<T> node = new Node<>(data, null); 
        if (this.head == null) {
        	this.head = node;
            _size++;
        }
        else { 
        	Node<T> current = this.head;
        	while(current.getNext() != null) {
        		current = current.getNext();
        	}
        	current.setNext(node);
        	this.tail = current.getNext();
            _size++;
        } 
    } 

    public void add(T[] array) {
        for (T data : array) {
            add(data);
        }
    }

    public void remove(T data) {
        Node current = getHead();
        Node next = current.getNext();

        if (getHead().getData().equals(data)) {
            if (_size == 1) {
                getHead().setData(null);
                _size--;
                return;
            }
            getHead().setData(null);
            head = getHead().getNext();
            _size--;
            return;
        }

        while (next != null) {
            if (next.getData().equals(data)) {
                current.setNext(next.getNext());
                next = null;
                _size--;
                return;
            }
            current = next;
            next = current.getNext();
        }
    }
    
    public Agency[] toArray() {
      Agency[] temp = new Agency[_size];
      Node current = getHead();
      Node next = current.getNext();
      for(int i = 0; i < _size; i++) {
        temp[i] = (Agency) current.getData();
        current = next;
        //next = current.getNext();
      }
      
      return temp;
    }
    public String toString(List<Agency> list) {
    	StringBuilder temp = new StringBuilder();
    	temp.append("[");
    	for(Agency elem : list) {
    		temp.append("Firm name:" + elem.getFirmName() + "\nPosition:" + elem.getPosition() + "\nCircumstances:" + elem.getCircs()
    		+ "\nSalary:" + elem.getSalary());
    		if(elem.getKey()) {
    			temp.append("\nEducation:" + elem.getReqs().getEducation() + "\nExperience:" + elem.getReqs().getYexp());
    		}
    	}
    	temp.append("]");
    	return temp.toString();
    }
    // return Head 
    public Node<T> getHead() 
    { 
        return head; 
    } 
    
      
    // return Tail 
    public Node<T> getTail() 
    { 
        return tail; 
    } 
      
    // return Iterator instance 
    public Iterator<T> iterator() 
    { 
        return new ListIterator<T>(this); 
    } 
    
    public static<T extends Agency> boolean compareFirmNames(T p1, T p2) {
        
    	if(p1.getFirmName().length() > p2.getFirmName().length()) {
    	return true;
    	}
    	return false;
        
    }
    public static<T extends Agency> boolean compareEducation(T p1, T p2) {
    	if(p1.getReqs() != null && p2.getReqs() != null) {
    		if( p1.getReqs().getEducation().compareTo(p2.getReqs().getEducation()) > 0) {
    			return true;
    		}
    		return false;
    	}
    	return false;
    }
    public static<T extends Agency> boolean compareCircs(T p1, T p2) {
        if(p1.getCircs().compareTo(p2.getCircs()) > 0) {
    	return true;
        }
        return false;
    }
    
    public void sortList() {
    	if(this.head == null) {
    		return;
    	}
    	boolean exit = false;
    	while(!exit) {
    		exit = true;
    		Node<T> current = head;
    		Node<T> prev = null;
    		while(current != null) {
    			Node<T> next = current.getNext();
    			if(next != null) {
    				if(compareFirmNames(current.getData(), next.getData())) {
    					if(current == this.head) {
    						this.head = next;
    					}
    					if(prev != null) {
    						prev.setNext(next);
    					}
    				
    					Node tmp = next.getNext();
    					next.setNext(current);
    					current.setNext(tmp);
    					
    					exit = false;
    				}
    			}
    			prev = current;
                current = next;
    		}
    		
    	}
    	
    }
    
} 
  
class ListIterator<T extends Agency> implements Iterator<T> { 
    Node<T> current; 
      
    // initialize pointer to head of the list for iteration 
    public ListIterator(List<T> list) 
    { 
        current = list.getHead(); 
    } 
      
    // returns false if next element does not exist 
    public boolean hasNext() 
    { 
        return current != null; 
    } 
      
    // return current data and update pointer 
    public T next() 
    { 
        T data = current.getData(); 
        current = current.getNext(); 
        return data; 
    } 
      
    // implement if needed 
    public void remove() 
    { 
        throw new UnsupportedOperationException(); 
    } 
} 
  
// Constituent Node of Linked List 
class Node<T> { 
    T data; 
    Node<T> next; 
    public Node(T data, Node<T> next) 
    { 
        this.data = data; 
        this.next = next; 
    } 
      
    // Setter getter methods for Data and Next Pointer 
    public void setData(T data) 
    { 
        this.data = data; 
    } 
      
    public void setNext(Node<T> next) 
    { 
        this.next = next; 
    } 
      
    public T getData() 
    { 
        return data; 
    } 
      
    public Node<T> getNext() 
    { 
        return next; 
    } 
} 
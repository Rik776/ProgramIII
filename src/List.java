import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;

public class List<T>  implements java.util.List  {
  private Node<T> head;
  private int size;
public List() {
    size = 0;
    head = null;
}
@Override
public int size() {
   return size;
}
@Override
public boolean isEmpty() {
   return head == null;
   }
@Override
public boolean contains(Object o) {
    Node<T> auxNode = head;
    while (auxNode.getData()!= o ) {
        auxNode = auxNode.getNext();
        if (auxNode.getNext()==null&& auxNode.getData()!=o) {
            return false;
        }
    }
    return true;
}

@Override
public Object[] toArray() {
    Object[] object = new Object[size-1];
    Node<T> nodeAux = head;
    int i = 0;
    while (nodeAux.getNext()!=null) {
        object[i]=nodeAux.getData();
        nodeAux = nodeAux.getNext();
        i++;
    }
    return object;


}
@Override
public Object[] toArray(Object[] a) {
   Object[] object = new Object[a.length];
    Node<T> nodeAux = head;
    int i = 0;
    while (nodeAux.getNext()!=null && i< a.length ) {
        object[i]=nodeAux.getData();
        nodeAux = nodeAux.getNext();
        i++;
    }
    return object;

}
@SuppressWarnings("unchecked")
@Override
public boolean add(Object e) {
    Node<T> auxNode = new Node<T>((T)e);
    if (head==null) {
        head= auxNode;
        size++;
    }else{
        verifyTail().setNext(auxNode);
        size++;
    }
    return verifyTail() ==auxNode;
}
@Override
public boolean remove(Object o) {
    Node<T> auxNode = head;
    if (contains(o)&& o != head.getData()) {
        while (auxNode.getNext().getData()!= o ) {
        auxNode = auxNode.getNext();
    }
    auxNode.setNext(auxNode.getNext().getNext());
    return true;
    }else if (o == head.getData()) {
        head = head.getNext();
        return true;
    }
    return false;
}
@Override
public boolean containsAll(Collection c) {
    for (Object object : c) {
        if (!contains(object)) {
            return false;
         }
    }
    return true;
}
@Override
public boolean addAll(Collection c) {
    if (!c.isEmpty()) {
     for (Object object : c) {
        add(object);
    }   
    return true;
    }
    return false;
    
}
@Override
public boolean addAll(int index, Collection c) {
    int aux = 0;
    Node<T> nodeAux = head;
    if (index == 0) {
        for (Object object : c) {
            add(aux++, object);
        }
    }else if( 0<=index && index<size){
    while (aux!=index-1 && nodeAux.getNext()!=null) {
        nodeAux = nodeAux.getNext();
        aux++;
    }for (Object object : c) {
        add(aux++, object);;
    }
    size = size+c.size();
    return true;
    }
    return false;

 }
    
@Override
public boolean removeAll(Collection c) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'removeAll'");
}
@Override
public boolean retainAll(Collection c) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'retainAll'");
}
@Override
public void clear() {
    head = null;
}
@Override
public Object get(int index) {
    Node<T> nodeAux = head;
    int aux = 0;
    if (size>index && index>=0) {
      while (aux != index && nodeAux.getNext() != null ) {
        nodeAux = nodeAux.getNext();
        aux++;
    }  
    return nodeAux.getData();
    }
    throw new IndexOutOfBoundsException("Index out of bounds. size = "+size);
}
@Override
public Object set(int index, Object element) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'set'");
}
@Override
public void add(int index, Object element) {
    Node<T> newNode = new Node<T>((T) element);
    int aux = 0;
    Node<T> nodeAux = head;
    if (index == 0) {
        newNode.setNext(head);
        head=newNode;
    }else{
    while (aux!=index-1 && nodeAux.getNext()!=null) {
        nodeAux = nodeAux.getNext();
        aux++;
    }
    newNode.setNext(nodeAux.getNext());
    nodeAux.setNext(newNode);
    }
    size++;
 }
@Override
public Object remove(int index) {
    throw new UnsupportedOperationException("Unimplemented method 'indexOf'");
}
@Override
public int indexOf(Object o) {
    Node<T> auxNode = head;
    int auxInt = 0;
    if (contains(o)) {
        while (auxNode.getNext()!= null) {
            if (o.equals(auxNode.getData())) {
                return auxInt;
            }
            auxNode = auxNode.getNext();
            auxInt++;
        }
    }
    return -1;
}
@Override
public int lastIndexOf(Object o) {
    Node auxNode = head;
    int auxInt=0;
    if (contains(o)) {
        while (auxNode.getNext()!=null) {
            if (o.equals(auxNode.getData())) {
                auxInt = indexOf(auxNode);
            }
            auxNode = auxNode.getNext();
        }
        return auxInt;
    }
    return -1;
}
@Override
public ListIterator listIterator() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'listIterator'");
}
@Override
public ListIterator listIterator(int index) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'listIterator'");
}
@Override
public java.util.List subList(int fromIndex, int toIndex) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'subList'");
}
@Override
public Iterator iterator() {
   Iterator iterator = new Iterator<T>() {
    Node<T> nodeAux = head;
    @Override
    public boolean hasNext() {
        return nodeAux!=null;
    }
    @Override
    public T next() {
        T auxT = nodeAux.getData();
        nodeAux = nodeAux.getNext();
         return auxT;
    }
   };
   return iterator;
}
public Node<T> verifyTail(){
    Node<T> nodeAux = head;
    while (nodeAux.getNext()!=null) {
        nodeAux = nodeAux.getNext();
    }
    return nodeAux;
}
}

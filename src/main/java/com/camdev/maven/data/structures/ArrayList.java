package com.camdev.maven.data.structures;

import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class ArrayList<E extends Comparable<E>> implements List<E> {
	
	private transient Object[] elements;
	private int size;
	private int currIndex;
	
	private static final int DEFAULT_CAPACITY = 10;
	private static final Object[] EMPTY_ELEMENTSDATA = {};
	
//	protected transient int modCount = 0;
	
	public ArrayList() {
		this.size = 10;
		currIndex = -1;
		elements = new Object[DEFAULT_CAPACITY];
	}
	
	public ArrayList(int size) {
		this.size = size;
		currIndex = -1;
		elements = new Object[size];
	}
	
	public ArrayList(Collection<? extends E> c) {
		
		Object[] a = c.toArray();
		
		if((size = a.length) != 0 ) {
			
			if(c.getClass() == ArrayList.class) {
				elements = a;
			}
			else {
				elements = Arrays.copyOf(a, size, Object[].class);
			}
			
			currIndex = size - 1;
			
		}
		else {
			elements = EMPTY_ELEMENTSDATA;
			currIndex = -1;
		}
		
	}
	
	private int occupiedSize() {
		return currIndex + 1; 
	}
	
	public void trimToSize() {
		if(occupiedSize() < size) {
			if(occupiedSize() != 0) {
				elements = Arrays.copyOf(elements, occupiedSize());
			}
		}
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return occupiedSize() == 0;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object[] toArray() {
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public boolean add(List<E> e) {
		Iterator<E> itr = e.iterator();
		int i = 0;
		while(itr.hasNext()) {
			if(currIndex == size) {
				grow();
			}
			E curr = itr.next();
			elements[i] = (E) curr;
			i++;
		}
		return true;
	}

	@Override
	public boolean add(E e) {
		if(currIndex == size - 1) {
			grow();
		}
		elements[currIndex] = (E) e;
		currIndex++;
		return false;
	}
	
	@Override
	public void add(int index, E element) {
		if(index >= size) {
			grow();
		}
		
	}
	
	public void grow() {
		grow((size + 1) * 2);
	}
	
	private void grow(int newSize) {
		Object[] elements = new Object[newSize];
		for(int i = 0; i < currIndex; i++) {
			elements[i] = this.elements[i];
		}
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		if(occupiedSize() == 0) return;
		for(int i = 0; i < occupiedSize(); i++) {
			elements[i] = null;
		}
		currIndex = -1;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E get(int index) {
		Objects.checkIndex(index, occupiedSize());
		return (E) elements[index];
	}

	@Override
	public E set(int index, E element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ListIterator<E> listIterator() {
		return new ListItr(0);
	}
	
	@Override
	public ListIterator<E> listIterator(int index) {
		rangeCheckForAdd(index);
		return new ListItr(index);
	}
	
	@Override
	public Iterator<E> iterator() {
		return new Itr();
	}

	private void rangeCheckForAdd(int index) {
		if(index < 0) {
			throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
		}
	}
	
	private String outOfBoundsMsg(int index) {
		return "Index: " + index + ", Size: " + occupiedSize();
	}
	
	private class Itr implements Iterator<E> {
		int cursor;
		int lastRet = -1;
		
		public Itr() {}
		
		public boolean hasNext() {
			return cursor != occupiedSize();
		}
		
		@SuppressWarnings("unchecked")
		public E next() {
			int i = cursor;
			if(i >= occupiedSize()) {
				throw new NoSuchElementException();
			}
			Object[] elements = ArrayList.this.elements;
			if(i >= (elements.length - (elements.length - occupiedSize()))) {
				throw new ConcurrentModificationException();
			}
			cursor = i + 1;
			lastRet = i;
			return (E) elements[lastRet];
		}
		
//		final void checkForComodification() {
//			if(modCount != expectedModCount) {
//				throw new ConcurrentModificationException();
//			}
//		}
		
	}
	
	private class ListItr extends Itr implements ListIterator<E> {
		
		ListItr(int index){
			super();
			cursor = index;
		}

		@Override
		public boolean hasPrevious() {
			return cursor != 0;
		}

		@Override
		public E previous() {
			try {
				int i = cursor - 1;
				E previous = get(i);
				lastRet = cursor = i;
				return previous;
			}
			catch (IndexOutOfBoundsException e){
				throw new NoSuchElementException(e.toString());
			}
		}

		@Override
		public int nextIndex() {
			return cursor;
		}

		@Override
		public int previousIndex() {
			return cursor - 1;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void set(E e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void add(E e) {
			// TODO Auto-generated method stub
			
		}
		
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String toString() {
		if(occupiedSize() == 0) return "";
		StringBuilder sb = new StringBuilder();
		int occupiedIndex = (currIndex < size) ? currIndex : size - 1;
		for(int i = 0; i <= occupiedIndex; i++) {
			if(i < occupiedIndex) {
				sb.append(elements[i] + ", ");
			}
			else {
				sb.append(elements[i]);
			}
		}
		return sb.toString();
	}

}

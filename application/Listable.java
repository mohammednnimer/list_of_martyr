package application;

public interface Listable <T extends Comparable<T>> {


	 void add(T data);
	boolean delete (T data);
	boolean find(T data);
	void clear();
	boolean isempty();
	int size();
	void traverse();





}




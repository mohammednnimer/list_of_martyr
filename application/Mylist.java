package application;

import java.util.List;

public class Mylist<T extends Comparable<T>> implements Listable<T> {
	int counter = 0;
	T[] List;

	public Mylist(int size) {
		List = (T[]) new Comparable[size];

	}

	@Override
	public void add(T data) {

		if (data != null) {

			if (counter >= List.length)
				resize();

			if (counter < List.length) {
				List[counter] = data;
				counter++;

			}

		}

	}

	@Override
	public boolean delete(T data) {
		for (int i = 0; i < counter; i++) {
			if (data.compareTo(List[i]) == 0) {
				List[i] = null;
				counter--;
				for (int j = i + 1; j <= counter; j++) {

					List[j - 1] = List[j];

				}
				return true;

			}

		}
		System.out.println("not found");
		return false;
	}

	public T get(int i) {
		return List[i];

	}

	private void resize() {
		T[] list1 = (T[]) new Comparable[List.length * 2];
		for (int i = 0; i < counter; i++) {
			list1[i] = List[i];
		}
		List = list1;
	}

	@Override
	public boolean find(T data) {
		if (counter != 0) {
			for (int i = 0; i < counter; i++) {
				if (data.compareTo(List[i]) == 0) {
					System.out.println(List[i]);
					return true;
				}
			}
		}

		return false;
	}

	@Override
	public void clear() {
		for (int i = 0; i < counter; i++) {
			List[i] = null;
		}
		counter = 0;
	}

	@Override
	public boolean isempty() {
		if (counter == 0)
			return true;
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return counter;
	}

	@Override
	public void traverse() {
		for (int i = 0; i < counter; i++) {
			System.out.println(i + " : " + List[i]);
		}

	}

}
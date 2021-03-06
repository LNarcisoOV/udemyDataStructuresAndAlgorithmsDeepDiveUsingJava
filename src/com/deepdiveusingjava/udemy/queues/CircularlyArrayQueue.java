package com.deepdiveusingjava.udemy.queues;

import java.util.NoSuchElementException;

import com.deepdiveusingjava.udemy.model.Employee;

public class CircularlyArrayQueue {
	private Employee[] queue;
	private int front;
	private int back;

	public CircularlyArrayQueue(int capacity) {
		queue = new Employee[capacity];
	}

	public void enqueue(Employee employee) {
		resizeQueueIfNecessary();

		queue[back] = employee;
		if (back < queue.length - 1) {
			back++;
		} else {
			back = 0;
		}
	}

	private void resizeQueueIfNecessary() {
		// Checking if the queue is full.
		if (size() == queue.length - 1) {
			int numItems = size();
			Employee[] newArray = new Employee[2 * queue.length];
			System.arraycopy(queue, front, newArray, 0, queue.length - front);
			System.arraycopy(queue, 0, newArray, queue.length - front, back);
			queue = newArray;
			front = 0;
			back = numItems;
		}
	}

	public Employee dequeue() {
		if (size() == 0) {
			throw new NoSuchElementException();
		}

		Employee employee = queue[front];
		queue[front] = null;
		front++;

		if (size() == 0) {
			front = 0;
			back = 0;
		} else if (front == queue.length) {
			front = 0;
		}

		return employee;
	}

	public Employee peek() {
		if (size() == 0) {
			throw new NoSuchElementException();
		}

		return queue[front];
	}

	public int size() {
		if (front <= back) {
			return back - front;
		} else {
			return back - front + queue.length;
		}

	}

	public void print() {
		if (front <= back) {
			for (int i = front; i < back; i++) {
				System.out.println(queue[i]);
			}
		} else {
			for (int i = front; i < queue.length; i++) {
				System.out.println(queue[i]);
			}
			for (int i = 0; i < back; i++) {
				System.out.println(queue[i]);
			}
		}
		System.out.println();
	}

}

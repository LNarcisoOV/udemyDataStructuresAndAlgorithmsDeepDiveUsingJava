package com.deepdiveusingjava.udemy.queues;

import com.deepdiveusingjava.udemy.model.Employee;

public class MainQueue {

	public static void main(String[] args) {
		System.out.println("::::: QUEUE :::::");
		System.out.println();

		System.out.println("- Abstract data type.");
		System.out.println("- FIFO, first in first out.");
		System.out.println("- ADD(), also called ENQUEUE, add an item ");
		System.out.println("to the end of the queue.");
		System.out.println("- REMOVE(), also called DEQUEUE, remove an item ");
		System.out.println("at the front of the queue.");
		System.out.println("- PEEK(), get the item at the front of the queue,");
		System.out.println("but don't remove it.");
		System.out.println();
		System.out.println();

		creatingPopulatingAndShowingQueue();
	}

	private static void creatingPopulatingAndShowingQueue() {
		Employee janeJones = new Employee(123, "Jane", "Jones");
		Employee johnDoe = new Employee(4567, "John", "Doe");
		Employee marySmith = new Employee(22, "Mary", "Smith");
		Employee mikeWilson = new Employee(3245, "Mike", "Wilson");

		ArrayQueue queue = new ArrayQueue(10);

		queue.enqueue(janeJones);
		queue.enqueue(johnDoe);
		queue.enqueue(marySmith);
		queue.enqueue(mikeWilson);

		System.out.println("----------------------------------------------------------------------");
		System.out.println("ENQUEUE: ");
		queue.print();

		System.out.println("----------------------------------------------------------------------");
		System.out.println("DEQUEUE: ");
		System.out.println(queue.dequeue());

		System.out.println();
		System.out.println("----------------------------------------------------------------------");
		System.out.println("PEEK: ");
		System.out.println(queue.peek());

	}

}

package pekan4_2511533030;

public class QueueArrayDriver_2511533030 {
	public static void main(String[] args) {
			QueueArray_2511533030 queue = new QueueArray_2511533030(1000);
			queue.enqueue(10);
			queue.enqueue(20);
			queue.enqueue(30);
			queue.enqueue(40);
			System.out.println("Item di depan "+ queue.front_3030());
			System.out.println("Item paling belakang " + queue.rear_3030());
			System.out.println("tampilan queue");
			queue.display_3030();
			System.out.println();
			System.out.println(queue.dequeue_3030() + "dihapus dari queue");
			System.out.println("Item di depan "+ queue.front_3030());
			System.out.println("Item paling belakang " + queue.rear_3030());
			System.out.println("tampilan queue setelah satu data dihapus");
			queue.display_3030();
	}

}

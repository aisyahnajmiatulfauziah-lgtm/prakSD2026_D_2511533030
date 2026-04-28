package pekan4_2511533030;

public class QueueArray_2511533030 {
	int front_3030, rear_3030, size_3030;
	int capacity_3030;
	int array_3030[];
	
	public QueueArray_2511533030(int capacity) {
		this.capacity_3030 = capacity;
		front_3030 = this.size_3030 = 0;
		rear_3030 = capacity - 1;
		array_3030 = new int[this.capacity_3030];
	}
	
	boolean isFull_2511533030(QueueArray_2511533030 queue) {
		return (queue.size_3030 == queue.capacity_3030);
	}
	
	boolean isEmpty(QueueArray_2511533030 queue) {
		return (queue.size_3030 == 0);
	}
	
	void enqueue(int item) {
		if (isFull_2511533030(this))
			return;
		this.rear_3030 = (this.rear_3030 +1) % this.capacity_3030;
		this.array_3030[this.rear_3030]= item;
		this.size_3030 = this.size_3030 + 1;
		System.out.println(item + "enqueue to queue");
	}

	int dequeue_3030() {
		if (isEmpty(this))
			return Integer.MIN_VALUE;
		int item = this.array_3030[this.front_3030];
		this.front_3030 = (this.front_3030 + 1) % this.capacity_3030;
		this.size_3030 = this.size_3030 - 1;
		return item;
	}
	
	int front_3030() {
		if (isEmpty(this))
			return Integer.MIN_VALUE;
		return this.array_3030[this.front_3030];
	}
	
	int rear_3030() {
		if (isEmpty(this))
			return Integer.MIN_VALUE;
		return this.array_3030[this.rear_3030];
	}
	
	// Mencetak elemen antrian
	void display_3030() {
		int i;
		if (front_3030 == rear_3030) {
			System.out.printf("\nAntrian Kosong\n");
			return;
		}
		
	// Kunjungi dari belakang dan cetak
		for (i = front_3030; i < rear_3030; i++) {
			System.out.printf(" %d <-- ", array_3030[i]);
		}
		return;
	}
}
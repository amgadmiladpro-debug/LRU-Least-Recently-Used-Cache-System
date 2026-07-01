public class Main {
	public static void main(String[] args) {
		// ================= TEST CASES =================
		LRUCache cache = new LRUCache(3);
		cache.put(1, 10);
		cache.put(2, 20);
		cache.put(3, 30);
		System.out.println("--------- Before Eviction: ---------");
		cache.display();
		cache.put(4, 40);     // Trigger Eviction
		System.out.println("\n--------- After Eviction: ---------");
		cache.display();
		System.out.println("\nCurrent Size = " + cache.getSize());    // Check size
		System.out.println("\n--------- Check if key 1 is removed: ---------");
		System.out.println("Returned value = " + cache.get(1));
		System.out.println("\n--------- After accessing key 2 (it should move to front): ---------");
		cache.get(2);                       // Moved
		cache.display();
		cache.put(3,50);  //updating an existing key(3)
		System.out.println("\n--------- After updating an existing key: ---------");
		cache.display();                //moved to front

		// ================= EDGE CASES =================
		System.out.println("\n--------- Accessing key many times: ---------");
		System.out.println("\n- First access: ");
		cache.get(4);    //Moved to the front
		cache.display();
		System.out.println("\n- second access: ");
		cache.get(4);   //The order didn't change
		cache.display();
		System.out.println("\n--------- Removing existing key: ---------");
		cache.remove(2);
		cache.display();
		System.out.println("\n--------- Removing non-existing key: ---------");
		cache.remove(5);
		cache.display();
		System.out.println("\n--------- Clearing the cache: ---------");
		cache.remove(3);
		cache.remove(4);
		System.out.print("The cache content: ");
		cache.display();
		System.out.println("The cache current size: "+cache.getSize());   //To make sure that HashTable is in sync with DLL
		System.out.println("\n--------- Getting key from empty cache: ---------");
		System.out.println("Returned value = " + cache.get(1));

		System.out.println("\n--------- Testing on cache with different capacity ---------");     //Test on different scenario
		LRUCache cache2=new LRUCache(1);
		cache2.put(10, 44);
		cache2.display();
		System.out.println("\n--------- Adding when capacity is full: ---------");
		cache2.put(11, 300);
		cache2.display();

		


		



		
		
	}

}

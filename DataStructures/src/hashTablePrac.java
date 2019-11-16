
	class hashTablePrac{
		  int[] data;

		  hashTablePrac(int size){
		    this.data = new int[size];
		  }
		  private int _hash(String key){
		    int hash = 0;
		    for(int i = 0; i < key.length(); i++){
		      hash = (hash + Character.codePointAt(key, i) * i) % this.data.length;
		    }
		    return hash;
		  }

		  public void set(String key, int value){
		    int index = _hash(key);
		    data[index] = value;
		  }

		  public int get(String key){
		    int index = _hash(key);
		    return data[index];
		  }

		}





class arrayPractice{
	//Log of pair of elements of the array
	   public static void logarr(){
	    int [] arr = new int[] {1,2,3,4,5};
	    double result;
	    for(int i = 0; i<arr.length;i++){
	      for(int j = 0;j<arr.length;j++){
	        result = Math.log(arr[i])/Math.log(arr[j]);
	        System.out.println(result);
	      }
	    }
	  }
	//Count the number of characters in the given string
	  public static void strcount(){
	    String str = "abcdef";
	    int count = 0;
	    for (char c : str.toCharArray()){
	      count++;
	    }
	    System.out.println(count);
	  }
	}


public class Anti_Best_Practices {
	
    public static void main(String[] args) {

        int[][] data = new int[10][10000];
        
        int lastDigit;
        
        for (int i = 0; i < 10000; i++) {
        	
        	lastDigit = i % 10;
        	if(lastDigit == 0){
        		data[0][i/10] = i;
        	} else if(lastDigit == 1) {
        		data[1][i/10] = i;
        	} else if(lastDigit == 2) {
        		data[2][i/10] = i;
        	} else if(lastDigit == 3) {
        		data[3][i/10] = i;
        	} else if(lastDigit == 4) {
        		data[4][i/10] = i;
        	} else if(lastDigit == 5) {
        		data[5][i/10] = i;
        	} else if(lastDigit == 6) {
        		data[6][i/10] = i;
        	} else if(lastDigit == 7) {
        		data[7][i/10] = i;
        	} else if(lastDigit == 8) {
        		data[8][i/10] = i;
        	} else {
        		data[9][i/10] = i;
        	} 
        }
        
        for (int i = 0; i < 10; i++) {
    	    System.out.print("Numbers ending with " + i + ": ");
    	    for (int j = 0; j < 10000; j++) {
    	        if (data[i][j] != 0) {
    	            System.out.print(data[i][j] + " ");
    	        }
    	    }
    	    System.out.println();
    	}
    }
}
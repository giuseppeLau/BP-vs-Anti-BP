
interface Model<T> {
    public T[] getData();
    public void setData(T[] data);
    public void generateMatrix(int size);
}

interface View<T> {
    public void render();
    public void update(T[] data);
}

interface Controller<T> {
    public void handleRequest(String request);
    public void updateView(T[] data);
}

class BP_Model implements Model<int[]> {
    private int[][] data;

    public BP_Model(int size) {
        data = new int[10][size];
    }

    public int[][] getData() {
        return data;
    }

    public void setData(int[][] data) {
        this.data = data;
    }

    public void generateMatrix(int size) {
    	int lastDigit;
        for (int i = 0; i < size; i++) {
        	lastDigit = i % 10;
        	switch (lastDigit) {
        	  case 0:
        		data[0][i/10] = i;
        	    break;
        	  case 1:
        		data[1][i/10] = i;
        	    break;
        	  case 2:
        		data[2][i/10] = i;
        	    break;
        	  case 3:
        		data[3][i/10] = i;
        	    break;
        	  case 4:
        		data[4][i/10] = i;
        	    break;
        	  case 5:
        		data[5][i/10] = i;
        	    break;
        	  case 6:
        		data[6][i/10] = i;
        	    break;
        	  case 7:
        		data[7][i/10] = i;
        	    break;
        	  case 8:
        		data[8][i/10] = i;
          	    break;
        	  case 9:
        		data[9][i/10] = i;
          	    break;
        	}
        }
    }
}

class BP_View implements View<int[]> {
    private int[][] data;

    public void render() {
    	for (int i = 0; i < 10; i++) {
    	    System.out.print("Numbers ending with " + i + ": ");
    	    for (int j = 0; j < 100000; j++) {
    	        if (data[i][j] != 0) {
    	            System.out.print(data[i][j] + " ");
    	        }
    	    }
    	    System.out.println();
    	}
    }

    public void update(int[][] data) {
        this.data = data;
        render();
    }
}

class BP_Controller implements Controller<int[]> {
    private Model<int[]> model;
    private View<int[]> view;

    public BP_Controller(Model<int[]> model, View<int[]> view) {
        this.model = model;
        this.view = view;
    }

    public void handleRequest(String request) {
        if (request.equalsIgnoreCase("generate")) {
            model.generateMatrix(100000);
            int[][] data = model.getData();
            view.update(data);
        }
    }

    public void updateView(int[][] data) {
        view.update(data);
    }
}

public class Best_Practices {
    public static void main(String[] args) {

    	int size = 100000;
        Model<int[]> model = new BP_Model(size);
        View<int[]> view = new BP_View();
        Controller<int[]> controller = new BP_Controller(model, view);

        controller.handleRequest("generate");
    }
}

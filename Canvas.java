import java.util.*;

public class Canvas implements ICanvas {
    private int[][] state;
    private int width;
    private int height;
   
   private class Pair<T, K> {
        private T first;
        private K second;

        public Pair(T first, K second) {
            this.first = first;
            this.second = second;
        }

        public T getFirst() {
            return first;
        }

        public K getSecond() {
            return second;
        }
   }

   public Canvas(int size) {
      width = size;
      height = size;
      
      state = new int[width][height];

   }
   
   public Canvas(int width, int height) {
       this.width = width;
       this.height = height;
       
      state = new int[height][width];
   }

   public int getWidth() {
       return width;
   }

   public int getHeight() {
       return height;
   }

   public void clear() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                clear(i, j);
            }
        }
   }

   public void clear(int x, int y) {
        try {
           state[y][x] = 0;
       }
       catch (ArrayIndexOutOfBoundsException e) {
           throw new IllegalArgumentException("Point out of bound.", e);
       }
   }


   public void dot(int x, int y) {
       try {
           state[y][x] = 1;
       }
       catch (ArrayIndexOutOfBoundsException e) {
           throw new IllegalArgumentException("Point out of bound.", e);
       }
   }

   public void fill(int x, int y) {
       try {
           Stack<Pair<Integer, Integer>> stack = new Stack<Pair<Integer, Integer>>();

           stack.push(new Pair<Integer, Integer>(x, y));

           while (!stack.empty()) {
                Pair<Integer, Integer> pair = stack.pop();

                int _x = pair.getFirst();
                int _y = pair.getSecond();

                if (state[_y][_x] != 1) {
                    dot(_x, _y);

                    if (_y > 0) stack.push(new Pair<Integer, Integer>(_x, _y - 1));

                    if (_y < height - 1) stack.push(new Pair<Integer, Integer>(_x, _y + 1));

                    if (_x > 0) stack.push(new Pair<Integer, Integer>(_x - 1, _y));

                    if (_x < width - 1) stack.push(new Pair<Integer, Integer>(_x + 1, _y));
                }                
           }
       }
       catch (ArrayIndexOutOfBoundsException e) {
           throw new IllegalArgumentException("Point out of bound.", e);
       }
   }
   
   @Override
   public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      
      stringBuilder.append(' ');
      for (int j = 1; j <= width; j++) {
          stringBuilder.append(j);
      }
      stringBuilder.append('\n');

      for (int i = 0; i < height; i++) {
         stringBuilder.append(i + 1);
         for (int j = 0; j < width; j++) {
             stringBuilder.append(state[i][j]);
         }
         stringBuilder.append('\n');
      }
      
      return stringBuilder.toString();
   }

}
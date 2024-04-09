package Groking;

public class BusiestTime {

    public static void main(String[] args) {
        int [][] data = { {1487799425, 14, 1},
                {1487799425, 4,  0},
                {1487799425, 2,  0},
                {1487800378, 10, 1},
                {1487801478, 18, 0},
                {1487801478, 18, 1},
                {1487901013, 1,  0},
                {1487901211, 7,  1},
                {1487901211, 7,  0} };

        System.out.println(busiestTime(data));
    }

    public static int busiestTime(int[][] data){
        int maxV = 0, curV = 0, time = 0, n = data.length;
        for (int i=0;i<n;i++) {
            if (data[i][2]==1) {
                curV+=data[i][1];
            } else {
                curV-=data[i][1];
            }
            if (i==n-1 || data[i][0]!=data[i+1][0]) {
                System.out.println(curV);
                if (curV > maxV) {
                    maxV = curV;
                    time = data[i][0];
                }
            }
        }
        return time;
    }
}

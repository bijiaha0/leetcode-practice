package Amazon.SlidingWindowAverageFromDataStream;

public class MovingAverage01 {

    double[] sum;
    int id, size;

    MovingAverage01(int size) {
        sum = new double[size + 1];
        id = 0;
        this.size = size;
    }

    int mod(int x) {
        return x % (size + 1);
    }

    public double next(int val) {

        id++;
        sum[mod(id)] = sum[mod(id - 1)] + val;

        if (id - size >= 0) {
            return (sum[mod(id)] - sum[mod(id - size)]) / size;
        } else {
            return sum[mod(id)] / id;
        }

    }

}

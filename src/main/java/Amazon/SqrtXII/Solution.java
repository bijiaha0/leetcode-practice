package Amazon.SqrtXII;
public class Solution {
    public double sqrt(double x) {
        double l = 0;
        double r = Math.max(x, 1.0);
        double eps = 1e-12;
        while (l + eps <= r) {
            double mid = l + (r - l) / 2;
            if(mid == x/mid){
                return mid;
            }else if(mid < x/mid){
                l = mid+1;
            }else {
                r = mid-1;
            }
        }
        return r;
    }
}
/**
 * Created by wopqw on 24.09.16.
 */
public class ComplexNumber {
    private final double re;
    private final double im;

    public ComplexNumber(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public double getRe() {
        return re;
    }

    public double getIm() {
        return im;
    }

//    @Override
//    public int hashCode(){
//        final int prime = 31;
//        int result = 1;
////        result = prime * result +re;
//    }
}

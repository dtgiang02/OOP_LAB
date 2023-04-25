import javax.swing.JOptionPane;
public class SystemOfFirstDegreeEquations{
    public static void main(String[] args){
        String a11,a12,b1,a21,a22,b2;
        a11 = JOptionPane.showInputDialog(null, "Input the first number: ");
        a12 = JOptionPane.showInputDialog(null, "Input the second number ");
        b1 = JOptionPane.showInputDialog(null, "Input the third number: ");
        a21 = JOptionPane.showInputDialog(null, "Input the fourth number: ");
        a22 = JOptionPane.showInputDialog(null, "Input the fifth number: ");
        b2 = JOptionPane.showInputDialog(null, "Input the sixth number: ");
        JOptionPane.showMessageDialog(null, "Function: " + a11 + "x1" +" + " + a12 + "x2" + " = " + b1 + " / " + a21 + "x1" +" + " + a22 + "x2" + " = " + b2 );
        double da11 = Double.parseDouble(a11);
        double da12 = Double.parseDouble(a12);
        double db1 = Double.parseDouble(b1);
        double da21 = Double.parseDouble(a21);
        double da22 = Double.parseDouble(a22);
        double db2 = Double.parseDouble(b2);
        double result1,result2;
        result1 = (da21*db1 - da11*db2) / (da22*da12 - da11*da22);
        result2 = (db1 - da12*result1) / da11;
        JOptionPane.showMessageDialog(null, "Results: "+ "x1 = " + result1 + " / " + "x2 = " + result2);

    }
}


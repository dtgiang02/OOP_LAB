import javax.swing.JOptionPane;
public class LinearEquationFirstDegree{
    public static void main(String[] args){
        String a;
        String b;
        a = JOptionPane.showInputDialog(null, "Input the first number:");
        b = JOptionPane.showInputDialog(null, "Input the second number");
        JOptionPane.showMessageDialog(null, "Function: " + a + "x" +" + " + b + " = 0");

        double c = Double.parseDouble(a);
        double d = Double.parseDouble(b);
        double x;
        x = -d/c;
        JOptionPane.showMessageDialog(null, "Result: x = " + x);

    }
}
import javax.swing.JOptionPane;
public class LinearEquationSecondDegree{
    public static void main(String[] args){
        String a,b,c;
        a = JOptionPane.showInputDialog(null, "Input the first number:");
        b = JOptionPane.showInputDialog(null, "Input the second number");
        c = JOptionPane.showInputDialog(null, "Input the third number");

        JOptionPane.showMessageDialog(null, "Function: " + a + "x^2" +" + " + b + "x " + "+ " + c + " = 0");
        double d = Double.parseDouble(a);
        double e = Double.parseDouble(b);
        double f = Double.parseDouble(c);
        double delta,x0,x1,x2;
        delta = e*e - 4*d*f;
        x0 = -e/(2*d);

        if (delta < 0) {
            JOptionPane.showMessageDialog(null, "Phuong trinh vo nghiem");
            System.exit(0);
        }
        if (delta == 0) {
            JOptionPane.showMessageDialog(null, "Phuong trinh co 1 nghiem");
            JOptionPane.showMessageDialog(null, "Result: x0 = "+ x0);
            System.exit(0);

        }
        if (delta > 0) {
            x1 = (-e - Math.sqrt(delta))/(2*d);
            x2 = (-e + Math.sqrt(delta))/(2*d);
            JOptionPane.showMessageDialog(null, "Phuong trinh co 2 nghiem");
            JOptionPane.showMessageDialog(null, "Result: x1 = "+ x1 + " / " + "x2 = "+ x2);
            System.exit(0);

        }
    }
}
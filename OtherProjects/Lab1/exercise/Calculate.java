import javax.swing.JOptionPane;
public class Calculate{
    public static void main(String[] args){
        String a;
        String b;
        a = JOptionPane.showInputDialog(null, "Input the first number:");
        b = JOptionPane.showInputDialog(null, "Input the second number");
        double c = Double.parseDouble(a);
        double d = Double.parseDouble(b);

        double sum,difference,product,quotient;
        sum = c + d;
        difference = c - d;
        product = c * d;
        quotient = c / d;
        JOptionPane.showMessageDialog(null, "Sum: " + sum);
        JOptionPane.showMessageDialog(null, "Difference: " + difference);
        JOptionPane.showMessageDialog(null, "Product: " + product);
        JOptionPane.showMessageDialog(null, "Quotient: " + quotient);

    }
}
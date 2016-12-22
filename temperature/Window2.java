import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Window2 extends JFrame implements ActionListener {
 private Container pane;

 private JButton CtoF,FtoC;
 private JLabel l;
 private JTextField t,u;
  
  //CONSTRUCTOR SETS EVERYTHING UP
  public Window2() {
     this.setTitle("Temperature Conversion!");
     this.setSize(600,400);
     this.setLocation(100,100);
     this.setDefaultCloseOperation(EXIT_ON_CLOSE);
     pane = this.getContentPane();
     pane.setLayout(new FlowLayout());  //NOTE!! THIS CAN BE CHANGED (see below)
     CtoF = new JButton("CtoF");
     FtoC = new JButton("FtoC");
     l = new JLabel("Temperature Converter!",null,JLabel.LEADING);
     t = new JTextField(12);
     u = new JTextField(12);
     pane.add(l);
     pane.add(CtoF);
     CtoF.addActionListener(this);
     pane.add(FtoC);
     FtoC.addActionListener(this);
     pane.add(t);
     pane.add(u);
  }
  public static double CtoF(double c) {
    return c*1.8 + 32;
  }
    public void actionPerformed(ActionEvent e) {
	try {
	    if (e.getActionCommand().equals("FtoC")) {
		u.setText(""+FtoC(Double.parseDouble(t.getText())));
	    }
	    else {
		u.setText(""+CtoF(Double.parseDouble(t.getText())));
	    }
	}
	catch (NumberFormatException n) {
	    System.out.println("Please put a valid real number into the text box!");
	}
    }
  public static double FtoC(double f) {
        return (5.0/9.0)*(f-32); 
  }
  //MAIN JUST INSTANTIATES + MAKE VISIBLE
  public static void main(String[] args) {
     Window2 g = new Window2();
     g.setVisible(true);
  }
}

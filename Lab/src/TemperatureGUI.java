import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TemperatureGUI extends JFrame {
    JTextField input;
    JLabel result;

    public TemperatureGUI() {
        setSize(350,180);
        setTitle("Temperature Converter");
        setLayout(new FlowLayout());
        input=new JTextField(10);
        JButton toC=new JButton("To Celsius");
        JButton toF=new JButton("To Fahrenheit");
        result=new JLabel("Result:");
        add(new JLabel("Enter Value:"));
        add(input);
        add(toC);
        add(toF);
        add(result);

        toC.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    double f=Double.parseDouble(input.getText());
                    double c=(f-32)*5/9;
                    result.setText("Result: "+String.format("%.2f",c)+" °C");
                }catch(Exception ex){result.setText("Invalid Input");}
            }
        });

        toF.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    double c=Double.parseDouble(input.getText());
                    double f=(c*9/5)+32;
                    result.setText("Result: "+String.format("%.2f",f)+" °F");
                }catch(Exception ex){result.setText("Invalid Input");}
            }
        });

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new TemperatureGUI();
    }
}

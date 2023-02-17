
/**
 * Create a GUI to take in user input of either celcius and fahrenheit and 
 * convert it to the opposite unit.
 *
 * @author Abigail Osborn
 * @version November 13, 2022
 */
//import nessecery classes
import javax.swing.*;
import java.awt.event.*;
import java.util.InputMismatchException;
import java.awt.Container;
import java.awt.GridLayout;
public class TemperatureConversions extends JFrame 
{
    //instantiate variables
    public static final int WIDTH = 400;
    public static final int HEIGHT = 500;
    private JLabel celcius, fahrenheit;
    private JTextField celciusF, fahrenheitF;
    private JButton calculateTempF, calculateTempC, exitTemp;
    
    //button handlers
    private CalculateButtonHandlerF ctfHandler;
    private CalculateButtonHandlerC ctcHandler;
    private ExitButtonHandler etHandler;
    /**
     * 
     * Default constructor that acts as a method for setting up
     * the JFrame.
     * 
     */
    public TemperatureConversions(){
        //intialize variables
        celcius = new JLabel("Celcius", SwingConstants.LEFT);
        fahrenheit = new JLabel("Fahrenheit", SwingConstants.LEFT);
        
        celciusF = new JTextField(10);
        fahrenheitF = new JTextField(10);
        
        calculateTempF = new JButton("Calculate");
        ctfHandler = new CalculateButtonHandlerF();
        calculateTempF.addActionListener(ctfHandler);
        
        calculateTempC = new JButton("Calculate");
        ctcHandler = new CalculateButtonHandlerC();
        calculateTempC.addActionListener(ctcHandler);
        
        exitTemp = new JButton("Exit");
        etHandler = new ExitButtonHandler();
        exitTemp.addActionListener(etHandler);
        
        //set frame title 
        setTitle("Fahrenheit Converter");
        
        //create Container
        Container pane = getContentPane();
        pane.setLayout(new GridLayout(4,2));
        
        //add buttons and text boxes to pane
        pane.add(celcius);
        pane.add(fahrenheit);
        pane.add(celciusF);
        pane.add(fahrenheitF);
        pane.add(calculateTempF);
        pane.add(calculateTempC);
        pane.add(exitTemp);
        
        //set frame's width and heigth
        setSize(WIDTH, HEIGHT);
        
        //set program to exit when user closes frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //make program visible to user
        setVisible(true);
    }
    /**
     * 
     * Class to set up ActionListener for the button that takes in fahrenheit 
     * and converts to celcius.
     * 
     */
    
    private class CalculateButtonHandlerC implements ActionListener{
        /**
         * 
         * @param e - cause event when button is pressed
         * 
         * Convert user inputted fahrenheit to celcius when calculateTempC is pressed.
         * 
         */
        public void actionPerformed(ActionEvent e){
            try{
            double fahren;
            double totalC;
            fahren = Double.parseDouble(fahrenheitF.getText());
            totalC = (fahren - 32) * (.5556);
            celciusF.setText(Double.toString(totalC));
            }
            catch(InputMismatchException excep){
                System.out.println("Test");
                JOptionPane.showMessageDialog(null, "Input must be a number.");
            }
        }
    }
    
    /**
     * 
     * Class to set up ActionListener for the button that takes in celcius
     * and converts to fahrenheit.
     * 
     */
    private class CalculateButtonHandlerF implements ActionListener{
        /**
         * 
         * @param e - cause event when button is pressed
         * 
         * Convert user inputted celcius to fahrenheit when calculateTempF is pressed.
         * 
         */
        public void actionPerformed(ActionEvent e){
            double celc;
            double totalF;
            celc = Double.parseDouble(celciusF.getText());
            totalF = (celc * 1.8) + 32;
            fahrenheitF.setText(Double.toString(totalF));
        }
    }
    /**
     * 
     * Class to set up ActionListener for the button that exits the program.
     * 
     */
    private class ExitButtonHandler implements ActionListener{
        /**
         * 
         * @param e - cause event when button is pressed
         * 
         * Exit program when the exitTemp button is pressed.
         * 
         */
        public void actionPerformed(ActionEvent e){
            System.exit(0);
        }
    }
    /**
     * 
     * Main class to call constructor
     * 
     */
    public static void main(String[] args){
        TemperatureConversions window = new TemperatureConversions();
        window.pack();
    }
}


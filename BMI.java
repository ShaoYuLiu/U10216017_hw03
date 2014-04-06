import java.awt.*;
import javax.swing.border.TitledBorder;
import javax.swing.*;
import java.awt.event.*;
public class BMI extends JFrame{
	// Create JTextField for user to input his information
	JTextField jftName = new JTextField(6);
	JTextField jftAge = new JTextField(6);
	JTextField jftHeight = new JTextField(6);
	JTextField jftWeight = new JTextField(6);
	JTextField jftResult = new JTextField(24);
	JButton jbtBMI = new JButton("ºâ¥X§AªºBMI­È");
	
	public BMI(){
	// Create a JPanel which names abc to hold the JTextField and JLabel
	JPanel abc = new JPanel(new GridLayout(5, 2));	
	abc.setBorder(new TitledBorder("Please enter your name, age,height and weight.\n"));
	abc.add(new JLabel("Your Name :"));
	abc.add(jftName);
	abc.add(new JLabel("Your Age :"));
	abc.add(jftAge);
	abc.add(new JLabel("Height :"));
	abc.add(jftHeight);
	abc.add(new JLabel("Weight :"));
	abc.add(jftWeight);
	abc.add(new JLabel("                                      "));
	abc.add(jbtBMI);
	
	// Create a JPanel which names cde to hold the button.
	JPanel cde = new JPanel(new FlowLayout(FlowLayout.RIGHT));
	cde.add(jftResult);
	// Place two JPanle in the assigned location.
	add(abc, BorderLayout.NORTH);
	add(cde, BorderLayout.CENTER);
	// set the button event that user click it.
	jbtBMI.addActionListener(new ButtonListener());
	}
	// This class define the action that user can use the button to get the result .
	class ButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e){
			// get the information users import.
			String yourname = jftName.getText();
			int yourage =  Integer.parseInt(jftHeight.getText());
			double yourheight = Double.parseDouble(jftHeight.getText());
			double yourweight = Double.parseDouble(jftWeight.getText());
			// Create a result object.
			MathBMI result = new MathBMI(yourname, yourage, yourheight,yourweight);
					
			double bmi = result.getBMI();	
			jftResult.setText(String.format("Your BMI is : %.3f",bmi));
		}
	}
	
	
	public static void main(String[] args){
		JFrame frame = new BMI();
		frame.setTitle("BMI");
		frame.setSize(300, 250);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}	
}


class MathBMI{
	  private String name;
	  private int age;
	  private double weight;
	  private double height;
	  public static final double KILOGRAMS_PER_POUND = 0.45359237;
	  public static final double METERS_PER_INCH = 0.0254;
	  
	  public MathBMI(String name , int age , double weight, double height){
		this.name = name;
		this.age  = age;
		this.weight = weight;
		this.height = height;
	  }
	  
	  public MathBMI(String name , double weight , double height){
		this(name , 20 , weight , height);  
	  }
	  
	  public double getBMI(){
		double bmi = weight * KILOGRAMS_PER_POUND / ((height * METERS_PER_INCH) * (height * METERS_PER_INCH));
		return Math.round(bmi * 100)/100.0;
	  }
	  
	  public String getStatus(){
		double bmi = getBMI();
		if(bmi < 18.5)
			return "Underweght";
		else if (bmi<25)
			return "Normal";
		else if (bmi < 30)
			return "Overweight";
		else
			return "Obese";
		
	  }
	  
	  public String getName(){
		return name;
	  }
	  
	  public int getAge(){
	   return age;
	  }

	  public double getWeight(){
	   return weight;
	  }
	  
	  public double getHeight(){
	   return height;
	  }
	  
	}

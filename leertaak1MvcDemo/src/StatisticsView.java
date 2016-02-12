import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class StatisticsView extends JPanel implements ActionListener {
    DobbelsteenModel d;
    private JLabel count = new JLabel("Aantal worpen: 0");
    private JLabel label1 = new JLabel("1:");
    private JLabel label2 = new JLabel("2:");
    private JLabel label3 = new JLabel("3:");
    private JLabel label4 = new JLabel("4:");
    private JLabel label5 = new JLabel("5:");
    private JLabel label6 = new JLabel("6:");
    private ArrayList<JLabel> labels;
    
    private int counter = 0;
    private int val1 = 0;
    private int val2 = 0;
    private int val3 = 0;
    private int val4 = 0;
    private int val5 = 0;
    private int val6 = 0;
    private ArrayList<Integer> values;
    
	public StatisticsView()
	{
		this.labels = new ArrayList<JLabel>();
		this.labels.add(count);
		this.labels.add(label1);
		this.labels.add(label2);
		this.labels.add(label3);
		this.labels.add(label4);
		this.labels.add(label5);
		this.labels.add(label6);
		
		this.values = new ArrayList<Integer>();
		this.values.add(counter);
		this.values.add(val1);
		this.values.add(val2);
		this.values.add(val3);
		this.values.add(val4);
		this.values.add(val5);
		this.values.add(val6);
			
	    this.setLayout(new GridLayout(7,2));
	    addLabelsToPanel();
	}
	
	private void addLabelsToPanel() {
		for(JLabel label: labels){ 
			this.add(label);
		}
	}

	public void actionPerformed( ActionEvent e )
	{
		//verhoog worpen teller
		counter++;
		count.setText("Aantal worpen: " + counter);
		
		//haal de source van het event op
	    d = (DobbelsteenModel) e.getSource();

	    //verhoog de value van het corresponderende getal
	    int waarde = d.getWaarde();
	    int val = values.get(waarde);
	    val++;
	    values.set(waarde, val);
	    
	    //pas de label aan dat correspondeerd aan het getal op de dobbelsteen
	    labels.get(waarde).setText(waarde + ": " + values.get(waarde));
	}
	
	public Dimension getPreferredSize()
	{
	    return new Dimension(150,50);
	} 
}

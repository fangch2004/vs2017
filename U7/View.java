import java.awt.GridLayout; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
 
import javax.swing.BorderFactory; 
import javax.swing.ButtonGroup; 
import javax.swing.ButtonModel; 
import javax.swing.JButton; 
import javax.swing.JComponent; 
import javax.swing.JFrame; 
import javax.swing.JLabel; 
import javax.swing.JList; 
import javax.swing.JPanel; 
import javax.swing.JRadioButton; 
import javax.swing.JScrollPane; 
import javax.swing.JTextField; 
 
public class View extends JComponent { 
 
  private static final long serialVersionUID = 1L; 
  public View() { 
    super(); 
    this.setBorder(BorderFactory.createEmptyBorder( 10, 10, 10, 10 
)); 
    setLayout(new GridLayout(0,1)); 
    JScrollPane scroll=new JScrollPane(); 
    String s[]={"Marmelade","Gelee"}; 
    final  JList<String> list=new JList<String>(s); 
    scroll.setViewportView(list); 
    this.add(scroll); 
//1b 
    final ButtonGroup group=new ButtonGroup(); 
    JRadioButton eins=new JRadioButton("1:1"); 
    final  JRadioButton zwei=new JRadioButton("1:2"); 
    final  JRadioButton drei=new JRadioButton("1:3"); 
    group.add(eins);group.add(zwei);group.add(drei);   
    JPanel art=new JPanel(); 
    art.add(eins);art.add(zwei);art.add(drei); 
    this.add(art); 
//bis 
    JPanel pSaft = new JPanel(); 
    JPanel pZucker = new JPanel(); 
    this.add(pSaft ); 
    this.add(pZucker); 
     
    pSaft.setLayout(new GridLayout(1,2)); 
    pSaft.add(new JLabel("Fruecht/Saft")); 
  final  JTextField saft=new JTextField("0") ; 
    pSaft.add(saft); 
    pZucker.setLayout(new GridLayout(1,2)); 
    pZucker.add(new JLabel("Gelierzucker")); 
   final  JLabel zucker=new JLabel("0"); 
    pZucker.add(zucker); 
    JButton button=new JButton("Berechnen"); 
    this.add(button); 

 
    button.addActionListener(new ActionListener(){ 
 
      @Override 
      public void actionPerformed(ActionEvent arg0) { 
        String select=list.getSelectedValue(); 
        ButtonModel selModel=group.getSelection();//1b  
        ButtonModel zweiModel=zwei.getModel();//1b 
        ButtonModel dreiModel=drei.getModel();//1b 
        if (select!=null){ 
        double mengeS=Double.parseDouble(saft.getText()); 
        double mengeZ=0; 
        if(select.equals("Marmelade")){ 
          mengeZ=mengeS; 
        }else 
          if(select.equals("Gelee")){ 
            mengeZ=mengeS*100/75; 
          } 
        if (selModel==zweiModel) mengeZ=mengeZ/2;//1b 
        if (selModel==dreiModel) mengeZ=mengeZ/3;//1b 
        zucker.setText(String.valueOf(mengeZ)); 
        } 
      } 
       
    }); 
  } 
   
  public static void main(String[] args) { 
    View objekt=new View(); 
    JFrame f=new JFrame(); 
    f.setTitle( "MarmeladenRechner" ); 
      f.setSize(300, 200); 
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
      f.getContentPane().add(objekt); 
      f.setVisible(true); 
  } 
}
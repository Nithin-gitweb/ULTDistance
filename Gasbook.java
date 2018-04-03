import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.*;
public class Gasbook extends JFrame{
 JLabel JL_fname,JL_id;
 JTextField JT_fname,JT_id;
 JButton btn_insert;
 public Gasbook(){
     super("Gas Booking System");
     JL_id = new JLabel("Customer Id:");
     JL_fname = new JLabel("Customer name:");
     JL_id.setBounds(20, 20, 100, 20);
     JL_fname.setBounds(20, 50, 100, 20);
     JT_id = new JTextField(20);
     JT_fname = new JTextField(20);
     JT_id.setBounds(130,20,150,20);
     JT_fname.setBounds(130, 50, 150, 20);
     btn_insert = new JButton("Submit");
     btn_insert.setBounds(165, 110, 80, 20);
     setLayout(null);
     add(JL_id);
     add(JL_fname);
     add(JT_id);
     add(JT_fname);
     add(btn_insert);
    btn_insert.addActionListener(new  ActionListener() {
         public void actionPerformed(ActionEvent e) {
         try{
             theQuery("insert into gasbook (Customer_name,Customer_Id) values('"+JT_fname.getText()+"',"+JT_id.getText()+")");
         }
         catch(Exception ex){}
         }
     });
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     setVisible(true);
     setLocationRelativeTo(null);
     setSize(500,200);}
public void theQuery(String query){
      Connection con = null;
      Statement st = null;
      try{
          con = DriverManager.getConnection("jdbc:mysql://localhost/test","root","Alohomo6a");
          st = con.createStatement();
          st.executeUpdate(query);
          JOptionPane.showMessageDialog(null,"Your request for LPG booking has been successfully accepted!");
      }catch(Exception ex){
          JOptionPane.showMessageDialog(null,ex.getMessage());
      }
  }
public static void main(String[] args){
    new  Gasbook(); }}
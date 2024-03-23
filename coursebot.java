//Contains Code for the AI CourseBot
import java.io.*;
import java.util.*;
import javax.swing.*;

public class coursebot{
    public static void main(String args[]){
        JFrame frame = new JFrame("CourseBot");
        JTextField chat = new JTextField(30);
        JButton enter = new JButton("enter");
        JPanel panel1 = new JPanel();
        JLabel header = new JLabel("Welcome to Coursebot!");
        JPanel panel2 = new JPanel();
        panel1.add(chat);
        panel1.add(enter);
        panel1.add(header);
        frame.add(panel2);
        frame.add(panel1);
        frame.setSize(1020,600);
        frame.show();
    }

}
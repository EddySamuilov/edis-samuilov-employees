package models;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UI implements ActionListener {
    private JFrame frame;
    private JButton button;
    private JLabel label;
    private JPanel panel;

    public UI() {
        this.frame = new JFrame();
        this.button = new JButton("Make a view");
        this.label = new JLabel("You will see a view of employees");
        this.panel = new JPanel();
    }

    public void action() {
        this.button.addActionListener(this);

        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(button);
        panel.add(label);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Data grid");
        frame.pack();
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        EmployeeViewModel employeeViewModel = new EmployeeViewModel();


    }
}

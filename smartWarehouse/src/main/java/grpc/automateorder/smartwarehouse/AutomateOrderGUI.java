package grpc.automateorder.smartwarehouse;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AutomateOrderGUI {

    private final AutomateOrderClient client;
    private final JFrame frame;
    private final JTextField itemNameField;
    private final JTextField quantityField;
    private final JTextField customerNameField;
    private final JTextArea outputArea;

    public AutomateOrderGUI() {
        // Initialize the client
        client = new AutomateOrderClient("localhost", 50092);

        // Create the JFrame and components
        frame = new JFrame("Automate Order GUI");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(3, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel itemNameLabel = new JLabel("Item Name:");
        itemNameField = new JTextField();
        JLabel quantityLabel = new JLabel("Quantity:");
        quantityField = new JTextField();
        JLabel customerNameLabel = new JLabel("Customer Name:");
        customerNameField = new JTextField();

        inputPanel.add(itemNameLabel);
        inputPanel.add(itemNameField);
        inputPanel.add(quantityLabel);
        inputPanel.add(quantityField);
        inputPanel.add(customerNameLabel);
        inputPanel.add(customerNameField);

        JButton makeOrderButton = new JButton("Make Order");
        JButton stopOrderButton = new JButton("Stop Order");
        JButton streamOrderStatusButton = new JButton("Stream Order Status");

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 3, 10, 10));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        buttonPanel.add(makeOrderButton);
        buttonPanel.add(stopOrderButton);
        buttonPanel.add(streamOrderStatusButton);

        outputArea = new JTextArea(10, 20);
        outputArea.setEditable(false);
        JScrollPane outputScrollPane = new JScrollPane(outputArea);

        // Add the components to the JFrame
        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.add(outputScrollPane, BorderLayout.SOUTH);

        // Add action listeners to the buttons
        makeOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String itemName = itemNameField.getText();
                int quantity = Integer.parseInt(quantityField.getText());
                String customerName = customerNameField.getText();
                String confirmation = client.makeOrder(itemName, quantity, customerName);
                outputArea.append(confirmation + "\n");
            }
        });

        stopOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String itemName = itemNameField.getText();
                int quantity = Integer.parseInt(quantityField.getText());
                String customerName = customerNameField.getText();
                client.stopOrder(itemName, quantity, customerName);
                outputArea.append("Order stop confirmation received\n" );
            }
        });

        streamOrderStatusButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                String itemName = itemNameField.getText();
                int quantity = Integer.parseInt(quantityField.getText());
                String customerName = customerNameField.getText();
                try {
                    client.streamOrderStatus(itemName, quantity, customerName);
                    outputArea.append("Order status streaming completed\n");
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                    outputArea.append("Error in streaming order status\n");
                }
            }
        });
        
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                AutomateOrderGUI gui = new AutomateOrderGUI();
                gui.frame.setVisible(true);
            }
        });
    }
}


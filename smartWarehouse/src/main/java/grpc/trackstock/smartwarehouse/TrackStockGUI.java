package grpc.trackstock.smartwarehouse;

import javax.swing.*;


import io.grpc.stub.StreamObserver;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrackStockGUI {

	private final TrackStockClient client;
    private final JFrame frame;
    private final JTextField itemField;
    private final JTextField quantityField;
    private final JButton addButton;
    private final JButton removeButton;
    private final JButton listButton;
    private final JTextArea outputArea;

    public TrackStockGUI() {
        // Initialize the client
        client = new TrackStockClient("localhost", 50054);

        // Create the JFrame and components
        frame = new JFrame("Track Stock GUI");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(2, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel itemLabel = new JLabel("Item:");
        itemField = new JTextField();
        JLabel quantityLabel = new JLabel("Quantity:");
        quantityField = new JTextField();

        inputPanel.add(itemLabel);
        inputPanel.add(itemField);
        inputPanel.add(quantityLabel);
        inputPanel.add(quantityField);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 3, 10, 10));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        addButton = new JButton("Add Item");
        removeButton = new JButton("Remove Item");
        listButton = new JButton("List Items");

        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(listButton);

        outputArea = new JTextArea();
        outputArea.setEditable(false);

        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.add(new JScrollPane(outputArea), BorderLayout.SOUTH);

        addActionListeners();
    }

    

    private void addActionListeners() {
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addItem();
            }
        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeItem();
            }
        });

        listButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listItems();
            }
        });
    }

    
    private void addItem() {
        String itemName = itemField.getText();
        int itemQuantity = Integer.parseInt(quantityField.getText());
        StockItem item = StockItem.newBuilder().setName(itemName).setQuantity(itemQuantity).build();

        client.addItem(item, new StreamObserver<Confirmation>() {
            @Override
            public void onNext(Confirmation confirmation) {
                System.out.println(confirmation);
                JOptionPane.showMessageDialog(frame, confirmation.getMessage());
            }
            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }

            @Override
            public void onCompleted() {
                System.out.println("Add Item completed");
            }
        });
    }

    private void removeItem() {
        String itemName = itemField.getText();
        int itemQuantity = Integer.parseInt(quantityField.getText());
        StockItem item = StockItem.newBuilder().setName(itemName).setQuantity(itemQuantity).build();

        client.removeItem(item, new StreamObserver<Confirmation>() {
            @Override
            public void onNext(Confirmation confirmation) {
                System.out.println(confirmation);
                JOptionPane.showMessageDialog(frame, confirmation.getMessage());
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }

            @Override
            public void onCompleted() {
                System.out.println("Remove Item completed");
            }
        });
    }

    private void listItems() {
        int numItems = Integer.parseInt(quantityField.getText());

        client.listItems(numItems, new StreamObserver<StockItem>() {
            @Override
            public void onNext(StockItem stockItem) {
                System.out.println("Item: " + stockItem.getName() + ", Quantity: " + stockItem.getQuantity());
                JOptionPane.showMessageDialog(frame, "Item: " + stockItem.getName() + ", Quantity: " + stockItem.getQuantity());
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }

            @Override
            public void onCompleted() {
                System.out.println("List Items completed");
            }
        });
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	TrackStockGUI gui = new TrackStockGUI();
                gui.frame.setVisible(true);
            }
        });
    }
}

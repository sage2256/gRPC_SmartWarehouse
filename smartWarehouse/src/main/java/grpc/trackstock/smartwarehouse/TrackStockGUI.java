package grpc.trackstock.smartwarehouse;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;
import javax.swing.*;


import io.grpc.stub.StreamObserver;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;

public class TrackStockGUI {
	// Declare necessary class variables
	private final TrackStockClient client;
    private final JFrame frame;
    private final JTextField itemField;
    private final JTextField quantityField;
    private final JButton addButton;
    private final JButton removeButton;
    private final JButton listButton;
    private final JTextArea outputArea;
    static String host = "_order._tcp.local.";
    static int port;
    static String resolvedIP;

    public TrackStockGUI() {
    	testJMDNS();
        // Initialize the client
        client = new TrackStockClient("localhost", 50054);

        // Create the JFrame and components
        frame = new JFrame("Track Stock GUI");// initialize JFrame
        frame.setSize(600, 400);// set size of JFrame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// set default close operation
        frame.setLayout(new BorderLayout());// set layout of JFrame to BorderLayout


        JPanel inputPanel = new JPanel(); // initialize JPanel
        inputPanel.setLayout(new GridLayout(2, 2, 10, 10));// set layout of inputPanel to GridLayout
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));// set border of inputPanel

        JLabel itemLabel = new JLabel("Item:");// initialize JLabel for item name
        itemField = new JTextField();//initialize field for text to be inputed
        JLabel quantityLabel = new JLabel("Quantity:");// initialize JLabel for item quantity
        quantityField = new JTextField();//initialize field for text to be inputed
        
        // Add input fields to input panel
        inputPanel.add(itemLabel);
        inputPanel.add(itemField);
        inputPanel.add(quantityLabel);
        inputPanel.add(quantityField);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 3, 10, 10));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        addButton = new JButton("Add Item");//initialize button for adding items
        removeButton = new JButton("Remove Item");//initialize button for removing items
        listButton = new JButton("List Items");//initialize button to list items
        
        // Add buttons to button panel
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(listButton);

        outputArea = new JTextArea();//initialize output area
        outputArea.setEditable(false);//make output area uneditable
        
        // Add panels and text area to frame
        frame.add(inputPanel, BorderLayout.NORTH);//add input panel to the frame
        frame.add(buttonPanel, BorderLayout.CENTER);//add button panel to frame
        frame.add(new JScrollPane(outputArea), BorderLayout.SOUTH);//add scrolling to frame

        addActionListeners();//syntax to call the action listener methods
    }

    

    private void addActionListeners() {// declaring the action listener method
        addButton.addActionListener(new ActionListener() {//action listener for the add button
            @Override
            public void actionPerformed(ActionEvent e) {
                addItem();//addItem method to be implemented when action listener button is activated
            }
        });

        removeButton.addActionListener(new ActionListener() {// action listener for the remove button
            @Override
            public void actionPerformed(ActionEvent e) {
                removeItem();//remove item method to be implemented when the remove item button is activated
            }
        });

        listButton.addActionListener(new ActionListener() {//action listener for the remove button
            @Override
            public void actionPerformed(ActionEvent e) {
                listItems();//liste item method to be implemented when the list item button is activated
            }
        });
    }

    
    private void addItem() {// additem method
        String itemName = itemField.getText();//get the item name from the text field
        int itemQuantity = Integer.parseInt(quantityField.getText());// get the item quantity from the text field
        StockItem item = StockItem.newBuilder().setName(itemName).setQuantity(itemQuantity).build();

        client.addItem(item, new StreamObserver<Confirmation>() { // call addItem method from TrackStockClient with parameters
            @Override
            public void onNext(Confirmation confirmation) {
                System.out.println(confirmation);
                JOptionPane.showMessageDialog(frame, confirmation.getMessage());
            }
            @Override
            public void onError(Throwable throwable) {//when things dont go as planned
                throwable.printStackTrace();
            }

            @Override
            public void onCompleted() {//oncompleted method when things go as planned
                System.out.println("Add Item completed");
            }
        });
    }

    private void removeItem() {//remove item method
        String itemName = itemField.getText();//get the item name from the text field
        int itemQuantity = Integer.parseInt(quantityField.getText());//get the item quantity from the text field
        StockItem item = StockItem.newBuilder().setName(itemName).setQuantity(itemQuantity).build();

        client.removeItem(item, new StreamObserver<Confirmation>() { // call removeItem method from TrackStockClient with parameters
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

        client.listItems(numItems, new StreamObserver<StockItem>() { // call listItem method from TrackStockClient with parameters
            @Override
            public void onNext(StockItem stockItem) {//onNextMethod
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
    public static void main(String[] args) {//main method
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	TrackStockGUI gui = new TrackStockGUI();//initialize the TrackStockGUI
                gui.frame.setVisible(true);
            }
        });
    }
    
    private static class SampleListener implements ServiceListener {
		public void serviceAdded(ServiceEvent event) {
			System.out.println("Service added: " + event.getInfo());
		}
		public void serviceRemoved(ServiceEvent event) {
			System.out.println("Service removed: " + event.getInfo());
		}
		@SuppressWarnings("deprecation")
		public void serviceResolved(ServiceEvent event) {
					System.out.println("Service resolved: " + event.getInfo());

                    ServiceInfo info = event.getInfo();
                    port = info.getPort();
                    resolvedIP = info.getHostAddress();
                    System.out.println("IP Resolved - " + resolvedIP + ":" + port);
		}
    }
    
	public static void testJMDNS() {
			try {
				
				JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
				jmdns.addServiceListener(host, new SampleListener());
	            Thread.sleep(20000);

			} catch (Exception e) {
				System.out.println(e.getMessage());
		}
	}
    
}

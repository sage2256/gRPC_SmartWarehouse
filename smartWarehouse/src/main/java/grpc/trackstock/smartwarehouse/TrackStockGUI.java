package grpc.trackstock.smartwarehouse;

import javax.swing.*;
import java.awt.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class TrackStockGUI extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int PORT = 50054;
    private static TrackStockServiceGrpc.TrackStockServiceStub stub;
    private JPanel mainPanel;
    private JButton addItemButton;
    private JButton removeItemButton;
    private JButton listItemsButton;

    public TrackStockGUI() {
        setTitle("Track Stock Client");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(3, 1));

        addItemButton = new JButton("Add Item");
        addItemButton.addActionListener(e -> addItem());

        removeItemButton = new JButton("Remove Item");
        removeItemButton.addActionListener(e -> removeItem());

        listItemsButton = new JButton("List Items");
        listItemsButton.addActionListener(e -> listItems());

        mainPanel.add(addItemButton);
        mainPanel.add(removeItemButton);
        mainPanel.add(listItemsButton);

        add(mainPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", PORT).usePlaintext().build();
        stub = TrackStockServiceGrpc.newStub(channel);
        new TrackStockGUI();
    }

    public void addItem() {
        StreamObserver<Confirmation> responseObserver = new StreamObserver<Confirmation>() {
            @Override
            public void onNext(Confirmation value) {
                JOptionPane.showMessageDialog(mainPanel, "Add Item Response: " + value.getMessage());
            }

            @Override
            public void onError(Throwable t) {
                JOptionPane.showMessageDialog(mainPanel, "Error: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                JOptionPane.showMessageDialog(mainPanel, "Add Item Request completed");
            }
        };

        StockItem item = StockItem.newBuilder().setId(1).setName("Item 1").setQuantity(10).build();
        stub.add(item, responseObserver);
    }

    public void removeItem() {
        StreamObserver<Confirmation> responseObserver = new StreamObserver<Confirmation>() {
            @Override
            public void onNext(Confirmation value) {
                JOptionPane.showMessageDialog(mainPanel, "Remove Item Response: " + value.getMessage());
            }

            @Override
            public void onError(Throwable t) {
                JOptionPane.showMessageDialog(mainPanel, "Error: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                JOptionPane.showMessageDialog(mainPanel, "Remove Item Request completed");
            }
        };

        StockItem item = StockItem.newBuilder().setId(1).setName("Item 1").setQuantity(10).build();
        stub.remove(item, responseObserver);
    }

    public void listItems() {
        StreamObserver<StockItem> responseObserver = new StreamObserver<StockItem>() {
            @Override
            public void onNext(StockItem value) {
                JOptionPane.showMessageDialog(mainPanel, "List Item Response: " + value.getName() + ", " + value.getQuantity());
            }

            @Override
            public void onError(Throwable t) {
                JOptionPane.showMessageDialog(mainPanel, "Error: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                JOptionPane.showMessageDialog(mainPanel, "List Item Request completed");
            }
        };

        ListRequest request = ListRequest.newBuilder().setListItems(10).build();
        stub.list(request, responseObserver);
    }
}

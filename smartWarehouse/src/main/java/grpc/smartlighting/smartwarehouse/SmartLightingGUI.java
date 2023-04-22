package grpc.smartlighting.smartwarehouse;

import javax.swing.*;

import grpc.trackstock.smartwarehouse.TrackStockGUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SmartLightingGUI {

    private final SmartLightingClient client;
    private final JFrame frame;
    private final JTextField brightnessInput;
    private final JButton brightnessButton;
    private final JButton occupiedButton;
    private final JButton unoccupiedButton;
    private final JButton turnOnButton;
    private final JButton turnOffButton;

    public SmartLightingGUI() {
        client = new SmartLightingClient("localhost", 50053);

        frame = new JFrame("Smart Lighting");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(3, 1));

        JPanel brightnessPanel = new JPanel();
        brightnessPanel.setBorder(BorderFactory.createTitledBorder("Brightness"));
        brightnessInput = new JTextField(10);
        brightnessButton = new JButton("Adjust");
        brightnessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    float level = Float.parseFloat(brightnessInput.getText());
                    client.brightness(level);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid brightness level", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        brightnessPanel.add(brightnessInput);
        brightnessPanel.add(brightnessButton);
        frame.add(brightnessPanel);

        JPanel switchPanel = new JPanel();
        switchPanel.setBorder(BorderFactory.createTitledBorder("Switch"));
        occupiedButton = new JButton("Occupied");
        occupiedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                client.switchLight(true);
            }
        });
        unoccupiedButton = new JButton("Unoccupied");
        unoccupiedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                client.switchLight(false);
            }
        });
        switchPanel.add(occupiedButton);
        switchPanel.add(unoccupiedButton);
        frame.add(switchPanel);

        JPanel remotePanel = new JPanel();
        remotePanel.setBorder(BorderFactory.createTitledBorder("Remote"));
        turnOnButton = new JButton("Turn On");
        turnOnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                client.remote(true);
            }
        });
        turnOffButton = new JButton("Turn Off");
        turnOffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                client.remote(false);
            }
        });
        remotePanel.add(turnOnButton);
        remotePanel.add(turnOffButton);
        frame.add(remotePanel);

       // frame.setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	SmartLightingGUI gui = new SmartLightingGUI();
                gui.frame.setVisible(true);
            }
        });
    }
   
}

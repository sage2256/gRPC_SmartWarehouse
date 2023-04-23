package grpc.smartlighting.smartwarehouse;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;

public class SmartLightingGUI {

    private final SmartLightingClient client;
    private final JFrame frame;
    private final JTextField brightnessInput;
    private final JButton brightnessButton;
    private final JButton occupiedButton;
    private final JButton unoccupiedButton;
    private final JButton turnOnButton;
    private final JButton turnOffButton;
    static String host = "_lighting._tcp.local.";
    static int port;
    static String resolvedIP;
    public SmartLightingGUI() {
    	testJMDNS();
    	
        client = new SmartLightingClient(resolvedIP, port);

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

      
        
        
        
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	SmartLightingGUI gui = new SmartLightingGUI();
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
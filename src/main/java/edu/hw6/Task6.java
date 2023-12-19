package edu.hw6;

import edu.hw1.Pair;
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Task6 {
    private final static int COUNT_OF_PORTS = 49151;
    private final static Map<Integer, String> PORT_TCP_INFORMATION = Map.<Integer, String>ofEntries(
        Map.entry(135, "EPMAP"),
        Map.entry(139, "Служба сеансов NetBIOS"),
        Map.entry(445, "Microsoft-DS Active Directory"),
        Map.entry(843, "Adobe Flash"),
        Map.entry(17500, "Dropbox")
    );
    private final static Map<Integer, String> PORT_UDP_INFORMATION = Map.<Integer, String>ofEntries(
        Map.entry(137, "Служба имен NetBIOS"),
        Map.entry(138, "Служба датаграмм NetBIOS"),
        Map.entry(1900, "Simple Service Discovery Protocol (SSDP)"),
        Map.entry(3702, "Динамическое обнаружение веб-служб"),
        Map.entry(5353, "Многоадресный DNS")
    );

    private Task6() {

    }

    static Pair<List<Integer>, List<Integer>> scanningPorts() throws IOException {
        ArrayList<Integer> busyTCPPorts = new ArrayList<>();
        ArrayList<Integer> busyUDPPorts = new ArrayList<>();

        for (int port = 0; port <= COUNT_OF_PORTS; ++port) {
            try (ServerSocket serverSocket = new ServerSocket(port)) {
                serverSocket.close();
            } catch (IOException e) {
                busyTCPPorts.add(port);
            }

            try (DatagramSocket datagramSocket = new DatagramSocket(port)) {
                datagramSocket.close();
            } catch (IOException e) {
                busyUDPPorts.add(port);
            }
        }

        return new Pair<>(busyTCPPorts, busyUDPPorts);
    }

    static String portInformation(int port) {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            serverSocket.close();
        } catch (IOException e) {
            return "TCP " + port + " " + PORT_TCP_INFORMATION.getOrDefault(port, "");
        }

        try (DatagramSocket datagramSocket = new DatagramSocket(port)) {
            datagramSocket.close();
        } catch (IOException e) {
            return "UDP " + port + " " + PORT_UDP_INFORMATION.getOrDefault(port, "");
        }

        return "Open port";
    }
}

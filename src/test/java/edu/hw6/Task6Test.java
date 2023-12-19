package edu.hw6;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.io.IOException;
import java.net.ServerSocket;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class Task6Test {
    static Arguments[] portsTCPWithExpectedName() {
        return new Arguments[] {
            Arguments.of(
                135, "TCP 135 EPMAP"
            ),
            Arguments.of(
                139, "TCP 139 Служба сеансов NetBIOS"
            ),
            Arguments.of(
                445, "TCP 445 Microsoft-DS Active Directory"
            ),
            Arguments.of(
                17500, "Dropbox"
            ),
        };
    }

    static Arguments[] portsUDPWithExpectedName() {
        return new Arguments[] {
            Arguments.of(
                1900, "UDP 1900 Simple Service Discovery Protocol (SSDP)"
            ),
            Arguments.of(
                3702, "UDP 3702 Динамическое обнаружение веб-служб"
            ),
            Arguments.of(
                5353, "UDP 5353 Многоадресный DNS"
            ),
        };
    }

    @ParameterizedTest
    @MethodSource("portsTCPWithExpectedName")
    void givenTCPPortWhenCheckThatItsOpenThenReturnNameOfPortBorrower(int port, String expectedAnswer) {
        String actualAnswer = Task6.portInformation(port);

        if (actualAnswer.equals("Open port")) {
            assertTrue(true);
            return;
        }

        assertThat(actualAnswer).isEqualTo(expectedAnswer);
    }

    @ParameterizedTest
    @MethodSource("portsUDPWithExpectedName")
    void givenUDPPortWhenCheckThatItsOpenThenReturnNameOfPortBorrower(int port, String expectedAnswer) {
        String actualAnswer = Task6.portInformation(port);

        if (actualAnswer.equals("Open port")) {
            assertTrue(true);
            return;
        }

        assertThat(actualAnswer).isEqualTo(expectedAnswer);
    }

    static Arguments[] openPorts(){
        return new Arguments[]{
            Arguments.of(152),
            Arguments.of(243),
            Arguments.of(856),
            Arguments.of(2362),
            Arguments.of(325)
        };
    }

    @ParameterizedTest
    @MethodSource("openPorts")
    void givenClosedPortWhenCheckingThatHeIsCloseThenDontReturnOpenPort(
        int port
    ){
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            boolean isClose = !Task6.portInformation(port).equals("Open port");

            serverSocket.close();
            assertTrue(isClose);
        } catch (IOException e) {
            fail();
        }
    }
}

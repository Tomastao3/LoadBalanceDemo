import com.demo.eas.EASServer;
import com.demo.elb.ELBServer;
import com.demo.mock.MockHttpRequest;

import java.io.IOException;

public class DemoPortal {
    public static void commandExplain() {
        System.out.println("Hello world!");
        StringBuilder explains = new StringBuilder();
        explains.append("Welcome to distributed system,here are the commands you can execute:\n")
                .append("1 Start elb with default random load balance rule")
                .append("\n")
                .append("2 Start 3 eas instance with appEngine configured")
                .append("\n")
                .append("3 Kill one EAS instance randomly(this is called Monkey in Chaos Engineering)")
                .append("\n")
                .append("4 Start one new eas instance")
                .append("\n")
                .append("5 Change load balance rule of elb")
                .append("\n")
                .append("6 Show status of elb and available eas services")
                .append("\n")
                .append("7 Send a customer request to ELB,and display the output from the AppEngin")
                .append("\n")
                .append("8 Exit the system")
                .append("\n")
                .append("input command:");
        System.out.printf(explains.toString());
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        commandExplain();

        ELBServer elbServer = null;
        long count = 0;
        while (true) {
            char input = (char) System.in.read();
            if (input == 10 ) continue;
            if (input == '1') {
                elbServer = ELBServer.getRandomInstance();
                MockHttpRequest.setElbServer(elbServer);
                System.out.printf("ELBServer has started\n");
                System.out.printf("input command:");
            } else if (input == '2') {
                MockHttpRequest.easServerRegister(new EASServer("server1" ));
                MockHttpRequest.easServerRegister(new EASServer("server2"));
                MockHttpRequest.easServerRegister(new EASServer("server3"));
                System.out.printf("3 of EASServer has started\n");
                System.out.printf("input command:");
            } else if (input == '3') {
                elbServer.moveServerRandom();
                System.out.printf("1 of new EASServer was killed\n");
                System.out.printf("input command:");
            } else if (input == '4') {
                MockHttpRequest.easServerRegister(new EASServer("server"));
                System.out.printf("1 of new EASServer has started\n");
                System.out.printf("input command:");
            } else if (input == '5') {
                if(elbServer == null) continue;
                if(ELBServer.ROUND_ROBIN_STRTAGY == elbServer.getStrategy() ){
                  elbServer.setStrategy(ELBServer.RANDOM_STRTAGY);
                  System.out.printf("balance trategy change to Random\n");
                }
                else{
                    elbServer.setStrategy(ELBServer.ROUND_ROBIN_STRTAGY);
                    System.out.printf("balance trategy change to RoundRobin\n");
                }
                System.out.printf("input command:");
            } else if (input == '6') {
                elbServer.showStatus();
                System.out.printf("input command:");
            } else if (input == '7') {
                MockHttpRequest.customerRequest();
            }
            else if (input == '8') {
                break;
            }
        }
    }

}
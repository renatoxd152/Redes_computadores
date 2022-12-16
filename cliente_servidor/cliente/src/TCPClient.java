import java.io.*;
import java.net.*;
import java.sql.SQLOutput;
import java.util.Scanner;

public class TCPClient {

    public static void main(String argv[]) throws Exception {

        int porta = 1234;

        String ip = "127.0.0.1";

        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

        /* Estabele conexao com o servidor */
        Socket conexao = new Socket(ip, porta);
        System.out.println("Conectado! " + conexao);
        /**

         * ******************************************************

         */
        double num1,num2;
        char operador;
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite os números:");
        num1 = entrada.nextDouble();
        num2 = entrada.nextDouble();
        System.out.println("Digite a operação que deseja fazer:");
        operador = entrada.next().charAt(0);
        /* Estabelece fluxos de entrada e saida */

        DataOutputStream fluxoSaida = new DataOutputStream(conexao.getOutputStream());

        DataInputStream fluxoEntrada = new DataInputStream(new BufferedInputStream(conexao.getInputStream()));

        fluxoSaida.writeChar(operador);
        fluxoSaida.writeDouble(num1);
        fluxoSaida.writeDouble(num2);
        fluxoSaida.flush();


        double soma = fluxoEntrada.readDouble();
        System.out.println("O resultado da operação é:" + soma);

        fluxoEntrada.close();
        fluxoSaida.close();
        conexao.close();

    }

}

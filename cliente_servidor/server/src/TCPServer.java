import java.io.*;
import java.net.*;
import java.util.Scanner;

public class TCPServer {
    public static void main(String[] args) throws Exception {
        /* Registra servico na porta 1234 e aguarda por conexoes */


        ServerSocket servidor = new ServerSocket(1234);

        System.out.println("Aguardando por conexoes");

        Socket conexao = servidor.accept();

        System.out.println("Cliente conectou " + conexao);

        /**

         * ******************************************************

         */

        /* Estabelece fluxos de entrada e saida */

        double num1,num2;
        double soma = 0.0;
        char op = '\n';
        char operacao;
        DataInputStream fluxoEntrada = new DataInputStream(new BufferedInputStream(conexao.getInputStream()));

        DataOutputStream fluxoSaida = new DataOutputStream(conexao.getOutputStream());

        operacao = fluxoEntrada.readChar();
        num1 = fluxoEntrada.readDouble();
        num2 = fluxoEntrada.readDouble();
        soma = num1 + num2;

        if(operacao == '+')
        {
            op = '+';
            soma = (num1 + num2);

        }
        else if(operacao == '-')
        {
            op = '-';
            soma = (num1 - num2);
        }
        else if(operacao == '/')
        {
            op = '/';
            soma = (num1/num2);
        }
        else
        {
            op = '*';
            soma = (num1*num2);
        }

        fluxoSaida.writeDouble(soma);
        fluxoSaida.flush();


        fluxoSaida.close();
        fluxoEntrada.close();
        servidor.close();

    }



}




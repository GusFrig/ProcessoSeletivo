import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static Scanner leia = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        String[] candidatos = {"João", "Maria", "Pedro", "Ana", "Carlos"};
        for (String candidato : candidatos) {
            entrarEmContato(candidato);
        }
    }

    static void entrarEmContato(String candidato) {
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;
        do {
            atendeu = atender();
            continuarTentando = !atendeu;
            if (continuarTentando) {
                tentativasRealizadas++;
            } else {
                System.out.println("Contato realizado com sucesso");
            }
        } while (continuarTentando && tentativasRealizadas < 3);

        if (atendeu) {
            System.out.println("conseguimos contato com " + candidato + " na " + tentativasRealizadas + " tentativas");
            } else {
                System.out.println("Não conseguimos entrar em contato com o candidato: " + candidato + ", máximo de tentativas alcançadas " );
            }
    }

    static boolean atender() {
        return new Random().nextInt(3) == 1;
    }


    static void imprimirCandidatosSelecionados() {
        String [] candidatos = {"João", "Maria", "Pedro", "Ana", "Carlos"};

        System.out.println("Imprimindo a lista de candidatos com base no indices dos mesmos");

        for (int indice = 0; indice < candidatos.length; indice++) {
            System.out.println("o candidato de Número: " + (indice + 1) + " é o: " + candidatos[indice]);
        }
    }

    //Método de seleção de candidatos baseado no salário pretendindo pelo mesmo, como também, o valor que a empresa está disposta a pagar. Com isso em mente, serãoi selecionados até 5 funcionários que atendam aos requesitos propostos(salário ideal etc).
    static void selecaoCandidatos() {
        String[] candidatos = {"João", "Maria", "Pedro", "Ana", "Carlos", "Beatriz", "Fernando", "Gabriela", "Rafael", "Isabela"};


        int candidatosselecionados = 0;
        int candidatoatual = 0;
        double salariobase = 2000.0;
        while (candidatosselecionados < 5 && candidatoatual < candidatos.length) {
            String candidato = candidatos[candidatoatual];
            double salarioPretendido = valorPretendido();

            System.out.println("O candidato " + candidato + " solicitou este salário: " + salarioPretendido);
            if (salariobase >= salarioPretendido) {
                candidatosselecionados++;
            } else {
                System.out.println("Candidato não foi selecionado");
            }
            candidatoatual++;
        }

        System.out.println("foram selcionados " + candidatosselecionados + " candidatos");


    }
    static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }
    static void analisarCandidato(double salarioPretendido) {
        double salariobase = 2000.0;
        if (salariobase > salarioPretendido) {
            System.out.println("LIgar para o candidato");
        } else if (salariobase == salarioPretendido) {
            System.out.println("Ligar para o candidato com contra proposta");
        } else {
            System.out.println("Aguardando resposta");
        }
    }
    }


package minutosRestantesLPD7;
//Debe solicitar al usuario un día de la semana (de lunes a viernes).
//Debe solicitar al usuario una hora (horas y minutos).
//Debe calcular cuantos minutos faltan para el fin de semana. Se considera que el fin de semana comienza el viernes a las 15:00 hrs.

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] dias= {"lunes","martes","miercoles","jueves","viernes"};
        String dia;
        int hora;
        int minutos;

        while (true) {
            System.out.print("Introduce un día de lunes a viernes");
            dia = sc.nextLine().toLowerCase().trim();
            int diaNumerico=obtenerDiaNumerico(dias,dia);
            if (diaNumerico == -1) { 
                System.out.println("Día inválido. Por favor, introduce un día válido.");
                continue;
            }

            System.out.print("Introduce la hora 0-23");
            if (!sc.hasNextInt() || (hora=sc.nextInt())<0 || hora>23) {
                System.out.println("Hora inválida. Por favor, introduce un número válido.");
                sc.nextLine();
                continue;
            }
            System.out.print("Introduce los minutos 0-59 ");
            if (!sc.hasNextInt()|| (minutos=sc.nextInt())<0 || minutos>59) {
                System.out.println("Minutos inválidos. Por favor, introduce un número válido.");
                sc.nextLine();
                continue;
            }
            sc.nextLine();
            int minutosRestantes = calcularMinutosRestantes(diaNumerico, hora, minutos);
            if (minutosRestantes >= 0) {
                System.out.println("Faltan " + minutosRestantes + " minutos para el fin de semana.");
                break;
            }
        }
        sc.close();
    }

    public static int obtenerDiaNumerico(String[]dias, String dia) {
        for(int i=0; i<dias.length; i++) {
        	if (dias[i].equals(dia)) return i;
        }
        return -1;
    }
    public static int calcularMinutosRestantes(int dia,int hora,int minutos) {
    	int minutosFinDeSemana=4*24*60+15*60;
    	int minutosActuales=dia*24*60 + hora*60 + minutos;
    	return minutosFinDeSemana-minutosActuales;
    }
}

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Input {
    public static void imprimirErrorInputGenerico() {
        System.out.println("Input inválido. Ingrese un valor correcto.");
    }

    public static int leerEntero(Scanner scanner, String prompt) {
        while(true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                imprimirErrorInputGenerico();
            }
        }
    }

    public static int leerEnteroEntre(Scanner scanner, String prompt, int start, int end) {
        while(true) {
            try {
                System.out.print(prompt);
                int input =  Integer.parseInt(scanner.nextLine());
                
                if (input < start || input > end) {
                    System.out.println("Input debe ser un número entre " + start + " y " + end + ".");
                    continue;
                }

                return input;
            } catch (NumberFormatException e) {
                imprimirErrorInputGenerico();
            }
        }
    }

    public static String leerString(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().strip();

            if (input.length() == 0) {
                imprimirErrorInputGenerico();
                continue;
            }

            return input;
        }
    }

    public static LocalDate leerFecha(Scanner scanner, String prompt) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        while(true) {
            try {
                System.out.print(prompt);
                return LocalDate.parse(scanner.nextLine(), formatter);
            } catch (DateTimeParseException e) {
                System.out.println("Input inválido. Ingrese una fecha válida (dd-mm-yyyy).");
            }
        }
    }

    // Float
    public static float leerFloat(Scanner scanner, String prompt) {
        while(true) {
            try {
                System.out.print(prompt);
                return Float.parseFloat(scanner.nextLine());
            } catch (NumberFormatException e) {
                imprimirErrorInputGenerico();
            }
        }
    }
}

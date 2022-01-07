package journey;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Input {
    public static void imprimirErrorInputGenerico() {
        System.out.println("Input inválido. Ingrese un valor correcto.");
    }

    public static int leerEntero(Scanner scanner, String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                imprimirErrorInputGenerico();
            }
        }
    }

    public static int leerEnteroNoNegativo(Scanner scanner, String prompt) {
        int input = 0;

        while (true) {
            input = leerEntero(scanner, prompt);

            if (input >= 0)
                break;

            System.out.println("Ingrese un entero no-negativo.");
        }

        return input;
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
        while(true) {
            try {
                System.out.print(prompt);
                return LocalDate.parse(scanner.nextLine(), Constantes.DATE_FORMATTER);
            } catch (DateTimeParseException e) {
                System.out.println("Input inválido. Ingrese una fecha válida (dd-mm-yyyy).");
            }
        }
    }

    public static LocalDate leerFechaNoFutura(Scanner scanner, String prompt) {
        LocalDate fecha = null;

        while(true) {
            fecha = leerFecha(scanner, prompt);

            if (fecha.isBefore(LocalDate.now()))
                break;

            System.out.println("Ingrese una fecha pasada.");
        }

        return fecha;
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

    public static float leerFloatPositivo(Scanner scanner, String prompt) {
        float input = 0;

        while (true) {
            input = leerFloat(scanner, prompt);

            if (input > 0)
                break;

            System.out.println("Ingrese un valor positivo.");
        }

        return input;
    }

    // Iterable
    public static <T> T leerArrayListOpciones(Scanner scanner, String prompt, ArrayList<T> opciones) {
        StringBuilder completePrompt = new StringBuilder();

        // Generate options.
        int i = 1;
        for (T value : opciones) {
            completePrompt.append(i + ". " + value + "\n");
            i++;
        }

        completePrompt.append(prompt);

        int inputInt = Input.leerEnteroEntre(scanner, completePrompt.toString(), 1, opciones.size());

        return opciones.get(inputInt - 1);
    }

    // Enum
    public static <E extends Enum<E>> E leerEnum(Scanner scanner, String prompt, Class<E> enumClass) {
        ArrayList<E> constants = new ArrayList<>();
        Collections.addAll(constants, enumClass.getEnumConstants());

        return leerArrayListOpciones(scanner, prompt, constants);
    }
}

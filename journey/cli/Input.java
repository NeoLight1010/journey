package journey.cli;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.function.Predicate;

import journey.Constantes;

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

    public static String leerStringValidado(Scanner scanner, String prompt, Predicate<String> validador, String mensajeError) {
        String input = null;

        while (true) {
            input = leerString(scanner, prompt);

            if (validador.test(input))
                break;

            System.out.println(mensajeError);
        }

        return input;
    }

    /**Lee un texto y valida que no contenga caracteres que no sean letras.*/
    public static String leerAlfa(Scanner scanner, String prompt, String mensajeError) {
        Predicate<String> validador = (str) -> {
            for (var c : str.toCharArray()) {
                if (!Character.isLetter(c))
                    return false;
            }

            return true;
        };

        return leerStringValidado(scanner, prompt, validador, mensajeError);
    }

    /**Lee un texto y valida que corresponda a un número celular de Ecuador.
     *
     * Debe comenzar en 09 y tener 10 dígitos en total.*/
    public static String leerNumeroCelular(Scanner scanner, String prompt) {
        Predicate<String> validador = (str) -> {
            if (str.charAt(0) != '0' || str.charAt(1) != '9')
                return false;

            if (str.length() != 10)
                return false;

            for (var c : str.toCharArray()) {
                if (!Character.isDigit(c))
                    return false;
            }

            return true;
        };

        return leerStringValidado(scanner, prompt, validador, "Número celular inválido. Asegúrese que sea de Ecuador, comience en 09, y tenga 10 dígitos en total.");
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

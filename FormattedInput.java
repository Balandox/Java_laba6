import java.io.IOException;
import java.util.*;


public class FormattedInput {

    public static Object[] scanf(String format){
        while(true) {

            try {
                System.out.print("Enter symbols " + format + ": ");
                Scanner scanner = new Scanner(System.in);
                String str = scanner.nextLine();
                Object[] vals = sscanf(format, str);
                scanner.close();
                return vals;
            }
            catch (InputMismatchException exception) {
                System.out.println(exception.getMessage());
                //exception.printStackTrace();
                System.out.println();
            }

        }
    }


    public static Object[] sscanf(String format, String in){
        Scanner scanner = new Scanner(in);
        scanner.useLocale(Locale.UK);
        ArrayList<Object> vals = new ArrayList<>();

        while (scanner.hasNext()) {
            for (int i = 0; i < format.length(); ) {

                if (format.startsWith("%d", i)) {
                    if (scanner.hasNextInt()) {
                        vals.add(scanner.nextInt());
                        i += "%d".length();
                    }
                    else
                        throw new InputMismatchException("Incorrect value");

                }

                if (format.startsWith("%f", i)) {
                    if (scanner.hasNextDouble()) {
                        vals.add(scanner.nextDouble());
                        i += "%f".length();
                    }
                    else
                        throw new InputMismatchException("Incorrect value");
                }

                if (format.startsWith("%s", i)) {
                    if (scanner.hasNextLine()) {
                        vals.add(scanner.next());
                        i += "%s".length();
                    }

                }

                if (format.startsWith("%c", i)) {
                    if (scanner.hasNext()) {
                            vals.add(scanner.next().charAt(0));
                            i += "%c".length();
                    }

                    else
                        throw new InputMismatchException("Incorrect value");
                }
                else
                    i++;
            }
        }

        scanner.close();
        return vals.toArray();
    }
}

package utils;

import types.AppointmentStatus;
import types.Gender;

import javax.swing.text.DateFormatter;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class InputUtils {
    private final Scanner scanner = new Scanner(System.in);

    private final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public DateTimeFormatter getDateFormat() {
        return dateFormat;
    }

    private String defaultHint(Object defaultValue) {
        return "[" + defaultValue + "] (Enter to skip) ";
    }

    public String inputString(String prompt) {
        while (true) {
            System.out.print(prompt);
            String val = scanner.nextLine().trim();
            if(!val.isEmpty()) {
                return val;
            }
            System.out.println("input is empty!");
        }
    }

    public String inputString(String prompt,int min,int max) {
        while (true) {
            String val = inputString(prompt);
            if(!(val.length() < min || val.length() > max)) {
                return val;
            }
            System.out.println("input must be between " + min + " and " + max);
        }
    }

    public int inputInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Enter a valid number");
            }
        }
    }

    public int inputInt(String prompt,int min,int max) {
        while (true) {
            int val = inputInt(prompt);
            if(val >= min && val <= max) {
                return val;
            }
            System.out.println("input must be between " + min + " and " + max);
        }
    }

    public long inputLong(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Long.parseLong(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Enter a valid number");
            }
        }
    }

    public Gender inputGender() {
        System.out.println("=====Choice Gender=====");
        System.out.println("= 1.Man               =");
        System.out.println("= 2.Woman             =");
        System.out.println("=======================");
        while (true) {
            int val = inputInt("choice: ");
            switch (val) {
                case 1 :
                    return Gender.man;
                case 2:
                    return Gender.woman;
                default:
                    System.out.println("not valid value!");
            }
        }
    }

    public LocalDate inputDate() {
        while (true) {
            System.out.print("input date (dd-MM-yyyy): ");
            try {
                return LocalDate.parse(scanner.nextLine().trim(),this.dateFormat);
            } catch (DateTimeException e) {
                System.out.println("wrong format date!");
            }
        }
    }

    // ===== WITH DEFAULT VALUE =====

    public String inputString(String prompt, String defaultValue) {
        System.out.print(prompt + this.defaultHint(defaultValue));
        String val = scanner.nextLine().trim();
        if (val.isEmpty()) {
            return defaultValue;
        }
        return val;
    }

    public String inputString(String prompt, String defaultValue, int min, int max) {
        while (true) {
            System.out.print(prompt + this.defaultHint(defaultValue));
            String val = scanner.nextLine().trim();
            if (val.isEmpty()) {
                return defaultValue;
            }
            if (!(val.length() < min || val.length() > max)) {
                return val;
            }
            System.out.println("input must be between " + min + " and " + max);
        }
    }

    public int inputInt(String prompt, int defaultValue) {
        while (true) {
            System.out.print(prompt + this.defaultHint(defaultValue));
            String val = scanner.nextLine().trim();
            if (val.isEmpty()) {
                return defaultValue;
            }
            try {
                return Integer.parseInt(val);
            } catch (NumberFormatException e) {
                System.out.println("Enter a valid number");
            }
        }
    }

    public int inputInt(String prompt,int defaultValue,int min,int max) {
        while (true) {
            System.out.print(prompt + this.defaultHint(defaultValue));
            String val = scanner.nextLine().trim();
            if(val.isEmpty()) {
                return  defaultValue;
            }
            try {
                int valInt = Integer.parseInt(val);

                if(valInt >= min && valInt <= max) {
                    return valInt;
                }
            } catch (NumberFormatException e) {
                System.out.println("Enter a valid number");
            }

            System.out.println("input must be between " + min + " and " + max);
        }
    }

    public long inputLong(String prompt, long defaultValue) {
        while (true) {
            System.out.print(prompt + this.defaultHint(defaultValue));
            String val = scanner.nextLine().trim();
            if (val.isEmpty()) {
                return defaultValue;
            }
            try {
                return Long.parseLong(val);
            } catch (NumberFormatException e) {
                System.out.println("Enter a valid number");
            }
        }
    }

    public Gender inputGender(Gender defaultValue) {
        System.out.println("=====Choice Gender=====");
        System.out.println("= 1.Man               =");
        System.out.println("= 2.Woman             =");
        System.out.println("=======================");
        while (true) {
            System.out.print("choice " + this.defaultHint(defaultValue));
            String val = scanner.nextLine().trim();
            if (val.isEmpty()) {
                return defaultValue;
            }
            switch (val) {
                case "1":
                    return Gender.man;
                case "2":
                    return Gender.woman;
                default:
                    System.out.println("not valid value!");
            }
        }
    }

    public LocalDate inputDate(LocalDate defaultValue) {
        while (true) {
            System.out.print("input date (dd-MM-yyyy) " + this.defaultHint(defaultValue.format(this.dateFormat)));
            String val = scanner.nextLine().trim();
            if (val.isEmpty()) {
                return defaultValue;
            }
            try {
                return LocalDate.parse(val,this.dateFormat);
            } catch (DateTimeException e) {
                System.out.println("wrong format date!");
            }
        }
    }

    public AppointmentStatus inputStatus(AppointmentStatus defaultValue) {
        System.out.println("=====Choice Status=====");
        System.out.println("= 1.waiting           =");
        System.out.println("= 2.finished          =");
        System.out.println("= 3.canceled          =");
        System.out.println("=======================");
        while (true) {
            System.out.print("choice " + this.defaultHint(defaultValue));
            String val = scanner.nextLine().trim();
            if (val.isEmpty()) {
                return defaultValue;
            }
            switch (val) {
                case "1":
                    return AppointmentStatus.waiting;
                case "2":
                    return AppointmentStatus.finished;
                case "3":
                    return AppointmentStatus.canceled;
                default:
                    System.out.println("not valid value!");
            }
        }
    }

}

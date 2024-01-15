public class CalendarPrinter {

    /**
     * Prints the calendar for the specified month and year.
     *
     * @param m The month (1-12).
     * @param y The year.
     */
    public static void printMonth(int m, int y) {
        // Determine the days in the month
        int[] daysInMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        // Check for a leap year
        if ((y % 4 == 0 && y % 100 != 0) || (y % 400 == 0)) {
            daysInMonth[2] = 29;
        }

        // Determine the day of the week for the first day of the month
        int dayOfWeek = (1 + (13 * (m + 1)) / 5 + y + y / 4 - y / 100 + y / 400) % 7;

        // Print the header
        System.out.println("Mon Tue Wed Thu Fri Sat Sun");

        // Print empty cells before the start of the month
        for (int i = 0; i < dayOfWeek; i++) {
            System.out.print("   ");
        }

        // Fill the calendar with days
        for (int day = 1; day <= daysInMonth[m]; day++) {
            System.out.printf("%2d ", day);

            // Move to a new line after Sunday
            if ((day + dayOfWeek) % 7 == 0) {
                System.out.println();
            }
        }

        // Move to a new line at the end of the month if needed
        if ((daysInMonth[m] + dayOfWeek) % 7 != 0) {
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Example usage:
        int month = 1;  // replace with the desired month
        int year = 2023;  // replace with the desired year
        printMonth(month, year);
    }
}

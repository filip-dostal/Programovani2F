package lekce201;

import java.util.Calendar;

//dd

public class CalendarTest {
    public static void main(String[] args) {
        Calendar birth = Calendar.getInstance();
        birth.set(2025, Calendar.SEPTEMBER, 21, 17, 3, 40);

        Calendar now = Calendar.getInstance();

        int[] timeDifference = calculateTimeDifference(birth, now);

        boolean isFuture = birth.after(now);

        if (isFuture) {
            System.out.print("Zbývá: ");
        } else {
            System.out.print("Uplynulo: ");
        }
        System.out.println(
                timeDifference[0] + " let, " +
                        timeDifference[1] + " měsíců, " +
                        timeDifference[2] + " dnů, " +
                        timeDifference[3] + " hodin, " +
                        timeDifference[4] + " minut, " +
                        timeDifference[5] + " sekund."
        );

        if (!isFuture) {
            Calendar nextAnniversary = (Calendar) birth.clone();
            nextAnniversary.set(Calendar.YEAR, now.get(Calendar.YEAR));

            if (now.after(nextAnniversary)) {
                nextAnniversary.set(Calendar.YEAR, now.get(Calendar.YEAR) + 1);
            }

            timeDifference = calculateTimeDifference(now, nextAnniversary);
            System.out.printf("Vaše výročí je: " + nextAnniversary.getTime() + "\n");

            System.out.print("Zbývá: ");
            System.out.println(
                    timeDifference[0] + " let, " +
                            timeDifference[1] + " měsíců, " +
                            timeDifference[2] + " dnů, " +
                            timeDifference[3] + " hodin, " +
                            timeDifference[4] + " minut, " +
                            timeDifference[5] + " sekund."
            );
        }
    }

    private static int[] calculateTimeDifference(Calendar calendar1, Calendar calendar2) {
        // Work with clones to avoid modifying input
        Calendar c1 = (Calendar) calendar1.clone();
        Calendar c2 = (Calendar) calendar2.clone();

        boolean isFuture = c1.after(c2);

        Calendar past = isFuture ? c2 : c1;
        Calendar future = isFuture ? c1 : c2;

        int years = future.get(Calendar.YEAR) - past.get(Calendar.YEAR);
        int months = future.get(Calendar.MONTH) - past.get(Calendar.MONTH);
        int days = future.get(Calendar.DAY_OF_MONTH) - past.get(Calendar.DAY_OF_MONTH);
        int hours = future.get(Calendar.HOUR_OF_DAY) - past.get(Calendar.HOUR_OF_DAY);
        int minutes = future.get(Calendar.MINUTE) - past.get(Calendar.MINUTE);
        int seconds = future.get(Calendar.SECOND) - past.get(Calendar.SECOND);

        if (seconds < 0) {
            minutes--;
            seconds += 60;
        }
        if (minutes < 0) {
            hours--;
            minutes += 60;
        }
        if (hours < 0) {
            days--;
            hours += 24;
        }
        if (days < 0) {
            months--;
            Calendar temp = (Calendar) future.clone();
            temp.add(Calendar.MONTH, -1);
            days += temp.getActualMaximum(Calendar.DAY_OF_MONTH);
        }
        if (months < 0) {
            years--;
            months += 12;
        }

        return new int[]{years, months, days, hours, minutes, seconds};
    }
}
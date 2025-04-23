package util;

import domain.LinkedListStack;
import domain.ArraysStack;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Calendar;

public class Utility {

    private static final Random random;
    private static ArraysStack employeeList;
    private static LinkedListStack jobPositionList;
    private static LinkedListStack staffingList;

    //constructor estático, inicializador estático
    static {
        // semilla para el random
        long seed = System.currentTimeMillis();
        random = new Random(seed);

    }

    public static ArraysStack getEmployeeList() {
        return employeeList;
    }

    public static void setEmployeeList(ArraysStack employeeList) {
        Utility.employeeList = employeeList;
    }

    public static LinkedListStack getJobPositionList() {
        return jobPositionList;
    }

    public static void setJobPositionList(LinkedListStack jobPositionList) {
        Utility.jobPositionList = jobPositionList;
    }

    public static LinkedListStack getStaffingList() {
        return staffingList;
    }

    public static void setStaffingList(LinkedListStack staffingList) {
        Utility.staffingList = staffingList;
    }

    // ------------------------------------------------------------- Métodos:
    public static int random(int bound){
        // return(int) Math.floor(Math.random()*bound); //Forma 1
        return 1+random.nextInt(bound);
    }

    public static void fill(int[] a) {
        for (int i = 0; i < a.length; i++){
            a[i] = random(99);
        }
    }

    public static String format(long n) {
        return new DecimalFormat("###,###,###.##").format(n); //Establecer un formato para n
    }

    public static String format(double n) {
        return new DecimalFormat("###,###,###.##").format(n); //Establecer un formato para n
    }

    public static String $format(double n) {
        return new DecimalFormat("$###,###,###.##").format(n); //Establecer un formato para n
    }

    public static int min(int x, int y) {
        return x<y ? x : y;
    }

    public static int max(int x, int y) {
        return x>y ? x : y;
    }

    public static String show(int[] a) {
        String result ="";
        for (int item : a){
            if (item == 0) break; //si es cero es porque no hay más elementos
            result+=item + " ";
        }//End for
        return result;
    }



    public static String dateFormat(Date value) {
        return new SimpleDateFormat("dd/MM/yyyy").format(value);
    }//End dateFormat

    public static Date parseDate(String dateStr) { //Convierte de String a Date
        SimpleDateFormat fechaFormateada = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return fechaFormateada.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static int getAge(Date date) {
        Calendar calendarBD = Calendar.getInstance();
        calendarBD.setTime(date);

        Calendar calendarToday = Calendar.getInstance();

        int age = calendarToday.get(Calendar.YEAR) - calendarBD.get(Calendar.YEAR); //Se resta el año actual al año de nacimiento y da la edad

        //Si el cumpleaños todavía no ocurre
        if (calendarToday.get(Calendar.DAY_OF_YEAR) < calendarBD.get(Calendar.DAY_OF_YEAR)) {
            age--;
        }

        return age;
    }
}
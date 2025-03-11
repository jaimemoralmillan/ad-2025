package com.digitechfp.curso_ad;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        System.out.println(factorial(5));        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
        }
        tiposDeDatos();
        stringBuilder();
        tiposEnum();
        colecciones();
        mapas();
        conjuntos();
        colas();
        pilas();
        expresionesRegulares();
        IPoligono circulo = new Circulo(200, 200, 50);
        System.out.println("Circulo area:"+circulo.area());
        System.out.println("Circulo perimetro:"+circulo.perimetro());
        IPoligono rectangulo = new Rectangulo(200, 200, 50, 100);
        System.out.println("Rectangulo area:"+rectangulo.area());
        System.out.println("Rectangulo perimetro:"+rectangulo.perimetro());
        Frame frame = new Frame(rectangulo);
        frame.setVisible(true);
        Frame frame2 = new Frame(circulo);
        frame2.setVisible(true);
        Caja<Integer> entero = new Caja<>(5);
        System.out.println(entero.getContenido());
        Caja<String> cadena = new Caja<>("Hola");
        System.out.println(cadena.getContenido());
        Caja<Double> decimal = new Caja<>(5.5);
        System.out.println(decimal.getContenido());
        System.out.println("El factorial de 5 es "+factorial(5).toString());
    }

    public static Integer factorial (Integer n) {
        return (n == 0) ? 1 : n * factorial(n - 1);
    }

    public static Integer factorial2 (Integer n) {
        Integer resultado = 1;
        for (int i = 1; i <= n; i++) {
            resultado *= i;
        }
        return resultado;
    }
    public static Integer factorial3 (Integer n) {
        var resultado = (n==0) ? 1 : n * factorial3(n - 1);
        return resultado;
    }

    public static void tiposDeDatos() {
        byte _byte = 1;         // 1 bytes. Números de -128 a 127;
        short _short = 2;       // 2 bytes. Números de -32768 a 32767;
        int _int = 3;           // 4 bytes. Números de -2147483648 a 2147483647i
        long _long = 4L;        // 8 bytes. Números de -2^63 hasta 2^63 - 1.
        float _float = 5.0f;    // 4 bytes. Números decimales con 6 a 7 dígitos decimales.
        double _double = 6.0;   // 8 bytes. Números decimales con 15 dígitos decimales.
        char _char = 'A';       // 2 bytes. Almacena un caracter.
        boolean _boolean = true;// 1 bit.
        Byte byteObj = 1;         // Objeto de tipo Byte.
        String _string = "Hello";
        // Los string no admiten sobrecarga de ==. Se usa equals.
        if (_string == "Hola") {
            System.out.println("Hello");
        }
        System.out.println("Equal:"+_string.equals("Hola"));
        System.out.println("Compare:"+_string.compareTo("Hola"));
    }
    public static void stringBuilder() {
        StringBuilder stringBuilder = new StringBuilder("Hola");
        stringBuilder.append(" Mundo!!");
        System.out.println(stringBuilder.toString());
    }

    public static void tiposEnum () {
        enum Dias {
            LUNES, MARTES, MIERCOLES, JUEVES, VIERNES, SABADO, DOMINGO;
            static boolean finDeSemana (Dias dia) {
                return (dia == SABADO || dia == DOMINGO);
            }
            Dias restarDias(int dias) {
                int ordinalActual = this.ordinal();
                int nuevoOrdinal = (ordinalActual - dias) % Dias.values().length;
                if (nuevoOrdinal < 0) {
                    nuevoOrdinal += Dias.values().length;
                }
                return Dias.values()[nuevoOrdinal];
            }
        }
        Dias lunes = Dias.LUNES;
        System.out.println(lunes);
        if (!Dias.finDeSemana(lunes)) {
            System.out.println ("A currar!");
        }
        Dias dia2 = lunes.restarDias(-3);
        System.out.println(dia2);
        Dias dia3 = lunes.restarDias(3);
        System.out.println(dia3);

    }

    public static void colecciones () {
        var arrayList = new ArrayList<>();
        System.out.println(arrayList.hashCode());
        arrayList.add("Hola");
        arrayList.add(" Mundo!!");
        System.out.println(arrayList);
        List<Integer> lista = new LinkedList<>();
        lista.add(3);
        lista.add(2);
        lista.add(1);
        System.out.println(lista);
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i));
        }
        for (Integer i : lista) {
            System.out.println(i);
        }
        ListIterator<Integer> it = lista.listIterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        List<Integer> vector = new Vector<>(Arrays.asList(1,2, 3));
        System.out.println("vector:"+vector);

    }

    public static void mapas () {
//        Use HashMap for fast access without order.
//        Use TreeMap for sorted keys.
//        Use LinkedHashMap for maintaining insertion or access order.
        System.out.println("mapas");
        Map<String, Integer> mapa = new HashMap<>();
        mapa.put("uno", 1);
        mapa.put("dos", 2);
        mapa.put("tres", 3);
        System.out.println(mapa);
        System.out.println(mapa.get("dos"));
        System.out.println(mapa.containsKey("dos"));
        System.out.println(mapa.containsValue(2));
        System.out.println(mapa.keySet());
        System.out.println(mapa.values());
        for (String key : mapa.keySet()) {
            System.out.println(key + ":" + mapa.get(key));
        }
        for (Map.Entry<String, Integer> entry : mapa.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        System.out.println("TreeMap");
        Map<String, Integer> mapa2 = new TreeMap<>();
        mapa2.put("tres", 3);
        mapa2.put("dos", 2);
        mapa2.put("uno", 1);
        System.out.println(mapa2);
        System.out.println("LinkedHashMap");
        Map<String, Integer> mapa3 = new LinkedHashMap<>();
        mapa3.put("tres", 3);
        mapa3.put("dos", 2);
        mapa3.put("uno", 1);
        System.out.println(mapa3);
    }
    public static void conjuntos () {
        Set<Integer> conjunto = new HashSet<>();
        conjunto.add(1);
        conjunto.add(2);
        conjunto.add(3);
        System.out.println(conjunto);
        System.out.println(conjunto.contains(2));
        System.out.println(conjunto.contains(4));
        System.out.println(conjunto.remove(2));
        System.out.println(conjunto);
        System.out.println(conjunto.remove(4));
        System.out.println(conjunto);
        Set<Integer> conjunto2 = new TreeSet<>();
        conjunto2.add(3);
        conjunto2.add(2);
        conjunto2.add(1);
        System.out.println(conjunto2);
        Set<Integer> conjunto3 = new LinkedHashSet<>();
        conjunto3.add(3);
        conjunto3.add(2);
        conjunto3.add(1);
        System.out.println(conjunto3);
    }
    public static void colas() {
        Queue<Integer> cola = new LinkedList<>();
        cola.add(1);
        cola.add(2);
        cola.add(3);
        System.out.println(cola);
        System.out.println(cola.poll());
        System.out.println(cola);
        System.out.println(cola.peek());
        System.out.println(cola);
    }

    public static void pilas() {
        Stack<Integer> pila = new Stack<>();
        pila.push(1);
        pila.push(2);
        pila.push(3);
        System.out.println(pila);
        System.out.println(pila.pop());
        System.out.println(pila);
        System.out.println(pila.peek());
        System.out.println(pila);
    }
    public static void expresionesRegulares() {
        // https://regex101.com/
        String regex = "^[A-Z][a-z]+\\s[A-Z][a-z]+$";
        String nombre = "Juan Perez";
        System.out.println(nombre.matches(regex));
        String regex2 = "^[A-Z][a-z]+\\s[A-Z][a-z]+\\s\\d{2}$";
        String nombre2 = "Juan Perez 23";
        System.out.println(nombre2.matches(regex2));

        Pattern pattern = Pattern.compile("^[0-9]{5}$");
        System.out.println(pattern.matcher("12345").matches());

        String logEntry = "2023-10-15 14:23:45 [INFO] Application started successfully.";

        // Regular expression with capture groups for date, time, and log level
        String regex3 = "^(\\d{4}-\\d{2}-\\d{2})\\s(\\d{2}:\\d{2}:\\d{2})\\s\\[(\\w+)].*$";
        Pattern pattern3 = Pattern.compile(regex3);
        Matcher matcher = pattern3.matcher(logEntry);

        if (matcher.matches()) {
            String date = matcher.group(1);
            String time = matcher.group(2);
            String logLevel = matcher.group(3);

            System.out.println("Date: " + date);
            System.out.println("Time: " + time);
            System.out.println("Log Level: " + logLevel);
        } else {
            System.out.println("No match found.");
        }
    }
}
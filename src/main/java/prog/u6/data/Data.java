package prog.u6.data;

import java.util.StringTokenizer;

public class Data {

    private int dia;

    private int mes;

    private int any;

    private static final String[] DIES_TEXT = new String[]{"diumenge", "dilluns", "dimarts", "dimecres", "dijous", "divendres",
        "dissabte"};

    private static final String[] MESOS_TEXT = new String[]{"gener", "febrer", "març", "abril", "maig", "juny",
        "juliol", "agost", "setembre", "octubre", "novembre", "desembre"};

    /**
     * Constructor por defecto Inicializa una fecha a dia 1-1-1970
     */
    public Data() {
        this(1, 1, 1970);
    }

    /**
     * Inicializa la fecha
     *
     * @param dia de la semana
     * @param mes del año
     * @param anyo
     */
    public Data(int dia, int mes, int any) {
        this.dia = dia;
        this.mes = mes;
        this.any = any;
    }

    /**
     * Inicializa la fecha a partir de otra pasada en formato String dd/mm/yyyy
     *
     * Deberemos trocearlas de forma que asignemos el día més y año a cada uno
     * de los atributoe Tienes que utilizar las funciones de *String o consultar
     * la documentación oficial y hacerlo OBLIGATORIAMENTE con la clase
     * StringTokenizer. Si el formato recibido no es el correcto, creará la
     * fecha por defecto.
     *
     * @param fecha
     */
    public Data(String data) {
        StringTokenizer dataToken = new StringTokenizer(data, "/");
        if(dataToken.countTokens() == 3) {
            this.dia = Integer.parseInt(dataToken.nextToken());
            this.mes = Integer.parseInt(dataToken.nextToken());
            this.any = Integer.parseInt(dataToken.nextToken());
        } else {
            this.dia = 1;
            this.mes = 1;
            this.any = 1970;
        }
    }

    /**
     * Modifica la fecha actual a partir de los datos pasados como argumento
     */
    public void set(int dia, int mes, int anyo) {
        this.dia = dia;
        this.mes = mes;
        this.any = anyo;
    }

    /**
     * Obtiene una fecha con los mismos atributos que la fecha actual
     *
     * @return
     */
    public Data clone() {
        return new Data(this.dia, this.mes, this.any);
    }

    /**
     * Devuelve el día de la semana que representa por la Fecha actual
     *
     * @return @dia
     */
    public int getDia() {
        return this.dia;
    }

    /**
     * Devuelve el mes que representa la Fecha actual
     *
     * @return @mes
     */
    public int getMes() {
        return this.mes;
    }

    /**
     * Devuelve el año que representa la Fecha actual
     *
     * @return @año
     */
    public int getAny() {
        return this.any;
    }

    /**
     * Muestra por pantalla la fecha en formato español dd-mm-yyyy
     */
    public void mostrarEnFormatES() {
        System.out.printf("%02d-%02d-%04d\n", this.dia, this.mes, this.any);
    }

    /**
     * Muestra por pantalla la fecha en formato inglés yyyy-mm-dd
     */
    public void mostrarEnFormatGB() {
        System.out.printf("%04d-%02d-%02d\n", this.any, this.mes, this.dia);
    }

    /**
     * Muestra por pantalla la fecha en formato texto dd-mmmm-yyyy Ej. 1 enero
     * de 1970
     */
    public void mostrarEnFormatText() {
        System.out.printf("%02d-%s-%04d\n", this.dia, getMesEnFormatText(), this.any);
    }

    /**
     * Retorna un booleano indicando si la fecha del objeto es igual a la fecha
     * pasada como argumento
     *
     * @return boolean
     */
    public boolean isIgual(Data otraFecha) {
        if (this.dia != otraFecha.getDia()) {
            return false;
        } else if (this.mes != otraFecha.getMes()) {
            return false;
        } else if (this.any != otraFecha.getAny()) {
            return false;
        }
        return true;
    }

    /**
     * Retorna un String que representa el dia de la setmana en format text
     * (dilluns, dimarts, dimecres, dijous, divendres, dissabte, diumenge).
     * L'algorisme de resolució d'aquest mètode es troba al enunciat.
     *
     * @return String
     */
    public String getDiaSetmana() {
        return DIES_TEXT[getDiesTranscorregutsOrigen() % 7];
    }

    /**
     * Retorna un booleà indicant si la data representada per l'objecte actual
     * és festiva. Es considerarà festiu si el dia de la setmana és dissabte o
     * diumenge
     *
     * @return boolean
     */
    public boolean isFestiu() {
        int dia = getDiesTranscorregutsOrigen() % 7;
        return (dia == 0 || dia == 6);
    }

    /**
     * Retorna el número de la setmana dins de l'any actual. Es considera una
     * setmana l'interval de dates entre una data que siga dilluns i la següent
     * data en ordre cronològic que siga diumenge. També es comptabilitza com a
     * setmana tant la primera setmana de l'any com l'última (inclusivament en
     * aquells anys en què la primera i/o última setmana no conté set dies en
     * total).
     *
     * @return int dia semana
     */
    public int getNumeroSetmana() {
        Data diaUno = new Data(1, 1, this.any);
        
        int diaSemana = diaUno.getDiesTranscorregutsOrigen() % 7;
        int diasAnyo = (diaSemana == 0) ? getDiesTranscorregutsEnAny() + 6 : getDiesTranscorregutsEnAny() + diaSemana - 1;
        
        int semana = (int) Math.ceil(diasAnyo / 7.0);
        
        return semana;
    }
    
    private int verificarNumDias (int numDias) {
        if (numDias > 30) {
            return 30;
        } else if (numDias < 1) {
            return 1;
        }
        return numDias;
    }

    /**
     * Retorna un nou objecte de tipus data que representa la data resultant
     * d'afegir el nombre de dies passats com a argument a la data que
     * representa l'objecte actual. Haurem de tindre en compte els dies que té
     * el mes actual i si l'any és de traspàs (bisiesto) amb la finalitat de
     * construir el nou objecte amb la data correcta. El màxim nombre de dies
     * que podrem afegir serà 30 i no podrem afegir un nombre negatiu de dies.
     *
     * @return boolean
     */
    public Data afegir(int numDias) {
        
        int dia = this.dia;
        int mes = this.mes;
        int any = this.any;
        int diasMes;
        
        numDias = verificarNumDias(numDias);
        dia += numDias;
        
        while (dia > (diasMes = getDiesMes(mes, any))) {            
            dia -= diasMes;
            mes++;
            if (mes > 12) {
                mes = 1;
                any++;
            }
        }
        
        return new Data(dia, mes, any);
    }

    /**
     * Retorna un nou objecte de tipus data que representa la data resultant de
     * restar el nombre de dies passats com a argument a la data que representa
     * l'objecte actual. Haurem de tindre en compte els dies que té el mes
     * actual i si l'any és de traspàs (bisiesto) amb la finalitat de construir
     * el nou objecte amb la data correcta. El màxim nombre de dies que podrem
     * restar serà 30 i no podrem restar un nombre negatiu de dies.
     *
     * @return boolean
     */
    public Data restar(int numDias) {
        int dia = this.dia;
        int mes = this.mes;
        int any = this.any;
        
        numDias = verificarNumDias(numDias);
        dia -= numDias;
        
        while (dia < 1) {
            mes--;
            if (mes < 1) {
                mes = 12;
                any--;
            }
            dia += getDiesMes(mes, any);
        }
        
        return new Data(dia, mes, any);
    }

    /**
     * Retorna un booleà indicant si la data representada per l'objecte actual
     * és correcta. No oblides comprovar que el dia es trobe dins del rang dels
     * dies que té el mes tenint en compte si l'any és de traspàs(bisiesto) o
     * no.
     *
     * @return
     */
    public boolean isCorrecta() {
        if (this.any < 1) {
            return false;
        } else if (this.mes < 1 || this.mes > 12) {
            return false;
        } else if (this.dia < 0 || this.dia > getDiesMes(this.mes, this.any)) {
            return false;
        }
        return true;
    }

    /**
     * Retorna el mes del año en formato text (enero, febrero, marzo,...)
     *
     * @return char
     */
    private String getMesEnFormatText() {
        return MESOS_TEXT[this.mes - 1];
    }

    /**
     * Devuelve el número de dias transcurridos desde el 1-1-1
     *
     * @return int
     */
    private int getDiesTranscorregutsOrigen() {
        int dias = this.dia;
        
        for (int i = 1; i < this.any; i++) {
            dias += getDiesAny(i);
        }
        
        for (int i = 1; i < this.mes; i++) {
            dias += getDiesMes(i, this.any);
        }
        
        return dias;
    }

    /**
     * Devuelve el número de dias transcurridos en el anyo que representa el
     * objeto
     *
     * @return int
     */
    private int getDiesTranscorregutsEnAny() {
        int dias = this.dia;
        
        for (int i = 1; i < this.mes; i++) {
            dias += getDiesMes(i, this.any);
        }
        return dias;
    }

    /**
     * Indica si el año pasado como argumento es bisiesto. Un año es bisiesto si
     * es divisible por 4 pero no es divisible entre 100 o es divisible entre 4
     * entre 100 y entre 400
     *
     * @return boolean
     */
    public static boolean isBisiesto(int anyo) {
        return ((anyo % 4 == 0) && (anyo % 100 != 0)) || ((anyo % 4 == 0) && (anyo % 100 == 0) && (anyo % 400 == 0));
    }

    /**
     * Calcula el número de días que tiene el @mes en el @año pasado como
     * argumento Deberás hacer uso del métodos isBisiesto
     *
     * @return int total dias mes en curso
     */
    public static int getDiesMes(int mes, int anyo) {
        if ((mes < 8 && mes % 2 != 0) || (mes > 7) && mes % 2 == 0) {
            return 31;
        } else if (mes == 2 && isBisiesto(anyo)) {
            return 29;
        } else if (mes == 2) {
            return 28;
        }
        return 30;
    }

    /**
     * Calcula el número total de dias que tiene el año pasado como argumento
     *
     * @return int total dias anyo en curso
     */
    public static int getDiesAny(int anyo) {
        return (isBisiesto(anyo)) ? 366 : 365;
    }
}

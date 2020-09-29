import java.sql.*;
import java.io.*;
import java.util.*;
import com.mysql.cj.jdbc.MysqlDataSource;

// TODO Sustituya las NNNNNNNN por su nombre completo y las XXXXXXXX por su matricula
// en las clausulas @author del siguiente comentario Javadoc

/**
 Esta clase demuestra el uso de DataSource para acceder a la base de datos
 controlconcursos_ad2020 para colocar datos en tres tablas
 @author  NNNNNNNN
 @author  XXXXXXXX
 */
public class PonDatosConDataSource {
    private int idConcurso;
    private ArrayList<Integer> idSedes;

    // TODO Sustituir las XXX en los valores de los siguientes atributos por su matricula
    private final String nomSede = "sede_XXX";
    private final String nomConcurso = "concurso_XXX";
    private final String nomSedeConcurso = "sede_concurso_XXX";
    private final String nomtablas[] =
            { nomSede, nomConcurso, nomSedeConcurso };

    /**
     * Metodo principal de la clase que recibe la direccion del servidor,
     * nombre de la base de datos, usuario y clave; datos necesarios para
     * hacer la conexion con MySQL
     * @param args Arreglo con los 4 argumentos necesarios para poder ejecutar el programa
     */
    public static void main(String args[]){
        int tipo=15;
        if (args.length < 4) {
            System.out.println(
                    "Uso: java PonDatosConDataSource"
                            + " dirServidor nombreBaseDatos cuenta password");
            System.exit(1);
        }
        // ESTE IF ES PARA LAS PRUEBAS, IGNORAR
        if (args.length>=5) {
            try {
                tipo=Integer.parseInt(args[4]);
            }
            catch (NumberFormatException exnum) { }
        }
        PonDatosConDataSource creador = new PonDatosConDataSource();
        Connection con=null;
        try{
            // Cargar el driver de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = creador.creaConexion(args[0], args[1], args[2], args[3]);
        }
        catch(ClassNotFoundException e){
            System.err.print("No se encontro la clase solicitada: ");
            System.err.println(e.getMessage());
        } catch (SQLException esql) {
            // SI NO SE PUDO CREAR LA CONEXION SE DA LA EXCEPCION SQLException
            System.err.println("Error al crear conexion a MySQL: "
                    + esql.getMessage());
            System.exit(1);
        }
        if ((tipo&1)!=0) {
            if (con instanceof Connection) {
                System.out.println("Conexion a MySQL exitosa!");
            }
        }
        creador.idSedes = new ArrayList<>();
        if ((tipo&2)!=0) {
            creador.llenaTablaSede(con);
        }
        else {
            creador.idSedes.add(1); creador.idSedes.add(2);
        }
        if ((tipo&4)!=0) {
            creador.llenaTablaConcurso(con);
        }
        else {
            creador.idConcurso=1;
        }
        if ((tipo&8)!=0) {
            creador.llenaTablaSedeConcurso(con);
        }

        // TODO Sustituir NNNNNNNNN por su nombre completo
        System.out.println("PRACTICA DE NNNNNNNNN");
    }

    /**
     * Este metodo crea la conexion a MySQL con los datos recibidos
     * @param direccionServidor  String que representa direccion del servidor
     * @param nomBD  String con el nombre de la base de datos a utilizar
     * @param usuario String con el usuario a usar para conectarse
     * @param clave  String con la clave a usar para conectarse
     * @return  Objeto Connection que representa la conexion con MySQL
     * @throws SQLException  En caso de no poder crearse la conexion
     */
    public Connection creaConexion(String direccionServidor,
                                   String nomBD, String usuario,
                                   String clave)
            throws SQLException {
        // TODO Completar el codigo de creaConexion
        return null; // TODO: Esta linea se elimina una vez que coloque el codigo real
    }

    /**
     * Metodo que coloca datos en la tabla sede
     * Los datos son tomados del archivo datosSede.txt
     * NOTA: El codigo demuestra el funcionamiento de un objeto ResultSet
     * actualizable y como se puede obtener el valor
     * de un campo autoincrementable despues de agregar el registro
     * @param con Objeto Connection que representa la conexion a MySQL
     */
    public void llenaTablaSede(Connection con) {
        // TODO Completar el codigo del metodo llenaTablaSede

    } // fin del metodo llenaTablaSede()

    /**
     * Metodo que coloca datos en la tabla concurso
     * NOTA: El codigo demuestra como se puede obtener el valor
     * de un campo autoincrementable despues de agregar el registro
     * @param con Objeto Connection que representa la conexion a MySQL
     */    
    public void llenaTablaConcurso(Connection con) {
        // TODO Completar el codigo del metodo llenaTablaConcurso

    }  // fin del metodo llenaTablaConcurso()

    /**
     * Metodo que coloca datos en la tabla sede_concurso
     * @param con Objeto Connection que representa la conexion a MySQL
     */
    public void llenaTablaSedeConcurso(Connection con) {
        // TODO Completar el codigo del metodo llenaTablaSedeConcurso

    }  // fin del metodo llenaTablaSedeConcurso()


}
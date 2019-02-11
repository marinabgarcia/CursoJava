package Clase6.Ejemplo4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ivan Salas Corrales <http://programandoointentandolo.com/>
 */
public class MuestraMovimientos implements ActionListener {

    private DefaultTableModel dtm;
    private Connection cn;
    private JTextField tfCuenta;

    public MuestraMovimientos(DefaultTableModel dtm, JTextField tfCuenta) {
        this.dtm = dtm;
        this.tfCuenta = tfCuenta;
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        String tipo;
        String cantidad;
        String fecha;

        // Se borra el contenido de la tabla
        int i = 0;
        while (dtm.getRowCount() > 0) {
            dtm.removeRow(i);
        }

        try {
            // Driver para conectar con MySQL
            Class.forName("com.mysql.jdbc.Driver");

            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Banco", "root", "glsqwe123");


            String sqlBusqueda = "SELECT tm.tipo,  m.cantidad,  m.fecha FROM movimientos AS m INNER JOIN tipos_movimiento AS tm ON tm.id=m.tipo WHERE m.codigo=?";

            PreparedStatement psBusqueda = cn.prepareStatement(sqlBusqueda);

            psBusqueda.setString(1, tfCuenta.getText());
            ResultSet listaMovimientos = psBusqueda.executeQuery();

            // Se ponene en la tabla los valores obtenidos de la consulta    
            while (listaMovimientos.next()) {
                tipo = listaMovimientos.getString("tipo");
                cantidad = listaMovimientos.getString("cantidad");
                fecha = listaMovimientos.getString("fecha");
                dtm.addRow(new String[]{tipo, cantidad, fecha});
            }

            // Cierro el ResultSet y el Statement aunque al cerrar el Statement ya se cierra el ResulSet
            listaMovimientos.close();
            psBusqueda.close();


        } catch (SQLException ex) {
            System.out.println("Error " + ex.getErrorCode() + ": " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
        	System.out.println("No se encontro el Driver MySQL para JDBC.");
        } finally {
            try {
                // Cierra la conexion con la base de datos
                cn.close();
            } catch (SQLException ex) {
            	System.out.println("Error " + ex.getErrorCode() + ": " + ex.getMessage());
            }
        }
    }
}
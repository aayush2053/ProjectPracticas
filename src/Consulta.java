import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Consulta {
	public static void main(String[] args) {
		try {	  
		    //mysql
		    Class.forName("com.mysql.jdbc.Driver");
		    Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root", null);
 	  
			// Preparamos la consulta
			Statement sentencia = conexion.createStatement();
			String sql = "SELECT * from fact_prov";
			ResultSet resul =sentencia.executeQuery(sql);
			
			//Recorremos el resultado para visualizar cada fila
			//Se hace un bucle mientras haya registros y se van visualizando
			while (resul.next()) {
				
				System.out.printf("%s, %s, Número de Factura:  %d, %s, %s, %s, %s, %s \n\n","CIF del proveedor: "+resul.getString(1),
						"Razón Social del Proveedor : "+resul.getString(2),
						resul.getInt(3),
						"Descripción de la Factura : "+resul.getString(4),
						"Base Imponible : "+resul.getString(5),
						"Total Importe : "+resul.getString(6),
						"Fecha de Factura :"+resul.getDate(8),
						"Fecha de Vencimiento :"+resul.getDate(9));
			}

			resul.close();     // Cerrar ResultSet
			sentencia.close(); // Cerrar Statement
			conexion.close();  // Cerrar conexión

		      } catch (ClassNotFoundException cn) {
			   cn.printStackTrace();
		      } catch (SQLException e) {
			   e.printStackTrace();
		      }
	}
}

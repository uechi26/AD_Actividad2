package persistencia;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidad.Coche;
import persistencia.interfaces.CocheDao;

public class CocheDaoMySql implements CocheDao{
	
	private Connection conexion;
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver cargado");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver No cargado");
			e.printStackTrace();
		}
	}
	
	public boolean abrirConexion() {
		String url = "jdbc:mysql://localhost:50/actividad2";

		try {
			conexion = DriverManager.getConnection(url,usuario,password);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		System.out.println("Se ha establecido la conexion con la BBDD");
		return true;
	}
	
	public boolean cerrarConexion() {
		try {
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean alta(Coche p) {
		if(!abrirConexion()) {
			return false;	
		}
		boolean alta = true;
		
		String query ="insert into coche (MARCA,MODELO,ANYOFABRI,KM)"
				+ "values(?,?,?,?)";
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setString(1, p.getMarca());
			ps.setString(2, p.getModelo());
			ps.setString(3, p.getAnyoFabri());
			ps.setInt(4, p.getKm());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("alta --> Error al insertar: " + p);
			alta = false;
			e.printStackTrace();
		} finally {
			cerrarConexion();
		}
		return alta;
		
	}

	@Override
	public boolean baja(int id) {
		if(!abrirConexion()) {
			return false;
		}
		
		boolean borrado = false;
		String query ="delete from coche where id = ?";
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setInt(1, id);
			
			int numeroFilasAfectadas = ps.executeUpdate();
			if(numeroFilasAfectadas == 0)
				borrado = false;
			else
				borrado = true;
		} catch (SQLException e) {
			System.out.println("baja --> No se ha podido dar de baja"
					+ " el id " + id);
			e.printStackTrace();
		} finally {
			cerrarConexion();
		}
		return borrado;
	}

	@Override
	public boolean modificar(Coche p) {
		if(!abrirConexion()) {
			return false;
		}
		boolean modificado = true;
		String query ="update coches set MARCA=?, "
				+ "MODELO=?, ANYOFABRI=?, KM=? WHERE ID=?";
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setString(1, p.getMarca());
			ps.setString(2, p.getModelo());
			ps.setString(3, p.getAnyoFabri());
			ps.setInt(4, p.getKm());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("modificar --> error al modificar el "
					+ " coche " + p);
			modificado = false;
			e.printStackTrace();
		} finally {
			cerrarConexion();
		}
		return modificado;
	}

	@Override
	public Coche obtener(int id) {
		if(!abrirConexion()) {
		return null;
		}
		Coche coche = null;
		
		String query = "select ID,MARCA,MODELO,ANYOFABRI,KM from coche "
				+ "where ID = ?";
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setInt(1, id);
			
			ResultSet rs = ps.execute.Query();
			while(rs.next()) {
				coche = new Coche();
				coche.setId(rs.getInt(1));
				coche.setMarca(re.getString(2));
				coche.setModelo(rs.getString(3));
				coche.setAnyoFabri(rs.getString(4));
				coche.setKm(rs.getInt(5));
			}
		} catch (SQLException e) {
			System.out.println("obtener --> error al obtener el "
					+ " coche con id " + id);
			e.printStackTrace();
		} finally {
			cerrarConexion();
		}
		return coche;
	}

	@Override
	public List<Coche> listar() {
		if(!abrirConexion()) {
		return null;
		}
		List<Coche> listaCoches = new ArrayList<>();
		
		String query = "select ID,MARCA,MODELO,ANYOFABRI,KM from coche";
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Coche coche = new Coche();
				coche.setId(rs.getInt(1));
				coche.setMarca(rs.getString(2));
				coche.setModelo(rs.getString(3));
				coche.setAnyoFabri(rs.getString(4));
				coche.setKm(rs.getInt(5));
			
				listaCoches.add(coche);
			}
		} catch (SQLException e) {
			System.out.println("listar --> error al obtener los "
					+ " coches");
			e.printStackTrace();
		} finally {
			cerrarConexion();
		}
		return listaCoches;
	}
	
}

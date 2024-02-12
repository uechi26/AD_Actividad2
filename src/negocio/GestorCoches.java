package negocio;

import java.util.List;

import entidad.Coche;
import persistencia.CocheDaoMySql;
import persistencia.interfaces.CocheDao;

public class GestorCoches {
	
	public boolean alta(Coche p) {
		if(p.getKm() >= 0) {
			CocheDao cocheDao = new CocheDaoMySql();
			boolean alta = cocheDao.alta(p);
			return alta;
		}else {
			return false;
		}
		
	}
	
	public boolean baja(int id) {
		CocheDao cocheDao = new CocheDaoMySql();
		boolean baja = cocheDao.baja(id);
		return baja;
	}
	
	public boolean modificar(Coche p) {
		CocheDao cochedao = new CocheDaoMySql();
		boolean modificar = cocheDao.modificar(p);
		return modificar<az;
	}
	
	public Coche obtener(int id) {
		CocheDao cocheDao = new CocheDaoMySql();
		Coche coche = cocheDao.obtener(id);
		return coche;
	}
	
	public List<Coche> listar(){
		CocheDao cocheDao = new CocheDaoMySql();
		List<Coche> listaCoches = cocheDao.listar();
		return listaCoches;
	}

}



package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.MedicaoVistoria;

public class MedicaoVistoriaDAO extends ConexaoDB {
	
	private static final String INSERT_MEDICAOVISTORIA_SQL = "INSERT INTO medicao_vistoria (raio, perfil, largura, indice_carga) VALUES (?);";
	private static final String SELECT_MEDICAOVISTORIA_BY_ID = "SELECT id, raio FROM medicao_vistoria WHERE id = ?";
	private static final String SELECT_MEDICAOVISTORIA_EIXO = "SELECT * FROM medicao_vistoria;";
	private static final String DELETE_MEDICAOVISTORIA_SQL = "DELETE FROM medicao_vistoria WHERE id = ?;";
	private static final String UPDATE_MEDICAOVISTORIA_SQL = "UPDATE medicao_vistoria SET raio = ? WHERE id = ?;";

	
	public void insertMedicaoVistoria(MedicaoVistoria entidade) {
       try (PreparedStatement preparedStatement = prapararSQL(INSERT_MEDICAOVISTORIA_SQL)) {
           preparedStatement.setInt(1, entidade.getRaio());
           preparedStatement.setString(2, entidade.getPerfil());
           preparedStatement.setString(3, entidade.getLargura());
           preparedStatement.setString(4, entidade.getIndice_carga());
           preparedStatement.executeUpdate();
       } catch (SQLException e) {
           printSQLException(e);
       } catch (ClassNotFoundException e) {
           throw new RuntimeException(e);
       }
   }

   public MedicaoVistoria selectMedicaoVistoria(int id) {
	   MedicaoVistoria entidade = null;
       try (PreparedStatement preparedStatement = prapararSQL(SELECT_MEDICAOVISTORIA_BY_ID)) {
           preparedStatement.setInt(1, id);
           ResultSet rs = preparedStatement.executeQuery();

           while (rs.next()) {
               Integer raio = rs.getInt("raio");
               String perfil = rs.getString("perfil");
               String largura = rs.getString("largura");
               String indice_carga = rs.getString("perfil");
               entidade = new MedicaoVistoria(id, raio, perfil, largura, indice_carga);
           }
       } catch (SQLException e) {
           printSQLException(e);
       } catch (ClassNotFoundException e) {
           throw new RuntimeException(e);
       }
       return entidade;
   }

   public List<MedicaoVistoria> selectAllMedicaoVistoria() {
       List<MedicaoVistoria> entidades = new ArrayList<>();
       try (PreparedStatement preparedStatement = prapararSQL(SELECT_MEDICAOVISTORIA_EIXO)) {
           ResultSet rs = preparedStatement.executeQuery();

           while (rs.next()) {
               int id = rs.getInt("id");
               Integer raio = rs.getInt("raio");
               String perfil = rs.getString("perfil");
               String largura = rs.getString("largura");
               String indice_carga = rs.getString("perfil");
               entidades.add(new MedicaoVistoria(id, raio, perfil, largura, indice_carga));
           }
       } catch (SQLException e) {
           printSQLException(e);
       } catch (ClassNotFoundException e) {
           throw new RuntimeException(e);
       }
       return entidades;
   }

   public boolean deleteMedicaoVistoria(int id) throws SQLException {
       try (PreparedStatement statement = prapararSQL(DELETE_MEDICAOVISTORIA_SQL)) {
           statement.setInt(1, id);
           return statement.executeUpdate() > 0;
       } catch (ClassNotFoundException e) {
           throw new RuntimeException(e);
       }
   }

   public boolean updateMedicaoVistoria(MedicaoVistoria entidade) throws SQLException {
       try (PreparedStatement statement = prapararSQL(UPDATE_MEDICAOVISTORIA_SQL)) {
           statement.setInt(1, entidade.getRaio());
           statement.setInt(2, entidade.getId());

           return statement.executeUpdate() > 0;
       } catch (ClassNotFoundException e) {
           throw new RuntimeException(e);
       }
   }

}

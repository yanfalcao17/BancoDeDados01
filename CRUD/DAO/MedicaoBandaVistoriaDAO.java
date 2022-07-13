package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.MedicaoBandaVistoria;

public class MedicaoBandaVistoriaDAO extends ConexaoDB {
	
	private static final String INSERT_MEDICAOBANDAVISTORIA_SQL = "INSERT INTO medicao_banda_vistoria (valor) VALUES (?);";
	private static final String SELECT_MEDICAOBANDAVISTORIA_BY_ID = "SELECT id, valor FROM medicao_banda_vistoria WHERE id = ?";
	private static final String SELECT_MEDICAOBANDAVISTORIA_EIXO = "SELECT * FROM medicao_banda_vistoria;";
	private static final String DELETE_MEDICAOBANDAVISTORIA_SQL = "DELETE FROM medicao_banda_vistoria WHERE id = ?;";
	private static final String UPDATE_MEDICAOBANDAVISTORIA_SQL = "UPDATE medicao_banda_vistoria SET valor = ? WHERE id = ?;";

	
	public void insertMedicaoBandaVistoria(MedicaoBandaVistoria entidade) {
       try (PreparedStatement preparedStatement = prapararSQL(INSERT_MEDICAOBANDAVISTORIA_SQL)) {
           preparedStatement.setFloat(1, entidade.getValor());
           preparedStatement.executeUpdate();
       } catch (SQLException e) {
           printSQLException(e);
       } catch (ClassNotFoundException e) {
           throw new RuntimeException(e);
       }
   }

   public MedicaoBandaVistoria selectMedicaoBandaVistoria(int id) {
	   MedicaoBandaVistoria entidade = null;
       try (PreparedStatement preparedStatement = prapararSQL(SELECT_MEDICAOBANDAVISTORIA_BY_ID)) {
           preparedStatement.setInt(1, id);
           ResultSet rs = preparedStatement.executeQuery();

           while (rs.next()) {
               float valor = rs.getFloat("valor");
               entidade = new MedicaoBandaVistoria(id, valor);
           }
       } catch (SQLException e) {
           printSQLException(e);
       } catch (ClassNotFoundException e) {
           throw new RuntimeException(e);
       }
       return entidade;
   }

   public List<MedicaoBandaVistoria> selectAllMedicaoBandaVistoria() {
       List<MedicaoBandaVistoria> entidades = new ArrayList<>();
       try (PreparedStatement preparedStatement = prapararSQL(SELECT_MEDICAOBANDAVISTORIA_EIXO)) {
           ResultSet rs = preparedStatement.executeQuery();

           while (rs.next()) {
               int id = rs.getInt("id");
               float valor = rs.getFloat("valor");
               entidades.add(new MedicaoBandaVistoria(id, valor));
           }
       } catch (SQLException e) {
           printSQLException(e);
       } catch (ClassNotFoundException e) {
           throw new RuntimeException(e);
       }
       return entidades;
   }

   public boolean deleteMedicaoBandaVistoria(int id) throws SQLException {
       try (PreparedStatement statement = prapararSQL(DELETE_MEDICAOBANDAVISTORIA_SQL)) {
           statement.setInt(1, id);
           return statement.executeUpdate() > 0;
       } catch (ClassNotFoundException e) {
           throw new RuntimeException(e);
       }
   }

   public boolean updateMedicaoBandaVistoria(MedicaoBandaVistoria entidade) throws SQLException {
       try (PreparedStatement statement = prapararSQL(UPDATE_MEDICAOBANDAVISTORIA_SQL)) {
           statement.setFloat(1, entidade.getValor());
           statement.setInt(2, entidade.getId());

           return statement.executeUpdate() > 0;
       } catch (ClassNotFoundException e) {
           throw new RuntimeException(e);
       }
   }

}

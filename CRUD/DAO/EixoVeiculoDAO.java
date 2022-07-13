package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.EixoVeiculo;

public class EixoVeiculoDAO extends ConexaoDB {
	
	private static final String INSERT_PNEURESERVA_SQL = "INSERT INTO eixo_veiculo (id) VALUES (?);";
	private static final String SELECT_ALL_PNEURESERVA = "SELECT * FROM eixo_veiculo;";
	private static final String DELETE_PNEURESERVA_SQL = "DELETE FROM eixo_veiculo WHERE id = ?;";

	
	public void insertPneuReserva(EixoVeiculo entidade) {
       try (PreparedStatement preparedStatement = prapararSQL(INSERT_PNEURESERVA_SQL)) {
    	   preparedStatement.setInt(1, entidade.getId());
           preparedStatement.executeUpdate();
       } catch (SQLException e) {
           printSQLException(e);
       } catch (ClassNotFoundException e) {
           throw new RuntimeException(e);
       }
   }


   public List<EixoVeiculo> selectAllPneuReservas() {
       List<EixoVeiculo> entidades = new ArrayList<>();
       try (PreparedStatement preparedStatement = prapararSQL(SELECT_ALL_PNEURESERVA)) {
           ResultSet rs = preparedStatement.executeQuery();

           while (rs.next()) {
               int id = rs.getInt("id");
               entidades.add(new EixoVeiculo(id));
           }
       } catch (SQLException e) {
           printSQLException(e);
       } catch (ClassNotFoundException e) {
           throw new RuntimeException(e);
       }
       return entidades;
   }

   public boolean deletePneuReserva(int id) throws SQLException {
       try (PreparedStatement statement = prapararSQL(DELETE_PNEURESERVA_SQL)) {
           statement.setInt(1, id);
           return statement.executeUpdate() > 0;
       } catch (ClassNotFoundException e) {
           throw new RuntimeException(e);
       }
   }


}

package DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.VistoriaVeiculo;

public class VistoriaVeiculoDAO extends ConexaoDB {
	
	private static final String INSERT_VISTORIAVEICULO_SQL = "INSERT INTO vistoria_veiculo (observacao, data_vistoria, username, data_cadastro, vistoria_veiculocol) VALUES (?);";
	private static final String SELECT_VISTORIAVEICULO_BY_ID = "SELECT id, observacao FROM vistoria_veiculo WHERE id = ?";
	private static final String SELECT_VISTORIAVEICULO_EIXO = "SELECT * FROM vistoria_veiculo;";
	private static final String DELETE_VISTORIAVEICULO_SQL = "DELETE FROM vistoria_veiculo WHERE id = ?;";
	private static final String UPDATE_VISTORIAVEICULO_SQL = "UPDATE vistoria_veiculo SET observacao = ? WHERE id = ?;";

	
	public void insertVistoriaVeiculo(VistoriaVeiculo entidade) {
       try (PreparedStatement preparedStatement = prapararSQL(INSERT_VISTORIAVEICULO_SQL)) {
           preparedStatement.setString(1, entidade.getObservacao());
           preparedStatement.setDate(2, entidade.getData_vistoria());
           preparedStatement.setString(3, entidade.getUsername());
           preparedStatement.setDate(4, entidade.getData_cadastro());
           preparedStatement.setString(5, entidade.getVistoria_veiculocol());
           preparedStatement.executeUpdate();
       } catch (SQLException e) {
           printSQLException(e);
       } catch (ClassNotFoundException e) {
           throw new RuntimeException(e);
       }
   }

   public VistoriaVeiculo selectVistoriaVeiculo(int id) {
	   VistoriaVeiculo entidade = null;
       try (PreparedStatement preparedStatement = prapararSQL(SELECT_VISTORIAVEICULO_BY_ID)) {
           preparedStatement.setInt(1, id);
           ResultSet rs = preparedStatement.executeQuery();

           while (rs.next()) {
        	   String observacao = rs.getString("observacao");
               Date data_vistoria = rs.getDate("data_vistoria");
               String username = rs.getString("username");
               Date data_cadastro = rs.getDate("data_cadastro");
               String vistoria_veiculocol = rs.getString("vistoria_veiculocol");
               entidade = new VistoriaVeiculo(id, observacao, data_vistoria, username, data_cadastro, vistoria_veiculocol);
           }
       } catch (SQLException e) {
           printSQLException(e);
       } catch (ClassNotFoundException e) {
           throw new RuntimeException(e);
       }
       return entidade;
   }

   public List<VistoriaVeiculo> selectAllVistoriaVeiculo() {
       List<VistoriaVeiculo> entidades = new ArrayList<>();
       try (PreparedStatement preparedStatement = prapararSQL(SELECT_VISTORIAVEICULO_EIXO)) {
           ResultSet rs = preparedStatement.executeQuery();

           while (rs.next()) {
               int id = rs.getInt("id");
               String observacao = rs.getString("observacao");
               Date data_vistoria = rs.getDate("data_vistoria");
               String username = rs.getString("username");
               Date data_cadastro = rs.getDate("data_cadastro");
               String vistoria_veiculocol = rs.getString("vistoria_veiculocol");
               entidades.add(new VistoriaVeiculo(id, observacao, data_vistoria, username, data_cadastro, vistoria_veiculocol));
           }
       } catch (SQLException e) {
           printSQLException(e);
       } catch (ClassNotFoundException e) {
           throw new RuntimeException(e);
       }
       return entidades;
   }

   public boolean deleteVistoriaVeiculo(int id) throws SQLException {
       try (PreparedStatement statement = prapararSQL(DELETE_VISTORIAVEICULO_SQL)) {
           statement.setInt(1, id);
           return statement.executeUpdate() > 0;
       } catch (ClassNotFoundException e) {
           throw new RuntimeException(e);
       }
   }

   public boolean updateVistoriaVeiculo(VistoriaVeiculo entidade) throws SQLException {
       try (PreparedStatement statement = prapararSQL(UPDATE_VISTORIAVEICULO_SQL)) {
           statement.setString(1, entidade.getObservacao());
           statement.setInt(2, entidade.getId());

           return statement.executeUpdate() > 0;
       } catch (ClassNotFoundException e) {
           throw new RuntimeException(e);
       }
   }


}

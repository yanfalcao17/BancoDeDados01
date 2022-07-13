package DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.VistoriaPneu;

public class VistoriaPneuDAO extends ConexaoDB {
	private static final String INSERT_VISTORIAPNEU_SQL = "INSERT INTO vistoria_pneu (observacao, data_cadastro) VALUES (?);";
	private static final String SELECT_VISTORIAPNEU_BY_ID = "SELECT id, observacao FROM vistoria_pneu WHERE id = ?";
	private static final String SELECT_VISTORIAPNEU_EIXO = "SELECT * FROM vistoria_pneu;";
	private static final String DELETE_VISTORIAPNEU_SQL = "DELETE FROM vistoria_pneu WHERE id = ?;";
	private static final String UPDATE_VISTORIAPNEU_SQL = "UPDATE vistoria_pneu SET observacao = ? WHERE id = ?;";

	
	public void insertVistoriaPneu(VistoriaPneu entidade) {
       try (PreparedStatement preparedStatement = prapararSQL(INSERT_VISTORIAPNEU_SQL)) {
           preparedStatement.setString(1, entidade.getObservacao());
           preparedStatement.setDate(2, (Date) entidade.getDataCadastro());
           preparedStatement.executeUpdate();
       } catch (SQLException e) {
           printSQLException(e);
       } catch (ClassNotFoundException e) {
           throw new RuntimeException(e);
       }
   }

   public VistoriaPneu selectVistoriaPneu(int id) {
	   VistoriaPneu entidade = null;
       try (PreparedStatement preparedStatement = prapararSQL(SELECT_VISTORIAPNEU_BY_ID)) {
           preparedStatement.setInt(1, id);
           ResultSet rs = preparedStatement.executeQuery();

           while (rs.next()) {
               String observasao = rs.getString("descricao");
               Date data = rs.getDate(1);
               entidade = new VistoriaPneu(id, observasao, data);
           }
       } catch (SQLException e) {
           printSQLException(e);
       } catch (ClassNotFoundException e) {
           throw new RuntimeException(e);
       }
       return entidade;
   }

   public List<VistoriaPneu> selectAllVistoriaPneu() {
       List<VistoriaPneu> entidades = new ArrayList<>();
       try (PreparedStatement preparedStatement = prapararSQL(SELECT_VISTORIAPNEU_EIXO)) {
           ResultSet rs = preparedStatement.executeQuery();

           while (rs.next()) {
               int id = rs.getInt("id");
               String observasao = rs.getString("descricao");
               Date data = rs.getDate(1);
               entidades.add(new VistoriaPneu(id, observasao, data));
           }
       } catch (SQLException e) {
           printSQLException(e);
       } catch (ClassNotFoundException e) {
           throw new RuntimeException(e);
       }
       return entidades;
   }

   public boolean deleteVistoriaPneu(int id) throws SQLException {
       try (PreparedStatement statement = prapararSQL(DELETE_VISTORIAPNEU_SQL)) {
           statement.setInt(1, id);
           return statement.executeUpdate() > 0;
       } catch (ClassNotFoundException e) {
           throw new RuntimeException(e);
       }
   }

   public boolean updateVistoriaPneu(VistoriaPneu entidade) throws SQLException {
       try (PreparedStatement statement = prapararSQL(UPDATE_VISTORIAPNEU_SQL)) {
           statement.setString(1, entidade.getObservacao());
           statement.setInt(2, entidade.getId());

           return statement.executeUpdate() > 0;
       } catch (ClassNotFoundException e) {
           throw new RuntimeException(e);
       }
   }

}

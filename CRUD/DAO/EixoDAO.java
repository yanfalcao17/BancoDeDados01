package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Eixo;

public class EixoDAO extends ConexaoDB {
	
	private static final String INSERT_EIXO_SQL = "INSERT INTO eixo (descricao, posicao) VALUES (?);";
	private static final String SELECT_EIXO_BY_ID = "SELECT id, descricao FROM eixo WHERE id = ?";
	private static final String SELECT_ALL_EIXO = "SELECT * FROM eixo;";
	private static final String DELETE_EIXO_SQL = "DELETE FROM eixo WHERE id = ?;";
	private static final String UPDATE_EIXO_SQL = "UPDATE eixo SET descricao = ? WHERE id = ?;";

	
	public void insertEixo(Eixo entidade) {
       try (PreparedStatement preparedStatement = prapararSQL(INSERT_EIXO_SQL)) {
           preparedStatement.setString(1, entidade.getDescricao());
           preparedStatement.setInt(2, entidade.getPocisao());
           preparedStatement.executeUpdate();
       } catch (SQLException e) {
           printSQLException(e);
       } catch (ClassNotFoundException e) {
           throw new RuntimeException(e);
       }
   }

   public Eixo selectEixo(int id) {
	   Eixo entidade = null;
       try (PreparedStatement preparedStatement = prapararSQL(SELECT_EIXO_BY_ID)) {
           preparedStatement.setInt(1, id);
           ResultSet rs = preparedStatement.executeQuery();

           while (rs.next()) {
               String descricao = rs.getString("descricao");
               Integer posicao = rs.getInt(1);
               entidade = new Eixo(id, descricao, posicao);
           }
       } catch (SQLException e) {
           printSQLException(e);
       } catch (ClassNotFoundException e) {
           throw new RuntimeException(e);
       }
       return entidade;
   }

   public List<Eixo> selectAllEixos() {
       List<Eixo> entidades = new ArrayList<>();
       try (PreparedStatement preparedStatement = prapararSQL(SELECT_ALL_EIXO)) {
           ResultSet rs = preparedStatement.executeQuery();

           while (rs.next()) {
               int id = rs.getInt("id");
               String descricao = rs.getString("descricao");
               Integer posicao = rs.getInt(1);
               entidades.add(new Eixo(id, descricao, posicao));
           }
       } catch (SQLException e) {
           printSQLException(e);
       } catch (ClassNotFoundException e) {
           throw new RuntimeException(e);
       }
       return entidades;
   }

   public boolean deleteEixo(int id) throws SQLException {
       try (PreparedStatement statement = prapararSQL(DELETE_EIXO_SQL)) {
           statement.setInt(1, id);
           return statement.executeUpdate() > 0;
       } catch (ClassNotFoundException e) {
           throw new RuntimeException(e);
       }
   }

   public boolean updateEixo(Eixo entidade) throws SQLException {
       try (PreparedStatement statement = prapararSQL(UPDATE_EIXO_SQL)) {
           statement.setString(1, entidade.getDescricao());
           statement.setInt(2, entidade.getId());

           return statement.executeUpdate() > 0;
       } catch (ClassNotFoundException e) {
           throw new RuntimeException(e);
       }
   }

}

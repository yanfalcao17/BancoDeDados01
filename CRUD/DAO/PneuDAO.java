package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Pneu;

public class PneuDAO extends ConexaoDB {
	
	private static final String INSERT_PNEU_SQL = "INSERT INTO pneu (raio, perfil, largura, indice_carga, indice_velocidade, pneucol) VALUES (?);";
	private static final String SELECT_PNEU_BY_ID = "SELECT id, raio FROM pneu WHERE id = ?";
	private static final String SELECT_PNEU_EIXO = "SELECT * FROM pneu;";
	private static final String DELETE_PNEU_SQL = "DELETE FROM pneu WHERE id = ?;";
	private static final String UPDATE_PNEU_SQL = "UPDATE pneu SET raio = ? WHERE id = ?;";

	
	public void insertPneu(Pneu entidade) {
       try (PreparedStatement preparedStatement = prapararSQL(INSERT_PNEU_SQL)) {
           preparedStatement.setInt(1, entidade.getRaio());
           preparedStatement.setString(2, entidade.getPerfil());
           preparedStatement.setString(3, entidade.getLargura());
           preparedStatement.setString(4, entidade.getIndice_carga());
           preparedStatement.setString(5, entidade.getIndice_velocidade());
           preparedStatement.setString(6, entidade.getPneucol());
           preparedStatement.executeUpdate();
       } catch (SQLException e) {
           printSQLException(e);
       } catch (ClassNotFoundException e) {
           throw new RuntimeException(e);
       }
   }

   public Pneu selectPneu(int id) {
	   Pneu entidade = null;
       try (PreparedStatement preparedStatement = prapararSQL(SELECT_PNEU_BY_ID)) {
           preparedStatement.setInt(1, id);
           ResultSet rs = preparedStatement.executeQuery();

           while (rs.next()) {
        	   Integer raio = rs.getInt("raio");
               String perfil = rs.getString("perfil");
               String largura = rs.getString("largura");
               String indice_carga = rs.getString("indice_carga");
               String indice_velocidade = rs.getString("indice_velocidade");
               String pneucol = rs.getString("pneucol");
               entidade = new Pneu(id, raio, perfil, largura, indice_carga, indice_velocidade, pneucol);
           }
       } catch (SQLException e) {
           printSQLException(e);
       } catch (ClassNotFoundException e) {
           throw new RuntimeException(e);
       }
       return entidade;
   }

   public List<Pneu> selectAllPneus() {
       List<Pneu> entidades = new ArrayList<>();
       try (PreparedStatement preparedStatement = prapararSQL(SELECT_PNEU_EIXO)) {
           ResultSet rs = preparedStatement.executeQuery();

           while (rs.next()) {
               int id = rs.getInt("id");
               Integer raio = rs.getInt("raio");
               String perfil = rs.getString("perfil");
               String largura = rs.getString("largura");
               String indice_carga = rs.getString("indice_carga");
               String indice_velocidade = rs.getString("indice_velocidade");
               String pneucol = rs.getString("pneucol");
               entidades.add(new Pneu(id, raio, perfil, largura, indice_carga, indice_velocidade, pneucol));
           }
       } catch (SQLException e) {
           printSQLException(e);
       } catch (ClassNotFoundException e) {
           throw new RuntimeException(e);
       }
       return entidades;
   }

   public boolean deletePneu(int id) throws SQLException {
       try (PreparedStatement statement = prapararSQL(DELETE_PNEU_SQL)) {
           statement.setInt(1, id);
           return statement.executeUpdate() > 0;
       } catch (ClassNotFoundException e) {
           throw new RuntimeException(e);
       }
   }

   public boolean updatePneu(Pneu entidade) throws SQLException {
       try (PreparedStatement statement = prapararSQL(UPDATE_PNEU_SQL)) {
           statement.setInt(1, entidade.getRaio());
           statement.setInt(2, entidade.getId());

           return statement.executeUpdate() > 0;
       } catch (ClassNotFoundException e) {
           throw new RuntimeException(e);
       }
   }

}

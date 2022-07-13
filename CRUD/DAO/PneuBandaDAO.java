package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.PneuBanda;

public class PneuBandaDAO extends ConexaoDB{
	
	private static final String INSERT_PNEUBANDA_SQL = "INSERT INTO pneu_banda (observacao, ordem) VALUES (?);";
	private static final String SELECT_PNEUBANDA_BY_ID = "SELECT id, observacao FROM pneu_banda WHERE id = ?";
	private static final String SELECT_PNEUBANDA_EIXO = "SELECT * FROM pneu_banda;";
	private static final String DELETE_PNEUBANDA_SQL = "DELETE FROM pneu_banda WHERE id = ?;";
	private static final String UPDATE_PNEUBANDA_SQL = "UPDATE pneu_banda SET observacao = ? WHERE id = ?;";

	
	public void insertPneuBanda(PneuBanda entidade) {
       try (PreparedStatement preparedStatement = prapararSQL(INSERT_PNEUBANDA_SQL)) {
           preparedStatement.setString(1, entidade.getObservacao());
           preparedStatement.setInt(2, entidade.getOrdem());
           preparedStatement.executeUpdate();
       } catch (SQLException e) {
           printSQLException(e);
       } catch (ClassNotFoundException e) {
           throw new RuntimeException(e);
       }
   }

   public PneuBanda selectPneuBanda(int id) {
	   PneuBanda entidade = null;
       try (PreparedStatement preparedStatement = prapararSQL(SELECT_PNEUBANDA_BY_ID)) {
           preparedStatement.setInt(1, id);
           ResultSet rs = preparedStatement.executeQuery();

           while (rs.next()) {
               String observasao = rs.getString("descricao");
               Integer ordem = rs.getInt(1);
               entidade = new PneuBanda(id, observasao, ordem);
           }
       } catch (SQLException e) {
           printSQLException(e);
       } catch (ClassNotFoundException e) {
           throw new RuntimeException(e);
       }
       return entidade;
   }

   public List<PneuBanda> selectAllPneuBandas() {
       List<PneuBanda> entidades = new ArrayList<>();
       try (PreparedStatement preparedStatement = prapararSQL(SELECT_PNEUBANDA_EIXO)) {
           ResultSet rs = preparedStatement.executeQuery();

           while (rs.next()) {
               int id = rs.getInt("id");
               String observasao = rs.getString("descricao");
               Integer ordem = rs.getInt(1);
               entidades.add(new PneuBanda(id, observasao, ordem));
           }
       } catch (SQLException e) {
           printSQLException(e);
       } catch (ClassNotFoundException e) {
           throw new RuntimeException(e);
       }
       return entidades;
   }

   public boolean deletePneuBanda(int id) throws SQLException {
       try (PreparedStatement statement = prapararSQL(DELETE_PNEUBANDA_SQL)) {
           statement.setInt(1, id);
           return statement.executeUpdate() > 0;
       } catch (ClassNotFoundException e) {
           throw new RuntimeException(e);
       }
   }

   public boolean updatePneuBanda(PneuBanda entidade) throws SQLException {
       try (PreparedStatement statement = prapararSQL(UPDATE_PNEUBANDA_SQL)) {
           statement.setString(1, entidade.getObservacao());
           statement.setInt(2, entidade.getId());

           return statement.executeUpdate() > 0;
       } catch (ClassNotFoundException e) {
           throw new RuntimeException(e);
       }
   }


}

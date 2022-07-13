package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.PneuReserva;

public class PneuReservaDAO extends ConexaoDB {
	
	private static final String INSERT_PNEURESERVA_SQL = "INSERT INTO pneu_reserva (descricao) VALUES (?);";
	private static final String SELECT_PNEURESERVA_BY_ID = "SELECT id, descricao FROM pneu_reserva WHERE id = ?";
	private static final String SELECT_ALL_PNEURESERVA = "SELECT * FROM pneu_reserva;";
	private static final String DELETE_PNEURESERVA_SQL = "DELETE FROM pneu_reserva WHERE id = ?;";
	private static final String UPDATE_PNEURESERVA_SQL = "UPDATE pneu_reserva SET descricao = ? WHERE id = ?;";

	
	public void insertPneuReserva(PneuReserva entidade) {
       try (PreparedStatement preparedStatement = prapararSQL(INSERT_PNEURESERVA_SQL)) {
           preparedStatement.setString(1, entidade.getDescricao());
           preparedStatement.executeUpdate();
       } catch (SQLException e) {
           printSQLException(e);
       } catch (ClassNotFoundException e) {
           throw new RuntimeException(e);
       }
   }

   public PneuReserva selectPneuReserva(int id) {
	   PneuReserva entidade = null;
       try (PreparedStatement preparedStatement = prapararSQL(SELECT_PNEURESERVA_BY_ID)) {
           preparedStatement.setInt(1, id);
           ResultSet rs = preparedStatement.executeQuery();

           while (rs.next()) {
               String descricao = rs.getString("descricao");
               entidade = new PneuReserva(id, descricao);
           }
       } catch (SQLException e) {
           printSQLException(e);
       } catch (ClassNotFoundException e) {
           throw new RuntimeException(e);
       }
       return entidade;
   }

   public List<PneuReserva> selectAllPneuReservas() {
       List<PneuReserva> entidades = new ArrayList<>();
       try (PreparedStatement preparedStatement = prapararSQL(SELECT_ALL_PNEURESERVA)) {
           ResultSet rs = preparedStatement.executeQuery();

           while (rs.next()) {
               int id = rs.getInt("id");
               String descricao = rs.getString("descricao");
               entidades.add(new PneuReserva(id, descricao));
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

   public boolean updatePneuReserva(PneuReserva entidade) throws SQLException {
       try (PreparedStatement statement = prapararSQL(UPDATE_PNEURESERVA_SQL)) {
           statement.setString(1, entidade.getDescricao());
           statement.setInt(2, entidade.getId());

           return statement.executeUpdate() > 0;
       } catch (ClassNotFoundException e) {
           throw new RuntimeException(e);
       }
   }


}

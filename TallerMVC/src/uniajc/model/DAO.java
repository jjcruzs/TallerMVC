package uniajc.model;

import java.sql.*;
import java.util.*;

public class DAO {

    public List<Estudiante> obtenerEstudiantes() {
        List<Estudiante> lista = new ArrayList<>();
        try (Connection con = ConexionBaseDatos.conectar();
             PreparedStatement stmt = con.prepareStatement("SELECT * FROM estudiantes");
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                lista.add(new Estudiante(rs.getInt("cod_estudiante"), rs.getString("nom_estudiante")));
            }

        } catch (SQLException e) { 
            e.printStackTrace();
        }
        return lista;
    }

    public List<Curso> obtenerCursos() {
        List<Curso> lista = new ArrayList<>();
        try (Connection con = ConexionBaseDatos.conectar();
             PreparedStatement stmt = con.prepareStatement("SELECT * FROM cursos");
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                lista.add(new Curso(rs.getInt("cod_curso"), rs.getString("nom_curso")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public void guardarMatricula(Matricula m) {
        try (Connection con = ConexionBaseDatos.conectar();
             PreparedStatement stmt = con.prepareStatement("INSERT INTO matricula VALUES (?, ?, ?)")) {

            stmt.setInt(1, m.getCodEstudiante());
            stmt.setInt(2, m.getCodCurso());
            stmt.setFloat(3, m.getNota());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}

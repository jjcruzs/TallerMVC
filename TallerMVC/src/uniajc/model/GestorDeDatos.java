package uniajc.model;

import java.sql.*;
import java.util.*;

public class GestorDeDatos {

    public void insertarEstudiante(Estudiante e) {
        try (Connection con = ConexionBaseDatos.conectar(); PreparedStatement stmt = con.prepareStatement("INSERT INTO estudiantes VALUES (?, ?)")) {
            stmt.setInt(1, e.getCodEstudiante());
            stmt.setString(2, e.getNomEstudiante());
            stmt.executeUpdate(); 
        } catch (SQLException ex) { 
            ex.printStackTrace();
        }
    }

    public void insertarDocente(Docente d) {
        try (Connection con = ConexionBaseDatos.conectar(); PreparedStatement stmt = con.prepareStatement("INSERT INTO docentes VALUES (?, ?)")) {
            stmt.setInt(1, d.getCodDocente());
            stmt.setString(2, d.getNomDocente());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void insertarCurso(Curso c) {
        try (Connection con = ConexionBaseDatos.conectar(); PreparedStatement stmt = con.prepareStatement("INSERT INTO cursos VALUES (?, ?, ?)")) {
            stmt.setInt(1, c.getCodCurso());
            stmt.setString(2, c.getNomCurso());
            stmt.setInt(3, c.getCodDocente());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void insertarMatricula(Matricula m) {
        try (Connection con = ConexionBaseDatos.conectar(); PreparedStatement stmt = con.prepareStatement("INSERT INTO matricula VALUES (?, ?, ?)")) {
            stmt.setInt(1, m.getCodEstudiante());
            stmt.setInt(2, m.getCodCurso());
            stmt.setFloat(3, m.getNota());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void actualizarNota(int codEst, int codCurso, float nota) {
        String sql = "UPDATE matricula SET nota_curso = ? WHERE cod_estudiante = ? AND cod_curso = ?";
        try (Connection con = ConexionBaseDatos.conectar(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setFloat(1, nota);
            stmt.setInt(2, codEst);
            stmt.setInt(3, codCurso);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public Estudiante buscarEstudiantePorCodigo(int codEst) {
        try (Connection con = ConexionBaseDatos.conectar(); PreparedStatement stmt = con.prepareStatement("SELECT * FROM estudiantes WHERE cod_estudiante = ?")) {
            stmt.setInt(1, codEst);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Estudiante(rs.getInt("cod_estudiante"), rs.getString("nom_estudiante"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void eliminarMatricula(int codEstudiante, int codCurso) {
        String sql = "DELETE FROM matricula WHERE cod_estudiante = ? AND cod_curso = ?";
        try (Connection con = ConexionBaseDatos.conectar(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, codEstudiante);
            stmt.setInt(2, codCurso);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public List<Estudiante> obtenerEstudiantes() {
        List<Estudiante> lista = new ArrayList<>();
        try (Connection con = ConexionBaseDatos.conectar(); PreparedStatement stmt = con.prepareStatement("SELECT * FROM estudiantes"); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                lista.add(new Estudiante(rs.getInt("cod_estudiante"), rs.getString("nom_estudiante")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public List<Docente> obtenerDocentes() {
        List<Docente> lista = new ArrayList<>();
        try (Connection con = ConexionBaseDatos.conectar(); PreparedStatement stmt = con.prepareStatement("SELECT * FROM docentes"); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                lista.add(new Docente(rs.getInt("cod_docente"), rs.getString("nom_docente")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public List<Curso> obtenerCursos() {
        List<Curso> lista = new ArrayList<>();
        try (Connection con = ConexionBaseDatos.conectar(); PreparedStatement stmt = con.prepareStatement("SELECT * FROM cursos"); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                lista.add(new Curso(rs.getInt("cod_curso"), rs.getString("nom_curso"), rs.getInt("cod_docente")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public List<String[]> obtenerListadoMatriculas() {
        List<String[]> lista = new ArrayList<>();
        String sql = "SELECT m.cod_estudiante, e.nom_estudiante, c.nom_curso, m.nota_curso "
                + "FROM matricula m "
                + "JOIN estudiantes e ON m.cod_estudiante = e.cod_estudiante "
                + "JOIN cursos c ON m.cod_curso = c.cod_curso";
        try (Connection con = ConexionBaseDatos.conectar(); PreparedStatement stmt = con.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                String[] fila = {
                    String.valueOf(rs.getInt("cod_estudiante")),
                    rs.getString("nom_estudiante"),
                    rs.getString("nom_curso"),
                    String.valueOf(rs.getFloat("nota_curso"))
                };
                lista.add(fila);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}

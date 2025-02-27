package com.frete.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class TesteConexao {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/transportadora    "; // Substitua pelo nome correto do banco
        String usuario = "root";
        String senha = "root";

        try (Connection conexao = DriverManager.getConnection(url, usuario, senha)) {
            System.out.println("✅ Conexão bem-sucedida!");

            // Criar tabela (caso não exista)
            String criarTabelaSQL = "CREATE TABLE IF NOT EXISTS teste ("
                    + "id INT AUTO_INCREMENT PRIMARY KEY, "
                    + "nome VARCHAR(50) NOT NULL)";

            try (Statement stmt = conexao.createStatement()) {
                stmt.execute(criarTabelaSQL);
                System.out.println("✅ Tabela 'teste' verificada/criada com sucesso!");
            }

            // Inserir um registro no banco de dados
            String inserirSQL = "INSERT INTO teste (nome) VALUES (?)";
            try (PreparedStatement pstmt = conexao.prepareStatement(inserirSQL)) {
                pstmt.setString(1, "Teste de Inserção");
                int linhasAfetadas = pstmt.executeUpdate();
                System.out.println("✅ Registro inserido! Linhas afetadas: " + linhasAfetadas);
            }

        } catch (SQLException e) {
            System.out.println("❌ Erro na conexão ou inserção: " + e.getMessage());
        }
    }
}

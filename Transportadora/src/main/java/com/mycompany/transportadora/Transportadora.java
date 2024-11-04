/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.transportadora;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.mycompany.transportadora.modelo.Cliente;
import com.mycompany.transportadora.modelo.Motorista;
import com.mycompany.transportadora.modelo.Veiculo;
import com.mycompany.transportadora.modelo.Entrega;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Transportadora {
    public static void main(String[] args) {
        
        String dbUser = System.getenv("DB_USER");
        String dbPassword = System.getenv("DB_PASSWORD");

        Map<String, String> configOverrides = new HashMap<>();
        configOverrides.put("hibernate.connection.username", dbUser);
        configOverrides.put("hibernate.connection.password", dbPassword);

        // Cria a EntityManagerFactory com as configurações sobrescritas
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TransportadoraPU", configOverrides);
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        // Criação de um Cliente
        Cliente cliente = new Cliente();
        cliente.setNome("João da Silva");
        cliente.setEmail("joao.silva@example.com");
        em.persist(cliente);

        // Criação de um Motorista
        Motorista motorista = new Motorista();
        motorista.setNome("Carlos Souza");
        motorista.setEmail("carlos.souza@example.com");
        em.persist(motorista);

        // Criação de um Veículo
        Veiculo veiculo = new Veiculo();
        veiculo.setPlaca("ABC-1234");
        veiculo.setModelo("Caminhão Ford");
        veiculo.setMotorista(motorista);
        em.persist(veiculo);

        // Criação de uma Entrega
        Entrega entrega = new Entrega();
        entrega.setDataEntrega(LocalDate.now());
        entrega.setCliente(cliente);
        entrega.setVeiculo(veiculo);
        entrega.setMotorista(motorista);  // Define o motorista na entrega
        em.persist(entrega);

        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}

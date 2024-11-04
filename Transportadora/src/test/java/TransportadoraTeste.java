/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User PC
 */
import com.mycompany.transportadora.modelo.Cliente;
import com.mycompany.transportadora.modelo.Motorista;
import com.mycompany.transportadora.modelo.Veiculo;
import com.mycompany.transportadora.modelo.Entrega;
import java.time.LocalDate;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.jupiter.api.*;

public class TransportadoraTeste {
    private static EntityManagerFactory emf;
    private EntityManager em;

    @BeforeAll
    public static void setUpClass() {
        emf = Persistence.createEntityManagerFactory("TransportadoraPU");
    }

    @BeforeEach
    public void setUp() {
        em = emf.createEntityManager();
        em.getTransaction().begin();
    }

    @AfterEach
    public void tearDown() {
        if (em.getTransaction().isActive()) {
            em.getTransaction().rollback();
        }
        em.close();
    }

    @AfterAll
    public static void tearDownClass() {
        emf.close();
    }

    @Test
    public void testPersistEntities() {
        // Cliente
        Cliente cliente = new Cliente();
        cliente.setNome("João da Silva");
        cliente.setEmail("joao.silva@example.com");
        em.persist(cliente);

        // Motorista
        Motorista motorista = new Motorista();
        motorista.setNome("Carlos Souza");
        motorista.setEmail("carlos.souza@example.com");
        em.persist(motorista);

        // Veículo
        Veiculo veiculo = new Veiculo();
        veiculo.setPlaca("ABC-1234");
        veiculo.setModelo("Caminhão Ford");
        veiculo.setMotorista(motorista);
        em.persist(veiculo);

        // Entrega
        Entrega entrega = new Entrega();
        entrega.setDataEntrega(LocalDate.now());
        entrega.setCliente(cliente);
        entrega.setVeiculo(veiculo);
        entrega.setMotorista(motorista);
        em.persist(entrega);

        em.getTransaction().commit();
        
        Assertions.assertNotNull(cliente.getId());
        Assertions.assertNotNull(motorista.getId());
        Assertions.assertNotNull(veiculo.getId());
        Assertions.assertNotNull(entrega.getId());
    }
}

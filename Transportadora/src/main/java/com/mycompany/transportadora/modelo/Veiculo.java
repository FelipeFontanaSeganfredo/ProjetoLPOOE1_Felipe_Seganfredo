/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.transportadora.modelo;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tb_veiculo")
public class Veiculo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, nullable = false)
    private String placa;

    @Column(length = 50, nullable = false)
    private String modelo;

    @ManyToOne
    @JoinColumn(name = "motorista_id", nullable = false)
    private Motorista motorista;

    @OneToMany(mappedBy = "veiculo", cascade = CascadeType.ALL)
    private List<Entrega> entregas;

    public Long getId() {
        return id;
    }

    public String getPlaca() {
        return placa;
    }

    public String getModelo() {
        return modelo;
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public List<Entrega> getEntregas() {
        return entregas;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
    }

    public void setEntregas(List<Entrega> entregas) {
        this.entregas = entregas;
    }

}



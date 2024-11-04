/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.transportadora.modelo;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tb_motorista")
public class Motorista extends Pessoa {
    
    @OneToMany(mappedBy = "motorista", cascade = CascadeType.ALL)
    private List<Veiculo> veiculos;

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(List<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }

    
}


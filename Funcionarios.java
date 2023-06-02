package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "funcionario")
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    private String dataNascimento;
    private String telefone;
    private String endereco;
    private double salario;

    // getters e setters

    // construtores

    // toString
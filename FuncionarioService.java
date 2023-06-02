package com.example.demo.service;

import com.example.demo.model.Funcionario;

public interface FuncionarioService {
    Funcionario cadastrarFuncionario(Funcionario funcionario);
    Funcionario calcularNovoSalario(String cpf);
}
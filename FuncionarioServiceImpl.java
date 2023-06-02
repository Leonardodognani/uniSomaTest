package com.example.demo.service;

import com.example.demo.dto.FuncionarioDTO;
import com.example.demo.model.Funcionario;
import com.example.demo.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {
    private static final double REAJUSTE_15 = 0.15;
    private static final double REAJUSTE_12 = 0.12;
    private static final double REAJUSTE_10 = 0.10;
    private static final double REAJUSTE_7 = 0.07;
    private static final double REAJUSTE_4 = 0.04;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Override
    public Funcionario cadastrarFuncionario(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    @Override
    public Funcionario calcularNovoSalario(String cpf) {
        Funcionario funcionario = funcionarioRepository.findByCpf(cpf);
        if (funcionario != null) {
            double salarioAtual = funcionario.getSalario();
            double novoSalario;
            double valorReajuste;
            double percentualReajuste;

            if (salarioAtual <= 400.00) {
                percentualReajuste = REAJUSTE_15;
            } else if (salarioAtual <= 800.00) {
                percentualReajuste = REAJUSTE_12;
            } else if (salarioAtual <= 1200.00) {
                percentualReajuste = REAJUSTE_10;
            } else if (salarioAtual <= 2000.00) {
                percentualReajuste = REAJUSTE_7;
            } else {
                percentualReajuste = REAJUSTE_4;
            }

            valorReajuste = salarioAtual * percentualReajuste;
            novoSalario = salarioAtual + valorReajuste;

            funcionario.setSalario(novoSalario);
            funcionarioRepository.save(funcionario);

            return funcionario;
        }
        return null;
    }
}
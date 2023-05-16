package br.com.helpdesk.services;

import br.com.helpdesk.domain.Chamado;
import br.com.helpdesk.domain.Cliente;
import br.com.helpdesk.domain.Tecnico;
import br.com.helpdesk.domain.enums.Perfil;
import br.com.helpdesk.domain.enums.Prioridade;
import br.com.helpdesk.domain.enums.Status;
import br.com.helpdesk.repositories.ChamadoRepository;
import br.com.helpdesk.repositories.ClienteRepository;
import br.com.helpdesk.repositories.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private TecnicoRepository tecnicoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ChamadoRepository chamadoRepository;


    public void instanciaDB() {
        Tecnico tec1 = new Tecnico(null, "William Filho", "90790324334", "williamfilho20@gmail.com", "123");
        tec1.addPerfil(Perfil.ADMIN);

        Tecnico tec2 = new Tecnico(null, "Patricia Franco Sousa", "89529588372", "patricia@gmail.com", "123");

        Cliente cli1 = new Cliente(null, "Bill Gates", "25463515670", "bill@gmail.com", "123");

        Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 1", "Primeiro chamado", tec1, cli1);

        Chamado c2 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 2", "segundo chamado", tec2, cli1);

        tecnicoRepository.saveAll(Arrays.asList(tec1, tec2));
        clienteRepository.saveAll(Arrays.asList(cli1));
        chamadoRepository.saveAll(Arrays.asList(c1, c2));



    }
}

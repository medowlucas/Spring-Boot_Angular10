package br.com.lucasviasoft.projetolucas.service;

import br.com.lucasviasoft.projetolucas.model.*;
import br.com.lucasviasoft.projetolucas.repository.EstadoRepository;
import br.com.lucasviasoft.projetolucas.repository.ServicoEstadoRepository;
import br.com.lucasviasoft.projetolucas.repository.ServicoRepository;
import br.com.lucasviasoft.projetolucas.repository.StatusServicoEstadoRepository;
import lombok.extern.java.Log;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@Log
public class VerificarDisponibilidadeNfeFazenda {

    @Autowired
    private EstadoRepository salvarEstado;
    private ServicoRepository salvarServico;
    private ServicoEstadoRepository salvarServicoEstado;
    private StatusServicoEstadoRepository salvarStatusServicoEstado;

    @Scheduled(cron="0 0/5 * 1/1 * ?")
    public void checkReceitaStatus(){
        try {
            String receitaUrl = "http://www.nfe.fazenda.gov.br/portal/disponibilidade.aspx";
            Document resposta = Jsoup.connect(receitaUrl).get();
            Elements tabela = resposta.select("tbody");
            if (tabela.size() > 1) {
                Elements rows = tabela.get(1).select("tr");
                for (int i = 1; i < rows.size(); i++) {
                    Elements values = rows.get(i).select("td");
                    String autorizadoresReceita = values.get(0).text().replaceAll("[^a-z A-Z]","");
                    Estado estado = new Estado(autorizadoresReceita);
                    List<ServicoEstado> servicoEstadoList = new ArrayList<ServicoEstado>();

                    Servico servico1 = new Servico(ServicosEnum.SERVICO1);
                    Servico servico2 = new Servico(ServicosEnum.SERVICO2);
                    Servico servico3 = new Servico(ServicosEnum.SERVICO3);
                    Servico servico4 = new Servico(ServicosEnum.SERVICO4);
                    Servico servico5 = new Servico(ServicosEnum.SERVICO5);
                    Servico servico6 = new Servico(ServicosEnum.SERVICO6);
                    Servico servico7 = new Servico(ServicosEnum.SERVICO7);

                    ServicoEstado servicoEstado1 = new ServicoEstado(estado.getId(),servico1.getId(),
                            (values.get(1).text()));
                    ServicoEstado servicoEstado2 = new ServicoEstado(estado.getId(),servico2.getId(),
                            (values.get(2).text()));
                    ServicoEstado servicoEstado3 = new ServicoEstado(estado.getId(),servico3.getId(),
                            (values.get(3).text()));
                    ServicoEstado servicoEstado4 = new ServicoEstado(estado.getId(),servico4.getId(),
                            (values.get(4).text()));
                    ServicoEstado servicoEstado5 = new ServicoEstado(estado.getId(),servico5.getId(),
                            (values.get(5).text()));
                    ServicoEstado servicoEstado6 = new ServicoEstado(estado.getId(),servico6.getId(),
                            (values.get(7).text()));
                    ServicoEstado servicoEstado7 = new ServicoEstado(estado.getId(),servico7.getId(),
                            (values.get(8).text()));

                    StatusServicoEstado statusServicoEstado1 = new StatusServicoEstado(servicoEstado1.getId(),
                            (servicoEstado1.getStatus()));
                    StatusServicoEstado statusServicoEstado2 = new StatusServicoEstado(servicoEstado2.getId(),
                            (servicoEstado2.getStatus()));
                    StatusServicoEstado statusServicoEstado3 = new StatusServicoEstado(servicoEstado3.getId(),
                            (servicoEstado3.getStatus()));
                    StatusServicoEstado statusServicoEstado4 = new StatusServicoEstado(servicoEstado4.getId(),
                            (servicoEstado4.getStatus()));
                    StatusServicoEstado statusServicoEstado5 = new StatusServicoEstado(servicoEstado5.getId(),
                            (servicoEstado5.getStatus()));
                    StatusServicoEstado statusServicoEstado6 = new StatusServicoEstado(servicoEstado6.getId(),
                            (servicoEstado6.getStatus()));
                    StatusServicoEstado statusServicoEstado7 = new StatusServicoEstado(servicoEstado7.getId(),
                            (servicoEstado7.getStatus()));

                    servicoEstadoList.add(servicoEstado1);
                    servicoEstadoList.add(servicoEstado2);
                    servicoEstadoList.add(servicoEstado3);
                    servicoEstadoList.add(servicoEstado4);
                    servicoEstadoList.add(servicoEstado5);
                    servicoEstadoList.add(servicoEstado6);
                    servicoEstadoList.add(servicoEstado7);

                    System.out.println(estado);
                    estado.setServicosEstados(servicoEstadoList);
                    System.out.println(estado);

                    servico1.setServicosEstados(servicoEstadoList);
                    servico2.setServicosEstados(servicoEstadoList);
                    servico3.setServicosEstados(servicoEstadoList);
                    servico4.setServicosEstados(servicoEstadoList);
                    servico5.setServicosEstados(servicoEstadoList);
                    servico6.setServicosEstados(servicoEstadoList);
                    servico7.setServicosEstados(servicoEstadoList);

                    salvarEstado.save(estado);
                    salvarServico.save(servico1);
                    salvarServico.save(servico2);
                    salvarServico.save(servico3);
                    salvarServico.save(servico4);
                    salvarServico.save(servico5);
                    salvarServico.save(servico6);
                    salvarServico.save(servico7);
                    salvarServicoEstado.save(servicoEstado1);
                    salvarServicoEstado.save(servicoEstado2);
                    salvarServicoEstado.save(servicoEstado3);
                    salvarServicoEstado.save(servicoEstado4);
                    salvarServicoEstado.save(servicoEstado5);
                    salvarServicoEstado.save(servicoEstado6);
                    salvarServicoEstado.save(servicoEstado7);
                    salvarStatusServicoEstado.save(statusServicoEstado1);
                    salvarStatusServicoEstado.save(statusServicoEstado2);
                    salvarStatusServicoEstado.save(statusServicoEstado3);
                    salvarStatusServicoEstado.save(statusServicoEstado4);
                    salvarStatusServicoEstado.save(statusServicoEstado5);
                    salvarStatusServicoEstado.save(statusServicoEstado6);
                    salvarStatusServicoEstado.save(statusServicoEstado7);

                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public EstadoRepository getSalvarEstado() {
        return salvarEstado;
    }

    public void salvarEstado(Estado estado) {
        this.salvarEstado.save(estado);
    }

    public ServicoRepository getSalvarServico() {
        return salvarServico;
    }

    public void setSalvarServico(ServicoRepository salvarServico) {
        this.salvarServico = salvarServico;
    }

    public ServicoEstadoRepository getSalvarServicoEstado() {
        return salvarServicoEstado;
    }

    public void setSalvarServicoEstado(ServicoEstadoRepository salvarServicoEstado) {
        this.salvarServicoEstado = salvarServicoEstado;
    }

    public StatusServicoEstadoRepository getSalvarStatusServicoEstado() {
        return salvarStatusServicoEstado;
    }

    public void setSalvarStatusServicoEstado(StatusServicoEstadoRepository salvarStatusServicoEstado) {
        this.salvarStatusServicoEstado = salvarStatusServicoEstado;
    }
}

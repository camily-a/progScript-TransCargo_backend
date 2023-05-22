package org.fatec.service;

import org.fatec.exception.CaminhaoNaoEncontradoException;
import lombok.extern.slf4j.Slf4j;
import org.fatec.model.Caminhao;
import org.fatec.repository.CaminhaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CaminhaoService {

    private final CaminhaoRepository caminhaoRepository;

    public CaminhaoService(CaminhaoRepository CaminhaoRepository) {
        this.caminhaoRepository = CaminhaoRepository;
    }

    public List<Caminhao> listarCaminhoes() {
        return caminhaoRepository.findAll();
    }

    public Caminhao buscarCaminhaoPorPlaca(String placa) {
        log.info("Buscando Caminhao com placa {}", placa);
        return this.caminhaoRepository.findByPlaca(placa).orElseThrow(CaminhaoNaoEncontradoException::new);
    }

    public Caminhao salvarCaminhao(Caminhao caminhao) {
        Caminhao caminhaoSalvo = caminhaoRepository.save(caminhao);
        log.info("Caminhão " + caminhaoSalvo.getPlaca() + " salvo com sucesso");
        return caminhaoSalvo;
    }

    public Caminhao atualizarCaminhao(String placa, Caminhao caminhao) {
        Caminhao caminhaoBd = buscarCaminhaoPorPlaca(placa);
        caminhaoBd.setModelo(caminhao.getModelo());
        caminhaoBd.setAnoFabricacao(caminhao.getAnoFabricacao());
        caminhaoBd.setAltura(caminhao.getAltura());
        caminhaoBd.setCargaMaxima(caminhao.getCargaMaxima());
        caminhaoBd.setQtdEixos(caminhao.getQtdEixos());
        caminhaoBd.setTipoCarroceria(caminhao.getTipoCarroceria());

        Caminhao CaminhaoSalvo = caminhaoRepository.save(caminhaoBd);
        log.info("Caminhão " + CaminhaoSalvo.getPlaca() + " atualizado com sucesso");
        return CaminhaoSalvo;
    }

    public void deletarCaminhao(String placa) {
        Caminhao CaminhaoBd = this.buscarCaminhaoPorPlaca(placa);
        this.caminhaoRepository.delete(CaminhaoBd);
        log.info("Caminhão " + CaminhaoBd.getPlaca() + " deletado com sucesso");
    }
}

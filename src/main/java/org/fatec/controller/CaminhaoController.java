package org.fatec.controller;

import org.fatec.model.Caminhao;
import org.fatec.service.CaminhaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/caminhoes")
public class CaminhaoController {

    @Autowired
    private CaminhaoService caminhaoService;
    
    @GetMapping
    public List<Caminhao> listarCaminhoes() {
        return caminhaoService.listarCaminhoes();
    }

    @GetMapping("/{placa}")
    public ResponseEntity buscarCaminhaoPorPlaca(@PathVariable("placa") String placa) {
        Caminhao caminhao = caminhaoService.buscarCaminhaoPorPlaca(placa);
        return new ResponseEntity(caminhao, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity salvarCaminhao(@Valid @RequestBody Caminhao caminhao){
        caminhaoService.salvarCaminhao(caminhao);
        return new ResponseEntity("Caminhão salvo com sucesso!", HttpStatus.CREATED);
    }

    @PutMapping("/{placa}")
    public ResponseEntity atualizarCaminhao(@PathVariable("placa") String placa, @Valid @RequestBody Caminhao caminhao){
        caminhaoService.atualizarCaminhao(placa, caminhao);
        return new ResponseEntity("Caminhão atualizado com sucesso", HttpStatus.OK);
    }

    @DeleteMapping("{placa}")
    public ResponseEntity deletarCaminhao(@PathVariable("placa") String placa){
        caminhaoService.deletarCaminhao(placa);
        return ResponseEntity.ok("Caminhão deletado com sucesso.");
    }
}

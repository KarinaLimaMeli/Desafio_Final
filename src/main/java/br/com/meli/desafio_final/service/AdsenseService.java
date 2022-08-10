package br.com.meli.desafio_final.service;

import br.com.meli.desafio_final.dto.AdsenseDto;
import br.com.meli.desafio_final.dto.AdsenseIdDto;
import br.com.meli.desafio_final.dto.BatchDto;
import br.com.meli.desafio_final.exception.NotFound;
import br.com.meli.desafio_final.model.entity.Adsense;
import br.com.meli.desafio_final.model.entity.Batch;
import br.com.meli.desafio_final.model.enums.Category;
import br.com.meli.desafio_final.repository.AdsenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdsenseService implements IAdsenseService {

    @Autowired
    private AdsenseRepository repository;

    @Autowired
    private BatchService batchService;

    @Override
    public Adsense findById(long id) {
        return repository.findById(id)
                .orElseThrow(() -> { throw new NotFound("Anúncio não cadastrado."); } );
    }

    @Override
    public List<Adsense> findAll() {
        List<Adsense> adsenses = repository.findAll();
        if (adsenses.size() == 0) throw new NotFound("💢 Lista de anúncios não encontrada");
        return adsenses;
    }

    @Override
    public List<Adsense> findByCategory(Category category) {
        return findAll().stream().filter(a -> a.getProduct().getCategory().equals(category))
                .collect(Collectors.toList());
    }

    @Override
    public List<AdsenseIdDto> findByProductId(Long productId) {
        List<Adsense> adsenseList = findAll().stream().filter(a -> a.getProduct().getId().equals(productId))
                .collect(Collectors.toList());
        return AdsenseIdDto.convertDto(adsenseList);
    }
}

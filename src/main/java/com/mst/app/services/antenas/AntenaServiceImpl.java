package com.mst.app.services.antenas;

import com.mst.app.mappers.AntenaMapper;
import com.mst.app.models.AntenaDTO;
import com.mst.app.persistence.AntenaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AntenaServiceImpl implements AntenaService{
    @Autowired
    private AntenaRepository antenaRepository;

    @Autowired
    private AntenaMapper antenaMapper;

    @Override
    @Transactional(readOnly = true)
    public List<AntenaDTO> findAll() {
        return antenaRepository.findAll().stream().map(antena -> antenaMapper.antenaEntityToAntenaModel(antena)).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<AntenaDTO> findById(Long id) {
        return antenaRepository.findById(id)
                .map(antena -> Optional.of(antenaMapper.antenaEntityToAntenaModel(antena)))
                .orElse(Optional.empty());
    }

    @Override
    @Transactional
    public AntenaDTO save(AntenaDTO antena) {
        return antenaMapper.antenaEntityToAntenaModel(antenaRepository.save(antenaMapper.antenaModelToAntenaEntity(antena)));
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        antenaRepository.deleteById(id);
    }
}

package com.dev.backend.service;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.backend.entity.State;
import com.dev.backend.repository.StateRepository;

@Service
public class StateService {

    @Autowired
    private StateRepository stateRepository;

    public List<State> findAll() {
        return stateRepository.findAll();
    }

    public State findById(Long id) {
        return stateRepository.findById(id).get();
    }

    public State insert(State state) {
        state.setCreationDate(new Date());
        State newState = stateRepository.saveAndFlush(state);
        return newState;
    }

    public State update(State state) {
        state.setUpdateDate(new Date());
        return stateRepository.saveAndFlush(state);
    }

    public void delete(Long id) {
        State state = stateRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("State not found."));
        stateRepository.delete(state);

    }

}

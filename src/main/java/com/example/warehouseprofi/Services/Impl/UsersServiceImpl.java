package com.example.warehouseprofi.Services.Impl;

import com.example.warehouseprofi.Controllers.Exception.UsersConflictException;
import com.example.warehouseprofi.Controllers.Exception.UsersNotFoundException;
import com.example.warehouseprofi.Dtos.UsersDto;
import com.example.warehouseprofi.Repositories.UsersRepository;
import com.example.warehouseprofi.Services.UsersService;
import com.example.warehouseprofi.models.Users;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    UsersRepository usersRepository;

    @Autowired
    private ModelMapper modelMapper;

    public UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public UsersDto register(UsersDto users) {
        Users u = modelMapper.map(users, Users.class);
        if (u.getId() == null || u.getId() == 0 || get(u.getId()).isEmpty()) {
            return modelMapper.map(usersRepository.save(u), UsersDto.class);
        } else {
            throw new UsersConflictException("Пользователи с такими идентификаторами уже существуют");
        }
    }

    @Override
    public List<UsersDto> getAll() {
        return usersRepository.findAll().stream().map((s) -> modelMapper.map(s, UsersDto.class)).collect(Collectors.toList());
    }

    @Override
    public Optional<UsersDto> get(Long id) {
        return Optional.ofNullable(modelMapper.map(usersRepository.findById(id), UsersDto.class));
    }

    @Override
    public void delete(Long id) {
        if (usersRepository.findById(id).isPresent()) {
            usersRepository.deleteById(id);
        } else {
            throw new UsersNotFoundException(id);
        }
    }

    @Override
    public UsersDto update(UsersDto users) {
        if (usersRepository.findById(users.getId()).isPresent()) {
            return modelMapper.map(usersRepository.save(modelMapper.map(users, Users.class)), UsersDto.class);
        } else {
            throw new UsersNotFoundException(users.getId());
        }
    }
}
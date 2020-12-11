package com.casestudy.case4.service.type_room;

import com.casestudy.case4.model.TypeRoom;
import com.casestudy.case4.repository.type_room.ITypeRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class TypeRoomServiceIPL implements ITypeRoomService{
    @Autowired
    private ITypeRoomRepository iTypeRoomRepository;

    @Override
    public Iterable<TypeRoom> findAll() {
        return iTypeRoomRepository.findAll();
    }

    @Override
    public TypeRoom save(TypeRoom typeRoom) {
        return iTypeRoomRepository.save(typeRoom);
    }

    @Override
    public Optional<TypeRoom> findById(Long id) {
        return iTypeRoomRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        iTypeRoomRepository.deleteById(id);
    }
}

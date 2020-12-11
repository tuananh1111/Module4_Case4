package com.casestudy.case4.repository.type_room;

import com.casestudy.case4.model.TypeRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITypeRoomRepository extends JpaRepository<TypeRoom, Long> {

}

package com.web.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.web.entity.Sdfc_Banking;
@Repository
public interface SdfcRepo extends CrudRepository<Sdfc_Banking, Long> {

}

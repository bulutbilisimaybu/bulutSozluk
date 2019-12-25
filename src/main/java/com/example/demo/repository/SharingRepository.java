package com.example.demo.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Sharing;
@Repository
public interface SharingRepository  extends JpaRepository<Sharing,Long>
{
	ArrayList<Sharing> findTop10ByTitleIgnoreCaseContaining(String title);
}

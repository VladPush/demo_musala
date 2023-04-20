package com.example.musala.repository;

import com.example.musala.entity.goods.Goods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface GoodsRepository extends JpaRepository<Goods, Long> {
}

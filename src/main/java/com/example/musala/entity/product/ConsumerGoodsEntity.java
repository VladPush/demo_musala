package com.example.musala.entity.product;


import com.example.musala.entity.product.core.Product;
import com.example.musala.entity.product.core.ProductType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
@Entity(name = "consumer_goods")
@DiscriminatorValue(value = ProductType.Values.CONSUMER_GOODS)
public final class ConsumerGoodsEntity extends Product {

    private String tradeMark;
}
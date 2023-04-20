package com.example.musala.entity.goods;


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
@Entity(name = "consumer_product")
@DiscriminatorValue(value = GoodsType.Values.CONSUMER_GOODS)
public final class ConsumerProductEntity extends Goods {

    private String tradeMark;
}
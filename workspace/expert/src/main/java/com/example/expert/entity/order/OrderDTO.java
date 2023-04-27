package com.example.expert.entity.order;

import lombok.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Getter @Setter @ToString
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class OrderDTO {
    @EqualsAndHashCode.Include
    private Long id;
    private String orderName;
    private List<Member> members;
}

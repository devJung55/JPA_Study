package com.example.expert.repository.order;

import com.example.expert.entity.order.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

}

package com.hendisantika.jwtexample.config

import com.hendisantika.jwtexample.model.Member
import com.hendisantika.jwtexample.repository.MemberRepository
import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.crypto.password.PasswordEncoder

@Configuration
class MemberConfiguration {
    @Bean
    fun initMembers(memberRepository: MemberRepository, passwordEncoder: PasswordEncoder) = ApplicationRunner {
        memberRepository.saveAll(
            listOf(
                Member("naruto", passwordEncoder.encode("123456"), "Uzumaki Naruto", listOf("ROLE_ADMIN", "ROLE_USER")),
                Member("sasuke", passwordEncoder.encode("123456"), "Uchiha Sasuke", listOf("ROLE_USER")),
                Member("sakura", "123456", "Haruno Sakura", listOf("ROLE_USER"))
            )
        )
    }
}
